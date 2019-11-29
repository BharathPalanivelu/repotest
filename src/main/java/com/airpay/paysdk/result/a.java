package com.airpay.paysdk.result;

import android.text.TextUtils;
import com.litesuits.orm.db.assit.SQLBuilder;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f4441a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f4442b = null;

    public a(String str, String str2) {
        this.f4442b = str;
        this.f4441a = str2;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f4441a) || TextUtils.isEmpty(this.f4442b)) {
            return "";
        }
        return SQLBuilder.PARENTHESES_LEFT + this.f4441a + SQLBuilder.PARENTHESES_RIGHT;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f4442b)) {
            return this.f4441a;
        }
        return this.f4442b;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f4442b)) {
            return this.f4441a;
        }
        if (TextUtils.isEmpty(this.f4441a)) {
            return this.f4442b;
        }
        return String.format("%1$s (%2$s)", new Object[]{this.f4442b, this.f4441a});
    }
}
