package com.squareup.a;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class h implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    final aa f30550a;

    /* renamed from: b  reason: collision with root package name */
    final WeakReference<ImageView> f30551b;

    /* renamed from: c  reason: collision with root package name */
    Object f30552c;

    /* renamed from: d  reason: collision with root package name */
    e f30553d;

    h(aa aaVar, ImageView imageView, e eVar) {
        this.f30550a = aaVar;
        this.f30551b = new WeakReference<>(imageView);
        this.f30553d = eVar;
        if (Build.VERSION.SDK_INT < 12 || imageView.getWindowToken() != null) {
            imageView.getViewTreeObserver().addOnPreDrawListener(this);
        } else {
            this.f30552c = a.a((View) imageView, this);
        }
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f30551b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0 && !imageView.isLayoutRequested()) {
            viewTreeObserver.removeOnPreDrawListener(this);
            this.f30551b.clear();
            this.f30550a.b().b(width, height).a(imageView, this.f30553d);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f30550a.c();
        this.f30553d = null;
        ImageView imageView = (ImageView) this.f30551b.get();
        if (imageView != null) {
            this.f30551b.clear();
            Object obj = this.f30552c;
            if (obj != null) {
                a.a((View) imageView, obj);
                this.f30552c = null;
                return;
            }
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }

    static class a {
        static Object a(View view, final h hVar) {
            AnonymousClass1 r0 = new View.OnAttachStateChangeListener() {
                public void onViewDetachedFromWindow(View view) {
                }

                public void onViewAttachedToWindow(View view) {
                    view.removeOnAttachStateChangeListener(this);
                    view.getViewTreeObserver().addOnPreDrawListener(hVar);
                    hVar.f30552c = null;
                }
            };
            view.addOnAttachStateChangeListener(r0);
            return r0;
        }

        static void a(View view, Object obj) {
            view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) obj);
        }
    }
}
