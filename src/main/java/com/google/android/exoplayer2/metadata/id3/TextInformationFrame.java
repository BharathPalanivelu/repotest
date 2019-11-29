package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s.v;

public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator<TextInformationFrame>() {
        /* renamed from: a */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        /* renamed from: a */
        public TextInformationFrame[] newArray(int i) {
            return new TextInformationFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f10876a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10877b;

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.f10876a = str2;
        this.f10877b = str3;
    }

    TextInformationFrame(Parcel parcel) {
        super(parcel.readString());
        this.f10876a = parcel.readString();
        this.f10877b = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        if (!this.f10873f.equals(textInformationFrame.f10873f) || !v.a((Object) this.f10876a, (Object) textInformationFrame.f10876a) || !v.a((Object) this.f10877b, (Object) textInformationFrame.f10877b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (527 + this.f10873f.hashCode()) * 31;
        String str = this.f10876a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f10877b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10873f);
        parcel.writeString(this.f10876a);
        parcel.writeString(this.f10877b);
    }
}
