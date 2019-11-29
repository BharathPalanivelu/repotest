package com.google.firebase.iid;

import android.os.Handler;
import android.os.Message;

final /* synthetic */ class g implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final h f14153a;

    g(h hVar) {
        this.f14153a = hVar;
    }

    public final boolean handleMessage(Message message) {
        return this.f14153a.a(message);
    }
}
