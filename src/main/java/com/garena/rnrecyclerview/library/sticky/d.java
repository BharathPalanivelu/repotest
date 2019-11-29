package com.garena.rnrecyclerview.library.sticky;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.views.image.ReactImageView;
import com.garena.rnrecyclerview.library.a.a;
import com.garena.rnrecyclerview.library.d.e;
import eu.davidea.a.b;
import java.util.List;

public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public View f8635a;

    public d(View view, View view2, eu.davidea.flexibleadapter.b bVar, boolean z) {
        super(view, bVar, z);
        this.f8635a = view2;
    }

    public void a() {
        if (this.itemView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) this.itemView;
            if (viewGroup.getChildCount() > 0) {
                a(e.a(viewGroup, "clear-image"));
            }
        }
    }

    private void a(List<View> list) {
        if (list != null) {
            for (View next : list) {
                if (next instanceof ReactImageView) {
                    a.a((ReactImageView) next, "");
                }
            }
        }
    }
}
