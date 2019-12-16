package com.demo.user.di


import com.demo.user.data.UserApi
import com.demo.user.data.UserApiViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val userModule = module {

    single { get<Retrofit>().create(UserApi::class.java) }

    viewModel { UserApiViewModel(get()) }
}