package com.linecorp.linesdk.a;

import android.content.Context;
import com.linecorp.a.a.a.b;
import java.util.concurrent.Executors;

public final class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final b f15026a = new b("com.linecorp.linesdk.sharedpreference.encryptionsalt");

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f15027b = false;

    public static void a(Context context) {
        if (!f15027b) {
            f15027b = true;
            Executors.newSingleThreadExecutor().execute(new a(context.getApplicationContext()));
        }
    }

    public static b a() {
        return f15026a;
    }

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Context f15028a;

        a(Context context) {
            this.f15028a = context;
        }

        public final void run() {
            c.f15026a.a(this.f15028a);
        }
    }
}
