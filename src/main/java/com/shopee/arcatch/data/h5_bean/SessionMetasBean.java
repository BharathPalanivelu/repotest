package com.shopee.arcatch.data.h5_bean;

import com.google.a.a.c;

public class SessionMetasBean {
    @c(a = "meta_key")
    private String key;
    @c(a = "meta_type")
    private String type;
    @c(a = "meta_value")
    private MetaValue value;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public MetaValue getValue() {
        return this.value;
    }

    public void setValue(MetaValue metaValue) {
        this.value = metaValue;
    }

    public String toString() {
        return "SessionMetasBean{key='" + this.key + '\'' + ", value=" + this.value + ", type='" + this.type + '\'' + '}';
    }
}
