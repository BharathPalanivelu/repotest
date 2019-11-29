package com.crashlytics.android.a;

public class m extends d<m> {

    /* renamed from: a  reason: collision with root package name */
    private final String f6349a;

    public m(String str) {
        if (str != null) {
            this.f6349a = this.f6312b.a(str);
            return;
        }
        throw new NullPointerException("eventName must not be null");
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.f6349a;
    }

    public String toString() {
        return "{eventName:\"" + this.f6349a + '\"' + ", customAttributes:" + this.f6313c + "}";
    }
}
