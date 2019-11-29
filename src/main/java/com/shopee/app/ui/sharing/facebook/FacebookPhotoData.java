package com.shopee.app.ui.sharing.facebook;

import androidx.annotation.Keep;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.ui.sharing.base.data.ShareImage;
import d.d.b.j;

@Keep
public final class FacebookPhotoData {
    private final ShareImage image;

    public static /* synthetic */ FacebookPhotoData copy$default(FacebookPhotoData facebookPhotoData, ShareImage shareImage, int i, Object obj) {
        if ((i & 1) != 0) {
            shareImage = facebookPhotoData.image;
        }
        return facebookPhotoData.copy(shareImage);
    }

    public final ShareImage component1() {
        return this.image;
    }

    public final FacebookPhotoData copy(ShareImage shareImage) {
        return new FacebookPhotoData(shareImage);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FacebookPhotoData) && j.a((Object) this.image, (Object) ((FacebookPhotoData) obj).image);
        }
        return true;
    }

    public int hashCode() {
        ShareImage shareImage = this.image;
        if (shareImage != null) {
            return shareImage.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "FacebookPhotoData(image=" + this.image + SQLBuilder.PARENTHESES_RIGHT;
    }

    public FacebookPhotoData(ShareImage shareImage) {
        this.image = shareImage;
    }

    public final ShareImage getImage() {
        return this.image;
    }
}
