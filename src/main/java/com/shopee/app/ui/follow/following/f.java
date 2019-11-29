package com.shopee.app.ui.follow.following;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.shopee.app.application.a.b;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.h;
import com.shopee.app.data.viewmodel.RecommendBannerData;
import com.shopee.app.f.a;
import com.shopee.app.g.d;
import com.shopee.app.h.m;
import com.shopee.app.h.q;
import com.shopee.app.ui.a.o;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.s;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class f extends FrameLayout implements o {

    /* renamed from: a  reason: collision with root package name */
    ListView f21634a;

    /* renamed from: b  reason: collision with root package name */
    r f21635b;

    /* renamed from: c  reason: collision with root package name */
    x f21636c;

    /* renamed from: d  reason: collision with root package name */
    d f21637d;

    /* renamed from: e  reason: collision with root package name */
    bc f21638e;

    /* renamed from: f  reason: collision with root package name */
    ak f21639f;

    /* renamed from: g  reason: collision with root package name */
    m f21640g;
    h h;
    RegionConfig i;
    b j;
    Activity k;
    be l;
    al m;
    s n;
    private int o = 0;
    private int p = 0;
    private List<t> q = new ArrayList();

    public f(Context context) {
        super(context);
        ((com.shopee.app.ui.follow.b) ((x) context).b()).a(this);
    }

    public void a(int i2, int i3) {
        for (t next : this.q) {
            if (next.m() == i2) {
                if (i2 == 2) {
                    a(next, i3);
                    return;
                } else if (i2 == 4) {
                    b(next, i3);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21638e.a(this.f21636c);
        this.f21636c.a(this);
        this.f21634a.setAdapter(this.f21637d);
        this.f21634a.setEmptyView(findViewById(R.id.emptyView));
        this.f21636c.e();
        this.f21636c.f();
        if (this.q.size() == 0) {
            b();
        }
        this.f21637d.a(new ArrayList(this.q));
        this.f21637d.notifyDataSetChanged();
    }

    public void b() {
        this.q = new ArrayList();
        if (this.n.a("find_friend_by_fb_and_contact")) {
            t tVar = new t();
            tVar.f(1);
            tVar.d(com.garena.android.appkit.tools.b.e(R.string.sp_find_facebook_friends));
            tVar.e(R.drawable.com_garena_shopee_ic_addfriend_fb);
            tVar.h(2);
            this.q.add(tVar);
            t tVar2 = new t();
            tVar2.f(1);
            tVar2.d(com.garena.android.appkit.tools.b.e(R.string.sp_find_contacts));
            tVar2.e(R.drawable.com_garena_shopee_ic_addfriend_contact);
            tVar2.h(4);
            this.q.add(tVar2);
        }
        t tVar3 = new t();
        tVar3.d(com.garena.android.appkit.tools.b.e(R.string.sp_recommended_friends));
        tVar3.f(0);
        this.q.add(tVar3);
        List<RecommendBannerData> a2 = this.h.a();
        if (a2.size() > 0) {
            for (RecommendBannerData a3 : a2) {
                t tVar4 = new t();
                tVar4.f(4);
                tVar4.a(a3);
                this.q.add(tVar4);
            }
        }
        a((List<t>) new ArrayList());
    }

    private void h() {
        if (a.a().b()) {
            e();
            return;
        }
        this.j.b();
        a.a().a(this.k);
    }

    public void e() {
        this.f21636c.g();
        this.f21639f.a(2, this.o);
    }

    private void i() {
        if (Build.VERSION.SDK_INT >= 23) {
            d.a(this.k, new String[]{"android.permission.READ_CONTACTS"}, 1114, 0, 0, R.string.sp_no_contact_access, R.string.sp_no_contact_access_hint, new d.a() {
                public void b() {
                }

                public void c() {
                }

                public void a() {
                    f.this.getContact();
                }
            });
        } else if (this.m.r()) {
            getContact();
        } else {
            com.shopee.app.ui.dialog.a.a((Context) this.k, (int) R.string.sp_warning_access_contacts, (int) R.string.sp_deny_access_contacts, (int) R.string.sp_label_yes, (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    f.this.m.d(true);
                    f.this.getContact();
                }
            });
        }
    }

    public void getContact() {
        this.f21636c.h();
        this.f21639f.a(4, this.p);
    }

    public void x_() {
        this.f21635b.a();
    }

    public void d() {
        this.f21635b.b();
    }

    public void a(List<t> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(this.q);
            arrayList.addAll(list);
            this.f21637d.a(arrayList);
            this.f21637d.notifyDataSetChanged();
        }
        this.f21637d.notifyDataSetChanged();
    }

    public void a(int i2) {
        this.f21637d.a(i2);
        this.f21637d.notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public void a(final t tVar) {
        if (this.l.m()) {
            com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_warning_invisible_to_contact, (int) R.string.sp_label_may_be_later, (int) R.string.sp_label_yes, (a.C0318a) new a.C0318a() {
                public void onPositive() {
                    f.this.l.n();
                    f.this.f21636c.a(false, tVar);
                }

                public void onNegative() {
                    f.this.l.n();
                    f.this.f21636c.a(true, tVar);
                }
            });
        } else {
            b(tVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(t tVar) {
        if (tVar.j() == 2) {
            this.f21639f.b(tVar.b());
        } else if (tVar.j() == 1) {
            int m2 = tVar.m();
            if (m2 == 2) {
                h();
            } else if (m2 == 4) {
                i();
            }
        }
    }

    public void b(int i2) {
        this.f21637d.b(i2);
        this.f21637d.notifyDataSetChanged();
    }

    public void f() {
        this.f21639f.a((String) null, false, "posts");
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putInt("fbCount", this.o);
        bundle.putInt("contactCount", this.p);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.o = bundle.getInt("fbCount", 0);
            this.p = bundle.getInt("contactCount", 0);
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void g() {
        this.f21639f.a("DATAPOINT_POPUP", 3, "", "");
    }

    private void a(t tVar, int i2) {
        this.o = i2;
        if (i2 == 0) {
            tVar.d(com.garena.android.appkit.tools.b.e(R.string.sp_find_facebook_friends));
        } else if (i2 == 1) {
            tVar.d(com.garena.android.appkit.tools.b.e(R.string.sp_facebook_friend));
        } else {
            tVar.d(com.garena.android.appkit.tools.b.a(R.string.sp_facebook_friends, Integer.valueOf(i2)));
        }
        this.f21637d.notifyDataSetChanged();
    }

    private void b(t tVar, int i2) {
        this.p = i2;
        if (i2 == 0) {
            tVar.d(com.garena.android.appkit.tools.b.e(R.string.sp_find_contacts));
        } else if (i2 == 1) {
            tVar.d(com.garena.android.appkit.tools.b.e(R.string.sp_contact_friend));
        } else {
            tVar.d(com.garena.android.appkit.tools.b.a(R.string.sp_contact_friends, Integer.valueOf(i2)));
        }
        this.f21637d.notifyDataSetChanged();
    }
}
