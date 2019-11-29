package com.shopee.app.ui.common.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.shopee.app.ui.common.scrollview.a.b;
import d.d.b.j;
import java.util.LinkedList;

public final class BaseNestedScrollView extends NestedScrollView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<b> f21335a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedList<com.shopee.app.ui.common.scrollview.a.a> f21336b;

    /* renamed from: c  reason: collision with root package name */
    private final NestedScrollView.b f21337c;

    public BaseNestedScrollView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public BaseNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseNestedScrollView(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseNestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        this.f21335a = new LinkedList<>();
        this.f21336b = new LinkedList<>();
        this.f21337c = new a(this);
        setOnScrollChangeListener(this.f21337c);
    }

    static final class a implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseNestedScrollView f21338a;

        a(BaseNestedScrollView baseNestedScrollView) {
            this.f21338a = baseNestedScrollView;
        }

        public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            for (b a2 : this.f21338a.f21335a) {
                a2.a(i, i2, i3, i4);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (com.shopee.app.ui.common.scrollview.a.a a2 : this.f21336b) {
            a2.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        for (com.shopee.app.ui.common.scrollview.a.a b2 : this.f21336b) {
            b2.b();
        }
        super.onDetachedFromWindow();
    }

    public final void a(b bVar) {
        j.b(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f21335a.add(bVar);
    }
}
