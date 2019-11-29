package com.shopee.app.ui.actionbox2;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.ai;
import com.shopee.app.d.c.bn;
import com.shopee.app.d.c.bv;
import com.shopee.app.d.c.u;
import com.shopee.app.d.c.w;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.ba;
import com.shopee.app.network.d.r;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.ae;
import com.shopee.app.util.af;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class d extends q<f> implements ae.a {

    /* renamed from: a  reason: collision with root package name */
    private final ActionRequiredCounter f19380a;

    /* renamed from: c  reason: collision with root package name */
    private final ActivityCounter f19381c;

    /* renamed from: d  reason: collision with root package name */
    private final u f19382d;

    /* renamed from: e  reason: collision with root package name */
    private final bn f19383e;

    /* renamed from: f  reason: collision with root package name */
    private bv f19384f;

    /* renamed from: g  reason: collision with root package name */
    private ai f19385g;
    private List<ActionContentInfo> h;
    private int i = 0;
    private int j;
    private int k;
    private w l;
    private i m;
    private HashMap<Long, a> n;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<ActionContentInfo> f19386a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f19387b;
    }

    public d(ActionRequiredCounter actionRequiredCounter, bn bnVar, w wVar, ActivityCounter activityCounter, u uVar, bv bvVar, ai aiVar) {
        this.f19380a = actionRequiredCounter;
        this.f19383e = bnVar;
        this.l = wVar;
        this.f19381c = activityCounter;
        this.f19382d = uVar;
        this.f19384f = bvVar;
        this.f19385g = aiVar;
        this.n = new HashMap<>();
        this.m = b.a(this);
    }

    public void a(int i2) {
        this.h = new ArrayList();
        this.k = i2;
        f();
        n();
        e();
        ((f) this.f19220b).g();
        ((f) this.f19220b).j();
    }

    public void e() {
        long j2;
        if (!af.a(this.h)) {
            j2 = this.h.get(this.h.size() - 1).getId();
        } else {
            j2 = 0;
        }
        com.shopee.app.network.d.a.b bVar = new com.shopee.app.network.d.a.b();
        o.a().a((az) bVar);
        bVar.a(j2, 10, this.k);
        m();
    }

    private void m() {
        if (this.k == 4) {
            com.shopee.app.network.d.a.b bVar = new com.shopee.app.network.d.a.b();
            bVar.a(2);
            o.a().a((az) bVar);
            bVar.a(0, 1, 2);
            com.shopee.app.network.d.a.b bVar2 = new com.shopee.app.network.d.a.b();
            bVar2.a(1);
            o.a().a((az) bVar2);
            bVar2.a(0, 1, 1);
            com.shopee.app.network.d.a.b bVar3 = new com.shopee.app.network.d.a.b();
            bVar3.a(6);
            o.a().a((az) bVar3);
            bVar3.a(0, 1, 6);
            com.shopee.app.network.d.a.b bVar4 = new com.shopee.app.network.d.a.b();
            bVar4.a(7);
            o.a().a((az) bVar4);
            bVar4.a(0, 1, 7);
            com.shopee.app.network.d.a.b bVar5 = new com.shopee.app.network.d.a.b();
            bVar5.a(8);
            o.a().a((az) bVar5);
            bVar5.a(0, 1, 8);
            com.shopee.app.network.d.a.b bVar6 = new com.shopee.app.network.d.a.b();
            bVar6.a(9);
            o.a().a((az) bVar6);
            bVar6.a(0, 1, 9);
            com.shopee.app.network.d.a.b bVar7 = new com.shopee.app.network.d.a.b();
            bVar7.a(10);
            o.a().a((az) bVar7);
            bVar7.a(0, 1, 10);
            com.shopee.app.network.d.a.b bVar8 = new com.shopee.app.network.d.a.b();
            bVar8.a(11);
            o.a().a((az) bVar8);
            bVar8.a(0, 1, 11);
            com.shopee.app.network.d.a.b bVar9 = new com.shopee.app.network.d.a.b();
            bVar9.a(12);
            o.a().a((az) bVar9);
            bVar9.a(0, 1, 12);
            com.shopee.app.network.d.a.b bVar10 = new com.shopee.app.network.d.a.b();
            bVar10.a(13);
            o.a().a((az) bVar10);
            bVar10.a(0, 1, 13);
            r rVar = new r();
            o.a().a((az) rVar);
            rVar.a(0, 1);
        }
    }

    public void a(long j2) {
        this.f19382d.a(this.k, this.n);
    }

    public void f() {
        this.f19382d.a(this.k, this.n);
    }

    private void n() {
        if (this.k == 4) {
            this.f19383e.a();
            this.l.a();
            this.f19384f.a();
        }
    }

    public void a() {
        this.m.a();
    }

    public void b() {
        this.m.b();
        if (this.k != 4) {
            k();
        }
    }

    public void c() {
        this.m.c();
    }

    public void d() {
        this.m.d();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        a(this.k);
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Long, Integer> pair) {
        a(this.k);
        if (((Integer) pair.second).intValue() == this.k) {
            long longValue = ((Long) pair.first).longValue();
            if (this.n.containsKey(Long.valueOf(longValue)) && this.n.get(Long.valueOf(longValue)).f19387b) {
                com.shopee.app.network.d.a.b bVar = new com.shopee.app.network.d.a.b();
                o.a().a((az) bVar);
                bVar.a(longValue, this.k);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(long j2) {
        ((f) this.f19220b).f();
        e(j2);
        a(this.k);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        ((f) this.f19220b).f();
        o();
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        o();
    }

    private void o() {
        ((f) this.f19220b).f();
        ((f) this.f19220b).g();
        a(this.k);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (aVar.f17892a != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((f) this.f19220b).f();
        ((f) this.f19220b).b(str);
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (aVar.f17892a != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((f) this.f19220b).f();
        ((f) this.f19220b).b(str);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        f();
    }

    /* access modifiers changed from: package-private */
    public void a(long j2, long j3) {
        ((f) this.f19220b).e();
        ba baVar = new ba();
        o.a().a((az) baVar);
        baVar.a(j2, j3);
    }

    /* access modifiers changed from: package-private */
    public void i() {
        ((f) this.f19220b).l();
    }

    /* access modifiers changed from: package-private */
    public void a(ActionRequiredCounter actionRequiredCounter) {
        ((f) this.f19220b).g();
    }

    /* access modifiers changed from: package-private */
    public void a(ActivityCounter activityCounter) {
        ((f) this.f19220b).g();
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        if (i2 == -1) {
            n();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<ActivityItemInfo> list) {
        if (!af.a(list)) {
            ((f) this.f19220b).a(3, list.get(0).wrapMsg());
        }
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        ((f) this.f19220b).a(str);
    }

    /* access modifiers changed from: package-private */
    public void a(bn.b bVar) {
        if (this.k == 4) {
            ((f) this.f19220b).a(2, bVar.f16607b);
            ((f) this.f19220b).a(1, bVar.f16606a);
            ((f) this.f19220b).a(6, bVar.f16608c);
            ((f) this.f19220b).a(8, bVar.f16609d);
            ((f) this.f19220b).a(7, bVar.f16610e);
            ((f) this.f19220b).a(9, bVar.f16611f);
            ((f) this.f19220b).a(10, bVar.f16612g);
            ((f) this.f19220b).a(11, bVar.h);
            ((f) this.f19220b).a(12, bVar.i);
            ((f) this.f19220b).a(13, bVar.j);
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        ((f) this.f19220b).k();
        f();
        n();
    }

    /* access modifiers changed from: package-private */
    public void c(long j2) {
        ((f) this.f19220b).k();
        this.f19385g.a(j2);
    }

    /* access modifiers changed from: package-private */
    public void b(Pair<Long, Integer> pair) {
        int intValue = ((Integer) pair.second).intValue();
        long longValue = ((Long) pair.first).longValue();
        n();
        if (this.k == intValue) {
            ((f) this.f19220b).k();
            a(longValue);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(long j2) {
        this.f19385g.a(j2);
    }

    /* access modifiers changed from: package-private */
    public void c(Pair<List<ActionContentInfo>, u.a> pair) {
        if (((u.a) pair.second).f17126a == this.k) {
            ((f) this.f19220b).k();
            this.h = new ArrayList((Collection) pair.first);
            ((f) this.f19220b).a(this.h);
            if (this.h.size() + 1 == this.j) {
                ((f) this.f19220b).h();
            } else {
                ((f) this.f19220b).i();
            }
            ((f) this.f19220b).g();
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Pair<List<ActionContentInfo>, Long> pair) {
        if (this.n.containsKey(pair.second)) {
            this.n.get(pair.second).f19386a = (List) pair.first;
        } else {
            a aVar = new a();
            aVar.f19386a = (List) pair.first;
            this.n.put(pair.second, aVar);
        }
        f();
    }

    /* access modifiers changed from: package-private */
    public void a(MeCounter meCounter) {
        ((f) this.f19220b).a(meCounter);
    }

    public void e(long j2) {
        this.f19380a.remove(j2, this.k);
        ((f) this.f19220b).g();
    }

    public void k() {
        this.f19380a.clear(this.k);
        ((f) this.f19220b).g();
    }

    public void l() {
        this.f19380a.clear(this.k);
        ((f) this.f19220b).g();
        f();
    }

    public void d(int i2) {
        this.j = i2;
        this.i += 10;
        e();
    }

    public void a(ActionContentInfo actionContentInfo, boolean z) {
        if (actionContentInfo != null) {
            if (this.n.containsKey(Long.valueOf(actionContentInfo.getGroupId()))) {
                this.n.get(Long.valueOf(actionContentInfo.getGroupId())).f19387b = z;
            } else {
                a aVar = new a();
                aVar.f19387b = z;
                this.n.put(Long.valueOf(actionContentInfo.getGroupId()), aVar);
                this.f19385g.a(actionContentInfo.getGroupId());
            }
            if (z) {
                com.shopee.app.network.d.a.b bVar = new com.shopee.app.network.d.a.b();
                o.a().a((az) bVar);
                bVar.a(actionContentInfo.getGroupId(), this.k);
            }
        }
    }
}
