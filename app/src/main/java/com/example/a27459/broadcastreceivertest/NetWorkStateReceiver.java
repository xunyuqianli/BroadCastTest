package com.example.a27459.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by 27459 on 2017/2/6.
 */

public class NetWorkStateReceiver extends BroadcastReceiver {
    private static final String TAG = "NetWorkStateReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!isNetworkAvailable(context) ) {
            Log.e(TAG, "onReceive:网络断开链接 ");
            Toast.makeText(context,"网络断开链接",Toast.LENGTH_SHORT).show();
        }

    }

    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo [] info = mgr.getAllNetworkInfo();
        if (info != null) {
            for (int i = 0; i < info.length; i++) {
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }
}
