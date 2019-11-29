package com.facebook.react.views.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import androidx.core.g.w;

public class ReactViewBackgroundManager {
    private ReactViewBackgroundDrawable mReactBackgroundDrawable;
    private View mView;

    public ReactViewBackgroundManager(View view) {
        this.mView = view;
    }

    private ReactViewBackgroundDrawable getOrCreateReactViewBackground() {
        if (this.mReactBackgroundDrawable == null) {
            this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable(this.mView.getContext());
            Drawable background = this.mView.getBackground();
            w.a(this.mView, (Drawable) null);
            if (background == null) {
                w.a(this.mView, (Drawable) this.mReactBackgroundDrawable);
            } else {
                w.a(this.mView, (Drawable) new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, background}));
            }
        }
        return this.mReactBackgroundDrawable;
    }

    public void setBackgroundColor(int i) {
        if (i != 0 || this.mReactBackgroundDrawable != null) {
            getOrCreateReactViewBackground().setColor(i);
        }
    }

    public void setBorderWidth(int i, float f2) {
        getOrCreateReactViewBackground().setBorderWidth(i, f2);
    }

    public void setBorderColor(int i, float f2, float f3) {
        getOrCreateReactViewBackground().setBorderColor(i, f2, f3);
    }

    public void setBorderRadius(float f2) {
        getOrCreateReactViewBackground().setRadius(f2);
    }

    public void setBorderRadius(float f2, int i) {
        getOrCreateReactViewBackground().setRadius(f2, i);
    }

    public void setBorderStyle(String str) {
        getOrCreateReactViewBackground().setBorderStyle(str);
    }
}
