package com.shopee.app.ui.scanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import com.garena.android.appkit.f.f;
import com.garena.android.gpns.utility.CONSTANT;
import com.google.zxing.BBQRScannerControl;
import com.google.zxing.a;
import com.google.zxing.w;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.ui.a.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;

public class d extends FrameLayout implements a, r {

    /* renamed from: a  reason: collision with root package name */
    BBQRScannerControl f24992a;

    /* renamed from: b  reason: collision with root package name */
    ak f24993b;

    /* renamed from: c  reason: collision with root package name */
    com.shopee.app.ui.common.r f24994c;

    /* renamed from: d  reason: collision with root package name */
    Activity f24995d;

    public d(Context context) {
        super(context);
        ((c) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24992a.setOrientation(1);
        this.f24992a.setCodeType(1);
        this.f24992a.setScannerListener(this);
        f.a().a(new Runnable() {
            public void run() {
                if (d.this.f24992a != null) {
                    d.this.f24995d.finish();
                }
            }
        }, CONSTANT.TIME.MIN_1);
    }

    public void b() {
        this.f24992a.onShow(0);
    }

    public void c() {
        this.f24992a.onHide();
    }

    public void d() {
        this.f24992a.onDestroy();
    }

    public void a(w wVar, String str) {
        Intent intent = new Intent();
        intent.putExtra(AbTestingModule.KEY_RESULT, str);
        this.f24995d.setResult(-1, intent);
        this.f24995d.finish();
    }
}
