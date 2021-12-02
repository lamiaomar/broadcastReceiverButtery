package com.example.broadcastreceiverbuttery

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import androidx.appcompat.widget.AppCompatTextView

class MyReceiver(val textView : AppCompatTextView , val textView1: AppCompatTextView) : BroadcastReceiver() {

    @SuppressLint("SetTextI18n")
    override fun onReceive(context: Context?, intent: Intent?) {


        if (intent!!.action == "android.intent.action.BATTERY_CHANGED"){

            val battryState = intent.getIntExtra(BatteryManager.EXTRA_LEVEL , -1)

            if (battryState in 100 downTo 50 ) textView1.text = "Normal buttery - "
            else if (battryState in 49 downTo 1 ) textView1.text = "low buttery - "
        }


        if (intent.getIntExtra(
                BatteryManager.EXTRA_STATUS, -1
        ) == BatteryManager.BATTERY_STATUS_CHARGING
        ){
            textView.text = "charging"
        }else {
            textView.text = "Not charging"
        }
    }
}