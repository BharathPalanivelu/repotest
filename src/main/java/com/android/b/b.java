package com.android.b;

import java.util.Collections;
import java.util.Map;

public interface b {
    a a(String str);

    void a();

    void a(String str, a aVar);

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f4582a;

        /* renamed from: b  reason: collision with root package name */
        public String f4583b;

        /* renamed from: c  reason: collision with root package name */
        public long f4584c;

        /* renamed from: d  reason: collision with root package name */
        public long f4585d;

        /* renamed from: e  reason: collision with root package name */
        public long f4586e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f4587f = Collections.emptyMap();

        public boolean a() {
            return this.f4585d < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f4586e < System.currentTimeMillis();
        }
    }
}
