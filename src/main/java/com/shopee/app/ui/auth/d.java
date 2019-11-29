package com.shopee.app.ui.auth;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.common.ap;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class d extends FrameLayout implements r {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f19515e = {b.e(R.string.sp_sign_up), b.e(R.string.sp_log_in)};

    /* renamed from: a  reason: collision with root package name */
    MaterialTabView f19516a;

    /* renamed from: b  reason: collision with root package name */
    com.shopee.app.ui.actionbar.a f19517b;

    /* renamed from: c  reason: collision with root package name */
    g f19518c;

    /* renamed from: d  reason: collision with root package name */
    k f19519d;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f19520f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f19521g;
    /* access modifiers changed from: private */
    public m h;
    /* access modifiers changed from: private */
    public r i;

    public d(Context context, String str, String str2) {
        super(context);
        this.f19520f = str;
        this.f19521g = str2;
        ((com.shopee.app.ui.auth.b.b) ((x) context).b()).a(this);
        this.f19517b.setVisibility(8);
        setId(R.id.left);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a aVar = new a();
        this.f19516a.setAdapter(aVar);
        this.f19516a.setTabIndicator(new ap(aVar.b()));
        this.f19516a.a();
        this.f19518c.a();
        this.f19519d.c();
    }

    public void b() {
        this.f19516a.b();
    }

    public void c() {
        this.f19516a.c();
    }

    public void d() {
        this.f19518c.b();
        this.f19519d.d();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return this.f19518c.a(this.f19519d.a(super.onSaveInstanceState()));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(this.f19519d.b(this.f19518c.b(parcelable)));
    }

    public void setTabIndex(int i2) {
        this.f19516a.setSelectedIndex(i2);
    }

    public m getLoginTab() {
        return this.h;
    }

    public r getSignupTab() {
        return this.i;
    }

    private class a extends com.garena.android.uikit.a.a {
        public View a(Context context) {
            return null;
        }

        public int b() {
            return 2;
        }

        private a() {
        }

        public com.garena.android.uikit.a.a.b d(Context context, int i) {
            ao aoVar = new ao(context, d.f19515e[i]);
            aoVar.setTitle(d.f19515e[i]);
            return aoVar;
        }

        public com.garena.android.uikit.a.a.a e(Context context, int i) {
            if (i != 0) {
                d dVar = d.this;
                m unused = dVar.h = n.a(context, dVar.f19520f, d.this.f19521g, d.this.f19518c, d.this.f19519d);
                return d.this.h;
            }
            d dVar2 = d.this;
            r unused2 = dVar2.i = s.a(context, dVar2.f19521g, d.this.f19518c, d.this.f19519d);
            return d.this.i;
        }
    }
}
