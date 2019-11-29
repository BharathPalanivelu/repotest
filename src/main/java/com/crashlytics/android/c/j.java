package com.crashlytics.android.c;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.crashlytics.android.a.q;
import com.crashlytics.android.c.an;
import com.crashlytics.android.c.h;
import com.crashlytics.android.c.q;
import com.crashlytics.android.c.y;
import com.facebook.internal.ServerProtocol;
import com.salesforce.android.service.common.liveagentlogging.event.ErrorEvent;
import com.shopee.livequiz.data.bean.LiveParams;
import com.shopee.shopeetracker.EventSender;
import io.a.a.a.a.b.j;
import io.a.a.a.a.b.p;
import io.a.a.a.a.g.o;
import io.a.a.a.a.g.t;
import io.a.a.a.l;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

class j {

    /* renamed from: a  reason: collision with root package name */
    static final FilenameFilter f6487a = new c("BeginSession") {
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static final FilenameFilter f6488b = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(".cls");
        }
    };

    /* renamed from: c  reason: collision with root package name */
    static final FileFilter f6489c = new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory() && file.getName().length() == 35;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    static final Comparator<File> f6490d = new Comparator<File>() {
        /* renamed from: a */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    static final Comparator<File> f6491e = new Comparator<File>() {
        /* renamed from: a */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f6492f = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");

    /* renamed from: g  reason: collision with root package name */
    private static final Map<String, String> f6493g = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    private static final String[] h = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    private final AtomicInteger i = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final k j;
    private final i k;
    private final io.a.a.a.a.e.e l;
    private final p m;
    private final ah n;
    private final io.a.a.a.a.f.a o;
    /* access modifiers changed from: private */
    public final a p;
    private final f q;
    /* access modifiers changed from: private */
    public final y r;
    private final an.c s;
    private final an.b t;
    private final u u;
    private final ar v;
    /* access modifiers changed from: private */
    public final String w;
    private final q x;
    private final boolean y;
    private q z;

    private interface b {
        void a(f fVar) throws Exception;
    }

    private interface d {
        void a(FileOutputStream fileOutputStream) throws Exception;
    }

    static class c implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        private final String f6560a;

        public c(String str) {
            this.f6560a = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.f6560a) && !str.endsWith(".cls_temp");
        }
    }

    static class k implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        private final String f6573a;

        public k(String str) {
            this.f6573a = str;
        }

        public boolean accept(File file, String str) {
            if (!str.equals(this.f6573a + ".cls") && str.contains(this.f6573a) && !str.endsWith(".cls_temp")) {
                return true;
            }
            return false;
        }
    }

    private static class a implements FilenameFilter {
        private a() {
        }

        public boolean accept(File file, String str) {
            return !j.f6488b.accept(file, str) && j.f6492f.matcher(str).matches();
        }
    }

    static class e implements FilenameFilter {
        e() {
        }

        public boolean accept(File file, String str) {
            return e.f6462a.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    j(k kVar, i iVar, io.a.a.a.a.e.e eVar, p pVar, ah ahVar, io.a.a.a.a.f.a aVar, a aVar2, at atVar, boolean z2) {
        this.j = kVar;
        this.k = iVar;
        this.l = eVar;
        this.m = pVar;
        this.n = ahVar;
        this.o = aVar;
        this.p = aVar2;
        this.w = atVar.a();
        this.y = z2;
        Context r2 = kVar.r();
        this.q = new f(aVar);
        this.r = new y(r2, this.q);
        this.s = new h();
        this.t = new i();
        this.u = new u(r2);
        this.v = new ab(1024, new al(10));
        this.x = com.crashlytics.android.a.k.a(r2);
    }

    /* access modifiers changed from: package-private */
    public void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        a();
        this.z = new q(new q.a() {
            public void a(Thread thread, Throwable th) {
                j.this.a(thread, th);
            }
        }, uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.z);
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(final Thread thread, final Throwable th) {
        l h2 = io.a.a.a.c.h();
        h2.a("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        this.u.b();
        final Date date = new Date();
        this.k.a(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                j.this.j.o();
                j.this.a(date, thread, th);
                t b2 = io.a.a.a.a.g.q.a().b();
                io.a.a.a.a.g.p pVar = b2 != null ? b2.f33263b : null;
                j.this.b(pVar);
                j.this.n();
                if (pVar != null) {
                    j.this.a(pVar.f33256g);
                }
                if (!j.this.a(b2)) {
                    j.this.b(b2);
                }
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, t tVar) {
        if (tVar == null) {
            io.a.a.a.c.h().d("CrashlyticsCore", "Could not send reports. Settings are not available.");
            return;
        }
        new an(this.p.f6397a, b(tVar.f33262a.f33221d, tVar.f33262a.f33222e), this.s, this.t).a(f2, a(tVar) ? new g(this.j, this.n, tVar.f33264c) : new an.a());
    }

    /* access modifiers changed from: package-private */
    public void a(final long j2, final String str) {
        this.k.b(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                if (j.this.f()) {
                    return null;
                }
                j.this.r.a(j2, str);
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void b(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.k.a((Runnable) new Runnable() {
            public void run() {
                if (!j.this.f()) {
                    j.this.b(date, thread, th);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(final String str, final String str2, final String str3) {
        this.k.b(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                new aa(j.this.g()).a(j.this.l(), new au(str, str2, str3));
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(final Map<String, String> map) {
        this.k.b(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                new aa(j.this.g()).a(j.this.l(), (Map<String, String>) map);
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.k.b(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                j.this.n();
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public String l() {
        File[] o2 = o();
        if (o2.length > 0) {
            return a(o2[0]);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String m() {
        File[] o2 = o();
        if (o2.length > 1) {
            return a(o2[1]);
        }
        return null;
    }

    static String a(File file) {
        return file.getName().substring(0, 35);
    }

    /* access modifiers changed from: package-private */
    public boolean a(final io.a.a.a.a.g.p pVar) {
        return ((Boolean) this.k.a(new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                if (j.this.f()) {
                    io.a.a.a.c.h().a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                io.a.a.a.c.h().a("CrashlyticsCore", "Finalizing previously open sessions.");
                j.this.a(pVar, true);
                io.a.a.a.c.h().a("CrashlyticsCore", "Closed all previously open sessions");
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    /* access modifiers changed from: private */
    public void n() throws Exception {
        Date date = new Date();
        String dVar = new d(this.m).toString();
        l h2 = io.a.a.a.c.h();
        h2.a("CrashlyticsCore", "Opening a new session with ID " + dVar);
        a(dVar, date);
        c(dVar);
        d(dVar);
        e(dVar);
        this.r.a(dVar);
    }

    /* access modifiers changed from: package-private */
    public void b(io.a.a.a.a.g.p pVar) throws Exception {
        a(pVar, false);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [boolean, int] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(io.a.a.a.a.g.p r4, boolean r5) throws java.lang.Exception {
        /*
            r3 = this;
            int r0 = r5 + 8
            r3.b((int) r0)
            java.io.File[] r0 = r3.o()
            int r1 = r0.length
            java.lang.String r2 = "CrashlyticsCore"
            if (r1 > r5) goto L_0x0018
            io.a.a.a.l r4 = io.a.a.a.c.h()
            java.lang.String r5 = "No open sessions to be closed."
            r4.a((java.lang.String) r2, (java.lang.String) r5)
            return
        L_0x0018:
            r1 = r0[r5]
            java.lang.String r1 = a((java.io.File) r1)
            r3.f((java.lang.String) r1)
            if (r4 != 0) goto L_0x002d
            io.a.a.a.l r4 = io.a.a.a.c.h()
            java.lang.String r5 = "Unable to close session. Settings are not loaded."
            r4.a((java.lang.String) r2, (java.lang.String) r5)
            return
        L_0x002d:
            int r4 = r4.f33252c
            r3.a((java.io.File[]) r0, (int) r5, (int) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.c.j.a(io.a.a.a.a.g.p, boolean):void");
    }

    private void a(File[] fileArr, int i2, int i3) {
        io.a.a.a.c.h().a("CrashlyticsCore", "Closing open sessions.");
        while (i2 < fileArr.length) {
            File file = fileArr[i2];
            String a2 = a(file);
            l h2 = io.a.a.a.c.h();
            h2.a("CrashlyticsCore", "Closing session: " + a2);
            a(file, a2, i3);
            i2++;
        }
    }

    private void a(e eVar) {
        if (eVar != null) {
            try {
                eVar.a();
            } catch (IOException e2) {
                io.a.a.a.c.h().e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Set<File> set) {
        for (File b2 : set) {
            b(b2);
        }
    }

    private void b(File file) {
        if (file.isDirectory()) {
            for (File b2 : file.listFiles()) {
                b(b2);
            }
        }
        file.delete();
    }

    private void a(String str) {
        for (File delete : b(str)) {
            delete.delete();
        }
    }

    private File[] b(String str) {
        return a((FilenameFilter) new k(str));
    }

    /* access modifiers changed from: package-private */
    public File[] b() {
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, a(h(), f6488b));
        Collections.addAll(linkedList, a(i(), f6488b));
        Collections.addAll(linkedList, a(g(), f6488b));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    /* access modifiers changed from: package-private */
    public File[] c() {
        return a(f6489c);
    }

    /* access modifiers changed from: package-private */
    public File[] d() {
        return a(f6487a);
    }

    private File[] o() {
        File[] d2 = d();
        Arrays.sort(d2, f6490d);
        return d2;
    }

    private File[] a(FileFilter fileFilter) {
        return b(g().listFiles(fileFilter));
    }

    /* access modifiers changed from: private */
    public File[] a(FilenameFilter filenameFilter) {
        return a(g(), filenameFilter);
    }

    private File[] a(File file, FilenameFilter filenameFilter) {
        return b(file.listFiles(filenameFilter));
    }

    private File[] c(File file) {
        return b(file.listFiles());
    }

    private File[] b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void a(String str, int i2) {
        File g2 = g();
        av.a(g2, new c(str + "SessionEvent"), i2, f6491e);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        int a2 = i2 - av.a(h(), i2, f6491e);
        av.a(g(), f6488b, a2 - av.a(i(), a2, f6491e), f6491e);
    }

    private void b(int i2) {
        HashSet hashSet = new HashSet();
        File[] o2 = o();
        int min = Math.min(i2, o2.length);
        for (int i3 = 0; i3 < min; i3++) {
            hashSet.add(a(o2[i3]));
        }
        this.r.a((Set<String>) hashSet);
        a(a((FilenameFilter) new a()), (Set<String>) hashSet);
    }

    private void a(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = f6492f.matcher(name);
            if (!matcher.matches()) {
                io.a.a.a.c.h().a("CrashlyticsCore", "Deleting unknown file: " + name);
                file.delete();
            } else if (!set.contains(matcher.group(1))) {
                io.a.a.a.c.h().a("CrashlyticsCore", "Trimming session file: " + name);
                file.delete();
            }
        }
    }

    private File[] a(String str, File[] fileArr, int i2) {
        if (fileArr.length <= i2) {
            return fileArr;
        }
        io.a.a.a.c.h().a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i2)}));
        a(str, i2);
        return a((FilenameFilter) new c(str + "SessionEvent"));
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.k.a((Runnable) new Runnable() {
            public void run() {
                j jVar = j.this;
                jVar.a(jVar.a((FilenameFilter) new e()));
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(File[] fileArr) {
        final HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            io.a.a.a.c.h().a("CrashlyticsCore", "Found invalid session part file: " + file);
            hashSet.add(a(file));
        }
        if (!hashSet.isEmpty()) {
            File j2 = j();
            if (!j2.exists()) {
                j2.mkdir();
            }
            for (File file2 : a((FilenameFilter) new FilenameFilter() {
                public boolean accept(File file, String str) {
                    if (str.length() < 35) {
                        return false;
                    }
                    return hashSet.contains(str.substring(0, 35));
                }
            })) {
                io.a.a.a.c.h().a("CrashlyticsCore", "Moving session file: " + file2);
                if (!file2.renameTo(new File(j2, file2.getName()))) {
                    io.a.a.a.c.h().a("CrashlyticsCore", "Could not move session file. Deleting " + file2);
                    file2.delete();
                }
            }
            p();
        }
    }

    private void p() {
        File j2 = j();
        if (j2.exists()) {
            File[] a2 = a(j2, (FilenameFilter) new e());
            Arrays.sort(a2, Collections.reverseOrder());
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < a2.length && hashSet.size() < 4; i2++) {
                hashSet.add(a(a2[i2]));
            }
            a(c(j2), (Set<String>) hashSet);
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, File file, String str) throws IOException {
        byte[] b2 = ae.b(file);
        byte[] c2 = ae.c(file);
        byte[] a2 = ae.a(file, context);
        if (b2 == null || b2.length == 0) {
            l h2 = io.a.a.a.c.h();
            h2.d("CrashlyticsCore", "No minidump data found in directory " + file);
            return;
        }
        d(str, "<native-crash: minidump>");
        byte[] a3 = a(str, "BeginSession.json");
        byte[] a4 = a(str, "SessionApp.json");
        byte[] a5 = a(str, "SessionDevice.json");
        byte[] a6 = a(str, "SessionOS.json");
        byte[] a7 = ae.a(new aa(g()).b(str));
        y yVar = new y(this.j.r(), this.q, str);
        byte[] b3 = yVar.b();
        yVar.c();
        byte[] a8 = ae.a(new aa(g()).c(str));
        File file2 = new File(this.o.a(), str);
        if (!file2.mkdir()) {
            io.a.a.a.c.h().a("CrashlyticsCore", "Couldn't create native sessions directory");
            return;
        }
        a(b2, new File(file2, "minidump"));
        a(c2, new File(file2, "metadata"));
        a(a2, new File(file2, "binaryImages"));
        a(a3, new File(file2, ErrorEvent.OPENTOK_DOMAIN_SESSION));
        a(a4, new File(file2, LiveParams.SYNC_TYPE_APP));
        a(a5, new File(file2, "device"));
        a(a6, new File(file2, "os"));
        a(a7, new File(file2, "user"));
        a(b3, new File(file2, "logs"));
        a(a8, new File(file2, "keys"));
    }

    /* access modifiers changed from: package-private */
    public boolean a(final n nVar) {
        if (nVar == null) {
            return true;
        }
        return ((Boolean) this.k.a(new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                TreeSet<File> treeSet = nVar.f6585a;
                String e2 = j.this.m();
                if (e2 != null && !treeSet.isEmpty()) {
                    File first = treeSet.first();
                    if (first != null) {
                        j jVar = j.this;
                        jVar.a(jVar.j.r(), first, e2);
                    }
                }
                j.this.a((Set<File>) treeSet);
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    private void a(byte[] bArr, File file) throws IOException {
        if (bArr != null && bArr.length > 0) {
            b(bArr, file);
        }
    }

    private void b(byte[] bArr, File file) throws IOException {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.finish();
                io.a.a.a.a.b.i.a((Closeable) gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                io.a.a.a.a.b.i.a((Closeable) gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            io.a.a.a.a.b.i.a((Closeable) gZIPOutputStream);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void a(Date date, Thread thread, Throwable th) {
        e eVar;
        f fVar = null;
        try {
            String l2 = l();
            if (l2 == null) {
                io.a.a.a.c.h().e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", (Throwable) null);
                io.a.a.a.a.b.i.a((Flushable) null, "Failed to flush to session begin file.");
                io.a.a.a.a.b.i.a((Closeable) null, "Failed to close fatal exception file output stream.");
                return;
            }
            d(l2, th.getClass().getName());
            try {
                a(date.getTime());
                eVar = new e(g(), l2 + "SessionCrash");
                try {
                    fVar = f.a((OutputStream) eVar);
                    a(fVar, date, thread, th, "crash", true);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                eVar = null;
                try {
                    io.a.a.a.c.h().e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                    io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to session begin file.");
                    io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close fatal exception file output stream.");
                } catch (Throwable th2) {
                    th = th2;
                    io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to session begin file.");
                    io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close fatal exception file output stream.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                eVar = null;
                io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to session begin file.");
                io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close fatal exception file output stream.");
                throw th;
            }
            io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to session begin file.");
            io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close fatal exception file output stream.");
        } catch (Exception e4) {
            e = e4;
            eVar = null;
            io.a.a.a.c.h().e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
            io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to session begin file.");
            io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close fatal exception file output stream.");
        } catch (Throwable th4) {
            th = th4;
            eVar = null;
            io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to session begin file.");
            io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close fatal exception file output stream.");
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void b(Date date, Thread thread, Throwable th) {
        e eVar;
        String l2 = l();
        f fVar = null;
        if (l2 == null) {
            io.a.a.a.c.h().e("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", (Throwable) null);
            return;
        }
        c(l2, th.getClass().getName());
        try {
            io.a.a.a.c.h().a("CrashlyticsCore", "Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
            eVar = new e(g(), l2 + "SessionEvent" + io.a.a.a.a.b.i.a(this.i.getAndIncrement()));
            try {
                f a2 = f.a((OutputStream) eVar);
                try {
                    a(a2, date, thread, th, "error", false);
                    io.a.a.a.a.b.i.a((Flushable) a2, "Failed to flush to non-fatal file.");
                } catch (Exception e2) {
                    e = e2;
                    fVar = a2;
                    try {
                        io.a.a.a.c.h().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                        io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to non-fatal file.");
                        io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close non-fatal file output stream.");
                        a(l2, 64);
                    } catch (Throwable th2) {
                        th = th2;
                        io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to non-fatal file.");
                        io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close non-fatal file output stream.");
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fVar = a2;
                    io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to non-fatal file.");
                    io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close non-fatal file output stream.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                io.a.a.a.c.h().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to non-fatal file.");
                io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close non-fatal file output stream.");
                a(l2, 64);
            }
        } catch (Exception e4) {
            e = e4;
            eVar = null;
            io.a.a.a.c.h().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
            io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to non-fatal file.");
            io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close non-fatal file output stream.");
            a(l2, 64);
        } catch (Throwable th4) {
            th = th4;
            eVar = null;
            io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to non-fatal file.");
            io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close non-fatal file output stream.");
            throw th;
        }
        io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close non-fatal file output stream.");
        try {
            a(l2, 64);
        } catch (Exception e5) {
            io.a.a.a.c.h().e("CrashlyticsCore", "An error occurred when trimming non-fatal files.", e5);
        }
    }

    private void a(String str, String str2, b bVar) throws Exception {
        e eVar;
        f fVar = null;
        try {
            eVar = new e(g(), str + str2);
            try {
                fVar = f.a((OutputStream) eVar);
                bVar.a(fVar);
                io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to session " + str2 + " file.");
                io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close session " + str2 + " file.");
            } catch (Throwable th) {
                th = th;
                io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to session " + str2 + " file.");
                io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close session " + str2 + " file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            eVar = null;
            io.a.a.a.a.b.i.a((Flushable) fVar, "Failed to flush to session " + str2 + " file.");
            io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close session " + str2 + " file.");
            throw th;
        }
    }

    private void a(String str, String str2, d dVar) throws Exception {
        FileOutputStream fileOutputStream = null;
        try {
            File g2 = g();
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(g2, str + str2));
            try {
                dVar.a(fileOutputStream2);
                io.a.a.a.a.b.i.a((Closeable) fileOutputStream2, "Failed to close " + str2 + " file.");
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                io.a.a.a.a.b.i.a((Closeable) fileOutputStream, "Failed to close " + str2 + " file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            io.a.a.a.a.b.i.a((Closeable) fileOutputStream, "Failed to close " + str2 + " file.");
            throw th;
        }
    }

    private byte[] a(String str, String str2) {
        File g2 = g();
        return ae.a(new File(g2, str + str2));
    }

    private void a(String str, Date date) throws Exception {
        final String str2 = str;
        final String format = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{this.j.a()});
        final long time = date.getTime() / 1000;
        a(str, "BeginSession", (b) new b() {
            public void a(f fVar) throws Exception {
                ao.a(fVar, str2, format, time);
            }
        });
        a(str, "BeginSession.json", (d) new d() {
            public void a(FileOutputStream fileOutputStream) throws Exception {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() {
                    {
                        put(EventSender.TRACKING_DATA_SESSION_ID, str2);
                        put("generator", format);
                        put("started_at_seconds", Long.valueOf(time));
                    }
                }).toString().getBytes());
            }
        });
    }

    private void c(String str) throws Exception {
        String c2 = this.m.c();
        String str2 = this.p.f6401e;
        String str3 = this.p.f6402f;
        final String str4 = c2;
        final String str5 = str2;
        final String str6 = str3;
        final String b2 = this.m.b();
        final int id = io.a.a.a.a.b.l.determineFrom(this.p.f6399c).getId();
        a(str, "SessionApp", (b) new b() {
            public void a(f fVar) throws Exception {
                ao.a(fVar, str4, j.this.p.f6397a, str5, str6, b2, id, j.this.w);
            }
        });
        a(str, "SessionApp.json", (d) new d() {
            public void a(FileOutputStream fileOutputStream) throws Exception {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() {
                    {
                        put("app_identifier", str4);
                        put("api_key", j.this.p.f6397a);
                        put("version_code", str5);
                        put("version_name", str6);
                        put("install_uuid", b2);
                        put("delivery_mechanism", Integer.valueOf(id));
                        put("unity_version", TextUtils.isEmpty(j.this.w) ? "" : j.this.w);
                    }
                }).toString().getBytes());
            }
        });
    }

    private void d(String str) throws Exception {
        final boolean g2 = io.a.a.a.a.b.i.g(this.j.r());
        a(str, "SessionOS", (b) new b() {
            public void a(f fVar) throws Exception {
                ao.a(fVar, Build.VERSION.RELEASE, Build.VERSION.CODENAME, g2);
            }
        });
        a(str, "SessionOS.json", (d) new d() {
            public void a(FileOutputStream fileOutputStream) throws Exception {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() {
                    {
                        put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, Build.VERSION.RELEASE);
                        put("build_version", Build.VERSION.CODENAME);
                        put("is_rooted", Boolean.valueOf(g2));
                    }
                }).toString().getBytes());
            }
        });
    }

    private void e(String str) throws Exception {
        String str2 = str;
        Context r2 = this.j.r();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int a2 = io.a.a.a.a.b.i.a();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long b2 = io.a.a.a.a.b.i.b();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean f2 = io.a.a.a.a.b.i.f(r2);
        final int i2 = a2;
        final int i3 = availableProcessors;
        final long j2 = b2;
        final long j3 = blockCount;
        final boolean z2 = f2;
        final Map<p.a, String> h2 = this.m.h();
        long j4 = b2;
        AnonymousClass16 r15 = r0;
        final int h3 = io.a.a.a.a.b.i.h(r2);
        AnonymousClass16 r0 = new b() {
            public void a(f fVar) throws Exception {
                ao.a(fVar, i2, Build.MODEL, i3, j2, j3, z2, (Map<p.a, String>) h2, h3, Build.MANUFACTURER, Build.PRODUCT);
            }
        };
        a(str2, "SessionDevice", (b) r15);
        final long j5 = j4;
        a(str2, "SessionDevice.json", (d) new d() {
            public void a(FileOutputStream fileOutputStream) throws Exception {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() {
                    {
                        put("arch", Integer.valueOf(i2));
                        put("build_model", Build.MODEL);
                        put("available_processors", Integer.valueOf(i3));
                        put("total_ram", Long.valueOf(j5));
                        put("disk_space", Long.valueOf(j3));
                        put("is_emulator", Boolean.valueOf(z2));
                        put("ids", h2);
                        put(ServerProtocol.DIALOG_PARAM_STATE, Integer.valueOf(h3));
                        put("build_manufacturer", Build.MANUFACTURER);
                        put("build_product", Build.PRODUCT);
                    }
                }).toString().getBytes());
            }
        });
    }

    private void f(String str) throws Exception {
        final au g2 = g(str);
        a(str, "SessionUser", (b) new b() {
            public void a(f fVar) throws Exception {
                ao.a(fVar, g2.f6447b, g2.f6448c, g2.f6449d);
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.util.TreeMap} */
    /* JADX WARNING: type inference failed for: r6v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.crashlytics.android.c.f r25, java.util.Date r26, java.lang.Thread r27, java.lang.Throwable r28, java.lang.String r29, boolean r30) throws java.lang.Exception {
        /*
            r24 = this;
            r0 = r24
            com.crashlytics.android.c.as r5 = new com.crashlytics.android.c.as
            com.crashlytics.android.c.ar r1 = r0.v
            r2 = r28
            r5.<init>(r2, r1)
            com.crashlytics.android.c.k r1 = r0.j
            android.content.Context r1 = r1.r()
            long r2 = r26.getTime()
            r6 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r6
            java.lang.Float r16 = io.a.a.a.a.b.i.c((android.content.Context) r1)
            com.crashlytics.android.c.u r4 = r0.u
            boolean r4 = r4.a()
            int r17 = io.a.a.a.a.b.i.a((android.content.Context) r1, (boolean) r4)
            boolean r18 = io.a.a.a.a.b.i.d((android.content.Context) r1)
            android.content.res.Resources r4 = r1.getResources()
            android.content.res.Configuration r4 = r4.getConfiguration()
            int r13 = r4.orientation
            long r6 = io.a.a.a.a.b.i.b()
            long r8 = io.a.a.a.a.b.i.b((android.content.Context) r1)
            long r19 = r6 - r8
            java.io.File r4 = android.os.Environment.getDataDirectory()
            java.lang.String r4 = r4.getPath()
            long r21 = io.a.a.a.a.b.i.c((java.lang.String) r4)
            java.lang.String r4 = r1.getPackageName()
            android.app.ActivityManager$RunningAppProcessInfo r12 = io.a.a.a.a.b.i.a((java.lang.String) r4, (android.content.Context) r1)
            java.util.LinkedList r9 = new java.util.LinkedList
            r9.<init>()
            java.lang.StackTraceElement[] r7 = r5.f6444c
            com.crashlytics.android.c.a r4 = r0.p
            java.lang.String r15 = r4.f6398b
            io.a.a.a.a.b.p r4 = r0.m
            java.lang.String r14 = r4.c()
            r4 = 0
            if (r30 == 0) goto L_0x00a1
            java.util.Map r8 = java.lang.Thread.getAllStackTraces()
            int r10 = r8.size()
            java.lang.Thread[] r10 = new java.lang.Thread[r10]
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0078:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x009e
            java.lang.Object r11 = r8.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r23 = r11.getKey()
            java.lang.Thread r23 = (java.lang.Thread) r23
            r10[r4] = r23
            com.crashlytics.android.c.ar r6 = r0.v
            java.lang.Object r11 = r11.getValue()
            java.lang.StackTraceElement[] r11 = (java.lang.StackTraceElement[]) r11
            java.lang.StackTraceElement[] r6 = r6.a(r11)
            r9.add(r6)
            r6 = 1
            int r4 = r4 + r6
            goto L_0x0078
        L_0x009e:
            r6 = 1
            r8 = r10
            goto L_0x00a5
        L_0x00a1:
            r6 = 1
            java.lang.Thread[] r4 = new java.lang.Thread[r4]
            r8 = r4
        L_0x00a5:
            java.lang.String r4 = "com.crashlytics.CollectCustomKeys"
            boolean r1 = io.a.a.a.a.b.i.a((android.content.Context) r1, (java.lang.String) r4, (boolean) r6)
            if (r1 != 0) goto L_0x00b3
            java.util.TreeMap r1 = new java.util.TreeMap
            r1.<init>()
            goto L_0x00c8
        L_0x00b3:
            com.crashlytics.android.c.k r1 = r0.j
            java.util.Map r1 = r1.g()
            if (r1 == 0) goto L_0x00c8
            int r4 = r1.size()
            if (r4 <= r6) goto L_0x00c8
            java.util.TreeMap r4 = new java.util.TreeMap
            r4.<init>(r1)
            r10 = r4
            goto L_0x00c9
        L_0x00c8:
            r10 = r1
        L_0x00c9:
            com.crashlytics.android.c.y r11 = r0.r
            r1 = r25
            r4 = r29
            r6 = r27
            com.crashlytics.android.c.ao.a((com.crashlytics.android.c.f) r1, (long) r2, (java.lang.String) r4, (com.crashlytics.android.c.as) r5, (java.lang.Thread) r6, (java.lang.StackTraceElement[]) r7, (java.lang.Thread[]) r8, (java.util.List<java.lang.StackTraceElement[]>) r9, (java.util.Map<java.lang.String, java.lang.String>) r10, (com.crashlytics.android.c.y) r11, (android.app.ActivityManager.RunningAppProcessInfo) r12, (int) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.Float) r16, (int) r17, (boolean) r18, (long) r19, (long) r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.c.j.a(com.crashlytics.android.c.f, java.util.Date, java.lang.Thread, java.lang.Throwable, java.lang.String, boolean):void");
    }

    private void a(File file, String str, int i2) {
        l h2 = io.a.a.a.c.h();
        h2.a("CrashlyticsCore", "Collecting session parts for ID " + str);
        File[] a2 = a((FilenameFilter) new c(str + "SessionCrash"));
        boolean z2 = a2 != null && a2.length > 0;
        io.a.a.a.c.h().a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z2)}));
        File[] a3 = a((FilenameFilter) new c(str + "SessionEvent"));
        boolean z3 = a3 != null && a3.length > 0;
        io.a.a.a.c.h().a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z3)}));
        if (z2 || z3) {
            a(file, str, a(str, a3, i2), z2 ? a2[0] : null);
        } else {
            l h3 = io.a.a.a.c.h();
            h3.a("CrashlyticsCore", "No events present for session ID " + str);
        }
        l h4 = io.a.a.a.c.h();
        h4.a("CrashlyticsCore", "Removing session part files for ID " + str);
        a(str);
    }

    private void a(File file, String str, File[] fileArr, File file2) {
        e eVar;
        String str2 = str;
        File file3 = file2;
        boolean z2 = file3 != null;
        File h2 = z2 ? h() : i();
        if (!h2.exists()) {
            h2.mkdirs();
        }
        try {
            eVar = new e(h2, str2);
            try {
                f a2 = f.a((OutputStream) eVar);
                io.a.a.a.c.h().a("CrashlyticsCore", "Collecting SessionStart data for session ID " + str2);
                a(a2, file);
                a2.a(4, new Date().getTime() / 1000);
                a2.a(5, z2);
                a2.a(11, 1);
                a2.b(12, 3);
                a(a2, str2);
                a(a2, fileArr, str2);
                if (z2) {
                    a(a2, file3);
                }
                io.a.a.a.a.b.i.a((Flushable) a2, "Error flushing session file stream");
                io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close CLS file");
            } catch (Exception e2) {
                e = e2;
                try {
                    io.a.a.a.c.h().e("CrashlyticsCore", "Failed to write session file for session ID: " + str2, e);
                    io.a.a.a.a.b.i.a((Flushable) null, "Error flushing session file stream");
                    a(eVar);
                } catch (Throwable th) {
                    th = th;
                    io.a.a.a.a.b.i.a((Flushable) null, "Error flushing session file stream");
                    io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close CLS file");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            eVar = null;
            io.a.a.a.c.h().e("CrashlyticsCore", "Failed to write session file for session ID: " + str2, e);
            io.a.a.a.a.b.i.a((Flushable) null, "Error flushing session file stream");
            a(eVar);
        } catch (Throwable th2) {
            th = th2;
            eVar = null;
            io.a.a.a.a.b.i.a((Flushable) null, "Error flushing session file stream");
            io.a.a.a.a.b.i.a((Closeable) eVar, "Failed to close CLS file");
            throw th;
        }
    }

    private static void a(f fVar, File[] fileArr, String str) {
        Arrays.sort(fileArr, io.a.a.a.a.b.i.f33068a);
        for (File file : fileArr) {
            try {
                io.a.a.a.c.h().a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, file.getName()}));
                a(fVar, file);
            } catch (Exception e2) {
                io.a.a.a.c.h().e("CrashlyticsCore", "Error writting non-fatal to session.", e2);
            }
        }
    }

    private void a(f fVar, String str) throws IOException {
        for (String str2 : h) {
            File[] a2 = a((FilenameFilter) new c(str + str2 + ".cls"));
            if (a2.length == 0) {
                io.a.a.a.c.h().e("CrashlyticsCore", "Can't find " + str2 + " data for session ID " + str, (Throwable) null);
            } else {
                io.a.a.a.c.h().a("CrashlyticsCore", "Collecting " + str2 + " data for session ID " + str);
                a(fVar, a2[0]);
            }
        }
    }

    private static void a(f fVar, File file) throws IOException {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            io.a.a.a.c.h().e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), (Throwable) null);
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                a((InputStream) fileInputStream, fVar, (int) file.length());
                io.a.a.a.a.b.i.a((Closeable) fileInputStream, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                io.a.a.a.a.b.i.a((Closeable) fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            io.a.a.a.a.b.i.a((Closeable) fileInputStream, "Failed to close file input stream.");
            throw th;
        }
    }

    private static void a(InputStream inputStream, f fVar, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < bArr.length) {
            int read = inputStream.read(bArr, i3, bArr.length - i3);
            if (read < 0) {
                break;
            }
            i3 += read;
        }
        fVar.a(bArr);
    }

    private au g(String str) {
        if (f()) {
            return new au(this.j.h(), this.j.j(), this.j.i());
        }
        return new aa(g()).a(str);
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        q qVar = this.z;
        return qVar != null && qVar.a();
    }

    /* access modifiers changed from: package-private */
    public File g() {
        return this.o.a();
    }

    /* access modifiers changed from: package-private */
    public File h() {
        return new File(g(), "fatal-sessions");
    }

    /* access modifiers changed from: package-private */
    public File i() {
        return new File(g(), "nonfatal-sessions");
    }

    /* access modifiers changed from: package-private */
    public File j() {
        return new File(g(), "invalidClsFiles");
    }

    /* access modifiers changed from: private */
    public boolean a(t tVar) {
        if (tVar != null && tVar.f33265d.f33235a && !this.n.a()) {
            return true;
        }
        return false;
    }

    private s b(String str, String str2) {
        String b2 = io.a.a.a.a.b.i.b(this.j.r(), "com.crashlytics.ApiEndpoint");
        return new g(new t(this.j, b2, str, this.l), new ad(this.j, b2, str2, this.l));
    }

    /* access modifiers changed from: private */
    public void b(t tVar) {
        if (tVar == null) {
            io.a.a.a.c.h().d("CrashlyticsCore", "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context r2 = this.j.r();
        an anVar = new an(this.p.f6397a, b(tVar.f33262a.f33221d, tVar.f33262a.f33222e), this.s, this.t);
        for (File apVar : b()) {
            this.k.a((Runnable) new C0113j(r2, new ap(apVar, f6493g), anVar));
        }
    }

    private static void c(String str, String str2) {
        com.crashlytics.android.a.b bVar = (com.crashlytics.android.a.b) io.a.a.a.c.a(com.crashlytics.android.a.b.class);
        if (bVar == null) {
            io.a.a.a.c.h().a("CrashlyticsCore", "Answers is not available");
        } else {
            bVar.a(new j.b(str, str2));
        }
    }

    private static void d(String str, String str2) {
        com.crashlytics.android.a.b bVar = (com.crashlytics.android.a.b) io.a.a.a.c.a(com.crashlytics.android.a.b.class);
        if (bVar == null) {
            io.a.a.a.c.h().a("CrashlyticsCore", "Answers is not available");
        } else {
            bVar.a(new j.a(str, str2));
        }
    }

    private void a(long j2) {
        if (q()) {
            io.a.a.a.c.h().a("CrashlyticsCore", "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
        } else if (!this.y) {
        } else {
            if (this.x != null) {
                io.a.a.a.c.h().a("CrashlyticsCore", "Logging Crashlytics event to Firebase");
                Bundle bundle = new Bundle();
                bundle.putInt("_r", 1);
                bundle.putInt("fatal", 1);
                bundle.putLong("timestamp", j2);
                this.x.a("clx", "_ae", bundle);
                return;
            }
            io.a.a.a.c.h().a("CrashlyticsCore", "Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
        }
    }

    private boolean q() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private final class i implements an.b {
        private i() {
        }

        public boolean a() {
            return j.this.f();
        }
    }

    private final class h implements an.c {
        private h() {
        }

        public File[] a() {
            return j.this.b();
        }

        public File[] b() {
            return j.this.j().listFiles();
        }

        public File[] c() {
            return j.this.c();
        }
    }

    private static final class g implements an.d {

        /* renamed from: a  reason: collision with root package name */
        private final io.a.a.a.i f6562a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ah f6563b;

        /* renamed from: c  reason: collision with root package name */
        private final o f6564c;

        public g(io.a.a.a.i iVar, ah ahVar, o oVar) {
            this.f6562a = iVar;
            this.f6563b = ahVar;
            this.f6564c = oVar;
        }

        public boolean a() {
            Activity b2 = this.f6562a.s().b();
            if (b2 == null || b2.isFinishing()) {
                return true;
            }
            final h a2 = h.a(b2, this.f6564c, new h.a() {
                public void a(boolean z) {
                    g.this.f6563b.a(z);
                }
            });
            b2.runOnUiThread(new Runnable() {
                public void run() {
                    a2.a();
                }
            });
            io.a.a.a.c.h().a("CrashlyticsCore", "Waiting for user opt-in.");
            a2.b();
            return a2.c();
        }
    }

    /* renamed from: com.crashlytics.android.c.j$j  reason: collision with other inner class name */
    private static final class C0113j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Context f6570a;

        /* renamed from: b  reason: collision with root package name */
        private final am f6571b;

        /* renamed from: c  reason: collision with root package name */
        private final an f6572c;

        public C0113j(Context context, am amVar, an anVar) {
            this.f6570a = context;
            this.f6571b = amVar;
            this.f6572c = anVar;
        }

        public void run() {
            if (io.a.a.a.a.b.i.n(this.f6570a)) {
                io.a.a.a.c.h().a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                this.f6572c.a(this.f6571b);
            }
        }
    }

    private static final class f implements y.a {

        /* renamed from: a  reason: collision with root package name */
        private final io.a.a.a.a.f.a f6561a;

        public f(io.a.a.a.a.f.a aVar) {
            this.f6561a = aVar;
        }

        public File a() {
            File file = new File(this.f6561a.a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
