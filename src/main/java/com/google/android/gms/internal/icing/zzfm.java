package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.util.List;

final class zzfm {
    private static final Class<?> zznd = zzdc();
    private static final zzgc<?, ?> zzne = zzh(false);
    private static final zzgc<?, ?> zznf = zzh(true);
    private static final zzgc<?, ?> zzng = new zzge();

    public static void zzf(Class<?> cls) {
        if (!zzdo.class.isAssignableFrom(cls)) {
            Class<?> cls2 = zznd;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    public static void zza(int i, List<Double> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzgw zzgw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzgw zzgw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzcl> list, zzgw zzgw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzgw zzgw, zzfk zzfk) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zza(i, list, zzfk);
        }
    }

    public static void zzb(int i, List<?> list, zzgw zzgw, zzfk zzfk) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgw.zzb(i, list, zzfk);
        }
    }

    static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzek) {
            zzek zzek = (zzek) list;
            i = 0;
            while (i2 < size) {
                i += zzcy.zze(zzek.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzcy.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzcy.zzs(i));
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzek) {
            zzek zzek = (zzek) list;
            i = 0;
            while (i2 < size) {
                i += zzcy.zzf(zzek.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzcy.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzcy.zzs(i));
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzek) {
            zzek zzek = (zzek) list;
            i = 0;
            while (i2 < size) {
                i += zzcy.zzg(zzek.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzcy.zzg(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzcy.zzs(i));
    }

    static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdr) {
            zzdr zzdr = (zzdr) list;
            i = 0;
            while (i2 < size) {
                i += zzcy.zzy(zzdr.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzcy.zzy(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzcy.zzs(i));
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdr) {
            zzdr zzdr = (zzdr) list;
            i = 0;
            while (i2 < size) {
                i += zzcy.zzt(zzdr.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzcy.zzt(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzcy.zzs(i));
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdr) {
            zzdr zzdr = (zzdr) list;
            i = 0;
            while (i2 < size) {
                i += zzcy.zzu(zzdr.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzcy.zzu(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzcy.zzs(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdr) {
            zzdr zzdr = (zzdr) list;
            i = 0;
            while (i2 < size) {
                i += zzcy.zzv(zzdr.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzcy.zzv(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzcy.zzs(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzcy.zzj(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzcy.zzg(i, 0);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzcy.zzb(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzs = zzcy.zzs(i) * size;
        if (list instanceof zzeh) {
            zzeh zzeh = (zzeh) list;
            while (i4 < size) {
                Object zzad = zzeh.zzad(i4);
                if (zzad instanceof zzcl) {
                    i3 = zzcy.zzb((zzcl) zzad);
                } else {
                    i3 = zzcy.zzr((String) zzad);
                }
                zzs += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzcl) {
                    i2 = zzcy.zzb((zzcl) obj);
                } else {
                    i2 = zzcy.zzr((String) obj);
                }
                zzs += i2;
                i4++;
            }
        }
        return zzs;
    }

    static int zzc(int i, Object obj, zzfk zzfk) {
        if (obj instanceof zzef) {
            return zzcy.zza(i, (zzef) obj);
        }
        return zzcy.zzb(i, (zzex) obj, zzfk);
    }

    static int zzc(int i, List<?> list, zzfk zzfk) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzs = zzcy.zzs(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzef) {
                i2 = zzcy.zza((zzef) obj);
            } else {
                i2 = zzcy.zza((zzex) obj, zzfk);
            }
            zzs += i2;
        }
        return zzs;
    }

    static int zzd(int i, List<zzcl> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzs = size * zzcy.zzs(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzs += zzcy.zzb(list.get(i2));
        }
        return zzs;
    }

    static int zzd(int i, List<zzex> list, zzfk zzfk) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzcy.zzc(i, list.get(i3), zzfk);
        }
        return i2;
    }

    public static zzgc<?, ?> zzcz() {
        return zzne;
    }

    public static zzgc<?, ?> zzda() {
        return zznf;
    }

    public static zzgc<?, ?> zzdb() {
        return zzng;
    }

    private static zzgc<?, ?> zzh(boolean z) {
        try {
            Class<?> zzdd = zzdd();
            if (zzdd == null) {
                return null;
            }
            return (zzgc) zzdd.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzdc() {
        try {
            return Class.forName("com.google.c.r");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzdd() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzd(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzeq zzeq, T t, T t2, long j) {
        zzgi.zza((Object) t, j, zzeq.zzb(zzgi.zzo(t, j), zzgi.zzo(t2, j)));
    }

    static <T, FT extends zzdl<FT>> void zza(zzde<FT> zzde, T t, T t2) {
        zzdj<FT> zzd = zzde.zzd(t2);
        if (!zzd.zzhb.isEmpty()) {
            zzde.zze((Object) t).zza(zzd);
        }
    }

    static <T, UT, UB> void zza(zzgc<UT, UB> zzgc, T t, T t2) {
        zzgc.zze(t, zzgc.zzf(zzgc.zzp(t), zzgc.zzp(t2)));
    }
}
