package com.demo.order.data

import com.demo.base.net.Rep
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface OrderApi {
    /**
     * 登录
     */
    @GET("/login")
    fun getOrders(@Query("userId")userId:String): Single<Rep<Orders>>

}