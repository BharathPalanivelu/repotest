package com.shopee.scanner;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import d.d.b.j;

public final class ZBarScannerView extends d {

    /* renamed from: c  reason: collision with root package name */
    private final f f30271c;

    public ZBarScannerView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public ZBarScannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ZBarScannerView(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZBarScannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        this.f30271c = new f(getCallbackBridge());
    }

    public void a() {
        this.f30271c.a(getContext());
        super.a();
    }

    public void b() {
        this.f30271c.a();
        super.b();
    }

    /* access modifiers changed from: protected */
    public Camera.PreviewCallback getCamera1PreviewCallback() {
        return this.f30271c;
    }
}
