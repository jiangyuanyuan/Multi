package com.demo.base.net

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

const val COMMON_SUC_CODE = 0 //只有0是成功

data class Rep<T>(
    val errmsg: String,
    val errcode: Int,
    val data: T
) {
    fun isSuccessful() = errcode == COMMON_SUC_CODE
}

data class Data<T>(
    val current: Int,
    val pages: Int,
    val records: List<T>,
    val size: Int,
    val total: Int,
    val searchCount: Boolean
)




