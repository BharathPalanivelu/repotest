package life.knowledge4.videotrimmer.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f33770a = new Handler(Looper.getMainLooper()) {
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
    private static final Map<String, a> f33771b = new HashMap();

    public static void a(String str, Runnable runnable, long j) {
        if ("".equals(str)) {
            f33770a.postDelayed(runnable, j);
            return;
        }
        f33770a.postAtTime(runnable, b(str), SystemClock.uptimeMillis() + j);
    }

    private static a b(String str) {
        a aVar;
        synchronized (f33771b) {
            aVar = f33771b.get(str);
            if (aVar == null) {
                aVar = new a(str);
                f33771b.put(str, aVar);
            }
            aVar.f33772a++;
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public static void b(a aVar) {
        synchronized (f33771b) {
            int i = aVar.f33772a - 1;
            aVar.f33772a = i;
            if (i == 0) {
                String str = aVar.f33773b;
                a remove = f33771b.remove(str);
                if (remove != aVar) {
                    f33771b.put(str, remove);
                }
            }
        }
    }

    public static void a(String str) {
        a remove;
        synchronized (f33771b) {
            remove = f33771b.remove(str);
        }
        if (remove != null) {
            f33770a.removeCallbacksAndMessages(remove);
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f33772a;

        /* renamed from: b  reason: collision with root package name */
        final String f33773b;

        private a(String str) {
            this.f33772a = 0;
            this.f33773b = str;
        }
    }
}
