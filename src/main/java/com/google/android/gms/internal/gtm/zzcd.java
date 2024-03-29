package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzcd {
    private final List<zzbk> zzaaz;
    private final long zzaba;
    private final long zzabb;
    private final int zzabc;
    private final boolean zzabd;
    private final String zzabe;
    private final Map<String, String> zztc;

    public zzcd(zzam zzam, Map<String, String> map, long j, boolean z) {
        this(zzam, map, j, z, 0, 0, (List<zzbk>) null);
    }

    public zzcd(zzam zzam, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(zzam, map, j, z, j2, i, (List<zzbk>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcd(com.google.android.gms.internal.gtm.zzam r1, java.util.Map<java.lang.String, java.lang.String> r2, long r3, boolean r5, long r6, int r8, java.util.List<com.google.android.gms.internal.gtm.zzbk> r9) {
        /*
            r0 = this;
            r0.<init>()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            r0.zzabb = r3
            r0.zzabd = r5
            r0.zzaba = r6
            r0.zzabc = r8
            if (r9 == 0) goto L_0x0015
            r3 = r9
            goto L_0x0019
        L_0x0015:
            java.util.List r3 = java.util.Collections.emptyList()
        L_0x0019:
            r0.zzaaz = r3
            r3 = 0
            if (r9 == 0) goto L_0x003f
            java.util.Iterator r4 = r9.iterator()
        L_0x0022:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x003f
            java.lang.Object r5 = r4.next()
            com.google.android.gms.internal.gtm.zzbk r5 = (com.google.android.gms.internal.gtm.zzbk) r5
            java.lang.String r6 = r5.getId()
            java.lang.String r7 = "appendVersion"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0022
            java.lang.String r4 = r5.getValue()
            goto L_0x0040
        L_0x003f:
            r4 = r3
        L_0x0040:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r3 = r4
        L_0x0048:
            r0.zzabe = r3
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Set r4 = r2.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0057:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0083
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            boolean r6 = zzc(r6)
            if (r6 == 0) goto L_0x0057
            java.lang.Object r6 = r5.getKey()
            java.lang.String r6 = zza(r1, r6)
            if (r6 == 0) goto L_0x0057
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = zzb(r1, r5)
            r3.put(r6, r5)
            goto L_0x0057
        L_0x0083:
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x008b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00b7
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            boolean r5 = zzc(r5)
            if (r5 != 0) goto L_0x008b
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = zza(r1, r5)
            if (r5 == 0) goto L_0x008b
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = zzb(r1, r4)
            r3.put(r5, r4)
            goto L_0x008b
        L_0x00b7:
            java.lang.String r1 = r0.zzabe
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00df
            java.lang.String r1 = r0.zzabe
            java.lang.String r2 = "_v"
            com.google.android.gms.internal.gtm.zzcz.zzb((java.util.Map<java.lang.String, java.lang.String>) r3, (java.lang.String) r2, (java.lang.String) r1)
            java.lang.String r1 = r0.zzabe
            java.lang.String r2 = "ma4.0.0"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00da
            java.lang.String r1 = r0.zzabe
            java.lang.String r2 = "ma4.0.1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00df
        L_0x00da:
            java.lang.String r1 = "adid"
            r3.remove(r1)
        L_0x00df:
            java.util.Map r1 = java.util.Collections.unmodifiableMap(r3)
            r0.zztc = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcd.<init>(com.google.android.gms.internal.gtm.zzam, java.util.Map, long, boolean, long, int, java.util.List):void");
    }

    private static boolean zzc(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    private static String zza(zzam zzam, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            zzam.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    private static String zzb(zzam zzam, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        String substring = obj2.substring(0, 8192);
        zzam.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    public final int zzff() {
        return this.zzabc;
    }

    public final Map<String, String> zzdm() {
        return this.zztc;
    }

    public final long zzfg() {
        return this.zzaba;
    }

    public final long zzfh() {
        return this.zzabb;
    }

    public final List<zzbk> zzfi() {
        return this.zzaaz;
    }

    public final boolean zzfj() {
        return this.zzabd;
    }

    public final long zzfk() {
        return zzcz.zzag(zzd("_s", AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    public final String zzfl() {
        return zzd("_m", "");
    }

    private final String zzd(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(!str.startsWith("&"), "Short param name required");
        String str3 = this.zztc.get(str);
        return str3 != null ? str3 : str2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ht=");
        sb.append(this.zzabb);
        if (this.zzaba != 0) {
            sb.append(", dbId=");
            sb.append(this.zzaba);
        }
        if (this.zzabc != 0) {
            sb.append(", appUID=");
            sb.append(this.zzabc);
        }
        ArrayList arrayList = new ArrayList(this.zztc.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            String str = (String) obj;
            sb.append(", ");
            sb.append(str);
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(this.zztc.get(str));
        }
        return sb.toString();
    }
}
