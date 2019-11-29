package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgp  reason: invalid package */
final class zzgp {
    private static final Class<?> zzty = zzix();
    private static final zzhf<?, ?> zztz = zzg(false);
    private static final zzhf<?, ?> zzua = zzg(true);
    private static final zzhf<?, ?> zzub = new zzhh();

    public static void zzf(Class<?> cls) {
        if (!zzep.class.isAssignableFrom(cls)) {
            Class<?> cls2 = zzty;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    public static void zza(int i, List<Double> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzhz zzhz, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzhz zzhz) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzdl> list, zzhz zzhz) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzhz zzhz, zzgn zzgn) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zza(i, list, zzgn);
        }
    }

    public static void zzb(int i, List<?> list, zzhz zzhz, zzgn zzgn) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhz.zzb(i, list, zzgn);
        }
    }

    static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfo) {
            zzfo zzfo = (zzfo) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzap(zzfo.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzap(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzd(list) + (list.size() * zzec.zzy(i));
    }

    static int zze(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfo) {
            zzfo zzfo = (zzfo) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzaq(zzfo.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzaq(list.get(i2).longValue());
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
        return zze(list) + (size * zzec.zzy(i));
    }

    static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfo) {
            zzfo zzfo = (zzfo) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzar(zzfo.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzar(list.get(i2).longValue());
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
        return zzf(list) + (size * zzec.zzy(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzes) {
            zzes zzes = (zzes) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzae(zzes.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzae(list.get(i2).intValue());
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
        return zzg(list) + (size * zzec.zzy(i));
    }

    static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzes) {
            zzes zzes = (zzes) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzz(zzes.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzz(list.get(i2).intValue());
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
        return zzh(list) + (size * zzec.zzy(i));
    }

    static int zzi(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzes) {
            zzes zzes = (zzes) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzaa(zzes.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzaa(list.get(i2).intValue());
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
        return zzi(list) + (size * zzec.zzy(i));
    }

    static int zzj(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzes) {
            zzes zzes = (zzes) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzab(zzes.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzab(list.get(i2).intValue());
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
        return zzj(list) + (size * zzec.zzy(i));
    }

    static int zzk(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzec.zzn(i, 0);
    }

    static int zzl(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzec.zzg(i, 0);
    }

    static int zzm(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzec.zzb(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzy = zzec.zzy(i) * size;
        if (list instanceof zzfh) {
            zzfh zzfh = (zzfh) list;
            while (i4 < size) {
                Object raw = zzfh.getRaw(i4);
                if (raw instanceof zzdl) {
                    i3 = zzec.zzb((zzdl) raw);
                } else {
                    i3 = zzec.zzai((String) raw);
                }
                zzy += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzdl) {
                    i2 = zzec.zzb((zzdl) obj);
                } else {
                    i2 = zzec.zzai((String) obj);
                }
                zzy += i2;
                i4++;
            }
        }
        return zzy;
    }

    static int zzc(int i, Object obj, zzgn zzgn) {
        if (obj instanceof zzff) {
            return zzec.zza(i, (zzff) obj);
        }
        return zzec.zzb(i, (zzga) obj, zzgn);
    }

    static int zzc(int i, List<?> list, zzgn zzgn) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = zzec.zzy(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzff) {
                i2 = zzec.zza((zzff) obj);
            } else {
                i2 = zzec.zza((zzga) obj, zzgn);
            }
            zzy += i2;
        }
        return zzy;
    }

    static int zzd(int i, List<zzdl> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = size * zzec.zzy(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzy += zzec.zzb(list.get(i2));
        }
        return zzy;
    }

    static int zzd(int i, List<zzga> list, zzgn zzgn) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzec.zzc(i, list.get(i3), zzgn);
        }
        return i2;
    }

    public static zzhf<?, ?> zziu() {
        return zztz;
    }

    public static zzhf<?, ?> zziv() {
        return zzua;
    }

    public static zzhf<?, ?> zziw() {
        return zzub;
    }

    private static zzhf<?, ?> zzg(boolean z) {
        try {
            Class<?> zziy = zziy();
            if (zziy == null) {
                return null;
            }
            return (zzhf) zziy.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzix() {
        try {
            return Class.forName("com.google.c.r");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zziy() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzf(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzft zzft, T t, T t2, long j) {
        zzhl.zza((Object) t, j, zzft.zzd(zzhl.zzo(t, j), zzhl.zzo(t2, j)));
    }

    static <T, FT extends zzem<FT>> void zza(zzef<FT> zzef, T t, T t2) {
        zzek<FT> zzc = zzef.zzc(t2);
        if (!zzc.zznt.isEmpty()) {
            zzef.zzd(t).zza(zzc);
        }
    }

    static <T, UT, UB> void zza(zzhf<UT, UB> zzhf, T t, T t2) {
        zzhf.zzg(t, zzhf.zzh(zzhf.zzo(t), zzhf.zzo(t2)));
    }
}
