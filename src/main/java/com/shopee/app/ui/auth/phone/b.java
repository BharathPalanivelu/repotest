package com.shopee.app.ui.auth.phone;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.f.a;
import com.shopee.app.network.d.f.m;
import com.shopee.app.ui.a.q;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;
import java.util.List;

public class b extends q<d> {

    /* renamed from: a  reason: collision with root package name */
    a f19687a;

    /* renamed from: c  reason: collision with root package name */
    private String f19688c;

    /* renamed from: d  reason: collision with root package name */
    private final i f19689d = com.garena.a.a.a.b.a(this);

    /* renamed from: e  reason: collision with root package name */
    private m f19690e;

    public void a(String str) {
        this.f19688c = str;
    }

    public void b(String str) {
        ((d) this.f19220b).d();
        this.f19687a = new a();
        this.f19687a.a(str);
    }

    public void a() {
        this.f19689d.a();
    }

    public void b() {
        this.f19689d.b();
    }

    public void a(String str, int i) {
        a(str, i, false);
    }

    public void a(String str, int i, boolean z) {
        ((d) this.f19220b).d();
        this.f19690e = new m(this.f19688c, str, i, z);
        this.f19690e.a("", false, false);
    }

    public void b(String str, int i) {
        ((d) this.f19220b).d();
        this.f19690e = new m(this.f19688c, str, i);
        this.f19690e.a("", true, false);
    }

    public void a(Integer num) {
        if (num != null) {
            ((d) this.f19220b).d();
            new au().a(num.intValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ResponseCommon responseCommon) {
        if (b(responseCommon)) {
            ((d) this.f19220b).e();
            ((d) this.f19220b).a(this.f19688c, responseCommon.userid);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(ResponseCommon responseCommon) {
        a aVar = this.f19687a;
        return aVar != null && aVar.i().a().equals(responseCommon.requestid);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (b(aVar.f17894c)) {
            ((d) this.f19220b).e();
            if (!TextUtils.isEmpty(aVar.f17893b)) {
                str = aVar.f17893b;
            } else {
                int i = aVar.f17892a;
                if (i == 4) {
                    ((d) this.f19220b).b(this.f19688c);
                    return;
                } else if (i == 16) {
                    ((d) this.f19220b).c(this.f19688c);
                    return;
                } else if (i == -100) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
                } else if (i != 1) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
                } else {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_invalid_phone_format);
                }
            }
            ((d) this.f19220b).a(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<String, Boolean> pair) {
        m mVar = this.f19690e;
        if (mVar != null && mVar.i().a().equals(pair.first)) {
            ((d) this.f19220b).e();
            if (((Boolean) pair.second).booleanValue()) {
                ((d) this.f19220b).e(this.f19688c);
            } else {
                ((d) this.f19220b).d(this.f19688c);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        m mVar = this.f19690e;
        if (mVar != null && mVar.i().a().equals(aVar.f17894c.requestid)) {
            ((d) this.f19220b).e();
            if (!TextUtils.isEmpty(aVar.f17893b)) {
                str = aVar.f17893b;
            } else {
                int i = aVar.f17892a;
                if (i == -100) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
                } else if (i == 1) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_invalid_phone_format);
                } else if (i == 5) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_try_another_phone);
                } else if (i != 38) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
                } else {
                    ((d) this.f19220b).c();
                    return;
                }
            }
            ((d) this.f19220b).a(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<UserData> list) {
        ((d) this.f19220b).e();
        if (list == null || list.size() != 1) {
            ((d) this.f19220b).a(com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error));
        } else if (list.get(0).isUserBanned()) {
            ((d) this.f19220b).g();
        } else {
            ((d) this.f19220b).f();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        String str;
        ((d) this.f19220b).e();
        if (i != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((d) this.f19220b).a(str);
    }
}
