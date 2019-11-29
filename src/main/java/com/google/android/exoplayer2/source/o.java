package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.s.a;
import java.util.Arrays;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final int f12114a;

    /* renamed from: b  reason: collision with root package name */
    private final Format[] f12115b;

    /* renamed from: c  reason: collision with root package name */
    private int f12116c;

    public o(Format... formatArr) {
        a.b(formatArr.length > 0);
        this.f12115b = formatArr;
        this.f12114a = formatArr.length;
    }

    public Format a(int i) {
        return this.f12115b[i];
    }

    public int a(Format format) {
        int i = 0;
        while (true) {
            Format[] formatArr = this.f12115b;
            if (i >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i]) {
                return i;
            }
            i++;
        }
    }

    public int hashCode() {
        if (this.f12116c == 0) {
            this.f12116c = 527 + Arrays.hashCode(this.f12115b);
        }
        return this.f12116c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f12114a != oVar.f12114a || !Arrays.equals(this.f12115b, oVar.f12115b)) {
            return false;
        }
        return true;
    }
}
