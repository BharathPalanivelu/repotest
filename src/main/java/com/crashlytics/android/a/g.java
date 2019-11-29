package com.crashlytics.android.a;

import android.content.Context;
import android.os.Looper;
import io.a.a.a.a.b.t;
import io.a.a.a.a.f.a;
import java.io.IOException;

class g {

    /* renamed from: a  reason: collision with root package name */
    final Context f6334a;

    /* renamed from: b  reason: collision with root package name */
    final a f6335b;

    public g(Context context, a aVar) {
        this.f6334a = context;
        this.f6335b = aVar;
    }

    public z a() throws IOException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return new z(this.f6334a, new af(), new t(), new io.a.a.a.a.d.g(this.f6334a, this.f6335b.a(), "session_analytics.tap", "session_analytics_to_send"));
        }
        throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
    }
}
