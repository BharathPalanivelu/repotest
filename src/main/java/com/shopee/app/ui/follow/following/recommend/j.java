package com.shopee.app.ui.follow.following.recommend;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.model.AppInviteContent;
import com.facebook.share.widget.AppInviteDialog;
import com.garena.android.appkit.tools.b;
import com.shopee.app.database.orm.bean.DBContactInfo;
import com.shopee.app.h.q;
import com.shopee.app.ui.a.o;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class j extends FrameLayout implements o {
    private static List<DBContactInfo> n = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    TextView f21714a;

    /* renamed from: b  reason: collision with root package name */
    r f21715b;

    /* renamed from: c  reason: collision with root package name */
    d f21716c;

    /* renamed from: d  reason: collision with root package name */
    Activity f21717d;

    /* renamed from: e  reason: collision with root package name */
    bc f21718e;

    /* renamed from: f  reason: collision with root package name */
    ak f21719f;

    /* renamed from: g  reason: collision with root package name */
    o f21720g;
    ListView h;
    TextView i;
    RelativeLayout j;
    private int k;
    private p l;
    private int m;

    public j(Context context, int i2, int i3) {
        super(context);
        this.k = i2;
        this.m = i3;
        ((i) ((x) context).b()).a(this);
    }

    public void x_() {
        this.f21715b.a();
    }

    public void d() {
        this.f21715b.b();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21716c.b(this.k);
    }

    private void h() {
        if (AppInviteDialog.canShow()) {
            new AppInviteDialog(this.f21717d).show(new AppInviteContent.Builder().setApplinkUrl(b.e(R.string.shopee_app_link)).setPreviewImageUrl("http://content.garena.com/shopee/conf_a/8770A10BD9D2E72B.png").build());
            return;
        }
        q.a((View) this, (int) R.string.sp_function_not_available);
    }

    public void b() {
        this.f21720g.b();
        this.j.setVisibility(8);
        this.f21720g.notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public void a(DBContactInfo dBContactInfo) {
        if (dBContactInfo.g() == 2) {
            this.f21719f.b(dBContactInfo.d());
        } else if (dBContactInfo.g() == 1) {
            h();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f21718e.a(this.f21716c);
        this.f21716c.a(this);
        this.h.setAdapter(this.f21720g);
        this.f21716c.a(this.k);
        d(this.k);
        i();
        e(this.k);
        this.l = new p(this.h);
        this.l.a((p.a) this.f21716c);
    }

    private void d(int i2) {
        if (i2 == 2) {
            this.f21714a.setText(b.e(R.string.sp_no_facebook_friends));
        } else if (i2 != 4) {
            this.f21714a.setText(b.e(R.string.sp_no_beetalk_friends));
        } else {
            this.f21714a.setText(b.e(R.string.sp_no_contact));
        }
    }

    private void e(int i2) {
        String str;
        int i3 = this.m;
        if (i3 == 1) {
            if (i2 == 2) {
                str = b.e(R.string.sp_fb_friend_shopee);
            } else if (i2 != 4) {
                str = b.e(R.string.sp_beetalk_friend_shopee);
            } else {
                str = b.e(R.string.sp_contact_friend_shopee);
            }
        } else if (i2 == 2) {
            str = b.a(R.string.sp_fb_friends_shopee, Integer.valueOf(i3));
        } else if (i2 != 4) {
            str = b.a(R.string.sp_beetalk_friends_shopee, Integer.valueOf(i3));
        } else {
            str = b.a(R.string.sp_contact_friends_shopee, Integer.valueOf(i3));
        }
        this.i.setText(str);
    }

    public void f() {
        this.l.c();
    }

    public void g() {
        this.l.b();
    }

    public void a(int i2) {
        this.f21720g.b(i2);
        this.f21720g.notifyDataSetChanged();
        this.j.setVisibility(0);
    }

    public void b(int i2) {
        this.f21720g.a(i2);
        this.f21720g.notifyDataSetChanged();
        if (this.f21720g.a()) {
            this.j.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putInt("friendType", this.k);
        return bundle;
    }

    public void a(List<DBContactInfo> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(n);
            arrayList.addAll(list);
            this.f21720g.a(arrayList);
        }
        this.f21720g.notifyDataSetChanged();
        if (list.size() == 0) {
            findViewById(R.id.emptyView).setVisibility(0);
            this.j.setVisibility(8);
            return;
        }
        findViewById(R.id.emptyView).setVisibility(8);
        if (this.f21720g.a()) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.k = bundle.getInt("friendType");
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void i() {
        n = new ArrayList();
        DBContactInfo dBContactInfo = new DBContactInfo();
        dBContactInfo.d(0);
        dBContactInfo.c(this.k);
        n.add(dBContactInfo);
        this.f21720g.a(new ArrayList(n));
        this.f21720g.notifyDataSetChanged();
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void c(int i2) {
        String str;
        if (i2 == 1) {
            int i3 = this.k;
            if (i3 == 2) {
                str = b.e(R.string.sp_fb_friend_shopee);
            } else if (i3 != 4) {
                str = b.e(R.string.sp_beetalk_friend_shopee);
            } else {
                str = b.e(R.string.sp_contact_friend_shopee);
            }
        } else {
            int i4 = this.k;
            if (i4 == 2) {
                str = b.a(R.string.sp_fb_friends_shopee, Integer.valueOf(i2));
            } else if (i4 != 4) {
                str = b.a(R.string.sp_beetalk_friends_shopee, Integer.valueOf(i2));
            } else {
                str = b.a(R.string.sp_contact_friends_shopee, Integer.valueOf(i2));
            }
        }
        this.i.setText(str);
    }
}
