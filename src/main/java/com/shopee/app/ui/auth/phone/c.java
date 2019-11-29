package com.shopee.app.ui.auth.phone;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.protocol.action.ResponseCommon;
import java.util.List;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f19691a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19692b = new g() {
        public void onEvent(a aVar) {
            c.this.f19691a.a((ResponseCommon) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f19693c = new g() {
        public void onEvent(a aVar) {
            c.this.f19691a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f19694d = new g() {
        public void onEvent(a aVar) {
            c.this.f19691a.a((Pair<String, Boolean>) (Pair) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f19695e = new g() {
        public void onEvent(a aVar) {
            c.this.f19691a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f19696f = new g() {
        public void onEvent(a aVar) {
            c.this.f19691a.a((List<UserData>) (List) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f19697g = new g() {
        public void onEvent(a aVar) {
            c.this.f19691a.a(((Integer) aVar.data).intValue());
        }
    };

    public void c() {
    }

    public void d() {
    }

    public c(b bVar) {
        this.f19691a = bVar;
    }

    public void a() {
        b.a("ACCOUNT_FOUND_SUCCESS", (e) this.f19692b, b.a.NETWORK_BUS);
        b.a("ACCOUNT_FOUND_FAIL", (e) this.f19693c, b.a.NETWORK_BUS);
        b.a("SEND_V_CODE_SUCCESS", (e) this.f19694d, b.a.NETWORK_BUS);
        b.a("SEND_V_CODE_FAIL", (e) this.f19695e, b.a.NETWORK_BUS);
        b.a("GET_USER_INFO_LOAD", (e) this.f19696f, b.a.NETWORK_BUS);
        b.a("GET_USER_INFO_ERROR", (e) this.f19697g, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ACCOUNT_FOUND_SUCCESS", this.f19692b, b.a.NETWORK_BUS);
        b.b("ACCOUNT_FOUND_FAIL", this.f19693c, b.a.NETWORK_BUS);
        b.b("SEND_V_CODE_SUCCESS", this.f19694d, b.a.NETWORK_BUS);
        b.b("SEND_V_CODE_FAIL", this.f19695e, b.a.NETWORK_BUS);
        b.b("GET_USER_INFO_LOAD", this.f19696f, b.a.NETWORK_BUS);
        b.b("GET_USER_INFO_ERROR", this.f19697g, b.a.NETWORK_BUS);
    }
}
