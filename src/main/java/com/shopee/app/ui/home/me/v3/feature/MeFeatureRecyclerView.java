package com.shopee.app.ui.home.me.v3.feature;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.ServerProtocol;
import com.garena.android.appkit.tools.c;
import d.d.b.j;
import java.util.List;

public final class MeFeatureRecyclerView extends RecyclerView {
    private e M;

    public MeFeatureRecyclerView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public MeFeatureRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MeFeatureRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeFeatureRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        setNestedScrollingEnabled(false);
        setLayoutManager(new LinearLayoutManager(context));
        a((RecyclerView.h) new a());
    }

    public final void a(i iVar, List<? extends MeFeature> list) {
        j.b(iVar, "metadata");
        j.b(list, "features");
        e eVar = new e(iVar);
        eVar.a(list);
        setAdapter(eVar);
        this.M = eVar;
    }

    public final void y() {
        e eVar = this.M;
        if (eVar != null) {
            eVar.e();
        }
    }

    public static final class a extends RecyclerView.h {
        public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
            j.b(rect, "outRect");
            j.b(view, "view");
            j.b(recyclerView, "parent");
            j.b(tVar, ServerProtocol.DIALOG_PARAM_STATE);
            int f2 = recyclerView.f(view);
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (f2 > 0 && (adapter instanceof e)) {
                e eVar = (e) adapter;
                List d2 = eVar.d();
                j.a((Object) d2, "adapter.itemList");
                MeFeature meFeature = (MeFeature) d.a.j.a(d2, f2 - 1);
                List d3 = eVar.d();
                j.a((Object) d3, "adapter.itemList");
                MeFeature meFeature2 = (MeFeature) d.a.j.a(d3, f2);
                String str = null;
                String group = meFeature != null ? meFeature.getGroup() : null;
                if (meFeature2 != null) {
                    str = meFeature2.getGroup();
                }
                if (!j.a((Object) group, (Object) str)) {
                    rect.top = c.a().a(8);
                } else {
                    rect.top = c.a().a(0);
                }
            }
        }
    }
}
