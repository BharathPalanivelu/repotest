package cn.tongdun.android.core.ooxoxoooxooo0xx00;

import android.content.Context;
import android.content.pm.PackageInfo;
import cn.tongdun.android.shell.common.HelperJNI;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class x0ox00x0oooo0xxx {
    private static final String o00xx0xx0ooooo0xx00 = o00xxox0x0xoox("24797f6566776870", 127);
    private static final String oo0ooo0o00o0xo = o00xxox0x0xoox("24126210691160", 20);
    private static final String x0000xo0x0oooooo0 = o00xxox0x0xoox("236b61282d263871727e69626477", 110);
    private static final x0ox00x0oooo0xxx xo00x00xo00 = new x0ox00x0oooo0xxx();
    private String[] o00xxox0x0xoox = {o00xxox0x0xoox("231b61582d563801720e69126407", 30), o00xxox0x0xoox("233d617e2370243b7a2a693964396d30", 56), o00xxox0x0xoox("235061132a0e310838083d00320d34467e576a5a67526a", 85), o00xxox0x0xoox("2319615a235928447f1c60076606720b", 28), o00xxox0x0xoox("234161023e1a3f1d3f5c7c507a5e70", 68)};
    private Context x0ox00x0oooo0xxx;

    public static x0ox00x0oooo0xxx o00xxox0x0xoox() {
        return xo00x00xo00;
    }

    public String o00xxox0x0xoox(Context context) {
        this.x0ox00x0oooo0xxx = context.getApplicationContext();
        try {
            JSONObject oo0ooo0o00o0xo2 = oo0ooo0o00o0xo();
            JSONObject oo0ooo0o00o0xo3 = oo0ooo0o00o0xo(this.x0ox00x0oooo0xxx);
            String shooted = HelperJNI.shooted();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(o00xxox0x0xoox("233b6e3d6612570873227b79", 57), shooted);
            if (oo0ooo0o00o0xo2 == null && oo0ooo0o00o0xo3 == null && shooted == null && shooted == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (oo0ooo0o00o0xo2 != null) {
                jSONArray.put(oo0ooo0o00o0xo2);
            }
            if (oo0ooo0o00o0xo3 != null) {
                jSONArray.put(oo0ooo0o00o0xo3);
            }
            if (shooted != null) {
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private x0ox00x0oooo0xxx() {
    }

    private JSONObject oo0ooo0o00o0xo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            context.getPackageName();
            boolean z = false;
            String str = null;
            boolean z2 = false;
            for (PackageInfo next : context.getPackageManager().getInstalledPackages(0)) {
                if (next.packageName.equals(x0000xo0x0oooooo0)) {
                    z2 = true;
                }
                if (next.packageName.startsWith(oo0ooo0o00o0xo) || next.packageName.startsWith(o00xx0xx0ooooo0xx00)) {
                    str = next.packageName;
                    z = true;
                }
            }
            if (z && !z2) {
                JSONObject jSONObject = new JSONObject();
                if (str != null) {
                    jSONObject.put(o00xxox0x0xoox("23736e75665a5740736a7b", 113), str);
                } else {
                    jSONObject.put(o00xxox0x0xoox("234c6e4a6665577f73557b", 78), o00xxox0x0xoox("24517e55745d4d66413c12270b27", 73));
                }
                return jSONObject;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static JSONObject oo0ooo0o00o0xo() {
        JSONObject jSONObject = new JSONObject();
        String o00xx0xx0ooooo0xx002 = o00xx0xx0ooooo0xx00();
        if (!(o00xx0xx0ooooo0xx002 == null || o00xx0xx0ooooo0xx002.length() == 0)) {
            String o00xxox0x0xoox2 = o00xxox0x0xoox(o00xxox0x0xoox("3009", 3));
            if (o00xxox0x0xoox2 != null && !o00xxox0x0xoox2.isEmpty()) {
                String[] split = o00xxox0x0xoox2.split(o00xxox0x0xoox("4a", 54));
                if (split != null && split.length > 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (split[i2].contains(o00xx0xx0ooooo0xx002)) {
                            int lastIndexOf = split[i2].lastIndexOf(o00xxox0x0xoox("60", 83));
                            File file = new File(String.format(o00xxox0x0xoox("6f5a2a4f3f01740461112f1b79", 24), new Object[]{split[i2].substring(lastIndexOf <= 0 ? 0 : lastIndexOf + 1, split[i2].length()), Locale.CHINA}));
                            if (file.exists()) {
                                try {
                                    jSONObject.put(o00xxox0x0xoox("231b6e1d66235a2e1e", 25) + i2, file.getAbsolutePath());
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                                i++;
                            }
                        }
                    }
                    if (i > 1) {
                        return jSONObject;
                    }
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.io.BufferedOutputStream} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0065 A[SYNTHETIC, Splitter:B:33:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006f A[SYNTHETIC, Splitter:B:38:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0082 A[SYNTHETIC, Splitter:B:49:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008c A[SYNTHETIC, Splitter:B:54:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String o00xxox0x0xoox(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x007d, all -> 0x0060 }
            java.lang.String r2 = "3348"
            r3 = 90
            java.lang.String r2 = o00xxox0x0xoox(r2, r3)     // Catch:{ Exception -> 0x007d, all -> 0x0060 }
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ Exception -> 0x007d, all -> 0x0060 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r2.<init>(r3)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            java.io.InputStream r4 = r1.getInputStream()     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            byte[] r5 = r5.getBytes()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.write(r5)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r5 = 10
            r2.write(r5)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.flush()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.close()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r1.waitFor()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            java.lang.String r5 = o00xxox0x0xoox((java.io.BufferedInputStream) r3)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0044:
            r3.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.destroy()
        L_0x0051:
            return r5
        L_0x0052:
            r5 = move-exception
            r0 = r3
            goto L_0x0063
        L_0x0055:
            goto L_0x0080
        L_0x0057:
            r5 = move-exception
            goto L_0x0063
        L_0x0059:
            r3 = r0
            goto L_0x0080
        L_0x005b:
            r5 = move-exception
            r2 = r0
            goto L_0x0063
        L_0x005e:
            r2 = r0
            goto L_0x007f
        L_0x0060:
            r5 = move-exception
            r1 = r0
            r2 = r1
        L_0x0063:
            if (r2 == 0) goto L_0x006d
            r2.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r2 = move-exception
            r2.printStackTrace()
        L_0x006d:
            if (r0 == 0) goto L_0x0077
            r0.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0077:
            if (r1 == 0) goto L_0x007c
            r1.destroy()
        L_0x007c:
            throw r5
        L_0x007d:
            r1 = r0
            r2 = r1
        L_0x007f:
            r3 = r2
        L_0x0080:
            if (r2 == 0) goto L_0x008a
            r2.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008a:
            if (r3 == 0) goto L_0x0094
            r3.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0094:
            if (r1 == 0) goto L_0x0099
            r1.destroy()
        L_0x0099:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.tongdun.android.core.ooxoxoooxooo0xx00.x0ox00x0oooo0xxx.o00xxox0x0xoox(java.lang.String):java.lang.String");
    }

    private static String o00xxox0x0xoox(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } while (read >= 512);
        return sb.toString();
    }

    private static String o00xx0xx0ooooo0xx00() {
        String o00xxox0x0xoox2 = o00xxox0x0xoox(o00xxox0x0xoox("23407614794b7b56771a2b0c22066b4a6f5f724577", 75));
        if (!(o00xxox0x0xoox2 == null || o00xxox0x0xoox2.length() == 0)) {
            int lastIndexOf = o00xxox0x0xoox2.lastIndexOf(o00xxox0x0xoox("351378", 6));
            int lastIndexOf2 = o00xxox0x0xoox2.lastIndexOf(o00xxox0x0xoox("6f66366b", 48));
            if (lastIndexOf < 0) {
                return null;
            }
            if (lastIndexOf2 <= 0) {
                lastIndexOf2 = o00xxox0x0xoox2.length();
            }
            try {
                String replaceAll = o00xxox0x0xoox2.substring(lastIndexOf + 4, lastIndexOf2).replaceAll(o00xxox0x0xoox("4a", 90), "");
                if (!oo0ooo0o00o0xo(replaceAll)) {
                    return null;
                }
                int intValue = Integer.valueOf(replaceAll).intValue();
                return String.format(o00xxox0x0xoox("351d1a235e62", 81), new Object[]{Integer.valueOf(intValue - 10000)});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private static boolean oo0ooo0o00o0xo(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String o00xxox0x0xoox(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b2 = (byte) (i ^ 9);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 64);
            byte b3 = bArr[0];
            int i4 = 1;
            while (i4 < length2) {
                byte b4 = bArr[i4];
                bArr[i4] = (byte) ((b3 ^ bArr[i4]) ^ b2);
                i4++;
                b3 = b4;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
