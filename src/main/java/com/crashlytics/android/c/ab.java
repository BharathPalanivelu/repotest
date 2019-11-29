package com.crashlytics.android.c;

class ab implements ar {

    /* renamed from: a  reason: collision with root package name */
    private final int f6406a;

    /* renamed from: b  reason: collision with root package name */
    private final ar[] f6407b;

    /* renamed from: c  reason: collision with root package name */
    private final ac f6408c;

    public ab(int i, ar... arVarArr) {
        this.f6406a = i;
        this.f6407b = arVarArr;
        this.f6408c = new ac(i);
    }

    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f6406a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (ar arVar : this.f6407b) {
            if (stackTraceElementArr2.length <= this.f6406a) {
                break;
            }
            stackTraceElementArr2 = arVar.a(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.f6406a ? this.f6408c.a(stackTraceElementArr2) : stackTraceElementArr2;
    }
}
