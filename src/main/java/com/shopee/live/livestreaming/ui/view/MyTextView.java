package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.devspark.robototextview.widget.RobotoTextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;

public class MyTextView extends RobotoTextView {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f29165a;

    public MyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29165a = BitmapFactory.decodeResource(context.getResources(), c.d.live_streaming_ic_public_voice);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.f29165a, BitmapDescriptorFactory.HUE_RED, 8.0f, getPaint());
        super.onDraw(canvas);
    }
}
