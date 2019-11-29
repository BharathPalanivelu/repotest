package com.shopee.app.data.viewmodel;

import java.util.List;

public class Variation {
    public final List<String> images;
    public final String name;
    public final List<String> options;

    public Variation(String str, List<String> list, List<String> list2) {
        this.name = str;
        this.options = list;
        this.images = list2;
    }
}
