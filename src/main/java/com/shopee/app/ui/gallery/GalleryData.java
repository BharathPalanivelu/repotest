package com.shopee.app.ui.gallery;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.shopee.app.data.viewmodel.GalleryItemInfo;

public class GalleryData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        /* renamed from: a */
        public GalleryData createFromParcel(Parcel parcel) {
            return new GalleryData(parcel);
        }

        /* renamed from: a */
        public GalleryData[] newArray(int i) {
            return new GalleryData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public boolean f21837a;

    /* renamed from: b  reason: collision with root package name */
    public String f21838b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21839c;

    /* renamed from: d  reason: collision with root package name */
    public long f21840d;

    /* renamed from: e  reason: collision with root package name */
    public int f21841e;

    /* renamed from: f  reason: collision with root package name */
    public int f21842f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21843g;

    public int describeContents() {
        return 0;
    }

    public GalleryData(String str, boolean z, int i, int i2) {
        this.f21838b = str;
        this.f21837a = z;
        this.f21841e = i;
        this.f21842f = i2;
        this.f21839c = false;
        this.f21840d = 0;
    }

    private GalleryData(String str, boolean z, boolean z2, long j, int i, int i2, boolean z3) {
        this.f21838b = str;
        this.f21837a = z;
        this.f21839c = z2;
        this.f21840d = j;
        this.f21841e = i;
        this.f21842f = i2;
        this.f21843g = z3;
    }

    public static GalleryData a(GalleryItemInfo galleryItemInfo, boolean z, boolean z2) {
        return new GalleryData(galleryItemInfo.getPath(), z, galleryItemInfo.isVideo(), galleryItemInfo.getVideoTime(), galleryItemInfo.getWidth(), galleryItemInfo.getHeight(), z2);
    }

    public GalleryData(Parcel parcel) {
        this.f21838b = parcel.readString();
        boolean z = false;
        this.f21837a = parcel.readInt() == 1;
        this.f21839c = parcel.readInt() == 1;
        this.f21840d = parcel.readLong();
        this.f21841e = parcel.readInt();
        this.f21842f = parcel.readInt();
        this.f21843g = parcel.readInt() == 1 ? true : z;
    }

    public boolean a() {
        return this.f21843g;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f21838b);
        parcel.writeInt(this.f21837a ? 1 : 0);
        parcel.writeInt(this.f21839c ? 1 : 0);
        parcel.writeLong(this.f21840d);
        parcel.writeInt(this.f21841e);
        parcel.writeInt(this.f21842f);
        parcel.writeInt(this.f21843g ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GalleryData)) {
            return false;
        }
        GalleryData galleryData = (GalleryData) obj;
        if (!TextUtils.isEmpty(galleryData.f21838b)) {
            return galleryData.f21838b.equals(this.f21838b);
        }
        if (this.f21838b == null) {
            return true;
        }
        return false;
    }
}
