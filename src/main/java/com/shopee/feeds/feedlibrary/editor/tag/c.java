package com.shopee.feeds.feedlibrary.editor.tag;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.editor.b.a;
import com.shopee.feeds.feedlibrary.editor.b.c;
import com.shopee.feeds.feedlibrary.editor.b.d;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.l;
import com.shopee.feeds.feedlibrary.util.s;
import java.util.ArrayList;

public class c extends com.shopee.feeds.feedlibrary.editor.b.a<a> {

    /* renamed from: e  reason: collision with root package name */
    private c.a f28021e = new c.a() {
        public void a() {
        }

        public void b() {
        }

        public void d() {
        }

        public void c() {
            e.o();
        }

        public void a(String str, float f2, float f3) {
            float measuredWidth = (float) c.this.f27913b.getMeasuredWidth();
            float measuredHeight = (float) c.this.f27913b.getMeasuredHeight();
            if (str != null && measuredWidth > BitmapDescriptorFactory.HUE_RED && measuredHeight > BitmapDescriptorFactory.HUE_RED) {
                for (int i = 0; i < c.this.f27915d.size(); i++) {
                    if (((a) c.this.f27915d.get(i)).g().equals(str)) {
                        ((a) c.this.f27915d.get(i)).a(f2);
                        ((a) c.this.f27915d.get(i)).b(f3);
                        ((a) c.this.f27915d.get(i)).c(f2 / measuredWidth);
                        ((a) c.this.f27915d.get(i)).d(f3 / measuredHeight);
                    }
                }
            }
        }

        public void a(com.shopee.feeds.feedlibrary.editor.b.b bVar) {
            try {
                c.this.b((a) bVar);
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private boolean f28022f = true;

    /* renamed from: g  reason: collision with root package name */
    private a f28023g;

    public interface a {
        void a();
    }

    public interface b<T> extends a.C0429a<T> {
        void a();
    }

    public c(d dVar, a aVar) {
        super(dVar);
        this.f28023g = aVar;
    }

    public void a(a aVar) {
        super.a(aVar);
        this.f28023g.a();
    }

    public void b(a aVar) {
        if (this.f27915d.size() < this.f27912a) {
            this.f27915d.add(aVar);
            this.f27914c.b(aVar);
            this.f28023g.a();
        }
    }

    public void c(a aVar) {
        this.f27915d.remove(a(aVar.g()));
        this.f27914c.a(aVar);
        this.f28023g.a();
    }

    public void a(ArrayList<a> arrayList) {
        super.a(arrayList);
        this.f28023g.a();
        if (this.f27914c instanceof b) {
            ((b) this.f27914c).a();
        }
    }

    /* renamed from: d */
    public void b(a aVar) {
        super.b(aVar);
        this.f28023g.a();
    }

    public void c() {
        super.c();
        this.f28023g.a();
        if (this.f27914c instanceof b) {
            ((b) this.f27914c).a();
        }
    }

    public boolean e() {
        return this.f27915d.size() < d();
    }

    public void a(boolean z) {
        this.f28022f = z;
    }

    public void a(b bVar) {
        this.f27914c = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void f(a aVar) {
        float f2;
        float f3;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (j.a().w()) {
            this.f28022f = false;
        }
        d dVar = new d(this.f27913b.getContext(), this.f28022f);
        if (aVar.m() == 1) {
            e eVar = new e(this.f27913b.getContext());
            eVar.setTagInfo((b) aVar);
            dVar.setContainer(eVar);
        }
        dVar.setGestureListener(this.f28021e);
        dVar.setInfo(aVar);
        this.f27913b.a((View) dVar, (ViewGroup.LayoutParams) layoutParams);
        dVar.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        dVar.getMeasuredHeight();
        float containerWidth = dVar.getContainerWidth() / 2.0f;
        float triangleWidth = (dVar.getTriangleWidth() / 2.0f) - containerWidth;
        float triangleWidth2 = containerWidth - (dVar.getTriangleWidth() / 2.0f);
        if (j.a().w()) {
            aVar.a((float) (s.a(dVar.getContext()) / 2));
            aVar.b((float) l.a(54, dVar.getContext()));
        }
        float f4 = BitmapDescriptorFactory.HUE_RED;
        if (aVar.a() - containerWidth < BitmapDescriptorFactory.HUE_RED) {
            f2 = -dVar.getTagMargin();
            f4 = Math.max(aVar.a() - containerWidth, triangleWidth);
        } else if (aVar.a() + containerWidth > aVar.e()) {
            float e2 = (aVar.e() - ((float) dVar.getMeasuredWidth())) + dVar.getTagMargin();
            f4 = Math.min((containerWidth - aVar.e()) + aVar.a(), triangleWidth2);
            f2 = e2;
        } else {
            f2 = (aVar.a() - containerWidth) - dVar.getTagMargin();
        }
        if (aVar.b() <= ((aVar.f() - dVar.getTagMargin()) - dVar.getContainerHeight()) - dVar.getTriangleHeight()) {
            dVar.a(false);
            f3 = (aVar.b() - dVar.getTagMargin()) + dVar.getTriangleHeight();
        } else {
            dVar.a(true);
            f3 = ((aVar.b() - dVar.getTagMargin()) - dVar.getContainerHeight()) - dVar.getTriangleHeight();
        }
        dVar.setX(f2);
        dVar.setY(f3);
        dVar.setTriangleTransition(f4);
        dVar.a();
        e.n();
    }
}
