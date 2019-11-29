package com.shopee.app.ui.shopassistant.shopSetting;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.network.c.d.a;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.bm;
import com.shopee.id.R;
import com.shopee.protocol.action.Errcode;

public class d extends q<f> {

    /* renamed from: a  reason: collision with root package name */
    i f25555a = b.a(this);

    /* renamed from: c  reason: collision with root package name */
    private final a f25556c;

    public d(a aVar) {
        this.f25556c = aVar;
    }

    public void a() {
        this.f25555a.a();
    }

    public void c() {
        this.f25555a.c();
    }

    public void d() {
        this.f25555a.d();
    }

    public void b() {
        this.f25555a.b();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        ((f) this.f19220b).e();
    }

    /* access modifiers changed from: package-private */
    public void f() {
        ((f) this.f19220b).c();
        ((f) this.f19220b).f();
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        String str;
        ((f) this.f19220b).c();
        if (aVar.f17892a == Errcode.MESSAGE_CENSORED.getValue()) {
            bm.b(((f) this.f19220b).getContext(), com.garena.android.appkit.tools.b.e(R.string.sp_label_message_auto_reply_violate_t_and_c));
            return;
        }
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            str = a(aVar.f17892a);
        }
        ((f) this.f19220b).a(str);
    }

    private String a(int i) {
        if (i != -100) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        }
        return com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
    }

    public void a(String str) {
        this.f25556c.a(str);
    }
}
