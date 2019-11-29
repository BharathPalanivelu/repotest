package com.beetalklib.network.file.a;

import com.beetalklib.network.file.protocol.ImageUploadRequestHeader;
import com.beetalklib.network.file.protocol.ImageUploadRequestPart;
import e.f;

public class j implements g {

    /* renamed from: a  reason: collision with root package name */
    protected String f5564a;

    /* renamed from: b  reason: collision with root package name */
    protected String f5565b;

    /* renamed from: c  reason: collision with root package name */
    protected String f5566c;

    /* renamed from: d  reason: collision with root package name */
    private String f5567d;

    /* renamed from: e  reason: collision with root package name */
    private int f5568e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f5569f = null;

    /* renamed from: g  reason: collision with root package name */
    private i f5570g;
    private int h;
    private int i;

    public int e() {
        return 1;
    }

    public j(String str, int i2, String str2, byte[] bArr, String str3, i iVar) {
        this.f5569f = bArr;
        this.h = (int) Math.ceil((double) (((float) this.f5569f.length) / 4096.0f));
        a(str, i2, str2, str3, iVar);
    }

    public j(String str, int i2, String str2, String str3, String str4, i iVar) {
        this.f5567d = str3;
        a(str, i2, str2, str4, iVar);
    }

    private void a(String str, int i2, String str2, String str3, i iVar) {
        this.f5564a = str2;
        this.f5565b = str3;
        this.f5570g = iVar;
        this.f5566c = str;
        this.f5568e = i2;
        this.i = -1;
    }

    /* access modifiers changed from: protected */
    public ImageUploadRequestHeader a() {
        ImageUploadRequestHeader.Builder builder = new ImageUploadRequestHeader.Builder();
        String str = this.f5564a;
        builder.Name = str;
        builder.RequestId = str;
        builder.Timeout = 1000;
        builder.Token = this.f5565b;
        builder.TotalBlock = Integer.valueOf(this.h);
        builder.Thumb(false);
        builder.Type = "f";
        return builder.build();
    }

    public String b() {
        return this.f5566c;
    }

    public int c() {
        return this.f5568e;
    }

    /* access modifiers changed from: protected */
    public int d() {
        return this.i;
    }

    /* access modifiers changed from: protected */
    public ImageUploadRequestPart a(int i2) {
        this.i = i2 - 1;
        int i3 = i2 * 4096;
        if (i2 >= this.h) {
            i iVar = this.f5570g;
            byte[] bArr = this.f5569f;
            iVar.a(bArr.length, bArr.length);
            this.f5570g.a();
            return null;
        }
        this.f5570g.a(this.f5569f.length, i3);
        byte[] bArr2 = this.f5569f;
        int i4 = i3 + 4096;
        if (bArr2.length < i4) {
            i4 = bArr2.length;
        }
        int i5 = i4 - i3;
        byte[] bArr3 = new byte[i5];
        System.arraycopy(this.f5569f, i3, bArr3, 0, i5);
        ImageUploadRequestPart.Builder builder = new ImageUploadRequestPart.Builder();
        builder.PartId = Integer.valueOf(i2);
        builder.Content = f.a(bArr3);
        builder.RequestId = this.f5564a;
        return builder.build();
    }

    /* access modifiers changed from: protected */
    public int f() {
        return this.h;
    }

    public void b(int i2) {
        this.f5570g.a(i2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (!jVar.b().equals(this.f5566c) || jVar.f5568e != this.f5568e || !this.f5570g.equals(jVar.f5570g) || !this.f5564a.equals(jVar.f5564a)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061 A[SYNTHETIC, Splitter:B:31:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006d A[SYNTHETIC, Splitter:B:38:0x006d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g() {
        /*
            r6 = this;
            byte[] r0 = r6.f5569f
            r1 = 0
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = r6.f5567d
            if (r0 != 0) goto L_0x000b
            goto L_0x0076
        L_0x000b:
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            boolean r0 = r2.exists()
            if (r0 != 0) goto L_0x0017
            return r1
        L_0x0017:
            r0 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0059, all -> 0x0055 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0059, all -> 0x0055 }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0053 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0053 }
            r2.<init>()     // Catch:{ IOException -> 0x0053 }
        L_0x0026:
            int r4 = r3.read(r0)     // Catch:{ IOException -> 0x0053 }
            r5 = -1
            if (r4 == r5) goto L_0x0031
            r2.write(r0, r1, r4)     // Catch:{ IOException -> 0x0053 }
            goto L_0x0026
        L_0x0031:
            byte[] r0 = r2.toByteArray()     // Catch:{ IOException -> 0x0053 }
            r6.f5569f = r0     // Catch:{ IOException -> 0x0053 }
            byte[] r0 = r6.f5569f     // Catch:{ IOException -> 0x0053 }
            int r0 = r0.length     // Catch:{ IOException -> 0x0053 }
            float r0 = (float) r0     // Catch:{ IOException -> 0x0053 }
            r2 = 1166016512(0x45800000, float:4096.0)
            float r0 = r0 / r2
            double r4 = (double) r0     // Catch:{ IOException -> 0x0053 }
            double r4 = java.lang.Math.ceil(r4)     // Catch:{ IOException -> 0x0053 }
            int r0 = (int) r4     // Catch:{ IOException -> 0x0053 }
            r6.h = r0     // Catch:{ IOException -> 0x0053 }
            r3.close()     // Catch:{ IOException -> 0x0053 }
            r0 = 1
            r3.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r1 = move-exception
            com.beetalklib.network.c.a.a(r1)
        L_0x0052:
            return r0
        L_0x0053:
            r0 = move-exception
            goto L_0x005c
        L_0x0055:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto L_0x006b
        L_0x0059:
            r2 = move-exception
            r3 = r0
            r0 = r2
        L_0x005c:
            com.beetalklib.network.c.a.a(r0)     // Catch:{ all -> 0x006a }
            if (r3 == 0) goto L_0x0069
            r3.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r0 = move-exception
            com.beetalklib.network.c.a.a(r0)
        L_0x0069:
            return r1
        L_0x006a:
            r0 = move-exception
        L_0x006b:
            if (r3 == 0) goto L_0x0075
            r3.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r1 = move-exception
            com.beetalklib.network.c.a.a(r1)
        L_0x0075:
            throw r0
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beetalklib.network.file.a.j.g():boolean");
    }
}
