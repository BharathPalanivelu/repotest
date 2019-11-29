package com.shopee.feeds.feedlibrary.picture;

import android.os.Parcel;
import android.os.Parcelable;
import com.shopee.feeds.feedlibrary.c;
import java.util.ArrayList;
import java.util.List;

public final class PictureSelectionConfig implements Parcelable {
    public static final Parcelable.Creator<PictureSelectionConfig> CREATOR = new Parcelable.Creator<PictureSelectionConfig>() {
        /* renamed from: a */
        public PictureSelectionConfig createFromParcel(Parcel parcel) {
            return new PictureSelectionConfig(parcel);
        }

        /* renamed from: a */
        public PictureSelectionConfig[] newArray(int i) {
            return new PictureSelectionConfig[i];
        }
    };
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public List<LocalMedia> R;

    /* renamed from: a  reason: collision with root package name */
    public int f28216a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28217b;

    /* renamed from: c  reason: collision with root package name */
    public String f28218c;

    /* renamed from: d  reason: collision with root package name */
    public String f28219d;

    /* renamed from: e  reason: collision with root package name */
    public String f28220e;

    /* renamed from: f  reason: collision with root package name */
    public int f28221f;

    /* renamed from: g  reason: collision with root package name */
    public int f28222g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public boolean z;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final PictureSelectionConfig f28223a = new PictureSelectionConfig();
    }

    public int describeContents() {
        return 0;
    }

    private void c() {
        this.f28216a = 1;
        this.f28217b = false;
        this.f28221f = c.h.picture_default_style;
        this.f28222g = 2;
        this.h = 9;
        this.i = 0;
        this.j = 1;
        this.k = 90;
        this.l = 0;
        this.m = 0;
        this.n = 60;
        this.o = 100;
        this.p = 4;
        this.q = 0;
        this.r = 0;
        this.y = false;
        this.s = 0;
        this.t = 0;
        this.v = 0;
        this.w = 0;
        this.z = true;
        this.A = false;
        this.B = true;
        this.C = true;
        this.D = true;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = true;
        this.K = true;
        this.L = true;
        this.M = true;
        this.N = true;
        this.O = false;
        this.P = true;
        this.x = true;
        this.Q = true;
        this.f28218c = "";
        this.f28219d = "";
        this.f28220e = ".JPEG";
        this.u = 0.5f;
        this.R = new ArrayList();
    }

    public static PictureSelectionConfig a() {
        return a.f28223a;
    }

    public static PictureSelectionConfig b() {
        PictureSelectionConfig a2 = a();
        a2.c();
        return a2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f28216a);
        parcel.writeByte(this.f28217b ? (byte) 1 : 0);
        parcel.writeString(this.f28218c);
        parcel.writeString(this.f28219d);
        parcel.writeString(this.f28220e);
        parcel.writeInt(this.f28221f);
        parcel.writeInt(this.f28222g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeFloat(this.u);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeByte(this.x ? (byte) 1 : 0);
        parcel.writeByte(this.y ? (byte) 1 : 0);
        parcel.writeByte(this.z ? (byte) 1 : 0);
        parcel.writeByte(this.A ? (byte) 1 : 0);
        parcel.writeByte(this.B ? (byte) 1 : 0);
        parcel.writeByte(this.C ? (byte) 1 : 0);
        parcel.writeByte(this.D ? (byte) 1 : 0);
        parcel.writeByte(this.E ? (byte) 1 : 0);
        parcel.writeByte(this.F ? (byte) 1 : 0);
        parcel.writeByte(this.G ? (byte) 1 : 0);
        parcel.writeByte(this.H ? (byte) 1 : 0);
        parcel.writeByte(this.I ? (byte) 1 : 0);
        parcel.writeByte(this.J ? (byte) 1 : 0);
        parcel.writeByte(this.K ? (byte) 1 : 0);
        parcel.writeByte(this.L ? (byte) 1 : 0);
        parcel.writeByte(this.M ? (byte) 1 : 0);
        parcel.writeByte(this.N ? (byte) 1 : 0);
        parcel.writeByte(this.O ? (byte) 1 : 0);
        parcel.writeByte(this.P ? (byte) 1 : 0);
        parcel.writeByte(this.Q ? (byte) 1 : 0);
        parcel.writeTypedList(this.R);
    }

    public PictureSelectionConfig() {
    }

    protected PictureSelectionConfig(Parcel parcel) {
        this.f28216a = parcel.readInt();
        boolean z2 = true;
        this.f28217b = parcel.readByte() != 0;
        this.f28218c = parcel.readString();
        this.f28219d = parcel.readString();
        this.f28220e = parcel.readString();
        this.f28221f = parcel.readInt();
        this.f28222g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.u = parcel.readFloat();
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        this.x = parcel.readByte() != 0;
        this.y = parcel.readByte() != 0;
        this.z = parcel.readByte() != 0;
        this.A = parcel.readByte() != 0;
        this.B = parcel.readByte() != 0;
        this.C = parcel.readByte() != 0;
        this.D = parcel.readByte() != 0;
        this.E = parcel.readByte() != 0;
        this.F = parcel.readByte() != 0;
        this.G = parcel.readByte() != 0;
        this.H = parcel.readByte() != 0;
        this.I = parcel.readByte() != 0;
        this.J = parcel.readByte() != 0;
        this.K = parcel.readByte() != 0;
        this.L = parcel.readByte() != 0;
        this.M = parcel.readByte() != 0;
        this.N = parcel.readByte() != 0;
        this.O = parcel.readByte() != 0;
        this.P = parcel.readByte() != 0;
        this.Q = parcel.readByte() == 0 ? false : z2;
        this.R = parcel.createTypedArrayList(LocalMedia.CREATOR);
    }
}
