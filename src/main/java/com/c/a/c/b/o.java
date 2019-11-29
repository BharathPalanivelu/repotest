package com.c.a.c.b;

import android.util.Log;
import com.c.a.c.h;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class o extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private static final StackTraceElement[] f5856a = new StackTraceElement[0];
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private com.c.a.c.a dataSource;
    private h key;

    public Throwable fillInStackTrace() {
        return this;
    }

    public o(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    public o(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    public o(String str, List<Throwable> list) {
        super(str);
        setStackTrace(f5856a);
        this.causes = list;
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar, com.c.a.c.a aVar) {
        a(hVar, aVar, (Class<?>) null);
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar, com.c.a.c.a aVar, Class<?> cls) {
        this.key = hVar;
        this.dataSource = aVar;
        this.dataClass = cls;
    }

    public List<Throwable> a() {
        return this.causes;
    }

    public List<Throwable> b() {
        ArrayList arrayList = new ArrayList();
        a((Throwable) this, (List<Throwable>) arrayList);
        return arrayList;
    }

    public void a(String str) {
        List<Throwable> b2 = b();
        int size = b2.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(SQLBuilder.PARENTHESES_RIGHT);
            Log.i(str, sb.toString(), b2.get(i));
            i = i2;
        }
    }

    private void a(Throwable th, List<Throwable> list) {
        if (th instanceof o) {
            for (Throwable a2 : ((o) th).a()) {
                a(a2, list);
            }
            return;
        }
        list.add(th);
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        a((Appendable) printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        a((Appendable) printWriter);
    }

    private void a(Appendable appendable) {
        a((Throwable) this, appendable);
        a(a(), (Appendable) new a(appendable));
    }

    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.getMessage());
        String str3 = "";
        if (this.dataClass != null) {
            str = ", " + this.dataClass;
        } else {
            str = str3;
        }
        sb.append(str);
        if (this.dataSource != null) {
            str2 = ", " + this.dataSource;
        } else {
            str2 = str3;
        }
        sb.append(str2);
        if (this.key != null) {
            str3 = ", " + this.key;
        }
        sb.append(str3);
        return sb.toString();
    }

    private static void a(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private static void a(List<Throwable> list, Appendable appendable) {
        try {
            b(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void b(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof o) {
                ((o) th).a(appendable);
            } else {
                a(th, appendable);
            }
            i = i2;
        }
    }

    private static final class a implements Appendable {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f5857a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f5858b = true;

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        a(Appendable appendable) {
            this.f5857a = appendable;
        }

        public Appendable append(char c2) throws IOException {
            boolean z = false;
            if (this.f5858b) {
                this.f5858b = false;
                this.f5857a.append("  ");
            }
            if (c2 == 10) {
                z = true;
            }
            this.f5858b = z;
            this.f5857a.append(c2);
            return this;
        }

        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence a2 = a(charSequence);
            return append(a2, 0, a2.length());
        }

        public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            CharSequence a2 = a(charSequence);
            boolean z = false;
            if (this.f5858b) {
                this.f5858b = false;
                this.f5857a.append("  ");
            }
            if (a2.length() > 0 && a2.charAt(i2 - 1) == 10) {
                z = true;
            }
            this.f5858b = z;
            this.f5857a.append(a2, i, i2);
            return this;
        }
    }
}
