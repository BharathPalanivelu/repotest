package com.garena.rnrecyclerview.library.sticky.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.garena.rnrecyclerview.library.d.c;
import com.garena.rnrecyclerview.library.d.d;
import eu.davidea.flexibleadapter.b.b;
import java.util.List;

public class a extends b<C0149a> {

    /* renamed from: a  reason: collision with root package name */
    public final String f8614a;

    /* renamed from: b  reason: collision with root package name */
    public final d f8615b;
    private final c h;
    private final int i;

    public a(String str, int i2, d dVar, c cVar) {
        this.f8614a = str;
        this.i = i2;
        this.f8615b = dVar;
        this.h = cVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f8614a.equals(((a) obj).f8614a);
        }
        return false;
    }

    public int a() {
        return this.f8615b.f8566b;
    }

    public int hashCode() {
        return this.f8614a.hashCode();
    }

    /* renamed from: a */
    public C0149a b(eu.davidea.flexibleadapter.b bVar, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new C0149a(this.h.a(this.f8615b.f8565a), bVar);
    }

    public void a(eu.davidea.flexibleadapter.b bVar, C0149a aVar, int i2, List list) {
        if (aVar.itemView instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) aVar.itemView;
            com.garena.rnrecyclerview.library.view.a a2 = aVar.f8616a;
            if (frameLayout.getChildCount() == 0 && !(a2.getParent() instanceof com.garena.rnrecyclerview.library.sticky.views.a)) {
                ((ViewGroup) a2.getParent()).removeView(a2);
                frameLayout.addView(a2);
            }
            a2.a(this.i, this.f8614a, "");
        }
    }

    /* renamed from: com.garena.rnrecyclerview.library.sticky.a.a$a  reason: collision with other inner class name */
    public static class C0149a extends eu.davidea.a.b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.garena.rnrecyclerview.library.view.a f8616a;

        public C0149a(View view, eu.davidea.flexibleadapter.b bVar) {
            super(view, bVar, true);
            this.f8616a = (com.garena.rnrecyclerview.library.view.a) view;
        }
    }
}
