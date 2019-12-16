package com.demo.koinmultidemo

import android.os.Bundle
import com.demo.base.common.BaseActivity
import com.demo.base.net.ErrorNotice
import com.demo.router.JumpUtils
import com.demo.router.RouterPath
import org.jetbrains.anko.toast

/**
 * 整个应用只有这一个Activity
 * 它不会销毁 所以网络错误回调注册在这里
 */
class MainActivity : BaseActivity() , ErrorNotice.ErrorListener{
    override fun onNotify(code: Int, msg: String) {//网络请求错误回调
        when (code){
            40001->{// 这个code   是后台定义的错误code
                toast("token失效")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ErrorNotice.INSTANCE.reg(this)//网络错误注册

        loadRootFragment(R.id.mMainContent, JumpUtils.BuildFragment(RouterPath.Home.PATH_MAIN))//加载根Fragment

    }
}
