package com.shopee.app.ui.sharing.copylink;

import androidx.annotation.Keep;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

@Keep
public final class CopyLinkData {
    private final String link;

    public static /* synthetic */ CopyLinkData copy$default(CopyLinkData copyLinkData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = copyLinkData.link;
        }
        return copyLinkData.copy(str);
    }

    public final String component1() {
        return this.link;
    }

    public final CopyLinkData copy(String str) {
        j.b(str, "link");
        return new CopyLinkData(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CopyLinkData) && j.a((Object) this.link, (Object) ((CopyLinkData) obj).link);
        }
        return true;
    }

    public int hashCode() {
        String str = this.link;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CopyLinkData(link=" + this.link + SQLBuilder.PARENTHESES_RIGHT;
    }

    public CopyLinkData(String str) {
        j.b(str, "link");
        this.link = str;
    }

    public final String getLink() {
        return this.link;
    }
}
