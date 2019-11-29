package com.shopee.livequiz.d.a;

import com.google.a.a.c;
import java.io.Serializable;

public class b<T> implements Serializable {
    @c(a = "payload")
    public T payload;
    @c(a = "request_id")
    public String request_id;
    @c(a = "room_id")
    public int room_id;
}
