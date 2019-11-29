package com.sunmi.peripheral.printer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface a extends IInterface {
    void a(int i, String str) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void b(int i, String str) throws RemoteException;

    /* renamed from: com.sunmi.peripheral.printer.a$a  reason: collision with other inner class name */
    public static abstract class C0479a extends Binder implements a {
        public IBinder asBinder() {
            return this;
        }

        public C0479a() {
            attachInterface(this, "woyou.aidlservice.jiuiv5.ICallback");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("woyou.aidlservice.jiuiv5.ICallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0480a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("woyou.aidlservice.jiuiv5.ICallback");
                a(parcel.readInt() != 0);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("woyou.aidlservice.jiuiv5.ICallback");
                a(parcel.readString());
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("woyou.aidlservice.jiuiv5.ICallback");
                b(parcel.readInt(), parcel.readString());
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("woyou.aidlservice.jiuiv5.ICallback");
                a(parcel.readInt(), parcel.readString());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("woyou.aidlservice.jiuiv5.ICallback");
                return true;
            }
        }

        /* renamed from: com.sunmi.peripheral.printer.a$a$a  reason: collision with other inner class name */
        private static class C0480a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f30631a;

            C0480a(IBinder iBinder) {
                this.f30631a = iBinder;
            }

            public IBinder asBinder() {
                return this.f30631a;
            }

            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.ICallback");
                    obtain.writeInt(z ? 1 : 0);
                    this.f30631a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.ICallback");
                    obtain.writeString(str);
                    this.f30631a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void b(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.ICallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f30631a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.ICallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f30631a.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
