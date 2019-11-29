package com.shopee.live.livestreaming.data.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class UploadListEntity implements Serializable {
    private ArrayList<String> list;

    public ArrayList<String> getList() {
        ArrayList<String> arrayList = this.list;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setList(ArrayList<String> arrayList) {
        this.list = arrayList;
    }
}
