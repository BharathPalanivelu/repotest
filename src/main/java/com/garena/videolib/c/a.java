package com.garena.videolib.c;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;

public class a {
    public static String a(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 60;
        long j4 = j3 / 60;
        String b2 = b(j4);
        String b3 = b(j3 % 60);
        String b4 = b(j2 % 60);
        StringBuilder sb = new StringBuilder();
        if (j4 > 0) {
            sb.append(b2);
            sb.append(":");
        }
        sb.append(b3);
        sb.append(":");
        sb.append(b4);
        return sb.toString();
    }

    private static String b(long j) {
        if (j >= 10) {
            return String.valueOf(j);
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_NO + j;
    }

    public static long a(Context context, String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
        return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
    }
}
