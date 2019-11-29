package com.shopee.livequiz.d.a;

import com.google.a.a.c;
import java.io.Serializable;

public class d<T> implements Serializable {
    @c(a = "data")
    public T data;
    @c(a = "err_code")
    public int err_code;
    @c(a = "err_msg")
    public String err_msg;

    public String toString() {
        return "RoomResult{err_msg='" + this.err_msg + '\'' + ", err_code=" + this.err_code + ", liveParams=" + this.data.toString() + '}';
    }
}
