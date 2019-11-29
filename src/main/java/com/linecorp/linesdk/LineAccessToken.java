package com.linecorp.linesdk;

import android.os.Parcel;
import android.os.Parcelable;

public class LineAccessToken implements Parcelable {
    public static final Parcelable.Creator<LineAccessToken> CREATOR = new Parcelable.Creator<LineAccessToken>() {
        /* renamed from: a */
        public final LineAccessToken createFromParcel(Parcel parcel) {
            return new LineAccessToken(parcel);
        }

        /* renamed from: a */
        public final LineAccessToken[] newArray(int i) {
            return new LineAccessToken[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final String f14982a;

    /* renamed from: b  reason: collision with root package name */
    private final long f14983b;

    /* renamed from: c  reason: collision with root package name */
    private final long f14984c;

    public int describeContents() {
        return 0;
    }

    public LineAccessToken(String str, long j, long j2) {
        this.f14982a = str;
        this.f14983b = j;
        this.f14984c = j2;
    }

    private LineAccessToken(Parcel parcel) {
        this.f14982a = parcel.readString();
        this.f14983b = parcel.readLong();
        this.f14984c = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14982a);
        parcel.writeLong(this.f14983b);
        parcel.writeLong(this.f14984c);
    }

    public String a() {
        return this.f14982a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LineAccessToken lineAccessToken = (LineAccessToken) obj;
        if (this.f14983b == lineAccessToken.f14983b && this.f14984c == lineAccessToken.f14984c) {
            return this.f14982a.equals(lineAccessToken.f14982a);
        }
        return false;
    }

    public int hashCode() {
        long j = this.f14983b;
        long j2 = this.f14984c;
        return (((this.f14982a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "LineAccessToken{accessToken='#####', expiresInMillis=" + this.f14983b + ", issuedClientTimeMillis=" + this.f14984c + '}';
    }
}
