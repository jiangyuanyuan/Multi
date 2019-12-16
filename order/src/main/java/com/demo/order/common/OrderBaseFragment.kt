package com.demo.order.common

import com.demo.base.common.BaseFragment
import com.demo.order.data.OrderApiViewModel
import org.koin.android.viewmodel.ext.android.viewModel

abstract class OrderBaseFragment : BaseFragment() {
    val mApiViewModel: OrderApiViewModel by viewModel()
}