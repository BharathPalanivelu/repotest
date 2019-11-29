package a;

public class l<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final k<TResult> f409a = new k<>();

    public k<TResult> a() {
        return this.f409a;
    }

    public boolean b() {
        return this.f409a.j();
    }

    public boolean a(TResult tresult) {
        return this.f409a.b(tresult);
    }

    public boolean a(Exception exc) {
        return this.f409a.b(exc);
    }

    public void c() {
        if (!b()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void b(TResult tresult) {
        if (!a(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void b(Exception exc) {
        if (!a(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
