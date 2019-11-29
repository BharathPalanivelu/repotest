package eu.davidea.flexibleadapter;

import android.util.Log;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class e extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32863a = "e";
    public static boolean k = false;

    /* renamed from: b  reason: collision with root package name */
    private Set<Integer> f32864b = new TreeSet();

    /* renamed from: c  reason: collision with root package name */
    private int f32865c = 0;
    protected RecyclerView l;
    protected boolean m = false;
    protected boolean n = false;

    public abstract boolean b(int i);

    public static void c(boolean z) {
        k = z;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.l = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.l = null;
    }

    public RecyclerView n() {
        return this.l;
    }

    public static int a(RecyclerView.i iVar) {
        if (iVar instanceof GridLayoutManager) {
            return ((GridLayoutManager) iVar).b();
        }
        if (iVar instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) iVar).i();
        }
        return 1;
    }

    public int o() {
        return this.f32865c;
    }

    public boolean i(int i) {
        return this.f32864b.contains(Integer.valueOf(i));
    }

    public void c(int i) {
        if (i >= 0) {
            if (this.f32865c == 1) {
                c();
            }
            boolean contains = this.f32864b.contains(Integer.valueOf(i));
            if (contains) {
                k(i);
            } else {
                j(i);
            }
            if (k) {
                String str = f32863a;
                StringBuilder sb = new StringBuilder();
                sb.append("toggleSelection ");
                sb.append(contains ? "removed" : "added");
                sb.append(" on position ");
                sb.append(i);
                sb.append(", current ");
                sb.append(this.f32864b);
                Log.v(str, sb.toString());
            }
        }
    }

    public boolean j(int i) {
        return b(i) && this.f32864b.add(Integer.valueOf(i));
    }

    public boolean k(int i) {
        return this.f32864b.remove(Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public void d(int i, int i2) {
        if (i(i) && !i(i2)) {
            k(i);
            j(i2);
        } else if (!i(i) && i(i2)) {
            k(i2);
            j(i);
        }
    }

    public void c() {
        if (k) {
            String str = f32863a;
            Log.d(str, "clearSelection " + this.f32864b);
        }
        Iterator<Integer> it = this.f32864b.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            it.remove();
            if (i + i2 == intValue) {
                i2++;
            } else {
                a(i, i2);
                i = intValue;
                i2 = 1;
            }
        }
        a(i, i2);
    }

    private void a(int i, int i2) {
        if (i2 > 0) {
            notifyItemRangeChanged(i, i2, c.SELECTION);
        }
    }

    public int p() {
        return this.f32864b.size();
    }

    public List<Integer> q() {
        return new ArrayList(this.f32864b);
    }
}
