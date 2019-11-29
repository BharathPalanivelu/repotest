package com.google.android.exoplayer2.j.f;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.j.d;
import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.n.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class i implements d {

    /* renamed from: a  reason: collision with root package name */
    private final List<e> f10616a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10617b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f10618c = new long[(this.f10617b * 2)];

    /* renamed from: d  reason: collision with root package name */
    private final long[] f10619d;

    public i(List<e> list) {
        this.f10616a = list;
        this.f10617b = list.size();
        for (int i = 0; i < this.f10617b; i++) {
            e eVar = list.get(i);
            int i2 = i * 2;
            this.f10618c[i2] = eVar.m;
            this.f10618c[i2 + 1] = eVar.n;
        }
        long[] jArr = this.f10618c;
        this.f10619d = Arrays.copyOf(jArr, jArr.length);
        Arrays.sort(this.f10619d);
    }

    public int a(long j) {
        int b2 = t.b(this.f10619d, j, false, false);
        if (b2 < this.f10619d.length) {
            return b2;
        }
        return -1;
    }

    public int i_() {
        return this.f10619d.length;
    }

    public long a(int i) {
        boolean z = true;
        a.a(i >= 0);
        if (i >= this.f10619d.length) {
            z = false;
        }
        a.a(z);
        return this.f10619d[i];
    }

    public List<com.google.android.exoplayer2.j.a> b(long j) {
        SpannableStringBuilder spannableStringBuilder = null;
        e eVar = null;
        ArrayList arrayList = null;
        for (int i = 0; i < this.f10617b; i++) {
            long[] jArr = this.f10618c;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                e eVar2 = this.f10616a.get(i);
                if (!eVar2.a()) {
                    arrayList.add(eVar2);
                } else if (eVar == null) {
                    eVar = eVar2;
                } else if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(eVar.f10429a).append("\n").append(eVar2.f10429a);
                } else {
                    spannableStringBuilder.append("\n").append(eVar2.f10429a);
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
