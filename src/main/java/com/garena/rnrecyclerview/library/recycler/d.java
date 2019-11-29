package com.garena.rnrecyclerview.library.recycler;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.views.image.ReactImageView;
import com.garena.rnrecyclerview.library.a.a;
import com.garena.rnrecyclerview.library.d.e;
import java.util.List;

public class d extends RecyclerView.w {

    /* renamed from: a  reason: collision with root package name */
    public final View f8605a;

    /* renamed from: b  reason: collision with root package name */
    private List<View> f8606b;

    public d(View view, View view2) {
        super(view);
        this.f8605a = view2;
    }

    public void a() {
        if (this.f8606b != null) {
            b();
            return;
        }
        View view = this.f8605a;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                this.f8606b = e.a(viewGroup, "clear-image");
                b();
            }
        }
    }

    private void b() {
        for (View next : this.f8606b) {
            if (next instanceof ReactImageView) {
                a.a((ReactImageView) next, "");
            }
        }
    }
}
