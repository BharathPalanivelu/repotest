package com.firebase.jobdispatcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface l extends IInterface {
    void a(Bundle bundle, int i) throws RemoteException;

    public static abstract class a extends Binder implements l {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.firebase.jobdispatcher.IJobCallback");
        }

        public static l a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.firebase.jobdispatcher.IJobCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof l)) {
                return new C0120a(iBinder);
            }
            return (l) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.firebase.jobdispatcher.IJobCallback");
                a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.firebase.jobdispatcher.IJobCallback");
                return true;
            }
        }

        /* renamed from: com.firebase.jobdispatcher.l$a$a  reason: collision with other inner class name */
        private static class C0120a implements l {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f7206a;

            C0120a(IBinder iBinder) {
                this.f7206a = iBinder;
            }

            public IBinder asBinder() {
                return this.f7206a;
            }

            public void a(Bundle bundle, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.firebase.jobdispatcher.IJobCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f7206a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
