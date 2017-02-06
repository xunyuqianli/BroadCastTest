package com.example.a27459.broadcastreceivertest;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity" ;
    public static boolean iscreated = false;
    private MyBroadcastReceiver mBroadcastReceiver;
    private SecondBroadcastReceiver secondReceiver;
    private ThirdReceiver thirdreceiver;
    private static final String BROADCAST_ACTION = "com.example.27459.broadcastreceivertest";
    private static final String BROADCAST_ACTION_TWO = "com.example.27459.SecondBroadcastReceiver";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iscreated = true;
        Log.e(TAG, "onCreate: ");
        //注册广播  一个intentfilter对应注册一个 这样可以分开发送广播
        mBroadcastReceiver = new MyBroadcastReceiver();
        secondReceiver = new SecondBroadcastReceiver();
        thirdreceiver = new ThirdReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(BROADCAST_ACTION_TWO);
        registerReceiver(mBroadcastReceiver,intentFilter);
        //2.3广播接收者地址相同
        registerReceiver(secondReceiver,intentFilter2);
        registerReceiver(thirdreceiver,intentFilter2);




    }

    public void startService(View view) {
        this.startService(new Intent(this,MyService.class));
    }

    public void startSecondActivity(View view) {
        this.startActivity(new Intent(this,SecondActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
    }

    public void sendBroadCast(View view) {
        //发送广播
        Intent intent = new Intent();
        intent.setAction(BROADCAST_ACTION_TWO);
        intent.putExtra("name","xunyuqianli");
        sendBroadcast(intent);
    }
}
