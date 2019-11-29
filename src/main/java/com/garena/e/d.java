package com.garena.e;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<NameValuePair> f7922a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public URL f7923b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f7924c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f7925d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, String> f7926e = new HashMap<>();

    public String a() {
        return this.f7925d;
    }

    public boolean b() {
        return this.f7924c;
    }

    public URL c() {
        return this.f7923b;
    }

    public List<NameValuePair> d() {
        List<NameValuePair> list = this.f7922a;
        return list == null ? new ArrayList() : list;
    }

    public String e() throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (NameValuePair next : d()) {
            if (next.getValue() == null) {
                com.beetalk.sdk.e.a.c("get query null  %s", next.getName());
            }
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(next.getName(), "UTF-8"));
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
        }
        return sb.toString();
    }

    public Map<String, String> f() {
        return this.f7926e;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private List<NameValuePair> f7927a;

        /* renamed from: b  reason: collision with root package name */
        private URL f7928b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7929c;

        /* renamed from: d  reason: collision with root package name */
        private String f7930d;

        public a a(String str) {
            this.f7930d = str;
            return this;
        }

        public a a(String str, String str2) {
            if (this.f7927a == null) {
                this.f7927a = new ArrayList();
            }
            this.f7927a.add(new BasicNameValuePair(str, str2));
            return this;
        }

        public a a(URL url) {
            if (url.getProtocol().equalsIgnoreCase("https")) {
                this.f7929c = true;
            }
            this.f7928b = url;
            return this;
        }

        public d a() {
            d dVar = new d();
            List unused = dVar.f7922a = this.f7927a;
            URL unused2 = dVar.f7923b = this.f7928b;
            boolean unused3 = dVar.f7924c = this.f7929c;
            String unused4 = dVar.f7925d = this.f7930d;
            return dVar;
        }
    }
}
