package com.shopee.app.ui.auth.password;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.bf;
import com.shopee.app.network.d.f.a;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.af;
import com.shopee.app.util.as;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;
import java.util.List;

public class m extends q<o> {

    /* renamed from: a  reason: collision with root package name */
    a f19622a;

    /* renamed from: c  reason: collision with root package name */
    private final n f19623c;

    /* renamed from: d  reason: collision with root package name */
    private String f19624d;

    /* renamed from: e  reason: collision with root package name */
    private int f19625e;

    /* renamed from: f  reason: collision with root package name */
    private final i f19626f;

    /* renamed from: g  reason: collision with root package name */
    private e f19627g = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((o) m.this.f19220b).d();
            ((o) m.this.f19220b).h();
            ((o) m.this.f19220b).g();
        }
    };

    public m(n nVar) {
        this.f19623c = nVar;
        this.f19626f = b.a(this);
    }

    public void a() {
        this.f19626f.a();
        this.f19623c.a("SEND_V_MAIL_SUCCESS", this.f19627g);
    }

    public void b() {
        this.f19626f.b();
        this.f19623c.b("SEND_V_MAIL_SUCCESS", this.f19627g);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i = aVar.f17892a;
            if (i == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i != 1) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(this.f19625e == 1 ? R.string.sp_failed_email_login : R.string.sp_failed_phone_login);
            }
        }
        ((o) this.f19220b).d();
        ((o) this.f19220b).a(str);
    }

    /* access modifiers changed from: package-private */
    public void a(ResponseCommon responseCommon) {
        if (b(responseCommon) && responseCommon.userid != null) {
            new au().a(responseCommon.userid.intValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<UserData> list) {
        if (af.a(list) || !list.get(0).isUserDeletedOrBanned()) {
            int i = this.f19625e;
            if (i == 0) {
                ((o) this.f19220b).d();
                ((o) this.f19220b).a(false);
            } else if (i == 1) {
                c(this.f19624d);
            }
        } else {
            ((o) this.f19220b).d();
            ((o) this.f19220b).a(com.garena.android.appkit.tools.b.e(R.string.error_banned_reset_password));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        ((o) this.f19220b).d();
        ((o) this.f19220b).a(com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error));
    }

    /* access modifiers changed from: package-private */
    public boolean b(ResponseCommon responseCommon) {
        a aVar = this.f19622a;
        return aVar != null && aVar.i().a().equals(responseCommon.requestid);
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (b(aVar.f17894c)) {
            if (!TextUtils.isEmpty(aVar.f17893b)) {
                str = aVar.f17893b;
            } else {
                int i = aVar.f17892a;
                if (i == -100) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
                } else if (i == 1) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_invalid_phone_or_email);
                } else if (i == 4) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_account_not_exist);
                } else if (i != 16) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
                } else {
                    ((o) this.f19220b).d();
                    ((o) this.f19220b).a(true);
                    return;
                }
            }
            ((o) this.f19220b).d();
            ((o) this.f19220b).a(str);
        }
    }

    public void a(String str) {
        ((o) this.f19220b).c();
        this.f19624d = str;
        this.f19625e = 1;
        this.f19622a = new a();
        this.f19622a.b(str);
    }

    public void b(String str) {
        this.f19624d = as.a(str);
        ((o) this.f19220b).c();
        this.f19625e = 0;
        this.f19622a = new a();
        this.f19622a.a(this.f19624d);
    }

    public void c(String str) {
        new bf().a(str);
    }
}
