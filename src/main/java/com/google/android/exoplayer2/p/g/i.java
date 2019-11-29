package com.google.android.exoplayer2.p.g;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.p.b;
import com.google.android.exoplayer2.p.e;
import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class i implements e {

    /* renamed from: a  reason: collision with root package name */
    private final List<e> f11221a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11222b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f11223c = new long[(this.f11222b * 2)];

    /* renamed from: d  reason: collision with root package name */
    private final long[] f11224d;

    public i(List<e> list) {
        this.f11221a = list;
        this.f11222b = list.size();
        for (int i = 0; i < this.f11222b; i++) {
            e eVar = list.get(i);
            int i2 = i * 2;
            this.f11223c[i2] = eVar.m;
            this.f11223c[i2 + 1] = eVar.n;
        }
        long[] jArr = this.f11223c;
        this.f11224d = Arrays.copyOf(jArr, jArr.length);
        Arrays.sort(this.f11224d);
    }

    public int a(long j) {
        int b2 = v.b(this.f11224d, j, false, false);
        if (b2 < this.f11224d.length) {
            return b2;
        }
        return -1;
    }

    public int b() {
        return this.f11224d.length;
    }

    public long a(int i) {
        boolean z = true;
        a.a(i >= 0);
        if (i >= this.f11224d.length) {
            z = false;
        }
        a.a(z);
        return this.f11224d[i];
    }

    public List<b> b(long j) {
        SpannableStringBuilder spannableStringBuilder = null;
        e eVar = null;
        ArrayList arrayList = null;
        for (int i = 0; i < this.f11222b; i++) {
            long[] jArr = this.f11223c;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                e eVar2 = this.f11221a.get(i);
                if (!eVar2.a()) {
                    arrayList.add(eVar2);
                } else if (eVar == null) {
                    eVar = eVar2;
                } else if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(eVar.f11068a).append("\n").append(eVar2.f11068a);
                } else {
                    spannableStringBuilder.append("\n").append(eVar2.f11068a);
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new e(spannableStringBuilder));
        } else if (eVar != null) {
            arrayList.add(eVar);
        }
        if (arrayList != null) {
            return arrayList;
        }
        return Collections.emptyList();
    }
}
