package com.shopee.livequiz.d.b;

import com.shopee.livequiz.d.a.a;
import com.shopee.livequiz.d.a.a.c;
import com.shopee.livequiz.d.a.a.e;
import com.shopee.livequiz.d.a.d;
import f.c.f;
import f.c.k;
import f.c.o;
import f.c.s;

public interface b {
    @f(a = "gamehq/guest/api/v1/revive/share/{event_id}")
    f.b<a<c>> a(@s(a = "event_id") int i);

    @f(a = "gamehq/guest/api/v1/bonus_coins/{event_id}/{session_id}")
    f.b<a<com.shopee.livequiz.d.a.a.a>> a(@s(a = "event_id") int i, @s(a = "session_id") int i2);

    @k(a = {"Content-Type: application/json", "Accept: application/json"})
    @o(a = "gamehq/guest/api/v1/answers/{event_id}/{session_id}/{question_id}")
    f.b<a<Object>> a(@s(a = "event_id") int i, @s(a = "session_id") int i2, @s(a = "question_id") int i3, @f.c.a com.shopee.livequiz.d.a.b.a aVar);

    @k(a = {"Content-Type: application/json", "Accept: application/json"})
    @o(a = "api/v1/filter")
    f.b<d<e>> a(@f.c.a com.shopee.livequiz.d.a.b.b bVar);

    @f(a = "api/v1/group/{group_id}/membernum")
    f.b<d<com.shopee.livequiz.d.a.a.d>> a(@s(a = "group_id") String str);

    @k(a = {"Content-Type: application/json", "Accept: application/json"})
    @o(a = "gamehq/guest/api/v1/data/click/{type}/{event_id}/{session_id}")
    f.b<Void> a(@s(a = "type") String str, @s(a = "event_id") int i, @s(a = "session_id") int i2, @f.c.a com.shopee.livequiz.d.a.b.c cVar);

    @f(a = "gamehq/guest/api/v1/final/{event_id}/{session_id}")
    f.b<a<com.shopee.livequiz.d.a.a.b>> b(@s(a = "event_id") int i, @s(a = "session_id") int i2);

    @f(a = "gamehq/guest/api/v1/im/{event_id}/{session_id}")
    f.b<com.shopee.livequiz.d.a.b<String>> c(@s(a = "event_id") int i, @s(a = "session_id") int i2);
}
