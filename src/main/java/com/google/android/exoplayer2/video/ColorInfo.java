package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new Parcelable.Creator<ColorInfo>() {
        /* renamed from: a */
        public ColorInfo createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }

        /* renamed from: a */
        public ColorInfo[] newArray(int i) {
            return new ColorInfo[0];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f12217a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12218b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12219c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f12220d;

    /* renamed from: e  reason: collision with root package name */
    private int f12221e;

    public int describeContents() {
        return 0;
    }

    public ColorInfo(int i, int i2, int i3, byte[] bArr) {
        this.f12217a = i;
        this.f12218b = i2;
        this.f12219c = i3;
        this.f12220d = bArr;
    }

    ColorInfo(Parcel parcel) {
        this.f12217a = parcel.readInt();
        this.f12218b = parcel.readInt();
        this.f12219c = parcel.readInt();
        this.f12220d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ColorInfo colorInfo = (ColorInfo) obj;
            return this.f12217a == colorInfo.f12217a && this.f12218b == colorInfo.f12218b && this.f12219c == colorInfo.f12219c && Arrays.equals(this.f12220d, colorInfo.f12220d);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.f12217a);
        sb.append(", ");
        sb.append(this.f12218b);
        sb.append(", ");
        sb.append(this.f12219c);
        sb.append(", ");
        sb.append(this.f12220d != null);
        sb.append(SQLBuilder.PARENTHESES_RIGHT);
        return sb.toString();
    }

    public int hashCode() {
        if (this.f12221e == 0) {
            this.f12221e = ((((((527 + this.f12217a) * 31) + this.f12218b) * 31) + this.f12219c) * 31) + Arrays.hashCode(this.f12220d);
        }
        return this.f12221e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12217a);
        parcel.writeInt(this.f12218b);
        parcel.writeInt(this.f12219c);
        parcel.writeInt(this.f12220d != null ? 1 : 0);
        byte[] bArr = this.f12220d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
