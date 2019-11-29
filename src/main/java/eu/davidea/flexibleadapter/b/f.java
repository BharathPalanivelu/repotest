package eu.davidea.flexibleadapter.b;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.w;
import eu.davidea.flexibleadapter.b;
import java.util.List;

public interface f<VH extends RecyclerView.w> {
    int a();

    void a(b bVar, VH vh, int i, List list);

    void a(boolean z);

    VH b(b bVar, LayoutInflater layoutInflater, ViewGroup viewGroup);

    boolean b();

    boolean c();

    boolean d();

    boolean e();

    boolean f();
}
