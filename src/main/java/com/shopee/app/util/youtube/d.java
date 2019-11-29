package com.shopee.app.util.youtube;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.HashMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    protected String f26554a;

    public d(String str) {
        String[] split = str.split("&");
        HashMap hashMap = new HashMap();
        for (String split2 : split) {
            String[] split3 = split2.split(SimpleComparison.EQUAL_TO_OPERATION);
            if (split3 != null && split3.length >= 2) {
                hashMap.put(split3[0], split3[1]);
            }
        }
        this.f26554a = (String) hashMap.get("url");
    }

    public String a() {
        return this.f26554a;
    }
}
