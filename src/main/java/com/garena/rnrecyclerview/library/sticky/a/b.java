package com.garena.rnrecyclerview.library.sticky.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.garena.rnrecyclerview.library.sticky.d;
import com.garena.rnrecyclerview.library.view.a;
import eu.davidea.flexibleadapter.b.c;
import java.util.List;

public class b extends c<d, eu.davidea.flexibleadapter.b.b> {

    /* renamed from: a  reason: collision with root package name */
    public final String f8617a;

    /* renamed from: b  reason: collision with root package name */
    public final com.garena.rnrecyclerview.library.d.d f8618b;
    private final com.garena.rnrecyclerview.library.d.c i;
    private final int j;

    public b(String str, int i2, com.garena.rnrecyclerview.library.d.d dVar, com.garena.rnrecyclerview.library.d.c cVar, eu.davidea.flexibleadapter.b.b bVar) {
        super(bVar);
        this.f8617a = str;
        this.j = i2;
        this.f8618b = dVar;
        this.i = cVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f8617a.equals(((b) obj).f8617a);
        }
        return false;
    }

    public int a() {
        return this.f8618b.f8566b;
    }

    public int hashCode() {
        return this.f8617a.hashCode();
    }

    /* renamed from: a */
    public d b(eu.davidea.flexibleadapter.b bVar, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View a2 = this.i.a(this.f8618b.f8565a);
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.addView(a2, new FrameLayout.LayoutParams(-2, -2));
        return new d(frameLayout, a2, bVar, false);
    }

    public void a(eu.davidea.flexibleadapter.b bVar, d dVar, int i2, List list) {
        if (dVar.f8635a instanceof a) {
            a aVar = (a) dVar.f8635a;
            if (aVar.getInnerRowId() != i2) {
                dVar.a();
            }
            aVar.a(this.j, this.f8617a, "");
        }
    }
}
