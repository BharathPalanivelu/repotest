package com.shopee.app.ui.chat2.a;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.a.a.d;
import com.afollestad.materialdialogs.f;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.util.ak;
import com.shopee.app.util.au;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class d extends FrameLayout implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f20237a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f20238b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20239c;

    /* renamed from: d  reason: collision with root package name */
    TextView f20240d;

    /* renamed from: e  reason: collision with root package name */
    TextView f20241e;

    /* renamed from: f  reason: collision with root package name */
    TextView f20242f;

    /* renamed from: g  reason: collision with root package name */
    Button f20243g;
    Button h;
    View i;
    int j;
    int k;
    b l;
    bc m;
    ak n;
    public View.OnClickListener o = new View.OnClickListener() {
        public void onClick(View view) {
            d.this.l.g();
            d.this.j();
        }
    };
    public View.OnClickListener p = new View.OnClickListener() {
        public void onClick(View view) {
            d.this.l.f();
            d.this.j();
        }
    };
    public View.OnClickListener q = new View.OnClickListener() {
        public void onClick(View view) {
            d.this.l.h();
            d.this.j();
        }
    };
    public View.OnClickListener r = new View.OnClickListener() {
        public void onClick(View view) {
            d.this.l.i();
            d.this.j();
        }
    };
    private final a s;
    private f t;
    /* access modifiers changed from: private */
    public b u;
    private View.OnClickListener v = new View.OnClickListener() {
        public void onClick(View view) {
            d.this.n.u();
            d.this.j();
        }
    };
    private View.OnClickListener w = new View.OnClickListener() {
        public void onClick(View view) {
            d.this.l.j();
            d.this.j();
        }
    };

    public interface a {
        void a(d dVar);
    }

    public interface b {
        void a();
    }

    public d(Context context, a aVar) {
        super(context);
        this.s = aVar;
        ((a) ((x) getContext()).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.m.a(this.l);
        this.l.a(this);
        this.l.a(this.s);
        this.l.a(this.s.g(), this.s.h(), this.s.i());
        if (this.s.a() <= 0) {
            this.f20237a.setText(com.garena.android.appkit.tools.b.e(R.string.sp_offer_expired));
            com.a.a.f a2 = com.a.a.f.a(getContext());
            a2.a().a((Object) au.a(this.s.j(), this.s.k())).a().a(this.k).c().b();
            d.a a3 = a2.a();
            a3.a((Object) " x " + this.s.l()).a().a(this.j).c().b();
            a2.a(this.f20242f);
            TextView textView = this.f20242f;
            textView.setText(au.a(this.s.j(), this.s.k()) + " x" + this.s.l());
            return;
        }
        this.l.a(this.s.a(), this.s.g(), this.s.h(), this.s.i());
        this.f20239c.setText(this.s.b());
        a(this.s.e(), this.s.d(), this.s.k());
        com.a.a.f a4 = com.a.a.f.a(getContext());
        a4.a().a((Object) au.a(this.s.j(), this.s.k())).a().a(this.k).d().c().b();
        d.a a5 = a4.a();
        a5.a((Object) " x " + this.s.l()).a().a(this.j).c().b();
        a4.a(this.f20242f);
        if (this.s.i() <= 0) {
            this.f20240d.setVisibility(8);
        } else {
            this.f20240d.setText(this.s.c());
        }
        z.b(getContext()).a(this.s.f()).a(this.f20238b);
        this.f20238b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.u != null) {
                    d.this.u.a();
                }
            }
        });
    }

    public void setOnProductClickedListener(b bVar) {
        this.u = bVar;
    }

    public void setDialog(f fVar) {
        this.t = fVar;
        this.t.setOnDismissListener(this);
    }

    public void a(ItemDetail itemDetail, ModelDetail modelDetail) {
        if (this.s.a() <= 0) {
            this.f20239c.setText(itemDetail.getItemName());
            z.b(getContext()).a(itemDetail.getImages()).a(this.f20238b);
            this.f20238b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (d.this.u != null) {
                        d.this.u.a();
                    }
                }
            });
            if (modelDetail != null) {
                this.f20240d.setText(modelDetail.getName());
            } else if (TextUtils.isEmpty(this.s.c())) {
                this.f20240d.setVisibility(8);
            }
            a(itemDetail.getPriceBeforeDiscount(), itemDetail.getPrice(), itemDetail.getCurrency());
        }
    }

    private void a(long j2, long j3, String str) {
        if (j2 <= 0) {
            com.a.a.f a2 = com.a.a.f.a(getContext());
            a2.a().a((Object) au.a(j3, str)).a().b(com.garena.android.appkit.tools.b.a(R.color.black87)).c().b();
            a2.a(this.f20241e);
            return;
        }
        com.a.a.f a3 = com.a.a.f.a(getContext());
        a3.a().a((Object) au.a(j2, str)).a().b(com.garena.android.appkit.tools.b.a(R.color.black54)).b().c().b();
        a3.a("  ").b();
        a3.a().a((Object) au.a(j3, str)).a().b(com.garena.android.appkit.tools.b.a(R.color.black87)).c().b();
        a3.a(this.f20241e);
    }

    public void b() {
        this.f20237a.setText(a((int) R.string.sp_offer_pending));
        this.i.setVisibility(0);
        a(a((int) R.string.sp_decline_offer), this.p);
        b(a((int) R.string.sp_accept_offer), this.o);
    }

    public void c() {
        this.f20237a.setText(a((int) R.string.sp_offer_pending));
        this.i.setVisibility(0);
        a(a((int) R.string.sp_cancel_offer), this.q);
        b(a((int) R.string.sp_edit_offer), this.r);
    }

    public void d() {
        this.f20237a.setText(a((int) R.string.sp_offer_accepted));
        this.i.setVisibility(8);
    }

    public void e() {
        this.f20237a.setText(a((int) R.string.sp_offer_accepted));
        this.i.setVisibility(0);
        this.f20243g.setVisibility(8);
        b(a((int) R.string.sp_label_go_to_shopping_cart), this.v);
    }

    public void f() {
        this.f20237a.setText(a((int) R.string.sp_offer_rejected));
        this.i.setVisibility(8);
    }

    public void g() {
        this.f20237a.setText(a((int) R.string.sp_offer_rejected));
        this.i.setVisibility(0);
        this.f20243g.setVisibility(8);
        b(a((int) R.string.sp_make_a_new_offer), this.w);
    }

    public void h() {
        this.f20237a.setText(a((int) R.string.sp_offer_cancelled));
        this.i.setVisibility(8);
    }

    public void i() {
        this.f20237a.setText(a((int) R.string.sp_offer_cancelled));
        this.i.setVisibility(0);
        this.f20243g.setVisibility(8);
        b(a((int) R.string.sp_make_a_new_offer), this.w);
    }

    private void a(String str, View.OnClickListener onClickListener) {
        this.f20243g.setVisibility(0);
        this.f20243g.setText(str);
        this.f20243g.setOnClickListener(onClickListener);
        this.f20243g.setBackgroundResource(R.drawable.btn_secondary_blue);
        this.f20243g.setTextColor(com.garena.android.appkit.tools.b.a(R.color.secondary));
    }

    private void b(String str, View.OnClickListener onClickListener) {
        this.h.setVisibility(0);
        this.h.setText(str);
        this.h.setOnClickListener(onClickListener);
        this.h.setBackgroundResource(R.drawable.btn_secondary_primary);
        this.h.setTextColor(getResources().getColor(R.color.primary));
    }

    private String a(int i2) {
        return com.garena.android.appkit.tools.b.e(i2);
    }

    /* access modifiers changed from: private */
    public void j() {
        f fVar = this.t;
        if (fVar != null) {
            fVar.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.l.d();
        this.l.b();
        this.m.b(this.l);
    }
}
