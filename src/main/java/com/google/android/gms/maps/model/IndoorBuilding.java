package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.maps.zzn;
import com.google.android.gms.internal.maps.zzq;
import com.google.android.gms.internal.maps.zzr;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding {
    private final zzn zzdd;
    private final zza zzde;

    @VisibleForTesting
    static class zza {
        public static final zza zzdf = new zza();

        private zza() {
        }

        public static IndoorLevel zza(zzq zzq) {
            return new IndoorLevel(zzq);
        }

        public static zzq zza(IBinder iBinder) {
            return zzr.zzf(iBinder);
        }
    }

    public IndoorBuilding(zzn zzn) {
        this(zzn, zza.zzdf);
    }

    @VisibleForTesting
    private IndoorBuilding(zzn zzn, zza zza2) {
        this.zzdd = (zzn) Preconditions.checkNotNull(zzn, "delegate");
        this.zzde = (zza) Preconditions.checkNotNull(zza2, "shim");
    }

    public final int getDefaultLevelIndex() {
        try {
            return this.zzdd.getDefaultLevelIndex();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int getActiveLevelIndex() {
        try {
            return this.zzdd.getActiveLevelIndex();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final List<IndoorLevel> getLevels() {
        try {
            List<IBinder> levels = this.zzdd.getLevels();
            ArrayList arrayList = new ArrayList(levels.size());
            for (IBinder zza2 : levels) {
                arrayList.add(zza.zza(zza.zza(zza2)));
            }
            return arrayList;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isUnderground() {
        try {
            return this.zzdd.isUnderground();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.zzdd.zzb(((IndoorBuilding) obj).zzdd);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.zzdd.zzj();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
