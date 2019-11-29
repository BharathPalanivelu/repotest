package com.firebase.jobdispatcher;

import android.os.Bundle;
import java.util.Arrays;
import org.json.JSONObject;

final class q implements r {

    /* renamed from: a  reason: collision with root package name */
    private final String f7223a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7224b;

    /* renamed from: c  reason: collision with root package name */
    private final u f7225c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f7226d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7227e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f7228f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f7229g;
    private final x h;
    private final boolean i;
    private final z j;

    private q(a aVar) {
        this.f7223a = aVar.f7230a;
        this.f7224b = aVar.f7231b;
        this.f7225c = aVar.f7232c;
        this.h = aVar.h;
        this.f7226d = aVar.f7233d;
        this.f7227e = aVar.f7234e;
        this.f7228f = aVar.f7235f;
        this.f7229g = aVar.f7236g;
        this.i = aVar.i;
        this.j = aVar.j;
    }

    public String i() {
        return this.f7224b;
    }

    public String e() {
        return this.f7223a;
    }

    public u f() {
        return this.f7225c;
    }

    public int g() {
        return this.f7227e;
    }

    public boolean h() {
        return this.f7226d;
    }

    public int[] a() {
        return this.f7228f;
    }

    public Bundle b() {
        return this.f7229g;
    }

    public x c() {
        return this.h;
    }

    public boolean d() {
        return this.i;
    }

    static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f7230a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f7231b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public u f7232c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f7233d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f7234e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int[] f7235f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final Bundle f7236g = new Bundle();
        /* access modifiers changed from: private */
        public x h;
        /* access modifiers changed from: private */
        public boolean i;
        /* access modifiers changed from: private */
        public z j;

        a() {
        }

        /* access modifiers changed from: package-private */
        public q a() {
            if (this.f7230a != null && this.f7231b != null && this.f7232c != null) {
                return new q(this);
            }
            throw new IllegalArgumentException("Required fields were not populated.");
        }

        public a a(String str) {
            this.f7230a = str;
            return this;
        }

        public a b(String str) {
            this.f7231b = str;
            return this;
        }

        public a a(u uVar) {
            this.f7232c = uVar;
            return this;
        }

        public a a(boolean z) {
            this.f7233d = z;
            return this;
        }

        public a a(int i2) {
            this.f7234e = i2;
            return this;
        }

        public a a(int[] iArr) {
            this.f7235f = iArr;
            return this;
        }

        public a a(Bundle bundle) {
            if (bundle != null) {
                this.f7236g.putAll(bundle);
            }
            return this;
        }

        public a a(x xVar) {
            this.h = xVar;
            return this;
        }

        public a b(boolean z) {
            this.i = z;
            return this;
        }

        public a a(z zVar) {
            this.j = zVar;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        q qVar = (q) obj;
        if (!this.f7223a.equals(qVar.f7223a) || !this.f7224b.equals(qVar.f7224b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f7223a.hashCode() * 31) + this.f7224b.hashCode();
    }

    public String toString() {
        return "JobInvocation{tag='" + JSONObject.quote(this.f7223a) + '\'' + ", service='" + this.f7224b + '\'' + ", trigger=" + this.f7225c + ", recurring=" + this.f7226d + ", lifetime=" + this.f7227e + ", constraints=" + Arrays.toString(this.f7228f) + ", extras=" + this.f7229g + ", retryStrategy=" + this.h + ", replaceCurrent=" + this.i + ", triggerReason=" + this.j + '}';
    }
}
