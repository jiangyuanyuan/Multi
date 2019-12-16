package com.demo.user

import com.alibaba.android.arouter.facade.annotation.Route
import com.demo.base.common.BaseFragment
import com.demo.router.JumpUtils
import com.demo.router.RouterPath



@Route(path = RouterPath.User.PATH_TEST)
class TestFragment : BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_test

    override fun initView() {
        loadRootFragment(R.id.mMain, JumpUtils.BuildFragment(RouterPath.User.PATH_LOGIN))
    }

    override fun initData() {

    }

    override fun initEvent() {

    }
}