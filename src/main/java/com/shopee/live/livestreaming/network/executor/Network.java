package com.shopee.live.livestreaming.network.executor;

import com.shopee.e.a.a;
import f.b;
import f.m;
import java.io.IOException;
import okhttp3.HttpUrl;

public class Network {
    public static <T> NetworkData<T> get(b<ServerResult<T>> bVar) {
        try {
            m<ServerResult<T>> a2 = bVar.a();
            if (a2.d()) {
                ServerResult<T> e2 = a2.e();
                if (e2 != null && e2.getErr_code() == 0) {
                    return new NetworkData<>(e2.getData(), e2.getErr_msg());
                }
                if (e2 == null) {
                    log("Http request error: No body.", bVar);
                    return new NetworkData<>(a2.a(), "No body!");
                }
                log("Http request error: " + e2.getErr_code() + "," + e2.getErr_msg(), bVar);
                return new NetworkData<>(e2.getErr_code(), e2.getErr_msg());
            }
            log("Http request error: Network error.", bVar);
            return new NetworkData<>(a2.a(), "Network error!");
        } catch (IOException e3) {
            log("Http request error: io exception", bVar);
            return new NetworkData<>(-99, e3.getMessage());
        }
    }

    public static <T> NetworkData<T> get2(b<ServerResult2<T>> bVar) {
        try {
            m<ServerResult2<T>> a2 = bVar.a();
            if (!a2.d()) {
                return new NetworkData<>(a2.a(), "Network error!");
            }
            ServerResult2<T> e2 = a2.e();
            if (e2 != null && e2.getCode() == 0) {
                return new NetworkData<>(e2.getData(), e2.getMsg());
            }
            if (e2 == null) {
                log("Http request error: No body.", bVar);
                return new NetworkData<>(a2.a(), "No body!");
            }
            log("Http request error: " + e2.getCode() + "," + e2.getMsg(), bVar);
            return new NetworkData<>(e2.getCode(), e2.getMsg());
        } catch (IOException e3) {
            log("Http request error: io exception", bVar);
            return new NetworkData<>(-99, e3.getMessage());
        }
    }

    private static <T> void log(String str, b<T> bVar) {
        if (bVar != null && bVar.e() != null) {
            HttpUrl url = bVar.e().url();
            a.b(str + " req = " + url, new Object[0]);
        }
    }
}
