package com.garena.sticker.model;

import java.util.List;

public class Sticker {
    private String ext;
    private List<String> name;
    private String sid;

    public Sticker(String str, List<String> list, String str2) {
        this.sid = str;
        this.name = list;
        this.ext = str2;
    }

    public String getFormat() {
        return this.ext;
    }

    public String getSid() {
        return this.sid;
    }

    public List<String> getName() {
        return this.name;
    }
}
