package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new Parcelable.ClassLoaderCreator<AbsSavedState>() {
        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.f1936c;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        /* renamed from: a */
        public AbsSavedState[] newArray(int i) {
            return new AbsSavedState[i];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final AbsSavedState f1936c = new AbsSavedState() {
    };

    /* renamed from: a  reason: collision with root package name */
    private final Parcelable f1937a;

    public int describeContents() {
        return 0;
    }

    private AbsSavedState() {
        this.f1937a = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.f1937a = parcelable == f1936c ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f1937a = readParcelable == null ? f1936c : readParcelable;
    }

    public final Parcelable a() {
        return this.f1937a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1937a, i);
    }
}
