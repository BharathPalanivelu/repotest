package eu.davidea.flexibleadapter.common;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SmoothScrollLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView.s f32862a;

    public void a(RecyclerView recyclerView, RecyclerView.t tVar, int i) {
        this.f32862a.c(i);
        a(this.f32862a);
    }
}
