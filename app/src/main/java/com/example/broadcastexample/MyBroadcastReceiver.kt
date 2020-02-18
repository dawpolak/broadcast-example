package com.example.broadcastexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

private const val TAG = "BroadcastReceiver"

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action)
        {
            //if u have API level 26 or higher, you cannot use the manifest to declare a receiver for most implicit broadcast like the one below
            "android.intent.action.AIRPLANE_MODE"->{
                StringBuilder().apply {
                    append("Action: ${intent.action}\n")
                    append("URI: ${intent.toUri(Intent.URI_INTENT_SCHEME)}\n")
                    toString().also { log ->
                        Log.d(TAG, log)
                        Toast.makeText(context, log, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}