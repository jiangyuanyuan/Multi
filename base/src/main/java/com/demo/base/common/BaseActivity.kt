package com.demo.base.common

import android.os.Bundle
import me.yokeyword.fragmentation.SupportActivity
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator


open class BaseActivity : SupportActivity()  {

    //权限
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentAnimator = DefaultHorizontalAnimator() //横向动画
//        fragmentAnimator = DefaultVerticalAnimator() //竖向动画
//        fragmentAnimator = DefaultNoAnimator() //没有动画
//        initLocaleLanguage()
    }

//    private fun initLocaleLanguage() {
//        val resources = this.getResources()
//        val configuration = resources.getConfiguration()
//        configuration.locale = Hawk.get(LANGUAGE_, Locale.getDefault())
//        resources.updateConfiguration(configuration, resources.displayMetrics)//更新配置
//    }


}