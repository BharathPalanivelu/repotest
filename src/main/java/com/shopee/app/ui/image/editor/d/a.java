package com.shopee.app.ui.image.editor.d;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f22913a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22914b;

    public a(ImageView imageView, int i) {
        this.f22913a = imageView;
        this.f22914b = i;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f22913a.setColorFilter(this.f22914b);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f22913a.setColorFilter(0);
            if (new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) view.getWidth(), (float) view.getHeight()).contains(motionEvent.getX(), motionEvent.getY())) {
                view.performClick();
            }
        }
        return true;
    }
}
