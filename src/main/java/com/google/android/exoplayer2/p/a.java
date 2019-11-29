package com.google.android.exoplayer2.p;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.s.v;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f11019a = new a(-1, -16777216, 0, 0, -1, (Typeface) null);

    /* renamed from: b  reason: collision with root package name */
    public final int f11020b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11021c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11022d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11023e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11024f;

    /* renamed from: g  reason: collision with root package name */
    public final Typeface f11025g;

    @TargetApi(19)
    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        if (v.f11449a >= 21) {
            return c(captionStyle);
        }
        return b(captionStyle);
    }

    public a(int i, int i2, int i3, int i4, int i5, Typeface typeface) {
        this.f11020b = i;
        this.f11021c = i2;
        this.f11022d = i3;
        this.f11023e = i4;
        this.f11024f = i5;
        this.f11025g = typeface;
    }

    @TargetApi(19)
    private static a b(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @TargetApi(21)
    private static a c(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f11019a.f11020b, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f11019a.f11021c, captionStyle.hasWindowColor() ? captionStyle.windowColor : f11019a.f11022d, captionStyle.hasEdgeType() ? captionStyle.edgeType : f11019a.f11023e, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f11019a.f11024f, captionStyle.getTypeface());
    }
}
