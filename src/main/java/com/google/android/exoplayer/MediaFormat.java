package com.google.android.exoplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer.a.a;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MediaFormat implements Parcelable {
    public static final Parcelable.Creator<MediaFormat> CREATOR = new Parcelable.Creator<MediaFormat>() {
        /* renamed from: a */
        public MediaFormat createFromParcel(Parcel parcel) {
            return new MediaFormat(parcel);
        }

        /* renamed from: a */
        public MediaFormat[] newArray(int i) {
            return new MediaFormat[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f8939a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8940b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8941c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8942d;

    /* renamed from: e  reason: collision with root package name */
    public final long f8943e;

    /* renamed from: f  reason: collision with root package name */
    public final List<byte[]> f8944f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final boolean f8945g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final float m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final String s;
    public final long t;
    private int u;

    public int describeContents() {
        return 0;
    }

    MediaFormat(Parcel parcel) {
        this.f8939a = parcel.readString();
        this.f8940b = parcel.readString();
        this.f8941c = parcel.readInt();
        this.f8942d = parcel.readInt();
        this.f8943e = parcel.readLong();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readFloat();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.s = parcel.readString();
        this.t = parcel.readLong();
        parcel.readList(this.f8944f, (ClassLoader) null);
        this.f8945g = parcel.readInt() != 1 ? false : true;
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = parcel.readInt();
    }

    public String toString() {
        return "MediaFormat(" + this.f8939a + ", " + this.f8940b + ", " + this.f8941c + ", " + this.f8942d + ", " + this.h + ", " + this.i + ", " + this.l + ", " + this.m + ", " + this.n + ", " + this.o + ", " + this.s + ", " + this.f8943e + ", " + this.f8945g + ", " + this.j + ", " + this.k + ", " + this.p + ", " + this.q + ", " + this.r + SQLBuilder.PARENTHESES_RIGHT;
    }

    public int hashCode() {
        if (this.u == 0) {
            String str = this.f8939a;
            int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f8940b;
            int hashCode2 = (((((((((((((((((((((((((((((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f8941c) * 31) + this.f8942d) * 31) + this.h) * 31) + this.i) * 31) + this.l) * 31) + Float.floatToRawIntBits(this.m)) * 31) + ((int) this.f8943e)) * 31) + (this.f8945g ? 1231 : 1237)) * 31) + this.j) * 31) + this.k) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31;
            String str3 = this.s;
            int hashCode3 = ((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + ((int) this.t);
            for (int i2 = 0; i2 < this.f8944f.size(); i2++) {
                hashCode3 = (hashCode3 * 31) + Arrays.hashCode(this.f8944f.get(i2));
            }
            this.u = hashCode3;
        }
        return this.u;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MediaFormat mediaFormat = (MediaFormat) obj;
            if (this.f8945g == mediaFormat.f8945g && this.f8941c == mediaFormat.f8941c && this.f8942d == mediaFormat.f8942d && this.f8943e == mediaFormat.f8943e && this.h == mediaFormat.h && this.i == mediaFormat.i && this.l == mediaFormat.l && this.m == mediaFormat.m && this.j == mediaFormat.j && this.k == mediaFormat.k && this.n == mediaFormat.n && this.o == mediaFormat.o && this.p == mediaFormat.p && this.q == mediaFormat.q && this.r == mediaFormat.r && this.t == mediaFormat.t && a.a(this.f8939a, mediaFormat.f8939a) && a.a(this.s, mediaFormat.s) && a.a(this.f8940b, mediaFormat.f8940b) && this.f8944f.size() == mediaFormat.f8944f.size()) {
                for (int i2 = 0; i2 < this.f8944f.size(); i2++) {
                    if (!Arrays.equals(this.f8944f.get(i2), mediaFormat.f8944f.get(i2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8939a);
        parcel.writeString(this.f8940b);
        parcel.writeInt(this.f8941c);
        parcel.writeInt(this.f8942d);
        parcel.writeLong(this.f8943e);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.l);
        parcel.writeFloat(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeString(this.s);
        parcel.writeLong(this.t);
        parcel.writeList(this.f8944f);
        parcel.writeInt(this.f8945g ? 1 : 0);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
    }
}
