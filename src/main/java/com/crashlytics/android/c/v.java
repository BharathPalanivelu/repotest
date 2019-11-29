package com.crashlytics.android.c;

import android.content.Context;
import io.a.a.a.a.b.i;
import io.a.a.a.a.g.o;

class v {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6601a;

    /* renamed from: b  reason: collision with root package name */
    private final o f6602b;

    public v(Context context, o oVar) {
        this.f6601a = context;
        this.f6602b = oVar;
    }

    public String a() {
        return a("com.crashlytics.CrashSubmissionPromptTitle", this.f6602b.f33243a);
    }

    public String b() {
        return a("com.crashlytics.CrashSubmissionPromptMessage", this.f6602b.f33244b);
    }

    public String c() {
        return a("com.crashlytics.CrashSubmissionSendTitle", this.f6602b.f33245c);
    }

    public String d() {
        return a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f6602b.f33249g);
    }

    public String e() {
        return a("com.crashlytics.CrashSubmissionCancelTitle", this.f6602b.f33247e);
    }

    private String a(String str, String str2) {
        return b(i.b(this.f6601a, str), str2);
    }

    private String b(String str, String str2) {
        return a(str) ? str2 : str;
    }

    private boolean a(String str) {
        return str == null || str.length() == 0;
    }
}
