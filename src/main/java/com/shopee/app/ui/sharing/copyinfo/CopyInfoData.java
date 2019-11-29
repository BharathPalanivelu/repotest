package com.shopee.app.ui.sharing.copyinfo;

import androidx.annotation.Keep;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

@Keep
public final class CopyInfoData {
    private final String content;

    public static /* synthetic */ CopyInfoData copy$default(CopyInfoData copyInfoData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = copyInfoData.content;
        }
        return copyInfoData.copy(str);
    }

    public final String component1() {
        return this.content;
    }

    public final CopyInfoData copy(String str) {
        return new CopyInfoData(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CopyInfoData) && j.a((Object) this.content, (Object) ((CopyInfoData) obj).content);
        }
        return true;
    }

    public int hashCode() {
        String str = this.content;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CopyInfoData(content=" + this.content + SQLBuilder.PARENTHESES_RIGHT;
    }

    public CopyInfoData(String str) {
        this.content = str;
    }

    public final String getContent() {
        return this.content;
    }
}
