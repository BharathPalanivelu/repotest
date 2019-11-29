package com.tencent.qalsdk.sdk;

import com.tencent.qalsdk.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, x> f32230a = new ConcurrentHashMap<>();

    public static int a(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return -1;
        }
        if (toServiceMsg.getServiceName().equals(v.a().b())) {
            return v.a().a(toServiceMsg);
        }
        if (!f32230a.containsKey(toServiceMsg.getServiceName())) {
            f32230a.putIfAbsent(toServiceMsg.getServiceName(), new x(toServiceMsg.getServiceName()));
        }
        return f32230a.get(toServiceMsg.getServiceName()).b(toServiceMsg);
    }
}
