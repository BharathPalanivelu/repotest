package com.google.android.exoplayer2.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.k;

public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f9826a;

    /* renamed from: b  reason: collision with root package name */
    public final long f9827b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f9828c;

    private a(long j, byte[] bArr, long j2) {
        this.f9826a = j2;
        this.f9827b = j;
        this.f9828c = bArr;
    }

    private a(Parcel parcel) {
        this.f9826a = parcel.readLong();
        this.f9827b = parcel.readLong();
        this.f9828c = new byte[parcel.readInt()];
        parcel.readByteArray(this.f9828c);
    }

    static a a(k kVar, int i, long j) {
        long l = kVar.l();
        byte[] bArr = new byte[(i - 4)];
        kVar.a(bArr, 0, bArr.length);
        return new a(l, bArr, j);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f9826a);
        parcel.writeLong(this.f9827b);
        parcel.writeInt(this.f9828c.length);
        parcel.writeByteArray(this.f9828c);
    }
}
