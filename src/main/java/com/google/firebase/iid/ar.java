package com.google.firebase.iid;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class ar implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstanceId f14129a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14130b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14131c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14132d;

    ar(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.f14129a = firebaseInstanceId;
        this.f14130b = str;
        this.f14131c = str2;
        this.f14132d = str3;
    }

    public final Task then(Object obj) {
        return this.f14129a.b(this.f14130b, this.f14131c, this.f14132d, (String) obj);
    }
}
