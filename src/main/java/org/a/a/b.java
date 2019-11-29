package org.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f33819a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            Runnable callback = message.getCallback();
            if (callback != null) {
                callback.run();
                b.b((a) message.obj);
                return;
            }
            super.handleMessage(message);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, a> f33820b = new HashMap();

    public static void a(String str, Runnable runnable, long j) {
        if ("".equals(str)) {
            f33819a.postDelayed(runnable, j);
            return;
        }
        f33819a.postAtTime(runnable, a(str), SystemClock.uptimeMillis() + j);
    }

    private static a a(String str) {
        a aVar;
        synchronized (f33820b) {
            aVar = f33820b.get(str);
            if (aVar == null) {
                aVar = new a(str);
                f33820b.put(str, aVar);
            }
            aVar.f33821a++;
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public static void b(a aVar) {
        synchronized (f33820b) {
            int i = aVar.f33821a - 1;
            aVar.f33821a = i;
            if (i == 0) {
                String str = aVar.f33822b;
                a remove = f33820b.remove(str);
                if (remove != aVar) {
                    f33820b.put(str, remove);
                }
            }
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f33821a;

        /* renamed from: b  reason: collision with root package name */
        final String f33822b;

        private a(String str) {
            this.f33821a = 0;
            this.f33822b = str;
        }
    }
}
