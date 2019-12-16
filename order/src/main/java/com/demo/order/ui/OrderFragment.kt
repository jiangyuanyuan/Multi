package com.demo.order.ui

import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.demo.base.data.UserInfo
import com.demo.order.R
import com.demo.order.common.OrderBaseFragment
import com.demo.router.LOGIN_SUCCESS

import com.demo.router.RouterPath
import com.jeremyliao.liveeventbus.LiveEventBus
import org.jetbrains.anko.toast

@Route(path = RouterPath.Order.PATH_ORDER)
class OrderFragment : OrderBaseFragment() {
    override fun getLayoutId() = R.layout.fragment_test

    override fun initView() {
        LiveEventBus.get(LOGIN_SUCCESS, UserInfo::class.java)//登录成功的事件监听
            .observe(this, Observer {
                if (it!=null){
                    getOrders(it.userId)
                }
            })
    }

    override fun initData() {

    }

    override fun initEvent() {

    }


    private fun getOrders(userId:String){
        mApiViewModel?.getOrders(userId)?.observe(this, Observer {
            if (it!=null){
                //更新你的UI视图
                _mActivity.toast("Order页面UI数据更新了")
            }
        })
    }
}