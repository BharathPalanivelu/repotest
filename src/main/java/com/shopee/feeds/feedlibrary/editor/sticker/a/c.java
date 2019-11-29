package com.shopee.feeds.feedlibrary.editor.sticker.a;

public class c extends d {
    private int pixelHeight;
    private int pixelWidth;
    private String url;

    public c() {
        super(1);
    }

    public c(String str) {
        super(1);
        this.url = str;
    }

    public String m() {
        return this.url;
    }

    public int n() {
        return this.pixelWidth;
    }

    public void b(int i) {
        this.pixelWidth = i;
    }

    public int o() {
        return this.pixelHeight;
    }

    public void c(int i) {
        this.pixelHeight = i;
    }
}
