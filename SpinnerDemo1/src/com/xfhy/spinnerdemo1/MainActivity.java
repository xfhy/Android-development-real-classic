package com.xfhy.spinnerdemo1;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * 下拉列表框
 * 可以直接在main.xml文件中定义<Spinner>节点,但是在定义此元素时却不能直接设置其显示的列表项
 * 关于下拉框列表项的2中配置方式
 * 方式1:
 * 直接通过资源文件配置,例如定义一个values\city_data.xml文件,在定义数据内容时需要使用<string-array>
 * 元素指定.随后在layout\main.xml文件中定义<Spinner>节点时,直接使用
 * android:entries="@array/city_labels"属性即可读取信息
 * 
 * 方式2:
 * 在程序中编码,则需要使用ArrayAdapter,读取资源文件或者指定具体设置的数据,此类有2个主要功能,读取资源文件
 * 中定义的列表项或者是通过List集合设置列表项
 * @author XFHY
 *
 */
public class MainActivity extends Activity {

	private Spinner spiColor = null;   //定义表示颜色的列表框
	private Spinner spiEdu = null;     //定义表示学历的列表框
	private ArrayAdapter<CharSequence> adapterColor = null;  //下拉列表内容适配器
	private ArrayAdapter<CharSequence> adapterEdu = null;    //下拉列表内容适配器
	private List<CharSequence> dataEdu = null;   //集合保存下拉列表选项
	private Spinner mycity = null;
	private TextView text = null;
	
	private String[][] areaData = new String[][]{  //定义联动菜单项
			{"东城","西城","朝阳","大兴","平谷"},       //第一级子选项
			{"黄埔","杨浦","闵行"},                   //第二级子选项
			{"广州"}                                //第三极子选项
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mycity = (Spinner)findViewById(R.id.mycity);
        text = (TextView)findViewById(R.id.text);
        this.spiColor = (Spinner)super.findViewById(R.id.mycolor);
        this.spiColor.setPrompt("请选择您喜欢的颜色");     //定义提示的信息
        this.adapterColor = ArrayAdapter.createFromResource(this,
        		R.array.color_lables, 
        		android.R.layout.simple_spinner_item);  //从资源文件读取选项
        
        this.adapterColor.setDropDownViewResource(android.
        		R.layout.simple_spinner_dropdown_item);   //设置列表显示风格
        
        this.spiColor.setAdapter(this.adapterColor);   //设置下拉列表选项
        this.dataEdu = new ArrayList<CharSequence>();  //实例化List集合
        this.dataEdu.add("大学");
        this.dataEdu.add("研究生");
        this.dataEdu.add("高中");
        this.spiEdu = (Spinner)super.findViewById(R.id.myedu);
        this.spiEdu.setPrompt("请选择喜欢的学历");
        this.adapterEdu = new ArrayAdapter<CharSequence>(this,
        		android.R.layout.simple_spinner_item,this.dataEdu);  //定义下拉列表项
        this.adapterEdu.setDropDownViewResource(android.
        		R.layout.simple_spinner_dropdown_item);   //设置列表显示风格
        this.spiEdu.setAdapter(adapterEdu);   //设置下拉列表选项
        
        mycity.setOnItemSelectedListener(new OnItemSelectedListenerlmpl());
    }
    
    private class OnItemSelectedListenerlmpl implements OnItemSelectedListener
    {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			//得到当前选择的选项
			String str = parent.getItemAtPosition(position).toString();  
			text.setText("您喜欢的城市是"+str);
		}
		@Override
		public void onNothingSelected(AdapterView<?> parent) {   //没有选项时触发
			text.setText("您没有喜欢的城市吗?");
		}
    }
}
