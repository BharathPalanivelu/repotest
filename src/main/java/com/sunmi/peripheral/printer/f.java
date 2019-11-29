package com.sunmi.peripheral.printer;

import android.content.Context;
import android.content.Intent;

public class f {

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static f f30634a = new f();
    }

    private f() {
    }

    public static f a() {
        return a.f30634a;
    }

    public void a(Context context, d dVar) throws e {
        if (context == null || dVar == null) {
            throw new e("parameter must be nonull!");
        }
        Intent intent = new Intent();
        intent.setPackage("woyou.aidlservice.jiuiv5");
        intent.setAction("woyou.aidlservice.jiuiv5.IWoyouService");
        context.getApplicationContext().bindService(intent, dVar, 1);
    }

    public void b(Context context, d dVar) throws e {
        if (context == null || dVar == null) {
            throw new e("parameter must be nonull!");
        }
        context.getApplicationContext().unbindService(dVar);
    }
}
