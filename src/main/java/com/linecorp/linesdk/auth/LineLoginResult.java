package com.linecorp.linesdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.linecorp.linesdk.LineAccessToken;
import com.linecorp.linesdk.LineApiError;
import com.linecorp.linesdk.LineCredential;
import com.linecorp.linesdk.LineProfile;
import com.linecorp.linesdk.b;

public class LineLoginResult implements Parcelable {
    public static final Parcelable.Creator<LineLoginResult> CREATOR = new Parcelable.Creator<LineLoginResult>() {
        /* renamed from: a */
        public final LineLoginResult createFromParcel(Parcel parcel) {
            return new LineLoginResult(parcel);
        }

        /* renamed from: a */
        public final LineLoginResult[] newArray(int i) {
            return new LineLoginResult[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final LineLoginResult f15052a = new LineLoginResult(b.CANCEL, LineApiError.f14985a);

    /* renamed from: b  reason: collision with root package name */
    private final b f15053b;

    /* renamed from: c  reason: collision with root package name */
    private final LineProfile f15054c;

    /* renamed from: d  reason: collision with root package name */
    private final LineCredential f15055d;

    /* renamed from: e  reason: collision with root package name */
    private final LineApiError f15056e;

    public int describeContents() {
        return 0;
    }

    public LineLoginResult(LineProfile lineProfile, LineCredential lineCredential) {
        this(b.SUCCESS, lineProfile, lineCredential, LineApiError.f14985a);
    }

    public LineLoginResult(b bVar, LineApiError lineApiError) {
        this(bVar, (LineProfile) null, (LineCredential) null, lineApiError);
    }

    LineLoginResult(b bVar, LineProfile lineProfile, LineCredential lineCredential, LineApiError lineApiError) {
        this.f15053b = bVar;
        this.f15054c = lineProfile;
        this.f15055d = lineCredential;
        this.f15056e = lineApiError;
    }

    private LineLoginResult(Parcel parcel) {
        this.f15053b = (b) parcel.readSerializable();
        this.f15054c = (LineProfile) parcel.readParcelable(LineProfile.class.getClassLoader());
        this.f15055d = (LineCredential) parcel.readParcelable(LineAccessToken.class.getClassLoader());
        this.f15056e = (LineApiError) parcel.readParcelable(LineApiError.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f15053b);
        parcel.writeParcelable(this.f15054c, i);
        parcel.writeParcelable(this.f15055d, i);
        parcel.writeParcelable(this.f15056e, i);
    }

    public b a() {
        return this.f15053b;
    }

    public LineProfile b() {
        return this.f15054c;
    }

    public LineCredential c() {
        return this.f15055d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LineLoginResult lineLoginResult = (LineLoginResult) obj;
        if (this.f15053b != lineLoginResult.f15053b) {
            return false;
        }
        LineProfile lineProfile = this.f15054c;
        if (lineProfile == null ? lineLoginResult.f15054c != null : !lineProfile.equals(lineLoginResult.f15054c)) {
            return false;
        }
        LineCredential lineCredential = this.f15055d;
        if (lineCredential == null ? lineLoginResult.f15055d == null : lineCredential.equals(lineLoginResult.f15055d)) {
            return this.f15056e.equals(lineLoginResult.f15056e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f15053b.hashCode() * 31;
        LineProfile lineProfile = this.f15054c;
        int i = 0;
        int hashCode2 = (hashCode + (lineProfile != null ? lineProfile.hashCode() : 0)) * 31;
        LineCredential lineCredential = this.f15055d;
        if (lineCredential != null) {
            i = lineCredential.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.f15056e.hashCode();
    }

    public String toString() {
        return "LineLoginResult{errorData=" + this.f15056e + ", responseCode=" + this.f15053b + ", lineProfile=" + this.f15054c + ", lineCredential=" + this.f15055d + '}';
    }
}
