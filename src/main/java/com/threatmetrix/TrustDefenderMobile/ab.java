package com.threatmetrix.TrustDefenderMobile;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.util.Log;
import android.util.TimingLogger;
import android.view.WindowManager;
import com.appsflyer.share.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.shopee.shopeetracker.EventSender;
import com.tencent.qcloud.core.http.HttpConstants;
import com.threatmetrix.TrustDefenderMobile.j;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(9)
class ab {

    /* renamed from: a  reason: collision with root package name */
    public static String f32535a = "2.5-16";
    private static final String t = "ab";
    private volatile AtomicBoolean A = null;
    private volatile k B = k.THM_OK;
    private b C = new b();
    private String D = null;
    private String E = null;

    /* renamed from: b  reason: collision with root package name */
    String f32536b = null;

    /* renamed from: c  reason: collision with root package name */
    String f32537c = null;

    /* renamed from: d  reason: collision with root package name */
    String f32538d = null;

    /* renamed from: e  reason: collision with root package name */
    String f32539e = null;

    /* renamed from: f  reason: collision with root package name */
    int f32540f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f32541g = 0;
    int h = 0;
    int i = 0;
    String j = null;
    String k = null;
    String l = null;
    String m = null;
    int n = 0;
    String o = null;
    String p = null;
    Location q = null;
    ArrayList<String> r = null;
    w s = null;
    private String u = null;
    private String v = null;
    private String w = null;
    private Context x = null;
    private String y = null;
    private TimingLogger z = null;

