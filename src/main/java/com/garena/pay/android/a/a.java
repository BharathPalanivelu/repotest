package com.garena.pay.android.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.beetalk.sdk.e.b;
import com.beetalk.sdk.e.c;
import com.beetalk.sdk.f;
import com.beetalk.sdk.l;
import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f8137a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f8138b;

    /* renamed from: c  reason: collision with root package name */
    private String f8139c;

    /* renamed from: d  reason: collision with root package name */
    private String f8140d;

    /* renamed from: e  reason: collision with root package name */
    private Locale f8141e = c.c();

    /* renamed from: f  reason: collision with root package name */
    private int f8142f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f8143g = 0;

    public a(String str, Integer num, String str2, String str3, int i, int i2, Locale locale) {
        this.f8137a = str;
        this.f8138b = num;
        this.f8139c = str2;
        this.f8140d = str3;
        this.f8142f = i;
        this.f8143g = i2;
        this.f8141e = locale;
    }

    public a(String str, Integer num, String str2, String str3, int i, int i2) {
        this.f8137a = str;
        this.f8138b = num;
        this.f8139c = str2;
        this.f8140d = str3;
        this.f8142f = i;
        this.f8143g = i2;
    }

    public Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("access_token", this.f8140d);
        Locale locale = this.f8141e;
        if (locale != null) {
            hashMap.put("locale", locale.toString());
        } else {
            hashMap.put("locale", c.c(context).toString());
        }
        hashMap.put("app_id", this.f8137a);
        hashMap.put("open_id", this.f8139c);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, f.b().f().toString());
        hashMap.put("platform", String.valueOf(this.f8138b));
        hashMap.put("client_type", l.c.f5472b.toString());
        hashMap.put("app_server_id", String.valueOf(this.f8142f));
        hashMap.put("app_role_id", String.valueOf(this.f8143g));
        if (b.d(context)) {
            hashMap.put("imsi", ((TelephonyManager) context.getSystemService("phone")).getSubscriberId());
        }
        com.beetalk.sdk.e.a.b("Channel Get Request Data %s", hashMap.toString());
        return hashMap;
    }

    /* renamed from: com.garena.pay.android.a.a$a  reason: collision with other inner class name */
    public static class C0135a {

        /* renamed from: a  reason: collision with root package name */
        private String f8144a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f8145b;

        /* renamed from: c  reason: collision with root package name */
        private String f8146c;

        /* renamed from: d  reason: collision with root package name */
        private String f8147d;

        /* renamed from: e  reason: collision with root package name */
        private Locale f8148e;

        /* renamed from: f  reason: collision with root package name */
        private int f8149f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f8150g = 0;

        public C0135a a(String str) {
            this.f8144a = str;
            return this;
        }

        public C0135a a(Integer num) {
            this.f8145b = num;
            return this;
        }

        public C0135a b(String str) {
            this.f8146c = str;
            return this;
        }

        public C0135a c(String str) {
            this.f8147d = str;
            return this;
        }

        public C0135a a(Locale locale) {
            this.f8148e = locale;
            return this;
        }

        public C0135a a(int i) {
            this.f8149f = i;
            return this;
        }

        public C0135a b(int i) {
            this.f8150g = i;
            return this;
        }

        public a a() {
            Locale locale = this.f8148e;
            if (locale == null) {
                return new a(this.f8144a, this.f8145b, this.f8146c, this.f8147d, this.f8149f, this.f8150g);
            }
            return new a(this.f8144a, this.f8145b, this.f8146c, this.f8147d, this.f8149f, this.f8150g, locale);
        }
    }
}
