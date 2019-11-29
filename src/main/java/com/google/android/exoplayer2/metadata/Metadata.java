package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() {
        /* renamed from: a */
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        /* renamed from: a */
        public Metadata[] newArray(int i) {
            return new Metadata[0];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Entry[] f10834a;

    public interface Entry extends Parcelable {
    }

    public int describeContents() {
        return 0;
    }

    public Metadata(Entry... entryArr) {
        this.f10834a = entryArr == null ? new Entry[0] : entryArr;
    }

    public Metadata(List<? extends Entry> list) {
        if (list != null) {
            this.f10834a = new Entry[list.size()];
            list.toArray(this.f10834a);
            return;
        }
        this.f10834a = new Entry[0];
    }

    Metadata(Parcel parcel) {
        this.f10834a = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            Entry[] entryArr = this.f10834a;
            if (i < entryArr.length) {
                entryArr[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public int a() {
        return this.f10834a.length;
    }

    public Entry a(int i) {
        return this.f10834a[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f10834a, ((Metadata) obj).f10834a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f10834a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10834a.length);
        for (Entry writeParcelable : this.f10834a) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
