package com.shopee.app.ui.home.me.v3.feature;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.app.ui.a.y;
import d.d.b.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class e extends y<MeFeature> {

    /* renamed from: c  reason: collision with root package name */
    private final List<MeFeature> f22618c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final i f22619d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(i iVar) {
        super(new g());
        j.b(iVar, "metaData");
        this.f22619d = iVar;
    }

    public void a(List<? extends MeFeature> list) {
        j.b(list, "itemList");
        if (!j.a((Object) this.f22618c, (Object) list)) {
            this.f22618c.clear();
            this.f22618c.addAll(list);
        }
        Collection arrayList = new ArrayList();
        for (Object next : this.f22618c) {
            n a2 = n.f22642a.a(((MeFeature) next).getName());
            if (a2 != null ? a2.a(this.f22619d) : true) {
                arrayList.add(next);
            }
        }
        super.a((List) arrayList);
    }

    public final void e() {
        a(this.f22618c);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i) {
        j.b(wVar, "holder");
        super.onBindViewHolder(wVar, i);
        View view = wVar.itemView;
        j.a((Object) view, "holder?.itemView");
        MeFeature meFeature = (MeFeature) a(i);
        if ((view instanceof h) && meFeature != null) {
            ((h) view).a(this.f22619d, meFeature);
        }
    }
}
