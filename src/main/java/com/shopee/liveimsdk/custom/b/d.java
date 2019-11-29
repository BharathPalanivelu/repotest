package com.shopee.liveimsdk.custom.b;

import com.google.a.a.c;
import java.io.Serializable;

public class d<T> implements Serializable {
    @c(a = "code")
    public int code;
    @c(a = "data")
    public T data;
    @c(a = "msg")
    public String msg;

    public String toString() {
        return "Result:{msg='" + this.msg + '\'' + ", code=" + this.code + ", data=" + this.data.toString() + '}';
    }
}
