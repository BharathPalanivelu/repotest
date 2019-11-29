package com.crashlytics.android.c;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import io.a.a.a.a.b.i;
import io.a.a.a.c;
import java.io.File;
import java.util.Set;

class y {

    /* renamed from: a  reason: collision with root package name */
    private static final b f6606a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final Context f6607b;

    /* renamed from: c  reason: collision with root package name */
    private final a f6608c;

    /* renamed from: d  reason: collision with root package name */
    private w f6609d;

    public interface a {
        File a();
    }

    y(Context context, a aVar) {
        this(context, aVar, (String) null);
    }

    y(Context context, a aVar, String str) {
        this.f6607b = context;
        this.f6608c = aVar;
        this.f6609d = f6606a;
        a(str);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        this.f6609d.c();
        this.f6609d = f6606a;
        if (str != null) {
            if (!i.a(this.f6607b, "com.crashlytics.CollectCustomLogs", true)) {
                c.h().a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            } else {
                a(b(str), (int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j, String str) {
        this.f6609d.a(j, str);
    }

    /* access modifiers changed from: package-private */
    public c a() {
        return this.f6609d.a();
    }

    /* access modifiers changed from: package-private */
    public byte[] b() {
        return this.f6609d.b();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f6609d.d();
    }

    /* access modifiers changed from: package-private */
    public void a(Set<String> set) {
        File[] listFiles = this.f6608c.a().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(a(file))) {
                    file.delete();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(File file, int i) {
        this.f6609d = new ak(file, i);
    }

    private File b(String str) {
        return new File(this.f6608c.a(), "crashlytics-userlog-" + str + ".temp");
    }

    private String a(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        if (lastIndexOf == -1) {
            return name;
        }
        return name.substring(20, lastIndexOf);
    }

    private static final class b implements w {
        public c a() {
            return null;
        }

        public void a(long j, String str) {
        }

        public byte[] b() {
            return null;
        }

        public void c() {
        }

        public void d() {
        }

        private b() {
        }
    }
}
