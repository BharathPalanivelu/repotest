package com.google.android.exoplayer2.j;

import android.graphics.Bitmap;
import android.text.Layout;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f10429a;

    /* renamed from: b  reason: collision with root package name */
    public final Layout.Alignment f10430b;

    /* renamed from: c  reason: collision with root package name */
    public final Bitmap f10431c;

    /* renamed from: d  reason: collision with root package name */
    public final float f10432d;

    /* renamed from: e  reason: collision with root package name */
    public final int f10433e;

    /* renamed from: f  reason: collision with root package name */
    public final int f10434f;

    /* renamed from: g  reason: collision with root package name */
    public final float f10435g;
    public final int h;
    public final float i;
    public final float j;
    public final boolean k;
    public final int l;

    public a(Bitmap bitmap, float f2, int i2, float f3, int i3, float f4, float f5) {
        this((CharSequence) null, (Layout.Alignment) null, bitmap, f3, 0, i3, f2, i2, f4, f5, false, -16777216);
    }

    public a(CharSequence charSequence) {
        this(charSequence, (Layout.Alignment) null, Float.MIN_VALUE, RNCartPanelDataEntity.NULL_VALUE, RNCartPanelDataEntity.NULL_VALUE, Float.MIN_VALUE, RNCartPanelDataEntity.NULL_VALUE, Float.MIN_VALUE);
    }

    public a(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        this(charSequence, alignment, f2, i2, i3, f3, i4, f4, false, -16777216);
    }

    public a(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z, int i5) {
        this(charSequence, alignment, (Bitmap) null, f2, i2, i3, f3, i4, f4, Float.MIN_VALUE, z, i5);
    }

    private a(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f2, int i2, int i3, float f3, int i4, float f4, float f5, boolean z, int i5) {
        this.f10429a = charSequence;
        this.f10430b = alignment;
        this.f10431c = bitmap;
        this.f10432d = f2;
        this.f10433e = i2;
        this.f10434f = i3;
        this.f10435g = f3;
        this.h = i4;
        this.i = f4;
        this.j = f5;
        this.k = z;
        this.l = i5;
    }
}
