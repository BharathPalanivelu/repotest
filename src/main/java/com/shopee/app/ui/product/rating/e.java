package com.shopee.app.ui.product.rating;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ItemCommentInfo;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.x;
import com.shopee.app.network.d.y;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.product.rating.b;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class e extends q<g> {

    /* renamed from: a  reason: collision with root package name */
    private int f24740a;

    /* renamed from: c  reason: collision with root package name */
    private long f24741c;

    /* renamed from: d  reason: collision with root package name */
    private int f24742d;

    /* renamed from: e  reason: collision with root package name */
    private i f24743e = b.a(this);

    /* renamed from: f  reason: collision with root package name */
    private final b f24744f;

    /* renamed from: g  reason: collision with root package name */
    private List<ItemCommentInfo> f24745g;
    private int h;
    private int i;
    private boolean j = true;
    private int k;
    private boolean l;

    public e(b bVar) {
        this.f24744f = bVar;
        this.f24745g = new ArrayList();
    }

    public void a() {
        this.f24743e.a();
    }

    public void b() {
        this.f24743e.b();
    }

    public void a(int i2, long j2, int i3, boolean z, int i4, int i5) {
        this.f24740a = i2;
        this.f24741c = j2;
        this.k = i3;
        this.l = z;
        this.f24742d = 0;
        this.h = i4;
        this.i = i5;
        b(((i4 / 20) + 1) * 20);
    }

    private void b(int i2) {
        x a2 = new y().a(this.f24740a).a(this.f24741c).b(this.f24742d).c(this.k).d(i2).a(true).d(true).e(this.l).a();
        o.a().a((az) a2);
        a2.g();
    }

    public void e() {
        if (this.j) {
            b(20);
            ((g) this.f19220b).g();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<ItemCommentInfo> list) {
        if (list.size() < 20) {
            this.j = false;
        }
        this.f24742d += list.size();
        this.f24745g.addAll(list);
        this.f24744f.a(this.f24740a, this.f24741c, new ArrayList(this.f24745g), this.h, this.i);
        this.h = -1;
        this.i = -1;
    }

    /* access modifiers changed from: package-private */
    public void a(b.C0380b bVar) {
        ((g) this.f19220b).a(bVar.f24731c);
        if (bVar.f24732d >= 0) {
            ((g) this.f19220b).setCurrentIndex(bVar.f24732d);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(List<UserData> list) {
        this.f24744f.a(this.f24740a, this.f24741c, new ArrayList(this.f24745g), -1, -1);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f24744f.a(this.f24740a, this.f24741c, new ArrayList(this.f24745g), -1, -1);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        String str;
        if (i2 != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((g) this.f19220b).h.b();
        ((g) this.f19220b).a(str);
    }
}
