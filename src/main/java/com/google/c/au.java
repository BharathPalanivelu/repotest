package com.google.c;

import java.util.Arrays;

public final class au {

    /* renamed from: a  reason: collision with root package name */
    private static final au f13682a = new au(0, new int[0], new Object[0], false);

    /* renamed from: b  reason: collision with root package name */
    private int f13683b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f13684c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f13685d;

    /* renamed from: e  reason: collision with root package name */
    private int f13686e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13687f;

    public static au a() {
        return f13682a;
    }

    static au a(au auVar, au auVar2) {
        int i = auVar.f13683b + auVar2.f13683b;
        int[] copyOf = Arrays.copyOf(auVar.f13684c, i);
        System.arraycopy(auVar2.f13684c, 0, copyOf, auVar.f13683b, auVar2.f13683b);
        Object[] copyOf2 = Arrays.copyOf(auVar.f13685d, i);
        System.arraycopy(auVar2.f13685d, 0, copyOf2, auVar.f13683b, auVar2.f13683b);
        return new au(i, copyOf, copyOf2, true);
    }

    private au() {
        this(0, new int[8], new Object[8], true);
    }

    private au(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f13686e = -1;
        this.f13683b = i;
        this.f13684c = iArr;
        this.f13685d = objArr;
        this.f13687f = z;
    }

    public void b() {
        this.f13687f = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof au)) {
            return false;
        }
        au auVar = (au) obj;
        return this.f13683b == auVar.f13683b && Arrays.equals(this.f13684c, auVar.f13684c) && Arrays.deepEquals(this.f13685d, auVar.f13685d);
    }

    public int hashCode() {
        return ((((527 + this.f13683b) * 31) + Arrays.hashCode(this.f13684c)) * 31) + Arrays.deepHashCode(this.f13685d);
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f13683b; i2++) {
            af.a(sb, i, String.valueOf(ay.b(this.f13684c[i2])), this.f13685d[i2]);
        }
    }
}
