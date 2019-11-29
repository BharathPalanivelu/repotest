package com.c.a.c.b.a;

import android.graphics.Bitmap;
import com.c.a.i.i;

class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final b f5683a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final h<a, Bitmap> f5684b = new h<>();

    c() {
    }

    public void a(Bitmap bitmap) {
        this.f5684b.a(this.f5683a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f5684b.a(this.f5683a.a(i, i2, config));
    }

    public Bitmap a() {
        return this.f5684b.a();
    }

    public String b(Bitmap bitmap) {
        return d(bitmap);
    }

    public String b(int i, int i2, Bitmap.Config config) {
        return c(i, i2, config);
    }

    public int c(Bitmap bitmap) {
        return i.a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f5684b;
    }

    private static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    static String c(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    static class b extends d<a> {
        b() {
        }

        public a a(int i, int i2, Bitmap.Config config) {
            a aVar = (a) c();
            aVar.a(i, i2, config);
            return aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b() {
            return new a(this);
        }
    }

    static class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f5685a;

        /* renamed from: b  reason: collision with root package name */
        private int f5686b;

        /* renamed from: c  reason: collision with root package name */
        private int f5687c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.Config f5688d;

        public a(b bVar) {
            this.f5685a = bVar;
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.f5686b = i;
            this.f5687c = i2;
            this.f5688d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f5686b == aVar.f5686b && this.f5687c == aVar.f5687c && this.f5688d == aVar.f5688d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.f5686b * 31) + this.f5687c) * 31;
            Bitmap.Config config = this.f5688d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.c(this.f5686b, this.f5687c, this.f5688d);
        }

        public void a() {
            this.f5685a.a(this);
        }
    }
}
