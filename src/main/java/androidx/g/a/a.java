package androidx.g.a;

import android.os.Bundle;
import androidx.g.b.c;
import androidx.lifecycle.h;
import androidx.lifecycle.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {

    /* renamed from: androidx.g.a.a$a  reason: collision with other inner class name */
    public interface C0049a<D> {
        c<D> a(int i, Bundle bundle);

        void a(c<D> cVar);

        void a(c<D> cVar, D d2);
    }

    public abstract <D> c<D> a(int i, Bundle bundle, C0049a<D> aVar);

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public static <T extends h & t> a a(T t) {
        return new b(t, ((t) t).getViewModelStore());
    }
}
