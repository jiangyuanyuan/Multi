package com.demo.koinmultidemo.common


import com.demo.base.common.BaseFragment
import com.demo.base.data.ApiViewModel


import org.koin.android.viewmodel.ext.android.viewModel


abstract class HomeBaseFragment : BaseFragment() {
    val mApiViewModel: ApiViewModel by viewModel()
}