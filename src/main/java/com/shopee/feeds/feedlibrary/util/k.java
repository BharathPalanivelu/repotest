package com.shopee.feeds.feedlibrary.util;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.shopee.feeds.feedlibrary.b;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Callable;

public class k {
    public static String a(String str) {
        try {
            return a(MessageDigest.getInstance("md5").digest(str.getBytes()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return ".jpg";
        }
        String[] split = str.split(".");
        if (split == null || split.length <= 0) {
            return ".jpg";
        }
        return split[split.length - 1];
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return true;
        }
        return false;
    }

    static String[] d(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            str2 = str.substring(lastIndexOf);
            str = substring;
        } else {
            str2 = "";
        }
        return new String[]{str, str2};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (r8 == null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r8 != null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        r8.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String a(android.content.Context r8, android.net.Uri r9) {
        /*
            java.lang.String r0 = r9.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0042
            android.content.ContentResolver r2 = r8.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r9
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)
            if (r8 == 0) goto L_0x003d
            boolean r0 = r8.moveToFirst()     // Catch:{ Exception -> 0x0030 }
            if (r0 == 0) goto L_0x003d
            java.lang.String r0 = "_display_name"
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r0 = r8.getString(r0)     // Catch:{ Exception -> 0x0030 }
            r1 = r0
            goto L_0x003d
        L_0x002e:
            r9 = move-exception
            goto L_0x0037
        L_0x0030:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x002e }
            if (r8 == 0) goto L_0x0042
            goto L_0x003f
        L_0x0037:
            if (r8 == 0) goto L_0x003c
            r8.close()
        L_0x003c:
            throw r9
        L_0x003d:
            if (r8 == 0) goto L_0x0042
        L_0x003f:
            r8.close()
        L_0x0042:
            if (r1 != 0) goto L_0x0057
            java.lang.String r1 = r9.getPath()
            java.lang.String r8 = java.io.File.separator
            int r8 = r1.lastIndexOf(r8)
            r9 = -1
            if (r8 == r9) goto L_0x0057
            int r8 = r8 + 1
            java.lang.String r1 = r1.substring(r8)
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.util.k.a(android.content.Context, android.net.Uri):java.lang.String");
    }

    static String b(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return uri.getPath();
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("_data"));
        query.close();
        return string;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str) {
        try {
            if (!d.a(str)) {
                a(context, new File(str));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(final Context context, final ArrayList<String> arrayList) {
        a.k.a(new Callable<Object>() {
            public Object call() throws Exception {
                ArrayList arrayList = arrayList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return null;
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    if (!d.a((String) arrayList.get(i))) {
                        k.a(context, new File((String) arrayList.get(i)));
                    }
                }
                return null;
            }
        });
    }

    public static void a(Context context, File file) {
        if (file.isFile() && file.exists() && context != null) {
            file.delete();
            MediaScannerConnection.scanFile(b.b().c(), new String[]{file.getAbsolutePath()}, (String[]) null, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String str, Uri uri) {
                }
            });
        }
    }

    public static void e(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String a(Context context, Bitmap bitmap) {
        File file = new File(q.a(context, "feedCover_" + UUID.randomUUID().toString().replace("-", "") + ".jpg"));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file.getAbsolutePath();
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int a(File file) {
        return (int) (file.length() / IjkMediaMeta.AV_CH_SIDE_RIGHT);
    }

    public static int f(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return (int) (file.length() / IjkMediaMeta.AV_CH_SIDE_RIGHT);
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String g(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.getName();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(String str, String str2) {
        String str3 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "feeds";
        e(str3);
        try {
            FileWriter fileWriter = new FileWriter(new File(str3, str), false);
            fileWriter.write(str2);
            fileWriter.flush();
            fileWriter.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String h(String str) {
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "feeds";
        e(str2);
        File file = new File(str2, str);
        if (!file.exists()) {
            return "";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return new String(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
