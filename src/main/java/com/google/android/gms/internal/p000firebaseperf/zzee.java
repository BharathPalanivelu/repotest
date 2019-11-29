package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzee  reason: invalid package */
final class zzee implements zzhz {
    private final zzec zzmz;

    public static zzee zza(zzec zzec) {
        if (zzec.zzni != null) {
            return zzec.zzni;
        }
        return new zzee(zzec);
    }

    private zzee(zzec zzec) {
        this.zzmz = (zzec) zzer.zza(zzec, "output");
        this.zzmz.zzni = this;
    }

    public final int zzgt() {
        return zzep.zzc.zzrd;
    }

    public final void zzq(int i, int i2) throws IOException {
        this.zzmz.zzj(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzmz.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzmz.zzc(i, j);
    }

    public final void zza(int i, float f2) throws IOException {
        this.zzmz.zza(i, f2);
    }

    public final void zza(int i, double d2) throws IOException {
        this.zzmz.zza(i, d2);
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zzmz.zzg(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzmz.zza(i, j);
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zzmz.zzg(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzmz.zzc(i, j);
    }

    public final void zzj(int i, int i2) throws IOException {
        this.zzmz.zzj(i, i2);
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zzmz.zza(i, z);
    }

    public final void zzb(int i, String str) throws IOException {
        this.zzmz.zzb(i, str);
    }

    public final void zza(int i, zzdl zzdl) throws IOException {
        this.zzmz.zza(i, zzdl);
    }

    public final void zzh(int i, int i2) throws IOException {
        this.zzmz.zzh(i, i2);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zzmz.zzi(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzmz.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzgn zzgn) throws IOException {
        this.zzmz.zza(i, (zzga) obj, zzgn);
    }

    public final void zzb(int i, Object obj, zzgn zzgn) throws IOException {
        zzec zzec = this.zzmz;
        zzec.zzf(i, 3);
        zzgn.zza((zzga) obj, zzec.zzni);
        zzec.zzf(i, 4);
    }

    public final void zzai(int i) throws IOException {
        this.zzmz.zzf(i, 3);
    }

    public final void zzaj(int i) throws IOException {
        this.zzmz.zzf(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzdl) {
            this.zzmz.zzb(i, (zzdl) obj);
        } else {
            this.zzmz.zza(i, (zzga) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzz(list.get(i4).intValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzu(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzac(list.get(i4).intValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzx(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzj(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzap(list.get(i4).longValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzam(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzaq(list.get(i4).longValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzam(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzas(list.get(i4).longValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzao(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzb(list.get(i4).floatValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzb(list.get(i4).doubleValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzae(list.get(i4).intValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzu(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zze(list.get(i4).booleanValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzd(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzfh) {
            zzfh zzfh = (zzfh) list;
            while (i2 < list.size()) {
                Object raw = zzfh.getRaw(i2);
                if (raw instanceof String) {
                    this.zzmz.zzb(i, (String) raw);
                } else {
                    this.zzmz.zza(i, (zzdl) raw);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzb(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzdl> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzmz.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzaa(list.get(i4).intValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzv(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzad(list.get(i4).intValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzx(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzj(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzat(list.get(i4).longValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzao(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzab(list.get(i4).intValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzw(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzi(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzar(list.get(i4).longValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzan(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzgn zzgn) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzgn);
        }
    }

    public final void zzb(int i, List<?> list, zzgn zzgn) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzgn);
        }
    }

    public final <K, V> void zza(int i, zzfr<K, V> zzfr, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzmz.zzf(i, 2);
            this.zzmz.zzv(zzfs.zza(zzfr, next.getKey(), next.getValue()));
            zzec zzec = this.zzmz;
            Object key = next.getKey();
            Object value = next.getValue();
            zzek.zza(zzec, zzfr.zzsq, 1, key);
            zzek.zza(zzec, zzfr.zzss, 2, value);
        }
    }
}
