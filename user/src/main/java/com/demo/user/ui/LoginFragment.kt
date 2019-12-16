package com.demo.user.ui

import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.demo.router.LOGIN_SUCCESS
import com.demo.user.R
import com.demo.user.common.UserBaseFragment
import com.demo.router.RouterPath
import com.jeremyliao.liveeventbus.LiveEventBus
import kotlinx.android.synthetic.main.fragment_login.*
import org.jetbrains.anko.toast


@Route(path = RouterPath.User.PATH_LOGIN)
class LoginFragment : UserBaseFragment() {
    override fun getLayoutId() = R.layout.fragment_login

    override fun initView() {

    }

    override fun initData() {

    }

    override fun initEvent() {
        mLogin?.setOnClickListener {
            mApiViewModel?.login(mUserName?.text?.toString()?:"",mPwd?.text?.toString()?:"")?.observe(this,
                Observer {
                    if (it!=null){
                        _mActivity.toast(it.token)//登录成功
                        LiveEventBus.get(LOGIN_SUCCESS).post(it)//发送登录成功事件
                    }
                })
        }
    }
}