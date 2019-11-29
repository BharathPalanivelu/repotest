package com.shopee.livequiz.d.a;

import com.google.a.a.c;
import java.io.Serializable;

public class a<T> implements Serializable {
    @c(a = "payload")
    public T data;
    @c(a = "err_code")
    public int err_code;
    @c(a = "err_msg")
    public String err_msg;

    public String toString() {
        return "GameResult{err_msg='" + this.err_msg + '\'' + ", err_code=" + this.err_code + '}';
    }
}
