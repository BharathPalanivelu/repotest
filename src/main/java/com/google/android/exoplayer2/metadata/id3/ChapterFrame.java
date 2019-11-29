package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s.v;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new Parcelable.Creator<ChapterFrame>() {
        /* renamed from: a */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        /* renamed from: a */
        public ChapterFrame[] newArray(int i) {
            return new ChapterFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f10855a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10856b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10857c;

    /* renamed from: d  reason: collision with root package name */
    public final long f10858d;

    /* renamed from: e  reason: collision with root package name */
    public final long f10859e;

    /* renamed from: g  reason: collision with root package name */
    private final Id3Frame[] f10860g;

    public int describeContents() {
        return 0;
    }

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f10855a = str;
        this.f10856b = i;
        this.f10857c = i2;
        this.f10858d = j;
        this.f10859e = j2;
        this.f10860g = id3FrameArr;
    }

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.f10855a = parcel.readString();
        this.f10856b = parcel.readInt();
        this.f10857c = parcel.readInt();
        this.f10858d = parcel.readLong();
        this.f10859e = parcel.readLong();
        int readInt = parcel.readInt();
        this.f10860g = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.f10860g[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        if (this.f10856b == chapterFrame.f10856b && this.f10857c == chapterFrame.f10857c && this.f10858d == chapterFrame.f10858d && this.f10859e == chapterFrame.f10859e && v.a((Object) this.f10855a, (Object) chapterFrame.f10855a) && Arrays.equals(this.f10860g, chapterFrame.f10860g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = (((((((527 + this.f10856b) * 31) + this.f10857c) * 31) + ((int) this.f10858d)) * 31) + ((int) this.f10859e)) * 31;
        String str = this.f10855a;
        return i + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10855a);
        parcel.writeInt(this.f10856b);
        parcel.writeInt(this.f10857c);
        parcel.writeLong(this.f10858d);
        parcel.writeLong(this.f10859e);
        parcel.writeInt(this.f10860g.length);
        for (Id3Frame writeParcelable : this.f10860g) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
