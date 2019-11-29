package com.android.b.a;

import android.os.SystemClock;
import com.android.b.b;
import com.android.b.t;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class c implements com.android.b.b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f4566a;

    /* renamed from: b  reason: collision with root package name */
    private long f4567b;

    /* renamed from: c  reason: collision with root package name */
    private final File f4568c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4569d;

    public c(File file, int i) {
        this.f4566a = new LinkedHashMap(16, 0.75f, true);
        this.f4567b = 0;
        this.f4568c = file;
        this.f4569d = i;
    }

    public c(File file) {
        this(file, 5242880);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005b A[SYNTHETIC, Splitter:B:29:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0066 A[SYNTHETIC, Splitter:B:38:0x0066] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.android.b.b.a a(java.lang.String r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Map<java.lang.String, com.android.b.a.c$a> r0 = r8.f4566a     // Catch:{ all -> 0x006d }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x006d }
            com.android.b.a.c$a r0 = (com.android.b.a.c.a) r0     // Catch:{ all -> 0x006d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r8)
            return r1
        L_0x000e:
            java.io.File r2 = r8.c((java.lang.String) r9)     // Catch:{ all -> 0x006d }
            com.android.b.a.c$b r3 = new com.android.b.a.c$b     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r4.<init>(r2)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r3.<init>(r4)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            com.android.b.a.c.a.a((java.io.InputStream) r3)     // Catch:{ IOException -> 0x0039 }
            long r4 = r2.length()     // Catch:{ IOException -> 0x0039 }
            int r6 = r3.f4577a     // Catch:{ IOException -> 0x0039 }
            long r6 = (long) r6     // Catch:{ IOException -> 0x0039 }
            long r4 = r4 - r6
            int r5 = (int) r4     // Catch:{ IOException -> 0x0039 }
            byte[] r4 = a((java.io.InputStream) r3, (int) r5)     // Catch:{ IOException -> 0x0039 }
            com.android.b.b$a r9 = r0.a((byte[]) r4)     // Catch:{ IOException -> 0x0039 }
            r3.close()     // Catch:{ IOException -> 0x0037 }
            monitor-exit(r8)
            return r9
        L_0x0037:
            monitor-exit(r8)
            return r1
        L_0x0039:
            r0 = move-exception
            goto L_0x0040
        L_0x003b:
            r9 = move-exception
            r3 = r1
            goto L_0x0064
        L_0x003e:
            r0 = move-exception
            r3 = r1
        L_0x0040:
            java.lang.String r4 = "%s: %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0063 }
            r6 = 0
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0063 }
            r5[r6] = r2     // Catch:{ all -> 0x0063 }
            r2 = 1
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0063 }
            r5[r2] = r0     // Catch:{ all -> 0x0063 }
            com.android.b.t.b(r4, r5)     // Catch:{ all -> 0x0063 }
            r8.b((java.lang.String) r9)     // Catch:{ all -> 0x0063 }
            if (r3 == 0) goto L_0x0061
            r3.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0061
        L_0x005f:
            monitor-exit(r8)
            return r1
        L_0x0061:
            monitor-exit(r8)
            return r1
        L_0x0063:
            r9 = move-exception
        L_0x0064:
            if (r3 == 0) goto L_0x006c
            r3.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006c
        L_0x006a:
            monitor-exit(r8)
            return r1
        L_0x006c:
            throw r9     // Catch:{ all -> 0x006d }
        L_0x006d:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.b.a.c.a(java.lang.String):com.android.b.b$a");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:25|(2:35|36)|37|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x005f */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0056 A[SYNTHETIC, Splitter:B:32:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0062 A[SYNTHETIC, Splitter:B:40:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0065 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.io.File r0 = r8.f4568c     // Catch:{ all -> 0x006a }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x006a }
            r1 = 0
            if (r0 != 0) goto L_0x0024
            java.io.File r0 = r8.f4568c     // Catch:{ all -> 0x006a }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "Unable to create cache dir %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x006a }
            java.io.File r3 = r8.f4568c     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x006a }
            r2[r1] = r3     // Catch:{ all -> 0x006a }
            com.android.b.t.c(r0, r2)     // Catch:{ all -> 0x006a }
        L_0x0022:
            monitor-exit(r8)
            return
        L_0x0024:
            java.io.File r0 = r8.f4568c     // Catch:{ all -> 0x006a }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r8)
            return
        L_0x002e:
            int r2 = r0.length     // Catch:{ all -> 0x006a }
        L_0x002f:
            if (r1 >= r2) goto L_0x0068
            r3 = r0[r1]     // Catch:{ all -> 0x006a }
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0053 }
            r5.<init>(r3)     // Catch:{ IOException -> 0x0053 }
            com.android.b.a.c$a r4 = com.android.b.a.c.a.a((java.io.InputStream) r5)     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            long r6 = r3.length()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            r4.f4570a = r6     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            java.lang.String r6 = r4.f4571b     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            r8.a((java.lang.String) r6, (com.android.b.a.c.a) r4)     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            r5.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0065
        L_0x004c:
            r0 = move-exception
            goto L_0x005a
        L_0x004e:
            r4 = r5
            goto L_0x0054
        L_0x0050:
            r0 = move-exception
            r5 = r4
            goto L_0x005a
        L_0x0053:
        L_0x0054:
            if (r3 == 0) goto L_0x0060
            r3.delete()     // Catch:{ all -> 0x0050 }
            goto L_0x0060
        L_0x005a:
            if (r5 == 0) goto L_0x005f
            r5.close()     // Catch:{ IOException -> 0x005f }
        L_0x005f:
            throw r0     // Catch:{ all -> 0x006a }
        L_0x0060:
            if (r4 == 0) goto L_0x0065
            r4.close()     // Catch:{ IOException -> 0x0065 }
        L_0x0065:
            int r1 = r1 + 1
            goto L_0x002f
        L_0x0068:
            monitor-exit(r8)
            return
        L_0x006a:
            r0 = move-exception
            monitor-exit(r8)
            goto L_0x006e
        L_0x006d:
            throw r0
        L_0x006e:
            goto L_0x006d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.b.a.c.a():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|(1:10)|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        com.android.b.t.b("Could not clean up file %s", r0.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0.delete() == false) goto L_0x002b;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r4, com.android.b.b.a r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            byte[] r0 = r5.f4582a     // Catch:{ all -> 0x003c }
            int r0 = r0.length     // Catch:{ all -> 0x003c }
            r3.a((int) r0)     // Catch:{ all -> 0x003c }
            java.io.File r0 = r3.c((java.lang.String) r4)     // Catch:{ all -> 0x003c }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0025 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0025 }
            com.android.b.a.c$a r2 = new com.android.b.a.c$a     // Catch:{ IOException -> 0x0025 }
            r2.<init>(r4, r5)     // Catch:{ IOException -> 0x0025 }
            r2.a((java.io.OutputStream) r1)     // Catch:{ IOException -> 0x0025 }
            byte[] r5 = r5.f4582a     // Catch:{ IOException -> 0x0025 }
            r1.write(r5)     // Catch:{ IOException -> 0x0025 }
            r1.close()     // Catch:{ IOException -> 0x0025 }
            r3.a((java.lang.String) r4, (com.android.b.a.c.a) r2)     // Catch:{ IOException -> 0x0025 }
            monitor-exit(r3)
            return
        L_0x0025:
            boolean r4 = r0.delete()     // Catch:{ all -> 0x003c }
            if (r4 != 0) goto L_0x003a
            java.lang.String r4 = "Could not clean up file %s"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x003c }
            r1 = 0
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x003c }
            r5[r1] = r0     // Catch:{ all -> 0x003c }
            com.android.b.t.b(r4, r5)     // Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r3)
            return
        L_0x003c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.b.a.c.a(java.lang.String, com.android.b.b$a):void");
    }

    public synchronized void b(String str) {
        boolean delete = c(str).delete();
        e(str);
        if (!delete) {
            t.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
        }
    }

    private String d(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    public File c(String str) {
        return new File(this.f4568c, d(str));
    }

    private void a(int i) {
        long j;
        long j2 = (long) i;
        if (this.f4567b + j2 >= ((long) this.f4569d)) {
            if (t.f4631b) {
                t.a("Pruning old cache entries.", new Object[0]);
            }
            long j3 = this.f4567b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, a>> it = this.f4566a.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                a aVar = (a) it.next().getValue();
                if (c(aVar.f4571b).delete()) {
                    j = j2;
                    this.f4567b -= aVar.f4570a;
                } else {
                    j = j2;
                    t.b("Could not delete cache entry for key=%s, filename=%s", aVar.f4571b, d(aVar.f4571b));
                }
                it.remove();
                i2++;
                if (((float) (this.f4567b + j)) < ((float) this.f4569d) * 0.9f) {
                    break;
                }
                j2 = j;
            }
            if (t.f4631b) {
                t.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f4567b - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    private void a(String str, a aVar) {
        if (!this.f4566a.containsKey(str)) {
            this.f4567b += aVar.f4570a;
        } else {
            this.f4567b += aVar.f4570a - this.f4566a.get(str).f4570a;
        }
        this.f4566a.put(str, aVar);
    }

    private void e(String str) {
        a aVar = this.f4566a.get(str);
        if (aVar != null) {
            this.f4567b -= aVar.f4570a;
            this.f4566a.remove(str);
        }
    }

    private static byte[] a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f4570a;

        /* renamed from: b  reason: collision with root package name */
        public String f4571b;

        /* renamed from: c  reason: collision with root package name */
        public String f4572c;

        /* renamed from: d  reason: collision with root package name */
        public long f4573d;

        /* renamed from: e  reason: collision with root package name */
        public long f4574e;

        /* renamed from: f  reason: collision with root package name */
        public long f4575f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, String> f4576g;

        private a() {
        }

        public a(String str, b.a aVar) {
            this.f4571b = str;
            this.f4570a = (long) aVar.f4582a.length;
            this.f4572c = aVar.f4583b;
            this.f4573d = aVar.f4584c;
            this.f4574e = aVar.f4585d;
            this.f4575f = aVar.f4586e;
            this.f4576g = aVar.f4587f;
        }

        public static a a(InputStream inputStream) throws IOException {
            a aVar = new a();
            if (c.a(inputStream) == 538051844) {
                aVar.f4571b = c.c(inputStream);
                aVar.f4572c = c.c(inputStream);
                if (aVar.f4572c.equals("")) {
                    aVar.f4572c = null;
                }
                aVar.f4573d = c.b(inputStream);
                aVar.f4574e = c.b(inputStream);
                aVar.f4575f = c.b(inputStream);
                aVar.f4576g = c.d(inputStream);
                return aVar;
            }
            throw new IOException();
        }

        public b.a a(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f4582a = bArr;
            aVar.f4583b = this.f4572c;
            aVar.f4584c = this.f4573d;
            aVar.f4585d = this.f4574e;
            aVar.f4586e = this.f4575f;
            aVar.f4587f = this.f4576g;
            return aVar;
        }

        public boolean a(OutputStream outputStream) {
            try {
                c.a(outputStream, 538051844);
                c.a(outputStream, this.f4571b);
                c.a(outputStream, this.f4572c == null ? "" : this.f4572c);
                c.a(outputStream, this.f4573d);
                c.a(outputStream, this.f4574e);
                c.a(outputStream, this.f4575f);
                c.a(this.f4576g, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e2) {
                t.b("%s", e2.toString());
                return false;
            }
        }
    }

    private static class b extends FilterInputStream {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f4577a;

        private b(InputStream inputStream) {
            super(inputStream);
            this.f4577a = 0;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f4577a++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f4577a += read;
            }
            return read;
        }
    }

    private static int e(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int a(InputStream inputStream) throws IOException {
        return (e(inputStream) << 24) | (e(inputStream) << 0) | 0 | (e(inputStream) << 8) | (e(inputStream) << 16);
    }

    static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static long b(InputStream inputStream) throws IOException {
        return ((((long) e(inputStream)) & 255) << 0) | 0 | ((((long) e(inputStream)) & 255) << 8) | ((((long) e(inputStream)) & 255) << 16) | ((((long) e(inputStream)) & 255) << 24) | ((((long) e(inputStream)) & 255) << 32) | ((((long) e(inputStream)) & 255) << 40) | ((((long) e(inputStream)) & 255) << 48) | ((255 & ((long) e(inputStream))) << 56);
    }

    static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String c(InputStream inputStream) throws IOException {
        return new String(a(inputStream, (int) b(inputStream)), "UTF-8");
    }

    static void a(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            a(outputStream, map.size());
            for (Map.Entry next : map.entrySet()) {
                a(outputStream, (String) next.getKey());
                a(outputStream, (String) next.getValue());
            }
            return;
        }
        a(outputStream, 0);
    }

    static Map<String, String> d(InputStream inputStream) throws IOException {
        int a2 = a(inputStream);
        Map<String, String> emptyMap = a2 == 0 ? Collections.emptyMap() : new HashMap<>(a2);
        for (int i = 0; i < a2; i++) {
            emptyMap.put(c(inputStream).intern(), c(inputStream).intern());
        }
        return emptyMap;
    }
}
