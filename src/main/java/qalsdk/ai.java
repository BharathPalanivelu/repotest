package qalsdk;

import com.tencent.qalsdk.sdk.c;
import com.tencent.qalsdk.sdk.v;
import com.tencent.qalsdk.util.QLog;

final class ai implements Runnable {
    ai(ah ahVar) {
    }

    public final void run() {
        QLog.d("Foreground", 4, "onActivityPaused " + am.a());
        if (am.a() && v.a().f32278a) {
            c.a().h();
        }
    }
}
