package com.shopee.react.sdk.bridge.protocol;

import com.facebook.share.internal.ShareConstants;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class PrintBitmapReq {
    private final String uri;

    public static /* synthetic */ PrintBitmapReq copy$default(PrintBitmapReq printBitmapReq, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = printBitmapReq.uri;
        }
        return printBitmapReq.copy(str);
    }

    public final String component1() {
        return this.uri;
    }

    public final PrintBitmapReq copy(String str) {
        j.b(str, ShareConstants.MEDIA_URI);
        return new PrintBitmapReq(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PrintBitmapReq) && j.a((Object) this.uri, (Object) ((PrintBitmapReq) obj).uri);
        }
        return true;
    }

    public int hashCode() {
        String str = this.uri;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "PrintBitmapReq(uri=" + this.uri + SQLBuilder.PARENTHESES_RIGHT;
    }

    public PrintBitmapReq(String str) {
        j.b(str, ShareConstants.MEDIA_URI);
        this.uri = str;
    }

    public final String getUri() {
        return this.uri;
    }
}
