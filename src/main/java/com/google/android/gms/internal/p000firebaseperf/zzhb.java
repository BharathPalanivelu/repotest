package com.google.android.gms.internal.p000firebaseperf;

import com.tencent.qcloud.core.util.IOUtils;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhb  reason: invalid package */
final class zzhb {
    static String zzd(zzdl zzdl) {
        zzhe zzhe = new zzhe(zzdl);
        StringBuilder sb = new StringBuilder(zzhe.size());
        for (int i = 0; i < zzhe.size(); i++) {
            byte zzq = zzhe.zzq(i);
            if (zzq == 34) {
                sb.append("\\\"");
            } else if (zzq == 39) {
                sb.append("\\'");
            } else if (zzq != 92) {
                switch (zzq) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zzq >= 32 && zzq <= 126) {
                            sb.append((char) zzq);
                            break;
                        } else {
                            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append((char) (((zzq >>> 6) & 3) + 48));
                            sb.append((char) (((zzq >>> 3) & 7) + 48));
                            sb.append((char) ((zzq & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
