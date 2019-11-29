package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.gtm.zzev;
import com.google.android.gms.internal.gtm.zzfb;
import com.google.android.gms.internal.gtm.zzfy;

@DynamiteApi
public class TagManagerApiImpl extends zzcq {
    private zzfy zzalj;

    public void initialize(IObjectWrapper iObjectWrapper, zzcm zzcm, zzcd zzcd) throws RemoteException {
        this.zzalj = zzfy.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzcm, zzcd);
        this.zzalj.zzb((String[]) null);
    }

    @Deprecated
    public void preview(Intent intent, IObjectWrapper iObjectWrapper) {
        zzev.zzac("Deprecated. Please use previewIntent instead.");
    }

    public void previewIntent(Intent intent, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, zzcm zzcm, zzcd zzcd) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzalj = zzfy.zza(context, zzcm, zzcd);
        new zzfb(intent, context, (Context) ObjectWrapper.unwrap(iObjectWrapper2), this.zzalj).zzkq();
    }
}
