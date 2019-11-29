package androidx.emoji.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.util.e;
import androidx.k.a.a.b;
import java.io.IOException;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final b f2076a;

    /* renamed from: b  reason: collision with root package name */
    private final char[] f2077b;

    /* renamed from: c  reason: collision with root package name */
    private final a f2078c;

    /* renamed from: d  reason: collision with root package name */
    private final Typeface f2079d;

    f() {
        this.f2079d = null;
        this.f2076a = null;
        this.f2078c = new a(1024);
        this.f2077b = new char[0];
    }

    private f(Typeface typeface, b bVar) {
        this.f2079d = typeface;
        this.f2076a = bVar;
        this.f2078c = new a(1024);
        this.f2077b = new char[(this.f2076a.b() * 2)];
        a(this.f2076a);
    }

    public static f a(AssetManager assetManager, String str) throws IOException {
        return new f(Typeface.createFromAsset(assetManager, str), e.a(assetManager, str));
    }

    private void a(b bVar) {
        int b2 = bVar.b();
        for (int i = 0; i < b2; i++) {
            b bVar2 = new b(this, i);
            Character.toChars(bVar2.a(), this.f2077b, i * 2);
            a(bVar2);
        }
    }

    /* access modifiers changed from: package-private */
    public Typeface a() {
        return this.f2079d;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f2076a.a();
    }

    /* access modifiers changed from: package-private */
    public a c() {
        return this.f2078c;
    }

    public char[] d() {
        return this.f2077b;
    }

    public b e() {
        return this.f2076a;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        e.a(bVar, (Object) "emoji metadata cannot be null");
        e.a(bVar.g() > 0, (Object) "invalid metadata codepoint length");
        this.f2078c.a(bVar, 0, bVar.g() - 1);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<a> f2080a;

        /* renamed from: b  reason: collision with root package name */
        private b f2081b;

        private a() {
            this(1);
        }

        a(int i) {
            this.f2080a = new SparseArray<>(i);
        }

        /* access modifiers changed from: package-private */
        public a a(int i) {
            SparseArray<a> sparseArray = this.f2080a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i);
        }

        /* access modifiers changed from: package-private */
        public final b a() {
            return this.f2081b;
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar, int i, int i2) {
            a a2 = a(bVar.a(i));
            if (a2 == null) {
                a2 = new a();
                this.f2080a.put(bVar.a(i), a2);
            }
            if (i2 > i) {
                a2.a(bVar, i + 1, i2);
            } else {
                a2.f2081b = bVar;
            }
        }
    }
}
