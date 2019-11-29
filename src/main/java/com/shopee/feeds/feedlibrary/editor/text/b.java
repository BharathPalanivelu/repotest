package com.shopee.feeds.feedlibrary.editor.text;

import java.util.HashMap;

public class b extends com.shopee.feeds.feedlibrary.editor.b.b {
    private int backgroundColorId;
    private HashMap<Integer, Integer> charCountOfSize;
    private int fontColorId;
    private boolean isHighLight;
    private String text;
    private int textSize;

    public b(String str, int i, int i2, boolean z, int i3) {
        this.text = str;
        this.fontColorId = i;
        this.backgroundColorId = i2;
        this.isHighLight = z;
        this.textSize = i3;
    }

    public String m() {
        return this.text;
    }

    public void b(String str) {
        this.text = str;
    }

    public int n() {
        return this.fontColorId;
    }

    public void b(int i) {
        this.fontColorId = i;
    }

    public int o() {
        return this.backgroundColorId;
    }

    public void c(int i) {
        this.backgroundColorId = i;
    }

    public boolean p() {
        return this.isHighLight;
    }

    public void a(boolean z) {
        this.isHighLight = z;
    }

    public int q() {
        return this.textSize;
    }

    public void d(int i) {
        this.textSize = i;
    }

    public HashMap<Integer, Integer> r() {
        return this.charCountOfSize;
    }

    public void a(HashMap<Integer, Integer> hashMap) {
        this.charCountOfSize = hashMap;
    }
}
