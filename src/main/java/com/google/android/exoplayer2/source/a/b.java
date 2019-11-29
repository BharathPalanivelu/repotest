package com.google.android.exoplayer2.source.a;

import android.util.Log;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.source.a.d;

final class b implements d.b {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f11494a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.e.d[] f11495b;

    public b(int[] iArr, com.google.android.exoplayer2.e.d[] dVarArr) {
        this.f11494a = iArr;
        this.f11495b = dVarArr;
    }

    public n a(int i, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.f11494a;
            if (i3 >= iArr.length) {
                Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
                return new e();
            } else if (i2 == iArr[i3]) {
                return this.f11495b[i3];
            } else {
                i3++;
            }
        }
    }

    public int[] a() {
        int[] iArr = new int[this.f11495b.length];
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.e.d[] dVarArr = this.f11495b;
            if (i >= dVarArr.length) {
                return iArr;
            }
            if (dVarArr[i] != null) {
                iArr[i] = dVarArr[i].b();
            }
            i++;
        }
    }

    public void a(long j) {
        for (com.google.android.exoplayer2.e.d dVar : this.f11495b) {
            if (dVar != null) {
                dVar.a(j);
            }
        }
    }
}
