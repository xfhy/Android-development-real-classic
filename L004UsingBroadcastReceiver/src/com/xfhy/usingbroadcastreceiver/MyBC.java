package com.xfhy.usingbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBC extends BroadcastReceiver {

	public final static String ACTION = "com.xfhy.usingbroadcastreceiver.intent.action.MyBC";
	
	//在广播里接收数据
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("tag","onReceive data:"+intent.getStringExtra("txt"));
		
	}

}
