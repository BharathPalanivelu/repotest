package com.shopee.feeds.feedlibrary.data.d;

import android.content.Context;
import android.os.Process;
import com.facebook.appevents.AppEventsConstants;
import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, a> f27721a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private C0426a f27722b;

    /* renamed from: com.shopee.feeds.feedlibrary.data.d.a$1  reason: invalid class name */
    class AnonymousClass1 {
    }

    public static a a(Context context) {
        return a(context, "ACache");
    }

    public static a a(Context context, String str) {
        File cacheDir = context.getCacheDir();
        return a(new File(cacheDir, "ACache_" + str), 50000000, Integer.MAX_VALUE);
    }

    public static a a(File file, long j, int i) {
        Map<String, a> map = f27721a;
        a aVar = map.get(file.getAbsoluteFile() + a());
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(file, j, i);
        Map<String, a> map2 = f27721a;
        map2.put(file.getAbsolutePath() + a(), aVar2);
        return aVar2;
    }

    private static String a() {
        return "_" + Process.myPid();
    }

    private a(File file, long j, int i) {
        if (file.exists() || file.mkdirs()) {
            this.f27722b = new C0426a(this, file, j, i, (AnonymousClass1) null);
            return;
        }
        throw new RuntimeException("can't make dirs in " + file.getAbsolutePath());
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0026 A[SYNTHETIC, Splitter:B:17:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0039 A[SYNTHETIC, Splitter:B:24:0x0039] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r3, byte[] r4) {
        /*
            r2 = this;
            com.shopee.feeds.feedlibrary.data.d.a$a r0 = r2.f27722b
            java.io.File r3 = r0.b((java.lang.String) r3)
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0020 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0020 }
            r1.write(r4)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r1.flush()     // Catch:{ IOException -> 0x0016 }
            r1.close()     // Catch:{ IOException -> 0x0016 }
            goto L_0x0031
        L_0x0016:
            r4 = move-exception
            goto L_0x002e
        L_0x0018:
            r4 = move-exception
            r0 = r1
            goto L_0x0037
        L_0x001b:
            r4 = move-exception
            r0 = r1
            goto L_0x0021
        L_0x001e:
            r4 = move-exception
            goto L_0x0037
        L_0x0020:
            r4 = move-exception
        L_0x0021:
            r4.printStackTrace()     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0031
            r0.flush()     // Catch:{ IOException -> 0x002d }
            r0.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r4 = move-exception
        L_0x002e:
            r4.printStackTrace()
        L_0x0031:
            com.shopee.feeds.feedlibrary.data.d.a$a r4 = r2.f27722b
            r4.a((java.io.File) r3)
            return
        L_0x0037:
            if (r0 == 0) goto L_0x0044
            r0.flush()     // Catch:{ IOException -> 0x0040 }
            r0.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0044:
            com.shopee.feeds.feedlibrary.data.d.a$a r0 = r2.f27722b
            r0.a((java.io.File) r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.data.d.a.a(java.lang.String, byte[]):void");
    }

    public void a(String str, byte[] bArr, int i) {
        a(str, b.b(i, bArr));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049 A[SYNTHETIC, Splitter:B:28:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0056 A[SYNTHETIC, Splitter:B:36:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            com.shopee.feeds.feedlibrary.data.d.a$a r1 = r5.f27722b     // Catch:{ Exception -> 0x0042, all -> 0x0040 }
            java.io.File r1 = r1.a((java.lang.String) r6)     // Catch:{ Exception -> 0x0042, all -> 0x0040 }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x0042, all -> 0x0040 }
            if (r2 != 0) goto L_0x000e
            return r0
        L_0x000e:
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0042, all -> 0x0040 }
            java.lang.String r3 = "r"
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x0042, all -> 0x0040 }
            long r3 = r2.length()     // Catch:{ Exception -> 0x003e }
            int r1 = (int) r3     // Catch:{ Exception -> 0x003e }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x003e }
            r2.read(r1)     // Catch:{ Exception -> 0x003e }
            boolean r3 = com.shopee.feeds.feedlibrary.data.d.a.b.c(r1)     // Catch:{ Exception -> 0x003e }
            if (r3 != 0) goto L_0x0032
            byte[] r6 = com.shopee.feeds.feedlibrary.data.d.a.b.d(r1)     // Catch:{ Exception -> 0x003e }
            r2.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0031:
            return r6
        L_0x0032:
            r2.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003a:
            r5.c(r6)
            return r0
        L_0x003e:
            r6 = move-exception
            goto L_0x0044
        L_0x0040:
            r6 = move-exception
            goto L_0x0054
        L_0x0042:
            r6 = move-exception
            r2 = r0
        L_0x0044:
            r6.printStackTrace()     // Catch:{ all -> 0x0052 }
            if (r2 == 0) goto L_0x0051
            r2.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0051:
            return r0
        L_0x0052:
            r6 = move-exception
            r0 = r2
        L_0x0054:
            if (r0 == 0) goto L_0x005e
            r0.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x005e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.data.d.a.a(java.lang.String):byte[]");
    }

    public void a(String str, Serializable serializable) {
        a(str, serializable, -1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0031 A[SYNTHETIC, Splitter:B:21:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003c A[SYNTHETIC, Splitter:B:26:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r4, java.io.Serializable r5, int r6) {
        /*
            r3 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x002b }
            r1.<init>()     // Catch:{ Exception -> 0x002b }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x002b }
            r2.<init>(r1)     // Catch:{ Exception -> 0x002b }
            r2.writeObject(r5)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            byte[] r5 = r1.toByteArray()     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            r0 = -1
            if (r6 == r0) goto L_0x001c
            r3.a((java.lang.String) r4, (byte[]) r5, (int) r6)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            goto L_0x001f
        L_0x001c:
            r3.a((java.lang.String) r4, (byte[]) r5)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
        L_0x001f:
            r2.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0023:
            r4 = move-exception
            r0 = r2
            goto L_0x003a
        L_0x0026:
            r4 = move-exception
            r0 = r2
            goto L_0x002c
        L_0x0029:
            r4 = move-exception
            goto L_0x003a
        L_0x002b:
            r4 = move-exception
        L_0x002c:
            r4.printStackTrace()     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0039
            r0.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0039:
            return
        L_0x003a:
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0044:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.data.d.a.a(java.lang.String, java.io.Serializable, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0038 A[SYNTHETIC, Splitter:B:28:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0042 A[SYNTHETIC, Splitter:B:33:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0051 A[SYNTHETIC, Splitter:B:41:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x005b A[SYNTHETIC, Splitter:B:46:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(java.lang.String r5) {
        /*
            r4 = this;
            byte[] r5 = r4.a((java.lang.String) r5)
            r0 = 0
            if (r5 == 0) goto L_0x0064
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
            java.lang.Object r0 = r5.readObject()     // Catch:{ Exception -> 0x0026 }
            r1.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            r1 = move-exception
            r1.printStackTrace()
        L_0x001d:
            r5.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0025:
            return r0
        L_0x0026:
            r2 = move-exception
            goto L_0x0033
        L_0x0028:
            r5 = move-exception
            goto L_0x004f
        L_0x002a:
            r2 = move-exception
            r5 = r0
            goto L_0x0033
        L_0x002d:
            r5 = move-exception
            r1 = r0
            goto L_0x004f
        L_0x0030:
            r2 = move-exception
            r5 = r0
            r1 = r5
        L_0x0033:
            r2.printStackTrace()     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0040:
            if (r5 == 0) goto L_0x004a
            r5.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004a:
            return r0
        L_0x004b:
            r0 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
        L_0x004f:
            if (r1 == 0) goto L_0x0059
            r1.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0059:
            if (r0 == 0) goto L_0x0063
            r0.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0063:
            throw r5
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.data.d.a.b(java.lang.String):java.lang.Object");
    }

    public boolean c(String str) {
        return this.f27722b.c(str);
    }

    /* renamed from: com.shopee.feeds.feedlibrary.data.d.a$a  reason: collision with other inner class name */
    public class C0426a {

        /* renamed from: a  reason: collision with root package name */
        protected File f27723a;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f27725c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f27726d;

        /* renamed from: e  reason: collision with root package name */
        private final long f27727e;

        /* renamed from: f  reason: collision with root package name */
        private final int f27728f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final Map<File, Long> f27729g;

        /* synthetic */ C0426a(a aVar, File file, long j, int i, AnonymousClass1 r6) {
            this(file, j, i);
        }

        private C0426a(File file, long j, int i) {
            this.f27729g = Collections.synchronizedMap(new HashMap());
            this.f27723a = file;
            this.f27727e = j;
            this.f27728f = i;
            this.f27725c = new AtomicLong();
            this.f27726d = new AtomicInteger();
            a();
        }

        private void a() {
            new Thread(new Runnable() {
                public void run() {
                    File[] listFiles = C0426a.this.f27723a.listFiles();
                    if (listFiles != null) {
                        int i = 0;
                        int i2 = 0;
                        for (File file : listFiles) {
                            i = (int) (((long) i) + C0426a.this.b(file));
                            i2++;
                            C0426a.this.f27729g.put(file, Long.valueOf(file.lastModified()));
                        }
                        C0426a.this.f27725c.set((long) i);
                        C0426a.this.f27726d.set(i2);
                    }
                }
            }).start();
        }

        /* access modifiers changed from: private */
        public void a(File file) {
            int i = this.f27726d.get();
            while (i + 1 > this.f27728f) {
                this.f27725c.addAndGet(-b());
                i = this.f27726d.addAndGet(-1);
            }
            this.f27726d.addAndGet(1);
            long b2 = b(file);
            long j = this.f27725c.get();
            while (j + b2 > this.f27727e) {
                j = this.f27725c.addAndGet(-b());
            }
            this.f27725c.addAndGet(b2);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.f27729g.put(file, valueOf);
        }

        /* access modifiers changed from: private */
        public File a(String str) {
            File b2 = b(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            b2.setLastModified(valueOf.longValue());
            this.f27729g.put(b2, valueOf);
            return b2;
        }

        /* access modifiers changed from: private */
        public File b(String str) {
            if (!this.f27723a.exists()) {
                this.f27723a.mkdirs();
            }
            File file = this.f27723a;
            return new File(file, str.hashCode() + "");
        }

        /* access modifiers changed from: private */
        public boolean c(String str) {
            return a(str).delete();
        }

        private long b() {
            File file;
            if (this.f27729g.isEmpty()) {
                return 0;
            }
            Set<Map.Entry<File, Long>> entrySet = this.f27729g.entrySet();
            synchronized (this.f27729g) {
                file = null;
                Long l = null;
                for (Map.Entry next : entrySet) {
                    if (file == null) {
                        file = (File) next.getKey();
                        l = (Long) next.getValue();
                    } else {
                        Long l2 = (Long) next.getValue();
                        if (l2.longValue() < l.longValue()) {
                            file = (File) next.getKey();
                            l = l2;
                        }
                    }
                }
            }
            long b2 = b(file);
            if (file.delete()) {
                this.f27729g.remove(file);
            }
            return b2;
        }

        /* access modifiers changed from: private */
        public long b(File file) {
            return file.length();
        }
    }

    private static class b {
        /* access modifiers changed from: private */
        public static boolean c(byte[] bArr) {
            String[] f2 = f(bArr);
            if (f2 != null && f2.length == 2) {
                String str = f2[0];
                while (str.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    str = str.substring(1, str.length());
                }
                if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(f2[1]).longValue() * 1000)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public static byte[] b(int i, byte[] bArr) {
            byte[] bytes = a(i).getBytes();
            byte[] bArr2 = new byte[(bytes.length + bArr.length)];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }

        /* access modifiers changed from: private */
        public static byte[] d(byte[] bArr) {
            return e(bArr) ? a(bArr, a(bArr, ' ') + 1, bArr.length) : bArr;
        }

        private static boolean e(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && a(bArr, ' ') > 14;
        }

        private static String[] f(byte[] bArr) {
            if (!e(bArr)) {
                return null;
            }
            return new String[]{new String(a(bArr, 0, 13)), new String(a(bArr, 14, a(bArr, ' ')))};
        }

        private static int a(byte[] bArr, char c2) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] == c2) {
                    return i;
                }
            }
            return -1;
        }

        private static byte[] a(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
                return bArr2;
            }
            throw new IllegalArgumentException(i + " > " + i2);
        }

        private static String a(int i) {
            String str = System.currentTimeMillis() + "";
            while (str.length() < 13) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO + str;
            }
            return str + "-" + i + ' ';
        }
    }
}
