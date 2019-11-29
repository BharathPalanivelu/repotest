package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzdl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzdj<FieldDescriptorType extends zzdl<FieldDescriptorType>> {
    private static final zzdj zzhe = new zzdj(true);
    final zzfp<FieldDescriptorType, Object> zzhb = zzfp.zzai(16);
    private boolean zzhc;
    private boolean zzhd = false;

    private zzdj() {
    }

    private zzdj(boolean z) {
        zzah();
    }

    public static <T extends zzdl<T>> zzdj<T> zzbd() {
        return zzhe;
    }

    public final void zzah() {
        if (!this.zzhc) {
            this.zzhb.zzah();
            this.zzhc = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzhc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdj)) {
            return false;
        }
        return this.zzhb.equals(((zzdj) obj).zzhb);
    }

    public final int hashCode() {
        return this.zzhb.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzhd) {
            return new zzec(this.zzhb.entrySet().iterator());
        }
        return this.zzhb.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzhd) {
            return new zzec(this.zzhb.zzdg().iterator());
        }
        return this.zzhb.zzdg().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzhb.get(fielddescriptortype);
        return obj instanceof zzeb ? zzeb.zzcb() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzbi()) {
            zza(fielddescriptortype.zzbg(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzbg(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzeb) {
            this.zzhd = true;
        }
        this.zzhb.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.icing.zzeb) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.icing.zzdv) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.icing.zzgq r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.icing.zzdq.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.icing.zzdi.zzgz
            com.google.android.gms.internal.icing.zzgx r2 = r2.zzdu()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.icing.zzex
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.icing.zzeb
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.icing.zzdv
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.icing.zzcl
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.zzdj.zza(com.google.android.gms.internal.icing.zzgq, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzhb.zzde(); i++) {
            if (!zzb(this.zzhb.zzaj(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> zzb : this.zzhb.zzdf()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        zzdl zzdl = (zzdl) entry.getKey();
        if (zzdl.zzbh() == zzgx.MESSAGE) {
            if (zzdl.zzbi()) {
                for (zzex isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzex) {
                    if (!((zzex) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzeb) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzdj<FieldDescriptorType> zzdj) {
        for (int i = 0; i < zzdj.zzhb.zzde(); i++) {
            zzc(zzdj.zzhb.zzaj(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzc : zzdj.zzhb.zzdf()) {
            zzc(zzc);
        }
    }

    private static Object zzg(Object obj) {
        if (obj instanceof zzfd) {
            return ((zzfd) obj).zzcr();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzdl zzdl = (zzdl) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzeb) {
            value = zzeb.zzcb();
        }
        if (zzdl.zzbi()) {
            Object zza = zza(zzdl);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzg : (List) value) {
                ((List) zza).add(zzg(zzg));
            }
            this.zzhb.put(zzdl, zza);
        } else if (zzdl.zzbh() == zzgx.MESSAGE) {
            Object zza2 = zza(zzdl);
            if (zza2 == null) {
                this.zzhb.put(zzdl, zzg(value));
                return;
            }
            if (zza2 instanceof zzfd) {
                obj = zzdl.zza((zzfd) zza2, (zzfd) value);
            } else {
                obj = zzdl.zza(((zzex) zza2).zzbq(), (zzex) value).zzbx();
            }
            this.zzhb.put(zzdl, obj);
        } else {
            this.zzhb.put(zzdl, zzg(value));
        }
    }

    static void zza(zzcy zzcy, zzgq zzgq, int i, Object obj) throws IOException {
        if (zzgq == zzgq.GROUP) {
            zzex zzex = (zzex) obj;
            zzdq.zzf(zzex);
            zzcy.zzb(i, 3);
            zzex.zzb(zzcy);
            zzcy.zzb(i, 4);
            return;
        }
        zzcy.zzb(i, zzgq.zzdv());
        switch (zzdi.zzha[zzgq.ordinal()]) {
            case 1:
                zzcy.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzcy.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzcy.zzb(((Long) obj).longValue());
                return;
            case 4:
                zzcy.zzb(((Long) obj).longValue());
                return;
            case 5:
                zzcy.zzo(((Integer) obj).intValue());
                return;
            case 6:
                zzcy.zzd(((Long) obj).longValue());
                return;
            case 7:
                zzcy.zzr(((Integer) obj).intValue());
                return;
            case 8:
                zzcy.zze(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzex) obj).zzb(zzcy);
                return;
            case 10:
                zzcy.zzb((zzex) obj);
                return;
            case 11:
                if (obj instanceof zzcl) {
                    zzcy.zza((zzcl) obj);
                    return;
                } else {
                    zzcy.zzq((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzcl) {
                    zzcy.zza((zzcl) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzcy.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzcy.zzp(((Integer) obj).intValue());
                return;
            case 14:
                zzcy.zzr(((Integer) obj).intValue());
                return;
            case 15:
                zzcy.zzd(((Long) obj).longValue());
                return;
            case 16:
                zzcy.zzq(((Integer) obj).intValue());
                return;
            case 17:
                zzcy.zzc(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzdv) {
                    zzcy.zzo(((zzdv) obj).zzbf());
                    return;
                } else {
                    zzcy.zzo(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzbe() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzhb.zzde(); i2++) {
            i += zzd(this.zzhb.zzaj(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzd : this.zzhb.zzdf()) {
            i += zzd(zzd);
        }
        return i;
    }

    private static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        zzdl zzdl = (zzdl) entry.getKey();
        Object value = entry.getValue();
        if (zzdl.zzbh() != zzgx.MESSAGE || zzdl.zzbi() || zzdl.zzbj()) {
            return zzb((zzdl<?>) zzdl, value);
        }
        if (value instanceof zzeb) {
            return zzcy.zzb(((zzdl) entry.getKey()).zzbf(), (zzef) (zzeb) value);
        }
        return zzcy.zzb(((zzdl) entry.getKey()).zzbf(), (zzex) value);
    }

    static int zza(zzgq zzgq, int i, Object obj) {
        int zzs = zzcy.zzs(i);
        if (zzgq == zzgq.GROUP) {
            zzdq.zzf((zzex) obj);
            zzs <<= 1;
        }
        return zzs + zzb(zzgq, obj);
    }

    private static int zzb(zzgq zzgq, Object obj) {
        switch (zzdi.zzha[zzgq.ordinal()]) {
            case 1:
                return zzcy.zzb(((Double) obj).doubleValue());
            case 2:
                return zzcy.zzb(((Float) obj).floatValue());
            case 3:
                return zzcy.zze(((Long) obj).longValue());
            case 4:
                return zzcy.zzf(((Long) obj).longValue());
            case 5:
                return zzcy.zzt(((Integer) obj).intValue());
            case 6:
                return zzcy.zzh(((Long) obj).longValue());
            case 7:
                return zzcy.zzw(((Integer) obj).intValue());
            case 8:
                return zzcy.zzf(((Boolean) obj).booleanValue());
            case 9:
                return zzcy.zzd((zzex) obj);
            case 10:
                if (obj instanceof zzeb) {
                    return zzcy.zza((zzef) (zzeb) obj);
                }
                return zzcy.zzc((zzex) obj);
            case 11:
                if (obj instanceof zzcl) {
                    return zzcy.zzb((zzcl) obj);
                }
                return zzcy.zzr((String) obj);
            case 12:
                if (obj instanceof zzcl) {
                    return zzcy.zzb((zzcl) obj);
                }
                return zzcy.zzc((byte[]) obj);
            case 13:
                return zzcy.zzu(((Integer) obj).intValue());
            case 14:
                return zzcy.zzx(((Integer) obj).intValue());
            case 15:
                return zzcy.zzi(((Long) obj).longValue());
            case 16:
                return zzcy.zzv(((Integer) obj).intValue());
            case 17:
                return zzcy.zzg(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzdv) {
                    return zzcy.zzy(((zzdv) obj).zzbf());
                }
                return zzcy.zzy(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzdl<?> zzdl, Object obj) {
        zzgq zzbg = zzdl.zzbg();
        int zzbf = zzdl.zzbf();
        if (!zzdl.zzbi()) {
            return zza(zzbg, zzbf, obj);
        }
        int i = 0;
        if (zzdl.zzbj()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzbg, zzb);
            }
            return zzcy.zzs(zzbf) + i + zzcy.zzaa(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzbg, zzbf, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzdj zzdj = new zzdj();
        for (int i = 0; i < this.zzhb.zzde(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzaj = this.zzhb.zzaj(i);
            zzdj.zza((zzdl) zzaj.getKey(), zzaj.getValue());
        }
        for (Map.Entry next : this.zzhb.zzdf()) {
            zzdj.zza((zzdl) next.getKey(), next.getValue());
        }
        zzdj.zzhd = this.zzhd;
        return zzdj;
    }
}
