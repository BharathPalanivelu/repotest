package eu.davidea.flexibleadapter.c;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f32861a = -1;

    public static int a(RecyclerView.i iVar) {
        if (iVar instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) iVar).h();
        }
        if (iVar instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) iVar).O();
        }
        return 0;
    }

    public static int b(RecyclerView.i iVar) {
        if (iVar instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) iVar).b((int[]) null)[0];
        }
        return ((LinearLayoutManager) iVar).o();
    }

    public static int c(RecyclerView.i iVar) {
        if (iVar instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) iVar).c((int[]) null)[0];
        }
        return ((LinearLayoutManager) iVar).q();
    }

    public static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }
}
