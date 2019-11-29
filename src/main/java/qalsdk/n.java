package qalsdk;

public abstract class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected int f34172a;

    /* renamed from: b  reason: collision with root package name */
    private a f34173b;

    public interface a {
        void a(int i, int i2, String str, Object obj);
    }

    /* access modifiers changed from: protected */
    public abstract int a(String str);

    /* access modifiers changed from: protected */
    public abstract boolean a();

    /* access modifiers changed from: protected */
    public abstract void b();

    /* access modifiers changed from: protected */
    public abstract String c();

    /* access modifiers changed from: protected */
    public abstract Object d();

    public n(int i, a aVar) {
        this.f34172a = i;
        this.f34173b = aVar;
    }

    public void run() {
        if (!a()) {
            b();
            a aVar = this.f34173b;
            if (aVar != null) {
                aVar.a(this.f34172a, -1, (String) null, d());
                return;
            }
            return;
        }
        String c2 = c();
        if (c2 == null) {
            b();
            a aVar2 = this.f34173b;
            if (aVar2 != null) {
                aVar2.a(this.f34172a, -2, (String) null, d());
                return;
            }
            return;
        }
        int a2 = a(c2);
        b();
        a aVar3 = this.f34173b;
        if (aVar3 != null) {
            aVar3.a(this.f34172a, a2, c2, d());
        }
    }
}
