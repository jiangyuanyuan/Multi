package com.demo.base.di
import com.demo.base.data.Api
import com.demo.base.data.ApiViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val baseModule = module {

    single { get<Retrofit>().create(Api::class.java) }

    viewModel { ApiViewModel(get()) }
}