package androidx.core.g;

import android.view.View;
import android.view.ViewGroup;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private int f1796a;

    /* renamed from: b  reason: collision with root package name */
    private int f1797b;

    public q(ViewGroup viewGroup) {
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f1797b = i;
        } else {
            this.f1796a = i;
        }
    }

    public int a() {
        return this.f1796a | this.f1797b;
    }

    public void a(View view) {
        a(view, 0);
    }

    public void a(View view, int i) {
        if (i == 1) {
            this.f1797b = 0;
        } else {
            this.f1796a = 0;
        }
    }
}
