package com.bca.xco.widget.d.a.a;

import com.bca.xco.widget.d.a.t;
import com.bca.xco.widget.d.b.d;
import com.bca.xco.widget.d.b.g;
import com.bca.xco.widget.d.b.h;
import com.facebook.common.time.Clock;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f4795a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f4796b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f4797c = Charset.forName("UTF-8");

    /* renamed from: d  reason: collision with root package name */
    public static final TimeZone f4798d = TimeZone.getTimeZone("GMT");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f4799e = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(d dVar, int i, TimeUnit timeUnit) {
        try {
            return b(dVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean b(d dVar, int i, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long e_ = dVar.a().d_() ? dVar.a().e_() - nanoTime : Long.MAX_VALUE;
        dVar.a().a(Math.min(e_, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            g gVar = new g();
            while (dVar.a(gVar, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) != -1) {
                gVar.r();
            }
            if (e_ == Clock.MAX_TIME) {
                dVar.a().f();
            } else {
                dVar.a().a(nanoTime + e_);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (e_ == Clock.MAX_TIME) {
                dVar.a().f();
            } else {
                dVar.a().a(nanoTime + e_);
            }
            return false;
        } catch (Throwable th) {
            if (e_ == Clock.MAX_TIME) {
                dVar.a().f();
            } else {
                dVar.a().a(nanoTime + e_);
            }
            throw th;
        }
    }

    public static h a(h hVar) {
        try {
            return h.a(MessageDigest.getInstance(Hash.ALGORITHM_SHA1).digest(hVar.f()));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static h b(h hVar) {
        try {
            return h.a(MessageDigest.getInstance(Hash.ALGORITHM_SHA256).digest(hVar.f()));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(final String str, final boolean z) {
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static <T> T[] a(Class<T> cls, T[] tArr, T[] tArr2) {
        List a2 = a(tArr, tArr2);
        return a2.toArray((Object[]) Array.newInstance(cls, a2.size()));
    }

    private static <T> List<T> a(T[] tArr, T[] tArr2) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            int length = tArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                T t2 = tArr2[i];
                if (t.equals(t2)) {
                    arrayList.add(t2);
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    public static String a(t tVar, boolean z) {
        String str;
        if (tVar.f().contains(":")) {
            str = "[" + tVar.f() + "]";
        } else {
            str = tVar.f();
        }
        if (!z && tVar.g() == t.a(tVar.b())) {
            return str;
        }
        return str + ":" + tVar.g();
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static <T> int a(T[] tArr, T t) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (a((Object) tArr[i], (Object) t)) {
                return i;
            }
        }
        return -1;
    }

    public static String[] a(String[] strArr, String str) {
        String[] strArr2 = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static int a(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int b(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static String c(String str, int i, int i2) {
        int a2 = a(str, i, i2);
        return str.substring(a2, b(str, a2, i2));
    }

    public static int a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int a(String str, int i, int i2, char c2) {
        while (i < i2) {
            if (str.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String a(String str) {
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !c(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static boolean c(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str) {
        return f4799e.matcher(str).matches();
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }
}
