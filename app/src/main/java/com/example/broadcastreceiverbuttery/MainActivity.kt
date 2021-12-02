package com.example.broadcastreceiverbuttery

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    lateinit var myBatteryReceiver: MyReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  battery = findViewById<AppCompatTextView>(R.id.battery_state)

        myBatteryReceiver = MyReceiver(battery)

        registerReceiver(myBatteryReceiver , IntentFilter(Intent.ACTION_BATTERY_CHANGED))


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBatteryReceiver)
    }
}