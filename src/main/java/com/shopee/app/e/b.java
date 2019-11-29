package com.shopee.app.e;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.util.bj;
import d.d.b.j;
import d.p;

public final class b {
    public static final void a(View view) {
        j.b(view, "$this$gone");
        view.setVisibility(8);
    }

    public static final void b(View view) {
        j.b(view, "$this$visible");
        view.setVisibility(0);
    }

    public static final void c(View view) {
        j.b(view, "$this$disable");
        view.setEnabled(false);
    }

    public static final void d(View view) {
        j.b(view, "$this$enable");
        view.setEnabled(true);
    }

    public static final void a(View view, boolean z) {
        j.b(view, "$this$setVisisble");
        if (z) {
            b(view);
        } else {
            a(view);
        }
    }

    public static final void a(View view, int[] iArr, AttributeSet attributeSet, d.d.a.b<? super TypedArray, p> bVar) {
        j.b(view, "$this$injectAttr");
        j.b(iArr, "intArray");
        j.b(bVar, "block");
        Context context = view.getContext();
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, iArr) : null;
        if (obtainStyledAttributes != null) {
            bVar.a(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d.d.a.b f17468a;

        a(d.d.a.b bVar) {
            this.f17468a = bVar;
        }

        public final void onClick(View view) {
            this.f17468a.a(view);
        }
    }

    public static final void a(View view, d.d.a.b<? super View, p> bVar) {
        j.b(view, "$this$setOnClickListenerWithDebounce");
        j.b(bVar, "block");
        bj.a(view, (View.OnClickListener) new a(bVar));
    }
}
