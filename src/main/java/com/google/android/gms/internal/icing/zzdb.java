package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzdo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzdb implements zzgw {
    private final zzcy zzge;

    public static zzdb zza(zzcy zzcy) {
        if (zzcy.zzgk != null) {
            return zzcy.zzgk;
        }
        return new zzdb(zzcy);
    }

    private zzdb(zzcy zzcy) {
        this.zzge = (zzcy) zzdq.zza(zzcy, "output");
        this.zzge.zzgk = this;
    }

    public final int zzau() {
        return zzdo.zzc.zzkl;
    }

    public final void zzm(int i, int i2) throws IOException {
        this.zzge.zzf(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzge.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzge.zzc(i, j);
    }

    public final void zza(int i, float f2) throws IOException {
        this.zzge.zza(i, f2);
    }

    public final void zza(int i, double d2) throws IOException {
        this.zzge.zza(i, d2);
    }

    public final void zzn(int i, int i2) throws IOException {
        this.zzge.zzc(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzge.zza(i, j);
    }

    public final void zzc(int i, int i2) throws IOException {
        this.zzge.zzc(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzge.zzc(i, j);
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zzge.zzf(i, i2);
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zzge.zza(i, z);
    }

    public final void zza(int i, String str) throws IOException {
        this.zzge.zza(i, str);
    }

    public final void zza(int i, zzcl zzcl) throws IOException {
        this.zzge.zza(i, zzcl);
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zzge.zzd(i, i2);
    }

    public final void zze(int i, int i2) throws IOException {
        this.zzge.zze(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzge.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzfk zzfk) throws IOException {
        this.zzge.zza(i, (zzex) obj, zzfk);
    }

    public final void zzb(int i, Object obj, zzfk zzfk) throws IOException {
        zzcy zzcy = this.zzge;
        zzcy.zzb(i, 3);
        zzfk.zza((zzex) obj, zzcy.zzgk);
        zzcy.zzb(i, 4);
    }

    public final void zzab(int i) throws IOException {
        this.zzge.zzb(i, 3);
    }

    public final void zzac(int i) throws IOException {
        this.zzge.zzb(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzcl) {
            this.zzge.zzb(i, (zzcl) obj);
        } else {
            this.zzge.zza(i, (zzex) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzt(list.get(i4).intValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zzo(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzw(list.get(i4).intValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zzr(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zze(list.get(i4).longValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzf(list.get(i4).longValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzh(list.get(i4).longValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zzd(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzb(list.get(i4).floatValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzb(list.get(i4).doubleValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzy(list.get(i4).intValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zzo(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzf(list.get(i4).booleanValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zze(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzeh) {
            zzeh zzeh = (zzeh) list;
            while (i2 < list.size()) {
                Object zzad = zzeh.zzad(i2);
                if (zzad instanceof String) {
                    this.zzge.zza(i, (String) zzad);
                } else {
                    this.zzge.zza(i, (zzcl) zzad);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zza(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzcl> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzge.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzu(list.get(i4).intValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zzp(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzx(list.get(i4).intValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zzr(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzi(list.get(i4).longValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zzd(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzv(list.get(i4).intValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zzq(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzge.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzcy.zzg(list.get(i4).longValue());
            }
            this.zzge.zzp(i3);
            while (i2 < list.size()) {
                this.zzge.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzge.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzfk zzfk) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzfk);
        }
    }

    public final void zzb(int i, List<?> list, zzfk zzfk) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzfk);
        }
    }

    public final <K, V> void zza(int i, zzeo<K, V> zzeo, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzge.zzb(i, 2);
            this.zzge.zzp(zzdj.zza(zzeo.zzly, 1, next.getKey()) + zzdj.zza(zzeo.zzlz, 2, next.getValue()));
            zzcy zzcy = this.zzge;
            Object key = next.getKey();
            Object value = next.getValue();
            zzdj.zza(zzcy, zzeo.zzly, 1, key);
            zzdj.zza(zzcy, zzeo.zzlz, 2, value);
        }
    }
}
