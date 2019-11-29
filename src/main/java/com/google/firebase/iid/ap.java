package com.google.firebase.iid;

import com.google.android.gms.tasks.Task;

final /* synthetic */ class ap implements u {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstanceId f14121a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14122b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14123c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14124d;

    /* renamed from: e  reason: collision with root package name */
    private final String f14125e;

    ap(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3, String str4) {
        this.f14121a = firebaseInstanceId;
        this.f14122b = str;
        this.f14123c = str2;
        this.f14124d = str3;
        this.f14125e = str4;
    }

    public final Task a() {
        return this.f14121a.a(this.f14122b, this.f14123c, this.f14124d, this.f14125e);
    }
}
