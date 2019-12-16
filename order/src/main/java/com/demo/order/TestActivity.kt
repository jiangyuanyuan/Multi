package com.demo.order

import android.os.Bundle
import com.demo.base.common.BaseActivity
import com.demo.router.JumpUtils
import com.demo.router.RouterPath



class TestActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        loadRootFragment(R.id.test_main, JumpUtils.BuildFragment(RouterPath.User.PATH_TEST))
    }
}
