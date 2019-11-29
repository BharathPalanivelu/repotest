package com.modiface.mfemakeupkit.utils;

import android.content.Context;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import java.io.File;
import java.io.IOException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15353a = "AssetFilesCopier";

    public static boolean a(Context context, String str) {
        if (!(str == null || str.length() == 0)) {
            if (str.startsWith("asset://")) {
                str = str.substring(8);
            }
            String[] strArr = null;
            try {
                strArr = context.getAssets().list(str);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (strArr == null || strArr.length == 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: type inference failed for: r5v23 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(android.content.Context r4, java.lang.String r5, java.io.File r6) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x009a
            int r1 = r5.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x009a
        L_0x000b:
            java.lang.String r1 = "asset://"
            boolean r1 = r5.startsWith(r1)
            if (r1 == 0) goto L_0x0019
            r1 = 8
            java.lang.String r5 = r5.substring(r1)
        L_0x0019:
            r1 = 0
            boolean r2 = r6.exists()     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
            if (r2 == 0) goto L_0x0042
            boolean r2 = r6.isFile()     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
            if (r2 == 0) goto L_0x0027
            goto L_0x0042
        L_0x0027:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
            r5.<init>()     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
            java.lang.String r2 = r6.getPath()     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
            r5.append(r2)     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
            java.lang.String r2 = " must be a file."
            r5.append(r2)     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
            throw r4     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
        L_0x0042:
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
            java.io.InputStream r4 = r4.open(r5)     // Catch:{ IOException -> 0x0081, NullPointerException -> 0x007b, all -> 0x0077 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0071, NullPointerException -> 0x006b, all -> 0x0066 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0071, NullPointerException -> 0x006b, all -> 0x0066 }
            org.apache.commons.b.c.a(r4, r5)     // Catch:{ IOException -> 0x0061, NullPointerException -> 0x005c, all -> 0x005a }
            r0 = 1
            org.apache.commons.b.c.a((java.io.InputStream) r4)
            org.apache.commons.b.c.a((java.io.OutputStream) r5)
            goto L_0x008c
        L_0x005a:
            r6 = move-exception
            goto L_0x0069
        L_0x005c:
            r1 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
            goto L_0x007d
        L_0x0061:
            r1 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
            goto L_0x0083
        L_0x0066:
            r5 = move-exception
            r6 = r5
            r5 = r1
        L_0x0069:
            r1 = r4
            goto L_0x0093
        L_0x006b:
            r5 = move-exception
            r3 = r1
            r1 = r4
            r4 = r5
            r5 = r3
            goto L_0x007d
        L_0x0071:
            r5 = move-exception
            r3 = r1
            r1 = r4
            r4 = r5
            r5 = r3
            goto L_0x0083
        L_0x0077:
            r4 = move-exception
            r6 = r4
            r5 = r1
            goto L_0x0093
        L_0x007b:
            r4 = move-exception
            r5 = r1
        L_0x007d:
            r4.printStackTrace()     // Catch:{ all -> 0x0092 }
            goto L_0x0086
        L_0x0081:
            r4 = move-exception
            r5 = r1
        L_0x0083:
            r4.printStackTrace()     // Catch:{ all -> 0x0092 }
        L_0x0086:
            org.apache.commons.b.c.a((java.io.InputStream) r1)
            org.apache.commons.b.c.a((java.io.OutputStream) r5)
        L_0x008c:
            if (r0 != 0) goto L_0x0091
            r6.delete()
        L_0x0091:
            return r0
        L_0x0092:
            r6 = move-exception
        L_0x0093:
            org.apache.commons.b.c.a((java.io.InputStream) r1)
            org.apache.commons.b.c.a((java.io.OutputStream) r5)
            throw r6
        L_0x009a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.utils.a.b(android.content.Context, java.lang.String, java.io.File):boolean");
    }

    private static boolean c(Context context, String str, File file) {
        if (str.startsWith("asset://")) {
            str = str.substring(8);
        }
        try {
            String[] list = context.getAssets().list(str);
            String[] list2 = file.list();
            if (list != null) {
                if (list2 == null) {
                    list2 = new String[0];
                }
                if (list.length != list2.length) {
                    return false;
                }
                for (int i = 0; i < list.length; i++) {
                    if (!list[i].equalsIgnoreCase(list2[i])) {
                        return false;
                    }
                    if (!TextUtils.isEmpty(list[i])) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(Constants.URL_PATH_DELIMITER);
                        sb.append(list[i]);
                        if (!c(context, sb.toString(), new File(file, list[i]))) {
                            return false;
                        }
                    }
                }
                return true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not find asset folder: ");
            sb2.append(str);
            throw new RuntimeException(sb2.toString());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String a(String str) {
        int lastIndexOf = str.lastIndexOf(Constants.URL_PATH_DELIMITER) + 1;
        if (lastIndexOf < 0) {
            lastIndexOf = 0;
        }
        while (true) {
            int i = lastIndexOf + 1;
            if (!str.substring(lastIndexOf, i).equals(".")) {
                break;
            }
            lastIndexOf = i;
        }
        int indexOf = str.indexOf(".", lastIndexOf);
        if (indexOf >= 0 && indexOf < str.length() - 1) {
            return str.substring(indexOf + 1);
        }
        return null;
    }

    public static boolean a(Context context, String str, File file) {
        if (!(str == null || str.length() == 0 || file == null)) {
            if (!file.exists()) {
                file.mkdir();
            }
            if (str.startsWith("asset://")) {
                str = str.substring(8);
            }
            String[] strArr = null;
            try {
                strArr = context.getAssets().list(str);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (strArr != null && strArr.length > 0 && file.isDirectory()) {
                for (String str2 : strArr) {
                    if (Thread.currentThread().isInterrupted()) {
                        return false;
                    }
                    String str3 = str + Constants.URL_PATH_DELIMITER + str2;
                    if (a(context, str3)) {
                        if (!a(context, str3, new File(file, str2))) {
                            return false;
                        }
                    } else if (a(str2) != null && !b(context, str3, new File(file, str2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static String a(Context context, String str, String str2, boolean z) {
        File file = new File(context.getFilesDir(), str2);
        if (c(context, "asset://" + str, file)) {
            return file.getAbsolutePath();
        }
        if (z) {
            org.apache.commons.b.a.b(file);
        }
        a(context, str, file);
        return file.getAbsolutePath();
    }
}
