package g.a;

import android.os.Build;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile b[] f33037a = f33038b;

    /* renamed from: b  reason: collision with root package name */
    private static final b[] f33038b = new b[0];

    /* renamed from: c  reason: collision with root package name */
    private static final List<b> f33039c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private static final b f33040d = new b() {
        public void a(String str, Object... objArr) {
            for (b a2 : a.f33037a) {
                a2.a(str, objArr);
            }
        }

        public void b(String str, Object... objArr) {
            for (b b2 : a.f33037a) {
                b2.b(str, objArr);
            }
        }

        public void c(String str, Object... objArr) {
            for (b c2 : a.f33037a) {
                c2.c(str, objArr);
            }
        }

        public void a(Throwable th) {
            for (b a2 : a.f33037a) {
                a2.a(th);
            }
        }

        public void d(String str, Object... objArr) {
            for (b d2 : a.f33037a) {
                d2.d(str, objArr);
            }
        }

        public void b(Throwable th) {
            for (b b2 : a.f33037a) {
                b2.b(th);
            }
        }

        /* access modifiers changed from: protected */
        public void a(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }
    };

    public static void a(String str, Object... objArr) {
        f33040d.a(str, objArr);
    }

    public static void b(String str, Object... objArr) {
        f33040d.b(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        f33040d.c(str, objArr);
    }

    public static void a(Throwable th) {
        f33040d.a(th);
    }

    public static void d(String str, Object... objArr) {
        f33040d.d(str, objArr);
    }

    public static void b(Throwable th) {
        f33040d.b(th);
    }

    public static b a(String str) {
        for (b bVar : f33037a) {
            bVar.f33042a.set(str);
        }
        return f33040d;
    }

    public static void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("tree == null");
        } else if (bVar != f33040d) {
            synchronized (f33039c) {
                f33039c.add(bVar);
                f33037a = (b[]) f33039c.toArray(new b[f33039c.size()]);
            }
        } else {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
    }

    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final ThreadLocal<String> f33042a = new ThreadLocal<>();

        /* access modifiers changed from: protected */
        public abstract void a(int i, String str, String str2, Throwable th);

        /* access modifiers changed from: protected */
        @Deprecated
        public boolean a(int i) {
            return true;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            String str = this.f33042a.get();
            if (str != null) {
                this.f33042a.remove();
            }
            return str;
        }

        public void a(String str, Object... objArr) {
            a(2, (Throwable) null, str, objArr);
        }

        public void b(String str, Object... objArr) {
            a(3, (Throwable) null, str, objArr);
        }

        public void c(String str, Object... objArr) {
            a(4, (Throwable) null, str, objArr);
        }

        public void a(Throwable th) {
            a(5, th, (String) null, new Object[0]);
        }

        public void d(String str, Object... objArr) {
            a(6, (Throwable) null, str, objArr);
        }

        public void b(Throwable th) {
            a(6, th, (String) null, new Object[0]);
        }

        /* access modifiers changed from: protected */
        public boolean a(String str, int i) {
            return a(i);
        }

        private void a(int i, Throwable th, String str, Object... objArr) {
            String b2 = b();
            if (a(b2, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = e(str, objArr);
                    }
                    if (th != null) {
                        str = str + "\n" + c(th);
                    }
                } else if (th != null) {
                    str = c(th);
                } else {
                    return;
                }
                a(i, b2, str, th);
            }
        }

        /* access modifiers changed from: protected */
        public String e(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        private String c(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }
    }

    /* renamed from: g.a.a$a  reason: collision with other inner class name */
    public static class C0509a extends b {

        /* renamed from: b  reason: collision with root package name */
        private static final Pattern f33041b = Pattern.compile("(\\$\\d+)+$");

        /* access modifiers changed from: protected */
        public String a(StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = f33041b.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String substring = className.substring(className.lastIndexOf(46) + 1);
            return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
        }

        /* access modifiers changed from: package-private */
        public final String b() {
            String b2 = super.b();
            if (b2 != null) {
                return b2;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 5) {
                return a(stackTrace[5]);
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        /* access modifiers changed from: protected */
        public void a(int i, String str, String str2, Throwable th) {
            int min;
            if (str2.length() >= 4000) {
                int i2 = 0;
                int length = str2.length();
                while (i2 < length) {
                    int indexOf = str2.indexOf(10, i2);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i2 + 4000);
                        String substring = str2.substring(i2, min);
                        if (i == 7) {
                            Log.wtf(str, substring);
                        } else {
                            Log.println(i, str, substring);
                        }
                        if (min >= indexOf) {
                            break;
                        }
                        i2 = min;
                    }
                    i2 = min + 1;
                }
            } else if (i == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i, str, str2);
            }
        }
    }
}
