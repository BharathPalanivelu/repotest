package com.google.firebase.iid;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class aq implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstanceId f14126a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14127b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14128c;

    aq(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.f14126a = firebaseInstanceId;
        this.f14127b = str;
        this.f14128c = str2;
    }

    public final Object then(Task task) {
        return this.f14126a.a(this.f14127b, this.f14128c, task);
    }
}
