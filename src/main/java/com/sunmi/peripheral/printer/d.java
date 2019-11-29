package com.sunmi.peripheral.printer;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sunmi.peripheral.printer.h;

public abstract class d implements ServiceConnection {
    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract void a(h hVar);

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            a(h.a.a(iBinder));
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        a();
    }
}
