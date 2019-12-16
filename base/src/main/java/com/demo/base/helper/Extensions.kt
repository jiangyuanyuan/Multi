package com.demo.base.helper

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.exceptions.OnErrorNotImplementedException
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit

private val onNextStub: (Any) -> Unit = {}
private val onErrorStub: (Throwable) -> Unit =
    { RxJavaPlugins.onError(OnErrorNotImplementedException(it)) }
private val onCompleteStub: () -> Unit = {}


fun <T> applyWidgetSchedulers(windowDuration: Long = 1L): ObservableTransformer<T, T> {
    return ObservableTransformer {
        it.throttleFirst(windowDuration, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> applyWidgetSchedulersForMilliSeconds(windowDuration: Long = 1L): ObservableTransformer<T, T> {
    return ObservableTransformer {
        it.throttleFirst(windowDuration, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> applySchedulers(): ObservableTransformer<T, T> {
    return ObservableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> applySchedulersOnFlowable(): FlowableTransformer<T, T> {
    return FlowableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> applySchedulersOnSingle(): SingleTransformer<T, T> {
    return SingleTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
