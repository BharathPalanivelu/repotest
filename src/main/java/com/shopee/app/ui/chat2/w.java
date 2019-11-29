package com.shopee.app.ui.chat2;

import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.bm;
import com.shopee.id.R;
import com.shopee.protocol.action.Errcode;

public class w extends q<y> {

    /* renamed from: a  reason: collision with root package name */
    private final i f20949a = b.a(this);

    /* renamed from: c  reason: collision with root package name */
    private final s f20950c;

    public w(s sVar) {
        this.f20950c = sVar;
    }

    public void a() {
        this.f20949a.a();
    }

    public void c() {
        super.c();
        this.f20949a.c();
    }

    public void d() {
        super.d();
        this.f20949a.d();
    }

    public void b() {
        this.f20949a.b();
    }

    /* access modifiers changed from: package-private */
    public void a(Pair pair) {
        int intValue = ((Integer) pair.first).intValue();
        if (intValue == -1101) {
            ((y) this.f19220b).i();
        } else if (intValue == -1001) {
            ((y) this.f19220b).g();
        }
    }

    public void a(String str) {
        ((y) this.f19220b).b();
        this.f20950c.a(str);
    }

    public void a(int i, String str) {
        ((y) this.f19220b).b();
        this.f20950c.a(i, str);
    }

    public void a(int i) {
        ((y) this.f19220b).b();
        this.f20950c.a(i);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        ((y) this.f19220b).c();
        ((y) this.f19220b).h();
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        ((y) this.f19220b).c();
        if (i == Errcode.MESSAGE_CENSORED.getValue()) {
            bm.b(((y) this.f19220b).getContext(), com.garena.android.appkit.tools.b.e(R.string.sp_label_message_shortcut_violate_t_and_c));
        } else {
            ((y) this.f19220b).a(com.garena.android.appkit.tools.b.e(R.string.sp_network_error));
        }
    }
}
