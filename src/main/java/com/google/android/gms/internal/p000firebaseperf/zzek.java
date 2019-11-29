package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzek  reason: invalid package */
final class zzek<FieldDescriptorType extends zzem<FieldDescriptorType>> {
    private static final zzek zznw = new zzek(true);
    final zzgs<FieldDescriptorType, Object> zznt = zzgs.zzat(16);
    private boolean zznu;
    private boolean zznv = false;

    private zzek() {
    }

    private zzek(boolean z) {
        zzgf();
    }

    public static <T extends zzem<T>> zzek<T> zzgz() {
        return zznw;
    }

    public final void zzgf() {
        if (!this.zznu) {
            this.zznt.zzgf();
            this.zznu = true;
        }
    }

    public final boolean isImmutable() {
        return this.zznu;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzek)) {
            return false;
        }
        return this.zznt.equals(((zzek) obj).zznt);
    }

    public final int hashCode() {
        return this.zznt.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zznv) {
            return new zzfg(this.zznt.entrySet().iterator());
        }
        return this.zznt.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zznv) {
            return new zzfg(this.zznt.zzjb().iterator());
        }
        return this.zznt.zzjb().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zznt.get(fielddescriptortype);
        return obj instanceof zzfb ? zzfb.zzhu() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzhd()) {
            zza(fielddescriptortype.zzhb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzhb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfb) {
            this.zznv = true;
        }
        this.zznt.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.p000firebaseperf.zzfb) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.p000firebaseperf.zzeu) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.p000firebaseperf.zzht r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.p000firebaseperf.zzer.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.p000firebaseperf.zzej.zznr
            com.google.android.gms.internal.firebase-perf.zzia r2 = r2.zzjp()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001e;
                case 9: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0043
        L_0x0015:
            boolean r2 = r3 instanceof com.google.android.gms.internal.p000firebaseperf.zzga
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.p000firebaseperf.zzfb
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.p000firebaseperf.zzeu
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.p000firebaseperf.zzdl
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            r1 = r0
        L_0x0043:
            if (r1 == 0) goto L_0x0046
            return
        L_0x0046:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L_0x004f
        L_0x004e:
            throw r2
        L_0x004f:
            goto L_0x004e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.zzek.zza(com.google.android.gms.internal.firebase-perf.zzht, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zznt.zziz(); i++) {
            if (!zzc(this.zznt.zzau(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> zzc : this.zznt.zzja()) {
            if (!zzc(zzc)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        zzem zzem = (zzem) entry.getKey();
        if (zzem.zzhc() == zzia.MESSAGE) {
            if (zzem.zzhd()) {
                for (zzga isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzga) {
                    if (!((zzga) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzfb) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzek<FieldDescriptorType> zzek) {
        for (int i = 0; i < zzek.zznt.zziz(); i++) {
            zzd(zzek.zznt.zzau(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzd : zzek.zznt.zzja()) {
            zzd(zzd);
        }
    }

    private static Object zzf(Object obj) {
        if (obj instanceof zzgg) {
            return ((zzgg) obj).zzim();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzem zzem = (zzem) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfb) {
            value = zzfb.zzhu();
        }
        if (zzem.zzhd()) {
            Object zza = zza(zzem);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzf : (List) value) {
                ((List) zza).add(zzf(zzf));
            }
            this.zznt.put(zzem, zza);
        } else if (zzem.zzhc() == zzia.MESSAGE) {
            Object zza2 = zza(zzem);
            if (zza2 == null) {
                this.zznt.put(zzem, zzf(value));
                return;
            }
            if (zza2 instanceof zzgg) {
                obj = zzem.zza((zzgg) zza2, (zzgg) value);
            } else {
                obj = zzem.zza(((zzga) zza2).zzhk(), (zzga) value).zzhr();
            }
            this.zznt.put(zzem, obj);
        } else {
            this.zznt.put(zzem, zzf(value));
        }
    }

    static void zza(zzec zzec, zzht zzht, int i, Object obj) throws IOException {
        if (zzht == zzht.GROUP) {
            zzga zzga = (zzga) obj;
            zzer.zzf(zzga);
            zzec.zzf(i, 3);
            zzga.zzb(zzec);
            zzec.zzf(i, 4);
            return;
        }
        zzec.zzf(i, zzht.zzjq());
        switch (zzej.zzns[zzht.ordinal()]) {
            case 1:
                zzec.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzec.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzec.zzam(((Long) obj).longValue());
                return;
            case 4:
                zzec.zzam(((Long) obj).longValue());
                return;
            case 5:
                zzec.zzu(((Integer) obj).intValue());
                return;
            case 6:
                zzec.zzao(((Long) obj).longValue());
                return;
            case 7:
                zzec.zzx(((Integer) obj).intValue());
                return;
            case 8:
                zzec.zzd(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzga) obj).zzb(zzec);
                return;
            case 10:
                zzec.zzb((zzga) obj);
                return;
            case 11:
                if (obj instanceof zzdl) {
                    zzec.zza((zzdl) obj);
                    return;
                } else {
                    zzec.zzah((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdl) {
                    zzec.zza((zzdl) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzec.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzec.zzv(((Integer) obj).intValue());
                return;
            case 14:
                zzec.zzx(((Integer) obj).intValue());
                return;
            case 15:
                zzec.zzao(((Long) obj).longValue());
                return;
            case 16:
                zzec.zzw(((Integer) obj).intValue());
                return;
            case 17:
                zzec.zzan(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzeu) {
                    zzec.zzu(((zzeu) obj).zzdj());
                    return;
                } else {
                    zzec.zzu(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzha() {
        int i = 0;
        for (int i2 = 0; i2 < this.zznt.zziz(); i2++) {
            i += zze(this.zznt.zzau(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> zze : this.zznt.zzja()) {
            i += zze(zze);
        }
        return i;
    }

    private static int zze(Map.Entry<FieldDescriptorType, Object> entry) {
        zzem zzem = (zzem) entry.getKey();
        Object value = entry.getValue();
        if (zzem.zzhc() != zzia.MESSAGE || zzem.zzhd() || zzem.zzhe()) {
            return zzb((zzem<?>) zzem, value);
        }
        if (value instanceof zzfb) {
            return zzec.zzb(((zzem) entry.getKey()).zzdj(), (zzff) (zzfb) value);
        }
        return zzec.zzb(((zzem) entry.getKey()).zzdj(), (zzga) value);
    }

    static int zza(zzht zzht, int i, Object obj) {
        int zzy = zzec.zzy(i);
        if (zzht == zzht.GROUP) {
            zzer.zzf((zzga) obj);
            zzy <<= 1;
        }
        return zzy + zzb(zzht, obj);
    }

    private static int zzb(zzht zzht, Object obj) {
        switch (zzej.zzns[zzht.ordinal()]) {
            case 1:
                return zzec.zzb(((Double) obj).doubleValue());
            case 2:
                return zzec.zzb(((Float) obj).floatValue());
            case 3:
                return zzec.zzap(((Long) obj).longValue());
            case 4:
                return zzec.zzaq(((Long) obj).longValue());
            case 5:
                return zzec.zzz(((Integer) obj).intValue());
            case 6:
                return zzec.zzas(((Long) obj).longValue());
            case 7:
                return zzec.zzac(((Integer) obj).intValue());
            case 8:
                return zzec.zze(((Boolean) obj).booleanValue());
            case 9:
                return zzec.zzd((zzga) obj);
            case 10:
                if (obj instanceof zzfb) {
                    return zzec.zza((zzff) (zzfb) obj);
                }
                return zzec.zzc((zzga) obj);
            case 11:
                if (obj instanceof zzdl) {
                    return zzec.zzb((zzdl) obj);
                }
                return zzec.zzai((String) obj);
            case 12:
                if (obj instanceof zzdl) {
                    return zzec.zzb((zzdl) obj);
                }
                return zzec.zzc((byte[]) obj);
            case 13:
                return zzec.zzaa(((Integer) obj).intValue());
            case 14:
                return zzec.zzad(((Integer) obj).intValue());
            case 15:
                return zzec.zzat(((Long) obj).longValue());
            case 16:
                return zzec.zzab(((Integer) obj).intValue());
            case 17:
                return zzec.zzar(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzeu) {
                    return zzec.zzae(((zzeu) obj).zzdj());
                }
                return zzec.zzae(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzem<?> zzem, Object obj) {
        zzht zzhb = zzem.zzhb();
        int zzdj = zzem.zzdj();
        if (!zzem.zzhd()) {
            return zza(zzhb, zzdj, obj);
        }
        int i = 0;
        if (zzem.zzhe()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzhb, zzb);
            }
            return zzec.zzy(zzdj) + i + zzec.zzah(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzhb, zzdj, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzek zzek = new zzek();
        for (int i = 0; i < this.zznt.zziz(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzau = this.zznt.zzau(i);
            zzek.zza((zzem) zzau.getKey(), zzau.getValue());
        }
        for (Map.Entry next : this.zznt.zzja()) {
            zzek.zza((zzem) next.getKey(), next.getValue());
        }
        zzek.zznv = this.zznv;
        return zzek;
    }
}
