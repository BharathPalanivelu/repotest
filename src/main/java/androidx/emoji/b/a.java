package androidx.emoji.b;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f2026e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static volatile a f2027f;

    /* renamed from: a  reason: collision with root package name */
    final f f2028a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f2029b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f2030c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f2031d;

    /* renamed from: g  reason: collision with root package name */
    private final ReadWriteLock f2032g = new ReentrantReadWriteLock();
    private final Set<d> h;
    private int i = 3;
    private final Handler j;
    private final C0046a k;
    private final boolean l;
    private final int m;
    private final int n;

    public static abstract class d {
        public void a() {
        }

        public void a(Throwable th) {
        }
    }

    public interface f {
        void a(g gVar);
    }

    public static abstract class g {
        public abstract void a(f fVar);

        public abstract void a(Throwable th);
    }

    private a(c cVar) {
        this.f2029b = cVar.f2038b;
        this.f2030c = cVar.f2039c;
        this.f2031d = cVar.f2040d;
        this.l = cVar.f2042f;
        this.m = cVar.f2043g;
        this.f2028a = cVar.f2037a;
        this.n = cVar.h;
        this.j = new Handler(Looper.getMainLooper());
        this.h = new androidx.b.b();
        if (cVar.f2041e != null && !cVar.f2041e.isEmpty()) {
            this.h.addAll(cVar.f2041e);
        }
        this.k = Build.VERSION.SDK_INT < 19 ? new C0046a(this) : new b(this);
        f();
    }

    public static a a(c cVar) {
        if (f2027f == null) {
            synchronized (f2026e) {
                if (f2027f == null) {
                    f2027f = new a(cVar);
                }
            }
        }
        return f2027f;
    }

    public static a a() {
        a aVar;
        synchronized (f2026e) {
            androidx.core.util.e.a(f2027f != null, "EmojiCompat is not initialized. Please call EmojiCompat.init() first");
            aVar = f2027f;
        }
        return aVar;
    }

    /* JADX INFO: finally extract failed */
    private void f() {
        this.f2032g.writeLock().lock();
        try {
            if (this.n == 0) {
                this.i = 0;
            }
            this.f2032g.writeLock().unlock();
            if (c() == 0) {
                this.k.a();
            }
        } catch (Throwable th) {
            this.f2032g.writeLock().unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void b() {
        ArrayList arrayList = new ArrayList();
        this.f2032g.writeLock().lock();
        try {
            this.i = 1;
            arrayList.addAll(this.h);
            this.h.clear();
            this.f2032g.writeLock().unlock();
            this.j.post(new e((Collection<d>) arrayList, this.i));
        } catch (Throwable th) {
            this.f2032g.writeLock().unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f2032g.writeLock().lock();
        try {
            this.i = 2;
            arrayList.addAll(this.h);
            this.h.clear();
            this.f2032g.writeLock().unlock();
            this.j.post(new e(arrayList, this.i, th));
        } catch (Throwable th2) {
            this.f2032g.writeLock().unlock();
            throw th2;
        }
    }

    public void a(d dVar) {
        androidx.core.util.e.a(dVar, (Object) "initCallback cannot be null");
        this.f2032g.writeLock().lock();
        try {
            if (this.i != 1) {
                if (this.i != 2) {
                    this.h.add(dVar);
                }
            }
            this.j.post(new e(dVar, this.i));
        } finally {
            this.f2032g.writeLock().unlock();
        }
    }

    public int c() {
        this.f2032g.readLock().lock();
        try {
            return this.i;
        } finally {
            this.f2032g.readLock().unlock();
        }
    }

    private boolean g() {
        return c() == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.m;
    }

    public static boolean a(Editable editable, int i2, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return c.a(editable, i2, keyEvent);
        }
        return false;
    }

    public static boolean a(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            return c.a(inputConnection, editable, i2, i3, z);
        }
        return false;
    }

    public CharSequence a(CharSequence charSequence) {
        return a(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence a(CharSequence charSequence, int i2, int i3) {
        return a(charSequence, i2, i3, Integer.MAX_VALUE);
    }

    public CharSequence a(CharSequence charSequence, int i2, int i3, int i4) {
        return a(charSequence, i2, i3, i4, 0);
    }

    public CharSequence a(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        androidx.core.util.e.a(g(), "Not initialized yet");
        androidx.core.util.e.a(i2, "start cannot be negative");
        androidx.core.util.e.a(i3, "end cannot be negative");
        androidx.core.util.e.a(i4, "maxEmojiCount cannot be negative");
        androidx.core.util.e.a(i2 <= i3, (Object) "start should be <= than end");
        if (charSequence == null) {
            return charSequence;
        }
        androidx.core.util.e.a(i2 <= charSequence.length(), (Object) "start should be < than charSequence length");
        androidx.core.util.e.a(i3 <= charSequence.length(), (Object) "end should be < than charSequence length");
        if (charSequence.length() == 0 || i2 == i3) {
            return charSequence;
        }
        return this.k.a(charSequence, i2, i3, i4, i5 != 1 ? i5 != 2 ? this.f2029b : false : true);
    }

    public void a(EditorInfo editorInfo) {
        if (g() && editorInfo != null && editorInfo.extras != null) {
            this.k.a(editorInfo);
        }
    }

    static class h {
        h() {
        }

        /* access modifiers changed from: package-private */
        public d a(b bVar) {
            return new g(bVar);
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final f f2037a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2038b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2039c;

        /* renamed from: d  reason: collision with root package name */
        int[] f2040d;

        /* renamed from: e  reason: collision with root package name */
        Set<d> f2041e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2042f;

        /* renamed from: g  reason: collision with root package name */
        int f2043g = -16711936;
        int h = 0;

        protected c(f fVar) {
            androidx.core.util.e.a(fVar, (Object) "metadataLoader cannot be null.");
            this.f2037a = fVar;
        }
    }

    private static class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final List<d> f2044a;

        /* renamed from: b  reason: collision with root package name */
        private final Throwable f2045b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2046c;

        e(d dVar, int i) {
            this(Arrays.asList(new d[]{(d) androidx.core.util.e.a(dVar, (Object) "initCallback cannot be null")}), i, (Throwable) null);
        }

        e(Collection<d> collection, int i) {
            this(collection, i, (Throwable) null);
        }

        e(Collection<d> collection, int i, Throwable th) {
            androidx.core.util.e.a(collection, (Object) "initCallbacks cannot be null");
            this.f2044a = new ArrayList(collection);
            this.f2046c = i;
            this.f2045b = th;
        }

        public void run() {
            int size = this.f2044a.size();
            int i = 0;
            if (this.f2046c != 1) {
                while (i < size) {
                    this.f2044a.get(i).a(this.f2045b);
                    i++;
                }
                return;
            }
            while (i < size) {
                this.f2044a.get(i).a();
                i++;
            }
        }
    }

    /* renamed from: androidx.emoji.b.a$a  reason: collision with other inner class name */
    private static class C0046a {

        /* renamed from: a  reason: collision with root package name */
        final a f2033a;

        /* access modifiers changed from: package-private */
        public CharSequence a(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return charSequence;
        }

        /* access modifiers changed from: package-private */
        public void a(EditorInfo editorInfo) {
        }

        C0046a(a aVar) {
            this.f2033a = aVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2033a.b();
        }
    }

    private static final class b extends C0046a {

        /* renamed from: b  reason: collision with root package name */
        private volatile c f2034b;

        /* renamed from: c  reason: collision with root package name */
        private volatile f f2035c;

        b(a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            try {
                this.f2033a.f2028a.a(new g() {
                    public void a(f fVar) {
                        b.this.a(fVar);
                    }

                    public void a(Throwable th) {
                        b.this.f2033a.a(th);
                    }
                });
            } catch (Throwable th) {
                this.f2033a.a(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(f fVar) {
            if (fVar == null) {
                this.f2033a.a((Throwable) new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f2035c = fVar;
            this.f2034b = new c(this.f2035c, new h(), this.f2033a.f2030c, this.f2033a.f2031d);
            this.f2033a.b();
        }

        /* access modifiers changed from: package-private */
        public CharSequence a(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return this.f2034b.a(charSequence, i, i2, i3, z);
        }

        /* access modifiers changed from: package-private */
        public void a(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f2035c.b());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f2033a.f2029b);
        }
    }
}
