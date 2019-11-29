package com.shopee.app.ui.auth.password;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.h.q;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;

public class d extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    MaterialEditText f19600a;

    /* renamed from: b  reason: collision with root package name */
    Button f19601b;

    /* renamed from: c  reason: collision with root package name */
    RobotoTextView f19602c;

    /* renamed from: d  reason: collision with root package name */
    String f19603d;

    /* renamed from: e  reason: collision with root package name */
    String f19604e;

    /* renamed from: f  reason: collision with root package name */
    b f19605f;

    /* renamed from: g  reason: collision with root package name */
    UserInfo f19606g;
    r h;
    ak i;
    bc j;
    Activity k;

    public d(Context context) {
        super(context);
        ((i) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.j.a(this.f19605f);
        this.f19605f.a(this);
        this.f19601b.setText(this.f19603d);
        this.f19600a.setTypeface(Typeface.DEFAULT);
        this.f19600a.setHint(this.f19604e);
        this.f19600a.b((b) h.b());
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f19600a.b()) {
            this.f19605f.a(this.f19600a.getText().toString());
        }
    }

    public void c() {
        Intent intent = new Intent();
        intent.putExtra("password", this.f19600a.getText().toString());
        this.k.setResult(-1, intent);
        this.k.finish();
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void d() {
        this.h.a();
    }

    public void e() {
        this.h.b();
    }
}
