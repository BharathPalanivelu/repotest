package com.sunmi.peripheral.printer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface b extends IInterface {
    void a(boolean z) throws RemoteException;

    public static abstract class a extends Binder implements b {
        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("woyou.aidlservice.jiuiv5.ILcdCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0481a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("woyou.aidlservice.jiuiv5.ILcdCallback");
                a(parcel.readInt() != 0);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("woyou.aidlservice.jiuiv5.ILcdCallback");
                return true;
            }
        }

        /* renamed from: com.sunmi.peripheral.printer.b$a$a  reason: collision with other inner class name */
        private static class C0481a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f30632a;

            C0481a(IBinder iBinder) {
                this.f30632a = iBinder;
            }

            public IBinder asBinder() {
                return this.f30632a;
            }

            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.ILcdCallback");
                    obtain.writeInt(z ? 1 : 0);
                    this.f30632a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
