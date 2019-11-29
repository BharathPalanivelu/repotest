package androidx.l;

import android.view.View;
import android.view.ViewGroup;
import androidx.l.k;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f2503a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f2504b;

    public void a() {
        if (a(this.f2503a) == this) {
            Runnable runnable = this.f2504b;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    static void a(View view, m mVar) {
        view.setTag(k.a.transition_current_scene, mVar);
    }

    static m a(View view) {
        return (m) view.getTag(k.a.transition_current_scene);
    }
}
