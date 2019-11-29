package com.shopee.navigator.a;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.widget.Toast;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<a> f30116a;

    private b(a aVar) {
        this.f30116a = aVar.f30117a;
    }

    public boolean a(int i) {
        a aVar = this.f30116a.get(i);
        return aVar != null && aVar.a();
    }

    public void a(Activity activity, int i) {
        a aVar = this.f30116a.get(i);
        if (aVar == null) {
            a((Context) activity);
        } else {
            aVar.a(activity);
        }
    }

    public void b(Activity activity, int i) {
        a aVar = this.f30116a.get(i);
        if (aVar == null) {
            a((Context) activity);
        } else {
            aVar.b(activity);
        }
    }

    private void a(Context context) {
        Toast.makeText(context, "Feature not available", 0).show();
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public SparseArray<a> f30117a = new SparseArray<>();

        public a a(int i, a aVar) {
            this.f30117a.put(i, aVar);
            return this;
        }

        public b a() {
            return new b(this);
        }
    }
}
