package com.shopee.feeds.feedlibrary.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.util.TypedValue;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class l {

    public interface a {
        void a(String str);
    }

    public static String a(Context context, Bitmap bitmap, final a aVar) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "feeds");
        if (!file.exists()) {
            file.mkdir();
        }
        final File file2 = new File(file, System.currentTimeMillis() + ".jpg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            MediaScannerConnection.scanFile(context, new String[]{file2.getAbsolutePath()}, new String[]{"image/jpeg"}, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String str, Uri uri) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(file2.getPath());
                    }
                }
            });
            return "";
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int a(int i, Context context) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }
}
