package com.shopee.feeds.feedlibrary.editor.sticker.a;

import com.shopee.feeds.feedlibrary.editor.b.b;

public class d extends b {
    private String cmt_id;
    private String id;
    protected String kind = getClass().getName();
    private String promotion_id;
    private String question;
    private String signature;
    private float tranZ;
    protected int type;
    private int user_id;
    private String voucher_code;

    public d(int i) {
        this.type = i;
    }

    public int q() {
        return this.type;
    }

    public void k(float f2) {
        this.tranZ = f2;
    }

    public float r() {
        return this.tranZ;
    }

    public String s() {
        return this.id;
    }

    public void e(String str) {
        this.id = str;
    }

    public int t() {
        return this.user_id;
    }

    public void d(int i) {
        this.user_id = i;
    }

    public String u() {
        return this.promotion_id;
    }

    public void f(String str) {
        this.promotion_id = str;
    }

    public String v() {
        String str = this.signature;
        return str == null ? "" : str;
    }

    public void g(String str) {
        this.signature = str;
    }

    public String w() {
        return this.voucher_code;
    }

    public void h(String str) {
        this.voucher_code = str;
    }

    public String x() {
        return this.question;
    }

    public void i(String str) {
        this.question = str;
    }
}
