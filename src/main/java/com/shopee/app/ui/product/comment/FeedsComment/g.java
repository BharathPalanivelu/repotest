package com.shopee.app.ui.product.comment.FeedsComment;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.shopee.app.data.viewmodel.FeedCommentInfo;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.h.q;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.a.z;
import com.shopee.app.ui.common.TagEditText;
import com.shopee.app.ui.common.ag;
import com.shopee.app.ui.common.at;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.l;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.List;

public class g extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ListView f24458a;

    /* renamed from: b  reason: collision with root package name */
    ListView f24459b;

    /* renamed from: c  reason: collision with root package name */
    ag f24460c;

    /* renamed from: d  reason: collision with root package name */
    e f24461d;

    /* renamed from: e  reason: collision with root package name */
    a f24462e;

    /* renamed from: f  reason: collision with root package name */
    b f24463f;

    /* renamed from: g  reason: collision with root package name */
    bc f24464g;
    ak h;
    r i;
    ImageView j;
    TextView k;
    private final int l;
    private final long m;
    private at n;

    public void c() {
    }

    public g(Context context, int i2, long j2) {
        super(context);
        this.l = i2;
        this.m = j2;
        ((com.shopee.app.ui.product.comment.a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24464g.a(this.f24461d);
        this.f24461d.a(this);
        ((TagEditText) this.f24460c.getEditText()).setTagModeChangeListener(this.f24461d);
        this.f24459b.setAdapter(this.f24463f);
        this.f24461d.a(this.l, this.m);
        this.n = new at(this.f24458a, this.f24462e);
        this.f24458a.setAdapter(this.f24462e);
        this.n.a((at.a) this.f24461d);
    }

    public void a(List<FeedCommentInfo> list, boolean z, int i2) {
        for (FeedCommentInfo isOwnerComment : list) {
            isOwnerComment.setIsOwnerComment(this.l);
        }
        if (list.isEmpty()) {
            setEmptyView(true);
        }
        this.f24462e.a(list);
        if (z) {
            this.n.a(false);
            this.n.a(i2);
            this.n.c();
            return;
        }
        this.n.a(i2);
    }

    public void b() {
        this.f24459b.setVisibility(8);
        this.f24458a.setVisibility(0);
    }

    public void setEmptyView(boolean z) {
        if (z) {
            this.f24458a.setEmptyView(findViewById(R.id.emptyView));
        } else {
            this.f24458a.setEmptyView((View) null);
        }
    }

    public void d() {
        this.i.a();
    }

    public void e() {
        this.i.b();
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    /* access modifiers changed from: package-private */
    public void a(UserBriefInfo userBriefInfo) {
        if (this.f24460c.getVisibility() == 0) {
            ((TagEditText) this.f24460c.getEditText()).a(userBriefInfo.getUserName(), userBriefInfo.getUserId());
        }
    }

    public void a(int i2) {
        if (i2 != -1) {
            this.h.c(i2);
        }
    }

    public void a(String str, Integer num) {
        if (this.f24460c.getVisibility() == 0) {
            ((TagEditText) this.f24460c.getEditText()).a(0, 0);
            ((TagEditText) this.f24460c.getEditText()).a(str, num.intValue());
            com.shopee.app.c.a.b(this.f24460c.getEditText());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int i6 = i5 - i3;
        if (i6 >= l.p) {
            this.n.c();
        } else if (i6 <= (-l.p) && i5 != 0) {
            this.n.c();
        }
    }

    public void setScrollToBottom(boolean z) {
        this.n.a(z);
    }

    public void a(List<UserBriefInfo> list) {
        this.f24458a.setVisibility(8);
        this.f24459b.setVisibility(0);
        this.f24463f.a(list);
        this.f24463f.notifyDataSetChanged();
        g();
    }

    private void g() {
        this.j.setImageResource(R.drawable.ic_no_comment);
        this.k.setText(R.string.sp_label_empty_comments);
    }

    public void f() {
        this.j.setImageResource(R.drawable.ic_no_expired);
        this.k.setText(R.string.sp_post_has_expired);
    }

    public static class a extends z<FeedCommentInfo> {
        /* access modifiers changed from: protected */
        public n<FeedCommentInfo> a(Context context, int i) {
            return b.a(context);
        }
    }

    public static class b extends z<UserBriefInfo> {
        /* access modifiers changed from: protected */
        public n<UserBriefInfo> a(Context context, int i) {
            return com.shopee.app.ui.follow.search.b.a(context);
        }
    }
}
