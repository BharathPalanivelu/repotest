package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableByte extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableByte> CREATOR = new Parcelable.Creator<ObservableByte>() {
        /* renamed from: a */
        public ObservableByte createFromParcel(Parcel parcel) {
            return new ObservableByte(parcel.readByte());
        }

        /* renamed from: a */
        public ObservableByte[] newArray(int i) {
            return new ObservableByte[i];
        }
    };
    static final long serialVersionUID = 1;
    private byte mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableByte(byte b2) {
        this.mValue = b2;
    }

    public ObservableByte() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mValue);
    }
}
