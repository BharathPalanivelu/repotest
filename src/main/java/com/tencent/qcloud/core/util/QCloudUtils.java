package com.tencent.qcloud.core.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import java.io.File;

public class QCloudUtils {
    public static long getUriContentLength(Uri uri, ContentResolver contentResolver) {
        String scheme = uri.getScheme();
        if (UriUtil.LOCAL_CONTENT_SCHEME.equals(scheme)) {
            Cursor query = contentResolver.query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query == null) {
                return -1;
            }
            try {
                int columnIndex = query.getColumnIndex("_size");
                query.moveToFirst();
                return query.getLong(columnIndex);
            } finally {
                query.close();
            }
        } else if (UriUtil.LOCAL_FILE_SCHEME.equals(scheme)) {
            return new File(uri.getPath()).length();
        } else {
            return -1;
        }
    }
}
