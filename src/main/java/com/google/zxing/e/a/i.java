package com.google.zxing.e.a;

import com.google.zxing.y;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f14656a;

    i(boolean z) {
        this.f14656a = z;
    }

    public void a(y[] yVarArr) {
        if (this.f14656a && yVarArr != null && yVarArr.length >= 3) {
            y yVar = yVarArr[0];
            yVarArr[0] = yVarArr[2];
            yVarArr[2] = yVar;
        }
    }
}
