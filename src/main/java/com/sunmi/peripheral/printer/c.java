package com.sunmi.peripheral.printer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface c extends IInterface {
    void a(byte[] bArr) throws RemoteException;

    public static abstract class a extends Binder implements c {
        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("woyou.aidlservice.jiuiv5.ITax");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new C0482a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("woyou.aidlservice.jiuiv5.ITax");
                a(parcel.createByteArray());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("woyou.aidlservice.jiuiv5.ITax");
                return true;
            }
        }

        /* renamed from: com.sunmi.peripheral.printer.c$a$a  reason: collision with other inner class name */
        private static class C0482a implements c {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f30633a;

            C0482a(IBinder iBinder) {
                this.f30633a = iBinder;
            }

            public IBinder asBinder() {
                return this.f30633a;
            }

            public void a(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.ITax");
                    obtain.writeByteArray(bArr);
                    this.f30633a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
