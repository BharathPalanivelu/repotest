package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

class b {
    public static Uri a(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }

    static class a {
        public static void a(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }
}