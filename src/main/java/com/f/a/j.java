package com.f.a;

import java.util.ArrayList;
import java.util.List;

class j implements l {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<String> f6673a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private final List<f> f6674b = new ArrayList();

    j() {
    }

    public void a(String str, Object... objArr) {
        a(3, (Throwable) null, str, objArr);
    }

    public void a(Object obj) {
        a(3, (Throwable) null, m.a(obj), new Object[0]);
    }

    public void a(Throwable th, String str, Object... objArr) {
        a(6, th, str, objArr);
    }

    public void b(String str, Object... objArr) {
        a(5, (Throwable) null, str, objArr);
    }

    public void c(String str, Object... objArr) {
        a(4, (Throwable) null, str, objArr);
    }

    public synchronized void a(int i, String str, String str2, Throwable th) {
        if (!(th == null || str2 == null)) {
            str2 = str2 + " : " + m.a(th);
        }
        if (th != null && str2 == null) {
            str2 = m.a(th);
        }
        if (m.a((CharSequence) str2)) {
            str2 = "Empty/NULL log message";
        }
        for (f next : this.f6674b) {
            if (next.a(i, str)) {
                next.a(i, str, str2);
            }
        }
    }

    public void a(f fVar) {
        this.f6674b.add(m.b(fVar));
    }

    private synchronized void a(int i, Throwable th, String str, Object... objArr) {
        m.b(str);
        a(i, a(), d(str, objArr), th);
    }

    private String a() {
        String str = this.f6673a.get();
        if (str == null) {
            return null;
        }
        this.f6673a.remove();
        return str;
    }

    private String d(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }
}
