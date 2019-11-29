package com.shopee.app.ui.product.comment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.shopee.app.d.c.aj;
import com.shopee.app.data.viewmodel.ItemCommentInfo;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.h.q;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.a.z;
import com.shopee.app.ui.common.TagEditText;
import com.shopee.app.ui.common.ag;
import com.shopee.app.ui.common.at;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.product.comment.f;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.l;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.List;

public class m extends com.garena.android.uikit.a.a.a implements SwipeRefreshLayout.b {

    /* renamed from: a  reason: collision with root package name */
    ListView f24553a;

    /* renamed from: b  reason: collision with root package name */
    ListView f24554b;

    /* renamed from: c  reason: collision with root package name */
    ag f24555c;

    /* renamed from: d  reason: collision with root package name */
    TextView f24556d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f24557e;

    /* renamed from: f  reason: collision with root package name */
    k f24558f;

    /* renamed from: g  reason: collision with root package name */
    b f24559g;
    f h;
    c i;
    bc j;
    ak k;
    r l;
    private final int m;
    private final long n;
    /* access modifiers changed from: private */
    public at o;
    /* access modifiers changed from: private */
    public int p = 0;
    /* access modifiers changed from: private */
    public int q = 10;
    private f.b r = new f.b() {
        public void a() {
            int unused = m.this.p = 0;
            m.this.f24558f.a(m.this.q, m.this.p);
        }

        public void b() {
            int unused = m.this.p = 5;
            m.this.f24558f.a(m.this.q, m.this.p);
        }

        public void c() {
            int unused = m.this.p = 4;
            m.this.f24558f.a(m.this.q, m.this.p);
        }

        public void d() {
            int unused = m.this.p = 3;
            m.this.f24558f.a(m.this.q, m.this.p);
        }

        public void e() {
            int unused = m.this.p = 2;
            m.this.f24558f.a(m.this.q, m.this.p);
        }

        public void f() {
            int unused = m.this.p = 1;
            m.this.f24558f.a(m.this.q, m.this.p);
        }
    };

    public interface a {
        void a(m mVar);
    }

    public void onRefresh() {
    }

    public m(Context context, int i2, long j2, int i3) {
        super(context);
        this.m = i2;
        this.n = j2;
        this.q = i3;
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.j.a(this.f24558f);
        this.f24558f.a(this);
        ((TagEditText) this.f24555c.getEditText()).setTagModeChangeListener(this.f24558f);
        this.f24554b.setAdapter(this.i);
        this.f24558f.a(this.m, this.n, this.q);
        this.o = new at(this.f24553a, this.f24559g);
        this.f24553a.setAdapter(this.f24559g);
        this.o.a((at.a) this.f24558f);
        this.f24558f.a(this.m, this.n);
        if (this.q == 10) {
            this.h.setVisibility(8);
            return;
        }
        this.h.setVisibility(0);
        this.h.a(0, 0, this.r);
    }

    public void a(List<ItemCommentInfo> list, aj.b bVar, boolean z, int i2) {
        aj.b bVar2 = bVar;
        int i3 = i2;
        for (ItemCommentInfo isOwnerComment : list) {
            isOwnerComment.setIsOwnerComment(this.m);
        }
        this.h.setInfo(new f.a(bVar2.f16472c, bVar2.f16473d, bVar2.f16474e, bVar2.f16475f, bVar2.f16476g, bVar2.h, bVar2.i, this.r));
        if (list.isEmpty()) {
            a(true, bVar2.f16473d);
        }
        this.f24559g.a(list);
        if (z) {
            this.o.a(false);
            this.o.a(i3);
            this.o.c();
        } else if (i3 == 0) {
            com.garena.android.appkit.f.f.a().a(new Runnable() {
                public void run() {
                    m.this.o.a(0);
                }
            }, 500);
        } else {
            this.o.a(i3);
        }
    }

    public void a(List<UserBriefInfo> list) {
        this.f24553a.setVisibility(8);
        this.f24554b.setVisibility(0);
        this.i.a(list);
        this.i.notifyDataSetChanged();
    }

    public void e() {
        this.f24554b.setVisibility(8);
        this.f24553a.setVisibility(0);
    }

    private void a(boolean z, int i2) {
        if (z) {
            if (this.q == 10) {
                this.f24556d.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_empty_comments));
                this.f24557e.setImageResource(R.drawable.ic_no_comment);
            } else {
                if (i2 == 0) {
                    this.f24556d.setText(com.garena.android.appkit.tools.b.e(R.string.sp_product_no_rating));
                } else {
                    this.f24556d.setText(com.garena.android.appkit.tools.b.e(R.string.sp_no_ratings));
                }
                this.f24557e.setImageResource(R.drawable.ic_no_rating);
            }
            this.f24553a.setEmptyView(findViewById(R.id.emptyView));
            return;
        }
        this.f24553a.setEmptyView((View) null);
    }

    public void a() {
        super.a();
        this.f24558f.c();
    }

    public void b() {
        super.b();
        this.f24558f.d();
    }

    public void f() {
        this.l.a();
    }

    public void g() {
        this.l.b();
    }

    public void a(ItemDetail itemDetail) {
        ((g) getContext()).a(itemDetail.getImages());
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    /* access modifiers changed from: package-private */
    public void a(UserBriefInfo userBriefInfo) {
        if (this.f24555c.getVisibility() == 0) {
            ((TagEditText) this.f24555c.getEditText()).a(userBriefInfo.getUserName(), userBriefInfo.getUserId());
        }
    }

    public void a(int i2) {
        if (i2 != -1) {
            this.k.c(i2);
        }
    }

    public void a(String str, Integer num) {
        if (this.f24555c.getVisibility() == 0) {
            ((TagEditText) this.f24555c.getEditText()).a(0, 0);
            ((TagEditText) this.f24555c.getEditText()).a(str, num.intValue());
            com.shopee.app.c.a.b(this.f24555c.getEditText());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int i6 = i5 - i3;
        if (i6 >= l.p) {
            this.o.c();
        } else if (i6 <= (-l.p) && i5 != 0) {
            this.o.c();
        }
    }

    public void setScrollToBottom(boolean z) {
        this.o.a(z);
    }

    public void b(String str) {
        com.shopee.app.ui.dialog.a.a(getContext(), str, "", com.garena.android.appkit.tools.b.e(R.string.button_ok), (a.C0318a) null);
    }

    public static class b extends z<ItemCommentInfo> {
        /* access modifiers changed from: protected */
        public n<ItemCommentInfo> a(Context context, int i) {
            return d.a(context);
        }
    }

    public static class c extends z<UserBriefInfo> {
        /* access modifiers changed from: protected */
        public n<UserBriefInfo> a(Context context, int i) {
            return com.shopee.app.ui.follow.search.b.a(context);
        }
    }
}
