package com.shopee.app.util.datapoint.a;

import android.util.Base64;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.network.http.a.c;
import com.shopee.app.network.http.data.BaseResponse;
import com.shopee.app.network.http.data.datapoint.ReportUserInfoRequest;
import com.shopee.app.util.bd;
import com.shopee.app.util.i;
import com.shopee.b.a;
import d.d.b.j;
import d.h.d;
import f.m;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.UUID;
import javax.crypto.spec.SecretKeySpec;
import loan.data_point.ContentData;
import loan.data_point.ContentInfo;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private final a f26319a;

    /* renamed from: b  reason: collision with root package name */
    private int f26320b;

    /* renamed from: c  reason: collision with root package name */
    private final UserInfo f26321c;

    /* renamed from: d  reason: collision with root package name */
    private final SettingConfigStore f26322d;

    /* renamed from: e  reason: collision with root package name */
    private final c f26323e;

    /* renamed from: f  reason: collision with root package name */
    private final aa f26324f;

    public abstract ContentInfo a();

    public abstract int b();

    public abstract void c();

    public abstract void d();

    public e(c cVar, aa aaVar) {
        j.b(cVar, "dataPointApi");
        j.b(aaVar, "deviceStore");
        this.f26323e = cVar;
        this.f26324f = aaVar;
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        a deviceInfoCollector = f2.e().deviceInfoCollector();
        j.a((Object) deviceInfoCollector, "ShopeeApplication.get().…ent.deviceInfoCollector()");
        this.f26319a = deviceInfoCollector;
        ar f3 = ar.f();
        j.a((Object) f3, "ShopeeApplication.get()");
        this.f26321c = f3.e().loggedInUser();
        ar f4 = ar.f();
        j.a((Object) f4, "ShopeeApplication.get()");
        this.f26322d = f4.e().settingConfigStore();
    }

    /* access modifiers changed from: protected */
    public final a e() {
        return this.f26319a;
    }

    public final int f() {
        return this.f26320b;
    }

    /* access modifiers changed from: protected */
    public final UserInfo g() {
        return this.f26321c;
    }

    /* access modifiers changed from: protected */
    public final void h() {
        ContentInfo a2 = a();
        com.garena.android.appkit.d.a.b("POST_deviceInfo_TO_DataPoint%s", a2.toString());
        ContentData build = new ContentData.Builder().content_infos(d.a.j.a(a2)).build();
        SecretKeySpec secretKeySpec = null;
        try {
            SecretKeySpec b2 = bd.b("HELLO_WORLD");
            if (b2 == null) {
                j.a();
            }
            byte[] encoded = b2.getEncoded();
            byte[] a3 = org.apache.commons.c.a.a(bd.f26238a, Arrays.copyOf(encoded, encoded.length));
            if (a3 != null) {
                ReportUserInfoRequest.Builder app_version = new ReportUserInfoRequest.Builder().content_type(b()).device_fingerprint(b(true)).device_id(this.f26324f.d()).encrypt_key(bd.c(a3)).encrypt_data(Base64.encodeToString(bd.a(b2, bd.f26238a, build.toByteArray()), 2)).platform_type(1).app_version(com.shopee.app.react.modules.app.appmanager.a.b());
                ar f2 = ar.f();
                j.a((Object) f2, "ShopeeApplication.get()");
                UserInfo loggedInUser = f2.e().loggedInUser();
                j.a((Object) loggedInUser, "ShopeeApplication.get().component.loggedInUser()");
                m<BaseResponse> a4 = this.f26323e.a(com.shopee.app.network.http.b.a.a(), i.f7040c, app_version.user_id(loggedInUser.getUserId()).encrypt_data_hash(UUID.randomUUID().toString()).build()).a();
                j.a((Object) a4, "networkResponse");
                if (a4.d()) {
                    BaseResponse e2 = a4.e();
                    if (e2 != null && e2.isSuccess()) {
                        com.garena.android.appkit.d.a.b(String.valueOf(e2.errorCode.intValue()), new Object[0]);
                    }
                    d();
                    return;
                }
                return;
            }
            throw new d.m("null cannot be cast to non-null type kotlin.ByteArray");
        } catch (Exception e3) {
            com.garena.android.appkit.d.a.a(e3);
        }
    }

    public void a(boolean z) {
        this.f26320b = com.garena.android.appkit.tools.a.a.a();
        if (z) {
            c();
        } else {
            h();
        }
    }

    private final String b(boolean z) {
        String g2 = this.f26324f.g();
        j.a((Object) g2, "deviceStore.fingerprint");
        if (!z) {
            return g2;
        }
        Charset charset = d.f32688a;
        if (g2 != null) {
            byte[] bytes = g2.getBytes(charset);
            j.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 2);
            j.a((Object) encodeToString, "Base64.encodeToString(fi…eArray(), Base64.NO_WRAP)");
            return encodeToString;
        }
        throw new d.m("null cannot be cast to non-null type java.lang.String");
    }

    /* access modifiers changed from: protected */
    public final String a(int i) {
        return b(false) + b() + i;
    }

    /* access modifiers changed from: protected */
    public final boolean i() {
        UserInfo userInfo = this.f26321c;
        if (userInfo != null) {
            SettingConfigStore settingConfigStore = this.f26322d;
            return settingConfigStore != null && settingConfigStore.isDataPointOn(userInfo.getUserId());
        }
    }
}
