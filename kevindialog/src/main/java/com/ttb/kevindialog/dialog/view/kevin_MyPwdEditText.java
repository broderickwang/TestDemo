package com.ttb.kevindialog.dialog.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ttb.kevindialog.R;

/**
 * Created by Kevin on 16/6/30.
 */
public class kevin_MyPwdEditText extends RelativeLayout {
	private EditText pwd_et;
	private ImageView see;
	public kevin_MyPwdEditText(Context context) {
		super(context);
	}

	public kevin_MyPwdEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		int resourceId = -1;
		View view = LayoutInflater.from(context).inflate(R.layout.kevin_myedit_pwd, this,true);
		pwd_et = (EditText) view.findViewById(R.id.pwd_et);
		pwd_et.addTextChangedListener(textWatcher);
		pwd_et.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
		see = (ImageView) view.findViewById(R.id.pwd_see);
		see.setOnClickListener(new OnClickListener() {
			String tmp;
			//dddd
			@Override
			public void onClick(View view) {
				int type = pwd_et.getInputType();
				if(type == 129){
					pwd_et.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
					tmp = pwd_et.getText().toString();
					pwd_et.setText(tmp);
				}else{
					pwd_et.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
					tmp = pwd_et.getText().toString();
					pwd_et.setText(tmp);
				}
			}
		});
		TypedArray a = context.getTheme().obtainStyledAttributes(
				attrs,
				R.styleable.kevin_MyPwdEditText,
				0,0
		);
		int n = a.getIndexCount();
		for(int i=0;i<n;i++){
			int attr = a.getIndex(i);
			if(attr == R.styleable.kevin_MyPwdEditText_viewIconDrawable){
				resourceId = a.getResourceId(R.styleable.kevin_MyPwdEditText_viewIconDrawable,0);
				see.setImageResource(resourceId>0?resourceId:R.drawable.visible);
			}else if(attr == R.styleable.kevin_MyPwdEditText_kevin_text_pwd){
				resourceId = a.getResourceId(R.styleable.kevin_MyPwdEditText_kevin_text_pwd,0);
				pwd_et.setText(resourceId>0?getResources().getString(resourceId):
						a.getString(R.styleable.kevin_MyPwdEditText_kevin_text_pwd));
			}else if(attr == R.styleable.kevin_MyPwdEditText_kevin_tsize_pwd){
				resourceId = a.getResourceId(R.styleable.kevin_MyPwdEditText_kevin_tsize_pwd,0);
				pwd_et.setTextSize(resourceId>0?getResources().getDimension(resourceId)
						:a.getDimension(R.styleable.kevin_MyPwdEditText_kevin_tsize_pwd,20));
			}
		}
		a.recycle();
	}
	public void setDrawable(int drawableID){
		Drawable drawable = getResources().getDrawable(drawableID);
		see.setImageDrawable(drawable);
	}
	public void setText(String texgt){
		pwd_et.setText(texgt);
	}
	public String getText(){
		return pwd_et.getText().toString();
	}
	TextWatcher textWatcher = new TextWatcher() {
		@Override
		public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

		}

		@Override
		public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//			if (TextUtils.isEmpty(charSequence)) {
//				see.setVisibility(VISIBLE);
//			} else {
//				see.setVisibility(INVISIBLE);
//			}
		}

		@Override
		public void afterTextChanged(Editable editable) {

		}
	};
}
