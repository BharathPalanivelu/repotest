package com.shopee.app.ui.follow.following;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.devspark.robototextview.widget.RobotoButton;
import com.garena.android.appkit.b.a;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.follow.b;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class u extends FrameLayout implements n<t> {

    /* renamed from: a  reason: collision with root package name */
    ImageView f21736a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21737b;

    /* renamed from: c  reason: collision with root package name */
    TextView f21738c;

    /* renamed from: d  reason: collision with root package name */
    RobotoButton f21739d;

    /* renamed from: e  reason: collision with root package name */
    LinearLayout f21740e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f21741f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f21742g;
    ImageView h;
    ImageView i;
    TextView j;
    TextView k;
    TextView l;
    TextView m;
    RelativeLayout n;
    RelativeLayout o;
    RelativeLayout p;
    RelativeLayout q;
    bi r;
    ak s;
    /* access modifiers changed from: private */
    public t t;
    private int u;

    public u(Context context) {
        super(context);
        ((b) ((x) context).b()).a(this);
    }

    public void a(t tVar) {
        this.t = tVar;
        z.a(getContext()).a(tVar.d()).a(this.f21736a);
        this.u = tVar.b();
        this.f21737b.setText(tVar.c());
        this.f21738c.setText(com.garena.android.appkit.tools.b.a(R.string.sp_recommend_description, Integer.valueOf(tVar.l()), Integer.valueOf(tVar.e())));
        if (tVar.g()) {
            this.f21739d.setText(R.string.sp_following);
            this.f21739d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.f21739d.setBackgroundResource(R.drawable.btn_follow_disabled2);
            this.f21739d.setTextColor(com.garena.android.appkit.tools.b.a(R.color.white));
        } else {
            this.f21739d.setText(R.string.sp_follow);
            this.f21739d.setBackgroundResource(R.drawable.btn_primary);
            this.f21739d.setTextColor(com.garena.android.appkit.tools.b.a(R.color.white));
            this.f21739d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_garena_shopee_ic_btn_add, 0, 0, 0);
        }
        this.f21740e.setVisibility(0);
        int size = tVar.k().size();
        if (size == 0) {
            this.f21740e.setVisibility(8);
        } else if (size == 1) {
            a(this.q, this.i, this.m, tVar.k().get(0));
            this.n.setVisibility(4);
            this.o.setVisibility(4);
            this.p.setVisibility(4);
        } else if (size == 2) {
            a(this.q, this.i, this.m, tVar.k().get(0));
            a(this.n, this.f21741f, this.j, tVar.k().get(1));
            this.o.setVisibility(4);
            this.p.setVisibility(4);
        } else if (size != 3) {
            a(this.q, this.i, this.m, tVar.k().get(0));
            a(this.n, this.f21741f, this.j, tVar.k().get(1));
            a(this.o, this.f21742g, this.k, tVar.k().get(2));
            a(this.p, this.h, this.l, tVar.k().get(3));
        } else {
            this.p.setVisibility(4);
            a(this.q, this.i, this.m, tVar.k().get(0));
            a(this.n, this.f21741f, this.j, tVar.k().get(1));
            a(this.o, this.f21742g, this.k, tVar.k().get(2));
        }
    }

    private void a(RelativeLayout relativeLayout, ImageView imageView, TextView textView, final k kVar) {
        relativeLayout.setVisibility(0);
        z.b(getContext()).a(kVar.a()).a(imageView);
        textView.setText(kVar.b());
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                u.this.s.b(u.this.t.b(), kVar.c().longValue());
            }
        });
    }

    public void a() {
        if (!this.t.g()) {
            this.r.a("FOLLOW_SHOP_REQUEST", new a(Integer.valueOf(this.u)));
        } else {
            this.s.b(this.t.b());
        }
    }
}
