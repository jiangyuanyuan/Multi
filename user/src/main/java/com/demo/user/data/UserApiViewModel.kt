package com.demo.user.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.demo.base.data.UserInfo
import com.demo.base.helper.SingleLiveEvent
import com.demo.base.helper.applySchedulersOnSingle
import com.demo.base.net.DataObserver

class UserApiViewModel(private val userApi: UserApi) : ViewModel() {
    private val loginResult = SingleLiveEvent<UserInfo>()

    fun login(
        account: String = "", password: String = ""
    ): LiveData<UserInfo> {
        val req = HashMap<String,String>()
        req.put("username", account)
        req.put("password", password)
        userApi.login(req).compose(applySchedulersOnSingle()).subscribe(DataObserver(loginResult))
        return loginResult
    }
}