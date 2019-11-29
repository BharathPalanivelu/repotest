package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

public final class gc implements Parcelable {
    public static final Parcelable.Creator<gc> CREATOR = new gd();

    /* renamed from: a  reason: collision with root package name */
    public final ee f12609a;

    /* renamed from: b  reason: collision with root package name */
    public final AutocompleteActivityMode f12610b;

    /* renamed from: c  reason: collision with root package name */
    public final AutocompleteSessionToken f12611c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12612d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12613e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12614f;

    /* renamed from: g  reason: collision with root package name */
    public int f12615g;
    public int h;
    public int i;
    public int j;
    public String k;
    public int l;
    public int m;
    public boolean n;
    public int o;
    public long p;
    public final a q;

    public gc(ee eeVar, AutocompleteActivityMode autocompleteActivityMode, String str, a aVar) {
        this.f12609a = eeVar;
        this.f12610b = autocompleteActivityMode;
        this.k = go.a(str);
        this.f12615g = -1;
        this.p = -1;
        this.f12611c = AutocompleteSessionToken.newInstance();
        this.q = aVar;
    }

    public final int describeContents() {
        return 0;
    }

    gc(Parcel parcel) {
        this.f12609a = (ee) parcel.readParcelable(ee.class.getClassLoader());
        this.f12610b = (AutocompleteActivityMode) parcel.readParcelable(AutocompleteActivityMode.class.getClassLoader());
        this.f12612d = a(parcel);
        this.f12613e = a(parcel);
        this.f12614f = a(parcel);
        this.f12615g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = a(parcel);
        this.o = parcel.readInt();
        this.p = parcel.readLong();
        this.f12611c = (AutocompleteSessionToken) parcel.readParcelable(AutocompleteSessionToken.class.getClassLoader());
        this.q = new c();
    }

    private static boolean a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f12609a, i2);
        parcel.writeParcelable(this.f12610b, i2);
        a(parcel, this.f12612d);
        a(parcel, this.f12613e);
        a(parcel, this.f12614f);
        parcel.writeInt(this.f12615g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        a(parcel, this.n);
        parcel.writeInt(this.o);
        parcel.writeLong(this.p);
        parcel.writeParcelable(this.f12611c, i2);
    }

    private static void a(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public final boolean a() {
        return this.p != -1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof gc) {
            gc gcVar = (gc) obj;
            if (!hj.a((Object) this.f12609a, (Object) gcVar.f12609a) || !hj.a((Object) this.f12610b, (Object) gcVar.f12610b) || !hj.a((Object) this.f12611c, (Object) gcVar.f12611c) || !hj.a((Object) Boolean.valueOf(this.f12612d), (Object) Boolean.valueOf(gcVar.f12612d)) || !hj.a((Object) Boolean.valueOf(this.f12613e), (Object) Boolean.valueOf(gcVar.f12613e)) || !hj.a((Object) Boolean.valueOf(this.f12614f), (Object) Boolean.valueOf(gcVar.f12614f)) || this.f12615g != gcVar.f12615g || this.h != gcVar.h || this.i != gcVar.i || this.j != gcVar.j || !hj.a((Object) this.k, (Object) gcVar.k) || this.l != gcVar.l || this.m != gcVar.m || !hj.a((Object) Boolean.valueOf(this.n), (Object) Boolean.valueOf(gcVar.n)) || this.o != gcVar.o || this.p != gcVar.p || !hj.a((Object) this.q, (Object) gcVar.q)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return hj.a(this.f12609a, this.f12610b, this.f12611c, Boolean.valueOf(this.f12612d), Boolean.valueOf(this.f12613e), Boolean.valueOf(this.f12614f), Integer.valueOf(this.f12615g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j), this.k, Integer.valueOf(this.l), Integer.valueOf(this.m), Boolean.valueOf(this.n), Integer.valueOf(this.o), Long.valueOf(this.p), this.q);
    }
}
