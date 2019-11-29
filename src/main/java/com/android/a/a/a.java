package com.android.a.a;

import android.content.Context;
import android.os.RemoteException;

public abstract class a {
    public abstract void a(c cVar);

    public abstract boolean a();

    public abstract void b();

    public abstract d c() throws RemoteException;

    /* renamed from: com.android.a.a.a$a  reason: collision with other inner class name */
    public static final class C0087a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4548a;

        private C0087a(Context context) {
            this.f4548a = context;
        }

        public a a() {
            Context context = this.f4548a;
            if (context != null) {
                return new b(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
    }

    public static C0087a a(Context context) {
        return new C0087a(context);
    }
}
