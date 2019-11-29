package com.shopee.livequiz.d;

import com.shopee.livequiz.d.a.a;
import com.shopee.livequiz.d.a.c;
import com.shopee.livequiz.d.a.d;
import f.m;
import java.io.IOException;

public class b {
    public static <T> c<T> a(f.b<a<T>> bVar) {
        try {
            m<a<T>> a2 = bVar.a();
            if (!a2.d()) {
                return new c<>(a2.a(), "Network error!");
            }
            a e2 = a2.e();
            if (e2 != null && e2.err_code == 0) {
                return new c<>(e2.data, e2.err_msg);
            }
            if (e2 == null) {
                return new c<>(a2.a(), "No body!");
            }
            return new c<>(e2.err_code, e2.err_msg);
        } catch (IOException e3) {
            return new c<>(-99, e3.getMessage());
        }
    }

    public static <T> c<T> b(f.b<d<T>> bVar) {
        try {
            m<d<T>> a2 = bVar.a();
            if (!a2.d()) {
                return new c<>(a2.a(), "Network error!");
            }
            d e2 = a2.e();
            if (e2 != null && e2.err_code == 0) {
                return new c<>(e2.data, e2.err_msg);
            }
            if (e2 == null) {
                return new c<>(a2.a(), "No body!");
            }
            return new c<>(e2.err_code, e2.err_msg);
        } catch (IOException e3) {
            return new c<>(-99, e3.getMessage());
        }
    }

    public static <T> c<T> c(f.b<com.shopee.livequiz.d.a.b<T>> bVar) {
        try {
            m<com.shopee.livequiz.d.a.b<T>> a2 = bVar.a();
            if (!a2.d()) {
                return new c<>(-99, "Network error!");
            }
            com.shopee.livequiz.d.a.b e2 = a2.e();
            if (e2 != null) {
                return new c<>(e2.payload, "");
            }
            return new c<>(-99, "Null!!");
        } catch (IOException e3) {
            return new c<>(-99, e3.getMessage());
        }
    }
}
