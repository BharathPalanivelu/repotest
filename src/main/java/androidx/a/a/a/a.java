package androidx.a.a.a;

import java.util.concurrent.Executor;

public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f497a;

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f498d = new Executor() {
        public void execute(Runnable runnable) {
            a.a().b(runnable);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f499e = new Executor() {
        public void execute(Runnable runnable) {
            a.a().a(runnable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private c f500b = this.f501c;

    /* renamed from: c  reason: collision with root package name */
    private c f501c = new b();

    private a() {
    }

    public static a a() {
        if (f497a != null) {
            return f497a;
        }
        synchronized (a.class) {
            if (f497a == null) {
                f497a = new a();
            }
        }
        return f497a;
    }

    public void a(Runnable runnable) {
        this.f500b.a(runnable);
    }

    public void b(Runnable runnable) {
        this.f500b.b(runnable);
    }

    public boolean b() {
        return this.f500b.b();
    }
}
