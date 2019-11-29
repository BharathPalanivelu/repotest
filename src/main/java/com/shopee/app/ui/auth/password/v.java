package com.shopee.app.ui.auth.password;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.afollestad.materialdialogs.f;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.a.b;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.h.q;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.as;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;

public class v extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    MaterialEditText f19663a;

    /* renamed from: b  reason: collision with root package name */
    MaterialEditText f19664b;

    /* renamed from: c  reason: collision with root package name */
    MaterialEditText f19665c;

    /* renamed from: d  reason: collision with root package name */
    Button f19666d;

    /* renamed from: e  reason: collision with root package name */
    t f19667e;

    /* renamed from: f  reason: collision with root package name */
    bc f19668f;

    /* renamed from: g  reason: collision with root package name */
    Activity f19669g;
    r h;
    ak i;
    UserInfo j;
    private final String k;
    private final String l;
    private final String m;

    public v(Context context, String str, String str2, String str3) {
        super(context);
        this.k = str;
        this.l = str2;
        this.m = str3;
        ((i) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f19668f.a(this.f19667e);
        this.f19667e.a(this);
        this.f19665c.setTypeface(Typeface.DEFAULT);
        this.f19663a.setTypeface(Typeface.DEFAULT);
        this.f19665c.b((b) new a(com.garena.android.appkit.tools.b.e(R.string.sp_password_not_match)));
        this.f19663a.b((b) j.b());
        if (!TextUtils.isEmpty(this.k)) {
            this.f19664b.setText(as.d(this.k));
        } else {
            this.f19664b.setVisibility(8);
        }
        if (this.j.hasPassword()) {
            this.f19666d.setText(com.garena.android.appkit.tools.b.e(R.string.sp_reset));
        } else {
            this.f19666d.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_set));
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f19665c.b() && this.f19663a.b()) {
            if (this.j.isLoggedIn()) {
                e();
            } else {
                f();
            }
        }
    }

    private void e() {
        this.f19667e.b(this.k, this.l, this.m, this.f19665c.getText().toString());
    }

    private void f() {
        this.f19667e.a(this.k, this.l, this.m, this.f19665c.getText().toString());
    }

    public void c() {
        this.h.a();
    }

    public void d() {
        this.h.b();
    }

    public void a(ResponseCommon responseCommon) {
        if (this.j.isLoggedIn()) {
            this.h.b();
            com.shopee.app.c.a.a(getContext());
            com.shopee.app.ui.dialog.a.a(getContext(), 0, (int) R.string.sp_password_changed_popup_text, 0, (int) R.string.sp_label_ok, (f.b) new f.b() {
                public void onNegative(f fVar) {
                    v.this.h.a();
                    fVar.dismiss();
                    ar.k();
                }

                public void onPositive(f fVar) {
                    v.this.h.a();
                    fVar.dismiss();
                    ar.k();
                }
            }, false);
            return;
        }
        this.h.b();
        com.shopee.app.h.r.a().b((int) R.string.sp_label_reset_password_success);
        if (responseCommon == null || responseCommon.phone_auto_converted == null || !responseCommon.phone_auto_converted.booleanValue()) {
            this.f19669g.setResult(-1);
            this.f19669g.finish();
            return;
        }
        com.shopee.app.ui.dialog.a.a((Context) this.f19669g, this.k, (DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                v.this.f19669g.setResult(-1);
                v.this.f19669g.finish();
            }
        });
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    private class a extends b {
        public a(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            return charSequence.toString().equals(v.this.f19663a.getText().toString()) && !TextUtils.isEmpty(charSequence);
        }
    }
}
