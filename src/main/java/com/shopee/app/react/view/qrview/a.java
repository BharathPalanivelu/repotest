package com.shopee.app.react.view.qrview;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.shopee.app.react.view.qrview.a.b;
import com.shopee.id.R;
import com.shopee.scanner.ZBarScannerView;
import com.shopee.scanner.d;
import java.util.List;

public class a extends FrameLayout implements LifecycleEventListener, d.b {

    /* renamed from: a  reason: collision with root package name */
    private final EventDispatcher f19085a;

    /* renamed from: b  reason: collision with root package name */
    private ZBarScannerView f19086b;

    /* renamed from: c  reason: collision with root package name */
    private final ThemedReactContext f19087c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19088d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19089e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19090f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f19091g;
    private final Runnable h = new Runnable() {
        public void run() {
            a aVar = a.this;
            aVar.measure(View.MeasureSpec.makeMeasureSpec(aVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(a.this.getHeight(), 1073741824));
            a aVar2 = a.this;
            aVar2.layout(aVar2.getLeft(), a.this.getTop(), a.this.getRight(), a.this.getBottom());
        }
    };

    public void a(int i, int i2) {
    }

    public void setDebug(boolean z) {
    }

    public void setScanningAreaBottomMargin(int i) {
    }

    public a(Context context, ThemedReactContext themedReactContext) {
        super(context);
        this.f19087c = themedReactContext;
        this.f19086b = (ZBarScannerView) LayoutInflater.from(context).inflate(R.layout.layout_zbar_scanner, this, false);
        this.f19086b.setCodeType(2);
        this.f19086b.setListener(this);
        addView(this.f19086b, new FrameLayout.LayoutParams(-1, -1));
        this.f19085a = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.f19091g = true;
    }

    public ThemedReactContext getReactContext() {
        return this.f19087c;
    }

    public void setCodeType(int i) {
        if (i != 0) {
            this.f19086b.setCodeType(2);
        } else {
            this.f19086b.setCodeType(1);
        }
    }

    public void setTorchOn(boolean z) {
        if (this.f19086b != null) {
            this.f19086b.setFlash(z ? 2 : 0);
        }
    }

    public void a() {
        this.f19091g = true;
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.h);
    }

    public void b() {
        ZBarScannerView zBarScannerView = this.f19086b;
        if (zBarScannerView != null) {
            zBarScannerView.a();
            this.f19088d = true;
            this.f19089e = true;
        }
    }

    public void c() {
        if (this.f19089e) {
            this.f19086b.b();
            this.f19089e = false;
            this.f19085a.dispatchEvent(new b(getId()));
        }
    }

    public void onHostResume() {
        if (this.f19088d && !this.f19089e) {
            b();
        }
    }

    public void onHostPause() {
        if (this.f19088d && this.f19089e) {
            c();
        }
    }

    public void onHostDestroy() {
        d();
    }

    public void d() {
        if (!this.f19090f && this.f19086b != null) {
            c();
            this.f19090f = true;
        }
    }

    public void a(List<String> list, List<String> list2) {
        String b2 = b(list, list2);
        if (this.f19091g && !TextUtils.isEmpty(b2)) {
            this.f19085a.dispatchEvent(new com.shopee.app.react.view.qrview.a.a(getId(), b2));
            this.f19091g = false;
        }
    }

    private String b(List<String> list, List<String> list2) {
        if (this.f19086b.getCodeType() == 2) {
            if (!list.isEmpty()) {
                return list.get(0);
            }
            return "";
        } else if (this.f19086b.getCodeType() != 1) {
            if (this.f19086b.getCodeType() == 3) {
                if (!list.isEmpty()) {
                    return list.get(0);
                }
                if (!list2.isEmpty()) {
                    return list2.get(0);
                }
            }
            return "";
        } else if (!list2.isEmpty()) {
            return list2.get(0);
        } else {
            return "";
        }
    }
}
