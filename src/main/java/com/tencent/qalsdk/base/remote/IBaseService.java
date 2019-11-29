package com.tencent.qalsdk.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IBaseService extends IInterface {
    FromServiceMsg sendSyncToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException;

    int sendToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException;

    public static abstract class Stub extends Binder implements IBaseService {
        private static final String DESCRIPTOR = "com.tencent.qalsdk.base.remote.IBaseService";
        static final int TRANSACTION_sendSyncToServiceMsg = 1;
        static final int TRANSACTION_sendToServiceMsg = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBaseService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBaseService)) {
                return new a(iBinder);
            }
            return (IBaseService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ToServiceMsg toServiceMsg = null;
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    toServiceMsg = ToServiceMsg.CREATOR.createFromParcel(parcel);
                }
                FromServiceMsg sendSyncToServiceMsg = sendSyncToServiceMsg(toServiceMsg);
                parcel2.writeNoException();
                if (sendSyncToServiceMsg != null) {
                    parcel2.writeInt(1);
                    sendSyncToServiceMsg.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    toServiceMsg = ToServiceMsg.CREATOR.createFromParcel(parcel);
                }
                int sendToServiceMsg = sendToServiceMsg(toServiceMsg);
                parcel2.writeNoException();
                parcel2.writeInt(sendToServiceMsg);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        static class a implements IBaseService {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f32153a;

            a(IBinder iBinder) {
                this.f32153a = iBinder;
            }

            public final IBinder asBinder() {
                return this.f32153a;
            }

            public final FromServiceMsg sendSyncToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (toServiceMsg != null) {
                        obtain.writeInt(1);
                        toServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f32153a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? FromServiceMsg.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int sendToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (toServiceMsg != null) {
                        obtain.writeInt(1);
                        toServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f32153a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
