package com.demo.order.di

import com.demo.order.data.OrderApi
import com.demo.order.data.OrderApiViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val orderModule = module {

    single { get<Retrofit>().create(OrderApi::class.java) }

    viewModel { OrderApiViewModel(get()) }
}