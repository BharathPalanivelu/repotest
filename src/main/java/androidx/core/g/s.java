package androidx.core.g;

import android.view.View;
import android.view.ViewTreeObserver;

public final class s implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f1798a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f1799b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f1800c;

    private s(View view, Runnable runnable) {
        this.f1798a = view;
        this.f1799b = view.getViewTreeObserver();
        this.f1800c = runnable;
    }

    public static s a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            s sVar = new s(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(sVar);
            view.addOnAttachStateChangeListener(sVar);
            return sVar;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public boolean onPreDraw() {
        a();
        this.f1800c.run();
        return true;
    }

    public void a() {
        if (this.f1799b.isAlive()) {
            this.f1799b.removeOnPreDrawListener(this);
        } else {
            this.f1798a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f1798a.removeOnAttachStateChangeListener(this);
    }

    public void onViewAttachedToWindow(View view) {
        this.f1799b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
