package com.demo.base.data

class UserInfo(//用户信息  是所以模块都可能用到   所以定义在base 中
    val userId:String,
    val userName: String?,
    var email: String?,
    var phoneNo: String?,
    val token:String
)