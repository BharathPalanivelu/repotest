package org.greenrobot.eventbus;

import android.util.Log;
import java.io.PrintStream;
import java.util.logging.Level;

public interface g {
    void a(Level level, String str);

    void a(Level level, String str, Throwable th);

    public static class a implements g {

        /* renamed from: a  reason: collision with root package name */
        static final boolean f34012a;

        /* renamed from: b  reason: collision with root package name */
        private final String f34013b;

        static {
            boolean z = false;
            try {
                if (Class.forName("android.util.Log") != null) {
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            }
            f34012a = z;
        }

        public static boolean a() {
            return f34012a;
        }

        public a(String str) {
            this.f34013b = str;
        }

        public void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(a(level), this.f34013b, str);
            }
        }

        public void a(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                int a2 = a(level);
                String str2 = this.f34013b;
                Log.println(a2, str2, str + "\n" + Log.getStackTraceString(th));
            }
        }

        /* access modifiers changed from: protected */
        public int a(Level level) {
            int intValue = level.intValue();
            if (intValue < 800) {
                return intValue < 500 ? 2 : 3;
            }
            if (intValue < 900) {
                return 4;
            }
            return intValue < 1000 ? 5 : 6;
        }
    }

    public static class b implements g {
        public void a(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        public void a(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }
}
