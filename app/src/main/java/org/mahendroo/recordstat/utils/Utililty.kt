package org.mahendroo.recordstat.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import java.util.*

object Utililty {

    val runningQOrLater = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q

    fun getCurrentTimestamp(): Long {
        return Date().time
    }

    fun isNetworkConnected(context: Context): Boolean {
        if (!runningQOrLater) {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
            return isConnected
        }
//        TODO(Handle Q devices)
        return true
    }

    fun showToast() {

    }

}