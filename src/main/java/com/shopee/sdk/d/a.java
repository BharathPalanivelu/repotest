package com.shopee.sdk.d;

import android.text.TextUtils;
import java.util.regex.Pattern;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f30344a;

    /* renamed from: b  reason: collision with root package name */
    private String f30345b;

    /* renamed from: c  reason: collision with root package name */
    private Pattern f30346c;

    private a(String str, String str2) {
        this.f30344a = str;
        this.f30345b = str2;
    }

    public static a a(String str) {
        return new a(str, (String) null);
    }

    public String a() {
        return this.f30344a;
    }

    public Pattern b() {
        if (this.f30346c != null || !c()) {
            return null;
        }
        this.f30346c = Pattern.compile(this.f30345b);
        return null;
    }

    public boolean c() {
        return !TextUtils.isEmpty(this.f30345b);
    }
}
