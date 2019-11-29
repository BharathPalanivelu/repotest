package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

public final class b implements n {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView.a f2825a;

    public b(RecyclerView.a aVar) {
        this.f2825a = aVar;
    }

    public void a(int i, int i2) {
        this.f2825a.notifyItemRangeInserted(i, i2);
    }

    public void b(int i, int i2) {
        this.f2825a.notifyItemRangeRemoved(i, i2);
    }

    public void c(int i, int i2) {
        this.f2825a.notifyItemMoved(i, i2);
    }

    public void a(int i, int i2, Object obj) {
        this.f2825a.notifyItemRangeChanged(i, i2, obj);
    }
}
