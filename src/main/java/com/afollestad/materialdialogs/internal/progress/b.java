package com.afollestad.materialdialogs.internal.progress;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.afollestad.materialdialogs.a.a;

@TargetApi(14)
public class b extends LayerDrawable {

    /* renamed from: a  reason: collision with root package name */
    private int f3205a;

    /* renamed from: b  reason: collision with root package name */
    private i f3206b = ((i) getDrawable(0));

    /* renamed from: c  reason: collision with root package name */
    private i f3207c;

    /* renamed from: d  reason: collision with root package name */
    private i f3208d;

    public b(Context context) {
        super(new Drawable[]{new i(context), new i(context), new i(context)});
        setId(0, 16908288);
        setId(1, 16908303);
        this.f3207c = (i) getDrawable(1);
        this.f3205a = Math.round(a.a(context, 16842803) * 255.0f);
        this.f3207c.setAlpha(this.f3205a);
        this.f3207c.a(false);
        setId(2, 16908301);
        this.f3208d = (i) getDrawable(2);
        this.f3208d.a(false);
    }

    @TargetApi(21)
    public void setTint(int i) {
        this.f3206b.setTint(i);
        this.f3207c.setTint(i);
        this.f3208d.setTint(i);
    }

    @TargetApi(21)
    public void setTintList(ColorStateList colorStateList) {
        this.f3206b.setTintList(colorStateList);
        this.f3207c.setTintList(colorStateList);
        this.f3208d.setTintList(colorStateList);
    }

    @TargetApi(21)
    public void setTintMode(PorterDuff.Mode mode) {
        this.f3206b.setTintMode(mode);
        this.f3207c.setTintMode(mode);
        this.f3208d.setTintMode(mode);
    }
}
