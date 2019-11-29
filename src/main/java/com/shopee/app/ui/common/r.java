package com.shopee.app.ui.common;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.garena.android.appkit.f.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.shopee.id.R;

public class r {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Activity f21326a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public View f21327b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f21328c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ProgressWheel f21329d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TextView f21330e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f21331f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f21332g = 0;
    /* access modifiers changed from: private */
    public boolean h = false;

    public r(Activity activity) {
        this.f21326a = activity;
    }

    public void a() {
        this.f21332g = 0;
        this.f21328c = false;
        f.a().a(new Runnable() {
            public void run() {
                if (!r.this.f21328c && !r.this.f21326a.isFinishing()) {
                    if (r.this.f21327b == null) {
                        r rVar = r.this;
                        View unused = rVar.f21327b = View.inflate(rVar.f21326a, R.layout.loading_layout, (ViewGroup) null);
                        r rVar2 = r.this;
                        ProgressWheel unused2 = rVar2.f21329d = (ProgressWheel) rVar2.f21327b.findViewById(R.id.progress_wheel);
                        if (r.this.h) {
                            r.this.f21327b.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    r.this.b();
                                }
                            });
                        }
                        if (r.this.f21331f && r.this.f21329d != null) {
                            r rVar3 = r.this;
                            TextView unused3 = rVar3.f21330e = (TextView) rVar3.f21327b.findViewById(R.id.label);
                            r.this.f21329d.setLinearProgress(true);
                            r.this.f21329d.setInstantProgress(BitmapDescriptorFactory.HUE_RED);
                        }
                        FrameLayout frameLayout = (FrameLayout) r.this.f21326a.findViewById(16908290);
                        if (frameLayout != null) {
                            frameLayout.addView(r.this.f21327b, new FrameLayout.LayoutParams(-1, -1));
                        }
                    }
                    r.this.f21327b.setVisibility(0);
                    if (!r.this.f21331f && r.this.f21329d != null) {
                        r.this.f21329d.b();
                    }
                }
            }
        }, 400);
    }

    public void a(boolean z) {
        this.f21331f = z;
    }

    public void a(int i) {
        if (this.f21329d != null) {
            int i2 = this.f21332g;
            if (i2 >= i) {
                i = i2;
            }
            this.f21332g = i;
            this.f21329d.setProgress(((float) this.f21332g) / 100.0f);
            TextView textView = this.f21330e;
            textView.setText(this.f21332g + "%");
        }
    }

    public void b() {
        this.f21332g = 0;
        this.f21328c = true;
        View view = this.f21327b;
        if (view != null) {
            view.setVisibility(8);
        }
        ProgressWheel progressWheel = this.f21329d;
        if (progressWheel != null) {
            progressWheel.a();
        }
    }

    public void b(boolean z) {
        this.h = z;
    }
}
