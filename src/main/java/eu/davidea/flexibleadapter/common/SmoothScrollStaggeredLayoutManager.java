package eu.davidea.flexibleadapter.common;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class SmoothScrollStaggeredLayoutManager extends StaggeredGridLayoutManager {
    private RecyclerView.s i;

    public void a(RecyclerView recyclerView, RecyclerView.t tVar, int i2) {
        this.i.c(i2);
        a(this.i);
    }
}
