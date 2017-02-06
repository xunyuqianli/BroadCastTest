package com.example.a27459.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by 27459 on 2017/2/4.
 */

public class ThirdReceiver extends BroadcastReceiver {
    private static final String TAG = "ThirdReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive:第三个广播接受者 "+intent.getStringExtra("name") );
        Bundle bundle = new Bundle();
        bundle.putString("msg","第三个接收者发送的消息");
        setResultExtras(bundle);
    }
}
