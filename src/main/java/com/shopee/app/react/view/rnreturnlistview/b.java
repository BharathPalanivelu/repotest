package com.shopee.app.react.view.rnreturnlistview;

import android.view.View;
import android.widget.FrameLayout;
import com.shopee.app.ui.order.b.c.g;
import d.d.b.j;

public final class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f19096a = new a(this);

    /* renamed from: b  reason: collision with root package name */
    private final a f19097b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(a aVar) {
        super(aVar);
        j.b(aVar, "context");
        this.f19097b = aVar;
        addView(g.a(this.f19097b, false));
    }

    public final a getContext() {
        return this.f19097b;
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.f19096a);
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f19098a;

        a(b bVar) {
            this.f19098a = bVar;
        }

        public final void run() {
            b bVar = this.f19098a;
            bVar.measure(View.MeasureSpec.makeMeasureSpec(bVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f19098a.getHeight(), 1073741824));
            b bVar2 = this.f19098a;
            bVar2.layout(bVar2.getLeft(), this.f19098a.getTop(), this.f19098a.getRight(), this.f19098a.getBottom());
        }
    }
}
