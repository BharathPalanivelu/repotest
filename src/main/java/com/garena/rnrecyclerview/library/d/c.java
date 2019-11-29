package com.garena.rnrecyclerview.library.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, List<View>> f8564a = new HashMap();

    public void a(String str, View view) {
        if (!this.f8564a.containsKey(str)) {
            this.f8564a.put(str, new ArrayList());
        }
        this.f8564a.get(str).add(view);
    }

    public View a(String str) {
        List list = this.f8564a.get(str);
        View view = (View) list.remove(0);
        if (view.getParent() != null && !(view.getParent() instanceof RecyclerView)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        list.add(view);
        return view;
    }

    public void b(String str, View view) {
        List list = this.f8564a.get(str);
        if (list.remove(view)) {
            list.add(view);
        }
    }

    public void a() {
        this.f8564a.clear();
    }
}
