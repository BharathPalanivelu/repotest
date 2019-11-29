package com.crashlytics.android.c;

class as {

    /* renamed from: a  reason: collision with root package name */
    public final String f6442a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6443b;

    /* renamed from: c  reason: collision with root package name */
    public final StackTraceElement[] f6444c;

    /* renamed from: d  reason: collision with root package name */
    public final as f6445d;

    public as(Throwable th, ar arVar) {
        this.f6442a = th.getLocalizedMessage();
        this.f6443b = th.getClass().getName();
        this.f6444c = arVar.a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f6445d = cause != null ? new as(cause, arVar) : null;
    }
}
