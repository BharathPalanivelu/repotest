package com.f.a;

import com.litesuits.orm.db.assit.SQLBuilder;

public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    private final int f6675a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6676b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6677c;

    /* renamed from: d  reason: collision with root package name */
    private final g f6678d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6679e;

    private k(a aVar) {
        m.b(aVar);
        this.f6675a = aVar.f6680a;
        this.f6676b = aVar.f6681b;
        this.f6677c = aVar.f6682c;
        this.f6678d = aVar.f6683d;
        this.f6679e = aVar.f6684e;
    }

    public static a a() {
        return new a();
    }

    public void a(int i, String str, String str2) {
        m.b(str2);
        String b2 = b(str);
        a(i, b2);
        a(i, b2, this.f6675a);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (this.f6675a > 0) {
                c(i, b2);
            }
            b(i, b2, str2);
            b(i, b2);
            return;
        }
        if (this.f6675a > 0) {
            c(i, b2);
        }
        for (int i2 = 0; i2 < length; i2 += 4000) {
            b(i, b2, new String(bytes, i2, Math.min(length - i2, 4000)));
        }
        b(i, b2);
    }

    private void a(int i, String str) {
        c(i, str, "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    private void a(int i, String str, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.f6677c) {
            c(i, str, "│ Thread: " + Thread.currentThread().getName());
            c(i, str);
        }
        int a2 = a(stackTrace) + this.f6676b;
        if (i2 + a2 > stackTrace.length) {
            i2 = (stackTrace.length - a2) - 1;
        }
        String str2 = "";
        while (i2 > 0) {
            int i3 = i2 + a2;
            if (i3 < stackTrace.length) {
                str2 = str2 + "   ";
                c(i, str, 9474 + ' ' + str2 + a(stackTrace[i3].getClassName()) + "." + stackTrace[i3].getMethodName() + SQLBuilder.BLANK + " (" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + SQLBuilder.PARENTHESES_RIGHT);
            }
            i2--;
        }
    }

    private void b(int i, String str) {
        c(i, str, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    private void c(int i, String str) {
        c(i, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
    }

    private void b(int i, String str, String str2) {
        m.b(str2);
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            c(i, str, "│ " + str3);
        }
    }

    private void c(int i, String str, String str2) {
        m.b(str2);
        this.f6678d.a(i, str, str2);
    }

    private String a(String str) {
        m.b(str);
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private int a(StackTraceElement[] stackTraceElementArr) {
        m.b(stackTraceElementArr);
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(j.class.getName()) && !className.equals(i.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    private String b(String str) {
        if (m.a((CharSequence) str) || m.a(this.f6679e, str)) {
            return this.f6679e;
        }
        return this.f6679e + "-" + str;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f6680a;

        /* renamed from: b  reason: collision with root package name */
        int f6681b;

        /* renamed from: c  reason: collision with root package name */
        boolean f6682c;

        /* renamed from: d  reason: collision with root package name */
        g f6683d;

        /* renamed from: e  reason: collision with root package name */
        String f6684e;

        private a() {
            this.f6680a = 2;
            this.f6681b = 0;
            this.f6682c = true;
            this.f6684e = "PRETTY_LOGGER";
        }

        public a a(int i) {
            this.f6680a = i;
            return this;
        }

        public a b(int i) {
            this.f6681b = i;
            return this;
        }

        public a a(boolean z) {
            this.f6682c = z;
            return this;
        }

        public a a(String str) {
            this.f6684e = str;
            return this;
        }

        public k a() {
            if (this.f6683d == null) {
                this.f6683d = new h();
            }
            return new k(this);
        }
    }
}
