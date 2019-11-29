package com.shopee.app.ui.order.views;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ae;
import com.shopee.app.util.ak;
import com.shopee.app.util.au;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.List;

public class m extends RelativeLayout implements ae.b {

    /* renamed from: a  reason: collision with root package name */
    TextView f23907a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23908b;

    /* renamed from: c  reason: collision with root package name */
    View f23909c;

    /* renamed from: d  reason: collision with root package name */
    int f23910d;

    /* renamed from: e  reason: collision with root package name */
    int f23911e;

    /* renamed from: f  reason: collision with root package name */
    int f23912f;

    /* renamed from: g  reason: collision with root package name */
    int f23913g;
    ak h;
    private List<Long> i;
    private boolean j = false;

    public interface a {
        void a(m mVar);
    }

    public m(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i2 = this.f23911e;
        setPadding(i2, 0, i2, 0);
    }

    public void setIds(List<Long> list) {
        this.i = list;
    }

    public long getIdentifier() {
        return this.i.get(0).longValue();
    }

    public boolean a(long j2) {
        return this.i.contains(Long.valueOf(j2));
    }

    public void setCount(int i2) {
        if (i2 == 1) {
            this.f23907a.setText(b.a(R.string.sp_chat_list_1_item, Integer.valueOf(i2)));
            return;
        }
        this.f23907a.setText(b.a(R.string.sp_chat_list_n_items, Integer.valueOf(i2)));
    }

    public void a(int i2, String str) {
        f a2 = f.a(getContext());
        a2.a().a().b(b.a(R.color.black87)).c().a((Object) b.e(i2) + " : ").b();
        a2.a().a().d().b(b.a(R.color.primary)).c().a((Object) str).b();
        a2.a(this.f23908b);
    }

    public void setTotal(CheckoutItem checkoutItem) {
        f a2 = f.a(getContext());
        if (!checkoutItem.hasValidUniqueCode() && checkoutItem.getStatus() != 3) {
            a2.a((Object) b.e(R.string.sp_label_order_total)).a().d().c().b();
            a2.a(": ").b();
            a2.a((Object) au.b(checkoutItem.getTotalPrice())).a().b(b.a(R.color.primary)).d().c().b();
        }
        if (!checkoutItem.hasValidUniqueCode() && checkoutItem.getStatus() == 3) {
            this.f23908b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            a2.b((int) R.drawable.ic_guarantee).b(b.a.j).c(b.a.j).a();
            a2.a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_label_order_total)).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a(": ").b();
            a2.a((Object) au.b(checkoutItem.getTotalPrice())).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a("\n").b();
            a2.a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_amount_paid)).a().b(com.garena.android.appkit.tools.b.a(R.color.black87)).a(this.f23913g).c().b();
            a2.a(": ").b();
            a2.a((Object) au.b(checkoutItem.getPaidAmount())).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a("\n").b();
            a2.a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_amount_payable)).a().d().c().b();
            a2.a(": ").b();
            a2.a((Object) au.b(checkoutItem.getPayable())).a().b(com.garena.android.appkit.tools.b.a(R.color.primary)).d().c().b();
        }
        if (checkoutItem.hasValidUniqueCode() && checkoutItem.getStatus() != 3) {
            this.f23908b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            a2.b((int) R.drawable.ic_guarantee).b(b.a.j).c(b.a.j).a();
            a2.a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_label_order_total)).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a(": ").b();
            a2.a((Object) au.b(checkoutItem.getTotalPrice())).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a("\n").b();
            a2.a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_unique_code)).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a(": ").b();
            a2.a((Object) au.c(checkoutItem.getUniqueCode())).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a("\n").b();
            a2.a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_amount_payable)).a().d().c().b();
            a2.a(": ").b();
            a2.a((Object) au.b(checkoutItem.getPayable())).a().b(com.garena.android.appkit.tools.b.a(R.color.primary)).d().c().b();
        }
        if (checkoutItem.hasValidUniqueCode() && checkoutItem.getStatus() == 3) {
            this.f23908b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            a2.b((int) R.drawable.ic_guarantee).b(b.a.j).c(b.a.j).a();
            a2.a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_label_order_total)).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a(": ").b();
            a2.a((Object) au.b(checkoutItem.getTotalPrice())).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a("\n").b();
            a2.a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_amount_paid)).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a(": ").b();
            a2.a((Object) au.b(checkoutItem.getPaidAmount())).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a("\n").b();
            a2.a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_unique_code)).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a(": ").b();
            a2.a((Object) au.c(checkoutItem.getUniqueCode())).a().b(this.f23912f).a(this.f23913g).c().b();
            a2.a("\n").b();
            a2.a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_amount_payable)).a().d().c().b();
            a2.a(": ").b();
            a2.a((Object) au.b(checkoutItem.getPayable())).a().b(com.garena.android.appkit.tools.b.a(R.color.primary)).d().c().b();
        }
        a2.a(this.f23908b);
    }

    public void a(int i2) {
        this.f23908b.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        if (i2 == 0 || this.j) {
            this.f23908b.setOnClickListener((View.OnClickListener) null);
        } else {
            this.f23908b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    com.shopee.app.ui.dialog.a.a(m.this.getContext(), com.garena.android.appkit.tools.b.e(R.string.sp_shopee_guarentee_help_popup_text), com.garena.android.appkit.tools.b.e(R.string.sp_label_learn_more), com.garena.android.appkit.tools.b.e(R.string.sp_label_ok), (a.C0318a) new a.C0318a() {
                        public void onPositive() {
                        }

                        public void onNegative() {
                            m.this.h.j("3030");
                        }
                    });
                }
            });
        }
    }

    public void setNoPopup(boolean z) {
        this.j = z;
    }
}
