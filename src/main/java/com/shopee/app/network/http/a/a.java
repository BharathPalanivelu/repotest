package com.shopee.app.network.http.a;

import f.c.f;
import f.c.s;
import f.c.t;
import io.b.j;
import java.util.List;

public interface a {
    @f(a = "c-api-ds/category-suggestion/v1.{path}/item")
    j<List<Integer>> a(@s(a = "path") String str, @t(a = "title") String str2, @t(a = "cid") String str3);
}
