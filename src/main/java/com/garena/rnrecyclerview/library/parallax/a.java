package com.garena.rnrecyclerview.library.parallax;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView f8571a;

    /* renamed from: b  reason: collision with root package name */
    private final View f8572b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8573c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8574d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f8575e;

    /* renamed from: f  reason: collision with root package name */
    private float f8576f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private final int f8577g = 0;
    private final int h;

    public a(RecyclerView recyclerView, View view, int i, int i2, boolean z, float f2) {
        this.f8571a = recyclerView;
        this.f8572b = view;
        this.f8573c = i;
        this.f8574d = i2;
        this.f8575e = z;
        this.f8576f = f2;
        this.h = (this.f8573c - this.f8574d) * -1;
    }

    public float a(int i, int i2) {
        if (!this.f8575e) {
            if (i > 0) {
                float max = Math.max((float) this.h, this.f8572b.getY() - (((float) i) * this.f8576f));
                this.f8572b.setTranslationY(max);
                return max;
            } else if (i < 0) {
                if (i2 * -1 > this.f8573c || !a()) {
                    return -1.0f;
                }
                float min = Math.min(BitmapDescriptorFactory.HUE_RED, this.f8572b.getY() - (((float) i) * this.f8576f));
                this.f8572b.setTranslationY(min);
                return min;
            } else if (i != 0 || i2 != 0) {
                return -1.0f;
            } else {
                this.f8572b.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                return BitmapDescriptorFactory.HUE_RED;
            }
        } else if (i > 0) {
            float max2 = Math.max((float) this.h, this.f8572b.getY() - (((float) i) * this.f8576f));
            this.f8572b.setTranslationY(max2);
            return max2;
        } else if (i < 0) {
            float min2 = Math.min(BitmapDescriptorFactory.HUE_RED, this.f8572b.getY() - (((float) i) * this.f8576f));
            this.f8572b.setTranslationY(min2);
            return min2;
        } else if (i != 0 || i2 != 0) {
            return -1.0f;
        } else {
            this.f8572b.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            return BitmapDescriptorFactory.HUE_RED;
        }
    }

    public boolean a() {
        return ((LinearLayoutManager) this.f8571a.getLayoutManager()).n() == 0;
    }
}
