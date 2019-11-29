package com.google.android.libraries.places.internal;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLStatement;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class hn<K, V> extends hd<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private static final hd<Object, Object> f6722a = new hn((Object) null, new Object[0], 0);
    public static final long serialVersionUID = 0;

    /* renamed from: b  reason: collision with root package name */
    private final transient Object f6723b;

    /* renamed from: c  reason: collision with root package name */
    private final transient Object[] f6724c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f6725d;

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r2v4 ?, r2v1 ?, r2v5 ?, r2v6 ?, r2v8 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    static <K, V> com.google.android.libraries.places.internal.hn<K, V> a(int r10, java.lang.Object[] r11) {
        /*
            if (r10 != 0) goto L_0x0007
            com.google.android.libraries.places.internal.hd<java.lang.Object, java.lang.Object> r10 = f6722a
            com.google.android.libraries.places.internal.hn r10 = (com.google.android.libraries.places.internal.hn) r10
            return r10
        L_0x0007:
            r0 = 0
            r1 = 0
            r2 = 1
            if (r10 != r2) goto L_0x0019
            r10 = r11[r1]
            r1 = r11[r2]
            com.google.android.libraries.places.internal.go.b((java.lang.Object) r10, (java.lang.Object) r1)
            com.google.android.libraries.places.internal.hn r10 = new com.google.android.libraries.places.internal.hn
            r10.<init>(r0, r11, r2)
            return r10
        L_0x0019:
            int r3 = r11.length
            int r3 = r3 >> r2
            com.google.android.libraries.places.internal.go.b((int) r10, (int) r3)
            int r3 = com.google.android.libraries.places.internal.hg.a((int) r10)
            if (r10 != r2) goto L_0x002e
            r1 = r11[r1]
            r2 = r11[r2]
            com.google.android.libraries.places.internal.go.b((java.lang.Object) r1, (java.lang.Object) r2)
            r2 = r0
            goto L_0x00df
        L_0x002e:
            int r0 = r3 + -1
            r2 = 128(0x80, float:1.794E-43)
            r4 = -1
            if (r3 > r2) goto L_0x006d
            byte[] r2 = new byte[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x003a:
            if (r1 >= r10) goto L_0x00df
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.libraries.places.internal.go.b((java.lang.Object) r4, (java.lang.Object) r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.libraries.places.internal.go.b((int) r6)
        L_0x004f:
            r6 = r6 & r0
            byte r7 = r2[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x005d
            byte r3 = (byte) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x003a
        L_0x005d:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0068
            int r6 = r6 + 1
            goto L_0x004f
        L_0x0068:
            java.lang.IllegalArgumentException r10 = a(r4, r5, r11, r7)
            throw r10
        L_0x006d:
            r2 = 32768(0x8000, float:4.5918E-41)
            if (r3 > r2) goto L_0x00ab
            short[] r2 = new short[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x0077:
            if (r1 >= r10) goto L_0x00df
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.libraries.places.internal.go.b((java.lang.Object) r4, (java.lang.Object) r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.libraries.places.internal.go.b((int) r6)
        L_0x008c:
            r6 = r6 & r0
            short r7 = r2[r6]
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x009b
            short r3 = (short) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x0077
        L_0x009b:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00a6
            int r6 = r6 + 1
            goto L_0x008c
        L_0x00a6:
            java.lang.IllegalArgumentException r10 = a(r4, r5, r11, r7)
            throw r10
        L_0x00ab:
            int[] r2 = new int[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x00b0:
            if (r1 >= r10) goto L_0x00df
            int r3 = r1 * 2
            r5 = r11[r3]
            r6 = r3 ^ 1
            r6 = r11[r6]
            com.google.android.libraries.places.internal.go.b((java.lang.Object) r5, (java.lang.Object) r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.libraries.places.internal.go.b((int) r7)
        L_0x00c5:
            r7 = r7 & r0
            r8 = r2[r7]
            if (r8 != r4) goto L_0x00cf
            r2[r7] = r3
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00cf:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x00da
            int r7 = r7 + 1
            goto L_0x00c5
        L_0x00da:
            java.lang.IllegalArgumentException r10 = a(r5, r6, r11, r8)
            throw r10
        L_0x00df:
            com.google.android.libraries.places.internal.hn r0 = new com.google.android.libraries.places.internal.hn
            r0.<init>(r2, r11, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.hn.a(int, java.lang.Object[]):com.google.android.libraries.places.internal.hn");
    }

    private static IllegalArgumentException a(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private hn(Object obj, Object[] objArr, int i) {
        this.f6723b = obj;
        this.f6724c = objArr;
        this.f6725d = i;
    }

    public final int size() {
        return this.f6725d;
    }

    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.f6723b;
        V[] vArr = this.f6724c;
        int i = this.f6725d;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int b2 = go.b(obj.hashCode());
                while (true) {
                    int i2 = b2 & length;
                    byte b3 = bArr[i2] & 255;
                    if (b3 == 255) {
                        return null;
                    }
                    if (vArr[b3].equals(obj)) {
                        return vArr[b3 ^ 1];
                    }
                    b2 = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int b4 = go.b(obj.hashCode());
                while (true) {
                    int i3 = b4 & length2;
                    short s = sArr[i3] & SQLStatement.NONE;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    b4 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int b5 = go.b(obj.hashCode());
                while (true) {
                    int i4 = b5 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    b5 = i4 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final hg<Map.Entry<K, V>> a() {
        return new ho(this, this.f6724c, 0, this.f6725d);
    }

    /* access modifiers changed from: package-private */
    public final hg<K> b() {
        return new hq(this, new hr(this.f6724c, 0, this.f6725d));
    }

    /* access modifiers changed from: package-private */
    public final gz<V> c() {
        return new hr(this.f6724c, 1, this.f6725d);
    }
}
