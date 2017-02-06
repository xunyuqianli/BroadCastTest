package com.example.a27459.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by 27459 on 2017/2/4.
 */

public class SecondBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "SecondBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = getResultExtras(true).getString("msg");
        Log.e(TAG, "onReceive:第二个广播接收器 "+intent.getStringExtra("name")+msg);
    }
}
