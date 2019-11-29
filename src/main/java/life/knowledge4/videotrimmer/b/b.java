package life.knowledge4.videotrimmer.b;

import java.io.File;
import life.knowledge4.videotrimmer.a.c;
import life.knowledge4.videotrimmer.a.e;
import life.knowledge4.videotrimmer.c.a;

public class b extends a.C0531a {

    /* renamed from: a  reason: collision with root package name */
    private final e f33753a;

    /* renamed from: b  reason: collision with root package name */
    private final File f33754b;

    /* renamed from: c  reason: collision with root package name */
    private final String f33755c;

    /* renamed from: d  reason: collision with root package name */
    private final long f33756d;

    /* renamed from: e  reason: collision with root package name */
    private final long f33757e;

    /* renamed from: f  reason: collision with root package name */
    private final c f33758f;

    public b(e eVar, File file, String str, long j, long j2, c cVar) {
        super("", 0, "");
        this.f33753a = eVar;
        this.f33754b = file;
        this.f33755c = str;
        this.f33756d = j;
        this.f33757e = j2;
        this.f33758f = cVar;
    }

    public void a() {
        try {
            this.f33753a.a(this.f33754b, this.f33755c, this.f33756d, this.f33757e, this.f33758f);
        } catch (Throwable th) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
    }
}
