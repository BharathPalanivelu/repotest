package com.google.android.libraries.places.internal;

import com.android.b.n;
import com.google.android.gms.tasks.TaskCompletionSource;
import org.json.JSONObject;

public final /* synthetic */ class l implements n.b {

    /* renamed from: a  reason: collision with root package name */
    private final gg f12920a;

    /* renamed from: b  reason: collision with root package name */
    private final Class f12921b;

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource f12922c;

    public l(gg ggVar, Class cls, TaskCompletionSource taskCompletionSource) {
        this.f12920a = ggVar;
        this.f12921b = cls;
        this.f12922c = taskCompletionSource;
    }

    public final void onResponse(Object obj) {
        this.f12920a.a(this.f12921b, this.f12922c, (JSONObject) obj);
    }
}
