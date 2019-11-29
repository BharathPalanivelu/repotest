package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class k {

    /* renamed from: a  reason: collision with root package name */
    private final Messenger f14162a;

    /* renamed from: b  reason: collision with root package name */
    private final zzm f14163b;

    k(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f14162a = new Messenger(iBinder);
            this.f14163b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f14163b = new zzm(iBinder);
            this.f14162a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", valueOf.length() != 0 ? "Invalid interface descriptor: ".concat(valueOf) : new String("Invalid interface descriptor: "));
            throw new RemoteException();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f14162a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzm zzm = this.f14163b;
        if (zzm != null) {
            zzm.a(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
