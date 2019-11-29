package butterknife.a;

import android.view.View;

public abstract class a implements View.OnClickListener {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3074a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final Runnable f3075b = $$Lambda$a$tP0vbs2w0lu_2d1hIDuVH_tltU.INSTANCE;

    public abstract void a(View view);

    public final void onClick(View view) {
        if (f3074a) {
            f3074a = false;
            view.post(f3075b);
            a(view);
        }
    }
}
