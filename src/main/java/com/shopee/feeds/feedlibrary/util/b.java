package com.shopee.feeds.feedlibrary.util;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import java.io.File;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28256a = "b";

    public static void a(Context context, String str, long j, long j2) {
        a(context, str, j, 0, 0, j2);
    }

    private static ContentValues a(String str, long j) {
        ContentValues contentValues = new ContentValues();
        File file = new File(str);
        long a2 = a(j);
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("date_modified", Long.valueOf(a2));
        contentValues.put("date_added", Long.valueOf(a2));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }

    public static void a(Context context, String str, long j, int i, int i2, long j2) {
        if (b(str)) {
            long a2 = a(j);
            ContentValues a3 = a(str, a2);
            a3.put("datetaken", Long.valueOf(a2));
            if (j2 > 0) {
                a3.put("duration", Long.valueOf(j2));
            }
            if (Build.VERSION.SDK_INT > 16) {
                if (i > 0) {
                    a3.put("width", Integer.valueOf(i));
                }
                if (i2 > 0) {
                    a3.put("height", Integer.valueOf(i2));
                }
            }
            a3.put("mime_type", a(str));
            context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, a3);
            a(context);
        }
    }

    private static String a(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.endsWith("mp4") || lowerCase.endsWith("mpeg4") || !lowerCase.endsWith("3gp")) {
            return "video/mp4";
        }
        return "video/3gp";
    }

    private static long a(long j) {
        return j <= 0 ? System.currentTimeMillis() : j;
    }

    private static boolean b(String str) {
        return new File(str).exists();
    }

    private static void a(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
        context.sendBroadcast(intent);
    }
}
