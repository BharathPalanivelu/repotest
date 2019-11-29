package com.shopee.scanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.shopee.scanner.c;
import com.shopee.scanner.camera.CameraView;
import com.shopee.scanner.e;
import java.util.Collections;
import java.util.List;

public abstract class d extends CameraView {

    /* renamed from: c  reason: collision with root package name */
    private final a f30319c;

    /* renamed from: d  reason: collision with root package name */
    private ViewfinderView f30320d;

    /* renamed from: e  reason: collision with root package name */
    private b f30321e;

    /* renamed from: f  reason: collision with root package name */
    private int f30322f;

    /* renamed from: g  reason: collision with root package name */
    private int f30323g;

    public interface b {
        void a(List<String> list, List<String> list2);
    }

    public d(Context context) {
        this(context, (AttributeSet) null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30319c = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.e.ScannerView, i, c.d.Widget_ScannerView);
        this.f30322f = obtainStyledAttributes.getResourceId(c.e.ScannerView_viewfinder, -1);
        setCodeType(obtainStyledAttributes.getInteger(c.e.ScannerView_codeType, 3));
        obtainStyledAttributes.recycle();
        setAutoFocus(true);
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof ViewfinderView) {
            setViewfinder((ViewfinderView) view);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f30322f;
        if (i != -1) {
            View findViewById = findViewById(i);
            if (findViewById instanceof ViewfinderView) {
                setViewfinder((ViewfinderView) findViewById);
            }
        }
        if (this.f30320d != null) {
            d();
            return;
        }
        throw new NullPointerException("Unknown viewfinder!");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float relativeX = this.f30320d.getRelativeX();
        float relativeY = this.f30320d.getRelativeY();
        this.f30321e.a(relativeX, relativeY, ((float) this.f30320d.getWidth()) + relativeX, ((float) this.f30320d.getHeight()) + relativeY);
    }

    public void setCodeType(int i) {
        this.f30323g = i;
    }

    public int getCodeType() {
        return this.f30323g;
    }

    /* access modifiers changed from: protected */
    public e.a getCallbackBridge() {
        return this.f30319c;
    }

    private void d() {
        this.f30321e = new b(getContext());
        addView(this.f30321e, 1, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setViewfinder(ViewfinderView viewfinderView) {
        ViewfinderView viewfinderView2 = this.f30320d;
        if (viewfinderView2 != viewfinderView) {
            if (viewfinderView2 != null) {
                viewfinderView2.setScannerView((d) null);
            }
            this.f30320d = viewfinderView;
            this.f30320d.setScannerView(this);
        }
    }

    public void setListener(b bVar) {
        this.f30319c.a(bVar);
    }

    private class a implements e.a {

        /* renamed from: b  reason: collision with root package name */
        private b f30325b;

        private a() {
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f30325b = bVar;
        }

        public void a(List<String> list, List<String> list2) {
            b bVar = this.f30325b;
            if (bVar != null) {
                if ((d.this.getCodeType() & 2) <= 0) {
                    list = Collections.emptyList();
                }
                if ((d.this.getCodeType() & 1) <= 0) {
                    list2 = Collections.emptyList();
                }
                bVar.a(list, list2);
            }
        }
    }
}
