package com.andgigachad.retrofit_mvvm_hilt_project

import com.andgigachad.retrofit_mvvm_hilt_project.app.App
import com.andgigachad.retrofit_mvvm_hilt_project.network.RetrofitService
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertNotNull
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@HiltAndroidTest
class DITest {
    @get:Rule val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var app: App

    @Inject
    lateinit var retrofitService: RetrofitService

    @Test
    fun injectApp(){
        hiltRule.inject()
        assertNotNull(app)
    }


    @Test
    fun injectRetrofitService(){
        hiltRule.inject()
        assertNotNull(retrofitService)
    }
}