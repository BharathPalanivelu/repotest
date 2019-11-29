package com.shopee.app.ui.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.i;
import com.afollestad.materialdialogs.f;
import com.garena.android.appkit.b.g;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.f;
import com.shopee.app.data.store.al;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.tracking.trackingv3.model.ViewCommon;
import com.shopee.app.ui.common.a;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.m;
import com.shopee.app.util.n;
import com.shopee.app.web.protocol.RightItemMessage;
import com.shopee.id.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class e extends Activity implements h, bc {
    public static boolean u = false;
    UserInfo A;
    a B;
    ak C;
    f D;
    com.shopee.app.tracking.a E;
    b F;
    al G;

    /* renamed from: a  reason: collision with root package name */
    private i f7000a = new i(this);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<r> f7001b;

    /* renamed from: c  reason: collision with root package name */
    private List<q> f7002c;

    /* renamed from: d  reason: collision with root package name */
    private UserComponent f7003d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Dialog f7004e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f7005f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7006g = true;
    private g h = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            String k = com.shopee.app.react.g.k();
            if (!TextUtils.isEmpty(k)) {
                e.this.C.h(k);
            } else {
                e.this.C.v();
            }
        }
    };
    private g i = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (aVar.data != null) {
                e.this.c(((Boolean) aVar.data).booleanValue());
            }
        }
    };
    private g j = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            e.this.finish();
        }
    };
    private g k = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            e.this.a((int) R.string.sp_password_change_logout_popup);
        }
    };
    private g l = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            int i = ((com.shopee.app.network.c.d.a) aVar.data).f17892a;
            if (i == -100) {
                com.shopee.app.network.e.c().a(true);
            } else if (i == 5) {
                e.this.i();
            } else if (i == 13) {
                e.this.u_();
            } else if (i == 25) {
                e.this.g();
            } else if (i != 35) {
                if (i != 36) {
                    switch (i) {
                        case 9:
                            e.this.v_();
                            return;
                        case 10:
                            return;
                        case 11:
                            break;
                        default:
                            e.this.w_();
                            return;
                    }
                }
                e.this.a((int) R.string.sp_password_change_auto_login_failed_popup);
            } else {
                e.this.C();
            }
        }
    };
    private g m = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            e.this.u_();
        }
    };
    private g n = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            e.this.v_();
        }
    };
    private com.garena.android.appkit.b.e o = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            Pair pair = (Pair) aVar.data;
            int intValue = ((Integer) pair.first).intValue();
            if (4 == intValue) {
                e.this.E.a(((RightItemMessage) pair.second).getKey(), e.this.B(), e.this.j());
            } else if (1 == intValue) {
                e.this.E.a("home", e.this.B(), e.this.j());
            }
        }
    };
    private com.garena.android.appkit.b.e p = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (aVar.data instanceof String) {
                String str = (String) aVar.data;
                if ("more".equals(str)) {
                    e.this.E.a(str, e.this.B(), e.this.j());
                }
            }
        }
    };
    private com.garena.android.appkit.b.e q = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            e.this.E();
        }
    };
    n v;
    bi w;
    com.shopee.app.application.a.b x;
    r y;
    com.shopee.app.tracking.f z;

    /* access modifiers changed from: protected */
    public String B() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void C() {
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
    }

    /* access modifiers changed from: protected */
    public abstract void b(Bundle bundle);

    /* access modifiers changed from: protected */
    public void g() {
    }

    /* access modifiers changed from: protected */
    public String h() {
        return "";
    }

    public void m() {
    }

    public void n() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean o();

    /* access modifiers changed from: protected */
    public o p_() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7005f = String.valueOf(System.currentTimeMillis());
        com.shopee.app.util.n.a aVar = new com.shopee.app.util.n.a(j());
        aVar.a();
        s();
        a(bundle);
        this.w.a("ACTIVITY_KILL_SIGNAL", (com.garena.android.appkit.b.e) this.j);
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            String action = intent.getAction();
            if (intent.hasCategory("android.intent.category.LAUNCHER") && action != null && action.equals("android.intent.action.MAIN")) {
                finish();
                return;
            }
        }
        aVar.b();
        this.f7006g = true;
        this.x.a(this);
    }

    /* access modifiers changed from: protected */
    public void s() {
        setRequestedOrientation(1);
    }

    private void a(Bundle bundle) {
        this.f7003d = ar.a((Context) this).e();
        a(this.f7003d);
        this.f7002c = new ArrayList();
        b(bundle);
    }

    public void setContentView(View view) {
        if (view instanceof r) {
            this.f7001b = new WeakReference<>((r) view);
        }
        super.setContentView(view);
    }

    public void a(q qVar) {
        List<q> list = this.f7002c;
        if (list != null) {
            list.add(qVar);
        }
    }

    public void b(q qVar) {
        List<q> list = this.f7002c;
        if (list != null) {
            list.remove(qVar);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        if (Build.VERSION.SDK_INT < 24 || !ar.g()) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(m.a(context, ar.f().e().deviceStore().a()));
        }
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return !getClass().getSimpleName().equals(j());
    }

    public b z() {
        return this.F;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.x.b(this);
        this.f7000a.a(e.a.ON_START);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.x.c(this);
        this.f7000a.a(e.a.ON_RESUME);
        if (com.shopee.app.h.m.f()) {
            a((int) R.string.sp_password_change_auto_login_failed_popup);
        }
        this.v.a("DUPLICATE_LOGIN", (com.garena.android.appkit.b.e) this.k);
        this.v.a("LOGIN_FAIL", (com.garena.android.appkit.b.e) this.l);
        this.v.a("FACEBOOK_LOGIN_FAIL_BASE", (com.garena.android.appkit.b.e) this.l);
        this.v.a("USER_BAN", (com.garena.android.appkit.b.e) this.n);
        this.v.a("USER_DELETE", (com.garena.android.appkit.b.e) this.m);
        this.v.a("MIN_VERSION_PROBLEM", (com.garena.android.appkit.b.e) this.i);
        this.v.a("FACEBOOK_LOGIN_REGISTER", (com.garena.android.appkit.b.e) this.m);
        this.v.a("NEW_LOGIN", (com.garena.android.appkit.b.e) this.h);
        this.w.a("CLICK", this.o);
        this.w.a("PROMOTION_VOUCHER", this.q);
        this.w.a("more", this.p);
        this.B.a();
        com.garena.android.appkit.e.a.a().a(this);
        ar.f().e().fabricClient().a(j());
        if (this.f7001b != null && o()) {
            if (k()) {
                c(j());
                a(this.f7006g);
                b(this.f7006g);
                if (this.f7006g) {
                    this.f7006g = false;
                }
            }
            r rVar = (r) this.f7001b.get();
            if (rVar != null) {
                rVar.b();
            }
            for (q c2 : this.f7002c) {
                c2.c();
            }
        }
        if (u) {
            D();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.x.e(this);
        this.f7000a.a(e.a.ON_STOP);
    }

    public String A() {
        return this.f7005f;
    }

    public String j() {
        return getClass().getSimpleName();
    }

    /* access modifiers changed from: protected */
    public void c(String str) {
        this.E.a(str);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        this.E.a(this.f7005f, j(), z2, h());
    }

    /* access modifiers changed from: protected */
    public void b(boolean z2) {
        this.F.a(new ViewCommon(z2, !z2, this.f7005f), p_());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.v.b("DUPLICATE_LOGIN", this.k);
        this.v.b("LOGIN_FAIL", this.l);
        this.v.b("FACEBOOK_LOGIN_FAIL_BASE", this.l);
        this.v.b("USER_BAN", this.n);
        this.v.b("USER_DELETE", this.m);
        this.v.b("MIN_VERSION_PROBLEM", this.i);
        this.v.b("FACEBOOK_LOGIN_REGISTER", this.m);
        this.v.b("NEW_LOGIN", this.h);
        this.w.b("CLICK", this.o);
        this.w.b("PROMOTION_VOUCHER", this.q);
        this.w.b("more", this.p);
        this.B.b();
        if (this.f7001b != null && o()) {
            r rVar = (r) this.f7001b.get();
            if (rVar != null) {
                rVar.c();
            }
            for (q d2 : this.f7002c) {
                d2.d();
            }
        }
        this.x.d(this);
        this.f7000a.a(e.a.ON_PAUSE);
        com.garena.android.appkit.e.a.a().a((Activity) null);
    }

    public void onBackPressed() {
        try {
            this.E.a("back", B(), j());
            super.onBackPressed();
        } catch (IllegalStateException unused) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.v.b("ACTIVITY_KILL_SIGNAL", this.j);
        this.f7003d = null;
        WeakReference<r> weakReference = this.f7001b;
        if (weakReference != null) {
            r rVar = (r) weakReference.get();
            if (rVar != null) {
                rVar.d();
            }
            for (q b2 : this.f7002c) {
                b2.b();
            }
            this.f7002c = null;
            this.f7001b = null;
        }
        if (this.f7004e != null) {
            this.f7004e = null;
        }
        this.x.f(this);
        this.f7000a.a(e.a.ON_DESTROY);
    }

    public androidx.lifecycle.e getLifecycle() {
        return this.f7000a;
    }

    /* access modifiers changed from: protected */
    public void c(boolean z2) {
        if (!isFinishing()) {
            Dialog dialog = this.f7004e;
            if (dialog != null && dialog.isShowing()) {
                return;
            }
            if (z2) {
                this.f7004e = com.shopee.app.ui.dialog.a.a((Context) this, 0, (int) R.string.sp_update_app_popup, 0, (int) R.string.sp_label_ok, (f.b) new f.b() {
                    public void onNegative(com.afollestad.materialdialogs.f fVar) {
                        fVar.dismiss();
                        com.shopee.app.network.e.c().a(false);
                        e.this.C.P();
                    }

                    public void onPositive(com.afollestad.materialdialogs.f fVar) {
                        fVar.dismiss();
                        com.shopee.app.network.e.c().a(false);
                        e.this.C.P();
                    }
                }, false);
                return;
            }
            this.f7004e = com.shopee.app.ui.dialog.a.a((Context) this, 0, (int) R.string.sp_update_app_popup, (int) R.string.sp_not_now_capital, (int) R.string.sp_label_ok, (f.b) new f.b() {
                public void onNegative(com.afollestad.materialdialogs.f fVar) {
                }

                public void onPositive(com.afollestad.materialdialogs.f fVar) {
                    e.this.C.P();
                }
            }, true);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        if (!isFinishing()) {
            com.shopee.app.h.m.a(false);
            Dialog dialog = this.f7004e;
            if (dialog == null || !dialog.isShowing()) {
                this.f7004e = com.shopee.app.ui.dialog.a.a((Context) this, 0, i2, 0, (int) R.string.sp_label_ok, (f.b) new f.b() {
                    public void onNegative(com.afollestad.materialdialogs.f fVar) {
                        e.this.y.a();
                        ar.f().i();
                    }

                    public void onPositive(com.afollestad.materialdialogs.f fVar) {
                        fVar.dismiss();
                        e.this.y.a();
                        ar.f().i();
                    }
                }, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void u_() {
        if (!isFinishing()) {
            Dialog dialog = this.f7004e;
            if (dialog == null || !dialog.isShowing()) {
                this.f7004e = com.shopee.app.ui.dialog.a.a((Context) this, 0, (int) R.string.sp_delete_user_popup_msg, 0, (int) R.string.sp_label_ok, (f.b) new f.b() {
                    public void onNegative(com.afollestad.materialdialogs.f fVar) {
                        e.this.y.a();
                        ar.f().i();
                    }

                    public void onPositive(com.afollestad.materialdialogs.f fVar) {
                        e.this.y.a();
                        ar.f().i();
                    }
                }, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void v_() {
        if (!isFinishing()) {
            Dialog dialog = this.f7004e;
            if (dialog == null || !dialog.isShowing()) {
                this.f7004e = com.shopee.app.ui.dialog.a.a((Context) this, 0, (int) R.string.sp_ban_user_popup_msg, 0, (int) R.string.sp_label_ok, (f.b) new f.b() {
                    public void onNegative(com.afollestad.materialdialogs.f fVar) {
                        e.this.y.a();
                        ar.f().i();
                    }

                    public void onPositive(com.afollestad.materialdialogs.f fVar) {
                        e.this.y.a();
                        ar.f().i();
                    }
                }, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void D() {
        if (!isFinishing()) {
            Dialog dialog = this.f7004e;
            if (dialog == null || !dialog.isShowing()) {
                this.f7004e = com.shopee.app.ui.dialog.a.a((Context) this, 0, (int) R.string.sp_app_not_usable_message, 0, (int) R.string.sp_label_ok, (f.b) new f.b() {
                    public void onNegative(com.afollestad.materialdialogs.f fVar) {
                        e.this.C.a((Context) e.this);
                    }

                    public void onPositive(com.afollestad.materialdialogs.f fVar) {
                        e.this.C.a((Context) e.this);
                    }
                }, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void w_() {
        this.y.a();
        ar.f().i();
    }

    /* access modifiers changed from: protected */
    public void i() {
        this.y.a();
        ar.f().i();
    }

    /* access modifiers changed from: protected */
    public void E() {
        if (!isFinishing()) {
            Dialog dialog = this.f7004e;
            if (dialog != null && dialog.isShowing()) {
                return;
            }
        }
        final com.shopee.app.data.a y2 = this.G.y();
        if (y2 != null && y2.a() > 0 && y2.a() == this.A.getUserId()) {
            this.f7004e = com.shopee.app.ui.dialog.a.a((Context) this, y2, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    ((ClipboardManager) e.this.getSystemService("clipboard")).setText(y2.b());
                    com.shopee.app.h.r.a().b((int) R.string.sp_copy_text_done);
                    e.this.f7004e.dismiss();
                }
            });
            this.G.a((com.shopee.app.data.a) null);
        }
    }
}
