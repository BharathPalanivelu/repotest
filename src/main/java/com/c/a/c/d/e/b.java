package com.c.a.c.d.e;

import android.graphics.Bitmap;
import com.c.a.b.a;
import com.c.a.c.b.a.e;

public final class b implements a.C0098a {

    /* renamed from: a  reason: collision with root package name */
    private final e f6068a;

    /* renamed from: b  reason: collision with root package name */
    private final com.c.a.c.b.a.b f6069b;

    public b(e eVar, com.c.a.c.b.a.b bVar) {
        this.f6068a = eVar;
        this.f6069b = bVar;
    }

    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f6068a.b(i, i2, config);
    }

    public void a(Bitmap bitmap) {
        this.f6068a.a(bitmap);
    }

    public byte[] a(int i) {
        com.c.a.c.b.a.b bVar = this.f6069b;
        if (bVar == null) {
            return new byte[i];
        }
        return (byte[]) bVar.a(i, byte[].class);
    }

    public void a(byte[] bArr) {
        com.c.a.c.b.a.b bVar = this.f6069b;
        if (bVar != null) {
            bVar.a(bArr, byte[].class);
        }
    }

    public int[] b(int i) {
        com.c.a.c.b.a.b bVar = this.f6069b;
        if (bVar == null) {
            return new int[i];
        }
        return (int[]) bVar.a(i, int[].class);
    }

    public void a(int[] iArr) {
        com.c.a.c.b.a.b bVar = this.f6069b;
        if (bVar != null) {
            bVar.a(iArr, int[].class);
        }
    }
}
