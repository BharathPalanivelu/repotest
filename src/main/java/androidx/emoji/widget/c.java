package androidx.emoji.widget;

import android.annotation.SuppressLint;
import android.text.Editable;

final class c extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2091a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile Editable.Factory f2092b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f2093c;

    @SuppressLint({"PrivateApi"})
    private c() {
        try {
            f2093c = getClass().getClassLoader().loadClass("android.text.DynamicLayout$ChangeWatcher");
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory a() {
        if (f2092b == null) {
            synchronized (f2091a) {
                if (f2092b == null) {
                    f2092b = new c();
                }
            }
        }
        return f2092b;
    }

    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f2093c;
        if (cls != null) {
            return k.a(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
