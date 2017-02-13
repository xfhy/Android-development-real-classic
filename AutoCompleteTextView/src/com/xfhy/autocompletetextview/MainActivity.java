package com.xfhy.autocompletetextview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;


public class MainActivity extends Activity {

	private AutoCompleteTextView atv1 = null;
	private String[] resourse = {
			"beijing1","beijing2","beijing3","beijing4",
			"shanghai1","shanghai2","shanghai3","shanghai4"
	};
	private MultiAutoCompleteTextView matv1 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /*
         * AutoCompleteTextView
         * 第一步:初始化控件
         * 第二步:需要一个适配器
         * 第三步:初始化数据源,去匹配文本框中输入的内容
         * 第四步:将adapter与当前AutoCompleteTextView绑定
         * */
        atv1  = (AutoCompleteTextView)findViewById(R.id.atv1);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1,    //系统的布局
        		resourse);
        atv1.setAdapter(adapter);
        
        
        /*
         * MultiAutoCompleteTextView
         * 第一步:初始化控件
         * 第二步:需要一个适配器
         * 第三步:初始化数据源,去匹配文本框中输入的内容
         * 第四步:将adapter与当前AutoCompleteTextView绑定
         * 第五步:设置分隔符,
         * */
        matv1 = (MultiAutoCompleteTextView)findViewById(R.id.matv1);
        matv1.setAdapter(adapter);
        
        //设置以逗号为分隔符为结束的符号
        matv1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());  
    }
}
