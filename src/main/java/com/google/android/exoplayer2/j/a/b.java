package com.google.android.exoplayer2.j.a;

import android.text.Layout;
import com.google.android.exoplayer2.j.a;

final class b extends a implements Comparable<b> {
    public final int m;

    public b(CharSequence charSequence, Layout.Alignment alignment, float f2, int i, int i2, float f3, int i3, float f4, boolean z, int i4, int i5) {
        super(charSequence, alignment, f2, i, i2, f3, i3, f4, z, i4);
        this.m = i5;
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        int i = bVar.m;
        int i2 = this.m;
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }
}
