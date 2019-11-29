package com.shopee.feeds.feedlibrary.util.c;

import android.media.ThumbnailUtils;
import com.squareup.a.ab;
import com.squareup.a.w;
import com.squareup.a.z;
import java.io.IOException;

public class b extends ab {
    public boolean a(z zVar) {
        return "video".equals(zVar.f30601d.getScheme());
    }

    public ab.a a(z zVar, int i) throws IOException {
        return new ab.a(ThumbnailUtils.createVideoThumbnail(zVar.f30601d.getPath(), 1), w.d.DISK);
    }
}
