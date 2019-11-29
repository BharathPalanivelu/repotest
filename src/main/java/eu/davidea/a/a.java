package eu.davidea.a;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import eu.davidea.flexibleadapter.b;

abstract class a extends RecyclerView.w {

    /* renamed from: a  reason: collision with root package name */
    private int f32793a;

    /* renamed from: b  reason: collision with root package name */
    private View f32794b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, b bVar, boolean z) {
        super(z ? new FrameLayout(view.getContext()) : view);
        this.f32793a = -1;
        if (z) {
            this.itemView.setLayoutParams(bVar.n().getLayoutManager().a(view.getLayoutParams()));
            ((FrameLayout) this.itemView).addView(view);
            this.f32794b = view;
        }
    }

    public View g() {
        View view = this.f32794b;
        return view != null ? view : this.itemView;
    }

    public int h() {
        int adapterPosition = getAdapterPosition();
        return adapterPosition == -1 ? this.f32793a : adapterPosition;
    }

    public void b(int i) {
        this.f32793a = i;
    }
}
