package com.shopee.app.ui.order.search;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.garena.android.appkit.f.f;
import com.garena.android.appkit.tools.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import java.util.List;

public class o extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    r f23848a;

    /* renamed from: b  reason: collision with root package name */
    bc f23849b;

    /* renamed from: c  reason: collision with root package name */
    l f23850c;

    /* renamed from: d  reason: collision with root package name */
    c f23851d;

    /* renamed from: e  reason: collision with root package name */
    ListView f23852e;

    /* renamed from: f  reason: collision with root package name */
    View f23853f;

    /* renamed from: g  reason: collision with root package name */
    TextView f23854g;
    TextView h;
    UserInfo i;
    ak j;
    com.shopee.app.ui.actionbar.a k;
    SettingConfigStore l;
    private final int m;
    private final int n;
    private final String o;
    private final int p;
    private p q;

    public interface a {
        void a(o oVar);
    }

    public o(Context context, int i2, int i3, String str, int i4) {
        super(context);
        this.m = i2;
        this.n = i3;
        this.o = str;
        this.p = i4;
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f23849b.a(this.f23850c);
        this.f23850c.a(this);
        this.f23852e.setAdapter(this.f23851d);
        this.q = new p(this.f23852e);
        this.q.a((p.a) this.f23850c);
        this.f23852e.setEmptyView(findViewById(R.id.empty_vew));
        int i2 = this.m;
        if (i2 == 1) {
            this.f23850c.a(i2, this.n);
            this.f23850c.a(this.o, this.p);
        } else {
            f.a().a(new Runnable() {
                public void run() {
                    View findViewById = o.this.k.findViewById(R.id.search_edit);
                    if (findViewById != null) {
                        com.shopee.app.c.a.b(findViewById);
                    }
                }
            }, IjkMediaCodecInfo.RANK_LAST_CHANCE);
        }
        if (this.l.searchRecipientEnabled()) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar) {
        switch (fVar.f23810a) {
            case 1:
                this.j.a(fVar.f23816g, fVar.h, "", fVar.f23811b);
                return;
            case 2:
                this.j.a(fVar.f23812c, this.i.getShopId());
                return;
            case 3:
                this.j.a(fVar.f23816g, fVar.h, fVar.f23813d, fVar.f23811b);
                return;
            case 5:
            case 6:
            case 7:
            case 8:
                this.j.a(f.b(fVar.f23810a), fVar.f23811b, fVar.i, fVar.f23814e);
                return;
            default:
                return;
        }
    }

    public void a(List<f> list) {
        this.f23851d.a(list);
        this.f23851d.notifyDataSetChanged();
    }

    public void b() {
        this.f23853f.setVisibility(0);
        this.f23852e.setVisibility(8);
        this.f23854g.setVisibility(0);
        if (this.l.searchRecipientEnabled()) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
        this.f23854g.setText(R.string.sp_order_search_view_hint_1);
    }

    public void c() {
        this.f23853f.setVisibility(8);
        this.f23852e.setVisibility(0);
    }

    public void d() {
        this.q.c();
    }

    public void e() {
        this.q.b();
    }

    public void f() {
        this.f23853f.setVisibility(0);
        this.f23852e.setVisibility(8);
        this.f23854g.setText(b.e(R.string.sp_no_result_found));
        this.h.setVisibility(8);
    }
}
