package androidx.core.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.b.e;
import androidx.b.g;
import androidx.core.e.c;
import androidx.core.graphics.d;
import androidx.core.graphics.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    static final e<String, Typeface> f1665a = new e<>(16);

    /* renamed from: b  reason: collision with root package name */
    static final Object f1666b = new Object();

    /* renamed from: c  reason: collision with root package name */
    static final g<String, ArrayList<c.a<c>>> f1667c = new g<>();

    /* renamed from: d  reason: collision with root package name */
    private static final c f1668d = new c("fonts", 10, 10000);

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator<byte[]> f1669e = new Comparator<byte[]>() {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(byte[] r5, byte[] r6) {
            /*
                r4 = this;
                int r0 = r5.length
                int r1 = r6.length
                if (r0 == r1) goto L_0x0008
                int r5 = r5.length
                int r6 = r6.length
            L_0x0006:
                int r5 = r5 - r6
                return r5
            L_0x0008:
                r0 = 0
                r1 = 0
            L_0x000a:
                int r2 = r5.length
                if (r1 >= r2) goto L_0x001b
                byte r2 = r5[r1]
                byte r3 = r6[r1]
                if (r2 == r3) goto L_0x0018
                byte r5 = r5[r1]
                byte r6 = r6[r1]
                goto L_0x0006
            L_0x0018:
                int r1 = r1 + 1
                goto L_0x000a
            L_0x001b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.e.b.AnonymousClass4.compare(byte[], byte[]):int");
        }
    };

    static c a(Context context, a aVar, int i) {
        try {
            a a2 = a(context, (CancellationSignal) null, aVar);
            int i2 = -3;
            if (a2.a() == 0) {
                Typeface a3 = d.a(context, (CancellationSignal) null, a2.b(), i);
                if (a3 != null) {
                    i2 = 0;
                }
                return new c(a3, i2);
            }
            if (a2.a() == 1) {
                i2 = -2;
            }
            return new c((Typeface) null, i2);
        } catch (PackageManager.NameNotFoundException unused) {
            return new c((Typeface) null, -1);
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f1684a;

        /* renamed from: b  reason: collision with root package name */
        final int f1685b;

        c(Typeface typeface, int i) {
            this.f1684a = typeface;
            this.f1685b = i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0074, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0085, code lost:
        f1668d.a(r1, new androidx.core.e.b.AnonymousClass3());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface a(final android.content.Context r2, final androidx.core.e.a r3, final androidx.core.content.a.f.a r4, final android.os.Handler r5, boolean r6, int r7, final int r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r3.f()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            androidx.b.e<java.lang.String, android.graphics.Typeface> r1 = f1665a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0028
            if (r4 == 0) goto L_0x0027
            r4.a((android.graphics.Typeface) r1)
        L_0x0027:
            return r1
        L_0x0028:
            if (r6 == 0) goto L_0x0045
            r1 = -1
            if (r7 != r1) goto L_0x0045
            androidx.core.e.b$c r2 = a((android.content.Context) r2, (androidx.core.e.a) r3, (int) r8)
            if (r4 == 0) goto L_0x0042
            int r3 = r2.f1685b
            if (r3 != 0) goto L_0x003d
            android.graphics.Typeface r3 = r2.f1684a
            r4.a((android.graphics.Typeface) r3, (android.os.Handler) r5)
            goto L_0x0042
        L_0x003d:
            int r3 = r2.f1685b
            r4.a((int) r3, (android.os.Handler) r5)
        L_0x0042:
            android.graphics.Typeface r2 = r2.f1684a
            return r2
        L_0x0045:
            androidx.core.e.b$1 r1 = new androidx.core.e.b$1
            r1.<init>(r2, r3, r8, r0)
            r2 = 0
            if (r6 == 0) goto L_0x0058
            androidx.core.e.c r3 = f1668d     // Catch:{ InterruptedException -> 0x0057 }
            java.lang.Object r3 = r3.a(r1, (int) r7)     // Catch:{ InterruptedException -> 0x0057 }
            androidx.core.e.b$c r3 = (androidx.core.e.b.c) r3     // Catch:{ InterruptedException -> 0x0057 }
            android.graphics.Typeface r2 = r3.f1684a     // Catch:{ InterruptedException -> 0x0057 }
        L_0x0057:
            return r2
        L_0x0058:
            if (r4 != 0) goto L_0x005c
            r3 = r2
            goto L_0x0061
        L_0x005c:
            androidx.core.e.b$2 r3 = new androidx.core.e.b$2
            r3.<init>(r4, r5)
        L_0x0061:
            java.lang.Object r4 = f1666b
            monitor-enter(r4)
            androidx.b.g<java.lang.String, java.util.ArrayList<androidx.core.e.c$a<androidx.core.e.b$c>>> r5 = f1667c     // Catch:{ all -> 0x0090 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x0090 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x0090 }
            if (r5 == 0) goto L_0x0075
            if (r3 == 0) goto L_0x0073
            r5.add(r3)     // Catch:{ all -> 0x0090 }
        L_0x0073:
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            return r2
        L_0x0075:
            if (r3 == 0) goto L_0x0084
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0090 }
            r5.<init>()     // Catch:{ all -> 0x0090 }
            r5.add(r3)     // Catch:{ all -> 0x0090 }
            androidx.b.g<java.lang.String, java.util.ArrayList<androidx.core.e.c$a<androidx.core.e.b$c>>> r3 = f1667c     // Catch:{ all -> 0x0090 }
            r3.put(r0, r5)     // Catch:{ all -> 0x0090 }
        L_0x0084:
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            androidx.core.e.c r3 = f1668d
            androidx.core.e.b$3 r4 = new androidx.core.e.b$3
            r4.<init>(r0)
            r3.a(r1, r4)
            return r2
        L_0x0090:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.e.b.a(android.content.Context, androidx.core.e.a, androidx.core.content.a.f$a, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    /* renamed from: androidx.core.e.b$b  reason: collision with other inner class name */
    public static class C0031b {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f1679a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1680b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1681c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f1682d;

        /* renamed from: e  reason: collision with root package name */
        private final int f1683e;

        public C0031b(Uri uri, int i, int i2, boolean z, int i3) {
            this.f1679a = (Uri) androidx.core.util.e.a(uri);
            this.f1680b = i;
            this.f1681c = i2;
            this.f1682d = z;
            this.f1683e = i3;
        }

        public Uri a() {
            return this.f1679a;
        }

        public int b() {
            return this.f1680b;
        }

        public int c() {
            return this.f1681c;
        }

        public boolean d() {
            return this.f1682d;
        }

        public int e() {
            return this.f1683e;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f1677a;

        /* renamed from: b  reason: collision with root package name */
        private final C0031b[] f1678b;

        public a(int i, C0031b[] bVarArr) {
            this.f1677a = i;
            this.f1678b = bVarArr;
        }

        public int a() {
            return this.f1677a;
        }

        public C0031b[] b() {
            return this.f1678b;
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, C0031b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (C0031b bVar : bVarArr) {
            if (bVar.e() == 0) {
                Uri a2 = bVar.a();
                if (!hashMap.containsKey(a2)) {
                    hashMap.put(a2, j.a(context, cancellationSignal, a2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static a a(Context context, CancellationSignal cancellationSignal, a aVar) throws PackageManager.NameNotFoundException {
        ProviderInfo a2 = a(context.getPackageManager(), aVar, context.getResources());
        if (a2 == null) {
            return new a(1, (C0031b[]) null);
        }
        return new a(0, a(context, aVar, a2.authority, cancellationSignal));
    }

    public static ProviderInfo a(PackageManager packageManager, a aVar, Resources resources) throws PackageManager.NameNotFoundException {
        String a2 = aVar.a();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + a2);
        } else if (resolveContentProvider.packageName.equals(aVar.b())) {
            List<byte[]> a3 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a3, f1669e);
            List<List<byte[]>> a4 = a(aVar, resources);
            for (int i = 0; i < a4.size(); i++) {
                ArrayList arrayList = new ArrayList(a4.get(i));
                Collections.sort(arrayList, f1669e);
                if (a(a3, (List<byte[]>) arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + a2 + ", but package was not " + aVar.b());
        }
    }

    private static List<List<byte[]>> a(a aVar, Resources resources) {
        if (aVar.d() != null) {
            return aVar.d();
        }
        return androidx.core.content.a.c.a(resources, aVar.e());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.core.e.b.C0031b[] a(android.content.Context r19, androidx.core.e.a r20, java.lang.String r21, android.os.CancellationSignal r22) {
        /*
            r0 = r21
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            java.lang.String r3 = "content"
            android.net.Uri$Builder r2 = r2.scheme(r3)
            android.net.Uri$Builder r2 = r2.authority(r0)
            android.net.Uri r2 = r2.build()
            android.net.Uri$Builder r4 = new android.net.Uri$Builder
            r4.<init>()
            android.net.Uri$Builder r3 = r4.scheme(r3)
            android.net.Uri$Builder r0 = r3.authority(r0)
            java.lang.String r3 = "file"
            android.net.Uri$Builder r0 = r0.appendPath(r3)
            android.net.Uri r0 = r0.build()
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0137 }
            r5 = 16
            java.lang.String r7 = "font_variation_settings"
            r9 = 2
            r10 = 7
            java.lang.String r11 = "result_code"
            java.lang.String r12 = "font_italic"
            java.lang.String r13 = "font_weight"
            java.lang.String r14 = "font_ttc_index"
            java.lang.String r15 = "file_id"
            java.lang.String r3 = "_id"
            r6 = 1
            r8 = 0
            if (r4 <= r5) goto L_0x007e
            android.content.ContentResolver r4 = r19.getContentResolver()     // Catch:{ all -> 0x0137 }
            java.lang.String[] r10 = new java.lang.String[r10]     // Catch:{ all -> 0x0137 }
            r10[r8] = r3     // Catch:{ all -> 0x0137 }
            r10[r6] = r15     // Catch:{ all -> 0x0137 }
            r10[r9] = r14     // Catch:{ all -> 0x0137 }
            r5 = 3
            r10[r5] = r7     // Catch:{ all -> 0x0137 }
            r5 = 4
            r10[r5] = r13     // Catch:{ all -> 0x0137 }
            r5 = 5
            r10[r5] = r12     // Catch:{ all -> 0x0137 }
            r5 = 6
            r10[r5] = r11     // Catch:{ all -> 0x0137 }
            java.lang.String r7 = "query = ?"
            java.lang.String[] r9 = new java.lang.String[r6]     // Catch:{ all -> 0x0137 }
            java.lang.String r5 = r20.c()     // Catch:{ all -> 0x0137 }
            r9[r8] = r5     // Catch:{ all -> 0x0137 }
            r16 = 0
            r5 = r2
            r18 = r1
            r1 = 1
            r6 = r10
            r10 = 0
            r8 = r9
            r9 = r16
            r1 = 0
            r10 = r22
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0137 }
            goto L_0x00ab
        L_0x007e:
            r18 = r1
            r1 = 0
            android.content.ContentResolver r4 = r19.getContentResolver()     // Catch:{ all -> 0x0137 }
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch:{ all -> 0x0137 }
            r6[r1] = r3     // Catch:{ all -> 0x0137 }
            r5 = 1
            r6[r5] = r15     // Catch:{ all -> 0x0137 }
            r6[r9] = r14     // Catch:{ all -> 0x0137 }
            r5 = 3
            r6[r5] = r7     // Catch:{ all -> 0x0137 }
            r5 = 4
            r6[r5] = r13     // Catch:{ all -> 0x0137 }
            r5 = 5
            r6[r5] = r12     // Catch:{ all -> 0x0137 }
            r5 = 6
            r6[r5] = r11     // Catch:{ all -> 0x0137 }
            java.lang.String r7 = "query = ?"
            r5 = 1
            java.lang.String[] r8 = new java.lang.String[r5]     // Catch:{ all -> 0x0137 }
            java.lang.String r5 = r20.c()     // Catch:{ all -> 0x0137 }
            r8[r1] = r5     // Catch:{ all -> 0x0137 }
            r9 = 0
            r5 = r2
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0137 }
        L_0x00ab:
            if (r4 == 0) goto L_0x0127
            int r5 = r4.getCount()     // Catch:{ all -> 0x0125 }
            if (r5 <= 0) goto L_0x0127
            int r5 = r4.getColumnIndex(r11)     // Catch:{ all -> 0x0125 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0125 }
            r6.<init>()     // Catch:{ all -> 0x0125 }
            int r3 = r4.getColumnIndex(r3)     // Catch:{ all -> 0x0125 }
            int r7 = r4.getColumnIndex(r15)     // Catch:{ all -> 0x0125 }
            int r8 = r4.getColumnIndex(r14)     // Catch:{ all -> 0x0125 }
            int r9 = r4.getColumnIndex(r13)     // Catch:{ all -> 0x0125 }
            int r10 = r4.getColumnIndex(r12)     // Catch:{ all -> 0x0125 }
        L_0x00d0:
            boolean r11 = r4.moveToNext()     // Catch:{ all -> 0x0125 }
            if (r11 == 0) goto L_0x0129
            r11 = -1
            if (r5 == r11) goto L_0x00e0
            int r12 = r4.getInt(r5)     // Catch:{ all -> 0x0125 }
            r18 = r12
            goto L_0x00e2
        L_0x00e0:
            r18 = 0
        L_0x00e2:
            if (r8 == r11) goto L_0x00ea
            int r12 = r4.getInt(r8)     // Catch:{ all -> 0x0125 }
            r15 = r12
            goto L_0x00eb
        L_0x00ea:
            r15 = 0
        L_0x00eb:
            if (r7 != r11) goto L_0x00f6
            long r12 = r4.getLong(r3)     // Catch:{ all -> 0x0125 }
            android.net.Uri r12 = android.content.ContentUris.withAppendedId(r2, r12)     // Catch:{ all -> 0x0125 }
            goto L_0x00fe
        L_0x00f6:
            long r12 = r4.getLong(r7)     // Catch:{ all -> 0x0125 }
            android.net.Uri r12 = android.content.ContentUris.withAppendedId(r0, r12)     // Catch:{ all -> 0x0125 }
        L_0x00fe:
            r14 = r12
            if (r9 == r11) goto L_0x0108
            int r12 = r4.getInt(r9)     // Catch:{ all -> 0x0125 }
            r16 = r12
            goto L_0x010c
        L_0x0108:
            r12 = 400(0x190, float:5.6E-43)
            r16 = 400(0x190, float:5.6E-43)
        L_0x010c:
            if (r10 == r11) goto L_0x0118
            int r11 = r4.getInt(r10)     // Catch:{ all -> 0x0125 }
            r12 = 1
            if (r11 != r12) goto L_0x0119
            r17 = 1
            goto L_0x011b
        L_0x0118:
            r12 = 1
        L_0x0119:
            r17 = 0
        L_0x011b:
            androidx.core.e.b$b r11 = new androidx.core.e.b$b     // Catch:{ all -> 0x0125 }
            r13 = r11
            r13.<init>(r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0125 }
            r6.add(r11)     // Catch:{ all -> 0x0125 }
            goto L_0x00d0
        L_0x0125:
            r0 = move-exception
            goto L_0x0139
        L_0x0127:
            r6 = r18
        L_0x0129:
            if (r4 == 0) goto L_0x012e
            r4.close()
        L_0x012e:
            androidx.core.e.b$b[] r0 = new androidx.core.e.b.C0031b[r1]
            java.lang.Object[] r0 = r6.toArray(r0)
            androidx.core.e.b$b[] r0 = (androidx.core.e.b.C0031b[]) r0
            return r0
        L_0x0137:
            r0 = move-exception
            r4 = 0
        L_0x0139:
            if (r4 == 0) goto L_0x013e
            r4.close()
        L_0x013e:
            goto L_0x0140
        L_0x013f:
            throw r0
        L_0x0140:
            goto L_0x013f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.e.b.a(android.content.Context, androidx.core.e.a, java.lang.String, android.os.CancellationSignal):androidx.core.e.b$b[]");
    }
}
