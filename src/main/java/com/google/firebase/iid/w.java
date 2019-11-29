package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.firebase_messaging.zze;

final class w extends zze {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ x f14181a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    w(x xVar, Looper looper) {
        super(looper);
        this.f14181a = xVar;
    }

    public final void handleMessage(Message message) {
        this.f14181a.a(message);
    }
}
