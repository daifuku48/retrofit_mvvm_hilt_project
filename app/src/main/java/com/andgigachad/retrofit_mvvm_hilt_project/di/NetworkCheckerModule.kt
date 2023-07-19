package com.andgigachad.retrofit_mvvm_hilt_project.di

import com.andgigachad.retrofit_mvvm_hilt_project.data.internet.NetworkChecker
import com.andgigachad.retrofit_mvvm_hilt_project.data.internet.NetworkCheckerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkCheckerModule {
    @Binds
    abstract fun bindNetworkChecker(networkCheckerImpl: NetworkCheckerImpl): NetworkChecker
}