package com.shopee.scanner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.scanner.c;
import d.d.b.h;
import d.d.b.j;

public final class b extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f30274a;

    /* renamed from: b  reason: collision with root package name */
    private float f30275b;

    /* renamed from: c  reason: collision with root package name */
    private float f30276c;

    /* renamed from: d  reason: collision with root package name */
    private float f30277d;

    /* renamed from: e  reason: collision with root package name */
    private float f30278e;

    public b(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        Paint paint = new Paint(1);
        paint.setColor(androidx.core.content.b.c(context, c.a.viewfinder_mask));
        paint.setStyle(Paint.Style.FILL);
        this.f30274a = paint;
        this.f30275b = h.f32664a.a();
        this.f30276c = h.f32664a.a();
        this.f30277d = h.f32664a.a();
        this.f30278e = h.f32664a.a();
    }

    private final boolean getHasMaskPosition() {
        return !Float.isNaN(this.f30275b) && !Float.isNaN(this.f30276c) && !Float.isNaN(this.f30277d) && !Float.isNaN(this.f30278e);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (getHasMaskPosition() && canvas != null) {
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, this.f30277d, this.f30276c, this.f30274a);
            canvas.drawRect(this.f30277d, BitmapDescriptorFactory.HUE_RED, (float) canvas.getWidth(), this.f30278e, this.f30274a);
            canvas.drawRect(this.f30275b, this.f30278e, (float) canvas.getWidth(), (float) canvas.getHeight(), this.f30274a);
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, this.f30276c, this.f30275b, (float) canvas.getHeight(), this.f30274a);
        }
    }

    public final void a(float f2, float f3, float f4, float f5) {
        this.f30275b = f2;
        this.f30276c = f3;
        this.f30277d = f4;
        this.f30278e = f5;
        invalidate();
    }
}
