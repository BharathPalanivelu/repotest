package com.shopee.app.data.viewmodel;

import android.text.TextUtils;
import com.garena.android.appkit.tools.b;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class GalleryAlbumInfo {
    private long id;
    private String name;
    private ArrayList<GalleryItemInfo> photoList = new ArrayList<>();
    private String thumbPath;

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? b.e(R.string.sp_label_album) : this.name;
    }

    public void addPhoto(String str, int i, int i2, long j) {
        if (this.photoList.size() == 0) {
            this.thumbPath = str;
        }
        this.photoList.add(GalleryItemInfo.newGalleryImage(str, i, i2, j));
    }

    public void addVideo(String str, long j) {
        if (this.photoList.size() == 0) {
            this.thumbPath = str;
        }
        this.photoList.add(GalleryItemInfo.newVideo(str, j));
    }

    public ArrayList<GalleryItemInfo> getImageList() {
        return this.photoList;
    }

    public List<GalleryItemInfo> getPathList() {
        return this.photoList;
    }

    public void setId(long j) {
        this.id = j;
    }

    public long getId() {
        return this.id;
    }

    public String getImagePath() {
        String str = this.thumbPath;
        return str == null ? "" : str;
    }
}
