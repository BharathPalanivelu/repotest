package f.a.a;

import f.m;

public final class e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final m<T> f32876a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f32877b;

    public static <T> e<T> a(Throwable th) {
        if (th != null) {
            return new e<>((m) null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> e<T> a(m<T> mVar) {
        if (mVar != null) {
            return new e<>(mVar, (Throwable) null);
        }
        throw new NullPointerException("response == null");
    }

    private e(m<T> mVar, Throwable th) {
        this.f32876a = mVar;
        this.f32877b = th;
    }
}
