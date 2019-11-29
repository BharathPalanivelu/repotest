package com.tencent.qalsdk.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qalsdk.base.remote.IBaseService;
import com.tencent.qalsdk.util.QLog;

final class y implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ x f32295a;

    y(x xVar) {
        this.f32295a = xVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (QLog.isColorLevel()) {
            QLog.d("MSF.D.RemoteServiceProxy", 2, "threadID:" + Thread.currentThread().getId() + " onServiceConnected service:" + componentName);
        }
        this.f32295a.f32290d = IBaseService.Stub.asInterface(iBinder);
        this.f32295a.d();
        x.a(this.f32295a);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        QLog.i("MSF.D.RemoteServiceProxy", 2, " onServiceDisconnected " + componentName);
        x xVar = this.f32295a;
        xVar.f32290d = null;
        x.a(xVar);
        x xVar2 = this.f32295a;
        xVar2.a();
        xVar2.b();
    }
}
