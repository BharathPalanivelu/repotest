package com.shopee.liveimsdk.custom.b.b;

import com.shopee.liveimsdk.custom.a.a;
import com.shopee.liveimsdk.custom.b.d;
import f.c.f;
import f.c.s;
import f.c.t;

public interface b {
    @f(a = "api/v1/fetch/chatroom/{chatroom_id}/message")
    f.b<d<a>> a(@s(a = "chatroom_id") String str, @t(a = "uuid") String str2, @t(a = "timestamp") long j);
}
