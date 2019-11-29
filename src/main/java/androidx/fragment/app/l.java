package androidx.fragment.app;

import androidx.lifecycle.e;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class l {

    /* renamed from: d  reason: collision with root package name */
    ArrayList<a> f2227d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    int f2228e;

    /* renamed from: f  reason: collision with root package name */
    int f2229f;

    /* renamed from: g  reason: collision with root package name */
    int f2230g;
    int h;
    int i;
    int j;
    boolean k;
    boolean l = true;
    String m;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    boolean t = false;
    ArrayList<Runnable> u;

    public abstract int b();

    public abstract int c();

    public abstract void d();

    public abstract void e();

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f2231a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f2232b;

        /* renamed from: c  reason: collision with root package name */
        int f2233c;

        /* renamed from: d  reason: collision with root package name */
        int f2234d;

        /* renamed from: e  reason: collision with root package name */
        int f2235e;

        /* renamed from: f  reason: collision with root package name */
        int f2236f;

        /* renamed from: g  reason: collision with root package name */
        e.b f2237g;
        e.b h;

        a() {
        }

        a(int i, Fragment fragment) {
            this.f2231a = i;
            this.f2232b = fragment;
            this.f2237g = e.b.RESUMED;
            this.h = e.b.RESUMED;
        }

        a(int i, Fragment fragment, e.b bVar) {
            this.f2231a = i;
            this.f2232b = fragment;
            this.f2237g = fragment.mMaxState;
            this.h = bVar;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f2227d.add(aVar);
        aVar.f2233c = this.f2228e;
        aVar.f2234d = this.f2229f;
        aVar.f2235e = this.f2230g;
        aVar.f2236f = this.h;
    }

    public l a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public l a(int i2, Fragment fragment) {
        a(i2, fragment, (String) null, 1);
        return this;
    }

    public l a(int i2, Fragment fragment, String str) {
        a(i2, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.mFragmentId == 0 || fragment.mFragmentId == i2) {
                fragment.mFragmentId = i2;
                fragment.mContainerId = i2;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
            }
        }
        a(new a(i3, fragment));
    }

    public l a(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    public l b(Fragment fragment) {
        a(new a(6, fragment));
        return this;
    }

    public l c(Fragment fragment) {
        a(new a(7, fragment));
        return this;
    }

    public l a(Fragment fragment, e.b bVar) {
        a(new a(10, fragment, bVar));
        return this;
    }

    public l i() {
        if (!this.k) {
            this.l = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }
}
