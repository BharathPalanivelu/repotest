package com.shopee.app.ui.chat2.send;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.garena.android.appkit.b.a;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.e;
import com.shopee.app.util.bi;

public class d extends q<e> implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final bi f20928a;

    public void a() {
    }

    public void b() {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public d(bi biVar) {
        this.f20928a = biVar;
    }

    public void afterTextChanged(Editable editable) {
        boolean z = editable == null || TextUtils.isEmpty(editable.toString().trim());
        if (z && ((e) this.f19220b).f()) {
            ((e) this.f19220b).b(false);
            ((e) this.f19220b).h();
        }
        if (!z && !((e) this.f19220b).f()) {
            ((e) this.f19220b).b(true);
            ((e) this.f19220b).g();
        }
    }

    public void a(String str, e[] eVarArr) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                this.f20928a.a("ON_SEND", new a(trim));
                ((e) this.f19220b).e();
            }
        }
    }

    public void e() {
        this.f20928a.a("MORE_BTN", new a());
    }

    public void f() {
        this.f20928a.a("PANEL_CLOSE", new a());
    }

    public void g() {
        this.f20928a.a("STICKER_BTN", new a());
    }

    public void h() {
        this.f20928a.a("SHOW_KEYBOARD", new a());
    }
}
