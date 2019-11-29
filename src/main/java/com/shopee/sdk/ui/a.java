package com.shopee.sdk.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.garena.android.appkit.f.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.shopee.sdk.a;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Activity f30458a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public View f30459b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f30460c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ProgressWheel f30461d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TextView f30462e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f30463f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f30464g = 0;
    /* access modifiers changed from: private */
    public boolean h = false;

    public a(Activity activity) {
        this.f30458a = activity;
    }

    public void a() {
        this.f30464g = 0;
        this.f30460c = false;
        f.a().a(new Runnable() {
            public void run() {
                if (!a.this.f30460c && !a.this.f30458a.isFinishing()) {
                    if (a.this.f30459b == null) {
                        a aVar = a.this;
                        View unused = aVar.f30459b = View.inflate(aVar.f30458a, a.c.sp_sdk_loading_layout, (ViewGroup) null);
                        a aVar2 = a.this;
                        ProgressWheel unused2 = aVar2.f30461d = (ProgressWheel) aVar2.f30459b.findViewById(a.b.progress_wheel);
                        if (a.this.h) {
                            a.this.f30459b.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    a.this.b();
                                }
                            });
                        }
                        if (a.this.f30461d != null) {
                            a aVar3 = a.this;
                            TextView unused3 = aVar3.f30462e = (TextView) aVar3.f30459b.findViewById(a.b.label);
                        }
                        FrameLayout frameLayout = (FrameLayout) a.this.f30458a.findViewById(16908290);
                        if (frameLayout != null) {
                            frameLayout.addView(a.this.f30459b, new FrameLayout.LayoutParams(-1, -1));
                        }
                    }
                    a.this.f30459b.setVisibility(0);
                    if (a.this.f30463f && a.this.f30461d != null) {
                        a.this.f30461d.setLinearProgress(true);
                        a.this.f30461d.setInstantProgress(BitmapDescriptorFactory.HUE_RED);
                        a.this.f30462e.setText("Loading...");
                    }
                    if (!a.this.f30463f && a.this.f30461d != null) {
                        a.this.f30461d.setLinearProgress(false);
                        a.this.f30461d.b();
                        a.this.f30462e.setText("Loading...");
                    }
                }
            }
        }, 400);
    }

    public void a(boolean z) {
        this.f30463f = z;
    }

    public void b() {
        this.f30464g = 0;
        this.f30460c = true;
        View view = this.f30459b;
        if (view != null) {
            view.setVisibility(8);
        }
        ProgressWheel progressWheel = this.f30461d;
        if (progressWheel != null) {
            progressWheel.a();
        }
    }
}
