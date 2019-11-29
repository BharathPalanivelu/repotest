package com.firebase.jobdispatcher;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.firebase.jobdispatcher.q;

@TargetApi(21)
class j extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final GooglePlayReceiver f7203a;

    public j(Looper looper, GooglePlayReceiver googlePlayReceiver) {
        super(looper);
        this.f7203a = googlePlayReceiver;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            try {
                ((AppOpsManager) this.f7203a.getApplicationContext().getSystemService("appops")).checkPackage(message.sendingUid, "com.google.android.gms");
                int i = message.what;
                if (i == 1) {
                    a(message);
                } else if (i == 2) {
                    b(message);
                } else if (i != 4) {
                    Log.e("FJD.GooglePlayReceiver", "Unrecognized message received: " + message);
                }
            } catch (SecurityException unused) {
                Log.e("FJD.GooglePlayReceiver", "Message was not sent from GCM.");
            }
        }
    }

    private void a(Message message) {
        Bundle data = message.getData();
        Messenger messenger = message.replyTo;
        String string = data.getString("tag");
        if (messenger != null && string != null) {
            this.f7203a.a().a(this.f7203a.a((o) new k(messenger, string), data));
        } else if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
            Log.d("FJD.GooglePlayReceiver", "Invalid start execution message.");
        }
    }

    private void b(Message message) {
        q.a b2 = GooglePlayReceiver.b().b(message.getData());
        if (b2 != null) {
            d.a(b2.a(), true);
        } else if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
            Log.d("FJD.GooglePlayReceiver", "Invalid stop execution message.");
        }
    }
}
