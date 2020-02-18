package com.example.broadcastexample

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var myContextRegisteredBroadcastReceiver: MyContextRegisteredBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        myContextRegisteredBroadcastReceiver = MyContextRegisteredBroadcastReceiver()
        registerReceiver(myContextRegisteredBroadcastReceiver, IntentFilter(Intent.ACTION_POWER_CONNECTED))
        registerReceiver(myContextRegisteredBroadcastReceiver, IntentFilter(Intent.ACTION_POWER_DISCONNECTED))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(myContextRegisteredBroadcastReceiver)
    }
}
