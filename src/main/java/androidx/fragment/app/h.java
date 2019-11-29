package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    static final f f2174a = new f();

    /* renamed from: b  reason: collision with root package name */
    private f f2175b = null;

    public static abstract class a {
        public void a(h hVar, Fragment fragment) {
        }

        public void a(h hVar, Fragment fragment, Context context) {
        }

        public void a(h hVar, Fragment fragment, Bundle bundle) {
        }

        public void a(h hVar, Fragment fragment, View view, Bundle bundle) {
        }

        public void b(h hVar, Fragment fragment) {
        }

        public void b(h hVar, Fragment fragment, Context context) {
        }

        public void b(h hVar, Fragment fragment, Bundle bundle) {
        }

        public void c(h hVar, Fragment fragment) {
        }

        public void c(h hVar, Fragment fragment, Bundle bundle) {
        }

        public void d(h hVar, Fragment fragment) {
        }

        public void d(h hVar, Fragment fragment, Bundle bundle) {
        }

        public void e(h hVar, Fragment fragment) {
        }

        public void f(h hVar, Fragment fragment) {
        }

        public void g(h hVar, Fragment fragment) {
        }
    }

    public interface b {
        void a();
    }

    public abstract Fragment.SavedState a(Fragment fragment);

    public abstract Fragment a(int i);

    public abstract Fragment a(Bundle bundle, String str);

    public abstract Fragment a(String str);

    public abstract l a();

    public abstract void a(int i, int i2);

    public abstract void a(Bundle bundle, String str, Fragment fragment);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean b();

    public abstract boolean c();

    public abstract List<Fragment> d();

    public abstract boolean f();

    public void a(f fVar) {
        this.f2175b = fVar;
    }

    public f e() {
        if (this.f2175b == null) {
            this.f2175b = f2174a;
        }
        return this.f2175b;
    }
}
