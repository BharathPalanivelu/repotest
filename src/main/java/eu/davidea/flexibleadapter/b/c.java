package eu.davidea.flexibleadapter.b;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.w;
import eu.davidea.flexibleadapter.b.g;

public abstract class c<VH extends RecyclerView.w, H extends g> extends a<VH> implements h<VH, H> {
    protected H h;

    public c(H h2) {
        this.h = h2;
    }

    public H g() {
        return this.h;
    }

    public void a(H h2) {
        this.h = h2;
    }
}
