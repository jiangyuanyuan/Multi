package com.demo.base.net

import android.content.Context
import android.os.Build
import com.demo.base.BuildConfig
import com.google.gson.*

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.SocketTimeoutException
import java.util.*
import java.util.concurrent.TimeUnit


fun retrofit(callFactory: Call.Factory, API_BASE_URL: String) = Retrofit.Builder()
    .callFactory(callFactory)
    .baseUrl(API_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(dateGson))
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

fun okhttp(context: Context) = OkHttpClient.Builder()
    .addInterceptor(OkInterceptor(context))
    .addInterceptor(initLogInterceptor())
    .retryOnConnectionFailure(true)//失败重试一次 比较关键
    .connectTimeout(10, TimeUnit.SECONDS)
    .readTimeout(10, TimeUnit.SECONDS)
    .writeTimeout(10, TimeUnit.SECONDS)
    .build()

private const val CACHE_MAX_AGE = 60 * 60   // one hour
private const val DATE_PATTERN1 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS"
private const val DATE_PATTERN2 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

private val dateGson: Gson
    get() = GsonBuilder()
        .registerTypeAdapter(
            Date::class.java,
            DateDeserializer(DATE_PATTERN1, DATE_PATTERN2)
        )
        .serializeNulls()
        .create()

class OkInterceptor(var context: Context?) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response? {
//        if (context?.isConnected()==false) {
//            extRunOnMainThread {
//                context?.toast("网络连接异常！")
//            }
//        }
        val request = chain.request()
        val builder = request.newBuilder()
            ?.addHeader("Content_Type", "application/json")
            ?.addHeader("charset", "UTF-8")
            ?.addHeader("source-terminal", "Android")     //操作系统名称（注：ios、android）//设备型号
            ?.addHeader("device-model", Build.MODEL)             //设备型号
            ?.addHeader("os-version", Build.VERSION.RELEASE)     //操作系统版本号



        var response: Response? = null
        try {
            response = chain.proceed(builder?.build())
        } catch (e: Exception) {
            if (e is SocketTimeoutException)
                ErrorNotice.INSTANCE.notifyError(1408, e.toString())
        }

        val bytes = response?.body()?.bytes() ?: ""?.toByteArray()
        val build = response?.newBuilder()?.body(ResponseBody.create(MediaType.parse("UTF-8"), bytes))?.build()
        var responseCode = ""
        var responseMsg = ""
        try {
            if (bytes != null) {
                val returnData = JsonParser()?.parse(String(bytes))?.asJsonObject
                responseCode = returnData?.get("errcode")?.asString ?: "10000"
                responseMsg = returnData?.get("errmsg")?.asString ?: "server error"
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            //交给上层显示错误
            if (responseCode?.isNotBlank() && responseCode?.toInt() != COMMON_SUC_CODE) {
                ErrorNotice.INSTANCE.notifyError(responseCode?.toInt(), responseMsg)
            } else {
            }
        }
        return build
    }
}

private fun initLogInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG) {
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    } else {
        interceptor.level = HttpLoggingInterceptor.Level.NONE
    }
    return interceptor
}
