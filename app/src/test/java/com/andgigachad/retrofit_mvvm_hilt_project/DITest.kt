package com.andgigachad.retrofit_mvvm_hilt_project

import com.andgigachad.retrofit_mvvm_hilt_project.network.RetrofitService
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class DITest {

    @JvmField
    @Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var retrofitService: RetrofitService

    @Test
    fun setUp(){
        hiltRule.inject()
        assertNotNull(retrofitService)
    }
}