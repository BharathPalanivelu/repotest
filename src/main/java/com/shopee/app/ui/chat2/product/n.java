package com.shopee.app.ui.chat2.product;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.garena.android.uikit.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.common.ap;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class n extends FrameLayout implements c.b, r {
    /* access modifiers changed from: private */
    public static final String[] h = {com.garena.android.appkit.tools.b.e(R.string.sp_label_my_shop), com.garena.android.appkit.tools.b.e(R.string.sp_label_products), com.garena.android.appkit.tools.b.e(R.string.sp_label_latest)};
    /* access modifiers changed from: private */
    public static final String[] i = {com.garena.android.appkit.tools.b.e(R.string.sp_label_products), com.garena.android.appkit.tools.b.e(R.string.sp_label_latest)};

    /* renamed from: a  reason: collision with root package name */
    c f20821a;

    /* renamed from: b  reason: collision with root package name */
    Button f20822b;

    /* renamed from: c  reason: collision with root package name */
    bc f20823c;

    /* renamed from: d  reason: collision with root package name */
    View f20824d;

    /* renamed from: e  reason: collision with root package name */
    c f20825e;

    /* renamed from: f  reason: collision with root package name */
    com.shopee.app.ui.actionbar.a f20826f;

    /* renamed from: g  reason: collision with root package name */
    UserInfo f20827g;
    /* access modifiers changed from: private */
    public final int j;
    /* access modifiers changed from: private */
    public final int k;
    /* access modifiers changed from: private */
    public final String l;

    public interface a {
        void a(n nVar);
    }

    public void a(int i2) {
    }

    public n(Context context, int i2, int i3, String str) {
        super(context);
        ((a) ((x) getContext()).b()).a(this);
        this.j = i3;
        this.k = i2;
        this.l = str;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20823c.a(this.f20825e);
        this.f20825e.a(this);
        if (this.f20827g.isSeller()) {
            String[] strArr = h;
            strArr[1] = "@" + this.l;
        } else {
            String[] strArr2 = i;
            strArr2[0] = "@" + this.l;
        }
        b bVar = new b(this.f20827g.isSeller());
        this.f20821a.setAdapter(bVar);
        this.f20821a.setTabIndicator(new ap(bVar.b()));
        this.f20821a.a();
        this.f20821a.setTabChangeListener(this);
        this.f20824d.setVisibility(0);
        this.f20822b.setText(com.garena.android.appkit.tools.b.a(R.string.sp_send_link, 0));
        this.f20822b.setBackgroundResource(R.drawable.btn_disabled);
        this.f20822b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
    }

    public void e() {
        int size = com.shopee.app.ui.chat.a.f20003c.size();
        if (size > 0) {
            this.f20822b.setText(com.garena.android.appkit.tools.b.a(R.string.sp_send_link, Integer.valueOf(size)));
            this.f20822b.setBackgroundResource(R.drawable.btn_primary);
            this.f20822b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ((Activity) n.this.getContext()).setResult(-1);
                    ((Activity) n.this.getContext()).finish();
                }
            });
            return;
        }
        this.f20822b.setText(com.garena.android.appkit.tools.b.a(R.string.sp_send_link, 0));
        this.f20822b.setBackgroundResource(R.drawable.btn_disabled);
        this.f20822b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
    }

    public void b() {
        this.f20821a.b();
    }

    public void c() {
        this.f20821a.c();
    }

    public void d() {
        this.f20821a.d();
    }

    public void a(int i2, int i3) {
        String str;
        String e2 = com.garena.android.appkit.tools.b.e(R.string.sp_label_search);
        if (this.f20827g.isSeller()) {
            str = e2.concat(SQLBuilder.BLANK).concat(h[i3]);
        } else {
            str = e2.concat(SQLBuilder.BLANK).concat(i[i3]);
        }
        this.f20826f.setSearchPlaceholder(str);
    }

    private class b extends com.garena.android.uikit.a.a {

        /* renamed from: d  reason: collision with root package name */
        private boolean f20832d;

        public View a(Context context) {
            return null;
        }

        public b(boolean z) {
            this.f20832d = z;
        }

        public int b() {
            return this.f20832d ? 3 : 2;
        }

        public com.garena.android.uikit.a.a.b d(Context context, int i) {
            if (this.f20832d) {
                ao aoVar = new ao(context, n.h[i]);
                aoVar.setTitle(n.h[i]);
                return aoVar;
            }
            ao aoVar2 = new ao(context, n.i[i]);
            aoVar2.setTitle(n.i[i]);
            return aoVar2;
        }

        public com.garena.android.uikit.a.a.a e(Context context, int i) {
            if (this.f20832d) {
                if (i == 0) {
                    return com.shopee.app.ui.chat2.product.a.b.a(context);
                }
                if (i == 1) {
                    return com.shopee.app.ui.chat2.product.c.b.a(context, n.this.j);
                }
                if (i != 2) {
                    return i.a(context, i, n.this.j);
                }
                return com.shopee.app.ui.chat2.product.b.b.a(context, n.this.k, n.this.l);
            } else if (i == 0) {
                return com.shopee.app.ui.chat2.product.c.b.a(context, n.this.j);
            } else {
                if (i != 1) {
                    return i.a(context, i, n.this.j);
                }
                return com.shopee.app.ui.chat2.product.b.b.a(context, n.this.k, n.this.l);
            }
        }
    }
}
