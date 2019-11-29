package com.shopee.app.ui.shopassistant.shopSetting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ScrollView;
import com.a.a.f;
import com.afollestad.materialdialogs.f;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.h.q;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.setting.cell.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class n extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    ak f25608a;

    /* renamed from: b  reason: collision with root package name */
    r f25609b;

    /* renamed from: c  reason: collision with root package name */
    Activity f25610c;

    /* renamed from: d  reason: collision with root package name */
    l f25611d;

    /* renamed from: e  reason: collision with root package name */
    bc f25612e;

    /* renamed from: f  reason: collision with root package name */
    UserInfo f25613f;

    /* renamed from: g  reason: collision with root package name */
    a f25614g;
    a h;
    a i;
    a j;
    a k;
    View l;
    SettingConfigStore m;
    private boolean n = false;
    private View.OnClickListener o = new View.OnClickListener() {
        public void onClick(View view) {
            n.this.h();
        }
    };

    public n(Context context) {
        super(context);
        ((j) ((x) context).b()).a(this);
    }

    public void a() {
        this.f25609b.a();
    }

    public void b() {
        this.f25609b.b();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f25612e.a(this.f25611d);
        this.f25611d.a(this);
        this.f25611d.e();
        this.f25614g.setOnClickListener(this.o);
        this.h.setOnClickListener(this.o);
        if (this.m.isShowFullAddress()) {
            this.i.setVisibility(0);
            this.i.setOnClickListener(this.o);
        } else {
            this.i.setVisibility(8);
        }
        a(this.f25613f);
    }

    public void a(UserInfo userInfo) {
        this.f25613f = userInfo;
        if (TextUtils.isEmpty(this.f25613f.getPhone()) || this.m.hidePhonePublicOption()) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.j.setOnClickListener((View.OnClickListener) null);
            this.j.setChecked(this.f25613f.isPhonePublic());
            this.j.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    n.this.f25611d.a(n.this.j.c());
                }
            });
        }
        if (this.f25613f.isCrossBorder() || !this.m.allowSelfArrange()) {
            this.f25614g.setVisibility(8);
        } else {
            this.f25614g.setVisibility(0);
        }
        if (this.m.vacationModeEnabled()) {
            f();
        } else {
            this.k.setVisibility(8);
            this.l.setVisibility(8);
        }
        this.n = true;
    }

    /* access modifiers changed from: private */
    public void f() {
        final f a2 = f.a(getContext());
        a2.b((int) R.drawable.ic_help_2).c(b.a.l).a();
        f a3 = f.a(getContext());
        a3.a().a((Object) 0).a((com.a.a.a) new com.a.a.a() {
            public SpannedString format(Object obj) {
                String str = com.garena.android.appkit.tools.b.e(R.string.sp_vacation_mode) + "  ";
                SpannableString spannableString = new SpannableString(a2.b());
                spannableString.setSpan(new ClickableSpan() {
                    public void onClick(View view) {
                        n.this.g();
                    }
                }, 0, spannableString.length(), 17);
                return new SpannedString(new SpannableStringBuilder().append(str).append(spannableString));
            }
        }).b();
        this.k.setTextPrimary(a3);
        this.k.setVisibility(0);
        this.k.setOnClickListener((View.OnClickListener) null);
        this.k.setChecked(this.f25613f.isHolidayMode());
        this.k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new f.a(n.this.getContext()).c(n.this.k.c() ? R.string.sp_vacation_mode_activation : R.string.sp_vacation_mode_deactivation).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary)).d((int) R.string.sp_label_ok).h(R.string.sp_label_cancel).b(false).a((f.b) new f.b() {
                    public void onNegative(com.afollestad.materialdialogs.f fVar) {
                        fVar.dismiss();
                    }

                    public void onPositive(com.afollestad.materialdialogs.f fVar) {
                        fVar.dismiss();
                        n.this.f25611d.b(n.this.k.c());
                    }
                }).a((DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        n.this.f();
                    }
                }).c();
            }
        });
        this.l.setVisibility(0);
        if (com.garena.android.appkit.tools.a.a.a() - this.f25613f.getHolidayModeTime() > 3600 || !this.f25613f.isHolidayMode()) {
            this.k.setViewVisualEnabled(true);
            if (com.garena.android.appkit.tools.a.a.a() - this.f25613f.getHolidayModeTime() > 86400 || this.f25613f.isHolidayMode()) {
                this.k.setViewVisualEnabled(true);
                return;
            }
            this.k.setViewVisualEnabled(false);
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    new f.a(n.this.getContext()).c((int) R.string.sp_vacation_deactive_error).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary)).d((int) R.string.sp_label_ok).a((DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            n.this.f();
                        }
                    }).c();
                }
            });
            return;
        }
        this.k.setViewVisualEnabled(false);
        this.k.setOnClickListener((View.OnClickListener) null);
        this.k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new f.a(n.this.getContext()).c((int) R.string.sp_vacation_active_error).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary)).d((int) R.string.sp_label_ok).a((DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        n.this.f();
                    }
                }).c();
            }
        });
    }

    /* access modifiers changed from: private */
    public void g() {
        new f.a(getContext()).c((int) R.string.sp_vacation_mode_notice).g(com.garena.android.appkit.tools.b.a(R.color.primary)).h(R.string.sp_label_learn_more).e(com.garena.android.appkit.tools.b.a(R.color.primary)).d((int) R.string.sp_label_ok).a((f.b) new f.b() {
            public void onPositive(com.afollestad.materialdialogs.f fVar) {
            }

            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                n.this.f25608a.k("holiday_mode");
            }
        }).a((DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
            }
        }).c();
    }

    public void d() {
        h();
        this.f25610c.finish();
    }

    /* access modifiers changed from: private */
    public void h() {
        a();
        if (this.m.isShowFullAddress()) {
            this.f25611d.a(this.f25614g.c(), this.h.c(), this.i.c());
        } else {
            this.f25611d.a(this.f25614g.c(), this.h.c());
        }
    }

    public void a(ShopDetail shopDetail) {
        this.f25614g.setOnClickListener((View.OnClickListener) null);
        this.f25614g.setChecked(shopDetail.hasOfflinePayment());
        this.f25614g.setOnClickListener(this.o);
        this.h.setOnClickListener((View.OnClickListener) null);
        this.h.setChecked(shopDetail.isOfferEnabled());
        this.h.setOnClickListener(this.o);
        if (this.m.isShowFullAddress()) {
            this.i.setOnClickListener((View.OnClickListener) null);
            this.i.setChecked(shopDetail.isShowFullAddress());
            this.i.setOnClickListener(this.o);
        }
    }

    public void a(String str) {
        q.a((View) this, str);
        this.f25611d.f();
    }

    public void b(String str) {
        q.a((View) this, str);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f25608a.X();
    }

    public void a(int i2) {
        com.shopee.app.h.r.a().b(i2);
    }
}
