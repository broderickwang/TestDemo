package com.ttb.kevindialog.dialog.view;

import android.content.Context;
import android.content.res.TypedArray;
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
public class kevin_EditPwd extends RelativeLayout {
	private EditText pwd;
	private ImageView see;

	public kevin_EditPwd(Context context) {
		super(context);
	}

	public kevin_EditPwd(Context context, AttributeSet attrs) {
		super(context, attrs);
		int resourceId = -1;
		View view = LayoutInflater.from(context).inflate(R.layout.kevin_edit_pwd, null);
		pwd = (EditText) view.findViewById(R.id.et_pwd);
		pwd.addTextChangedListener(textWatcher);
		see = (ImageView) view.findViewById(R.id.imgClean);
		see.setVisibility(INVISIBLE);
		see.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				int type = pwd.getInputType();
				if(type == InputType.TYPE_TEXT_VARIATION_PASSWORD){
					pwd.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL);
				}else{
					pwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
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
				pwd.setText(resourceId>0?getResources().getString(resourceId):
							a.getString(R.styleable.kevin_MyPwdEditText_kevin_text_pwd));
			}
		}
		a.recycle();

	}

	TextWatcher textWatcher = new TextWatcher() {
		@Override
		public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

		}

		@Override
		public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			if (TextUtils.isEmpty(charSequence)) {
				see.setVisibility(VISIBLE);
			} else {
				see.setVisibility(INVISIBLE);
			}
		}

		@Override
		public void afterTextChanged(Editable editable) {

		}
	};
}
