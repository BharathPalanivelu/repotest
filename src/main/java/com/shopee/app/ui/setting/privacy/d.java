package com.shopee.app.ui.setting.privacy;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.h.q;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.setting.cell.a;
import com.shopee.app.ui.setting.m;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class d extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    b f25325a;

    /* renamed from: b  reason: collision with root package name */
    bc f25326b;

    /* renamed from: c  reason: collision with root package name */
    r f25327c;

    /* renamed from: d  reason: collision with root package name */
    a f25328d;

    /* renamed from: e  reason: collision with root package name */
    a f25329e;

    /* renamed from: f  reason: collision with root package name */
    a f25330f;

    /* renamed from: g  reason: collision with root package name */
    a f25331g;
    Activity h;
    RegionConfig i;
    al j;
    /* access modifiers changed from: private */
    public View.OnClickListener k = new View.OnClickListener() {
        public void onClick(View view) {
            if (!d.this.f25328d.c()) {
                com.shopee.app.ui.dialog.a.a(d.this.getContext(), (int) R.string.sp_privacy_warning, (int) R.string.sp_label_cancel, (int) R.string.sp_label_ok, (a.C0318a) new a.C0318a() {
                    public void onPositive() {
                        d.this.f25325a.a(d.this.f25328d.c(), d.this.f25329e.c(), d.this.f25331g.c());
                    }

                    public void onNegative() {
                        d.this.f25328d.setOnClickListener((View.OnClickListener) null);
                        d.this.f25328d.setChecked(!d.this.f25328d.c());
                        d.this.f25328d.setOnClickListener(d.this.k);
                    }
                }, (a.g) new a.g() {
                    public void a() {
                        d.this.f25328d.setOnClickListener((View.OnClickListener) null);
                        d.this.f25328d.setChecked(!d.this.f25328d.c());
                        d.this.f25328d.setOnClickListener(d.this.k);
                    }
                });
            } else {
                d.this.f25325a.a(d.this.f25328d.c(), d.this.f25329e.c(), d.this.f25331g.c());
            }
        }
    };
    /* access modifiers changed from: private */
    public View.OnClickListener l = new View.OnClickListener() {
        public void onClick(View view) {
            if (!d.this.f25329e.c()) {
                com.shopee.app.ui.dialog.a.a(d.this.getContext(), (int) R.string.sp_privacy_warning_likes, (int) R.string.sp_label_cancel, (int) R.string.sp_label_ok, (a.C0318a) new a.C0318a() {
                    public void onPositive() {
                        d.this.f25325a.a(d.this.f25328d.c(), d.this.f25329e.c(), d.this.f25331g.c());
                    }

                    public void onNegative() {
                        d.this.f25329e.setOnClickListener((View.OnClickListener) null);
                        d.this.f25329e.setChecked(!d.this.f25329e.c());
                        d.this.f25329e.setOnClickListener(d.this.l);
                    }
                }, (a.g) new a.g() {
                    public void a() {
                        d.this.f25329e.setOnClickListener((View.OnClickListener) null);
                        d.this.f25329e.setChecked(!d.this.f25329e.c());
                        d.this.f25329e.setOnClickListener(d.this.l);
                    }
                });
            } else {
                d.this.f25325a.a(d.this.f25328d.c(), d.this.f25329e.c(), d.this.f25331g.c());
            }
        }
    };
    private View.OnClickListener m = new View.OnClickListener() {
        public void onClick(View view) {
            d.this.j.d(d.this.f25330f.c());
        }
    };
    private View.OnClickListener n = new View.OnClickListener() {
        public void onClick(View view) {
            d.this.f25325a.a(d.this.f25328d.c(), d.this.f25329e.c(), d.this.f25331g.c());
        }
    };

    public d(Context context) {
        super(context);
        ((m) ((x) context).b()).a(this);
        setOrientation(1);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f25326b.a(this.f25325a);
        this.f25325a.a(this);
        this.f25325a.e();
        this.f25328d.setOnClickListener(this.k);
        this.f25329e.setOnClickListener(this.l);
        this.f25330f.setOnClickListener(this.m);
        this.f25331g.setOnClickListener(this.n);
        if (this.i.hideTimeline()) {
            this.f25328d.setVisibility(8);
        } else {
            this.f25328d.setVisibility(0);
        }
        if (Build.VERSION.SDK_INT < 23) {
            this.f25330f.setVisibility(0);
            this.f25330f.setChecked(this.j.r());
            return;
        }
        this.f25330f.setVisibility(8);
    }

    public void b() {
        this.f25327c.a();
    }

    public void c() {
        this.f25327c.b();
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void a(ShopDetail shopDetail) {
        this.f25328d.setOnClickListener((View.OnClickListener) null);
        this.f25329e.setOnClickListener((View.OnClickListener) null);
        this.f25331g.setOnClickListener((View.OnClickListener) null);
        this.f25328d.setChecked(shopDetail.isFeedsPrivate());
        this.f25329e.setChecked(shopDetail.isLikesPrivate());
        this.f25331g.setChecked(shopDetail.isInvisibleToContact());
        this.f25328d.setOnClickListener(this.k);
        this.f25329e.setOnClickListener(this.l);
        this.f25330f.setOnClickListener(this.m);
        this.f25331g.setOnClickListener(this.n);
    }
}
