package com.shopee.feeds.feedlibrary.a.a;

import java.io.Serializable;

public class c implements Serializable {
    private String data;
    private String msg;
    private String request_timestamp;
    private int status;

    public void a(int i) {
        this.status = i;
    }

    public void a(String str) {
        this.msg = str;
    }

    public String a() {
        return this.data;
    }

    public void b(String str) {
        this.data = str;
    }
}
