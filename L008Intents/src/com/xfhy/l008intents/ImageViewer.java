package com.xfhy.l008intents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewer extends Activity {
	private ImageView image = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	image = new ImageView(this);
    	setContentView(image);
    	image.setImageURI(getIntent().getData());
    }
}
