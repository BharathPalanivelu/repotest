package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public final class m {
    m() {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static c m165(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                e eVar = new e((byte) 0);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (!context.bindService(intent, eVar, 1)) {
                        if (context != null) {
                            context.unbindService(eVar);
                        }
                        throw new IOException("Google Play connection failed");
                    } else if (!eVar.f199) {
                        eVar.f199 = true;
                        d dVar = new d(eVar.f200.take());
                        c cVar = new c(dVar.m166(), dVar.m167());
                        if (context != null) {
                            context.unbindService(eVar);
                        }
                        return cVar;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Exception e2) {
                    throw e2;
                } catch (Throwable th) {
                    if (context != null) {
                        context.unbindService(eVar);
                    }
                    throw th;
                }
            } catch (Exception e3) {
                throw e3;
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    static final class c {

        /* renamed from: ˊ  reason: contains not printable characters */
        final boolean f196;

        /* renamed from: ॱ  reason: contains not printable characters */
        final String f197;

        c(String str, boolean z) {
            this.f197 = str;
            this.f196 = z;
        }
    }

    static final class e implements ServiceConnection {

        /* renamed from: ˊ  reason: contains not printable characters */
        boolean f199;

        /* renamed from: ˏ  reason: contains not printable characters */
        final LinkedBlockingQueue<IBinder> f200;

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private e() {
            this.f200 = new LinkedBlockingQueue<>(1);
            this.f199 = false;
        }

        /* synthetic */ e(byte b2) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f200.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }
    }

    static final class d implements IInterface {

        /* renamed from: ˊ  reason: contains not printable characters */
        private IBinder f198;

        d(IBinder iBinder) {
            this.f198 = iBinder;
        }

        public final IBinder asBinder() {
            return this.f198;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final String m166() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f198.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public final boolean m167() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.f198.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
