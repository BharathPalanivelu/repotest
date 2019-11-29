package com.linecorp.linesdk;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class LineProfile implements Parcelable {
    public static final Parcelable.Creator<LineProfile> CREATOR = new Parcelable.Creator<LineProfile>() {
        /* renamed from: a */
        public final LineProfile createFromParcel(Parcel parcel) {
            return new LineProfile(parcel);
        }

        /* renamed from: a */
        public final LineProfile[] newArray(int i) {
            return new LineProfile[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final String f14990a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14991b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f14992c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14993d;

    public int describeContents() {
        return 0;
    }

    public LineProfile(String str, String str2, Uri uri, String str3) {
        this.f14990a = str;
        this.f14991b = str2;
        this.f14992c = uri;
        this.f14993d = str3;
    }

    private LineProfile(Parcel parcel) {
        this.f14990a = parcel.readString();
        this.f14991b = parcel.readString();
        this.f14992c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f14993d = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14990a);
        parcel.writeString(this.f14991b);
        parcel.writeParcelable(this.f14992c, i);
        parcel.writeString(this.f14993d);
    }

    public String a() {
        return this.f14991b;
    }

    public String b() {
        return this.f14990a;
    }

    public Uri c() {
        return this.f14992c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            LineProfile lineProfile = (LineProfile) obj;
            if (!this.f14990a.equals(lineProfile.f14990a) || !this.f14991b.equals(lineProfile.f14991b)) {
                return false;
            }
            Uri uri = this.f14992c;
            if (uri == null ? lineProfile.f14992c != null : !uri.equals(lineProfile.f14992c)) {
                return false;
            }
            String str = this.f14993d;
            if (str != null) {
                return str.equals(lineProfile.f14993d);
            }
            if (lineProfile.f14993d == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f14990a.hashCode() * 31) + this.f14991b.hashCode()) * 31;
        Uri uri = this.f14992c;
        int i = 0;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.f14993d;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "LineProfile{displayName='" + this.f14991b + '\'' + ", userId='" + this.f14990a + '\'' + ", pictureUrl='" + this.f14992c + '\'' + ", statusMessage='" + this.f14993d + '\'' + '}';
    }
}
