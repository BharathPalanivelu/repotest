package com.shopee.app.data.store;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import c.a.a.a.a;
import c.a.a.a.b;
import c.a.a.a.d;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.shopee.app.application.ar;
import com.shopee.app.h.f;
import com.shopee.app.network.g;
import com.shopee.arcatch.data.common_bean.Country;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class aa extends ay {

    /* renamed from: a  reason: collision with root package name */
    private d f6935a;

    /* renamed from: b  reason: collision with root package name */
    private d f6936b;

    /* renamed from: c  reason: collision with root package name */
    private d f6937c;

    /* renamed from: d  reason: collision with root package name */
    private d f6938d;

    /* renamed from: e  reason: collision with root package name */
    private b f6939e;

    /* renamed from: f  reason: collision with root package name */
    private a f6940f;

    /* renamed from: g  reason: collision with root package name */
    private d f6941g;
    private a h;
    private d i;
    private d j;
    private d k;
    private d l;
    private d m;
    private final List<String> n = Arrays.asList(new String[]{"LAT", "NoGoogleService", "NoGoogleServiceRepairable", "Exception"});

    public aa(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f6935a = new d(sharedPreferences, "locale", "");
        this.f6936b = new d(sharedPreferences, "deviceId", "");
        this.f6937c = new d(sharedPreferences, "fingerprint", "");
        this.f6938d = new d(sharedPreferences, "lastLoginId", "");
        this.f6939e = new b(sharedPreferences, "crash_restart_count", 0);
        this.f6940f = new a(sharedPreferences, "mTempered", false);
        this.f6941g = new d(sharedPreferences, "InstallLocation", "");
        this.h = new a(sharedPreferences, "InstallTracked", false);
        this.i = new d(sharedPreferences, "advertisingId", "");
        this.j = new d(sharedPreferences, "freefire_open_id_encrypt", "");
        this.k = new d(sharedPreferences, "freefire_open_id_raw", "");
        this.l = new d(sharedPreferences, "freefire_fingerprint_encrypt", "");
        this.m = new d(sharedPreferences, "freefire_fingerprint_raw", "");
    }

    public Locale a() {
        return j(b());
    }

    public String b() {
        String a2 = this.f6935a.a();
        return TextUtils.isEmpty(a2) ? "id" : a2;
    }

    public void a(String str) {
        this.f6935a.a(str);
    }

    private void g(String str) {
        this.i.a(str);
    }

    public String c() {
        String a2 = this.i.a();
        if (TextUtils.isEmpty(a2) || this.n.contains(a2)) {
            t();
        }
        return a2;
    }

    private void t() {
        org.a.a.a.a((Runnable) new Runnable() {
            public final void run() {
                aa.this.x();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x() {
        g(w());
    }

    public String d() {
        String a2 = this.f6936b.a();
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String u = u();
        this.f6936b.a(u);
        return u;
    }

    private String u() {
        g[] gVarArr = {new g(), new g(), new g(), new g()};
        ByteBuffer allocate = ByteBuffer.allocate(32);
        for (int i2 = 0; i2 < gVarArr.length; i2++) {
            allocate.putLong(i2 * 8, gVarArr[i2].b());
        }
        return Base64.encodeToString(allocate.array(), 2);
    }

    public byte[] e() {
        return h(g());
    }

    public byte[] f() {
        return h(i());
    }

    private byte[] h(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public String g() {
        String a2 = this.f6937c.a();
        if (TextUtils.isEmpty(a2)) {
            a2 = v();
            this.f6937c.a(a2);
            String i2 = i();
            if (!TextUtils.isEmpty(i2)) {
                if (!a2.equals(i2)) {
                    this.f6940f.a(true);
                }
            } else if (k()) {
                i(a2);
            }
        }
        return a2;
    }

    public boolean h() {
        return this.f6940f.a();
    }

    public String i() {
        FileInputStream fileInputStream;
        if (!j()) {
            return "";
        }
        try {
            File file = new File(f.a().f() + File.separator + AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB, "dfdata");
            byte[] bArr = new byte[((int) file.length())];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
            return new String(Base64.decode(new String(bArr), 0), "UTF-8");
        } catch (Exception unused) {
            return "";
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    private void i(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = f.a().f() + File.separator + AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB;
            try {
                new File(str2).mkdirs();
                new FileOutputStream(new File(str2, "dfdata")).write(Base64.encodeToString(str.getBytes(), 0).getBytes("UTF-8"));
            } catch (IOException e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }

    public boolean j() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public boolean k() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    @SuppressLint({"MissingPermission"})
    private String v() {
        String str;
        try {
            str = ((TelephonyManager) ar.f().getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String string = Settings.Secure.getString(ar.f().getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(str)) {
                str = string;
            } else {
                str = str + "_" + string;
            }
        }
        if (TextUtils.isEmpty(Build.SERIAL)) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            return Build.SERIAL;
        }
        return str + "_" + Build.SERIAL;
    }

    private static Locale j(String str) {
        if ("sg".equals(str)) {
            return new Locale("en", Country.COUNTRY_SG);
        }
        if ("en".equals(str)) {
            return new Locale("en", Country.COUNTRY_SG);
        }
        if ("zh-Hant".equals(str)) {
            return Locale.TRADITIONAL_CHINESE;
        }
        if ("th".equals(str)) {
            return new Locale("th", Country.COUNTRY_TH);
        }
        if ("vi".equals(str)) {
            return new Locale("vi", Country.COUNTRY_VN);
        }
        if ("id".equals(str)) {
            return new Locale("in", "ID");
        }
        if (UserDataStore.PHONE.equals(str)) {
            return new Locale(UserDataStore.PHONE, Country.COUNTRY_PH);
        }
        if ("ms".equals(str)) {
            return new Locale("en", Country.COUNTRY_MY);
        }
        if ("fa".equals(str)) {
            return new Locale("fa", Country.COUNTRY_IR);
        }
        if ("zh_HK".equals(str)) {
            return new Locale("zh", Country.COUNTRY_HK);
        }
        if ("my".equals(str)) {
            return new Locale("my", Country.COUNTRY_MM);
        }
        if ("ms-my".equals(str)) {
            return new Locale("ms", Country.COUNTRY_MY);
        }
        if ("zh-Hans".equals(str)) {
            return Locale.SIMPLIFIED_CHINESE;
        }
        if ("id".equals(str)) {
            return new Locale("en", Country.COUNTRY_SG);
        }
        return j("id");
    }

    public String l() {
        return this.f6938d.a();
    }

    public void b(String str) {
        this.f6938d.a(str);
    }

    public int m() {
        return this.f6939e.a();
    }

    public void a(int i2) {
        this.f6939e.a(i2);
    }

    public boolean n() {
        return this.h.a();
    }

    public void o() {
        this.h.a(true);
    }

    private String w() {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(ar.a());
            String id = advertisingIdInfo.getId() != null ? advertisingIdInfo.getId() : "";
            if (!id.isEmpty() || !advertisingIdInfo.isLimitAdTrackingEnabled()) {
                return id;
            }
            return this.n.get(0);
        } catch (GooglePlayServicesNotAvailableException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return this.n.get(1);
        } catch (GooglePlayServicesRepairableException e3) {
            com.garena.android.appkit.d.a.a(e3);
            return this.n.get(2);
        } catch (Exception e4) {
            com.garena.android.appkit.d.a.a(e4);
            return this.n.get(3);
        }
    }

    public String p() {
        return this.j.a();
    }

    public aa c(String str) {
        this.j.a(str);
        return this;
    }

    public String q() {
        return this.l.a();
    }

    public aa d(String str) {
        this.l.a(str);
        return this;
    }

    public String r() {
        return this.k.a();
    }

    public aa e(String str) {
        this.k.a(str);
        return this;
    }

    public String s() {
        return this.m.a();
    }

    public aa f(String str) {
        this.m.a(str);
        return this;
    }
}
