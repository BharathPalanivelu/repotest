package com.shopee.app.ui.sharing.base.data;

import androidx.annotation.Keep;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

@Keep
public final class ShareImage {
    private final String imageBase64;
    private final String imageUrl;

    public static /* synthetic */ ShareImage copy$default(ShareImage shareImage, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareImage.imageUrl;
        }
        if ((i & 2) != 0) {
            str2 = shareImage.imageBase64;
        }
        return shareImage.copy(str, str2);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final String component2() {
        return this.imageBase64;
    }

    public final ShareImage copy(String str, String str2) {
        return new ShareImage(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareImage)) {
            return false;
        }
        ShareImage shareImage = (ShareImage) obj;
        return j.a((Object) this.imageUrl, (Object) shareImage.imageUrl) && j.a((Object) this.imageBase64, (Object) shareImage.imageBase64);
    }

    public int hashCode() {
        String str = this.imageUrl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.imageBase64;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ShareImage(imageUrl=" + this.imageUrl + ", imageBase64=" + this.imageBase64 + SQLBuilder.PARENTHESES_RIGHT;
    }

    public ShareImage(String str, String str2) {
        this.imageUrl = str;
        this.imageBase64 = str2;
    }

    public final String getImageBase64() {
        return this.imageBase64;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }
}
