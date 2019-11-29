package com.airpay.paysdk.pay.c.a;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.airpay.paysdk.base.bean.BPOrderPrecheckData;
import com.airpay.paysdk.base.bean.BPTopupChannelWithEvents;
import com.airpay.paysdk.pay.c.a.a.c;
import com.airpay.paysdk.qrcode.model.BankAccountFullInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<a> f4189a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private BaseAdapter f4190b = new b();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f4191c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ListView f4192d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<a> f4193e;

    /* renamed from: f  reason: collision with root package name */
    private long f4194f = -1;

    /* renamed from: g  reason: collision with root package name */
    private BPTopupChannelWithEvents f4195g;
    private long h = -1;
    private boolean i = false;
    private long j = -1;
    private long k = -1;
    /* access modifiers changed from: private */
    public List<BPTopupChannelWithEvents> l;
    /* access modifiers changed from: private */
    public boolean m = false;
    /* access modifiers changed from: private */
    public boolean n = false;
    /* access modifiers changed from: private */
    public BPTopupChannelWithEvents o;
    /* access modifiers changed from: private */
    public int p = -1;
    private boolean q = false;
    private int r = this.p;
    private boolean s = this.n;
    /* access modifiers changed from: private */
    public boolean t = false;
    private boolean u;
    private boolean v;
    private boolean w = false;
    private String x = null;
    private AdapterView.OnItemClickListener y = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int headerViewsCount = i - d.this.f4192d.getHeaderViewsCount();
            if (headerViewsCount >= 0 && headerViewsCount < d.this.f4189a.size()) {
                a aVar = (a) d.this.f4189a.get(headerViewsCount);
                if (aVar.c()) {
                    int b2 = aVar.b();
                    if (b2 == 0) {
                        boolean unused = d.this.t = true;
                        d dVar = d.this;
                        boolean unused2 = dVar.n = !dVar.n;
                        d.this.a(true);
                        d.this.a();
                        d.this.c();
                    } else if (b2 != 1) {
                        if (b2 == 2) {
                            boolean unused3 = d.this.m = true;
                            d.this.a();
                        }
                    } else if (aVar.a().isAvailable()) {
                        boolean unused4 = d.this.t = true;
                        BPTopupChannelWithEvents unused5 = d.this.o = aVar.a();
                        d dVar2 = d.this;
                        int unused6 = dVar2.p = dVar2.l.indexOf(d.this.o);
                        d.this.a(false);
                        d.this.a();
                        d.this.c();
                    }
                }
            }
        }
    };

    public interface a {
        void a(boolean z, boolean z2, long j, BPTopupChannelWithEvents bPTopupChannelWithEvents, BPTopupChannelWithEvents bPTopupChannelWithEvents2);
    }

    private boolean a(int i2) {
        return true;
    }

    private boolean a(long j2) {
        return true;
    }

    public void a(ListView listView, Activity activity, a aVar) {
        this.f4191c = new WeakReference<>(activity);
        this.f4192d = listView;
        this.f4192d.setAdapter(this.f4190b);
        this.f4192d.setOnItemClickListener(this.y);
        this.f4193e = new WeakReference<>(aVar);
    }

    public void a(long j2, BPTopupChannelWithEvents bPTopupChannelWithEvents, long j3, long j4) {
        this.f4194f = j2;
        this.f4195g = bPTopupChannelWithEvents;
        this.h = j3;
        this.k = j4;
    }

    public void a(List<BPTopupChannelWithEvents> list) {
        this.l = list;
        List<BPTopupChannelWithEvents> list2 = this.l;
        if (list2 != null && !list2.isEmpty()) {
            int i2 = this.p;
            if (i2 != -1) {
                this.o = this.l.get(i2);
                c();
                a(true);
            }
        }
        this.o = null;
        a(true);
    }

    public void a(boolean z, BPOrderPrecheckData bPOrderPrecheckData) {
        this.u = z;
        this.v = bPOrderPrecheckData.allowPartialPayment();
        this.w = bPOrderPrecheckData.showAddBankCard();
        this.x = bPOrderPrecheckData.addBankCardMsg();
    }

    /* access modifiers changed from: private */
    public void c() {
        this.s = this.n;
        this.r = this.p;
    }

    private void d() {
        this.j = this.f4194f;
        BPTopupChannelWithEvents bPTopupChannelWithEvents = this.f4195g;
        boolean z = true;
        if (bPTopupChannelWithEvents == null || bPTopupChannelWithEvents.getTopupAmountInfo() == null) {
            long j2 = this.f4194f;
            long j3 = this.h;
            if (j2 >= j3) {
                this.i = true;
                this.j = j3;
            }
        } else if (this.f4194f >= this.f4195g.getTopupAmountInfo().topupPayment) {
            this.i = true;
            this.j = this.f4195g.getTopupAmountInfo().topupPayment;
        }
        if (!this.u || (!this.i && (this.f4194f <= 0 || !this.v))) {
            z = false;
        }
        this.q = z;
        if (!this.t) {
            e();
        }
    }

    private void e() {
        boolean z;
        int i2 = 0;
        boolean z2 = true;
        if (f()) {
            if (this.s) {
                if (this.i) {
                    this.n = true;
                    this.o = null;
                    this.p = -1;
                    c();
                    return;
                } else if (this.r != -1) {
                    this.n = true;
                }
            }
            if (this.i) {
                long j2 = this.k;
                if (j2 != -1 && this.j <= j2) {
                    this.n = true;
                    this.o = null;
                    this.p = -1;
                    c();
                    return;
                }
            }
            List<BPTopupChannelWithEvents> list = this.l;
            if (list == null || list.isEmpty()) {
                this.n = true;
                this.o = null;
                this.p = -1;
                c();
                return;
            }
        } else {
            this.n = false;
            this.s = false;
        }
        this.n = this.s && this.r != -1;
        if (this.r > -1) {
            int size = this.l.size();
            int i3 = this.r;
            if (size > i3) {
                BPTopupChannelWithEvents bPTopupChannelWithEvents = this.l.get(i3);
                if (a(bPTopupChannelWithEvents.getBankAccountInfo())) {
                    z = a(bPTopupChannelWithEvents.getBankAccountInfo().a());
                } else {
                    z = a(bPTopupChannelWithEvents.getBankAccountInfo().c());
                }
                z2 = !z;
                this.p = this.r;
                this.o = bPTopupChannelWithEvents;
                c();
            }
        }
        if (z2) {
            this.o = null;
            while (true) {
                if (i2 >= this.l.size()) {
                    break;
                }
                BPTopupChannelWithEvents bPTopupChannelWithEvents2 = this.l.get(i2);
                if (bPTopupChannelWithEvents2.isAvailable()) {
                    if (a(bPTopupChannelWithEvents2.getBankAccountInfo())) {
                        if (a(bPTopupChannelWithEvents2.getBankAccountInfo().a())) {
                            this.p = i2;
                            this.o = bPTopupChannelWithEvents2;
                            break;
                        }
                    } else if (a(bPTopupChannelWithEvents2.getBankAccountInfo().c())) {
                        this.p = i2;
                        this.o = bPTopupChannelWithEvents2;
                        break;
                    }
                }
                i2++;
            }
            c();
        }
    }

    private boolean a(BankAccountFullInfo bankAccountFullInfo) {
        return bankAccountFullInfo.e() != null && bankAccountFullInfo.e().b() == 101;
    }

    private boolean f() {
        return a(11000);
    }

    public void a() {
        boolean z;
        boolean z2;
        this.f4189a.clear();
        List<BPTopupChannelWithEvents> list = this.l;
        if (list != null) {
            Iterator<BPTopupChannelWithEvents> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getBankAccountInfo().f()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        d();
        this.f4189a.add(new b());
        if (this.q) {
            List<BPTopupChannelWithEvents> list2 = this.l;
            this.f4189a.add(new com.airpay.paysdk.pay.c.a.a.b(this.j, this.f4195g, this.i, z, this.n, 0, (!this.i || !(list2 != null && !list2.isEmpty())) ? 0 : 1));
            if (!this.i) {
                this.f4189a.add(new b());
            }
        }
        List<BPTopupChannelWithEvents> list3 = this.l;
        int size = list3 == null ? 0 : list3.size();
        List<BPTopupChannelWithEvents> list4 = this.l;
        if (list4 != null) {
            int i2 = 0;
            for (BPTopupChannelWithEvents next : list4) {
                if (this.m || i2 == 0) {
                    int i3 = (i2 != 0 || this.i) ? 2 : 0;
                    int i4 = ((this.m || i2 != 0) && (i2 != size + -1 || !z)) ? 1 : 0;
                    boolean z3 = !this.i && this.n && next.isCompatibleWithCash(this.f4194f);
                    List<a> list5 = this.f4189a;
                    z2 = z;
                    c cVar = r8;
                    c cVar2 = new c(next, next.equals(this.o), i3, i4, z3, this.f4194f);
                    list5.add(cVar);
                } else {
                    z2 = z;
                }
                i2++;
                z = z2;
            }
        }
        if (!this.m && size > 1) {
            this.f4189a.add(new c());
        }
        this.f4190b.notifyDataSetChanged();
        g();
    }

    private void g() {
        WeakReference<a> weakReference = this.f4193e;
        if (weakReference != null && weakReference.get() != null) {
            ((a) this.f4193e.get()).a(this.n, this.i, this.j, this.f4195g, this.o);
        }
    }

    public void b() {
        ListView listView = this.f4192d;
        if (listView != null) {
            listView.setAdapter((ListAdapter) null);
        }
        this.f4192d = null;
        this.f4191c = null;
        this.f4190b = null;
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (!z) {
            BPTopupChannelWithEvents bPTopupChannelWithEvents = this.o;
            if (bPTopupChannelWithEvents != null && !bPTopupChannelWithEvents.isCompatibleWithCash(this.f4194f)) {
                this.n = false;
            }
            if (this.i) {
                this.n = false;
            }
        } else if (this.n) {
            if (this.i) {
                this.o = null;
                this.p = -1;
            }
            BPTopupChannelWithEvents bPTopupChannelWithEvents2 = this.o;
            if (bPTopupChannelWithEvents2 != null && !bPTopupChannelWithEvents2.isCompatibleWithCash(this.f4194f)) {
                this.o = null;
                this.p = -1;
            }
        }
    }

    private class b extends BaseAdapter {
        public long getItemId(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 5;
        }

        private b() {
        }

        public int getCount() {
            return d.this.f4189a.size();
        }

        public Object getItem(int i) {
            return d.this.f4189a.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar = (a) d.this.f4189a.get(i);
            if (view == null) {
                view = aVar.a(LayoutInflater.from((Context) d.this.f4191c.get()), viewGroup);
            }
            aVar.a(view);
            return view;
        }

        public int getItemViewType(int i) {
            return ((a) d.this.f4189a.get(i)).b();
        }

        public boolean isEnabled(int i) {
            a aVar = (a) d.this.f4189a.get(i);
            return aVar != null && aVar.c();
        }
    }
}
