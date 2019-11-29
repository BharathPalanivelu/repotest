package com.shopee.app.network.c.e;

import com.shopee.app.network.a.a;
import com.squareup.wire.Message;

public interface b<T extends Message> extends a<T> {
    int a();

    void a(String str, T t);

    int b();
}
