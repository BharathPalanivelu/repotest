package com.shopee.app.ui.income.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.f;
import com.afollestad.materialdialogs.f;
import com.facebook.appevents.AppEventsConstants;
import com.garena.android.appkit.tools.a.b;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.income.ShopBalance;
import com.shopee.app.ui.income.b;
import com.shopee.app.ui.income.h;
import com.shopee.app.util.ak;
import com.shopee.app.util.au;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.Calendar;

public class a extends com.shopee.app.ui.income.b.a {

    /* renamed from: a  reason: collision with root package name */
    TextView f23094a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23095b;

    /* renamed from: c  reason: collision with root package name */
    TextView f23096c;

    /* renamed from: d  reason: collision with root package name */
    TextView f23097d;

    /* renamed from: e  reason: collision with root package name */
    TextView f23098e;

    /* renamed from: f  reason: collision with root package name */
    ak f23099f;

    /* renamed from: g  reason: collision with root package name */
    TextView f23100g;
    TextView h;
    TextView i;
    RelativeLayout j;
    RelativeLayout k;
    ImageView l;
    be m;
    UserInfo n;
    /* access modifiers changed from: private */
    public final int o;
    private f p;
    private final int q;

    private int a(int i2) {
        return i2 != 0 ? i2 != 2 ? R.string.sp_label_offline_income : R.string.sp_label_escrow_transactions : R.string.sp_label_transactions_released;
    }

    private int b(int i2) {
        return i2 != 0 ? i2 != 2 ? R.string.sp_label_offline_income : R.string.sp_label_escrow : R.string.sp_label_released_amount;
    }

    private int c(int i2) {
        return i2 != 0 ? i2 != 2 ? R.string.sp_offline_income_help_text : R.string.sp_escrow_help_text : R.string.sp_escrow_released_help_text;
    }

    public void setAmount(Long l2) {
    }

