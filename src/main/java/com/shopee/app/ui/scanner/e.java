package com.shopee.app.ui.scanner;

import android.content.Context;
import android.view.View;
import com.google.zxing.BBQRScannerControl;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f24997e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f24998f = new c();

    public e(Context context) {
        super(context);
        e();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.f24997e) {
            this.f24997e = true;
            inflate(getContext(), R.layout.scanner_layout, this);
            this.f24998f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.f24998f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24992a = (BBQRScannerControl) aVar.internalFindViewById(R.id.scan_control);
        a();
    }
}
