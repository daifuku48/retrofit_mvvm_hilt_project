package com.andgigachad.retrofit_mvvm_hilt_project.data.internet

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

interface NetworkChecker {
    suspend fun isNetworkAvailable() : Boolean
}