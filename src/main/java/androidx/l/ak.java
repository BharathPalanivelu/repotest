package androidx.l;

import android.os.IBinder;

class ak implements am {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f2449a;

    ak(IBinder iBinder) {
        this.f2449a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ak) && ((ak) obj).f2449a.equals(this.f2449a);
    }

    public int hashCode() {
        return this.f2449a.hashCode();
    }
}
