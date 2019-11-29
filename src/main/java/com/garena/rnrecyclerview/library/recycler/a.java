package com.garena.rnrecyclerview.library.recycler;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.garena.rnrecyclerview.library.d.c;
import com.garena.rnrecyclerview.library.d.f;
import java.util.ArrayList;
import java.util.List;

public class a extends RecyclerView.a<d> {

    /* renamed from: a  reason: collision with root package name */
    private final c f8591a;

    /* renamed from: b  reason: collision with root package name */
    private final f f8592b;

    /* renamed from: c  reason: collision with root package name */
    private List<c> f8593c = new ArrayList();

    a(c cVar, f fVar) {
        this.f8591a = cVar;
        this.f8592b = fVar;
    }

    /* access modifiers changed from: package-private */
    public void a(List<c> list) {
        this.f8593c = list;
    }

    /* renamed from: a */
    public d onCreateViewHolder(ViewGroup viewGroup, int i) {
        View a2 = this.f8591a.a(this.f8592b.a(i));
        e eVar = new e(viewGroup.getContext(), this);
        eVar.addView(a2);
        return new d(eVar, a2);
    }

    /* renamed from: a */
    public void onBindViewHolder(d dVar, int i) {
        a(dVar, i, this.f8593c.get(i).f8604e);
    }

    /* renamed from: a */
    public void onBindViewHolder(d dVar, int i, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(dVar, i);
        } else {
            a(dVar, i, (String) list.get(0));
        }
    }

    private void a(d dVar, int i, String str) {
        if (dVar.f8605a instanceof com.garena.rnrecyclerview.library.view.a) {
            com.garena.rnrecyclerview.library.view.a aVar = (com.garena.rnrecyclerview.library.view.a) dVar.f8605a;
            this.f8591a.b(aVar.getViewType(), aVar);
            if (aVar.getInnerRowId() != i) {
                dVar.a();
            }
            aVar.a(i, this.f8593c.get(i).f8602c, this.f8593c.get(i).f8604e);
        }
    }

    public int getItemCount() {
        return this.f8593c.size();
    }

    public int getItemViewType(int i) {
        return this.f8593c.get(i).f8600a;
    }

    public int a(int i) {
        if (i < 0 || i >= this.f8593c.size()) {
            return -1;
        }
        return this.f8593c.get(i).f8603d;
    }

    public c b(int i) {
        return this.f8593c.get(i);
    }
}
