package com.airpay.paysdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.airpay.paysdk.base.interfaces.ICall;

public abstract class b extends Binder implements IInterface, ICall {
    public abstract String a();

    public IBinder asBinder() {
        return this;
    }
}
