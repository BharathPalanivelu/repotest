package com.shopee.app.ui.webview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.viewpager.widget.ViewPager;
import com.shopee.app.application.ar;
import com.shopee.app.ui.common.WebPageScrollView;

public class TouchWebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    public float f25803a = getResources().getDisplayMetrics().density;

    /* renamed from: b  reason: collision with root package name */
    public g f25804b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f25805c;

    /* renamed from: d  reason: collision with root package name */
    private WebPageScrollView f25806d;

    /* renamed from: e  reason: collision with root package name */
    private WebViewClient f25807e;

    /* renamed from: f  reason: collision with root package name */
    private int f25808f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f25809g = -1;
    private long h = -1;
    private int[] i = new int[2];
    private int[] j = new int[2];
    private boolean k = false;
    /* access modifiers changed from: private */
    public boolean l = false;
    /* access modifiers changed from: private */
    public boolean m = false;
    private long n = 0;
    private int[] o = new int[2];

    public TouchWebView(Context context) {
        super(context);
        b();
    }

    public TouchWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public TouchWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void b() {
        setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (!TouchWebView.this.f25804b.o()) {
                    return false;
                }
                TouchWebView.this.setHapticFeedbackEnabled(false);
                if (TouchWebView.this.m) {
                    boolean unused = TouchWebView.this.m = false;
                    return true;
                }
                boolean unused2 = TouchWebView.this.l = true;
                TouchWebView.this.performHapticFeedback(0, 1);
                return false;
            }
        });
        if (Build.VERSION.SDK_INT >= 24) {
            ((ar) ar.a()).h();
        }
    }

    public boolean a() {
        return this.f25805c != null;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        this.f25807e = webViewClient;
    }

    public WebViewClient getWebViewClient() {
        return this.f25807e;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewPager) {
                this.f25805c = (ViewPager) parent;
                return;
            }
            if (parent instanceof WebPageScrollView) {
                this.f25806d = (WebPageScrollView) parent;
            }
        }
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        this.n = System.currentTimeMillis();
        this.k = true;
        if (!(i2 == i4 && i3 == i5)) {
            this.f25804b.a((int) (((float) i3) / this.f25803a));
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    private void a(MotionEvent motionEvent, int[] iArr) {
        getLocationOnScreen(iArr);
        float rawX = ((float) ((int) motionEvent.getRawX())) - ((float) iArr[0]);
        float f2 = this.f25803a;
        iArr[0] = (int) (rawX / f2);
        iArr[1] = (int) ((((float) ((int) motionEvent.getRawY())) - ((float) iArr[1])) / f2);
    }

    private void setAllowParentInterceptTouch(boolean z) {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(!z);
        }
    }

    private void setAllowReload(boolean z) {
        g gVar = this.f25804b;
        gVar.z = z;
        gVar.requestDisallowInterceptTouchEvent(!z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f25804b == null) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        a(motionEvent, this.j);
        int[] iArr = this.j;
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (!this.f25804b.b(i2, i3)) {
            if (action == 0) {
                int[] iArr2 = this.o;
                iArr2[0] = i2;
                iArr2[1] = i3;
            } else if (action == 1) {
                int[] iArr3 = this.o;
                if (iArr3[0] - i2 > 30 && Math.abs(iArr3[1] - i3) < 20) {
                    this.f25804b.K();
                }
            }
        }
        if (action == 0) {
            if (this.f25804b.b(i2, i3)) {
                setAllowReload(false);
                setAllowParentInterceptTouch(false);
            } else {
                setAllowReload(true);
            }
        } else if (action == 1 || action == 3) {
            setAllowReload(true);
            setAllowParentInterceptTouch(true);
        }
        if (action == 0) {
            int[] iArr4 = this.i;
            iArr4[0] = i2;
            iArr4[1] = i3;
            WebPageScrollView webPageScrollView = this.f25806d;
            if (webPageScrollView != null) {
                this.f25808f = webPageScrollView.getScrollY();
                this.f25809g = (int) motionEvent.getRawY();
                this.h = System.currentTimeMillis();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        }
        if (action == 2) {
            WebPageScrollView webPageScrollView2 = this.f25806d;
            if (webPageScrollView2 != null) {
                int i4 = this.f25808f;
                if (!(i4 == -1 || this.f25809g == -1)) {
                    webPageScrollView2.scrollTo(0, i4 - ((int) (motionEvent.getRawY() - ((float) this.f25809g))));
                }
            }
        }
        if (action != 1) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.f25806d != null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.h);
            if (currentTimeMillis == 0) {
                currentTimeMillis = 1;
            }
            int i5 = ((-((int) (motionEvent.getRawY() - ((float) this.f25809g)))) * 1000) / currentTimeMillis;
            if (((float) Math.abs(i5)) > this.f25803a * 10.0f) {
                this.f25806d.fling(i5);
                return super.onTouchEvent(motionEvent);
            }
        }
        if (!this.f25804b.o()) {
            return super.onTouchEvent(motionEvent);
        }
        this.h = -1;
        this.f25808f = -1;
        this.f25809g = -1;
        if (this.k && System.currentTimeMillis() - this.n > 200) {
            this.k = false;
        }
        if (this.k || this.l) {
            this.k = false;
            this.l = false;
            return super.onTouchEvent(motionEvent);
        } else if (Math.abs(i2 - this.i[0]) > 10 || Math.abs(i3 - this.i[1]) > 10) {
            return super.onTouchEvent(motionEvent);
        } else {
            this.f25804b.a(i2, i3);
            this.m = true;
            return true;
        }
    }
}
