package com.beetalk.sdk;

import android.app.Activity;
import android.content.Intent;
import com.beetalk.sdk.b;
import com.beetalk.sdk.e.a;
import com.facebook.Session;

public class e extends c {
    private b.a mPendingRequest = null;
    private boolean newPermissionRequestFired = false;

    public e(b bVar) {
        super(bVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(final b.a aVar) {
        a.b("start FB Auth", new Object[0]);
        this.mPendingRequest = aVar;
        if (aVar == null) {
            return false;
        }
        final Activity a2 = this.client.a().a();
        Session.Builder builder = new Session.Builder(a2);
        builder.setApplicationId(com.beetalk.sdk.e.b.c(a2));
        Session build = builder.build();
        Session.OpenRequest openRequest = new Session.OpenRequest(a2);
        openRequest.setRequestCode(aVar.c());
        openRequest.setCallback(new Session.StatusCallback() {
        });
        Session.setActiveSession(build);
        Session.getActiveSession().openForRead(openRequest);
        return true;
    }

    private void a(b.c cVar) {
        this.client.a(cVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i, int i2, Intent intent, b.a aVar) {
        if (Session.getActiveSession() != null) {
            Session.getActiveSession().onActivityResult(this.client.a().a(), aVar.c(), i2, intent);
            return true;
        }
        a(b.c.a(aVar, com.garena.pay.android.a.SESSION_NOT_INITIALIZED.getCode().intValue()));
        return true;
    }
}
