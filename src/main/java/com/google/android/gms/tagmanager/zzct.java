package com.google.android.gms.tagmanager;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.gtm.zzn;

public abstract class zzct extends zzn implements zzcs {
    public zzct() {
        super("com.google.android.gms.tagmanager.ITagManagerServiceProvider");
    }

    public static zzcs asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.tagmanager.ITagManagerServiceProvider");
        if (queryLocalInterface instanceof zzcs) {
            return (zzcs) queryLocalInterface;
        }
        return new zzcu(iBinder);
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
        /*
            r4 = this;
            r8 = 1
            if (r5 != r8) goto L_0x004c
            android.os.IBinder r5 = r6.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            android.os.IBinder r0 = r6.readStrongBinder()
            r1 = 0
            if (r0 != 0) goto L_0x0014
            r0 = r1
            goto L_0x0028
        L_0x0014:
            java.lang.String r2 = "com.google.android.gms.tagmanager.IMeasurementProxy"
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.tagmanager.zzcm
            if (r3 == 0) goto L_0x0022
            r0 = r2
            com.google.android.gms.tagmanager.zzcm r0 = (com.google.android.gms.tagmanager.zzcm) r0
            goto L_0x0028
        L_0x0022:
            com.google.android.gms.tagmanager.zzco r2 = new com.google.android.gms.tagmanager.zzco
            r2.<init>(r0)
            r0 = r2
        L_0x0028:
            android.os.IBinder r6 = r6.readStrongBinder()
            if (r6 != 0) goto L_0x002f
            goto L_0x0041
        L_0x002f:
            java.lang.String r1 = "com.google.android.gms.tagmanager.ICustomEvaluatorProxy"
            android.os.IInterface r1 = r6.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.tagmanager.zzcd
            if (r2 == 0) goto L_0x003c
            com.google.android.gms.tagmanager.zzcd r1 = (com.google.android.gms.tagmanager.zzcd) r1
            goto L_0x0041
        L_0x003c:
            com.google.android.gms.tagmanager.zzcf r1 = new com.google.android.gms.tagmanager.zzcf
            r1.<init>(r6)
        L_0x0041:
            com.google.android.gms.internal.gtm.zzer r5 = r4.getService(r5, r0, r1)
            r7.writeNoException()
            com.google.android.gms.internal.gtm.zzo.zza((android.os.Parcel) r7, (android.os.IInterface) r5)
            return r8
        L_0x004c:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzct.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
