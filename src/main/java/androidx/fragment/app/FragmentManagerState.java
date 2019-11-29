package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() {
        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* renamed from: a */
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    ArrayList<FragmentState> f2138a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f2139b;

    /* renamed from: c  reason: collision with root package name */
    BackStackState[] f2140c;

    /* renamed from: d  reason: collision with root package name */
    String f2141d = null;

    /* renamed from: e  reason: collision with root package name */
    int f2142e;

    public int describeContents() {
        return 0;
    }

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.f2138a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f2139b = parcel.createStringArrayList();
        this.f2140c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f2141d = parcel.readString();
        this.f2142e = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f2138a);
        parcel.writeStringList(this.f2139b);
        parcel.writeTypedArray(this.f2140c, i);
        parcel.writeString(this.f2141d);
        parcel.writeInt(this.f2142e);
    }
}
