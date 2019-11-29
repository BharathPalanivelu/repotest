package com.linecorp.linesdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineCredential implements Parcelable {
    public static final Parcelable.Creator<LineCredential> CREATOR = new Parcelable.Creator<LineCredential>() {
        /* renamed from: a */
        public final LineCredential createFromParcel(Parcel parcel) {
            return new LineCredential(parcel);
        }

        /* renamed from: a */
        public final LineCredential[] newArray(int i) {
            return new LineCredential[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final LineAccessToken f14988a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f14989b;

    public int describeContents() {
        return 0;
    }

    public LineCredential(LineAccessToken lineAccessToken, List<String> list) {
        this.f14988a = lineAccessToken;
        this.f14989b = list;
    }

    private LineCredential(Parcel parcel) {
        this.f14988a = (LineAccessToken) parcel.readParcelable(LineAccessToken.class.getClassLoader());
        ArrayList arrayList = new ArrayList(8);
        parcel.readStringList(arrayList);
        this.f14989b = Collections.unmodifiableList(arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f14988a, i);
        parcel.writeStringList(this.f14989b);
    }

    public LineAccessToken a() {
        return this.f14988a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LineCredential lineCredential = (LineCredential) obj;
        if (!this.f14988a.equals(lineCredential.f14988a)) {
            return false;
        }
        return this.f14989b.equals(lineCredential.f14989b);
    }

    public int hashCode() {
        return (this.f14988a.hashCode() * 31) + this.f14989b.hashCode();
    }

    public String toString() {
        return "LineCredential{accessToken=" + "#####" + ", permission=" + this.f14989b + '}';
    }
}
