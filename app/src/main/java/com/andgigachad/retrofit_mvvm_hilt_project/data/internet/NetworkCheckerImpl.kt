package com.andgigachad.retrofit_mvvm_hilt_project.data.internet

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NetworkCheckerImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : NetworkChecker{

    // Сохраняем текущее состояние подключения
    private var isNetworkAvailable: Boolean = false

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {

        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            isNetworkAvailable = true
        }

        //Lost connection
        override fun onLost(network: Network) {
            super.onLost(network)
            isNetworkAvailable = false
        }
    }

    override suspend fun isNetworkAvailable(): Boolean {

        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()
        val connectivityManager = context.getSystemService(ConnectivityManager::class.java)

        // Register call to network
        connectivityManager?.registerNetworkCallback(networkRequest, networkCallback)

        return isNetworkAvailable
    }

}