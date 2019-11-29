package com.shopee.app.ui.order.detail;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.a.a.f;
import com.facebook.internal.NativeProtocol;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.d.b.a.a;
import com.shopee.app.d.b.a.d.h;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.OrderItemInfo;
import com.shopee.app.g.m;
import com.shopee.app.h.q;
import com.shopee.app.h.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.order.d;
import com.shopee.app.ui.order.detail.i;
import com.shopee.app.ui.order.views.OrderHeaderView_;
import com.shopee.app.ui.order.views.OrderInfoView_;
import com.shopee.app.ui.order.views.OrderRemarkView_;
import com.shopee.app.ui.order.views.OrderShopFooter_;
import com.shopee.app.ui.order.views.i;
import com.shopee.app.util.ak;
import com.shopee.app.util.as;
import com.shopee.app.util.au;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class e extends FrameLayout {
    private static int K = 1;
    private static int L = 16;
    private static int M = 256;
    private static int N = 4096;
    private static int O = 65536;
    Button A;
    Button B;
    int C;
    int D;
    int E;
    String F;
    String G;
    Activity H;
    View.OnClickListener I = new View.OnClickListener() {
        public void onClick(View view) {
            if (!TextUtils.isEmpty(e.this.Q.getPromDescription())) {
                com.shopee.app.ui.dialog.a.a(e.this.getContext(), e.this.Q.getPromDescription(), TextUtils.isEmpty(e.this.Q.getPromUrl()) ? "" : b.e(R.string.sp_label_learn_more), b.e(R.string.button_ok), (a.C0318a) new a.C0318a() {
                    public void onPositive() {
                    }

                    public void onNegative() {
                        e.this.f23608b.a(e.this.Q.getPromUrl());
                    }
                });
            }
        }
    };
    View.OnClickListener J = new View.OnClickListener() {
        public void onClick(View view) {
            com.shopee.app.ui.dialog.a.a(e.this.getContext(), b.e(R.string.sp_unique_code_info), "", b.e(R.string.sp_label_ok), (a.C0318a) new a.C0318a() {
                public void onPositive() {
                }

                public void onNegative() {
                    e.this.f23608b.j("3030");
                }
            });
        }
    };
    private long P;
    /* access modifiers changed from: private */
    public CheckoutItem Q;
    private final long R;
    /* access modifiers changed from: private */
    public HashSet<Long> S = new HashSet<>();

    /* renamed from: a  reason: collision with root package name */
    b f23607a;

    /* renamed from: b  reason: collision with root package name */
    ak f23608b;

    /* renamed from: c  reason: collision with root package name */
    bc f23609c;

    /* renamed from: d  reason: collision with root package name */
    View f23610d;

    /* renamed from: e  reason: collision with root package name */
    ScrollView f23611e;

    /* renamed from: f  reason: collision with root package name */
    View f23612f;

    /* renamed from: g  reason: collision with root package name */
    TextView f23613g;
    TextView h;
    i i;
    LinearLayout j;
    TextView k;
    TextView l;
    TextView m;
    TextView n;
    TextView o;
    TextView p;
    TextView q;
    TextView r;
    TextView s;
    TextView t;
    View u;
    View v;
    TextView w;
    Button x;
    Button y;
    Button z;

    public e(Context context, long j2, long j3) {
        super(context);
        ((d) ((x) context).b()).a(this);
        this.P = j2;
        this.R = j3;
        this.S.add(Long.valueOf(this.R));
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f23609c.a(this.f23607a);
        this.f23607a.a(this);
        this.f23607a.a(this.P);
        if (this.R != 0) {
            postDelayed(new Runnable() {
                public void run() {
                    e.this.f23611e.fullScroll(130);
                }
            }, 600);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putLong("checkoutId", this.P);
        bundle.putString("CheckoutItem", WebRegister.GSON.b(this.Q, CheckoutItem.class));
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.Q = (CheckoutItem) WebRegister.GSON.a(bundle.getString("CheckoutItem"), CheckoutItem.class);
            this.P = bundle.getLong("checkoutId");
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void a(CheckoutItem checkoutItem) {
        this.Q = checkoutItem;
        if (checkoutItem.getOrderDetailList().size() == 0) {
            setEmptyView(true);
            return;
        }
        boolean z2 = false;
        setEmptyView(false);
        final com.shopee.app.d.b.a.a a2 = h.a(checkoutItem);
        if (TextUtils.isEmpty(a2.j())) {
            this.f23612f.setVisibility(8);
        } else {
            this.f23612f.setVisibility(0);
            this.f23613g.setText(a2.j());
            this.h.setText(Html.fromHtml(a2.k() + "<br>" + checkoutItem.getLatestTransactionTime()));
            this.f23612f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (a2.n()) {
                        com.shopee.app.ui.dialog.a.a(e.this.getContext(), a2.l(), !TextUtils.isEmpty(a2.m()) ? b.e(R.string.sp_label_learn_more) : "", b.e(R.string.sp_label_ok), (a.C0318a) new a.C0318a() {
                            public void onPositive() {
                            }

                            public void onNegative() {
                                e.this.f23608b.j(a2.m());
                            }
                        });
                    }
                }
            });
        }
        if (checkoutItem.getOrderDetailList().size() == 1) {
            OrderDetail orderDetail = checkoutItem.getOrderDetailList().get(0);
            i iVar = this.i;
            String e2 = b.e(R.string.sp_label_address);
            iVar.a(R.drawable.com_garena_shopee_ic_me_location, e2, orderDetail.getShippingName() + "&nbsp;&nbsp;&nbsp;&nbsp;<br/><font color=\"#00BFA5\">" + as.c(orderDetail.getShippingPhone()) + "</font><br/>" + orderDetail.getShippingAddress(), "", b.e(R.string.sp_label_copy_capital), new a());
        } else {
            this.i.setVisibility(8);
        }
        j();
        int i2 = checkoutItem.isEscrow() ? R.drawable.ic_guarantee : 0;
        this.w.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        this.w.setText(checkoutItem.getPaymentMethod());
        if (i2 != 0) {
            this.w.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    com.shopee.app.ui.dialog.a.a(e.this.getContext(), (int) R.string.sp_label_escrow, (int) R.string.sp_shopee_guarentee_help_popup_text, (int) R.string.sp_label_learn_more, (int) R.string.sp_label_ok, (a.C0318a) new a.C0318a() {
                        public void onPositive() {
                        }

                        public void onNegative() {
                            e.this.f23608b.j("3030");
                        }
                    });
                }
            });
        }
        this.j.removeAllViews();
        int i3 = 0;
        for (final OrderDetail next : checkoutItem.getOrderDetailList()) {
            final com.shopee.app.ui.order.views.d a3 = OrderHeaderView_.a(getContext());
            a3.setAvatar(next.getPortrait());
            a3.setPrice(au.b(next.getPriceBeforeDiscount()));
            a3.setUsername(next.getUserName());
            if (i3 == 0) {
                a3.setBackgroundResource(R.drawable.top_and_bottom_border_white_background);
            } else {
                a3.setBackgroundResource(R.drawable.bottom_border_white_background);
            }
            int i4 = this.D;
            a3.setPadding(i4, this.C, i4, z2 ? 1 : 0);
            a3.a(z2);
            AnonymousClass4 r9 = new View.OnClickListener() {
                public void onClick(View view) {
                    List<View> list = (List) a3.getTag();
                    if (a3.d()) {
                        a3.c();
                        e.this.S.remove(Long.valueOf(next.getOrderId()));
                        for (View visibility : list) {
                            visibility.setVisibility(8);
                        }
                        return;
                    }
                    a3.b();
                    e.this.S.add(Long.valueOf(next.getOrderId()));
                    for (View visibility2 : list) {
                        visibility2.setVisibility(0);
                    }
                }
            };
            a3.a(true, r9);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i3 == 0) {
                layoutParams.topMargin = this.D;
            }
            this.j.addView(a3, layoutParams);
            ArrayList arrayList = new ArrayList();
            for (OrderItemInfo orderItemInfo : next.getItems()) {
                k a4 = l.a(getContext());
                a4.setOrderItemInfo(orderItemInfo);
                int i5 = this.D;
                int i6 = this.C;
                a4.setPadding(i5, i6, i5, i6);
                arrayList.add(a4);
                this.j.addView(a4, new ViewGroup.LayoutParams(-1, -2));
            }
            if (!next.isPayOffline()) {
                com.shopee.app.ui.order.views.h a5 = OrderRemarkView_.a(getContext());
                a5.setLabel(b.e(R.string.sp_label_status_shipping));
                f a6 = f.a(getContext());
                String actualCarrier = next.getActualCarrier();
                if (TextUtils.isEmpty(actualCarrier)) {
                    actualCarrier = b.e(R.string.sp_seller_arranged_logistics);
                }
                a6.a(actualCarrier + SQLBuilder.BLANK).b();
                if (next.getShippingFee() != next.getOriginShippingFee()) {
                    a6.a(au.b(next.getOriginShippingFee())).a().b().c().b();
                }
                a6.a(SQLBuilder.BLANK + au.b(next.getShippingFee())).a().b(b.a(R.color.primary)).c().b();
                a5.setRemark(a6.b());
                arrayList.add(a5);
                this.j.addView(a5);
            }
            if (!TextUtils.isEmpty(next.getRemark())) {
                com.shopee.app.ui.order.views.h a7 = OrderRemarkView_.a(getContext());
                a7.setRemark(next.getRemark());
                arrayList.add(a7);
                this.j.addView(a7);
            }
            com.shopee.app.ui.order.views.e a8 = OrderInfoView_.a(getContext());
            a8.setOrderNumber("#" + next.getSerialNumber());
            a8.setOrderTime(com.garena.android.appkit.tools.a.a.a(next.getCreateTime(), "ID"));
            a8.setBackgroundResource(R.drawable.bottom_border_white_background);
            int i7 = this.D;
            int i8 = this.C;
            a8.setPadding(i7, i8, i7, b.a.f7693d + i8);
            arrayList.add(a8);
            this.j.addView(a8);
            i a9 = OrderShopFooter_.a(getContext());
            a9.setSeller(next);
            a9.setBackgroundResource(R.drawable.bottom_border_white_background);
            int i9 = this.D;
            int i10 = this.C;
            a9.setPadding(i9, i10, i9, b.a.f7693d + i10);
            arrayList.add(a9);
            this.j.addView(a9);
            a3.setTag(arrayList);
            if (!this.S.contains(Long.valueOf(next.getOrderId()))) {
                r9.onClick(a3);
            }
            i3++;
            z2 = false;
        }
        a.C0251a d2 = a2.d();
        this.B.setVisibility(d2.a());
        this.B.setEnabled(d2.b());
        this.B.setText(d2.f15983a);
        this.B.setOnClickListener(d2.f15984b);
        a.C0251a i11 = a2.i();
        this.x.setVisibility(i11.a());
        this.x.setText(i11.f15983a);
        this.x.setOnClickListener(i11.f15984b);
        a.C0251a f2 = a2.f();
        this.y.setVisibility(f2.a());
        this.y.setText(f2.f15983a);
        this.y.setOnClickListener(f2.f15984b);
        a.C0251a g2 = a2.g();
        this.z.setVisibility(g2.a());
        this.z.setText(g2.f15983a);
        this.z.setOnClickListener(g2.f15984b);
        a.C0251a h2 = a2.h();
        this.A.setVisibility(h2.a());
        this.A.setText(h2.f15983a);
        this.A.setOnClickListener(h2.f15984b);
    }

    public void setEmptyView(boolean z2) {
        if (z2) {
            this.f23610d.setVisibility(8);
            this.f23611e.setVisibility(8);
            this.j.setVisibility(8);
            this.u.setVisibility(8);
            this.v.setVisibility(0);
            return;
        }
        this.f23610d.setVisibility(0);
        this.f23611e.setVisibility(0);
        this.u.setVisibility(0);
        this.j.setVisibility(0);
        this.v.setVisibility(8);
    }

    private void a(int i2) {
        if ((K & i2) != 0) {
            this.k.setVisibility(0);
            this.p.setVisibility(0);
        } else {
            this.k.setVisibility(8);
            this.p.setVisibility(8);
        }
        if ((L & i2) != 0) {
            this.l.setVisibility(0);
            this.q.setVisibility(0);
        } else {
            this.l.setVisibility(8);
            this.q.setVisibility(8);
        }
        if ((M & i2) != 0) {
            this.m.setVisibility(0);
            this.r.setVisibility(0);
        } else {
            this.m.setVisibility(8);
            this.r.setVisibility(8);
        }
        if ((N & i2) != 0) {
            this.n.setVisibility(0);
            this.s.setVisibility(0);
        } else {
            this.n.setVisibility(8);
            this.s.setVisibility(8);
        }
        if ((i2 & O) != 0) {
            this.o.setVisibility(0);
            this.t.setVisibility(0);
            return;
        }
        this.o.setVisibility(8);
        this.t.setVisibility(8);
    }

    private int getVisibleMasks() {
        if (!this.Q.hasValidUniqueCode() && !this.Q.isUnderPaid() && !this.Q.hasPromotion()) {
            return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (!this.Q.hasValidUniqueCode() && !this.Q.isUnderPaid() && this.Q.hasPromotion()) {
            return 65553;
        }
        if (!this.Q.hasValidUniqueCode() && this.Q.isUnderPaid() && !this.Q.hasPromotion()) {
            return 65793;
        }
        if (!this.Q.hasValidUniqueCode() && this.Q.isUnderPaid() && this.Q.hasPromotion()) {
            return 65809;
        }
        if (this.Q.hasValidUniqueCode() && !this.Q.isUnderPaid() && !this.Q.hasPromotion()) {
            return 69633;
        }
        if (this.Q.hasValidUniqueCode() && !this.Q.isUnderPaid() && this.Q.hasPromotion()) {
            return 69649;
        }
        if (this.Q.hasValidUniqueCode() && this.Q.isUnderPaid() && !this.Q.hasPromotion()) {
            return 69889;
        }
        if (!this.Q.hasValidUniqueCode() || !this.Q.isUnderPaid() || !this.Q.hasPromotion()) {
            return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        return 69905;
    }

    private void e() {
        this.p.setText(au.b(this.Q.getPriceBeforeDiscount()));
    }

    private void f() {
        this.q.setText(this.Q.getDiscount());
        this.q.setOnClickListener(this.I);
    }

    private void g() {
        this.r.setText(au.b(this.Q.getPaidAmount()));
    }

    private void h() {
        this.s.setText(au.c(this.Q.getUniqueCode()));
        this.s.setOnClickListener(this.J);
    }

    private void i() {
        this.t.setText(au.b(this.Q.getPayable()));
    }

    private void j() {
        a(getVisibleMasks());
        if (this.Q.hasValidUniqueCode() || this.Q.isUnderPaid() || this.Q.hasPromotion()) {
            this.o.setText(this.G);
            if (!this.Q.hasValidUniqueCode() && !this.Q.isUnderPaid() && this.Q.hasPromotion()) {
                e();
                f();
                i();
            } else if (!this.Q.hasValidUniqueCode() && this.Q.isUnderPaid() && !this.Q.hasPromotion()) {
                e();
                g();
                i();
            } else if (!this.Q.hasValidUniqueCode() && this.Q.isUnderPaid() && this.Q.hasPromotion()) {
                e();
                f();
                g();
                i();
            } else if (this.Q.hasValidUniqueCode() && !this.Q.isUnderPaid() && !this.Q.hasPromotion()) {
                e();
                h();
                i();
            } else if (this.Q.hasValidUniqueCode() && !this.Q.isUnderPaid() && this.Q.hasPromotion()) {
                e();
                f();
                h();
                i();
            } else if (this.Q.hasValidUniqueCode() && this.Q.isUnderPaid() && !this.Q.hasPromotion()) {
                e();
                g();
                h();
                i();
            } else if (this.Q.hasValidUniqueCode() && this.Q.isUnderPaid() && this.Q.hasPromotion()) {
                e();
                f();
                g();
                h();
                i();
            }
        } else {
            this.t.setText(au.b(this.Q.getTotalPrice()));
            this.o.setText(this.F);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f23608b.a(0, this.Q.getCheckoutId());
    }

    public void a(OrderDetail orderDetail) {
        this.f23608b.a(orderDetail.getOrderId(), orderDetail.getShopId());
    }

    public void c() {
        r.a().b((int) R.string.sp_order_be_cancelled);
        this.H.finish();
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void d() {
        this.H.finish();
    }

    private static class a implements i.a {
        public void a() {
        }

        private a() {
        }

        public void a(String str) {
            m.a(str, com.garena.android.appkit.tools.b.e(R.string.sp_info_copied));
        }
    }
}
