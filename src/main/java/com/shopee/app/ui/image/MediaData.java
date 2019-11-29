package com.shopee.app.ui.image;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class MediaData implements Parcelable {
    public static final Parcelable.Creator<MediaData> CREATOR = new Parcelable.Creator<MediaData>() {
        public MediaData createFromParcel(Parcel parcel) {
            return new MediaData(parcel);
        }

        public MediaData[] newArray(int i) {
            return new MediaData[i];
        }
    };
    private int curTime;
    private int duration;
    private boolean isDummy;
    private boolean isVideo;
    private String path;
    private int startTime;
    private int status;
    private String thumb;
    private String trackingData;

    public int describeContents() {
        return 0;
    }

    private MediaData() {
    }

    public String getPath() {
        return this.path;
    }

    public boolean isVideo() {
        return this.isVideo;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getThumb() {
        return this.thumb;
    }

    public int getCurTime() {
        return this.curTime;
    }

    public boolean isDummy() {
        return this.isDummy;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public String getTrackingData() {
        return this.trackingData;
    }

    public static MediaData newImageData(String str) {
        MediaData mediaData = new MediaData();
        mediaData.path = str;
        mediaData.isVideo = false;
        return mediaData;
    }

    public static MediaData newVideoData(String str, String str2, int i) {
        MediaData mediaData = new MediaData();
        mediaData.thumb = str;
        mediaData.path = str2;
        mediaData.duration = i;
        mediaData.isVideo = true;
        mediaData.curTime = 0;
        mediaData.isDummy = false;
        return mediaData;
    }

    public static MediaData newVideoData(String str, String str2, int i, int i2, int i3, boolean z) {
        MediaData mediaData = new MediaData();
        mediaData.thumb = str;
        mediaData.path = str2;
        mediaData.duration = i2;
        mediaData.isVideo = true;
        mediaData.curTime = 0;
        mediaData.startTime = i;
        mediaData.isDummy = z;
        mediaData.status = i3;
        return mediaData;
    }

    public static MediaData newVideoData(String str, String str2, int i, int i2, String str3) {
        MediaData mediaData = new MediaData();
        mediaData.thumb = str;
        mediaData.path = str2;
        mediaData.duration = i;
        mediaData.isVideo = true;
        mediaData.curTime = i2;
        mediaData.isDummy = false;
        mediaData.trackingData = str3;
        return mediaData;
    }

    public static MediaData newVideoData(String str, String str2, int i, int i2) {
        return newVideoData(str, str2, i, i2, "");
    }

    public static MediaData newMediaData(String str, boolean z, String str2) {
        MediaData mediaData = new MediaData();
        mediaData.path = str;
        mediaData.isVideo = z;
        mediaData.trackingData = str2;
        return mediaData;
    }

    public static MediaData newFromSdkMediaData(com.shopee.react.sdk.bridge.protocol.MediaData mediaData) {
        MediaData mediaData2 = new MediaData();
        mediaData2.thumb = mediaData.getThumb();
        mediaData2.path = mediaData.getPath();
        mediaData2.duration = mediaData.getDuration();
        mediaData2.isVideo = mediaData.isVideo();
        mediaData2.curTime = mediaData.getCurTime();
        mediaData2.startTime = mediaData.getStartTime();
        mediaData2.isDummy = mediaData.isDummy();
        mediaData2.status = mediaData.getStatus();
        mediaData2.trackingData = mediaData.getTrackingData();
        return mediaData2;
    }

    public static List<MediaData> newListFromSdkMediaDataList(List<com.shopee.react.sdk.bridge.protocol.MediaData> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (com.shopee.react.sdk.bridge.protocol.MediaData newFromSdkMediaData : list) {
            arrayList.add(newFromSdkMediaData(newFromSdkMediaData));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MediaData)) {
            return false;
        }
        MediaData mediaData = (MediaData) obj;
        if (!this.path.equals(mediaData.path) || !this.thumb.equals(mediaData.thumb) || this.isVideo != mediaData.isVideo || this.duration != mediaData.duration) {
            return false;
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.path);
        parcel.writeString(this.thumb);
        parcel.writeByte(this.isVideo ? (byte) 1 : 0);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.curTime);
        parcel.writeByte(this.isDummy ? (byte) 1 : 0);
        parcel.writeInt(this.startTime);
        parcel.writeString(this.trackingData);
    }

    protected MediaData(Parcel parcel) {
        this.path = parcel.readString();
        this.thumb = parcel.readString();
        boolean z = true;
        this.isVideo = parcel.readByte() != 0;
        this.duration = parcel.readInt();
        this.curTime = parcel.readInt();
        this.isDummy = parcel.readByte() == 0 ? false : z;
        this.startTime = parcel.readInt();
        this.trackingData = parcel.readString();
    }

    public int getStatus() {
        return this.status;
    }
}
