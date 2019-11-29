package com.google.zxing.c.b;

import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final a f14493a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f14494b = new ArrayList();

    public d(a aVar) {
        this.f14493a = aVar;
        this.f14494b.add(new b(aVar, new int[]{1}));
    }

    private b a(int i) {
        if (i >= this.f14494b.size()) {
            List<b> list = this.f14494b;
            b bVar = list.get(list.size() - 1);
            for (int size = this.f14494b.size(); size <= i; size++) {
                a aVar = this.f14493a;
                bVar = bVar.b(new b(aVar, new int[]{1, aVar.a((size - 1) + aVar.d())}));
                this.f14494b.add(bVar);
            }
        }
        return this.f14494b.get(i);
    }

    public void a(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                b a2 = a(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] a3 = new b(this.f14493a, iArr2).a(i, 1).c(a2)[1].a();
                int length2 = i - a3.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(a3, 0, iArr, length + length2, a3.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
