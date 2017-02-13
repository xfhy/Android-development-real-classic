package com.xfhy.gridviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Phone extends Activity implements OnItemClickListener,
OnItemLongClickListener{

	private SimpleAdapter ph_adapter = null;
	private ListView listView = null;
	private String selectData[]={"发短信","打电话"};
	
	//数据源
	private String[] names = {"张三","李四","黎明","北京分行","长春分行","长沙分行","成都分行",
			"重庆分行","大连分行","东莞分行"};
	private String[] ph_phone = {"10086","13425467854","13548564125",
			"010-66426705","0431-85580020","0731-84302954","028-61816547",
			"023-60363126","0411-39853315","0769-23667819"};
	private List<Map<String,Object>>dataList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phone);
		
		listView = (ListView) findViewById(R.id.listView);
		dataList = new ArrayList<Map<String,Object>>();   //初始化数据源
		
		//初始化Adapter
		ph_adapter = new SimpleAdapter(this, getData(), R.layout.item_phone,
				new String[]{"name","hphone"}, new int[]{R.id.name,R.id.hphone});
		listView.setAdapter(ph_adapter);    //设置ListView的Adapter
		
		listView.setOnItemClickListener(this);     //ListView点击事件
		listView.setOnItemLongClickListener(this);  //ListView长按事件
	}

	//为数据源添加数据
	private List<Map<String,Object>> getData() {
		for (int i = 0; i < names.length; i++) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("name", names[i]);
			map.put("hphone", ph_phone[i]);
			dataList.add(map);
		}
		return dataList;
	}

	//直接点击,则直接拨打电话
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String phonet = ph_phone[position];   //获得用户点击的联系人的号码
		Log.i("tag",phonet);   //记录需要拨打的电话
		
		//用intent启动拨打电话  
        Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phonet));
        startActivity(intent);
	}

	//长按ListView的选项时 的事件
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		final String phonet = ph_phone[position];   //获得用户点击的联系人的号码
		
		//长按ListView显示对话框,对话框中有2个选项,发短信和打电话
		Dialog dialog = new AlertDialog.Builder(Phone.this).
				setIcon(R.drawable.tou)
				.setTitle("请选择操作")
				.setNegativeButton("取消", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				})
				.setItems(selectData, new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if(which==0)
						{
							            /*----------调用系统发短信功能发送短信---------*/
							 /*Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+phonet));            
				            intent.putExtra("sms_body", "逗比");            
				            startActivity(intent); */
				            
							           /*----------直接自己发送短信给某人,而系统不会记录---------*/
				          //获取短信管理器   
				            android.telephony.SmsManager smsManager = android.telephony.
				            		SmsManager.getDefault();  
				            //拆分短信内容（手机短信长度限制）    
				            List<String> divideContents = smsManager.divideMessage("hf");   
				            for (String text : divideContents) {    
				                smsManager.sendTextMessage(phonet, null, text, null, null);    
				            }  
						}
						else if(which==1)
						{
							//用intent启动拨打电话  
					        Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phonet));
					        startActivity(intent);
						}
					}
				}).create();
		dialog.show();
				
		return false;
	}

}
