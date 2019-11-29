package com.otaliastudios.cameraview;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashMap;

public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    static final HashMap<String, a> f15515a = new HashMap<>(16);

    /* renamed from: b  reason: collision with root package name */
    private final int f15516b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15517c;

    public static a a(int i, int i2) {
        int b2 = b(i, i2);
        int i3 = i / b2;
        int i4 = i2 / b2;
        String str = i3 + ":" + i4;
        a aVar = f15515a.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(i3, i4);
        f15515a.put(str, aVar2);
        return aVar2;
    }

    public static a a(String str) {
        String[] split = str.split(":");
        if (split.length == 2) {
            return a(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue());
        }
        throw new NumberFormatException("Illegal AspectRatio string. Must be x:y");
    }

    private a(int i, int i2) {
        this.f15516b = i;
        this.f15517c = i2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f15516b == aVar.f15516b && this.f15517c == aVar.f15517c) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f15516b + ":" + this.f15517c;
    }

    public float a() {
        return ((float) this.f15516b) / ((float) this.f15517c);
    }

    public int hashCode() {
        int i = this.f15517c;
        int i2 = this.f15516b;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    /* renamed from: a */
    public int compareTo(a aVar) {
        if (equals(aVar)) {
            return 0;
        }
        return a() - aVar.a() > BitmapDescriptorFactory.HUE_RED ? 1 : -1;
    }

    public a b() {
        return a(this.f15517c, this.f15516b);
    }

    private static int b(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i == 0) {
                return i4;
            }
            i2 = i4 % i;
        }
    }
}
