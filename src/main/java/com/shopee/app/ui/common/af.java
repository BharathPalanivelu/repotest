package com.shopee.app.ui.common;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.bi;

public class af extends q<ag> implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final bi f21133a;

    public void a() {
    }

    public void b() {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public af(bi biVar) {
        this.f21133a = biVar;
    }

    public void afterTextChanged(Editable editable) {
        boolean z = editable == null || TextUtils.isEmpty(editable.toString().trim());
        if (z && ((ag) this.f19220b).f()) {
            ((ag) this.f19220b).a(false);
            ((ag) this.f19220b).h();
        }
        if (!z && !((ag) this.f19220b).f()) {
            ((ag) this.f19220b).a(true);
            ((ag) this.f19220b).g();
        }
    }

    public void a(String str, e[] eVarArr) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                this.f21133a.a("ON_SEND", new a(trim));
                this.f21133a.a("SEND_TEXT_COMMENT", new a(new Pair(trim, eVarArr)));
                ((ag) this.f19220b).b();
            }
        }
    }

    public void e() {
        this.f21133a.a("PHOTO_ADD", new a());
    }

    public void f() {
        this.f21133a.a("PHONE", new a());
    }
}
