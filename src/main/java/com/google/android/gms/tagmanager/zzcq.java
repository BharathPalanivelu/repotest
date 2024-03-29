package com.google.android.gms.tagmanager;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.gtm.zzn;

public abstract class zzcq extends zzn implements zzcp {
    public zzcq() {
        super("com.google.android.gms.tagmanager.ITagManagerApi");
    }

    public static zzcp asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.tagmanager.ITagManagerApi");
        if (queryLocalInterface instanceof zzcp) {
            return (zzcp) queryLocalInterface;
        }
        return new zzcr(iBinder);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.google.android.gms.tagmanager.zzco} */
    /* JADX WARNING: type inference failed for: r13v2, types: [android.os.IInterface] */
    /* JADX WARNING: type inference failed for: r11v4, types: [android.os.IInterface] */
    /* JADX WARNING: type inference failed for: r0v6, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r10, android.os.Parcel r11, android.os.Parcel r12, int r13) throws android.os.RemoteException {
        /*
            r9 = this;
            java.lang.String r13 = "com.google.android.gms.tagmanager.ICustomEvaluatorProxy"
            java.lang.String r0 = "com.google.android.gms.tagmanager.IMeasurementProxy"
            r1 = 1
            r2 = 0
            if (r10 == r1) goto L_0x0077
            r3 = 2
            if (r10 == r3) goto L_0x0063
            r3 = 3
            if (r10 == r3) goto L_0x0010
            r10 = 0
            return r10
        L_0x0010:
            android.os.Parcelable$Creator r10 = android.content.Intent.CREATOR
            android.os.Parcelable r10 = com.google.android.gms.internal.gtm.zzo.zza((android.os.Parcel) r11, r10)
            r4 = r10
            android.content.Intent r4 = (android.content.Intent) r4
            android.os.IBinder r10 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r10)
            android.os.IBinder r10 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r10)
            android.os.IBinder r10 = r11.readStrongBinder()
            if (r10 != 0) goto L_0x0031
            r7 = r2
            goto L_0x0044
        L_0x0031:
            android.os.IInterface r0 = r10.queryLocalInterface(r0)
            boolean r3 = r0 instanceof com.google.android.gms.tagmanager.zzcm
            if (r3 == 0) goto L_0x003e
            r10 = r0
            com.google.android.gms.tagmanager.zzcm r10 = (com.google.android.gms.tagmanager.zzcm) r10
            r7 = r10
            goto L_0x0044
        L_0x003e:
            com.google.android.gms.tagmanager.zzco r0 = new com.google.android.gms.tagmanager.zzco
            r0.<init>(r10)
            r7 = r0
        L_0x0044:
            android.os.IBinder r10 = r11.readStrongBinder()
            if (r10 != 0) goto L_0x004c
        L_0x004a:
            r8 = r2
            goto L_0x005e
        L_0x004c:
            android.os.IInterface r11 = r10.queryLocalInterface(r13)
            boolean r13 = r11 instanceof com.google.android.gms.tagmanager.zzcd
            if (r13 == 0) goto L_0x0058
            r2 = r11
            com.google.android.gms.tagmanager.zzcd r2 = (com.google.android.gms.tagmanager.zzcd) r2
            goto L_0x004a
        L_0x0058:
            com.google.android.gms.tagmanager.zzcf r2 = new com.google.android.gms.tagmanager.zzcf
            r2.<init>(r10)
            goto L_0x004a
        L_0x005e:
            r3 = r9
            r3.previewIntent(r4, r5, r6, r7, r8)
            goto L_0x00b2
        L_0x0063:
            android.os.Parcelable$Creator r10 = android.content.Intent.CREATOR
            android.os.Parcelable r10 = com.google.android.gms.internal.gtm.zzo.zza((android.os.Parcel) r11, r10)
            android.content.Intent r10 = (android.content.Intent) r10
            android.os.IBinder r11 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r11)
            r9.preview(r10, r11)
            goto L_0x00b2
        L_0x0077:
            android.os.IBinder r10 = r11.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r10)
            android.os.IBinder r3 = r11.readStrongBinder()
            if (r3 != 0) goto L_0x0087
            r0 = r2
            goto L_0x0097
        L_0x0087:
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r4 = r0 instanceof com.google.android.gms.tagmanager.zzcm
            if (r4 == 0) goto L_0x0092
            com.google.android.gms.tagmanager.zzcm r0 = (com.google.android.gms.tagmanager.zzcm) r0
            goto L_0x0097
        L_0x0092:
            com.google.android.gms.tagmanager.zzco r0 = new com.google.android.gms.tagmanager.zzco
            r0.<init>(r3)
        L_0x0097:
            android.os.IBinder r11 = r11.readStrongBinder()
            if (r11 != 0) goto L_0x009e
            goto L_0x00af
        L_0x009e:
            android.os.IInterface r13 = r11.queryLocalInterface(r13)
            boolean r2 = r13 instanceof com.google.android.gms.tagmanager.zzcd
            if (r2 == 0) goto L_0x00aa
            r2 = r13
            com.google.android.gms.tagmanager.zzcd r2 = (com.google.android.gms.tagmanager.zzcd) r2
            goto L_0x00af
        L_0x00aa:
            com.google.android.gms.tagmanager.zzcf r2 = new com.google.android.gms.tagmanager.zzcf
            r2.<init>(r11)
        L_0x00af:
            r9.initialize(r10, r0, r2)
        L_0x00b2:
            r12.writeNoException()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcq.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
