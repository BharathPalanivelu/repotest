package io.a.a.a.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import io.a.a.a.c;
import io.a.a.a.i;
import io.a.a.a.l;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class p {

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f33083e = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: f  reason: collision with root package name */
    private static final String f33084f = Pattern.quote(Constants.URL_PATH_DELIMITER);

    /* renamed from: a  reason: collision with root package name */
    c f33085a;

    /* renamed from: b  reason: collision with root package name */
    b f33086b;

    /* renamed from: c  reason: collision with root package name */
    boolean f33087c;

    /* renamed from: d  reason: collision with root package name */
    o f33088d;

    /* renamed from: g  reason: collision with root package name */
    private final ReentrantLock f33089g = new ReentrantLock();
    private final q h;
    private final boolean i;
    private final boolean j;
    private final Context k;
    private final String l;
    private final String m;
    private final Collection<i> n;

    public enum a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        
        public final int protobufIndex;

        private a(int i) {
            this.protobufIndex = i;
        }
    }

    public p(Context context, String str, String str2, Collection<i> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection != null) {
            this.k = context;
            this.l = str;
            this.m = str2;
            this.n = collection;
            this.h = new q();
            this.f33085a = new c(context);
            this.f33088d = new o();
            this.i = i.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.i) {
                l h2 = c.h();
                h2.a("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            this.j = i.a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.j) {
                l h3 = c.h();
                h3.a("Fabric", "User information collection disabled for " + context.getPackageName());
            }
        } else {
            throw new IllegalArgumentException("kits must not be null");
        }
    }

    public boolean a() {
        return this.j;
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        return f33083e.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public String b() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        SharedPreferences a2 = i.a(this.k);
        b(a2);
        String string = a2.getString("crashlytics.installation.id", (String) null);
        return string == null ? a(a2) : string;
    }

    public String c() {
        return this.l;
    }

    public String d() {
        return e() + Constants.URL_PATH_DELIMITER + f();
    }

    public String e() {
        return b(Build.VERSION.RELEASE);
    }

    public String f() {
        return b(Build.VERSION.INCREMENTAL);
    }

    public String g() {
        return String.format(Locale.US, "%s/%s", new Object[]{b(Build.MANUFACTURER), b(Build.MODEL)});
    }

    private String b(String str) {
        return str.replaceAll(f33084f, "");
    }

    @SuppressLint({"CommitPrefEdits"})
    private String a(SharedPreferences sharedPreferences) {
        this.f33089g.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", (String) null);
            if (string == null) {
                string = a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            return string;
        } finally {
            this.f33089g.unlock();
        }
    }

    private void b(SharedPreferences sharedPreferences) {
        b n2 = n();
        if (n2 != null) {
            a(sharedPreferences, n2.f33057a);
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    private void a(SharedPreferences sharedPreferences, String str) {
        this.f33089g.lock();
        try {
            if (!TextUtils.isEmpty(str)) {
                String string = sharedPreferences.getString("crashlytics.advertising.id", (String) null);
                if (TextUtils.isEmpty(string)) {
                    sharedPreferences.edit().putString("crashlytics.advertising.id", str).commit();
                } else if (!string.equals(str)) {
                    sharedPreferences.edit().remove("crashlytics.installation.id").putString("crashlytics.advertising.id", str).commit();
                }
                this.f33089g.unlock();
            }
        } finally {
            this.f33089g.unlock();
        }
    }

    public Map<a, String> h() {
        HashMap hashMap = new HashMap();
        for (i next : this.n) {
            if (next instanceof m) {
                for (Map.Entry next2 : ((m) next).e().entrySet()) {
                    a(hashMap, (a) next2.getKey(), (String) next2.getValue());
                }
            }
        }
        String k2 = k();
        if (TextUtils.isEmpty(k2)) {
            a(hashMap, a.ANDROID_ID, l());
        } else {
            a(hashMap, a.ANDROID_ADVERTISING_ID, k2);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public String i() {
        return this.h.a(this.k);
    }

    public Boolean j() {
        if (m()) {
            return o();
        }
        return null;
    }

    public String k() {
        if (m()) {
            b n2 = n();
            if (n2 != null && !n2.f33058b) {
                return n2.f33057a;
            }
        }
        return null;
    }

    private void a(Map<a, String> map, a aVar, String str) {
        if (str != null) {
            map.put(aVar, str);
        }
    }

    public String l() {
        boolean equals = Boolean.TRUE.equals(o());
        if (m() && !equals) {
            String string = Settings.Secure.getString(this.k.getContentResolver(), "android_id");
            if (!"9774d56d682e549c".equals(string)) {
                return a(string);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean m() {
        return this.i && !this.f33088d.b(this.k);
    }

    /* access modifiers changed from: package-private */
    public synchronized b n() {
        if (!this.f33087c) {
            this.f33086b = this.f33085a.a();
            this.f33087c = true;
        }
        return this.f33086b;
    }

    private Boolean o() {
        b n2 = n();
        if (n2 != null) {
            return Boolean.valueOf(n2.f33058b);
        }
        return null;
    }
}
