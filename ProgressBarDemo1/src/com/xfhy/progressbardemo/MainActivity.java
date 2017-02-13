package com.xfhy.progressbardemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

/*
 * ProgressBar:进度条
 * 
 * ProgressBar的分类:
 * 1.可以精确显示进度(可以显示刻度或者百分比)
 * 2.不可以精确显示进度(一直转啊转,类似于一个过场动画)
 * 
 * android:max="100"                  --最大显示进度
 * android:progress="50"              --第一显示进度
 * android:secondaryProgress="80"     --第二显示进度
 * android:indeterminate="true"       --设置是否精确显示
 * true是不精确显示,false表示不精确显示进度
 * 
 * */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
      //启动窗口特征,启用带进度和不带进度的进度条
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        
        setContentView(R.layout.activity_main);
        
        //显示两种进度条
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(true);
        
        setProgress(1200);   //设置带进度的进度条刻度
    }
}
