package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.a;
import java.util.Arrays;

public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public final int f11534a;

    /* renamed from: b  reason: collision with root package name */
    private final j[] f11535b;

    /* renamed from: c  reason: collision with root package name */
    private int f11536c;

    public ac(j... jVarArr) {
        a.b(jVarArr.length > 0);
        this.f11535b = jVarArr;
        this.f11534a = jVarArr.length;
    }

    public j a(int i) {
        return this.f11535b[i];
    }

    public int a(j jVar) {
        int i = 0;
        while (true) {
            j[] jVarArr = this.f11535b;
            if (i >= jVarArr.length) {
                return -1;
            }
            if (jVar == jVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public int hashCode() {
        if (this.f11536c == 0) {
            this.f11536c = 527 + Arrays.hashCode(this.f11535b);
        }
        return this.f11536c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ac acVar = (ac) obj;
        if (this.f11534a != acVar.f11534a || !Arrays.equals(this.f11535b, acVar.f11535b)) {
            return false;
        }
        return true;
    }
}
