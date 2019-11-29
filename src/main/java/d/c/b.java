package d.c;

import d.a;
import java.io.Closeable;

public final class b {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                a.a(th, th2);
            }
        }
    }
}
