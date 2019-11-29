package com.shopee.app.ui.sharing.instagram;

import androidx.annotation.Keep;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.ui.sharing.base.data.ShareImage;
import com.shopee.app.ui.sharing.base.data.ShareVideo;
import d.d.b.j;

@Keep
public final class InstagramStoryAppShareData {
    private final ShareImage image;
    private final String linkUrl;
    private final ShareVideo video;

    public static /* synthetic */ InstagramStoryAppShareData copy$default(InstagramStoryAppShareData instagramStoryAppShareData, ShareImage shareImage, ShareVideo shareVideo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            shareImage = instagramStoryAppShareData.image;
        }
        if ((i & 2) != 0) {
            shareVideo = instagramStoryAppShareData.video;
        }
        if ((i & 4) != 0) {
            str = instagramStoryAppShareData.linkUrl;
        }
        return instagramStoryAppShareData.copy(shareImage, shareVideo, str);
    }

    public final ShareImage component1() {
        return this.image;
    }

    public final ShareVideo component2() {
        return this.video;
    }

    public final String component3() {
        return this.linkUrl;
    }

    public final InstagramStoryAppShareData copy(ShareImage shareImage, ShareVideo shareVideo, String str) {
        return new InstagramStoryAppShareData(shareImage, shareVideo, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InstagramStoryAppShareData)) {
            return false;
        }
        InstagramStoryAppShareData instagramStoryAppShareData = (InstagramStoryAppShareData) obj;
        return j.a((Object) this.image, (Object) instagramStoryAppShareData.image) && j.a((Object) this.video, (Object) instagramStoryAppShareData.video) && j.a((Object) this.linkUrl, (Object) instagramStoryAppShareData.linkUrl);
    }

    public int hashCode() {
        ShareImage shareImage = this.image;
        int i = 0;
        int hashCode = (shareImage != null ? shareImage.hashCode() : 0) * 31;
        ShareVideo shareVideo = this.video;
        int hashCode2 = (hashCode + (shareVideo != null ? shareVideo.hashCode() : 0)) * 31;
        String str = this.linkUrl;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "InstagramStoryAppShareData(image=" + this.image + ", video=" + this.video + ", linkUrl=" + this.linkUrl + SQLBuilder.PARENTHESES_RIGHT;
    }

    public InstagramStoryAppShareData(ShareImage shareImage, ShareVideo shareVideo, String str) {
        this.image = shareImage;
        this.video = shareVideo;
        this.linkUrl = str;
    }

    public final ShareImage getImage() {
        return this.image;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InstagramStoryAppShareData(ShareImage shareImage, ShareVideo shareVideo, String str, int i, g gVar) {
        this(shareImage, (i & 2) != 0 ? null : shareVideo, str);
    }

    public final ShareVideo getVideo() {
        return this.video;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }
}
