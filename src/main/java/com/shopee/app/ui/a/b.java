package com.shopee.app.ui.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.n;
import com.shopee.app.ui.tracklog.i;

public abstract class b extends e {

    /* renamed from: a  reason: collision with root package name */
    private d f6998a;

    /* renamed from: b  reason: collision with root package name */
    private e f6999b = new f() {
        public void a(com.garena.android.appkit.b.a aVar) {
            b.this.b(((Integer) aVar.data).intValue());
        }
    };
    ActionRequiredCounter o;
    ActivityCounter p;
    com.shopee.app.d.c.c.a q;
    com.shopee.app.ui.common.a r;
    n s;
    i t;

    /* access modifiers changed from: protected */
    public abstract void a(Bundle bundle);

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
    }

    /* access modifiers changed from: protected */
    public void a(com.shopee.app.ui.common.a aVar) {
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean u() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void b(Bundle bundle) {
        this.f6998a = t();
        super.setContentView(this.f6998a);
        a(bundle);
        a(this.r);
        this.v.a("CHAT_BADGE_UPDATE2", this.f6999b);
        this.v.a("CHAT_BADGE_LOAD", this.f6999b);
        this.q.a();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.v.b("CHAT_BADGE_UPDATE2", this.f6999b);
        this.v.b("CHAT_BADGE_LOAD", this.f6999b);
    }

    /* access modifiers changed from: protected */
    public d t() {
        return new a(this);
    }

    @Deprecated
    public void setContentView(View view) {
        super.setContentView(view);
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        this.f6998a.setContentView(view);
        this.s.a((FrameLayout) this.f6998a, view, "Android");
        this.t.a(this.f6998a);
    }

    /* access modifiers changed from: private */
    public void b(int i) {
        v().a("ACTION_BAR_ACTION_BOX", i);
    }

    public com.shopee.app.ui.actionbar.a v() {
        d dVar = this.f6998a;
        if (dVar == null) {
            return null;
        }
        return dVar.getActionBar();
    }

    public com.shopee.app.ui.common.i w() {
        return this.f6998a.getShadowContainer();
    }

    public d x() {
        return this.f6998a;
    }

    public DrawerLayout y() {
        return this.f6998a.getDrawer();
    }

    public static class a extends d {
        public a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void a(a.C0296a aVar) {
            ((b) getContext()).a(aVar);
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return ((b) getContext()).u();
        }
    }

    /* renamed from: com.shopee.app.ui.a.b$b  reason: collision with other inner class name */
    public static class C0295b extends d {
        /* access modifiers changed from: protected */
        public void a(a.C0296a aVar) {
        }

        public C0295b(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public com.shopee.app.ui.actionbar.a a(Context context) {
            return new com.shopee.app.ui.actionbar.b(context);
        }

        public void b(a.C0296a aVar) {
            super.b(aVar);
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return ((b) getContext()).u();
        }
    }
}
