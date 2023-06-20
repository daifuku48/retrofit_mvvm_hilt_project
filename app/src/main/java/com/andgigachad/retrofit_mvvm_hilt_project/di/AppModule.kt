package com.andgigachad.retrofit_mvvm_hilt_project.di

import android.app.Application
import com.andgigachad.retrofit_mvvm_hilt_project.app.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
object AppModule {
    @Provides
    fun provideApplication(application: Application) : Application{
        return application as App
    }
}