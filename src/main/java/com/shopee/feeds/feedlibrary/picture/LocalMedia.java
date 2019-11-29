package com.shopee.feeds.feedlibrary.picture;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class LocalMedia implements Parcelable {
    public static final Parcelable.Creator<LocalMedia> CREATOR = new Parcelable.Creator<LocalMedia>() {
        /* renamed from: a */
        public LocalMedia createFromParcel(Parcel parcel) {
            return new LocalMedia(parcel);
        }

        /* renamed from: a */
        public LocalMedia[] newArray(int i) {
            return new LocalMedia[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f28202a;

    /* renamed from: b  reason: collision with root package name */
    private String f28203b;

    /* renamed from: c  reason: collision with root package name */
    private String f28204c;

    /* renamed from: d  reason: collision with root package name */
    private String f28205d;

    /* renamed from: e  reason: collision with root package name */
    private long f28206e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f28207f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f28208g;
    private int h;
    private int i;
    private String j;
    private boolean k;
    private int l;
    private int m;

    public int describeContents() {
        return 0;
    }

    public LocalMedia() {
    }

    public LocalMedia(String str, long j2, int i2, String str2) {
        this.f28203b = str;
        this.f28206e = j2;
        this.i = i2;
        this.j = str2;
    }

    public LocalMedia(String str, long j2, int i2, String str2, int i3, int i4) {
        this.f28203b = str;
        this.f28206e = j2;
        this.i = i2;
        this.j = str2;
        this.l = i3;
        this.m = i4;
    }

    public String a() {
        if (TextUtils.isEmpty(this.j)) {
            this.j = "image/jpeg";
        }
        return this.j;
    }

    public String b() {
        String str = this.f28203b;
        return str == null ? "" : str;
    }

    public long c() {
        return this.f28206e;
    }

    public int d() {
        return this.l;
    }

    public int e() {
        return this.m;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f28203b);
        parcel.writeString(this.f28204c);
        parcel.writeString(this.f28205d);
        parcel.writeLong(this.f28206e);
        parcel.writeByte(this.f28207f ? (byte) 1 : 0);
        parcel.writeByte(this.f28208g ? (byte) 1 : 0);
        parcel.writeInt(this.f28202a);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeString(this.j);
        parcel.writeByte(this.k ? (byte) 1 : 0);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }

    protected LocalMedia(Parcel parcel) {
        this.f28203b = parcel.readString();
        this.f28204c = parcel.readString();
        this.f28205d = parcel.readString();
        this.f28206e = parcel.readLong();
        boolean z = true;
        this.f28207f = parcel.readByte() != 0;
        this.f28208g = parcel.readByte() != 0;
        this.f28202a = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readString();
        this.k = parcel.readByte() == 0 ? false : z;
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }

    public boolean a(LocalMedia localMedia) {
        return localMedia.b().equals(this.f28203b);
    }
}
