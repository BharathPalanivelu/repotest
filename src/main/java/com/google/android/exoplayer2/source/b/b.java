package com.google.android.exoplayer2.source.b;

import android.util.Log;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.source.b.d;
import com.google.android.exoplayer2.source.k;

final class b implements d.b {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f11541a;

    /* renamed from: b  reason: collision with root package name */
    private final k[] f11542b;

    public b(int[] iArr, k[] kVarArr) {
        this.f11541a = iArr;
        this.f11542b = kVarArr;
    }

    public m a(int i, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.f11541a;
            if (i3 >= iArr.length) {
                Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
                return new com.google.android.exoplayer2.i.d();
            } else if (i2 == iArr[i3]) {
                return this.f11542b[i3];
            } else {
                i3++;
            }
        }
    }

    public int[] a() {
        int[] iArr = new int[this.f11542b.length];
        int i = 0;
        while (true) {
            k[] kVarArr = this.f11542b;
            if (i >= kVarArr.length) {
                return iArr;
            }
            if (kVarArr[i] != null) {
                iArr[i] = kVarArr[i].c();
            }
            i++;
        }
    }

    public void a(long j) {
        for (k kVar : this.f11542b) {
            if (kVar != null) {
                kVar.a(j);
            }
        }
    }
}
