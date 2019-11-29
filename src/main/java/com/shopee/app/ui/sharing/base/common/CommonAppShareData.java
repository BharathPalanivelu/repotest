package com.shopee.app.ui.sharing.base.common;

import androidx.annotation.Keep;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.ui.sharing.base.data.ShareImage;
import com.shopee.app.ui.sharing.base.data.ShareVideo;
import d.d.b.j;

@Keep
public final class CommonAppShareData {
    private final ShareImage image;
    private final String text;
    private final ShareVideo video;

    public static /* synthetic */ CommonAppShareData copy$default(CommonAppShareData commonAppShareData, ShareImage shareImage, ShareVideo shareVideo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            shareImage = commonAppShareData.image;
        }
        if ((i & 2) != 0) {
            shareVideo = commonAppShareData.video;
        }
        if ((i & 4) != 0) {
            str = commonAppShareData.text;
        }
        return commonAppShareData.copy(shareImage, shareVideo, str);
    }

    public final ShareImage component1() {
        return this.image;
    }

    public final ShareVideo component2() {
        return this.video;
    }

    public final String component3() {
        return this.text;
    }

    public final CommonAppShareData copy(ShareImage shareImage, ShareVideo shareVideo, String str) {
        return new CommonAppShareData(shareImage, shareVideo, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommonAppShareData)) {
            return false;
        }
        CommonAppShareData commonAppShareData = (CommonAppShareData) obj;
        return j.a((Object) this.image, (Object) commonAppShareData.image) && j.a((Object) this.video, (Object) commonAppShareData.video) && j.a((Object) this.text, (Object) commonAppShareData.text);
    }

    public int hashCode() {
        ShareImage shareImage = this.image;
        int i = 0;
        int hashCode = (shareImage != null ? shareImage.hashCode() : 0) * 31;
        ShareVideo shareVideo = this.video;
        int hashCode2 = (hashCode + (shareVideo != null ? shareVideo.hashCode() : 0)) * 31;
        String str = this.text;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CommonAppShareData(image=" + this.image + ", video=" + this.video + ", text=" + this.text + SQLBuilder.PARENTHESES_RIGHT;
    }

    public CommonAppShareData(ShareImage shareImage, ShareVideo shareVideo, String str) {
        this.image = shareImage;
        this.video = shareVideo;
        this.text = str;
    }

    public final ShareImage getImage() {
        return this.image;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommonAppShareData(ShareImage shareImage, ShareVideo shareVideo, String str, int i, g gVar) {
        this(shareImage, (i & 2) != 0 ? null : shareVideo, str);
    }

    public final ShareVideo getVideo() {
        return this.video;
    }

    public final String getText() {
        return this.text;
    }
}
