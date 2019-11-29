package com.shopee.feeds.feedlibrary.data.entity;

import com.garena.imageeditor.a.c.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AddMoreEntity implements Serializable {
    public static final int ADD = 2;
    public static final int NORMAL = 1;
    private int mode;
    private ArrayList<String> pathList;
    private LinkedHashMap<String, String> pathMap;
    private HashMap<String, n> presetHashMap;

    public LinkedHashMap<String, String> getPathMap() {
        return this.pathMap;
    }

    public void setPathMap(LinkedHashMap<String, String> linkedHashMap) {
        this.pathMap = linkedHashMap;
    }

    public void setPathMap(HashMap<String, String> hashMap) {
        if (this.pathMap == null) {
            this.pathMap = new LinkedHashMap<>();
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry next : hashMap.entrySet()) {
                this.pathMap.put(next.getKey(), next.getValue());
            }
        }
    }

    public HashMap<String, n> getPresetHashMap() {
        return this.presetHashMap;
    }

    public void setPresetHashMap(HashMap<String, n> hashMap) {
        this.presetHashMap = hashMap;
    }

    public ArrayList<String> getPathList() {
        ArrayList<String> arrayList = this.pathList;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setPathList(ArrayList<String> arrayList) {
        this.pathList = arrayList;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }
}
