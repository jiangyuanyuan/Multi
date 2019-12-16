package com.demo.user.common

import com.demo.base.common.BaseFragment
import com.demo.user.data.UserApiViewModel

import org.koin.android.viewmodel.ext.android.viewModel

abstract class UserBaseFragment : BaseFragment() {
    val mApiViewModel: UserApiViewModel by viewModel()
}