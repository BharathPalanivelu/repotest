package com.google.android.gms.internal.firebase_remote_config;

import com.appsflyer.share.Constants;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzg {
    private static final zzg zzz = new zzg();
    private final String zzaa;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzg() {
        /*
            r4 = this;
            java.lang.String r0 = "java.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            java.lang.String r1 = "9"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0011
            java.lang.String r0 = "9.0.0"
            goto L_0x0015
        L_0x0011:
            java.lang.String r0 = zzh(r0)
        L_0x0015:
            com.google.android.gms.internal.firebase_remote_config.zzdz r1 = com.google.android.gms.internal.firebase_remote_config.zzdz.OS_NAME
            java.lang.String r1 = r1.value()
            com.google.android.gms.internal.firebase_remote_config.zzdz r2 = com.google.android.gms.internal.firebase_remote_config.zzdz.OS_VERSION
            java.lang.String r2 = r2.value()
            java.lang.String r3 = com.google.android.gms.internal.firebase_remote_config.zzb.VERSION
            r4.<init>(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzg.<init>():void");
    }

    private zzg(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder("java/");
        sb.append(zzh(str));
        sb.append(" http-google-%s/");
        sb.append(zzh(str4));
        if (!(str2 == null || str3 == null)) {
            sb.append(SQLBuilder.BLANK);
            sb.append(zzg(str2));
            sb.append(Constants.URL_PATH_DELIMITER);
            sb.append(zzh(str3));
        }
        this.zzaa = sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zzf(String str) {
        return String.format(this.zzaa, new Object[]{zzg(str)});
    }

    /* access modifiers changed from: private */
    public static zzg zzj() {
        return zzz;
    }

    private static String zzg(String str) {
        return str.toLowerCase().replaceAll("[^\\w\\d\\-]", "-");
    }

    private static String zzh(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\d+\\.\\d+\\.\\d+).*").matcher(str);
        return matcher.find() ? matcher.group(1) : str;
    }
}
