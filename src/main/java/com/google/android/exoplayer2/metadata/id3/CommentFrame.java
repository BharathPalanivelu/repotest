package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s.v;

public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new Parcelable.Creator<CommentFrame>() {
        /* renamed from: a */
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        /* renamed from: a */
        public CommentFrame[] newArray(int i) {
            return new CommentFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f10866a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10867b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10868c;

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f10866a = str;
        this.f10867b = str2;
        this.f10868c = str3;
    }

    CommentFrame(Parcel parcel) {
        super("COMM");
        this.f10866a = parcel.readString();
        this.f10867b = parcel.readString();
        this.f10868c = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        if (!v.a((Object) this.f10867b, (Object) commentFrame.f10867b) || !v.a((Object) this.f10866a, (Object) commentFrame.f10866a) || !v.a((Object) this.f10868c, (Object) commentFrame.f10868c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f10866a;
        int i = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f10867b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f10868c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10873f);
        parcel.writeString(this.f10866a);
        parcel.writeString(this.f10868c);
    }
}
