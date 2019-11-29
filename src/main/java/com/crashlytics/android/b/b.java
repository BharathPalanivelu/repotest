package com.crashlytics.android.b;

import android.annotation.TargetApi;
import android.app.Activity;
import io.a.a.a.a;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private final a.b f6379a = new a.b() {
        public void a(Activity activity) {
            if (b.this.a()) {
                b.this.f6380b.submit(new Runnable() {
                    public void run() {
                        b.this.c();
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f6380b;

    public b(a aVar, ExecutorService executorService) {
        this.f6380b = executorService;
        aVar.a(this.f6379a);
    }
}
