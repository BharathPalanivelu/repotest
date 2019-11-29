package com.shopee.app.ui.shopassistant.chatSetting;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.h.q;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.setting.cell.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class f extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ak f25417a;

    /* renamed from: b  reason: collision with root package name */
    r f25418b;

    /* renamed from: c  reason: collision with root package name */
    Activity f25419c;

    /* renamed from: d  reason: collision with root package name */
    d f25420d;

    /* renamed from: e  reason: collision with root package name */
    bc f25421e;

    /* renamed from: f  reason: collision with root package name */
    a f25422f;

    /* renamed from: g  reason: collision with root package name */
    a f25423g;
    TextView h;
    View i;
    private View.OnClickListener j = new View.OnClickListener() {
        public void onClick(View view) {
            f.this.g();
        }
    };

    public f(Context context) {
        super(context);
        ((b) ((x) context).b()).a(this);
    }

    public void a() {
        this.f25418b.a();
    }

    public void b() {
        this.f25418b.b();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f25421e.a(this.f25420d);
        this.f25420d.a(this);
        this.f25420d.e();
        this.f25422f.setOnClickListener(this.j);
        this.f25423g.setOnClickListener(this.j);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f25417a.o(this.h.getText().toString());
    }

    public void e() {
        g();
        this.f25419c.finish();
    }

    /* access modifiers changed from: private */
    public void g() {
        String str;
        a();
        if (!TextUtils.isEmpty(this.h.getText()) || !this.f25422f.c()) {
            str = this.h.getText().toString();
        } else {
            str = b.e(R.string.sp_auto_reply_default);
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            this.f25422f.setTextSecondary(b.e(R.string.sp_auto_reply_sub_on));
            this.h.setText(str);
        }
        if (this.f25422f.getVisibility() == 8) {
            str = null;
        }
        if (this.f25422f.c()) {
            this.h.setTextColor(b.a(R.color.black87));
        } else {
            this.h.setTextColor(b.a(R.color.black54));
        }
        this.f25420d.a(this.f25422f.c(), str, !this.f25423g.c());
    }

    public void a(ShopDetail shopDetail) {
        this.f25422f.setOnClickListener((View.OnClickListener) null);
        this.f25423g.setOnClickListener((View.OnClickListener) null);
        if (shopDetail.isSeller()) {
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            this.f25422f.setVisibility(0);
        } else {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.f25422f.setVisibility(8);
        }
        this.f25422f.setChecked(shopDetail.isShopAutoMsgOn());
        boolean z = true;
        this.f25423g.setChecked(!shopDetail.isChatDisabled());
        this.f25423g.setOnClickListener(this.j);
        this.f25422f.setOnClickListener(this.j);
        if (shopDetail.isShopAutoMsgOn() || !TextUtils.isEmpty(shopDetail.getShopAutoMsg())) {
            z = false;
        }
        if (z) {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.h.setText("");
            this.f25422f.setTextSecondary(b.e(R.string.sp_auto_reply_off));
        } else {
            this.h.setVisibility(0);
            this.h.setVisibility(0);
            this.h.setText(shopDetail.getShopAutoMsg());
            this.f25422f.setTextSecondary(b.e(R.string.sp_auto_reply_sub_on));
        }
        if (this.f25422f.c()) {
            this.h.setTextColor(b.a(R.color.black87));
        } else {
            this.h.setTextColor(b.a(R.color.black54));
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f25417a.ao();
    }

    public void a(String str) {
        q.a((View) this, str);
        this.f25420d.f();
    }

    public void b(String str) {
        this.h.setText(str);
    }
}
