package com.google.android.exoplayer2.n;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<a> f10958a = new Comparator<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.f10965a - aVar2.f10965a;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<a> f10959b = new Comparator<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            if (aVar.f10967c < aVar2.f10967c) {
                return -1;
            }
            return aVar2.f10967c < aVar.f10967c ? 1 : 0;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final int f10960c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<a> f10961d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final a[] f10962e = new a[5];

    /* renamed from: f  reason: collision with root package name */
    private int f10963f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f10964g;
    private int h;
    private int i;

    public o(int i2) {
        this.f10960c = i2;
    }

    public void a(int i2, float f2) {
        a aVar;
        a();
        int i3 = this.i;
        if (i3 > 0) {
            a[] aVarArr = this.f10962e;
            int i4 = i3 - 1;
            this.i = i4;
            aVar = aVarArr[i4];
        } else {
            aVar = new a();
        }
        int i5 = this.f10964g;
        this.f10964g = i5 + 1;
        aVar.f10965a = i5;
        aVar.f10966b = i2;
        aVar.f10967c = f2;
        this.f10961d.add(aVar);
        this.h += i2;
        while (true) {
            int i6 = this.h;
            int i7 = this.f10960c;
            if (i6 > i7) {
                int i8 = i6 - i7;
                a aVar2 = this.f10961d.get(0);
                if (aVar2.f10966b <= i8) {
                    this.h -= aVar2.f10966b;
                    this.f10961d.remove(0);
                    int i9 = this.i;
                    if (i9 < 5) {
                        a[] aVarArr2 = this.f10962e;
                        this.i = i9 + 1;
                        aVarArr2[i9] = aVar2;
                    }
                } else {
                    aVar2.f10966b -= i8;
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
        for (int i3 = 0; i3 < this.f10961d.size(); i3++) {
            a aVar = this.f10961d.get(i3);
            i2 += aVar.f10966b;
            if (((float) i2) >= f3) {
                return aVar.f10967c;
            }
        }
        if (this.f10961d.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<a> arrayList = this.f10961d;
        return arrayList.get(arrayList.size() - 1).f10967c;
    }

    private void a() {
        if (this.f10963f != 1) {
            Collections.sort(this.f10961d, f10958a);
            this.f10963f = 1;
        }
    }

    private void b() {
        if (this.f10963f != 0) {
            Collections.sort(this.f10961d, f10959b);
            this.f10963f = 0;
        }
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f10965a;

        /* renamed from: b  reason: collision with root package name */
        public int f10966b;

        /* renamed from: c  reason: collision with root package name */
        public float f10967c;

        private a() {
        }
    }
}
