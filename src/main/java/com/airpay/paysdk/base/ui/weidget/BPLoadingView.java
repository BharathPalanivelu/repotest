package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.airpay.paysdk.base.interfaces.ILoadingView;
import com.airpay.paysdk.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class BPLoadingView extends AppCompatImageView implements ILoadingView {

    /* renamed from: a  reason: collision with root package name */
    private Animation f3872a;

    public BPLoadingView(Context context) {
        super(context);
        a();
    }

    public BPLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        setImageResource(c.d.com_garena_beepay_view_loading_circle);
        this.f3872a = AnimationUtils.loadAnimation(getContext(), c.a.com_garena_beepay_loading_circle_scale_anim);
        this.f3872a.setDuration(1440);
        this.f3872a.setInterpolator(new Interpolator() {
            public float getInterpolation(float f2) {
                double cos;
                if (f2 <= 0.33333334f) {
                    double d2 = (double) (f2 - 0.16666667f);
                    Double.isNaN(d2);
                    cos = Math.sin(d2 * 3.141592653589793d * 3.0d);
                } else if (f2 > 0.8333333f) {
                    return BitmapDescriptorFactory.HUE_RED;
                } else {
                    double d3 = (double) (f2 - 0.33333334f);
                    Double.isNaN(d3);
                    cos = Math.cos(d3 * 3.141592653589793d * 2.0d);
                }
                return ((float) (cos * 0.5d)) + 0.5f;
            }
        });
        this.f3872a.setRepeatCount(-1);
        this.f3872a.setRepeatMode(1);
    }

    public void changeLoadingState(boolean z) {
        if (z) {
            this.f3872a.reset();
            setAnimation(this.f3872a);
            return;
        }
        clearAnimation();
    }
}