    ab() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f32539e = null;
        this.f32540f = 0;
        this.f32541g = 0;
        this.m = null;
        this.q = null;
        this.s = null;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        this.C = bVar;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.f32536b;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.f32536b = str;
    }

    /* access modifiers changed from: package-private */
    public k c() {
        String str = t;
        Log.d(str, "getStatus returns: " + this.B.toString());
        return this.B;
    }

    /* access modifiers changed from: package-private */
    public void a(k kVar) {
        this.B = kVar;
    }

    /* access modifiers changed from: package-private */
    public void a(Location location) {
        this.q = location;
    }

    /* access modifiers changed from: package-private */
    public void a(AtomicBoolean atomicBoolean) {
        this.A = atomicBoolean;
    }

    /* access modifiers changed from: package-private */
    public void a(w wVar) {
        this.s = wVar;
    }

    /* access modifiers changed from: package-private */
    public w d() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        this.x = context;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public boolean b(String str) {
        if (str == null) {
            str = "h.online-metrix.net";
        }
        try {
            new URL("https://" + str);
            this.p = str;
            return true;
        } catch (MalformedURLException e2) {
            String str2 = t;
            Log.e(str2, "Invalid hostname " + str, e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str) {
        if (str == null || str.length() != 8) {
            Log.e(t, "Invalid org_id");
            return false;
        }
        this.o = str;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        if ((i2 & 1) == 0) {
            Log.e(t, "Synchronous is deprecated, please switch to ASYNC");
            return false;
        }
        this.n = i2;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            str2 = "TrustDefenderMobileSDK";
        }
        this.k = "http://" + str2;
        if (str == null || str.length() <= 0) {
            this.j = "http://" + str2 + "/mobile";
            return true;
        }
        this.j = str;
        if (str.compareToIgnoreCase(this.k) != 0) {
            return true;
        }
        this.j = str + "mobile";
        return true;
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return "https://" + this.p + "/fp/mobile/conf";
    }

    /* access modifiers changed from: package-private */
    public h h() {
        h hVar = new h();
        hVar.a("org_id", this.o);
        hVar.a(EventSender.TRACKING_DATA_SESSION_ID, this.f32536b);
        hVar.a("os", "android");
        hVar.a("osVersion", Build.VERSION.RELEASE);
        String str = this.y;
        if (str != null && !str.isEmpty()) {
            hVar.a("api_key", this.y);
        }
        return hVar;
    }

    /* access modifiers changed from: package-private */
    public void i() throws InterruptedException {
        String str;
        Log.d(t, "Getting timezone info");
        if ((this.n & 8) != 0) {
            j.a aVar = new j.a();
            if (j.a(aVar)) {
                this.f32541g = aVar.f32587b;
                this.f32540f = aVar.f32586a;
            }
            TimingLogger timingLogger = this.z;
            if (timingLogger != null) {
                timingLogger.addSplit("get time zone");
            }
        }
        if (this.f32539e == null || this.f32537c == null || this.f32538d == null) {
            boolean z2 = (this.n & 512) != 0 && x.a();
            String str2 = null;
            if (this.f32539e == null) {
                str = x.b(this.x);
                this.f32539e = x.b(str, z2);
            } else {
                str = null;
            }
            TimingLogger timingLogger2 = this.z;
            if (timingLogger2 != null) {
                timingLogger2.addSplit("cookie");
            }
            if (this.f32538d == null) {
                str2 = x.a(this.x);
                if (this.A == null || !this.A.get()) {
                    this.f32538d = x.a(str2, z2);
                } else {
                    throw new InterruptedException();
                }
            }
            TimingLogger timingLogger3 = this.z;
            if (timingLogger3 != null) {
                timingLogger3.addSplit("LSC");
            }
            if (this.u == null) {
                this.u = x.c(this.x);
                TimingLogger timingLogger4 = this.z;
                if (timingLogger4 != null) {
                    timingLogger4.addSplit("imei");
                }
            }
            if (this.f32537c == null) {
                if (str == null) {
                    str = x.b(this.x);
                }
                if (str2 == null) {
                    str2 = x.a(this.x);
                }
                if (this.A == null || !this.A.get()) {
                    this.f32537c = x.a(this.x, str, str2, this.u, z2);
                } else {
                    throw new InterruptedException();
                }
            }
            TimingLogger timingLogger5 = this.z;
            if (timingLogger5 != null) {
                timingLogger5.addSplit("Flash");
            }
        }
        if ((this.A == null || !this.A.get()) && !Thread.currentThread().isInterrupted()) {
            if ((this.n & 16) != 0 && (this.i == 0 || this.h == 0)) {
                f fVar = new f(((WindowManager) this.x.getSystemService("window")).getDefaultDisplay());
                this.h = fVar.a();
                this.i = fVar.b();
            }
            TimingLogger timingLogger6 = this.z;
            if (timingLogger6 != null) {
                timingLogger6.addSplit("get screen dimensions");
            }
            if ((this.A == null || !this.A.get()) && !Thread.currentThread().isInterrupted()) {
                this.m = j.d();
                TimingLogger timingLogger7 = this.z;
                if (timingLogger7 != null) {
                    timingLogger7.addSplit("get device state");
                }
                if ((this.A == null || !this.A.get()) && !Thread.currentThread().isInterrupted()) {
                    if (this.l == null) {
                        Context context = this.x;
                        this.l = j.a(context, context);
                    }
                    TimingLogger timingLogger8 = this.z;
                    if (timingLogger8 != null) {
                        timingLogger8.addSplit("get device fingerprint");
                    }
                    if ((this.n & 2048) != 0 && this.E == null) {
                        this.E = a.a(this.x);
                        TimingLogger timingLogger9 = this.z;
                        if (timingLogger9 != null) {
                            timingLogger9.addSplit("get self hash");
                        }
                    }
                    if (this.w == null || this.v == null) {
                        StringBuilder sb = new StringBuilder();
                        this.v = j.a(sb);
                        if (this.v != null) {
                            this.w = sb.toString();
                        }
                        Log.d(t, "Got " + this.w + " fonts gives: " + this.v);
                    }
                    TimingLogger timingLogger10 = this.z;
                    if (timingLogger10 != null) {
                        timingLogger10.addSplit("Get Fontlist");
                        return;
                    }
                    return;
                }
                throw new InterruptedException();
            }
            throw new InterruptedException();
        }
        throw new InterruptedException();
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> j() {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpConstants.Header.USER_AGENT, this.D);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> k() {
        HashMap hashMap = new HashMap();
        String str = this.D;
        if (str != null && !str.isEmpty()) {
            String str2 = t;
            Log.d(str2, "Setting User-Agent to " + this.D);
            hashMap.put(HttpConstants.Header.USER_AGENT, this.D);
        }
        if (this.f32539e == null) {
            hashMap.put("Cookie", "thx_guid=");
        } else {
            hashMap.put("Cookie", "thx_guid=" + this.f32539e);
        }
        hashMap.put("Referer", this.k);
        hashMap.put(HttpConstants.Header.CONTENT_TYPE, HttpConstants.ContentType.X_WWW_FORM_URLENCODED);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public h l() throws InterruptedException {
        String str;
        List<String> a2 = j.a(this.x, (List<String>) this.s.f32629c);
        int size = a2.size();
        String a3 = v.a(a2, ";");
        TimingLogger timingLogger = this.z;
        if (timingLogger != null) {
            timingLogger.addSplit("Check URLs");
        }
        String str2 = "";
        if ((this.s.f32627a & 256) != 0) {
            str = j.a((List<URI>) this.s.f32630d);
            TimingLogger timingLogger2 = this.z;
            if (timingLogger2 != null) {
                timingLogger2.addSplit("get URLs");
            }
        } else {
            str = str2;
        }
        h hVar = new h();
        hVar.a(255);
        hVar.a("w", this.s.f32628b);
        hVar.a(Constants.URL_CAMPAIGN, String.valueOf(this.f32540f));
        hVar.a("z", String.valueOf(this.f32541g));
        hVar.a("f", this.h + "x" + this.i);
        hVar.a("lh", this.j, true);
        hVar.a("dr", this.k, true);
        if (!this.C.b().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            hVar.a("p", this.C.a(), true);
            hVar.a("pl", this.C.b(), true);
            hVar.a(UserDataStore.PHONE, this.C.c(), true);
        }
        hVar.a("hh", v.b(this.o + this.f32536b));
        if (this.C.e() > 0) {
            hVar.a("mt", this.C.f());
            hVar.a("mn", String.valueOf(this.C.e()));
        }
        hVar.a("mdf", this.l, true);
        hVar.a("mds", this.m, true);
        hVar.a("imei", this.u, true);
        Location location = this.q;
        if (location != null) {
            hVar.a("tdlat", String.valueOf(location.getLatitude()));
            hVar.a("tdlon", String.valueOf(this.q.getLongitude()));
            hVar.a("tdlacc", String.valueOf(this.q.getAccuracy()));
        }
        ArrayList<String> arrayList = this.r;
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            Iterator<String> it = this.r.iterator();
            while (it.hasNext()) {
                StringBuilder sb = new StringBuilder();
                sb.append("aca");
                int i3 = i2 + 1;
                sb.append(i2);
                hVar.a(sb.toString(), it.next(), true);
                if (i3 >= 5) {
                    break;
                }
                i2 = i3;
            }
        }
        hVar.a("ah", this.E);
        hVar.a("la", this.s.f32628b + this.f32538d);
        hVar.a("lq", this.D);
        String num = Integer.toString(new Random().nextInt(10000) + 10000);
        hVar.a("nu", num.substring(num.length() + -4));
        hVar.a("fc", this.s.f32628b + this.f32537c);
        hVar.a("ftsn", this.w);
        hVar.a("fts", this.v, true);
        hVar.a("v", Build.VERSION.RELEASE, true);
        hVar.a("o", Build.BRAND, true);
        hVar.a("mf", Build.MODEL, true);
        hVar.a("l", Locale.getDefault().getLanguage(), true);
        hVar.a("fg", this.f32537c);
        hVar.a("ls", this.f32538d);
        if (this.s.f32629c.size() != 0) {
            str2 = String.valueOf(size);
        }
        hVar.a("gr", str2);
        hVar.a("grr", a3);
        hVar.a("at", "agent_mobile");
        hVar.a("av", f32535a);
        hVar.a("ex3", str);
        h hVar2 = new h();
        hVar2.a("org_id", this.o);
        hVar2.a(EventSender.TRACKING_DATA_SESSION_ID, this.f32536b);
        TimingLogger timingLogger3 = this.z;
        if (timingLogger3 != null) {
            timingLogger3.addSplit("params without xor");
        }
        String a4 = hVar.a();
        TimingLogger timingLogger4 = this.z;
        if (timingLogger4 != null) {
            timingLogger4.addSplit("url encoding");
        }
        hVar2.a("ja", v.a(a4, this.f32536b));
        hVar2.a("h", AppEventsConstants.EVENT_PARAM_VALUE_NO).a("m", "2");
        TimingLogger timingLogger5 = this.z;
        if (timingLogger5 != null) {
            timingLogger5.addSplit("Params xor'd");
        }
        return hVar2;
    }
}
