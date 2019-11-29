package com.shopee.feeds.feedlibrary.view.preview;

import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import com.shopee.feeds.feedlibrary.view.preview.e;

public class c implements f {

    /* renamed from: a  reason: collision with root package name */
    private g f28637a;

    public void a(e.a aVar) {
    }

    public Pair<Float, Float> c() {
        return null;
    }

    public void a(FrameLayout frameLayout) {
        this.f28637a = new g(frameLayout.getContext(), false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(this.f28637a, layoutParams);
    }

    public void a() {
        this.f28637a.setVisibility(8);
    }

    public void b(FrameLayout frameLayout) {
        frameLayout.removeView(this.f28637a);
        this.f28637a = null;
    }

    public void a(a aVar, e.a aVar2, Pair<Float, Float> pair) {
        if (pair != null) {
            this.f28637a.a((Float) pair.first, (Float) pair.second);
        }
        this.f28637a.setVisibility(0);
        this.f28637a.setVideoPath(aVar.h());
        this.f28637a.d();
    }

    public View d() {
        return this.f28637a;
    }
}
