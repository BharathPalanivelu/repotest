package com.garena.rnrecyclerview.library.d;

import android.view.View;
import android.view.ViewGroup;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f8563a;

    public interface a {
        void a(View view);
    }

    private b(a aVar) {
        this.f8563a = aVar;
    }

    public static b a(a aVar) {
        return new b(aVar);
    }

    public void a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            this.f8563a.a(childAt);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt);
            }
        }
    }
}
