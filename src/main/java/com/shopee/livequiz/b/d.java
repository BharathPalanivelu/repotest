package com.shopee.livequiz.b;

import java.io.Serializable;

public class d implements Serializable {
    private String operation;
    private String page_id;
    private String page_section;
    private String page_type;
    private String target_type;

    public String a() {
        String str = this.page_type;
        return str == null ? "" : str;
    }

    public String b() {
        String str = this.operation;
        return str == null ? "" : str;
    }

    public String c() {
        String str = this.page_section;
        return str == null ? "" : str;
    }

    public String d() {
        String str = this.target_type;
        return str == null ? "" : str;
    }
}
