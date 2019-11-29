package com.shopee.app.web.bridge.modules;

import d.a.j;
import d.h.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class TraceUrls {
    public static final TraceUrls INSTANCE = new TraceUrls();
    private static final ArrayList<String> SHOULD_START_TRACE_URLS = j.b((T[]) new String[]{"buyer/cart"});

    private TraceUrls() {
    }

    public final ArrayList<String> getSHOULD_START_TRACE_URLS() {
        return SHOULD_START_TRACE_URLS;
    }

    public final String shouldStartTrace(String str) {
        if (str == null) {
            return "";
        }
        Collection arrayList = new ArrayList();
        for (Object next : SHOULD_START_TRACE_URLS) {
            if (m.c(str, (String) next, false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (!list.isEmpty()) {
            return (String) list.get(0);
        }
        return "";
    }
}
