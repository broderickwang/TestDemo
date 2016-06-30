package com.ttb.testdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.ttb.kevindialog.dialog.MyDialog;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				MyDialog dlg = new MyDialog(MainActivity.this,R.layout.test1) {
					@Override
					public void onPClick() {

					}

					@Override
					public void onClick(View view) {
						switch (view.getId()){
							case R.id.gcc1:
								Toast.makeText(MainActivity.this, "gcc1", Toast.LENGTH_SHORT).show();
								break;
							case R.id.gcc2:
								Toast.makeText(MainActivity.this, "gcc2", Toast.LENGTH_SHORT).show();
								break;
						}
					}
				};

				dlg.setAttr(MainActivity.this,dlg);
				dlg.show();
			}
		});
	}
}
