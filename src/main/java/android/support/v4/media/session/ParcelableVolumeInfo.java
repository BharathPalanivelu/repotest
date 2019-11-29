package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator<ParcelableVolumeInfo>() {
        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: a */
        public ParcelableVolumeInfo[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f469a;

    /* renamed from: b  reason: collision with root package name */
    public int f470b;

    /* renamed from: c  reason: collision with root package name */
    public int f471c;

    /* renamed from: d  reason: collision with root package name */
    public int f472d;

    /* renamed from: e  reason: collision with root package name */
    public int f473e;

    public int describeContents() {
        return 0;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f469a = parcel.readInt();
        this.f471c = parcel.readInt();
        this.f472d = parcel.readInt();
        this.f473e = parcel.readInt();
        this.f470b = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f469a);
        parcel.writeInt(this.f471c);
        parcel.writeInt(this.f472d);
        parcel.writeInt(this.f473e);
        parcel.writeInt(this.f470b);
    }
}
