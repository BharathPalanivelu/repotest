package com.google.android.exoplayer2.s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<a> f11432a = new Comparator<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.f11439a - aVar2.f11439a;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<a> f11433b = new Comparator<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            if (aVar.f11441c < aVar2.f11441c) {
                return -1;
            }
            return aVar2.f11441c < aVar.f11441c ? 1 : 0;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final int f11434c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<a> f11435d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final a[] f11436e = new a[5];

    /* renamed from: f  reason: collision with root package name */
    private int f11437f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f11438g;
    private int h;
    private int i;

    public p(int i2) {
        this.f11434c = i2;
    }

    public void a(int i2, float f2) {
        a aVar;
        a();
        int i3 = this.i;
        if (i3 > 0) {
            a[] aVarArr = this.f11436e;
            int i4 = i3 - 1;
            this.i = i4;
            aVar = aVarArr[i4];
        } else {
            aVar = new a();
        }
        int i5 = this.f11438g;
        this.f11438g = i5 + 1;
        aVar.f11439a = i5;
        aVar.f11440b = i2;
        aVar.f11441c = f2;
        this.f11435d.add(aVar);
        this.h += i2;
        while (true) {
            int i6 = this.h;
            int i7 = this.f11434c;
            if (i6 > i7) {
                int i8 = i6 - i7;
                a aVar2 = this.f11435d.get(0);
                if (aVar2.f11440b <= i8) {
                    this.h -= aVar2.f11440b;
                    this.f11435d.remove(0);
                    int i9 = this.i;
                    if (i9 < 5) {
                        a[] aVarArr2 = this.f11436e;
                        this.i = i9 + 1;
                        aVarArr2[i9] = aVar2;
                    }
                } else {
                    aVar2.f11440b -= i8;
                    this.h -= i8;
                }
            } else {
                return;
            }
        }
    }

    public float a(float f2) {
        b();
        float f3 = f2 * ((float) this.h);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f11435d.size(); i3++) {
            a aVar = this.f11435d.get(i3);
            i2 += aVar.f11440b;
            if (((float) i2) >= f3) {
                return aVar.f11441c;
            }
        }
        if (this.f11435d.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<a> arrayList = this.f11435d;
        return arrayList.get(arrayList.size() - 1).f11441c;
    }

    private void a() {
        if (this.f11437f != 1) {
            Collections.sort(this.f11435d, f11432a);
            this.f11437f = 1;
        }
    }

    private void b() {
        if (this.f11437f != 0) {
            Collections.sort(this.f11435d, f11433b);
            this.f11437f = 0;
        }
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f11439a;

        /* renamed from: b  reason: collision with root package name */
        public int f11440b;

        /* renamed from: c  reason: collision with root package name */
        public float f11441c;

        private a() {
        }
    }
}
