package com.shopee.app.react.protocol;

import android.os.Parcel;
import android.os.Parcelable;

public class ImageData implements Parcelable {
    public static final Parcelable.Creator<ImageData> CREATOR = new Parcelable.Creator<ImageData>() {
        public ImageData createFromParcel(Parcel parcel) {
            return new ImageData(parcel);
        }

        public ImageData[] newArray(int i) {
            return new ImageData[i];
        }
    };
    public final int height;
    public final String uri;
    public final int width;

    public int describeContents() {
        return 0;
    }

    public ImageData(String str, int i, int i2) {
        this.uri = str;
        this.width = i;
        this.height = i2;
    }

    protected ImageData(Parcel parcel) {
        this.uri = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uri);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }
}
