package com.demo.base.net

import androidx.lifecycle.MutableLiveData

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

interface OnFinishedListener<T> {

    fun onSucceed(t: T)

    fun onFailure(throwable: Throwable)
}

/**
 * Base Observer，只对 OnSubscribe() 和 onError() 返回进行处理。
 * 需要子类继承并处理 onSuccess() 才能使用。
 */
abstract class BaseObserver<T> : SingleObserver<T> {

    private var disposable: Disposable? = null

    override fun onSubscribe(d: Disposable) {
        disposable = d

    }

    override fun onSuccess(t: T) {
        // 根据不同的 errCode 进行处理。
    }

    override fun onError(e: Throwable) {

    }
}

/**
 * Data Observer。
 * 只对 Rep<T> 格式的数据有效，可重写 onSucceed() / onFailure() 对处理进行扩展。
 */
open class DataObserver<T>(private val liveData: MutableLiveData<T>) :
    BaseObserver<Rep<T>>(), OnFinishedListener<T> {

    override fun onSuccess(t: Rep<T>) {
        super.onSuccess(t)

        if (t?.isSuccessful()==true) {
            liveData.value = t?.data
            onSucceed(t?.data)
        }else {
            liveData.value=null
        }
    }

    override fun onError(e: Throwable) {
        super.onError(e)
        liveData.value = null
        onFailure(e)
    }

    override fun onSucceed(t: T) {
    }

    override fun onFailure(throwable: Throwable) {
    }
}

/**
 * Data List observer.
 * 对 Rep<Data<T>> 有效，如果需要使用 page 相关的数据（判断是否到页尾），则需要使用 DataObserver。
 */

@Deprecated("not completed")
open class DataListObserver<T>(private val liveData: MutableLiveData<List<T>>) :
    BaseObserver<Rep<Data<T>>>(), OnFinishedListener<T> {

    override fun onSuccess(t: Rep<Data<T>>) {
        super.onSuccess(t)

        if (t.isSuccessful()) {
            liveData.value = t.data.records
        }
    }

    override fun onSucceed(t: T) {
    }

    override fun onFailure(throwable: Throwable) {
    }
}