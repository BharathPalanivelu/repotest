package com.shopee.app.ui.webview;

import android.text.TextUtils;
import com.shopee.app.g.c;
import com.shopee.app.h.f;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import org.apache.commons.c.d;

public class i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final LinkedList<File> f7028a = new LinkedList<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final LinkedList<b> f7029b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    private static final HashSet<String> f7030c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private static final Hashtable<String, byte[]> f7031d = new Hashtable<>();

    /* renamed from: e  reason: collision with root package name */
    private static final LinkedList<String> f7032e = new LinkedList<>();

    /* renamed from: f  reason: collision with root package name */
    private static int f7033f = 0;

    static {
        new Thread() {
            /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(2:5|6)|7|8|9) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r2 = this;
                L_0x0000:
                    java.util.LinkedList r0 = com.shopee.app.ui.webview.i.f7028a
                    monitor-enter(r0)
                    java.util.LinkedList r1 = com.shopee.app.ui.webview.i.f7028a     // Catch:{ all -> 0x0025 }
                    boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0025 }
                    if (r1 == 0) goto L_0x0016
                    java.util.LinkedList r1 = com.shopee.app.ui.webview.i.f7028a     // Catch:{ Throwable -> 0x0016 }
                    r1.wait()     // Catch:{ Throwable -> 0x0016 }
                L_0x0016:
                    java.util.LinkedList r1 = com.shopee.app.ui.webview.i.f7028a     // Catch:{ all -> 0x0025 }
                    java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0025 }
                    java.io.File r1 = (java.io.File) r1     // Catch:{ all -> 0x0025 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                    com.shopee.app.ui.webview.i.e((java.io.File) r1)
                    goto L_0x0000
                L_0x0025:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                    goto L_0x0029
                L_0x0028:
                    throw r1
                L_0x0029:
                    goto L_0x0028
                */
                throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.i.AnonymousClass1.run():void");
            }
        }.start();
        new Thread() {
            /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(2:5|6)|7|8|9) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r3 = this;
                L_0x0000:
                    java.util.LinkedList r0 = com.shopee.app.ui.webview.i.f7029b
                    monitor-enter(r0)
                    java.util.LinkedList r1 = com.shopee.app.ui.webview.i.f7029b     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002a }
                    if (r1 == 0) goto L_0x0016
                    java.util.LinkedList r1 = com.shopee.app.ui.webview.i.f7029b     // Catch:{ Throwable -> 0x0016 }
                    r1.wait()     // Catch:{ Throwable -> 0x0016 }
                L_0x0016:
                    java.util.LinkedList r1 = com.shopee.app.ui.webview.i.f7029b     // Catch:{ all -> 0x002a }
                    java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x002a }
                    com.shopee.app.ui.webview.i$b r1 = (com.shopee.app.ui.webview.i.b) r1     // Catch:{ all -> 0x002a }
                    monitor-exit(r0)     // Catch:{ all -> 0x002a }
                    java.lang.String r0 = r1.f26048b
                    r2 = 0
                    byte[] r1 = r1.f26049c
                    com.shopee.app.ui.webview.i.c(r0, r2, r1)
                    goto L_0x0000
                L_0x002a:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x002a }
                    goto L_0x002e
                L_0x002d:
                    throw r1
                L_0x002e:
                    goto L_0x002d
                */
                throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.i.AnonymousClass2.run():void");
            }
        }.start();
    }

    public static void a(File file) {
        synchronized (f7028a) {
            if (!f7028a.contains(file)) {
                f7028a.addLast(file);
                f7028a.notifyAll();
            }
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f26047a;

        /* renamed from: b  reason: collision with root package name */
        public String f26048b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f26049c;

        public b(String str, byte[] bArr) {
            this.f26048b = str;
            this.f26047a = i.l(str);
            this.f26049c = bArr;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            return this.f26047a.equals(((b) obj).f26047a);
        }
    }

    public static void a(b bVar) {
        synchronized (f7029b) {
            while (f7029b.contains(bVar)) {
                f7029b.remove(bVar);
            }
            f7029b.addLast(bVar);
            f7029b.notifyAll();
        }
    }

    private static void c(File file) {
        j(file.getAbsolutePath());
    }

    private static void d(File file) {
        k(file.getAbsolutePath());
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0003 A[LOOP:0: B:2:0x0003->B:14:0x0003, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void j(java.lang.String r2) {
        /*
            java.util.HashSet<java.lang.String> r0 = f7030c
            monitor-enter(r0)
        L_0x0003:
            java.util.HashSet<java.lang.String> r1 = f7030c     // Catch:{ all -> 0x0018 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0011
            java.util.HashSet<java.lang.String> r1 = f7030c     // Catch:{ Throwable -> 0x0003 }
            r1.wait()     // Catch:{ Throwable -> 0x0003 }
            goto L_0x0003
        L_0x0011:
            java.util.HashSet<java.lang.String> r1 = f7030c     // Catch:{ all -> 0x0018 }
            r1.add(r2)     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            goto L_0x001c
        L_0x001b:
            throw r2
        L_0x001c:
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.i.j(java.lang.String):void");
    }

    private static void k(String str) {
        synchronized (f7030c) {
            if (f7030c.contains(str)) {
                f7030c.remove(str);
                f7030c.notifyAll();
            }
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26044a;

        /* renamed from: b  reason: collision with root package name */
        public String f26045b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f26046c;

        public a(String str, String str2, byte[] bArr) {
            this.f26044a = str;
            this.f26045b = str2;
            this.f26046c = bArr;
        }
    }

    public static String a(String str) {
        int indexOf = str.indexOf(35);
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }

    /* access modifiers changed from: private */
    public static String l(String str) {
        return c.a(a(str));
    }

    private static File m(String str) {
        return new File(f.a().f(l(str)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        r8 = m(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        if (r8.exists() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r8.length() <= 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.String r8) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.Hashtable<java.lang.String, byte[]> r0 = f7031d
            monitor-enter(r0)
            java.util.Hashtable<java.lang.String, byte[]> r2 = f7031d     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = l(r8)     // Catch:{ all -> 0x0031 }
            boolean r2 = r2.containsKey(r3)     // Catch:{ all -> 0x0031 }
            r3 = 1
            if (r2 == 0) goto L_0x001a
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return r3
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            java.io.File r8 = m(r8)
            boolean r0 = r8.exists()
            if (r0 == 0) goto L_0x0030
            long r4 = r8.length()
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0030
            r1 = 1
        L_0x0030:
            return r1
        L_0x0031:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.i.b(java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public static void e(File file) {
        c(file);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            int length = (int) file.length();
            randomAccessFile.setLength((long) (length + 1));
            randomAccessFile.setLength((long) length);
            randomAccessFile.close();
        } catch (Throwable unused) {
        }
        d(file);
    }

    private static byte[] f(File file) {
        if (!(file == null || !file.exists() || file.length() == 0)) {
            c(file);
            try {
                byte[] bArr = new byte[((int) file.length())];
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                d(file);
                return bArr;
            } catch (Throwable unused) {
                d(file);
            }
        }
        return null;
    }

    private static void a(File file, byte[] bArr) {
        g(file);
        c(file);
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.write(bArr);
            dataOutputStream.close();
            d(file);
        } catch (Throwable unused) {
            d(file);
            g(file);
        }
    }

    private static void g(File file) {
        int i = 10;
        while (file.exists()) {
            int i2 = i - 1;
            if (i > 0 && !file.delete()) {
                try {
                    Thread.sleep(50);
                } catch (Throwable unused) {
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    private static byte[] n(String str) {
        byte[] bArr;
        synchronized (f7031d) {
            bArr = f7031d.get(str);
        }
        if (bArr == null) {
            return null;
        }
        o(str);
        return bArr;
    }

    private static void d() {
        if (f7032e.size() >= 200 || f7033f >= 5120000) {
            LinkedList linkedList = new LinkedList();
            synchronized (f7032e) {
                while (f7032e.size() >= 200) {
                    linkedList.add(f7032e.removeLast());
                }
            }
            if (!linkedList.isEmpty()) {
                synchronized (f7031d) {
                    while (linkedList.size() > 0) {
                        a((String) linkedList.removeFirst(), true);
                    }
                }
            }
            synchronized (f7032e) {
                while (f7033f > 4864000 && !f7032e.isEmpty()) {
                    p(f7032e.removeLast());
                }
            }
        }
    }

    private static void a(String str, byte[] bArr, String str2) {
        if (bArr != null && !g(str2) && bArr.length <= 512000) {
            d();
            synchronized (f7031d) {
                f7031d.put(str, bArr);
                f7033f += bArr.length;
            }
            synchronized (f7032e) {
                if (!f7032e.contains(str)) {
                    f7032e.addFirst(str);
                } else {
                    o(str);
                }
            }
        }
    }

    private static void o(String str) {
        synchronized (f7032e) {
            f7032e.remove(str);
            f7032e.addFirst(str);
        }
    }

    private static void p(String str) {
        a(str, false);
    }

    private static void a(String str, boolean z) {
        synchronized (f7031d) {
            byte[] remove = f7031d.remove(str);
            if (remove != null) {
                f7033f -= remove.length;
            }
        }
        if (!z) {
            synchronized (f7032e) {
                f7032e.remove(str);
            }
        }
    }

    public static byte[] c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String l = l(str);
        byte[] n = n(l);
        if (n == null) {
            n = f(m(str));
            if (n == null) {
                return null;
            }
            a(l, n, str);
        }
        a(m(str));
        return n;
    }

    public static String d(String str) {
        String f2 = f(str);
        if (".js".equals(f2)) {
            return "application/javascript";
        }
        if (".css".equals(f2)) {
            return "text/css";
        }
        if (".json".equals(f2)) {
            return HttpConstants.ContentType.JSON;
        }
        if (".png".equals(f2)) {
            return "image/png";
        }
        if (".jpg".equals(f2) || ".jpeg".equals(f2)) {
            return "image/jpeg";
        }
        return ".gif".equals(f2) ? "image/gif" : "";
    }

    public static String e(String str) {
        if (d.a(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf == str.length() - 1) {
            return "";
        }
        String substring = str.substring(lastIndexOf + 1);
        int indexOf = substring.indexOf(63);
        return indexOf > 0 ? substring.substring(0, indexOf) : substring;
    }

    public static String f(String str) {
        String e2 = e(str);
        if (d.a(e2)) {
            return "";
        }
        int lastIndexOf = e2.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            return e2.substring(lastIndexOf);
        }
        return "";
    }

    public static boolean a(String str, String str2) {
        if (str2 == null) {
            str2 = f(str);
        }
        if (!d.a(str2) && ".js|.css|.json".contains(str2)) {
            if (str.contains("?")) {
                return true;
            }
            String[] split = e(str).split("\\.");
            if (split.length < 3) {
                return false;
            }
            String str3 = split[split.length - 2];
            if (str3.length() < 12 || str3.length() > 32 || !str3.matches("[0-9a-fA-F]+")) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean g(String str) {
        return str.startsWith("http://cf.shopee") || str.startsWith("https://cf.shopee") || str.startsWith("http://f.shopee") || str.startsWith("http://file.shopee") || str.startsWith("https://f.shopee") || str.startsWith("https://file.shopee");
    }

    public static void a(String str, String str2, byte[] bArr) {
        a(new b(str, bArr));
    }

    /* access modifiers changed from: private */
    public static void c(String str, String str2, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            a(m(str), bArr);
            a(l(str), bArr, str);
        }
    }

    public static void h(String str) {
        if (!TextUtils.isEmpty(str)) {
            p(l(str));
            g(m(str));
        }
    }

    public static void a() {
        com.shopee.app.h.a.b.c().a(new File(f.a().g()));
        synchronized (f7032e) {
            f7032e.clear();
        }
        synchronized (f7031d) {
            f7031d.clear();
            f7033f = 0;
        }
    }
}
