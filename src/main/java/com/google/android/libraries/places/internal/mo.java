package com.google.android.libraries.places.internal;

final class mo implements ly {

    /* renamed from: a  reason: collision with root package name */
    public final ma f12976a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12977b;

    /* renamed from: c  reason: collision with root package name */
    public final Object[] f12978c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12979d;

    mo(ma maVar, String str, Object[] objArr) {
        this.f12976a = maVar;
        this.f12977b = str;
        this.f12978c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f12979d = charAt;
            return;
        }
        char c2 = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c2 |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.f12979d = c2 | (charAt2 << i);
                return;
            }
        }
    }

    public final ma c() {
        return this.f12976a;
    }

    public final ml a() {
        return (this.f12979d & 1) == 1 ? ml.PROTO2 : ml.PROTO3;
    }

    public final boolean b() {
        return (this.f12979d & 2) == 2;
    }
}
