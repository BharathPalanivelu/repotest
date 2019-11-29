package com.google.zxing;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.zxing.c.a.a;

public class y {

    /* renamed from: a  reason: collision with root package name */
    private final float f14794a;

    /* renamed from: b  reason: collision with root package name */
    private final float f14795b;

    public y(float f2, float f3) {
        this.f14794a = f2;
        this.f14795b = f3;
    }

    public final float a() {
        return this.f14794a;
    }

    public final float b() {
        return this.f14795b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (this.f14794a == yVar.f14794a && this.f14795b == yVar.f14795b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f14794a) * 31) + Float.floatToIntBits(this.f14795b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append('(');
        sb.append(this.f14794a);
        sb.append(',');
        sb.append(this.f14795b);
        sb.append(')');
        return sb.toString();
    }

    public static void a(y[] yVarArr) {
        y yVar;
        y yVar2;
        y yVar3;
        float a2 = a(yVarArr[0], yVarArr[1]);
        float a3 = a(yVarArr[1], yVarArr[2]);
        float a4 = a(yVarArr[0], yVarArr[2]);
        if (a3 >= a2 && a3 >= a4) {
            yVar3 = yVarArr[0];
            yVar2 = yVarArr[1];
            yVar = yVarArr[2];
        } else if (a4 < a3 || a4 < a2) {
            yVar3 = yVarArr[2];
            yVar2 = yVarArr[0];
            yVar = yVarArr[1];
        } else {
            yVar3 = yVarArr[1];
            yVar2 = yVarArr[0];
            yVar = yVarArr[2];
        }
        if (a(yVar2, yVar3, yVar) < BitmapDescriptorFactory.HUE_RED) {
            y yVar4 = yVar;
            yVar = yVar2;
            yVar2 = yVar4;
        }
        yVarArr[0] = yVar2;
        yVarArr[1] = yVar3;
        yVarArr[2] = yVar;
    }

    public static float a(y yVar, y yVar2) {
        return a.a(yVar.f14794a, yVar.f14795b, yVar2.f14794a, yVar2.f14795b);
    }

    private static float a(y yVar, y yVar2, y yVar3) {
        float f2 = yVar2.f14794a;
        float f3 = yVar2.f14795b;
        return ((yVar3.f14794a - f2) * (yVar.f14795b - f3)) - ((yVar3.f14795b - f3) * (yVar.f14794a - f2));
    }
}
