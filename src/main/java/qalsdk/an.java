package qalsdk;

import com.tencent.qalsdk.util.QLog;

final class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ am f34114a;

    an(am amVar) {
        this.f34114a = amVar;
    }

    public final void run() {
        try {
            am.a(this.f34114a);
            this.f34114a.f34113g.add(am.b(this.f34114a));
            QLog.d("MSF.C.StatReport", "CollectNetInfo:" + this.f34114a.i);
            if (this.f34114a.i >= 5) {
                this.f34114a.h.removeCallbacks(this.f34114a.f34111a);
                return;
            }
        } catch (Throwable th) {
            QLog.e("MSF.C.StatReport", 4, "exception: " + th);
        }
        this.f34114a.h.postDelayed(this, 1000);
    }
}
