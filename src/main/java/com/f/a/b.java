package com.f.a;

import android.os.Environment;
import android.os.HandlerThread;
import com.f.a.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6659a = System.getProperty("line.separator");

    /* renamed from: b  reason: collision with root package name */
    private final Date f6660b;

    /* renamed from: c  reason: collision with root package name */
    private final SimpleDateFormat f6661c;

    /* renamed from: d  reason: collision with root package name */
    private final g f6662d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6663e;

    private b(a aVar) {
        m.b(aVar);
        this.f6660b = aVar.f6664a;
        this.f6661c = aVar.f6665b;
        this.f6662d = aVar.f6666c;
        this.f6663e = aVar.f6667d;
    }

    public static a a() {
        return new a();
    }

    public void a(int i, String str, String str2) {
        m.b(str2);
        String a2 = a(str);
        this.f6660b.setTime(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(this.f6660b.getTime()));
        sb.append(",");
        sb.append(this.f6661c.format(this.f6660b));
        sb.append(",");
        sb.append(m.a(i));
        sb.append(",");
        sb.append(a2);
        if (str2.contains(f6659a)) {
            str2 = str2.replaceAll(f6659a, " <br> ");
        }
        sb.append(",");
        sb.append(str2);
        sb.append(f6659a);
        this.f6662d.a(i, a2, sb.toString());
    }

    private String a(String str) {
        if (m.a((CharSequence) str) || m.a(this.f6663e, str)) {
            return this.f6663e;
        }
        return this.f6663e + "-" + str;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        Date f6664a;

        /* renamed from: b  reason: collision with root package name */
        SimpleDateFormat f6665b;

        /* renamed from: c  reason: collision with root package name */
        g f6666c;

        /* renamed from: d  reason: collision with root package name */
        String f6667d;

        private a() {
            this.f6667d = "PRETTY_LOGGER";
        }

        public a a(g gVar) {
            this.f6666c = gVar;
            return this;
        }

        public a a(String str) {
            this.f6667d = str;
            return this;
        }

        public b a() {
            if (this.f6664a == null) {
                this.f6664a = new Date();
            }
            if (this.f6665b == null) {
                this.f6665b = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", Locale.UK);
            }
            if (this.f6666c == null) {
                String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "logger";
                HandlerThread handlerThread = new HandlerThread("AndroidFileLogger." + str);
                handlerThread.start();
                this.f6666c = new d(new d.a(handlerThread.getLooper(), str, 512000));
            }
            return new b(this);
        }
    }
}
