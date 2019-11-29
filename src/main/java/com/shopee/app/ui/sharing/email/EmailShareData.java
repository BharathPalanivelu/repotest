package com.shopee.app.ui.sharing.email;

import androidx.annotation.Keep;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.ui.sharing.base.data.ShareImage;
import d.d.b.j;

@Keep
public final class EmailShareData {
    private final String content;
    private final ShareImage image;
    private final String title;

    public static /* synthetic */ EmailShareData copy$default(EmailShareData emailShareData, String str, String str2, ShareImage shareImage, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emailShareData.title;
        }
        if ((i & 2) != 0) {
            str2 = emailShareData.content;
        }
        if ((i & 4) != 0) {
            shareImage = emailShareData.image;
        }
        return emailShareData.copy(str, str2, shareImage);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final ShareImage component3() {
        return this.image;
    }

    public final EmailShareData copy(String str, String str2, ShareImage shareImage) {
        return new EmailShareData(str, str2, shareImage);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmailShareData)) {
            return false;
        }
        EmailShareData emailShareData = (EmailShareData) obj;
        return j.a((Object) this.title, (Object) emailShareData.title) && j.a((Object) this.content, (Object) emailShareData.content) && j.a((Object) this.image, (Object) emailShareData.image);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ShareImage shareImage = this.image;
        if (shareImage != null) {
            i = shareImage.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "EmailShareData(title=" + this.title + ", content=" + this.content + ", image=" + this.image + SQLBuilder.PARENTHESES_RIGHT;
    }

    public EmailShareData(String str, String str2, ShareImage shareImage) {
        this.title = str;
        this.content = str2;
        this.image = shareImage;
    }

    public final String getContent() {
        return this.content;
    }

    public final ShareImage getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }
}
