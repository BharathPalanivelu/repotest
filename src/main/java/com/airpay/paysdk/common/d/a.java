package com.airpay.paysdk.common.d;

import android.view.View;
import com.airpay.paysdk.common.c.b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f3977a;

    /* renamed from: b  reason: collision with root package name */
    private final b f3978b = b.a(b.c.SCHEDULED);

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f3979c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private final View f3980d;

    public static a a() {
        return new a((View) null, 500);
    }

    private a(View view, int i) {
        this.f3977a = i < 500 ? 500 : i;
        this.f3980d = view;
    }

    public static a a(View view) {
        return new a(view, 500);
    }

    public boolean b() {
        return this.f3979c.get();
    }

    public void c() {
        if (this.f3979c.compareAndSet(false, true)) {
            this.f3978b.a(new Runnable() {
                public final void run() {
                    a.this.d();
                }
            }, this.f3977a, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f3979c.compareAndSet(true, false);
    }

    public void a(View.OnClickListener onClickListener) {
        View view = this.f3980d;
        if (view != null) {
            if (onClickListener == null) {
                view.setOnClickListener((View.OnClickListener) null);
            } else {
                view.setOnClickListener(new View.OnClickListener(onClickListener) {
                    private final /* synthetic */ View.OnClickListener f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        a.this.a(this.f$1, view);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View.OnClickListener onClickListener, View view) {
        if (!b()) {
            c();
            onClickListener.onClick(view);
        }
    }
}
