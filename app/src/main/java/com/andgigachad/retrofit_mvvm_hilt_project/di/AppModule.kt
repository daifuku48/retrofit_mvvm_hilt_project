package com.andgigachad.retrofit_mvvm_hilt_project.di

import android.content.Context
import com.andgigachad.retrofit_mvvm_hilt_project.app.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideApplication(@ApplicationContext application: Context) : App {
        return application as App
    }
}