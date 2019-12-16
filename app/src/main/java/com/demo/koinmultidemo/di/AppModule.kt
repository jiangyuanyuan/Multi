package com.demo.koinmultidemo.di


import com.demo.base.API_BASE_URL

import com.demo.base.data.ApiViewModel
import com.demo.base.net.okhttp
import com.demo.base.net.retrofit
import com.demo.koinmultidemo.App
import com.demo.koinmultidemo.data.HomeApi
import okhttp3.Call
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {

    single<Call.Factory> { okhttp( App.instance()) }

    single { retrofit(get(),API_BASE_URL) }

    single { get<Retrofit>().create(HomeApi::class.java) }

    viewModel { ApiViewModel(get()) }
}