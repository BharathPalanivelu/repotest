package com.crashlytics.android.c;

import com.litesuits.orm.db.assit.SQLBuilder;
import io.a.a.a.a.b.i;
import io.a.a.a.a.b.r;
import io.a.a.a.c;
import io.a.a.a.l;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

class ak implements w {

    /* renamed from: a  reason: collision with root package name */
    private final File f6417a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6418b;

    /* renamed from: c  reason: collision with root package name */
    private r f6419c;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f6423a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6424b;

        public a(byte[] bArr, int i) {
            this.f6423a = bArr;
            this.f6424b = i;
        }
    }

    public ak(File file, int i) {
        this.f6417a = file;
        this.f6418b = i;
    }

    public void a(long j, String str) {
        f();
        b(j, str);
    }

    public c a() {
        a e2 = e();
        if (e2 == null) {
            return null;
        }
        return c.a(e2.f6423a, 0, e2.f6424b);
    }

    public byte[] b() {
        a e2 = e();
        if (e2 == null) {
            return null;
        }
        return e2.f6423a;
    }

    private a e() {
        if (!this.f6417a.exists()) {
            return null;
        }
        f();
        r rVar = this.f6419c;
        if (rVar == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[rVar.a()];
        try {
            this.f6419c.a((r.c) new r.c() {
                public void a(InputStream inputStream, int i) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e2) {
            c.h().e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e2);
        }
        return new a(bArr, iArr[0]);
    }

    public void c() {
        i.a((Closeable) this.f6419c, "There was a problem closing the Crashlytics log file.");
        this.f6419c = null;
    }

    public void d() {
        c();
        this.f6417a.delete();
    }

    private void f() {
        if (this.f6419c == null) {
            try {
                this.f6419c = new r(this.f6417a);
            } catch (IOException e2) {
                l h = c.h();
                h.e("CrashlyticsCore", "Could not open log file: " + this.f6417a, e2);
            }
        }
    }

    private void b(long j, String str) {
        if (this.f6419c != null) {
            if (str == null) {
                str = "null";
            }
            try {
                int i = this.f6418b / 4;
                if (str.length() > i) {
                    str = "..." + str.substring(str.length() - i);
                }
                this.f6419c.a(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str.replaceAll("\r", SQLBuilder.BLANK).replaceAll("\n", SQLBuilder.BLANK)}).getBytes("UTF-8"));
                while (!this.f6419c.b() && this.f6419c.a() > this.f6418b) {
                    this.f6419c.c();
                }
            } catch (IOException e2) {
                c.h().e("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", e2);
            }
        }
    }
}
