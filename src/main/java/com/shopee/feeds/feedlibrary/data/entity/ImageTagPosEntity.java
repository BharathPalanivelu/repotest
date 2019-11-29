package com.shopee.feeds.feedlibrary.data.entity;

import com.shopee.feeds.feedlibrary.editor.tag.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ImageTagPosEntity implements Serializable {
    private LinkedHashMap<String, ArrayList<a>> mImageTagsInfo;
    private int tagNum;

    public HashMap<String, ArrayList<a>> getmImageTagsInfo() {
        return this.mImageTagsInfo;
    }

    public void setmImageTagsInfo(LinkedHashMap<String, ArrayList<a>> linkedHashMap) {
        this.mImageTagsInfo = linkedHashMap;
    }

    public int getTagNum() {
        return this.tagNum;
    }

    public void setTagNum(int i) {
        this.tagNum = i;
    }
}
