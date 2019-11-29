package com.google.android.exoplayer2.k;

import android.os.Parcel;
import android.os.Parcelable;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.Arrays;

public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[0];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f10638a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10639b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10640c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f10641d;

    /* renamed from: e  reason: collision with root package name */
    private int f10642e;

    public int describeContents() {
        return 0;
    }

    public b(int i, int i2, int i3, byte[] bArr) {
        this.f10638a = i;
        this.f10639b = i2;
        this.f10640c = i3;
        this.f10641d = bArr;
    }

    b(Parcel parcel) {
        this.f10638a = parcel.readInt();
        this.f10639b = parcel.readInt();
        this.f10640c = parcel.readInt();
        this.f10641d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            return this.f10638a == bVar.f10638a && this.f10639b == bVar.f10639b && this.f10640c == bVar.f10640c && Arrays.equals(this.f10641d, bVar.f10641d);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.f10638a);
        sb.append(", ");
        sb.append(this.f10639b);
        sb.append(", ");
        sb.append(this.f10640c);
        sb.append(", ");
        sb.append(this.f10641d != null);
        sb.append(SQLBuilder.PARENTHESES_RIGHT);
        return sb.toString();
    }

    public int hashCode() {
        if (this.f10642e == 0) {
            this.f10642e = ((((((527 + this.f10638a) * 31) + this.f10639b) * 31) + this.f10640c) * 31) + Arrays.hashCode(this.f10641d);
        }
        return this.f10642e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10638a);
        parcel.writeInt(this.f10639b);
        parcel.writeInt(this.f10640c);
        parcel.writeInt(this.f10641d != null ? 1 : 0);
        byte[] bArr = this.f10641d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
