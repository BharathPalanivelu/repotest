package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.internal.zzah;
import com.google.android.gms.maps.model.RuntimeRemoteException;

final class zzm implements LocationSource.OnLocationChangedListener {
    private final /* synthetic */ zzah zzu;

    zzm(zzl zzl, zzah zzah) {
        this.zzu = zzah;
    }

    public final void onLocationChanged(Location location) {
        try {
            this.zzu.zza(location);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
