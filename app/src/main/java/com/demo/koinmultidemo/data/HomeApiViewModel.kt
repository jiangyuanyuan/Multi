package com.demo.koinmultidemo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.demo.base.helper.SingleLiveEvent
import com.demo.base.helper.applySchedulersOnSingle


class HomeApiViewModel(private val homeApi: HomeApi) : ViewModel() {

    private val appUpdate = SingleLiveEvent<Any>()


    /**
     *  APP版本更新
     */
    fun appUpdate(requestVersion: Int): LiveData<Any> {
        val req = HashMap<String,Any>()
        req.put("appId", "bemax-android")
        req.put("requestVersion", requestVersion)

//        homeApi.appUpdate(req).compose(applySchedulersOnSingle()).subscribe(DataObserver(appUpdate))
        return appUpdate
    }




}