package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s.v;

public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new Parcelable.Creator<UrlLinkFrame>() {
        /* renamed from: a */
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        /* renamed from: a */
        public UrlLinkFrame[] newArray(int i) {
            return new UrlLinkFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f10878a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10879b;

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.f10878a = str2;
        this.f10879b = str3;
    }

    UrlLinkFrame(Parcel parcel) {
        super(parcel.readString());
        this.f10878a = parcel.readString();
        this.f10879b = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        if (!this.f10873f.equals(urlLinkFrame.f10873f) || !v.a((Object) this.f10878a, (Object) urlLinkFrame.f10878a) || !v.a((Object) this.f10879b, (Object) urlLinkFrame.f10879b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (527 + this.f10873f.hashCode()) * 31;
        String str = this.f10878a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f10879b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10873f);
        parcel.writeString(this.f10878a);
        parcel.writeString(this.f10879b);
    }
}
