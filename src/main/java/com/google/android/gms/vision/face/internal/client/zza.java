package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzl;
import com.google.android.gms.internal.vision.zzm;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import java.nio.ByteBuffer;

public final class zza extends zzl<zze> {
    private final zzc zzce;

    public zza(Context context, zzc zzc) {
        super(context, "FaceNativeHandle", "face");
        this.zzce = zzc;
        zzp();
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object zza(com.google.android.gms.dynamite.DynamiteModule r4, android.content.Context r5) throws android.os.RemoteException, com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r3 = this;
            java.lang.String r0 = "com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator"
            android.os.IBinder r4 = r4.instantiate(r0)
            r0 = 0
            if (r4 != 0) goto L_0x000b
            r4 = r0
            goto L_0x001f
        L_0x000b:
            java.lang.String r1 = "com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator"
            android.os.IInterface r1 = r4.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.vision.face.internal.client.zzg
            if (r2 == 0) goto L_0x0019
            r4 = r1
            com.google.android.gms.vision.face.internal.client.zzg r4 = (com.google.android.gms.vision.face.internal.client.zzg) r4
            goto L_0x001f
        L_0x0019:
            com.google.android.gms.vision.face.internal.client.zzh r1 = new com.google.android.gms.vision.face.internal.client.zzh
            r1.<init>(r4)
            r4 = r1
        L_0x001f:
            if (r4 != 0) goto L_0x0022
            return r0
        L_0x0022:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)
            com.google.android.gms.vision.face.internal.client.zzc r0 = r3.zzce
            com.google.android.gms.vision.face.internal.client.zze r4 = r4.zza(r5, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.face.internal.client.zza.zza(com.google.android.gms.dynamite.DynamiteModule, android.content.Context):java.lang.Object");
    }

    public final Face[] zzb(ByteBuffer byteBuffer, zzm zzm) {
        FaceParcel[] faceParcelArr;
        Landmark[] landmarkArr;
        int i = 0;
        if (!isOperational()) {
            return new Face[0];
        }
        try {
            FaceParcel[] zzc = ((zze) zzp()).zzc(ObjectWrapper.wrap(byteBuffer), zzm);
            Face[] faceArr = new Face[zzc.length];
            int i2 = 0;
            while (i2 < zzc.length) {
                FaceParcel faceParcel = zzc[i2];
                int i3 = faceParcel.id;
                PointF pointF = new PointF(faceParcel.centerX, faceParcel.centerY);
                float f2 = faceParcel.width;
                float f3 = faceParcel.height;
                float f4 = faceParcel.zzcf;
                float f5 = faceParcel.zzcg;
                LandmarkParcel[] landmarkParcelArr = faceParcel.zzch;
                if (landmarkParcelArr == null) {
                    faceParcelArr = zzc;
                    landmarkArr = new Landmark[i];
                } else {
                    landmarkArr = new Landmark[landmarkParcelArr.length];
                    int i4 = 0;
                    while (i4 < landmarkParcelArr.length) {
                        LandmarkParcel landmarkParcel = landmarkParcelArr[i4];
                        landmarkArr[i4] = new Landmark(new PointF(landmarkParcel.x, landmarkParcel.y), landmarkParcel.type);
                        i4++;
                        zzc = zzc;
                        landmarkParcelArr = landmarkParcelArr;
                    }
                    faceParcelArr = zzc;
                }
                faceArr[i2] = new Face(i3, pointF, f2, f3, f4, f5, landmarkArr, faceParcel.zzbs, faceParcel.zzbt, faceParcel.zzbu);
                i2++;
                zzc = faceParcelArr;
                i = 0;
            }
            return faceArr;
        } catch (RemoteException e2) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e2);
            return new Face[0];
        }
    }

    public final boolean zzd(int i) {
        if (!isOperational()) {
            return false;
        }
        try {
            return ((zze) zzp()).zzd(i);
        } catch (RemoteException e2) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e2);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzm() throws RemoteException {
        ((zze) zzp()).zzn();
    }
}
