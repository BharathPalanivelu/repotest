package eu.davidea.flexibleadapter.common;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SmoothScrollGridLayoutManager extends GridLayoutManager {
    private RecyclerView.s z;

    public void a(RecyclerView recyclerView, RecyclerView.t tVar, int i) {
        this.z.c(i);
        a(this.z);
    }
}
