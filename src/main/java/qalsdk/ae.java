package qalsdk;

import android.os.Handler;
import android.os.Message;

final class ae extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ad f34077a;

    ae(ad adVar) {
        this.f34077a = adVar;
    }

    public final synchronized void handleMessage(Message message) {
        if (message.what == 1) {
            this.f34077a.a(((Boolean) message.obj).booleanValue());
        }
    }
}
