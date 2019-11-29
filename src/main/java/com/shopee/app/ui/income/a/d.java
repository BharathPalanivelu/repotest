package com.shopee.app.ui.income.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.data.viewmodel.income.TransactionItem;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.ai;
import com.shopee.app.util.au;
import com.shopee.id.R;

public class d extends FrameLayout implements n<TransactionItem> {

    /* renamed from: a  reason: collision with root package name */
    ImageView f23107a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23108b;

    /* renamed from: c  reason: collision with root package name */
    TextView f23109c;

    /* renamed from: d  reason: collision with root package name */
    TextView f23110d;

    /* renamed from: e  reason: collision with root package name */
    TextView f23111e;

    /* renamed from: f  reason: collision with root package name */
    TextView f23112f;

    /* renamed from: g  reason: collision with root package name */
    int f23113g;
    int h;
    int i;
    private f j;
    private f k;
    private int l;

    private int a(int i2) {
        return (i2 == 0 || i2 != 2) ? R.string.sp_label_release_date : R.string.sp_label_estimated_release_date;
    }

    public d(Context context, int i2) {
        super(context);
        this.l = i2;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.j = f.a(getContext());
        this.k = f.a(getContext());
        this.k.a((Object) "$0").a("order_amount").a().b(b.a(R.color.primary)).c().b();
        this.k.a(this.f23112f);
        this.j.a((Object) "").a("release_date").a().b(this.f23113g).a(b.a.h).c().b();
        this.j.a(this.f23110d);
    }

    public void a(TransactionItem transactionItem) {
        String str;
        this.f23108b.setText(transactionItem.getOrderTitle());
        this.f23109c.setText(transactionItem.getCustomerName());
        long amount = transactionItem.getAmount();
        if (amount < 0) {
            str = "-" + au.b(Math.abs(amount));
        } else {
            str = au.b(amount);
        }
        this.k.b("order_amount").a((Object) str);
        this.k.a(this.f23112f);
        if (TextUtils.isEmpty(a(this.l, transactionItem.getStatus()))) {
            this.j.b("release_date").a((Object) b(transactionItem));
        } else {
            this.j.b("release_date").a((Object) a(this.l, transactionItem.getStatus()));
        }
        if (TextUtils.isEmpty(a(this.l, transactionItem.getStatus(), transactionItem.isUsingWallet()))) {
            this.f23111e.setVisibility(8);
        } else {
            this.f23111e.setVisibility(0);
            this.f23111e.setText(a(this.l, transactionItem.getStatus(), transactionItem.isUsingWallet()));
        }
        this.j.a(this.f23110d);
        ai.a(getContext()).a(transactionItem.getImage(), this.f23107a);
    }

    public String b(TransactionItem transactionItem) {
        int i2 = this.l;
        if (i2 == 0) {
            return com.garena.android.appkit.tools.b.a(a(i2), a.c(transactionItem.getTime(), "ID"));
        } else if (i2 != 2) {
            return com.garena.android.appkit.tools.b.a(a(i2), a.c(transactionItem.getTime(), "ID"));
        } else if (transactionItem.isVerified()) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_ready_to_release);
        } else {
            return com.garena.android.appkit.tools.b.a(a(this.l), a.c(transactionItem.getReleaseTime(), "ID"));
        }
    }

    private String a(int i2, int i3, boolean z) {
        if (i2 != 0) {
            if (i2 != 2) {
                return "";
            }
            if (i3 == 0) {
                return com.garena.android.appkit.tools.b.e(R.string.sp_payment_payment_confirmed);
            }
            if (i3 == 1) {
                return com.garena.android.appkit.tools.b.e(R.string.sp_payment_payment_transferred);
            }
            if (i3 == 2 || i3 == 3) {
                return "";
            }
            if (i3 != 4) {
                return i3 != 5 ? "" : com.garena.android.appkit.tools.b.e(R.string.sp_payment_payment_initiated);
            }
            return com.garena.android.appkit.tools.b.e(R.string.sp_payment_order_received);
        } else if (z) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_released_to_wallet_status);
        } else {
            return "";
        }
    }

    private String a(int i2, int i3) {
        if (i2 != 0 || i3 != 0) {
            return "";
        }
        return SQLBuilder.BLANK + com.garena.android.appkit.tools.b.e(R.string.sp_label_processing) + SQLBuilder.BLANK;
    }
}
