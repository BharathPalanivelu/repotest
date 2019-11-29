package com.shopee.shopeetracker.api;

import com.google.a.l;
import f.b;
import f.c.a;
import f.c.f;
import f.c.i;
import f.c.o;
import f.c.x;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public interface SendEventAPI {
    @o
    b<ResponseBody> send(@x String str, @i(a = "X-SPC-DF") String str2, @a l lVar);

    @o
    b<ResponseBody> send(@x String str, @i(a = "X-SPC-DF") String str2, @a RequestBody requestBody);

    @f
    b<ResponseBody> sendGet(@x String str);
}
