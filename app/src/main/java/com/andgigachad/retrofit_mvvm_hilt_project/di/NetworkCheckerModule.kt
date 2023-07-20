package com.andgigachad.retrofit_mvvm_hilt_project.di

import android.content.Context
import com.andgigachad.retrofit_mvvm_hilt_project.data.internet.NetworkChecker
import com.andgigachad.retrofit_mvvm_hilt_project.data.internet.NetworkCheckerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkCheckerModule {

    @Provides
    fun providesNetworkChecker(@ApplicationContext context: Context) : NetworkChecker {
        return NetworkCheckerImpl(
            context = context
        )
    }
}