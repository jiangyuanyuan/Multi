package com.demo.base.data

import com.demo.base.net.Rep
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET

interface Api {


    /**
     * 上传文件。
     */
    @GET("api/s/upload/callback")
    fun upload(@Body req: HashMap<String,Any>): Single<Rep<Boolean>>

}