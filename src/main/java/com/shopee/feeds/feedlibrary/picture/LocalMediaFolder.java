package com.shopee.feeds.feedlibrary.picture;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class LocalMediaFolder implements Parcelable {
    public static final Parcelable.Creator<LocalMediaFolder> CREATOR = new Parcelable.Creator<LocalMediaFolder>() {
        /* renamed from: a */
        public LocalMediaFolder createFromParcel(Parcel parcel) {
            return new LocalMediaFolder(parcel);
        }

        /* renamed from: a */
        public LocalMediaFolder[] newArray(int i) {
            return new LocalMediaFolder[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f28209a;

    /* renamed from: b  reason: collision with root package name */
    private String f28210b;

    /* renamed from: c  reason: collision with root package name */
    private String f28211c;

    /* renamed from: d  reason: collision with root package name */
    private int f28212d;

    /* renamed from: e  reason: collision with root package name */
    private int f28213e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f28214f;

    /* renamed from: g  reason: collision with root package name */
    private List<LocalMedia> f28215g = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public void a(boolean z) {
        this.f28214f = z;
    }

    public String a() {
        return this.f28209a;
    }

    public void a(String str) {
        this.f28209a = str;
    }

    public void b(String str) {
        this.f28210b = str;
    }

    public void c(String str) {
        this.f28211c = str;
    }

    public int b() {
        return this.f28212d;
    }

    public void a(int i) {
        this.f28212d = i;
    }

    public List<LocalMedia> c() {
        if (this.f28215g == null) {
            this.f28215g = new ArrayList();
        }
        return this.f28215g;
    }

    public void a(List<LocalMedia> list) {
        this.f28215g = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f28209a);
        parcel.writeString(this.f28210b);
        parcel.writeString(this.f28211c);
        parcel.writeInt(this.f28212d);
        parcel.writeInt(this.f28213e);
        parcel.writeByte(this.f28214f ? (byte) 1 : 0);
        parcel.writeTypedList(this.f28215g);
    }

    public LocalMediaFolder() {
    }

    protected LocalMediaFolder(Parcel parcel) {
        this.f28209a = parcel.readString();
        this.f28210b = parcel.readString();
        this.f28211c = parcel.readString();
        this.f28212d = parcel.readInt();
        this.f28213e = parcel.readInt();
        this.f28214f = parcel.readByte() != 0;
        this.f28215g = parcel.createTypedArrayList(LocalMedia.CREATOR);
    }
}
