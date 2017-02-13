package com.xfhy.mysqlitedemo;

import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	private SQLiteOpenHelper helper = null;
	private MytabOperate mytab = null;
	private Button insert = null;
	private Button update = null;
	private Button delete = null;
	private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.insert = (Button)findViewById(R.id.insert);
        this.update = (Button)findViewById(R.id.update);
        this.delete = (Button)findViewById(R.id.delete);
        this.helper = new MyDatabaseHelper(this);
        insert.setOnClickListener(new InsertOnClickListenerImpl());
        update.setOnClickListener(new UpdateOnClickListenerImpl());
        delete.setOnClickListener(new DeleteOnClickListenerImpl());
    }
    private class InsertOnClickListenerImpl implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			//取得可更新的数据库
			MainActivity.this.mytab = new MytabOperate(MainActivity.this.helper.getWritableDatabase());
			MainActivity.this.mytab.insert("李华"+count++, "1997-08-12");
		}
    }
    private class UpdateOnClickListenerImpl implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			MainActivity.this.mytab = new MytabOperate(MainActivity.this.helper.getWritableDatabase());
			MainActivity.this.mytab.update(1, "xfhyd", "1978-02-08");
		}
    }
    private class DeleteOnClickListenerImpl implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			MainActivity.this.mytab = new MytabOperate(MainActivity.this.helper.getWritableDatabase());
			MainActivity.this.mytab.delete(1);   //删除数据
		}
    }
}
