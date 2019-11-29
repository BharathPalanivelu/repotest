package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() {
        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: a */
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f443a;

    /* renamed from: b  reason: collision with root package name */
    private final float f444b;

    RatingCompat(int i, float f2) {
        this.f443a = i;
        this.f444b = f2;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f443a);
        sb.append(" rating=");
        float f2 = this.f444b;
        if (f2 < BitmapDescriptorFactory.HUE_RED) {
            str = "unrated";
        } else {
            str = String.valueOf(f2);
        }
        sb.append(str);
        return sb.toString();
    }

    public int describeContents() {
        return this.f443a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f443a);
        parcel.writeFloat(this.f444b);
    }
}
