package io.a.a.a.a.d;

import android.content.Context;

public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f33166a;

    /* renamed from: b  reason: collision with root package name */
    private final e f33167b;

    public i(Context context, e eVar) {
        this.f33166a = context;
        this.f33167b = eVar;
    }

    public void run() {
        try {
            io.a.a.a.a.b.i.a(this.f33166a, "Performing time based file roll over.");
            if (!this.f33167b.c()) {
                this.f33167b.d();
            }
        } catch (Exception e2) {
            io.a.a.a.a.b.i.a(this.f33166a, "Failed to roll over file", (Throwable) e2);
        }
    }
}
