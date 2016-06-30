package com.ttb.kevindialog.dialog.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ttb.kevindialog.R;

/**
 * Created by Kevin on 16/6/30.
 */
public class SettingItemView extends RelativeLayout {
	private CheckBox cb_status;
	private TextView tv_title;
	private TextView tv_desc;

	private String title;
	private String desc_on;
	private String desc_off;
	private TypedArray a;
	public SettingItemView(Context context) {
		super(context);
	}

	public SettingItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		a = context.getTheme().obtainStyledAttributes(
				attrs,
				R.styleable.SettingItemView,
				0,0);
		try {
			title = a.getString(R.styleable.SettingItemView_kevin_title);
			desc_on = a.getString(R.styleable.SettingItemView_kevin_desc_on);
			desc_off = a.getString(R.styleable.SettingItemView_kevin_desc_off);
		}finally {
			a.recycle();
		}
	}

	public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	private void initView(Context context){
		View.inflate(context, R.layout.test_layout, this);
		cb_status = (CheckBox)findViewById(R.id.cb_status);
		tv_title = (TextView)findViewById(R.id.tv_title);
		tv_desc = (TextView)findViewById(R.id.tv_desc);
	}
}
