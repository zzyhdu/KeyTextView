package com.imhuayou.ui.widget;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;

public class KeyTextView extends TextView {
	String mStr;
	List<Integer> starts;
	List<Integer> ends;
	List<Intent> intents;

	public KeyTextView(Context context) {
		super(context);
	}

	public KeyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public void setKeyText(String str, Intent intent) {
		SpannableString text = new SpannableString(str);
		if (starts != null && !starts.isEmpty()) {
			for (int i = 0; i < starts.size(); i++) {
				text.setSpan(new KeyTextClickableSpan(intents.get(i)),
						starts.get(i), ends.get(i),
						Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}
		setText(text);
		setMovementMethod(LinkMovementMethod.getInstance()); 
	}

	public void show(){
		SpannableString text = new SpannableString(mStr);
		if (starts != null && !starts.isEmpty()) {
			for (int i = 0; i < starts.size(); i++) {
				text.setSpan(new KeyTextClickableSpan(intents.get(i)),
						starts.get(i), ends.get(i),
						Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}
		setText(text);
		setMovementMethod(LinkMovementMethod.getInstance());
	}
	public void recycle(){
		if(mStr != null){
			mStr = null;
		}
		if (starts != null) {
			starts = null;
			ends = null;
			intents = null;
			
		}
	}
	
	public void addStr(String str, Intent intent) {
		if (mStr == null) {
			mStr = new String();
		}
		if (starts == null) {
			starts = new ArrayList<Integer>();
			ends = new ArrayList<Integer>();
			intents = new ArrayList<Intent>();
		}
		if(intent != null){
			starts.add(mStr.length());
			mStr = mStr + str;
			ends.add(mStr.length());
			intents.add(intent);
		}else{
			mStr = mStr + str;
		}
	}

}
