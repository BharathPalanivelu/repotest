package com.otaliastudios.cameraview;

import android.util.Log;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.ArrayList;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    static String f15631a;

    /* renamed from: b  reason: collision with root package name */
    static String f15632b;

    /* renamed from: c  reason: collision with root package name */
    private static int f15633c;

    /* renamed from: d  reason: collision with root package name */
    private static List<a> f15634d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private String f15635e;

    public interface a {
        void a(int i, String str, String str2, Throwable th);
    }

    static {
        a(3);
        f15634d.add(new a() {
            public void a(int i, String str, String str2, Throwable th) {
                if (i == 0) {
                    Log.v(str, str2, th);
                } else if (i == 1) {
                    Log.i(str, str2, th);
                } else if (i == 2) {
                    Log.w(str, str2, th);
                } else if (i == 3) {
                    Log.e(str, str2, th);
                }
            }
        });
    }

    static g a(String str) {
        return new g(str);
    }

    public static void a(int i) {
        f15633c = i;
    }

    private g(String str) {
        this.f15635e = str;
    }

    private boolean b(int i) {
        return f15633c <= i && f15634d.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public void a(Object... objArr) {
        a(0, objArr);
    }

    /* access modifiers changed from: package-private */
    public void b(Object... objArr) {
        a(1, objArr);
    }

    /* access modifiers changed from: package-private */
    public void c(Object... objArr) {
        a(2, objArr);
    }

    /* access modifiers changed from: package-private */
    public void d(Object... objArr) {
        a(3, objArr);
    }

    private void a(int i, Object... objArr) {
        if (b(i)) {
            Throwable th = null;
            int length = objArr.length;
            String str = "";
            for (Throwable th2 : objArr) {
                if (th2 instanceof Throwable) {
                    th = th2;
                }
                str = (str + String.valueOf(th2)) + SQLBuilder.BLANK;
            }
            String trim = str.trim();
            for (a a2 : f15634d) {
                a2.a(i, this.f15635e, trim, th);
            }
            f15631a = trim;
            f15632b = this.f15635e;
        }
    }
}
