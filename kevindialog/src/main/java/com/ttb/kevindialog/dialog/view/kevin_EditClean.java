package com.ttb.kevindialog.dialog.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
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
public class kevin_EditClean extends RelativeLayout {
	private EditText et;
	private ImageView img;
	public kevin_EditClean(Context context) {
		super(context);
	}

	public kevin_EditClean(Context context, AttributeSet attrs) {
		super(context, attrs);
		int resourceid = -1;
		View view = LayoutInflater.from(context).inflate(R.layout.kevin_edit_clean,this,true);
		et = (EditText)view.findViewById(R.id.et);
		et.addTextChangedListener(textWatcher);
		img = (ImageView)view.findViewById(R.id.imgClean);
		img.setVisibility(View.GONE);

		img.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				et.setText("");
			}
		});

		TypedArray a = context.getTheme().obtainStyledAttributes(
				attrs,
				R.styleable.kevin_EditClean,
				0,0
		);
		int n = a.getIndexCount();
		for(int i=0;i<n;i++){
			int attr  = a.getIndex(i);
			if (attr == R.styleable.kevin_EditClean_kevin_hint) {
				resourceid = a.getResourceId(R.styleable.kevin_EditClean_kevin_hint,0);
				et.setHint(resourceid>0?getResources().getText(resourceid):
				a.getString(R.styleable.kevin_EditClean_kevin_hint));
			}else if(attr == R.styleable.kevin_EditClean_kevin_text){
				resourceid = a.getResourceId(R.styleable.kevin_EditClean_kevin_text,0);
				et.setText(resourceid>0?getResources().getText(resourceid):
						a.getString(R.styleable.kevin_EditClean_kevin_text));
			}else if(attr == R.styleable.kevin_EditClean_kevin_cleanIconDrawable){
				resourceid = a.getResourceId(R.styleable.kevin_EditClean_kevin_cleanIconDrawable,0);
				img.setImageResource(resourceid>0?resourceid:R.drawable.icon_clean);
			}else if(attr == R.styleable.kevin_EditClean_kevin_textColor){
				resourceid = a.getResourceId(R.styleable.kevin_EditClean_kevin_textColor,0);
				et.setTextColor(resourceid>0?getResources().getColor(resourceid):
				a.getColor(R.styleable.kevin_EditClean_kevin_textColor, Color.WHITE));
			}else if(attr == R.styleable.kevin_EditClean_kevin_textSize ){
				resourceid = a.getResourceId(R.styleable.kevin_EditClean_kevin_textSize,0);
				et.setTextSize(resourceid>0?getResources().getDimension(resourceid)
				:a.getDimension(R.styleable.kevin_EditClean_kevin_textSize,20));
			}else if(attr == R.styleable.kevin_EditClean_kevin_maxLength){
//				resourceid = a.getResourceId(R.styleable.kevin_EditClean_kevin_maxLength,0);
				et.setFilters(new InputFilter[]{
						new InputFilter.LengthFilter(a.getInt(R.styleable.kevin_EditClean_kevin_maxLength, 0))});
			}
		}
		a.recycle();
	}

	//设置Hint提示字符串的方法，以便通过Java代码进行设置
	protected void setHint(String string){
		et.setHint(string);
	}

	//设置编辑框显示文字的方法，以便通过Java代码进行设置
	protected void setText(String string) {
		et.setText(string);
	}

	//获取输入值
	protected String getText(){
		return et.getText().toString();
	}

	//设置清除按钮的图标，以便通过Java代码进行设置
	protected void setCleanIcon(int drawableId) {
		Drawable drawable = getResources().getDrawable(drawableId);
		img.setImageDrawable(drawable);
	}

	//***重要
	//暴露出EditText，以便设置EditText的更多属性，如inputType属性等等，是为了增加灵活性和兼容性
	protected EditText getEditText(){
		return et;
	}
	private TextWatcher textWatcher = new TextWatcher() {
		@Override
		public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

		}

		@Override
		public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			//在输入框没有输入时不显示清除图标，有输入后显示
			if (TextUtils.isEmpty(charSequence)){
				//为什么不用View.GONE呢？——GONE会使被隐藏的控件不再占用它原本的位置
				// 为了放置在隐藏和显示变化过程中由于位置有无导致自定义控件外观产生抖动或是变化，所以用了View.INVISIBLE
				img.setVisibility(View.INVISIBLE);
			}else {
				img.setVisibility(View.VISIBLE);
			}
		}

		@Override
		public void afterTextChanged(Editable editable) {

		}
	};
}
