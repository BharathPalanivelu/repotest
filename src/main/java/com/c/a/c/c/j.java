package com.c.a.c.c;

import android.text.TextUtils;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j implements h {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<i>> f5930c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Map<String, String> f5931d;

    j(Map<String, List<i>> map) {
        this.f5930c = Collections.unmodifiableMap(map);
    }

    public Map<String, String> a() {
        if (this.f5931d == null) {
            synchronized (this) {
                if (this.f5931d == null) {
                    this.f5931d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f5931d;
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f5930c.entrySet()) {
            StringBuilder sb = new StringBuilder();
            List list = (List) next.getValue();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String a2 = ((i) list.get(i)).a();
                if (!TextUtils.isEmpty(a2)) {
                    sb.append(a2);
                    if (i != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                hashMap.put(next.getKey(), sb.toString());
            }
        }
        return hashMap;
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f5930c + '}';
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f5930c.equals(((j) obj).f5930c);
        }
        return false;
    }

    public int hashCode() {
        return this.f5930c.hashCode();
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final String f5932a = b();

        /* renamed from: b  reason: collision with root package name */
        private static final Map<String, List<i>> f5933b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5934c = true;

        /* renamed from: d  reason: collision with root package name */
        private Map<String, List<i>> f5935d = f5933b;

        /* renamed from: e  reason: collision with root package name */
        private boolean f5936e = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f5932a)) {
                hashMap.put(HttpConstants.Header.USER_AGENT, Collections.singletonList(new b(f5932a)));
            }
            f5933b = Collections.unmodifiableMap(hashMap);
        }

        public a a(String str, String str2) {
            return a(str, (i) new b(str2));
        }

        public a a(String str, i iVar) {
            if (this.f5936e && HttpConstants.Header.USER_AGENT.equalsIgnoreCase(str)) {
                return b(str, iVar);
            }
            c();
            a(str).add(iVar);
            return this;
        }

        public a b(String str, i iVar) {
            c();
            if (iVar == null) {
                this.f5935d.remove(str);
            } else {
                List<i> a2 = a(str);
                a2.clear();
                a2.add(iVar);
            }
            if (this.f5936e && HttpConstants.Header.USER_AGENT.equalsIgnoreCase(str)) {
                this.f5936e = false;
            }
            return this;
        }

        private List<i> a(String str) {
            List<i> list = this.f5935d.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f5935d.put(str, arrayList);
            return arrayList;
        }

        private void c() {
            if (this.f5934c) {
                this.f5934c = false;
                this.f5935d = d();
            }
        }

        public j a() {
            this.f5934c = true;
            return new j(this.f5935d);
        }

        private Map<String, List<i>> d() {
            HashMap hashMap = new HashMap(this.f5935d.size());
            for (Map.Entry next : this.f5935d.entrySet()) {
                hashMap.put(next.getKey(), new ArrayList((Collection) next.getValue()));
            }
            return hashMap;
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }
    }

    static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        private final String f5937a;

        b(String str) {
            this.f5937a = str;
        }

        public String a() {
            return this.f5937a;
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f5937a + '\'' + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f5937a.equals(((b) obj).f5937a);
            }
            return false;
        }

        public int hashCode() {
            return this.f5937a.hashCode();
        }
    }
}
