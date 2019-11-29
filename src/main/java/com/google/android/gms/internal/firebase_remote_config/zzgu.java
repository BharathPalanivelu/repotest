package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzgu implements zzku {
    private final zzgs zzpb;

    public static zzgu zza(zzgs zzgs) {
        if (zzgs.zzpw != null) {
            return zzgs.zzpw;
        }
        return new zzgu(zzgs);
    }

    private zzgu(zzgs zzgs) {
        this.zzpb = (zzgs) zzhm.zza(zzgs, "output");
        this.zzpb.zzpw = this;
    }

    public final int zzgd() {
        return zzhi.zze.zztx;
    }

    public final void zzn(int i, int i2) throws IOException {
        this.zzpb.zzg(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzpb.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzpb.zzc(i, j);
    }

    public final void zza(int i, float f2) throws IOException {
        this.zzpb.zza(i, f2);
    }

    public final void zza(int i, double d2) throws IOException {
        this.zzpb.zza(i, d2);
    }

    public final void zzo(int i, int i2) throws IOException {
        this.zzpb.zzd(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzpb.zza(i, j);
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zzpb.zzd(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzpb.zzc(i, j);
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zzpb.zzg(i, i2);
    }

    public final void zzc(int i, boolean z) throws IOException {
        this.zzpb.zzc(i, z);
    }

    public final void zzb(int i, String str) throws IOException {
        this.zzpb.zzb(i, str);
    }

    public final void zza(int i, zzfx zzfx) throws IOException {
        this.zzpb.zza(i, zzfx);
    }

    public final void zze(int i, int i2) throws IOException {
        this.zzpb.zze(i, i2);
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zzpb.zzf(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzpb.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzjf zzjf) throws IOException {
        this.zzpb.zza(i, (zziq) obj, zzjf);
    }

    public final void zzb(int i, Object obj, zzjf zzjf) throws IOException {
        zzgs zzgs = this.zzpb;
        zzgs.zzc(i, 3);
        zzjf.zza((zziq) obj, zzgs.zzpw);
        zzgs.zzc(i, 4);
    }

    public final void zzaz(int i) throws IOException {
        this.zzpb.zzc(i, 3);
    }

    public final void zzba(int i) throws IOException {
        this.zzpb.zzc(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzfx) {
            this.zzpb.zzb(i, (zzfx) obj);
        } else {
            this.zzpb.zza(i, (zziq) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzar(list.get(i4).intValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzam(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzau(list.get(i4).intValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzap(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzi(list.get(i4).longValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzf(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzj(list.get(i4).longValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzf(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzl(list.get(i4).longValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzh(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzc(list.get(i4).floatValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzb(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzd(list.get(i4).doubleValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzc(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzaw(list.get(i4).intValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzam(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zze(list.get(i4).booleanValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzd(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzc(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzhx) {
            zzhx zzhx = (zzhx) list;
            while (i2 < list.size()) {
                Object zzbd = zzhx.zzbd(i2);
                if (zzbd instanceof String) {
                    this.zzpb.zzb(i, (String) zzbd);
                } else {
                    this.zzpb.zza(i, (zzfx) zzbd);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzb(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzfx> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzpb.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzas(list.get(i4).intValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzan(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzav(list.get(i4).intValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzap(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzm(list.get(i4).longValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzh(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzat(list.get(i4).intValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzao(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzk(list.get(i4).longValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzg(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzjf zzjf) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzjf);
        }
    }

    public final void zzb(int i, List<?> list, zzjf zzjf) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzjf);
        }
    }

    public final <K, V> void zza(int i, zzih<K, V> zzih, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzpb.zzc(i, 2);
            this.zzpb.zzan(zzii.zza(zzih, next.getKey(), next.getValue()));
            zzii.zza(this.zzpb, zzih, next.getKey(), next.getValue());
        }
    }
}
