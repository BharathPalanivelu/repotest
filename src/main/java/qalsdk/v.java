package qalsdk;

import android.os.Handler;
import android.os.Message;
import com.tencent.qalsdk.util.QLog;

final class v extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ t f34197a;

    v(t tVar) {
        this.f34197a = tVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1000) {
            QLog.d("WifiDetector", 1, "WIFI detect delayed try!");
            this.f34197a.c((String) message.obj);
        }
    }
}
