package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Comparator;

final class zzhu implements Comparator<zzoa<?>> {
    private final /* synthetic */ zzof zzari;
    private final /* synthetic */ zzfl zzarj;

    zzhu(zzhs zzhs, zzof zzof, zzfl zzfl) {
        this.zzari = zzof;
        this.zzarj = zzfl;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzoa zzoa = (zzoa) obj;
        zzoa zzoa2 = (zzoa) obj2;
        if (zzoa == null) {
            return zzoa2 != null ? 1 : 0;
        }
        if (zzoa2 == null) {
            return zzoa != null ? -1 : 0;
        }
        zzoa<?> zzb = ((zzgz) this.zzari.value()).zzb(this.zzarj, zzoa, zzoa2);
        Preconditions.checkState(zzb instanceof zzoe);
        return (int) ((Double) ((zzoe) zzb).value()).doubleValue();
    }
}
