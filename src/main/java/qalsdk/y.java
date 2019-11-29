package qalsdk;

import com.tencent.qalsdk.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import qalsdk.n;

public final class y implements n.a {

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f34203a = new AtomicBoolean(true);

    /* renamed from: b  reason: collision with root package name */
    private AtomicInteger f34204b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    private q[] f34205c = {new r("http://3gimg.qq.com/qq_product_operations/nettest/index.html", "MobileQQ1"), new r("http://3gimg.qq.com/qq_product_operations/nettest/index2.html", "MobileQQ2")};

    public final boolean a() {
        return this.f34203a.get();
    }

    public final void b() {
        if (this.f34204b.get() > 0) {
            QLog.i("XGDetector", 1, "XGDetector running, exit");
            return;
        }
        QLog.i("XGDetector", 1, "start XGDetector");
        this.f34203a.set(true);
        int i = 0;
        this.f34204b.set(0);
        while (true) {
            q[] qVarArr = this.f34205c;
            if (i < qVarArr.length) {
                q qVar = qVarArr[i];
                Runnable runnable = null;
                int i2 = qVar.f34186a;
                if (i2 == 0) {
                    s sVar = (s) qVar;
                    runnable = new p(i, sVar.f34189c, sVar.f34190d, sVar.f34187b, 10000, this);
                } else if (i2 == 2) {
                    runnable = new o(i, ((r) qVar).f34188c, qVar.f34187b, 10000, this);
                }
                if (runnable != null) {
                    Thread thread = new Thread(runnable);
                    thread.setName("XGDetectEchoThread");
                    thread.start();
                    this.f34204b.incrementAndGet();
                }
                i++;
            } else {
                return;
            }
        }
    }

    public final void a(int i, int i2, String str, Object obj) {
        if (i2 != 0) {
            this.f34203a.set(false);
        }
        if (this.f34204b.decrementAndGet() == 0) {
            QLog.i("XGDetector", 1, "XGDetector complete. Result: " + this.f34203a);
        }
    }
}
