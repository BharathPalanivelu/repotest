package com.shopee.livequiz.c;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f29698a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, a> f29699b = new HashMap<>(2);

    public static void a() {
        if (f29698a == null) {
            f29698a = new f();
        }
    }

    private f() {
        this.f29699b.put("bg_thread", new a("bg_thread"));
        this.f29699b.put("loop_thread", new a("loop_thread"));
        this.f29699b.get("bg_thread").a();
        this.f29699b.get("loop_thread").a();
    }

    public static void b() {
        f fVar = f29698a;
        if (fVar != null) {
            fVar.f29699b.get("bg_thread").c();
            f29698a.f29699b.get("loop_thread").c();
            f29698a.f29699b.clear();
            f29698a = null;
        }
    }

    public static a a(String str) {
        f fVar = f29698a;
        if (fVar == null) {
            return null;
        }
        return fVar.f29699b.get(str);
    }

    public static boolean b(String str) {
        f fVar = f29698a;
        if (fVar == null) {
            return false;
        }
        a aVar = fVar.f29699b.get(str);
        if (aVar == null) {
            return false;
        }
        return aVar.b();
    }

    public static void a(e eVar) {
        synchronized ("bg_thread") {
            if (b("bg_thread")) {
                a a2 = a("bg_thread");
                if (a2 != null) {
                    a2.a(eVar.b());
                }
            }
        }
    }

    public static void a(e eVar, long j) {
        synchronized ("bg_thread") {
            if (b("bg_thread")) {
                a a2 = a("bg_thread");
                if (a2 != null) {
                    a2.a(eVar.b(), j);
                }
            }
        }
    }

    public static void b(e eVar) {
        synchronized ("bg_thread") {
            if (b("bg_thread")) {
                a a2 = a("bg_thread");
                if (a2 != null) {
                    a2.b(eVar.b());
                }
            }
        }
    }

    public static void a(e eVar, long j, String str) {
        if (((str.hashCode() == -439073787 && str.equals("loop_thread")) ? (char) 0 : 65535) != 0) {
            a(eVar, j);
            return;
        }
        synchronized ("loop_thread") {
            if (b("loop_thread")) {
                a a2 = a("loop_thread");
                if (a2 != null) {
                    a2.a(eVar.b(), j);
                }
            }
        }
    }

    public static void a(e eVar, String str) {
        if (((str.hashCode() == -439073787 && str.equals("loop_thread")) ? (char) 0 : 65535) != 0) {
            b(eVar);
            return;
        }
        synchronized ("loop_thread") {
            if (b("loop_thread")) {
                a a2 = a("loop_thread");
                if (a2 != null) {
                    a2.b(eVar.b());
                }
            }
        }
    }

    public static void c(e eVar) {
        com.garena.android.appkit.f.f.a().a(eVar.b());
    }

    public static void d(e eVar) {
        com.garena.android.appkit.f.f.a().b(eVar.b());
    }

    public static void b(e eVar, long j) {
        com.garena.android.appkit.f.f.a().a(eVar.b(), (int) j);
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private HandlerThread f29700a;

        /* renamed from: b  reason: collision with root package name */
        private Handler f29701b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f29702c;

        /* renamed from: d  reason: collision with root package name */
        private String f29703d;

        public a(String str) {
            this.f29703d = str;
        }

        public void a() {
            this.f29700a = new HandlerThread(this.f29703d, 10);
            this.f29700a.start();
            this.f29702c = true;
            this.f29701b = new Handler(this.f29700a.getLooper());
        }

        public boolean b() {
            return this.f29702c;
        }

        public void c() {
            if (b()) {
                this.f29702c = false;
                this.f29701b.removeCallbacksAndMessages((Object) null);
                this.f29701b = null;
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f29700a.quitSafely();
                } else {
                    this.f29700a.quit();
                }
                this.f29700a = null;
            }
        }

        public void a(Runnable runnable) {
            if (b()) {
                this.f29701b.post(runnable);
            }
        }

        public void a(Runnable runnable, long j) {
            if (b()) {
                this.f29701b.postDelayed(runnable, j);
            }
        }

        public void b(Runnable runnable) {
            if (b()) {
                this.f29701b.removeCallbacks(runnable);
            }
        }
    }
}
