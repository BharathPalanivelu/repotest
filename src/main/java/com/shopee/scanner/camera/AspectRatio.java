package com.shopee.scanner.camera;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.b.h;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class AspectRatio implements Parcelable, Comparable<AspectRatio> {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new Parcelable.Creator<AspectRatio>() {
        /* renamed from: a */
        public AspectRatio createFromParcel(Parcel parcel) {
            return AspectRatio.a(parcel.readInt(), parcel.readInt());
        }

        /* renamed from: a */
        public AspectRatio[] newArray(int i) {
            return new AspectRatio[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private static final h<h<AspectRatio>> f30279a = new h<>(16);

    /* renamed from: b  reason: collision with root package name */
    private final int f30280b;

    /* renamed from: c  reason: collision with root package name */
    private final int f30281c;

    public int describeContents() {
        return 0;
    }

    public static AspectRatio a(int i, int i2) {
        int b2 = b(i, i2);
        int i3 = i / b2;
        int i4 = i2 / b2;
        h a2 = f30279a.a(i3);
        if (a2 == null) {
            AspectRatio aspectRatio = new AspectRatio(i3, i4);
            h hVar = new h();
            hVar.b(i4, aspectRatio);
            f30279a.b(i3, hVar);
            return aspectRatio;
        }
        AspectRatio aspectRatio2 = (AspectRatio) a2.a(i4);
        if (aspectRatio2 != null) {
            return aspectRatio2;
        }
        AspectRatio aspectRatio3 = new AspectRatio(i3, i4);
        a2.b(i4, aspectRatio3);
        return aspectRatio3;
    }

    public static AspectRatio a(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            try {
                return a(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException("Malformed aspect ratio: " + str, e2);
            }
        } else {
            throw new IllegalArgumentException("Malformed aspect ratio: " + str);
        }
    }

    private AspectRatio(int i, int i2) {
        this.f30280b = i;
        this.f30281c = i2;
    }

    public int a() {
        return this.f30280b;
    }

    public int b() {
        return this.f30281c;
    }

    public boolean a(f fVar) {
        int b2 = b(fVar.a(), fVar.b());
        return this.f30280b == fVar.a() / b2 && this.f30281c == fVar.b() / b2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AspectRatio)) {
            return false;
        }
        AspectRatio aspectRatio = (AspectRatio) obj;
        if (this.f30280b == aspectRatio.f30280b && this.f30281c == aspectRatio.f30281c) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f30280b + ":" + this.f30281c;
    }

    public float c() {
        return ((float) this.f30280b) / ((float) this.f30281c);
    }

    public int hashCode() {
        int i = this.f30281c;
        int i2 = this.f30280b;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    /* renamed from: a */
    public int compareTo(AspectRatio aspectRatio) {
        if (equals(aspectRatio)) {
            return 0;
        }
        return c() - aspectRatio.c() > BitmapDescriptorFactory.HUE_RED ? 1 : -1;
    }

    public AspectRatio d() {
        return a(this.f30281c, this.f30280b);
    }

    private static int b(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i == 0) {
                return i4;
            }
            i2 = i4 % i;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f30280b);
        parcel.writeInt(this.f30281c);
    }
}
