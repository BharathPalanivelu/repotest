package com.garena.pay.android.c;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private String f8179a;

    public d(HashMap<String, String> hashMap) {
        this.f8179a = "";
        Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (next.getValue() != null) {
                this.f8179a += URLEncoder.encode(next.getKey().toString()) + SimpleComparison.EQUAL_TO_OPERATION + URLEncoder.encode(next.getValue().toString());
                if (it.hasNext()) {
                    this.f8179a += "&";
                }
            }
        }
    }

    public d() {
        this.f8179a = "";
        this.f8179a = "";
    }

    public String toString() {
        return this.f8179a;
    }
}
