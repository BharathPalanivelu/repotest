package com.shopee.app.web.protocol;

public class SaveMessage {
    private String data;
    private String key;
    private int persist = 0;

    public String getKey() {
        return this.key;
    }

    public String getData() {
        return this.data;
    }

    public int getPersist() {
        return this.persist;
    }
}
