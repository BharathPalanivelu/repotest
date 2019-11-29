package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public class f extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    g f844a;

    /* renamed from: b  reason: collision with root package name */
    private int f845b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f846c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f847d;

    /* renamed from: e  reason: collision with root package name */
    private final LayoutInflater f848e;

    /* renamed from: f  reason: collision with root package name */
    private final int f849f;

    public long getItemId(int i) {
        return (long) i;
    }

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.f847d = z;
        this.f848e = layoutInflater;
        this.f844a = gVar;
        this.f849f = i;
        b();
    }

    public void a(boolean z) {
        this.f846c = z;
    }

    public int getCount() {
        ArrayList<i> m = this.f847d ? this.f844a.m() : this.f844a.j();
        if (this.f845b < 0) {
            return m.size();
        }
        return m.size() - 1;
    }

    public g a() {
        return this.f844a;
    }

    /* renamed from: a */
    public i getItem(int i) {
        ArrayList<i> m = this.f847d ? this.f844a.m() : this.f844a.j();
        int i2 = this.f845b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return m.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f848e.inflate(this.f849f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f844a.b() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.f846c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        i s = this.f844a.s();
        if (s != null) {
            ArrayList<i> m = this.f844a.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                if (m.get(i) == s) {
                    this.f845b = i;
                    return;
                }
            }
        }
        this.f845b = -1;
    }

    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
