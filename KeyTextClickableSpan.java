package com.imhuayou.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class KeyTextClickableSpan extends ClickableSpan implements
		ParcelableSpan {
	private Intent mIntent;

	public KeyTextClickableSpan(Intent intent) {
		mIntent = intent;
	}

	@Override
	public void onClick(View sourceView) {
		Context context = sourceView.getContext();
		context.startActivity(mIntent);
	}

	@Override
	public void updateDrawState(TextPaint ds) {
		// TODO Auto-generated method stub #00C08E
		ds.setColor(Color.argb(255, 0, 0xc0, 0x8e));
		ds.setUnderlineText(false);
	}

	@Override
	public int getSpanTypeId() {
		return 100;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flag) {
		// don't write to parcel
	}

	public Intent getIntent() {
		return mIntent;
	}
}
