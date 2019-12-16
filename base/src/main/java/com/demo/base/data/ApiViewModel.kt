package com.demo.base.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.demo.base.helper.SingleLiveEvent
import com.demo.base.helper.applySchedulersOnSingle
import com.demo.base.net.DataObserver

/**
 * 当很多个模块   用到同一个接口时  可以将接口定义在base中  通过BaseFragment中的mBaseApiViewModel调用接口
 */
class ApiViewModel(private val api: Api) : ViewModel() {


    val uploadResult = SingleLiveEvent<Boolean>()




    /**
     * 上传文件。
     */
    fun upload(): LiveData<Boolean> {
        // Use OKHTTP3 upload files.
        return uploadResult
    }

}
