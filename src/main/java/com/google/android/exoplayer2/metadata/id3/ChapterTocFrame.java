package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s.v;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new Parcelable.Creator<ChapterTocFrame>() {
        /* renamed from: a */
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        /* renamed from: a */
        public ChapterTocFrame[] newArray(int i) {
            return new ChapterTocFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f10861a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f10862b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f10863c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f10864d;

    /* renamed from: e  reason: collision with root package name */
    private final Id3Frame[] f10865e;

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f10861a = str;
        this.f10862b = z;
        this.f10863c = z2;
        this.f10864d = strArr;
        this.f10865e = id3FrameArr;
    }

    ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.f10861a = parcel.readString();
        boolean z = true;
        this.f10862b = parcel.readByte() != 0;
        this.f10863c = parcel.readByte() == 0 ? false : z;
        this.f10864d = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f10865e = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.f10865e[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        if (this.f10862b != chapterTocFrame.f10862b || this.f10863c != chapterTocFrame.f10863c || !v.a((Object) this.f10861a, (Object) chapterTocFrame.f10861a) || !Arrays.equals(this.f10864d, chapterTocFrame.f10864d) || !Arrays.equals(this.f10865e, chapterTocFrame.f10865e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = (((true + (this.f10862b ? 1 : 0)) * 31) + (this.f10863c ? 1 : 0)) * 31;
        String str = this.f10861a;
        return i + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10861a);
        parcel.writeByte(this.f10862b ? (byte) 1 : 0);
        parcel.writeByte(this.f10863c ? (byte) 1 : 0);
        parcel.writeStringArray(this.f10864d);
        parcel.writeInt(this.f10865e.length);
        int i2 = 0;
        while (true) {
            Id3Frame[] id3FrameArr = this.f10865e;
            if (i2 < id3FrameArr.length) {
                parcel.writeParcelable(id3FrameArr[i2], 0);
                i2++;
            } else {
                return;
            }
        }
    }
}
