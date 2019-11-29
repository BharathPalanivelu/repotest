package com.shopee.app.ui.sharing.base.data;

import androidx.annotation.Keep;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

@Keep
public final class ShareVideo {
    private final String videoUrl;

    public static /* synthetic */ ShareVideo copy$default(ShareVideo shareVideo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareVideo.videoUrl;
        }
        return shareVideo.copy(str);
    }

    public final String component1() {
        return this.videoUrl;
    }

    public final ShareVideo copy(String str) {
        return new ShareVideo(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ShareVideo) && j.a((Object) this.videoUrl, (Object) ((ShareVideo) obj).videoUrl);
        }
        return true;
    }

    public int hashCode() {
        String str = this.videoUrl;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ShareVideo(videoUrl=" + this.videoUrl + SQLBuilder.PARENTHESES_RIGHT;
    }

    public ShareVideo(String str) {
        this.videoUrl = str;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }
}
