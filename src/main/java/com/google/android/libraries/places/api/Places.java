package com.google.android.libraries.places.api;

import android.content.Context;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.aw;
import com.google.android.libraries.places.internal.dw;
import com.google.android.libraries.places.internal.dx;
import com.google.android.libraries.places.internal.fx;
import com.google.android.libraries.places.internal.go;
import java.util.Locale;

public final class Places {

    /* renamed from: a  reason: collision with root package name */
    private static final aw f12320a = new aw();

    private Places() {
    }

    public static void initialize(Context context, String str) {
        try {
            a(context, str, (Locale) null, false);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public static synchronized void initialize(Context context, String str, Locale locale) {
        synchronized (Places.class) {
            try {
                a(context, str, locale, false);
            } catch (Error | RuntimeException e2) {
                dx.a(e2);
                throw e2;
            }
        }
    }

    private static synchronized void a(Context context, String str, Locale locale, boolean z) {
        synchronized (Places.class) {
            try {
                go.a(context, (Object) "Application context must not be null.");
                go.a(str, (Object) "API Key must not be null.");
                go.a(!str.isEmpty(), (Object) "API Key must not be empty.");
                dx.a(context.getApplicationContext());
                f12320a.a(str, locale, false);
            } catch (Error | RuntimeException e2) {
                dx.a(e2);
                throw e2;
            }
        }
    }

    public static synchronized boolean isInitialized() {
        boolean a2;
        synchronized (Places.class) {
            try {
                a2 = f12320a.a();
            } catch (Error | RuntimeException e2) {
                dx.a(e2);
                throw e2;
            }
        }
        return a2;
    }

    public static synchronized PlacesClient createClient(Context context) {
        PlacesClient a2;
        synchronized (Places.class) {
            try {
                go.a(context, (Object) "Context must not be null.");
                a2 = a(context, dw.a(context).b());
            } catch (Error | RuntimeException e2) {
                dx.a(e2);
                throw e2;
            }
        }
        return a2;
    }

    public static synchronized PlacesClient a(Context context, dw dwVar) {
        PlacesClient a2;
        synchronized (Places.class) {
            try {
                go.a(context, (Object) "Context must not be null.");
                go.a(dwVar, (Object) "ClientProfile must not be null.");
                go.b(isInitialized(), (Object) "Places must be initialized first.");
                a2 = fx.c().b(context).a(f12320a).a(dwVar).a().a();
            } catch (Error | RuntimeException e2) {
                dx.a(e2);
                throw e2;
            }
        }
        return a2;
    }
}
