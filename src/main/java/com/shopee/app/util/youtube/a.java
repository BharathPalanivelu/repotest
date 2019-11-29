package com.shopee.app.util.youtube;

import com.appsflyer.share.Constants;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected int f26553a;

    public a(String str) {
        this.f26553a = Integer.parseInt(str.split(Constants.URL_PATH_DELIMITER)[0]);
    }

    public a(int i) {
        this.f26553a = i;
    }

    public int a() {
        return this.f26553a;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof a) && ((a) obj).f26553a == this.f26553a) {
            return true;
        }
        return false;
    }
}
