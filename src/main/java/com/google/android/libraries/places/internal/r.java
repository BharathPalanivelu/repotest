package com.google.android.libraries.places.internal;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.internal.ay;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class r<TypeT, RequestT extends ay> {

    /* renamed from: a  reason: collision with root package name */
    public final RequestT f13061a;

    /* renamed from: b  reason: collision with root package name */
    public final Locale f13062b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13063c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f13064d;

    /* renamed from: e  reason: collision with root package name */
    public final fg f13065e;

    public r(RequestT requestt) {
        this.f13061a = requestt;
    }

    public abstract String d();

    public abstract Map<String, String> e();

    public final CancellationToken a() {
        return this.f13061a.getCancellationToken();
    }

    public Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("X-Android-Package", this.f13065e.c());
        hashMap.put("X-Android-Cert", this.f13065e.a());
        String str = this.f13064d ? ".compat" : "";
        hashMap.put("X-Places-Android-Sdk", str.length() != 0 ? "1.1.0".concat(str) : new String("1.1.0"));
        return hashMap;
    }

    public String c() {
        Uri.Builder buildUpon = Uri.parse("https://maps.googleapis.com/").buildUpon();
        buildUpon.appendEncodedPath("maps/api/place/");
        buildUpon.appendEncodedPath(d());
        buildUpon.appendQueryParameter("key", this.f13063c);
        Locale locale = this.f13062b;
        if (locale != null) {
            String a2 = a(locale);
            if (!TextUtils.isEmpty(a2)) {
                buildUpon.appendQueryParameter(IjkMediaMeta.IJKM_KEY_LANGUAGE, a2);
            }
        }
        for (Map.Entry next : e().entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return buildUpon.build().toString();
    }

    public r(RequestT requestt, Locale locale, String str, boolean z, fg fgVar) {
        this(requestt);
        this.f13062b = locale;
        this.f13063c = str;
        this.f13064d = z;
        this.f13065e = fgVar;
    }

    public static void a(Map<String, String> map, String str, Object obj, Object obj2) {
        String obj3 = obj != null ? obj.toString() : null;
        if (!TextUtils.isEmpty(obj3)) {
            map.put(str, obj3);
        }
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            return locale.toLanguageTag();
        }
        StringBuilder sb = new StringBuilder();
        String language = locale.getLanguage();
        if (!TextUtils.isEmpty(language)) {
            sb.append(language);
            String country = locale.getCountry();
            if (!TextUtils.isEmpty(country)) {
                sb.append("-");
                sb.append(country);
            }
        }
        return sb.toString();
    }
}
