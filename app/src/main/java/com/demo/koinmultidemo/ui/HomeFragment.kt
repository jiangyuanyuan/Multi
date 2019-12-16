package com.demo.koinmultidemo.ui

import com.alibaba.android.arouter.facade.annotation.Route
import com.demo.koinmultidemo.R
import com.demo.koinmultidemo.common.HomeBaseFragment
import com.demo.router.RouterPath

@Route(path = RouterPath.Home.PATH_HOME)
class HomeFragment : HomeBaseFragment() {
    override fun getLayoutId() = R.layout.fragment_home

    override fun initView() {

    }

    override fun initData() {

    }

    override fun initEvent() {

    }
}