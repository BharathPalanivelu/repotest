package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s.l;

public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() {
        /* renamed from: a */
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        /* renamed from: a */
        public PrivateCommand[] newArray(int i) {
            return new PrivateCommand[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f10885a;

    /* renamed from: b  reason: collision with root package name */
    public final long f10886b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f10887c;

    private PrivateCommand(long j, byte[] bArr, long j2) {
        this.f10885a = j2;
        this.f10886b = j;
        this.f10887c = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.f10885a = parcel.readLong();
        this.f10886b = parcel.readLong();
        this.f10887c = new byte[parcel.readInt()];
        parcel.readByteArray(this.f10887c);
    }

    static PrivateCommand a(l lVar, int i, long j) {
        long l = lVar.l();
        byte[] bArr = new byte[(i - 4)];
        lVar.a(bArr, 0, bArr.length);
        return new PrivateCommand(l, bArr, j);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f10885a);
        parcel.writeLong(this.f10886b);
        parcel.writeInt(this.f10887c.length);
        parcel.writeByteArray(this.f10887c);
    }
}
