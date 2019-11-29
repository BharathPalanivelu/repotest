package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.e;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() {
        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: a */
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final String f2143a;

    /* renamed from: b  reason: collision with root package name */
    final String f2144b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f2145c;

    /* renamed from: d  reason: collision with root package name */
    final int f2146d;

    /* renamed from: e  reason: collision with root package name */
    final int f2147e;

    /* renamed from: f  reason: collision with root package name */
    final String f2148f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f2149g;
    final boolean h;
    final boolean i;
    final Bundle j;
    final boolean k;
    final int l;
    Bundle m;
    Fragment n;

    public int describeContents() {
        return 0;
    }

    FragmentState(Fragment fragment) {
        this.f2143a = fragment.getClass().getName();
        this.f2144b = fragment.mWho;
        this.f2145c = fragment.mFromLayout;
        this.f2146d = fragment.mFragmentId;
        this.f2147e = fragment.mContainerId;
        this.f2148f = fragment.mTag;
        this.f2149g = fragment.mRetainInstance;
        this.h = fragment.mRemoving;
        this.i = fragment.mDetached;
        this.j = fragment.mArguments;
        this.k = fragment.mHidden;
        this.l = fragment.mMaxState.ordinal();
    }

    FragmentState(Parcel parcel) {
        this.f2143a = parcel.readString();
        this.f2144b = parcel.readString();
        boolean z = true;
        this.f2145c = parcel.readInt() != 0;
        this.f2146d = parcel.readInt();
        this.f2147e = parcel.readInt();
        this.f2148f = parcel.readString();
        this.f2149g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readBundle();
        this.k = parcel.readInt() == 0 ? false : z;
        this.m = parcel.readBundle();
        this.l = parcel.readInt();
    }

    public Fragment a(ClassLoader classLoader, f fVar) {
        if (this.n == null) {
            Bundle bundle = this.j;
            if (bundle != null) {
                bundle.setClassLoader(classLoader);
            }
            this.n = fVar.c(classLoader, this.f2143a);
            this.n.setArguments(this.j);
            Bundle bundle2 = this.m;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
                this.n.mSavedFragmentState = this.m;
            } else {
                this.n.mSavedFragmentState = new Bundle();
            }
            Fragment fragment = this.n;
            fragment.mWho = this.f2144b;
            fragment.mFromLayout = this.f2145c;
            fragment.mRestored = true;
            fragment.mFragmentId = this.f2146d;
            fragment.mContainerId = this.f2147e;
            fragment.mTag = this.f2148f;
            fragment.mRetainInstance = this.f2149g;
            fragment.mRemoving = this.h;
            fragment.mDetached = this.i;
            fragment.mHidden = this.k;
            fragment.mMaxState = e.b.values()[this.l];
            if (i.f2176b) {
                Log.v("FragmentManager", "Instantiated fragment " + this.n);
            }
        }
        return this.n;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f2143a);
        sb.append(" (");
        sb.append(this.f2144b);
        sb.append(")}:");
        if (this.f2145c) {
            sb.append(" fromLayout");
        }
        if (this.f2147e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2147e));
        }
        String str = this.f2148f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f2148f);
        }
        if (this.f2149g) {
            sb.append(" retainInstance");
        }
        if (this.h) {
            sb.append(" removing");
        }
        if (this.i) {
            sb.append(" detached");
        }
        if (this.k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f2143a);
        parcel.writeString(this.f2144b);
        parcel.writeInt(this.f2145c ? 1 : 0);
        parcel.writeInt(this.f2146d);
        parcel.writeInt(this.f2147e);
        parcel.writeString(this.f2148f);
        parcel.writeInt(this.f2149g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeBundle(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeInt(this.l);
    }
}
