package com.shopee.app.ui.common;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.shopee.app.ui.common.ar;
import java.util.ArrayList;
import java.util.List;

public class as {

    /* renamed from: a  reason: collision with root package name */
    private Context f21178a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f21179b;

    /* renamed from: c  reason: collision with root package name */
    private View f21180c;

    /* renamed from: d  reason: collision with root package name */
    private int f21181d;

    /* renamed from: e  reason: collision with root package name */
    private int f21182e;

    /* renamed from: f  reason: collision with root package name */
    private int f21183f;

    /* renamed from: g  reason: collision with root package name */
    private int f21184g;
    private int h;
    private int i;
    private List<Integer> j = new ArrayList();
    private int k;
    private int l;
    private FrameLayout m;
    private View.OnClickListener n;
    private ar.a o;

    public as(Context context, RelativeLayout relativeLayout) {
        this.f21178a = context;
        this.f21179b = relativeLayout;
    }

    public as a(View view) {
        this.f21180c = view;
        return this;
    }

    public as a(int i2) {
        this.f21181d = i2;
        return this;
    }

    public as b(int i2) {
        this.f21182e = i2;
        return this;
    }

    public as c(int i2) {
        this.i = i2;
        return this;
    }

    public as d(int i2) {
        this.j.add(Integer.valueOf(i2));
        return this;
    }

    public as e(int i2) {
        this.k = i2;
        return this;
    }

    public as a(View.OnClickListener onClickListener) {
        this.n = onClickListener;
        return this;
    }

    public as a(ar.a aVar) {
        this.o = aVar;
        return this;
    }

    public ar a() {
        return new ar(this.f21178a, this.f21179b, this.f21180c, this.f21181d, this.f21182e, this.f21183f, this.f21184g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }
}
