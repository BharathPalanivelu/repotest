package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzmg extends zzhb {
    private static final Set<String> zzarz = new HashSet(Arrays.asList(new String[]{"GET", "HEAD", "POST", "PUT"}));
    private final zzei zzary;

    public zzmg(zzei zzei) {
        this.zzary = zzei;
    }

    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        HashMap hashMap;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 1);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzok);
        zzoa<?> zzco = zzoaArr[0].zzco("url");
        Preconditions.checkArgument(zzco instanceof zzom);
        String str = (String) ((zzom) zzco).value();
        zzoa<?> zzco2 = zzoaArr[0].zzco("method");
        if (zzco2 == zzog.zzaum) {
            zzco2 = new zzom("GET");
        }
        Preconditions.checkArgument(zzco2 instanceof zzom);
        String str2 = (String) ((zzom) zzco2).value();
        Preconditions.checkArgument(zzarz.contains(str2));
        zzoa<?> zzco3 = zzoaArr[0].zzco("uniqueId");
        Preconditions.checkArgument(zzco3 == zzog.zzaum || zzco3 == zzog.zzaul || (zzco3 instanceof zzom));
        String str3 = (zzco3 == zzog.zzaum || zzco3 == zzog.zzaul) ? null : (String) ((zzom) zzco3).value();
        zzoa<?> zzco4 = zzoaArr[0].zzco("headers");
        Preconditions.checkArgument(zzco4 == zzog.zzaum || (zzco4 instanceof zzok));
        HashMap hashMap2 = new HashMap();
        if (zzco4 == zzog.zzaum) {
            hashMap = null;
        } else {
            for (Map.Entry entry : ((Map) ((zzok) zzco4).value()).entrySet()) {
                String str4 = (String) entry.getKey();
                zzoa zzoa = (zzoa) entry.getValue();
                if (!(zzoa instanceof zzom)) {
                    zzev.zzac(String.format("Ignore the non-string value of header key %s.", new Object[]{str4}));
                } else {
                    hashMap2.put(str4, (String) ((zzom) zzoa).value());
                }
            }
            hashMap = hashMap2;
        }
        zzoa<?> zzco5 = zzoaArr[0].zzco("body");
        Preconditions.checkArgument(zzco5 == zzog.zzaum || (zzco5 instanceof zzom));
        String str5 = zzco5 == zzog.zzaum ? null : (String) ((zzom) zzco5).value();
        if ((str2.equals("GET") || str2.equals("HEAD")) && str5 != null) {
            zzev.zzac(String.format("Body of %s hit will be ignored: %s.", new Object[]{str2, str5}));
        }
        this.zzary.zza(str, str2, str3, hashMap, str5);
        zzev.zzab(String.format("QueueRequest:\n  url = %s,\n  method = %s,\n  uniqueId = %s,\n  headers = %s,\n  body = %s", new Object[]{str, str2, str3, hashMap, str5}));
        return zzog.zzaum;
    }
}
