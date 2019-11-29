package com.shopee.app.ui.product.comment.FeedsComment;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.ap;
import com.shopee.app.data.viewmodel.FeedCommentInfo;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.h.o;
import com.shopee.app.network.d.a;
import com.shopee.app.network.d.ac;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.m;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.TagEditText;
import com.shopee.app.ui.common.at;
import com.shopee.app.util.af;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class e extends q<g> implements TagEditText.a, at.a {

    /* renamed from: a  reason: collision with root package name */
    private final ap f24429a;

    /* renamed from: c  reason: collision with root package name */
    private final UserInfo f24430c;

    /* renamed from: d  reason: collision with root package name */
    private List<FeedCommentInfo> f24431d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private int f24432e;

    /* renamed from: f  reason: collision with root package name */
    private long f24433f;

    /* renamed from: g  reason: collision with root package name */
    private final i f24434g = b.a(this);
    private long h;

    /* access modifiers changed from: package-private */
    public void a(ItemDetail itemDetail) {
    }

    public e(ap apVar, UserInfo userInfo) {
        this.f24429a = apVar;
        this.f24430c = userInfo;
    }

    public void a(int i, long j) {
        this.f24432e = i;
        this.f24433f = j;
        ((g) this.f19220b).c();
        this.h = 0;
        a(true);
        h();
    }

    private void a(boolean z) {
        ac acVar = new ac(this.f24433f, this.h, z);
        o.a().a((az) acVar);
        acVar.g();
    }

    private void h() {
        this.f24429a.a(this.f24433f);
    }

    public void a() {
        this.f24434g.a();
    }

    public void c() {
        this.f24434g.c();
    }

    public void d() {
        this.f24434g.d();
    }

    public void b() {
        this.f24434g.b();
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<String, com.shopee.app.ui.common.e[]> pair) {
        new a().a(this.f24432e, this.f24433f, (String) pair.first, (com.shopee.app.ui.common.e[]) pair.second);
        ((g) this.f19220b).b();
        ((g) this.f19220b).d();
        ((g) this.f19220b).setScrollToBottom(true);
    }

    /* access modifiers changed from: package-private */
    public void c(int i) {
        ((g) this.f19220b).a(i);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.ui.product.comment.b bVar) {
        ((g) this.f19220b).d();
        new m().a(bVar.f24466a, bVar.f24467b, bVar.f24468c);
    }

    /* access modifiers changed from: package-private */
    public void b(Pair<String, Integer> pair) {
        if (this.f24430c.isLoggedIn()) {
            ((g) this.f19220b).a((String) pair.first, (Integer) pair.second);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i) {
        if (i == 4) {
            ((g) this.f19220b).f();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        h();
    }

    /* access modifiers changed from: package-private */
    public void a(List<FeedCommentInfo> list) {
        int size = this.f24431d.size();
        this.f24431d = new ArrayList(list);
        ((g) this.f19220b).a(list, this.h == 0, this.f24431d.size() - size);
        if (!af.a(list)) {
            this.h = list.get(0).getcTime();
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        h();
    }

    /* access modifiers changed from: package-private */
    public void b(List<UserData> list) {
        h();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.h = 0;
        a(true);
        ((g) this.f19220b).e();
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        ((g) this.f19220b).e();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (aVar.f17892a != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_comment_posting_failed);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((g) this.f19220b).a(str);
    }

    public void b(int i) {
        ((g) this.f19220b).setScrollToBottom(false);
        a(false);
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f24431d.size(); i++) {
            FeedCommentInfo feedCommentInfo = this.f24431d.get(i);
            String userName = feedCommentInfo.getUserName();
            if (userName.startsWith(str) && !userName.equals(this.f24430c.getUsername())) {
                UserBriefInfo userBriefInfo = new UserBriefInfo();
                userBriefInfo.setUserId(feedCommentInfo.getUserId());
                userBriefInfo.setUserName(feedCommentInfo.getUserName());
                userBriefInfo.setNickName(feedCommentInfo.getNickName());
                userBriefInfo.setPortrait(feedCommentInfo.getUserPortrait());
                userBriefInfo.hideFollow(true);
                if (!arrayList.contains(userBriefInfo)) {
                    arrayList.add(userBriefInfo);
                }
            }
        }
        ((g) this.f19220b).a((List<UserBriefInfo>) arrayList);
    }

    public void a(int i) {
        if (i == 1) {
            ((g) this.f19220b).post(new Runnable() {
                public void run() {
                    e.this.b("");
                }
            });
        } else {
            ((g) this.f19220b).post(new Runnable() {
                public void run() {
                    ((g) e.this.f19220b).b();
                }
            });
        }
    }

    public void a(final String str) {
        ((g) this.f19220b).post(new Runnable() {
            public void run() {
                e.this.b(str);
            }
        });
    }
}
