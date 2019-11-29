package com.shopee.app.ui.product.comment;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.aj;
import com.shopee.app.d.c.br;
import com.shopee.app.data.viewmodel.ItemCommentInfo;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.h.o;
import com.shopee.app.network.c.d.a;
import com.shopee.app.network.d.ax;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.be;
import com.shopee.app.network.d.m;
import com.shopee.app.network.d.x;
import com.shopee.app.network.d.y;
import com.shopee.app.tracking.f;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.TagEditText;
import com.shopee.app.ui.common.at;
import com.shopee.app.ui.common.e;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class k extends q<m> implements TagEditText.a, at.a {

    /* renamed from: a  reason: collision with root package name */
    private final aj f24524a;

    /* renamed from: c  reason: collision with root package name */
    private final br f24525c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f24526d;

    /* renamed from: e  reason: collision with root package name */
    private List<ItemCommentInfo> f24527e;

    /* renamed from: f  reason: collision with root package name */
    private int f24528f;

    /* renamed from: g  reason: collision with root package name */
    private long f24529g;
    private final i h;
    private int i = 0;
    private int j;
    private int k;
    private f l;

    public k(br brVar, aj ajVar, UserInfo userInfo, f fVar) {
        this.f24524a = ajVar;
        this.f24525c = brVar;
        this.f24526d = userInfo;
        this.l = fVar;
        this.f24527e = new ArrayList();
        this.h = b.a(this);
    }

    public void a() {
        this.h.a();
    }

    public void b() {
        this.h.b();
    }

    public void c() {
        this.h.c();
    }

    public void d() {
        this.h.d();
    }

    public void a(int i2) {
        if (i2 == 1) {
            ((m) this.f19220b).post(new Runnable() {
                public void run() {
                    k.this.b("");
                }
            });
        } else {
            ((m) this.f19220b).post(new Runnable() {
                public void run() {
                    ((m) k.this.f19220b).e();
                }
            });
        }
    }

    public void a(final String str) {
        ((m) this.f19220b).post(new Runnable() {
            public void run() {
                k.this.b(str);
            }
        });
    }

    public void b(int i2) {
        this.i += 20;
        ((m) this.f19220b).setScrollToBottom(false);
        i();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, long j2, int i3) {
        this.f24528f = i2;
        this.f24529g = j2;
        this.j = i3;
        this.k = 0;
        this.i = 0;
        h();
        i();
    }

    private void h() {
        this.f24524a.a(this.f24528f, this.f24529g, this.j != 10, this.j, this.k);
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f24527e.size(); i2++) {
            ItemCommentInfo itemCommentInfo = this.f24527e.get(i2);
            String userName = itemCommentInfo.getUserName();
            if (userName.startsWith(str) && !userName.equals(this.f24526d.getUsername())) {
                UserBriefInfo userBriefInfo = new UserBriefInfo();
                userBriefInfo.setUserId(itemCommentInfo.getUserId());
                userBriefInfo.setUserName(itemCommentInfo.getUserName());
                userBriefInfo.setNickName(itemCommentInfo.getNickName());
                userBriefInfo.setPortrait(itemCommentInfo.getUserPortrait());
                userBriefInfo.hideFollow(true);
                if (!arrayList.contains(userBriefInfo)) {
                    arrayList.add(userBriefInfo);
                }
            }
        }
        ((m) this.f19220b).a((List<UserBriefInfo>) arrayList);
    }

    public void a(int i2, long j2) {
        this.f24525c.a(i2, j2);
    }

    public void a(int i2, int i3) {
        if (this.j != i2 || this.k != i3) {
            this.j = i2;
            this.k = i3;
            this.i = 0;
            h();
            i();
        }
    }

    private void i() {
        boolean z = true;
        y c2 = new y().a(this.f24528f).a(this.f24529g).b(this.i).c(true);
        if (this.j == 10) {
            z = false;
        }
        x a2 = c2.a(z).c(this.k).a();
        o.a().a((az) a2);
        a2.g();
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<String, e[]> pair) {
        new be().a(this.f24528f, this.f24529g, (String) pair.first, (e[]) pair.second);
        ((m) this.f19220b).e();
        ((m) this.f19220b).f();
        ((m) this.f19220b).setScrollToBottom(true);
        this.l.a((long) this.f24528f, this.f24529g);
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        ((m) this.f19220b).a(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        ((m) this.f19220b).f();
        new m().a(bVar.f24466a, bVar.f24467b, bVar.f24468c);
    }

    /* access modifiers changed from: package-private */
    public void b(Pair<String, Integer> pair) {
        if (this.f24526d.isLoggedIn()) {
            ((m) this.f19220b).a((String) pair.first, (Integer) pair.second);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(aj.b bVar) {
        if (bVar.f16470a == this.j) {
            int size = this.f24527e.size();
            this.f24527e = new ArrayList(bVar.f16471b);
            ((m) this.f19220b).a(this.f24527e, bVar, this.i == 0, this.f24527e.size() - size);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        h();
    }

    /* access modifiers changed from: package-private */
    public void a(List<UserData> list) {
        h();
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.i = 0;
        ((m) this.f19220b).g();
        new ax(this.f24528f, this.f24529g).g();
        i();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        ((m) this.f19220b).g();
        new ax(this.f24528f, this.f24529g).g();
        ((m) this.f19220b).a(com.garena.android.appkit.tools.b.e(R.string.sp_comment_delete_success));
        h();
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (aVar.f17892a != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((m) this.f19220b).a(str);
        ((m) this.f19220b).g();
    }

    /* access modifiers changed from: package-private */
    public void a(ItemDetail itemDetail) {
        if (itemDetail.getId() == this.f24529g) {
            ((m) this.f19220b).a(itemDetail);
            h();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        String str;
        ((m) this.f19220b).g();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (aVar.f17892a != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_comment_posting_failed);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        if (aVar.f17892a != 28) {
            ((m) this.f19220b).a(str);
        } else {
            ((m) this.f19220b).b(str);
        }
    }
}
