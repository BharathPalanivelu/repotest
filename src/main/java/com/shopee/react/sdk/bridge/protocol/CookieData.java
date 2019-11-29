package com.shopee.react.sdk.bridge.protocol;

import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;

public class CookieData {
    private String domain;
    private String expires;
    private String name;
    private String path;
    private String value;

    public CookieData(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.domain = str2;
        this.path = str3;
        this.value = str4;
        this.expires = str5;
    }

    public String getName() {
        return this.name;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getPath() {
        return this.path;
    }

    public String getValue() {
        return this.value;
    }

    public String getExpires() {
        return this.expires;
    }

    public String getCookieString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.value);
        sb.append(";");
        if (!TextUtils.isEmpty(this.domain)) {
            sb.append("domain=");
            sb.append(this.domain);
            sb.append(";");
        }
        if (!TextUtils.isEmpty(this.path)) {
            sb.append("path=");
            sb.append(this.path);
            sb.append(";");
        }
        if (!TextUtils.isEmpty(this.expires)) {
            sb.append("expires=");
            sb.append(this.expires);
            sb.append(";");
        }
        return sb.toString();
    }
}
