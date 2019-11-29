package com.google.android.gms.internal.firebase_remote_config;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qcloud.core.util.IOUtils;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzy {
    private static final Pattern zzap = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
    private static final Pattern zzaq = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
    private static final Pattern zzar;
    private static final Pattern zzas;
    private String type = "application";
    private String zzat = "octet-stream";
    private final SortedMap<String, String> zzau = new TreeMap();
    private String zzav;

    public zzy(String str) {
        Matcher matcher = zzar.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (zzap.matcher(group).matches()) {
                this.type = group;
                this.zzav = null;
                String group2 = matcher.group(2);
                if (zzap.matcher(group2).matches()) {
                    this.zzat = group2;
                    this.zzav = null;
                    String group3 = matcher.group(3);
                    if (group3 != null) {
                        Matcher matcher2 = zzas.matcher(group3);
                        while (matcher2.find()) {
                            String group4 = matcher2.group(1);
                            String group5 = matcher2.group(3);
                            if (group5 == null) {
                                group5 = matcher2.group(2);
                            }
                            zza(group4, group5);
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Subtype contains reserved characters");
            }
            throw new IllegalArgumentException("Type contains reserved characters");
        }
        throw new IllegalArgumentException("Type must be in the 'maintype/subtype; parameter=value' format");
    }

    private final zzy zza(String str, String str2) {
        if (str2 == null) {
            this.zzav = null;
            this.zzau.remove(str.toLowerCase(Locale.US));
            return this;
        } else if (zzaq.matcher(str).matches()) {
            this.zzav = null;
            this.zzau.put(str.toLowerCase(Locale.US), str2);
            return this;
        } else {
            throw new IllegalArgumentException("Name contains reserved characters");
        }
    }

    static boolean zzv(String str) {
        return zzaq.matcher(str).matches();
    }

    public final String zzp() {
        String str = this.zzav;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.type);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(this.zzat);
        SortedMap<String, String> sortedMap = this.zzau;
        if (sortedMap != null) {
            for (Map.Entry next : sortedMap.entrySet()) {
                String str2 = (String) next.getValue();
                sb.append("; ");
                sb.append((String) next.getKey());
                sb.append(SimpleComparison.EQUAL_TO_OPERATION);
                if (!zzv(str2)) {
                    String replace = str2.replace("\\", "\\\\").replace("\"", "\\\"");
                    StringBuilder sb2 = new StringBuilder(String.valueOf(replace).length() + 2);
                    sb2.append("\"");
                    sb2.append(replace);
                    sb2.append("\"");
                    str2 = sb2.toString();
                }
                sb.append(str2);
            }
        }
        this.zzav = sb.toString();
        return this.zzav;
    }

    public final String toString() {
        return zzp();
    }

    private final boolean zza(zzy zzy) {
        return zzy != null && this.type.equalsIgnoreCase(zzy.type) && this.zzat.equalsIgnoreCase(zzy.zzat);
    }

    public static boolean zzb(String str, String str2) {
        return str2 != null && new zzy(str).zza(new zzy(str2));
    }

    public final zzy zza(Charset charset) {
        zza("charset", charset == null ? null : charset.name());
        return this;
    }

    public final Charset zzr() {
        String str = (String) this.zzau.get("charset".toLowerCase(Locale.US));
        if (str == null) {
            return null;
        }
        return Charset.forName(str);
    }

    public final int hashCode() {
        return zzp().hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzy)) {
            return false;
        }
        zzy zzy = (zzy) obj;
        if (!zza(zzy) || !this.zzau.equals(zzy.zzau)) {
            return false;
        }
        return true;
    }

    static {
        StringBuilder sb = new StringBuilder("[^\\s/=;\"]+".length() + 14 + "[^\\s/=;\"]+".length() + ";.*".length());
        sb.append("\\s*(");
        sb.append("[^\\s/=;\"]+");
        sb.append(")/(");
        sb.append("[^\\s/=;\"]+");
        sb.append(")\\s*(");
        sb.append(";.*");
        sb.append(")?");
        zzar = Pattern.compile(sb.toString(), 32);
        StringBuilder sb2 = new StringBuilder("\"([^\"]*)\"".length() + 1 + "[^\\s;\"]*".length());
        sb2.append("\"([^\"]*)\"");
        sb2.append("|");
        sb2.append("[^\\s;\"]*");
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder("[^\\s/=;\"]+".length() + 12 + String.valueOf(sb3).length());
        sb4.append("\\s*;\\s*(");
        sb4.append("[^\\s/=;\"]+");
        sb4.append(")=(");
        sb4.append(sb3);
        sb4.append(SQLBuilder.PARENTHESES_RIGHT);
        zzas = Pattern.compile(sb4.toString());
    }
}
