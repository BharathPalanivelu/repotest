package com.shopee.live.livestreaming.ui.audience.view;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class a implements TypeEvaluator<PointF> {

    /* renamed from: a  reason: collision with root package name */
    private PointF f29057a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f29058b;

    public a(PointF pointF, PointF pointF2) {
        this.f29057a = pointF;
        this.f29058b = pointF2;
    }

    /* renamed from: a */
    public PointF evaluate(float f2, PointF pointF, PointF pointF2) {
        PointF pointF3 = new PointF();
        float f3 = 1.0f - f2;
        pointF3.x = (pointF.x * f3 * f3 * f3) + (this.f29057a.x * 3.0f * f2 * f3 * f3) + (this.f29058b.x * 3.0f * f2 * f2 * f3) + (pointF2.x * f2 * f2 * f2);
        pointF3.y = (pointF.y * f3 * f3 * f3) + (this.f29057a.y * 3.0f * f2 * f3 * f3) + (this.f29058b.y * 3.0f * f2 * f2 * f3) + (pointF2.y * f2 * f2 * f2);
        return pointF3;
    }
}
