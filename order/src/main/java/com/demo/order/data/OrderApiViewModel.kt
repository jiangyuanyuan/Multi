package com.demo.order.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.demo.base.helper.SingleLiveEvent
import com.demo.base.helper.applySchedulersOnSingle
import com.demo.base.net.DataObserver

class OrderApiViewModel(private val orderApi: OrderApi) : ViewModel() {
    private val ordersResult = SingleLiveEvent<Orders>()
    fun getOrders(
        userId: String = ""
    ): LiveData<Orders> {

        orderApi.getOrders(userId).compose(applySchedulersOnSingle()).subscribe(DataObserver(ordersResult))
        return ordersResult
    }

}