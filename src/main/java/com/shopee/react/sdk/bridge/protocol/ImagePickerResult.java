package com.shopee.react.sdk.bridge.protocol;

import java.util.ArrayList;
import java.util.List;

public class ImagePickerResult {
    private final List<ImageData> images;
    private final int status;
    private final List<String> uriList;

    public ImagePickerResult(List<String> list, List<ImageData> list2, int i) {
        this.uriList = list;
        this.images = list2;
        this.status = i;
    }

    public ImagePickerResult(int i) {
        this.uriList = new ArrayList();
        this.images = new ArrayList();
        this.status = i;
    }

    public List<String> getUriList() {
        return this.uriList;
    }

    public List<ImageData> getImages() {
        return this.images;
    }

    public int getStatus() {
        return this.status;
    }
}
