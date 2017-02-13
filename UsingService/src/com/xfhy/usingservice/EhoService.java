package com.xfhy.usingservice;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class EhoService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		Log.i("tag","onBind");
		return echoServiceBinder;   //这里返回空值的话,则不会调用onServiceConnected
	}
	private final EchoServiceBinder echoServiceBinder = new EchoServiceBinder();
	public class EchoServiceBinder  extends Binder
	{
		public EhoService getService(){
			return EhoService.this;
		}
	}
	
	public int getNumber()
	{
		return i;
	}
	
	@Override
	public void onCreate() {
		
		super.onCreate();
		Log.i("tag", "onCreate:Service is start!");
		startTimer();
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("tag", "onDestroy:Service is stop!");
		stopTimer();
	}

	private Timer timer = null;
	private TimerTask timerTask = null;
	private int i=0;
	
	public void startTimer()
	{
		if(timer==null)
    	{
			timer = new Timer();
			timerTask = new TimerTask() {
				
				@Override
				public void run() {
					i++;
					Log.i("tag",i+"");
				}
			};
    		timer.schedule(timerTask, 1000, 1000);
    	}
	}
	
    public void stopTimer()
    {
    	if(timer!=null)
    	{
    		timerTask.cancel();
    		timer.cancel();
    		
    		timerTask = null;
    		timer = null;
    	}
    }
    
	
}