    public a(Context context, int i2) {
        super(context);
        this.o = i2;
        ((b) ((x) context).b()).a(this);
        Calendar instance = Calendar.getInstance();
        instance.set(7, 2);
        instance.setFirstDayOfWeek(2);
        this.q = (int) (instance.getTimeInMillis() / 1000);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f23098e.setText(a(this.o));
        if (this.o == 2) {
            if (this.n.isWalletFeatureOn()) {
                this.k.setVisibility(8);
                this.j.setVisibility(8);
                this.f23098e.setVisibility(8);
            } else {
                this.k.setVisibility(0);
                this.j.setVisibility(0);
                this.f23098e.setVisibility(0);
            }
            f.a(getContext()).a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_label_released_amount)).a().a(b.a.k).c().b().b().a(this.f23100g);
            this.p = f.a(getContext());
            this.p.a((Object) AppEventsConstants.EVENT_PARAM_VALUE_NO).a(AppMeasurementSdk.ConditionalUserProperty.VALUE).b().b().a(this.h);
        }
    }

    public void a(ShopBalance shopBalance) {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        int i2 = this.o;
        if (i2 == 0) {
            this.f23096c.setText(au.b(shopBalance.getOther()));
            this.f23094a.setVisibility(8);
            this.f23095b.setVisibility(8);
        } else if (i2 == 1) {
            long other = shopBalance.getOther();
            if (other < 0) {
                str = "-" + au.b(Math.abs(other));
            } else {
                str = au.b(other);
            }
            this.f23096c.setText(str);
            this.f23094a.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_self_arrange));
            this.f23095b.setVisibility(8);
        } else if (i2 != 2) {
            long other2 = shopBalance.getOther();
            if (other2 < 0) {
                str3 = "-" + au.b(Math.abs(other2));
            } else {
                str3 = au.b(other2);
            }
            this.f23096c.setText(str3);
            this.f23094a.setVisibility(8);
            this.f23095b.setVisibility(8);
        } else {
            long frozen = shopBalance.getFrozen();
            if (frozen < 0) {
                str2 = "-" + au.b(Math.abs(frozen));
            } else {
                str2 = au.b(frozen);
            }
            this.f23096c.setText(str2);
            this.f23098e.setText(com.garena.android.appkit.tools.b.a(R.string.sp_label_escrow_transactions_amount, str2));
            this.f23094a.setCompoundDrawablesWithIntrinsicBounds(com.garena.android.appkit.tools.b.f(R.drawable.ic_guarantee), (Drawable) null, (Drawable) null, (Drawable) null);
            sb.append(SQLBuilder.BLANK);
            sb.append(com.garena.android.appkit.tools.b.e(R.string.sp_label_under_escrow));
            this.f23094a.setText(sb.toString());
            if (this.n.isWalletFeatureOn()) {
                this.f23095b.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f23094a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.addRule(14);
                    this.f23094a.setLayoutParams(layoutParams);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f23096c.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.addRule(14);
                    this.f23096c.setLayoutParams(layoutParams2);
                    return;
                }
                return;
            }
            this.f23095b.setText(com.garena.android.appkit.tools.b.e(R.string.sp_to_be_released));
        }
    }

    public void b() {
        if (this.o == 2 && this.m.f() != 0) {
            f();
        }
    }

    public void b(ShopBalance shopBalance) {
        String str;
        if (this.o != 2) {
            return;
        }
        if (this.m.f() == 0) {
            long currentWeek = shopBalance.getCurrentWeek();
            if (currentWeek < 0) {
                str = "-" + au.b(Math.abs(currentWeek));
            } else {
                str = au.b(currentWeek);
            }
            this.p.b(AppMeasurementSdk.ConditionalUserProperty.VALUE).a((Object) str);
            this.p.a(this.h);
            return;
        }
        f();
    }

    private void f() {
        String str;
        String str2;
        long a2 = this.m.a();
        if (a2 < 0) {
            str = "-" + au.b(Math.abs(a2));
        } else {
            str = au.b(a2);
        }
        this.p.b(AppMeasurementSdk.ConditionalUserProperty.VALUE).a((Object) str);
        this.p.a(this.h);
        h hVar = new h(this.m.f(), this.m.g());
        if (Math.abs(hVar.f23182a - this.q) < 43200) {
            this.f23097d.setText(com.garena.android.appkit.tools.b.e(R.string.sp_release_amount_current_week));
            return;
        }
        if (hVar.f23182a == -1) {
            str2 = com.garena.android.appkit.tools.b.e(R.string.sp_all);
        } else {
            str2 = com.garena.android.appkit.tools.a.a.c(hVar.f23182a, "ID") + " - " + com.garena.android.appkit.tools.a.a.c(hVar.f23183b, "ID");
        }
        this.f23097d.setText(SQLBuilder.PARENTHESES_LEFT + str2 + SQLBuilder.PARENTHESES_RIGHT);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        com.shopee.app.ui.dialog.a.a(getContext(), b(this.o), c(this.o), this.o == 2 ? R.string.sp_label_learn_more : 0, (int) R.string.sp_label_ok, (f.b) new f.b() {
            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                if (a.this.o == 2) {
                    a.this.f23099f.j("3030");
                }
            }

            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                fVar.dismiss();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f23099f.M();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f23099f.K();
    }

    public void a(ShopDetail shopDetail) {
        int bankStatus = shopDetail.getBankStatus();
        if (bankStatus == 0) {
            this.i.setText(R.string.sp_label_add);
        } else if (bankStatus == 1) {
            this.i.setText(R.string.sp_label_under_review);
        } else if (bankStatus != 2) {
            if (bankStatus != 3) {
                if (bankStatus == 4) {
                    this.i.setText(R.string.sp_label_checked);
                    return;
                } else if (bankStatus != 5) {
                    return;
                }
            }
            this.i.setText(R.string.sp_bank_account_rejected);
        } else {
            this.i.setText(shopDetail.getBankNoSecret());
        }
    }
}
