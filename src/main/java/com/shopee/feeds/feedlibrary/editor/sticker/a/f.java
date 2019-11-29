package com.shopee.feeds.feedlibrary.editor.sticker.a;

public class f extends d {
    private String cap_value;
    private int coin_percentage_real;
    private int discount_percent;
    private String discount_value;
    private String min_spend;
    private int reward_type;

    public f() {
        super(3);
    }

    public int m() {
        return this.discount_percent;
    }

    public void b(int i) {
        this.discount_percent = i;
    }

    public String n() {
        String str = this.discount_value;
        return str == null ? "" : str;
    }

    public void b(String str) {
        this.discount_value = str;
    }

    public int o() {
        return this.reward_type;
    }

    public void c(int i) {
        this.reward_type = i;
    }

    public int p() {
        return this.coin_percentage_real;
    }

    public void e(int i) {
        this.coin_percentage_real = i;
    }

    public String y() {
        String str = this.cap_value;
        return str == null ? "" : str;
    }

    public void c(String str) {
        this.cap_value = str;
    }

    public String z() {
        String str = this.min_spend;
        return str == null ? "" : str;
    }

    public void d(String str) {
        this.min_spend = str;
    }
}
