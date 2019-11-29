package com.a.a;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;

public class e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f3120a;

    /* renamed from: b  reason: collision with root package name */
    private int f3121b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f3122c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f3123d = -1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3124e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3125f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3126g;
    private boolean h;
    private boolean i;

    public e(T t) {
        this.f3120a = t;
    }

    public e<T> a(int i2) {
        this.f3121b = i2;
        return this;
    }

    public e<T> b(int i2) {
        this.f3122c = i2;
        return this;
    }

    public e<T> a() {
        this.f3124e = true;
        return this;
    }

    public e<T> b() {
        this.f3125f = true;
        return this;
    }

    public T c() {
        return this.f3120a;
    }

    public e<T> d() {
        this.i = true;
        return this;
    }

    public SpannableString a(SpannableString spannableString, int i2, int i3) {
        if (this.i) {
            spannableString.setSpan(new StyleSpan(1), i2, i3, 33);
        }
        if (this.h) {
            spannableString.setSpan(new SubscriptSpan(), i2, i3, 33);
        }
        if (this.f3126g) {
            spannableString.setSpan(new SuperscriptSpan(), i2, i3, 33);
        }
        if (this.f3125f) {
            spannableString.setSpan(new StrikethroughSpan(), i2, i3, 33);
        }
        if (this.f3124e) {
            spannableString.setSpan(new UnderlineSpan(), i2, i3, 33);
        }
        int i4 = this.f3121b;
        if (i4 != -1) {
            spannableString.setSpan(new AbsoluteSizeSpan(i4), i2, i3, 33);
        }
        int i5 = this.f3122c;
        if (i5 != -1) {
            spannableString.setSpan(new ForegroundColorSpan(i5), i2, i3, 33);
        }
        int i6 = this.f3123d;
        if (i6 != -1) {
            spannableString.setSpan(new BackgroundColorSpan(i6), i2, i3, 33);
        }
        return spannableString;
    }
}
