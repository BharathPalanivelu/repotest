package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.l;
import androidx.lifecycle.e;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: a */
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int[] f2119a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<String> f2120b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f2121c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f2122d;

    /* renamed from: e  reason: collision with root package name */
    final int f2123e;

    /* renamed from: f  reason: collision with root package name */
    final int f2124f;

    /* renamed from: g  reason: collision with root package name */
    final String f2125g;
    final int h;
    final int i;
    final CharSequence j;
    final int k;
    final CharSequence l;
    final ArrayList<String> m;
    final ArrayList<String> n;
    final boolean o;

    public int describeContents() {
        return 0;
    }

    public BackStackState(a aVar) {
        int size = aVar.f2227d.size();
        this.f2119a = new int[(size * 5)];
        if (aVar.k) {
            this.f2120b = new ArrayList<>(size);
            this.f2121c = new int[size];
            this.f2122d = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                l.a aVar2 = (l.a) aVar.f2227d.get(i2);
                int i4 = i3 + 1;
                this.f2119a[i3] = aVar2.f2231a;
                this.f2120b.add(aVar2.f2232b != null ? aVar2.f2232b.mWho : null);
                int i5 = i4 + 1;
                this.f2119a[i4] = aVar2.f2233c;
                int i6 = i5 + 1;
                this.f2119a[i5] = aVar2.f2234d;
                int i7 = i6 + 1;
                this.f2119a[i6] = aVar2.f2235e;
                this.f2119a[i7] = aVar2.f2236f;
                this.f2121c[i2] = aVar2.f2237g.ordinal();
                this.f2122d[i2] = aVar2.h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f2123e = aVar.i;
            this.f2124f = aVar.j;
            this.f2125g = aVar.m;
            this.h = aVar.f2164c;
            this.i = aVar.n;
            this.j = aVar.o;
            this.k = aVar.p;
            this.l = aVar.q;
            this.m = aVar.r;
            this.n = aVar.s;
            this.o = aVar.t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f2119a = parcel.createIntArray();
        this.f2120b = parcel.createStringArrayList();
        this.f2121c = parcel.createIntArray();
        this.f2122d = parcel.createIntArray();
        this.f2123e = parcel.readInt();
        this.f2124f = parcel.readInt();
        this.f2125g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.k = parcel.readInt();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public a a(i iVar) {
        a aVar = new a(iVar);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f2119a.length) {
            l.a aVar2 = new l.a();
            int i4 = i2 + 1;
            aVar2.f2231a = this.f2119a[i2];
            if (i.f2176b) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i3 + " base fragment #" + this.f2119a[i4]);
            }
            String str = this.f2120b.get(i3);
            if (str != null) {
                aVar2.f2232b = iVar.f2181g.get(str);
            } else {
                aVar2.f2232b = null;
            }
            aVar2.f2237g = e.b.values()[this.f2121c[i3]];
            aVar2.h = e.b.values()[this.f2122d[i3]];
            int[] iArr = this.f2119a;
            int i5 = i4 + 1;
            aVar2.f2233c = iArr[i4];
            int i6 = i5 + 1;
            aVar2.f2234d = iArr[i5];
            int i7 = i6 + 1;
            aVar2.f2235e = iArr[i6];
            aVar2.f2236f = iArr[i7];
            aVar.f2228e = aVar2.f2233c;
            aVar.f2229f = aVar2.f2234d;
            aVar.f2230g = aVar2.f2235e;
            aVar.h = aVar2.f2236f;
            aVar.a(aVar2);
            i3++;
            i2 = i7 + 1;
        }
        aVar.i = this.f2123e;
        aVar.j = this.f2124f;
        aVar.m = this.f2125g;
        aVar.f2164c = this.h;
        aVar.k = true;
        aVar.n = this.i;
        aVar.o = this.j;
        aVar.p = this.k;
        aVar.q = this.l;
        aVar.r = this.m;
        aVar.s = this.n;
        aVar.t = this.o;
        aVar.a(1);
        return aVar;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f2119a);
        parcel.writeStringList(this.f2120b);
        parcel.writeIntArray(this.f2121c);
        parcel.writeIntArray(this.f2122d);
        parcel.writeInt(this.f2123e);
        parcel.writeInt(this.f2124f);
        parcel.writeString(this.f2125g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        TextUtils.writeToParcel(this.j, parcel, 0);
        parcel.writeInt(this.k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }
}
