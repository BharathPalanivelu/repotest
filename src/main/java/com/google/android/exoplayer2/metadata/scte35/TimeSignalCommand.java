package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.s;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Parcelable.Creator<TimeSignalCommand>() {
        /* renamed from: a */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }

        /* renamed from: a */
        public TimeSignalCommand[] newArray(int i) {
            return new TimeSignalCommand[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f10908a;

    /* renamed from: b  reason: collision with root package name */
    public final long f10909b;

    private TimeSignalCommand(long j, long j2) {
        this.f10908a = j;
        this.f10909b = j2;
    }

    static TimeSignalCommand a(l lVar, long j, s sVar) {
        long a2 = a(lVar, j);
        return new TimeSignalCommand(a2, sVar.b(a2));
    }

    static long a(l lVar, long j) {
        long g2 = (long) lVar.g();
        if ((128 & g2) != 0) {
            return 8589934591L & ((((g2 & 1) << 32) | lVar.l()) + j);
        }
        return -9223372036854775807L;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f10908a);
        parcel.writeLong(this.f10909b);
    }
}
