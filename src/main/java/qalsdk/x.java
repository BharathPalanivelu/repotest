package qalsdk;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f34201a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    protected q[] f34202b = {new r("http://3gimg.qq.com/qq_product_operations/nettest/index.html", "MobileQQ1"), new r("http://3gimg.qq.com/qq_product_operations/nettest/index2.html", "MobileQQ2")};

    public abstract void a();

    public abstract void a(String str);

    public abstract void b();

    public abstract void b(String str);

    public abstract void c();

    public final synchronized boolean e() {
        return f34201a.get();
    }
}
