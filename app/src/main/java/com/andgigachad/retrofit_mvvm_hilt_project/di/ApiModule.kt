package com.andgigachad.retrofit_mvvm_hilt_project.di

import com.andgigachad.retrofit_mvvm_hilt_project.network.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun providesHttpInterceptor() : HttpLoggingInterceptor{
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun providesHttpClient(interceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(RetrofitService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesApiMeals(retrofit: Retrofit) : RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }
}