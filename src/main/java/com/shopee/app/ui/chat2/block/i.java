package com.shopee.app.ui.chat2.block;

import com.garena.a.a.a.b;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import com.shopee.app.network.c.d.a;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.chat2.block.c;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class i extends q<l> {

    /* renamed from: a  reason: collision with root package name */
    private final com.garena.android.appkit.b.i f20324a;

    /* renamed from: c  reason: collision with root package name */
    private final n f20325c;

    /* renamed from: d  reason: collision with root package name */
    private final r f20326d;

    /* renamed from: e  reason: collision with root package name */
    private List<UserBriefInfo> f20327e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private c f20328f;

    public i(n nVar, r rVar) {
        this.f20325c = nVar;
        this.f20324a = b.a(this);
        this.f20326d = rVar;
    }

    public void a() {
        this.f20328f = new c(((l) this.f19220b).getContext(), (c.a) this.f19220b);
        this.f20324a.a();
    }

    public void b() {
        this.f20324a.b();
    }

    public void d() {
        this.f20324a.d();
    }

    public void c() {
        this.f20324a.c();
    }

    /* access modifiers changed from: package-private */
    public void a(UserBriefInfo userBriefInfo) {
        if (userBriefInfo.isChatBlocked()) {
            this.f20328f.a(userBriefInfo.getUserId(), userBriefInfo.getUserName());
        } else {
            this.f20328f.b(userBriefInfo.getUserId(), userBriefInfo.getUserName());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<UserBriefInfo> list) {
        ((l) this.f19220b).d();
        ((l) this.f19220b).a(list);
        this.f20327e = list;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        g();
    }

    /* access modifiers changed from: package-private */
    public void a(DBBlockUser dBBlockUser) {
        int i = -1;
        for (UserBriefInfo next : this.f20327e) {
            if (next.getUserId() == dBBlockUser.a()) {
                i = this.f20327e.indexOf(next);
            }
        }
        this.f20327e.remove(i);
        ((l) this.f19220b).d();
        ((l) this.f19220b).a(this.f20327e);
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        ((l) this.f19220b).d();
        this.f20328f.a(aVar);
    }

    private void g() {
        this.f20326d.a();
    }

    public void f() {
        g();
        ((l) this.f19220b).x_();
        new com.shopee.app.network.d.c.b().g();
    }
}
