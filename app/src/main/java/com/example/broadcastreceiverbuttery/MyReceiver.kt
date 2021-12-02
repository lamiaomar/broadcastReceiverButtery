package com.example.broadcastreceiverbuttery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.telephony.TelephonyManager
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView

class MyReceiver(val textView : AppCompatTextView) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
//
//        val batteryLevl = intent?.getIntExtra("level" , 0)
//        textView.text = if (batteryLevl?:0 > 0 ) batteryLevl.toString() else ""
//
//        val extras = intent?.extras
//        extras?.let {
//            val state = it.getString(BatteryManager.EXTRA_BATTERY_LOW)
//
//            Toast.makeText(context , state ,Toast.LENGTH_SHORT).show()
//        }

        if (intent!!.action == "android.intent.action.BATTERY_CHANGED"){

            val battryState = intent.getIntExtra(BatteryManager.EXTRA_LEVEL , -1)

            if (battryState in 100 downTo 50 ) textView.text = "Normal buttery"
            else if (battryState in 69 downTo 30 ) textView.text = "low buttery"
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