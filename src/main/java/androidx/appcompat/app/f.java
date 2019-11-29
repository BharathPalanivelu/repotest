package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.b;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.Toolbar;
import androidx.b.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static int f642a = -100;

    /* renamed from: b  reason: collision with root package name */
    private static final b<WeakReference<f>> f643b = new b<>();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f644c = new Object();

    public abstract a a();

    public abstract androidx.appcompat.view.b a(b.a aVar);

    public void a(int i) {
    }

    public void a(Context context) {
    }

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(Toolbar toolbar);

    public abstract void a(CharSequence charSequence);

    public abstract MenuInflater b();

    public abstract <T extends View> T b(int i);

    public abstract void b(Bundle bundle);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void c();

    public abstract void c(int i);

    public abstract void c(Bundle bundle);

    public abstract void d();

    public abstract boolean d(int i);

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract b.a h();

    public abstract void i();

    public int j() {
        return -100;
    }

    public static f a(Activity activity, e eVar) {
        return new AppCompatDelegateImpl(activity, eVar);
    }

    public static f a(Dialog dialog, e eVar) {
        return new AppCompatDelegateImpl(dialog, eVar);
    }

    f() {
    }

    public static int k() {
        return f642a;
    }

    static void a(f fVar) {
        synchronized (f644c) {
            c(fVar);
            f643b.add(new WeakReference(fVar));
        }
    }

    static void b(f fVar) {
        synchronized (f644c) {
            c(fVar);
        }
    }

    private static void c(f fVar) {
        synchronized (f644c) {
            Iterator<WeakReference<f>> it = f643b.iterator();
            while (it.hasNext()) {
                f fVar2 = (f) it.next().get();
                if (fVar2 == fVar || fVar2 == null) {
                    it.remove();
                }
            }
        }
    }
}
