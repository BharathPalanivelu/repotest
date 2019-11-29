package com.tencent.qalsdk.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IBaseActionListener extends IInterface {
    void onActionResult(FromServiceMsg fromServiceMsg) throws RemoteException;

    void onRecvFromMsg(FromServiceMsg fromServiceMsg) throws RemoteException;

    void onResponse(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) throws RemoteException;

    public static abstract class Stub extends Binder implements IBaseActionListener {
        private static final String DESCRIPTOR = "com.tencent.qalsdk.base.remote.IBaseActionListener";
        static final int TRANSACTION_onActionResult = 2;
        static final int TRANSACTION_onRecvFromMsg = 1;
        static final int TRANSACTION_onResponse = 3;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBaseActionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBaseActionListener)) {
                return new a(iBinder);
            }
            return (IBaseActionListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            FromServiceMsg fromServiceMsg = null;
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    fromServiceMsg = FromServiceMsg.CREATOR.createFromParcel(parcel);
                }
                onRecvFromMsg(fromServiceMsg);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    fromServiceMsg = FromServiceMsg.CREATOR.createFromParcel(parcel);
                }
                onActionResult(fromServiceMsg);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                ToServiceMsg createFromParcel = parcel.readInt() != 0 ? ToServiceMsg.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    fromServiceMsg = FromServiceMsg.CREATOR.createFromParcel(parcel);
                }
                onResponse(createFromParcel, fromServiceMsg);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        static class a implements IBaseActionListener {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f32152a;

            a(IBinder iBinder) {
                this.f32152a = iBinder;
            }

            public final IBinder asBinder() {
                return this.f32152a;
            }

            public final void onRecvFromMsg(FromServiceMsg fromServiceMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (fromServiceMsg != null) {
                        obtain.writeInt(1);
                        fromServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f32152a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void onActionResult(FromServiceMsg fromServiceMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (fromServiceMsg != null) {
                        obtain.writeInt(1);
                        fromServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f32152a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void onResponse(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (toServiceMsg != null) {
                        obtain.writeInt(1);
                        toServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (fromServiceMsg != null) {
                        obtain.writeInt(1);
                        fromServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f32152a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
