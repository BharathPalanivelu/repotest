package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

class k implements o {

    /* renamed from: a  reason: collision with root package name */
    private final Messenger f7204a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7205b;

    k(Messenger messenger, String str) {
        this.f7204a = messenger;
        this.f7205b = str;
    }

    public void a(int i) {
        try {
            this.f7204a.send(b(i));
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }

    private Message b(int i) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = i;
        Bundle bundle = new Bundle();
        bundle.putString("tag", this.f7205b);
        obtain.setData(bundle);
        return obtain;
    }
}
