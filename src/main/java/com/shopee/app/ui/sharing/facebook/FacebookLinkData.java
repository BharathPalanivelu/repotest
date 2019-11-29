package com.shopee.app.ui.sharing.facebook;

import androidx.annotation.Keep;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

@Keep
public final class FacebookLinkData {
    private final String contentUrl;
    private final String hashTag;
    private final String quote;

    public static /* synthetic */ FacebookLinkData copy$default(FacebookLinkData facebookLinkData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = facebookLinkData.contentUrl;
        }
        if ((i & 2) != 0) {
            str2 = facebookLinkData.hashTag;
        }
        if ((i & 4) != 0) {
            str3 = facebookLinkData.quote;
        }
        return facebookLinkData.copy(str, str2, str3);
    }

    public final String component1() {
        return this.contentUrl;
    }

    public final String component2() {
        return this.hashTag;
    }

    public final String component3() {
        return this.quote;
    }

    public final FacebookLinkData copy(String str, String str2, String str3) {
        return new FacebookLinkData(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FacebookLinkData)) {
            return false;
        }
        FacebookLinkData facebookLinkData = (FacebookLinkData) obj;
        return j.a((Object) this.contentUrl, (Object) facebookLinkData.contentUrl) && j.a((Object) this.hashTag, (Object) facebookLinkData.hashTag) && j.a((Object) this.quote, (Object) facebookLinkData.quote);
    }

    public int hashCode() {
        String str = this.contentUrl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.hashTag;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.quote;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "FacebookLinkData(contentUrl=" + this.contentUrl + ", hashTag=" + this.hashTag + ", quote=" + this.quote + SQLBuilder.PARENTHESES_RIGHT;
    }

    public FacebookLinkData(String str, String str2, String str3) {
        this.contentUrl = str;
        this.hashTag = str2;
        this.quote = str3;
    }

    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final String getHashTag() {
        return this.hashTag;
    }

    public final String getQuote() {
        return this.quote;
    }
}
