package com.garena.rnrecyclerview.library.d;

import android.view.View;
import android.view.ViewGroup;
import com.garena.rnrecyclerview.library.d.b;
import java.util.ArrayList;
import java.util.List;

public class e {
    public static List<View> a(ViewGroup viewGroup, Object obj) {
        a aVar = new a(obj);
        b.a((b.a) aVar).a(viewGroup);
        return aVar.a();
    }

    private static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f8568a;

        /* renamed from: b  reason: collision with root package name */
        private final List<View> f8569b;

        private a(Object obj) {
            this.f8569b = new ArrayList();
            this.f8568a = obj;
        }

        public void a(View view) {
            Object tag = view.getTag();
            if (tag != null && tag.equals(this.f8568a)) {
                this.f8569b.add(view);
            }
        }

        /* access modifiers changed from: private */
        public List<View> a() {
            return this.f8569b;
        }
    }
}
