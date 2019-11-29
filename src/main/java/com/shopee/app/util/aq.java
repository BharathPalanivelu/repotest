package com.shopee.app.util;

import android.animation.TypeEvaluator;

public class aq implements TypeEvaluator<ar> {
    /* renamed from: a */
    public ar evaluate(float f2, ar arVar, ar arVar2) {
        float f3;
        float f4;
        if (arVar2.f26167g == 2) {
            float f5 = 1.0f - f2;
            float f6 = f5 * f5 * f5;
            float f7 = 3.0f * f5;
            float f8 = f5 * f7 * f2;
            float f9 = f7 * f2 * f2;
            float f10 = f2 * f2 * f2;
            f3 = (arVar.f26161a * f6) + (arVar2.f26163c * f8) + (arVar2.f26165e * f9) + (arVar2.f26161a * f10);
            f4 = (f6 * arVar.f26162b) + (f8 * arVar2.f26164d) + (f9 * arVar2.f26166f) + (f10 * arVar2.f26162b);
        } else if (arVar2.f26167g == 1) {
            f3 = arVar.f26161a + ((arVar2.f26161a - arVar.f26161a) * f2);
            f4 = arVar.f26162b + (f2 * (arVar2.f26162b - arVar.f26162b));
        } else {
            f3 = arVar2.f26161a;
            f4 = arVar2.f26162b;
        }
        return ar.a(f3, f4);
    }
}
