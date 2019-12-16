package com.demo.user.data

import com.demo.base.data.UserInfo
import com.demo.base.net.Rep
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    /**
     * 登录
     */
    @POST("/api/a/login")
    fun login(@Body req: HashMap<String,String>): Single<Rep<UserInfo>>

}