package com.shopee.app.ui.income.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.f;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.income.ShopBalance;
import com.shopee.app.ui.income.b;
import com.shopee.app.ui.income.b.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.au;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.Calendar;

public class h extends a {
    private View.OnFocusChangeListener A = new View.OnFocusChangeListener() {
        public void onFocusChange(View view, boolean z) {
            if (z) {
                h.this.j();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    TextView f23118a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23119b;

    /* renamed from: c  reason: collision with root package name */
    ak f23120c;

    /* renamed from: d  reason: collision with root package name */
    TextView f23121d;

    /* renamed from: e  reason: collision with root package name */
    TextView f23122e;

    /* renamed from: f  reason: collision with root package name */
    RelativeLayout f23123f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f23124g;
    EditText h;
    TextView i;
    TextView j;
    View k;
    View l;
    TextView m;
    View n;
    View o;
    Activity p;
    f q;
    bc r;
    bi s;
    be t;
    UserInfo u;
    /* access modifiers changed from: private */
    public final int v;
    /* access modifiers changed from: private */
    public com.shopee.app.ui.income.h w;
    private Dialog x;
    private final int y;
    private long z;

    public void a(ShopDetail shopDetail) {
    }

    public void a(ShopBalance shopBalance) {
    }

    public h(Context context, int i2) {
        super(context);
        this.v = i2;
        ((b) ((x) context).b()).a(this);
        Calendar instance = Calendar.getInstance();
        instance.set(7, 2);
        instance.setFirstDayOfWeek(2);
        this.y = (int) (instance.getTimeInMillis() / 1000);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.r.a(this.q);
        this.q.a(this);
        if (this.t.f() != 0) {
            this.w = new com.shopee.app.ui.income.h(this.t.f(), this.t.g());
        } else {
            this.w = new com.shopee.app.ui.income.h(this.y, com.garena.android.appkit.tools.a.a.a());
        }
        a(new ShopBalance());
        this.f23121d.setText(com.garena.android.appkit.tools.b.e(R.string.sp_total_released_amount));
        this.k.requestFocus();
        if (this.u.isWalletFeatureOn()) {
            this.l.setVisibility(8);
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.f23123f.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f23118a.getLayoutParams();
            layoutParams.addRule(14);
            this.f23118a.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f23119b.getLayoutParams();
            layoutParams2.addRule(14);
            this.f23119b.setLayoutParams(layoutParams2);
            this.z = n();
            long j2 = (this.z - 604800000) + 1;
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j2);
            this.i.setTag(Long.valueOf(j2));
            this.i.setText(com.garena.android.appkit.tools.a.a.c((int) (instance.getTimeInMillis() / 1000), "ID"));
            long j3 = this.z;
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j3);
            this.j.setTag(Long.valueOf(j3));
            this.j.setText(com.garena.android.appkit.tools.a.a.c((int) (instance2.getTimeInMillis() / 1000), "ID"));
            m();
            return;
        }
        this.h.setOnFocusChangeListener(this.A);
        this.f23118a.setText(com.garena.android.appkit.tools.b.e(R.string.sp_release_amount_current_week));
        post(new Runnable() {
            public void run() {
                h hVar = h.this;
                hVar.setTimeText(hVar.w);
            }
        });
        this.o.setVisibility(8);
        this.n.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setVisibility(8);
        this.f23123f.setVisibility(0);
    }

    public void b(ShopBalance shopBalance) {
        String str;
        StringBuilder sb = new StringBuilder(SQLBuilder.BLANK);
        long available = shopBalance.getAvailable();
        if (available < 0) {
            str = "-" + au.b(available);
        } else {
            str = au.b(available);
        }
        sb.append(str);
        this.f23122e.setText(sb.toString());
        this.m.setText(com.garena.android.appkit.tools.b.a(R.string.sp_released_to_wallet, str));
    }

    private void h() {
        this.s.a("INCOME_TIME_FILTER", new com.garena.android.appkit.b.a(this.h.getTag()));
        this.k.requestFocus();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        j();
    }

    public void setTimeText(com.shopee.app.ui.income.h hVar) {
        String str;
        String str2;
        if (Math.abs(hVar.f23182a - this.y) < 43200) {
            this.f23118a.setText(com.garena.android.appkit.tools.b.e(R.string.sp_release_amount_current_week));
        } else {
            if (hVar.f23182a == -1) {
                str2 = com.garena.android.appkit.tools.b.e(R.string.sp_all);
            } else {
                str2 = com.garena.android.appkit.tools.a.a.c(hVar.f23182a, "ID") + " - " + com.garena.android.appkit.tools.a.a.c(hVar.f23183b, "ID");
            }
            this.f23118a.setText(com.garena.android.appkit.tools.b.e(R.string.sp_release_amount) + " (" + str2 + SQLBuilder.PARENTHESES_RIGHT);
        }
        this.h.setOnFocusChangeListener((View.OnFocusChangeListener) null);
        if (hVar.f23182a == -1) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_all);
        } else {
            str = com.garena.android.appkit.tools.a.a.c(hVar.f23182a, "ID") + " - " + com.garena.android.appkit.tools.a.a.c(hVar.f23183b, "ID");
        }
        this.h.setText(str);
        this.h.setTag(hVar);
        this.h.setOnFocusChangeListener(this.A);
        h();
        i();
    }

    private void i() {
        Dialog dialog = this.x;
        if (dialog != null && dialog.isShowing()) {
            this.x.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        i();
        this.x = com.shopee.app.ui.dialog.a.a(getContext(), (f.b) new f.b() {
            public void onPositive(f fVar) {
                h.this.s.a().ao.a(h.this.w).a();
            }
        });
    }

    public void setAmount(Long l2) {
        String str;
        if (l2.longValue() < 0) {
            str = "-" + au.b(l2.longValue());
        } else {
            str = au.b(l2.longValue());
        }
        if (this.u.isWalletFeatureOn()) {
            this.f23119b.setText(str);
            return;
        }
        com.shopee.app.ui.income.h hVar = (com.shopee.app.ui.income.h) this.h.getTag();
        if (hVar != null) {
            this.t.a(hVar.f23182a);
            this.t.b(hVar.f23183b);
            this.t.a(l2.longValue());
            this.f23119b.setText(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        com.shopee.app.ui.dialog.a.a(getContext(), ((Long) this.i.getTag()).longValue(), 1420070400000L, this.z, (DatePicker.OnDateChangedListener) new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
                Calendar instance = Calendar.getInstance();
                instance.set(i, i2, i3);
                h.this.i.setTag(Long.valueOf(instance.getTimeInMillis()));
                h.this.i.setText(com.garena.android.appkit.tools.a.a.c((int) (instance.getTimeInMillis() / 1000), "ID"));
                h.this.k();
                h.this.m();
            }
        }, (f.b) new f.b() {
        });
    }

    /* access modifiers changed from: package-private */
    public void e() {
        com.shopee.app.ui.dialog.a.a(getContext(), ((Long) this.j.getTag()).longValue(), 1420070400000L, this.z, (DatePicker.OnDateChangedListener) new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
                Calendar instance = Calendar.getInstance();
                instance.set(i, i2, i3);
                h.this.j.setTag(Long.valueOf(instance.getTimeInMillis()));
                h.this.j.setText(com.garena.android.appkit.tools.a.a.c((int) (instance.getTimeInMillis() / 1000), "ID"));
                h.this.l();
                h.this.m();
            }
        }, (f.b) new f.b() {
        });
    }

    /* access modifiers changed from: private */
    public void k() {
        if (((int) (((Long) this.j.getTag()).longValue() / 1000)) < ((int) (((Long) this.i.getTag()).longValue() / 1000))) {
            this.j.setTag(this.i.getTag());
            this.j.setText(this.i.getText());
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        if (((int) (((Long) this.i.getTag()).longValue() / 1000)) > ((int) (((Long) this.j.getTag()).longValue() / 1000))) {
            this.i.setTag(this.j.getTag());
            this.i.setText(this.j.getText());
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        com.shopee.app.ui.income.h hVar = new com.shopee.app.ui.income.h((int) (((Long) this.i.getTag()).longValue() / 1000), (int) (((Long) this.j.getTag()).longValue() / 1000));
        this.f23118a.setText(com.garena.android.appkit.tools.b.e(R.string.sp_release_amount) + " (" + (com.garena.android.appkit.tools.a.a.c(hVar.f23182a, "ID") + " - " + com.garena.android.appkit.tools.a.a.c(hVar.f23183b, "ID")) + SQLBuilder.PARENTHESES_RIGHT);
        this.s.a("INCOME_TIME_FILTER", new com.garena.android.appkit.b.a(hVar));
    }

    /* access modifiers changed from: package-private */
    public void f() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_label_released_amount, this.u.isWalletFeatureOn() ? R.string.sp_wallet_released_help_text : R.string.sp_escrow_released_help_text, this.v == 2 ? R.string.sp_label_learn_more : 0, (int) R.string.sp_label_ok, (f.b) new f.b() {
            public void onNegative(f fVar) {
                if (h.this.v == 2) {
                    h.this.f23120c.j("3030");
                }
            }

            public void onPositive(f fVar) {
                fVar.dismiss();
            }
        });
    }

    private long n() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(com.garena.android.appkit.tools.a.a.b());
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return (instance.getTimeInMillis() + 86400000) - 1;
    }

    public void b() {
        this.q.c();
        m();
    }

    public void g() {
        this.q.d();
    }
}
