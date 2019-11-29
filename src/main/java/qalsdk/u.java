package qalsdk;

import com.tencent.qalsdk.util.QLog;
import qalsdk.n;

final class u implements n.a {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ t f34196a;

    u(t tVar) {
        this.f34196a = tVar;
    }

    public final void a(int i, int i2, String str, Object obj) {
        if (str != null && str.length() > 10) {
            str = str.substring(0, 10);
        }
        if (QLog.isColorLevel()) {
            QLog.d("WifiDetector", 2, "WIFI detect onEchoResult, taskId: " + i + " result: " + i2 + " actualContent: " + str);
        }
        t.a(this.f34196a, t.a(this.f34196a, i2), (String) obj);
        t tVar = this.f34196a;
        int unused = tVar.f34192d = tVar.f34192d - (1 << i);
        if (this.f34196a.f34192d == 0) {
            this.f34196a.d();
        }
    }
}
