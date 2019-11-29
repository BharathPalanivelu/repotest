package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.video.ColorInfo;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.ijk.media.player.misc.IMediaFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() {
        /* renamed from: a */
        public Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        /* renamed from: a */
        public Format[] newArray(int i) {
            return new Format[i];
        }
    };
    private int A;

    /* renamed from: a  reason: collision with root package name */
    public final String f8953a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8954b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8955c;

    /* renamed from: d  reason: collision with root package name */
    public final Metadata f8956d;

    /* renamed from: e  reason: collision with root package name */
    public final String f8957e;

    /* renamed from: f  reason: collision with root package name */
    public final String f8958f;

    /* renamed from: g  reason: collision with root package name */
    public final int f8959g;
    public final List<byte[]> h;
    public final DrmInitData i;
    public final int j;
    public final int k;
    public final float l;
    public final int m;
    public final float n;
    public final int o;
    public final byte[] p;
    public final ColorInfo q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final long w;
    public final int x;
    public final String y;
    public final int z;

    public int describeContents() {
        return 0;
    }

    public static Format a(String str, String str2, String str3, String str4, int i2, int i3, int i4, float f2, List<byte[]> list, int i5) {
        return new Format(str, str2, str3, str4, i2, -1, i3, i4, f2, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, i5, (String) null, -1, Clock.MAX_TIME, list, (DrmInitData) null, (Metadata) null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, DrmInitData drmInitData) {
        return a(str, str2, str3, i2, i3, i4, i5, f2, list, i6, f3, (byte[]) null, -1, (ColorInfo) null, drmInitData);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, byte[] bArr, int i7, ColorInfo colorInfo, DrmInitData drmInitData) {
        return new Format(str, (String) null, str2, str3, i2, i3, i4, i5, f2, i6, f3, bArr, i7, colorInfo, -1, -1, -1, -1, -1, 0, (String) null, -1, Clock.MAX_TIME, list, drmInitData, (Metadata) null);
    }

    public static Format a(String str, String str2, String str3, String str4, int i2, int i3, int i4, List<byte[]> list, int i5, String str5) {
        return new Format(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, i3, i4, -1, -1, -1, i5, str5, -1, Clock.MAX_TIME, list, (DrmInitData) null, (Metadata) null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str4) {
        return a(str, str2, str3, i2, i3, i4, i5, -1, list, drmInitData, i6, str4);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, List<byte[]> list, DrmInitData drmInitData, int i7, String str4) {
        return a(str, str2, str3, i2, i3, i4, i5, i6, -1, -1, list, drmInitData, i7, str4, (Metadata) null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, List<byte[]> list, DrmInitData drmInitData, int i9, String str4, Metadata metadata) {
        return new Format(str, (String) null, str2, str3, i2, i3, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, i4, i5, i6, i7, i8, i9, str4, -1, Clock.MAX_TIME, list, drmInitData, metadata);
    }

    public static Format a(String str, String str2, String str3, String str4, int i2, int i3, String str5) {
        return a(str, str2, str3, str4, i2, i3, str5, -1);
    }

    public static Format a(String str, String str2, String str3, String str4, int i2, int i3, String str5, int i4) {
        return new Format(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, i3, str5, i4, Clock.MAX_TIME, (List<byte[]>) null, (DrmInitData) null, (Metadata) null);
    }

    public static Format a(String str, String str2, int i2, String str3) {
        return a(str, str2, i2, str3, (DrmInitData) null);
    }

    public static Format a(String str, String str2, int i2, String str3, DrmInitData drmInitData) {
        return a(str, str2, (String) null, -1, i2, str3, -1, drmInitData, (long) Clock.MAX_TIME, (List<byte[]>) Collections.emptyList());
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, String str4, int i4, DrmInitData drmInitData) {
        return a(str, str2, str3, i2, i3, str4, i4, drmInitData, (long) Clock.MAX_TIME, (List<byte[]>) Collections.emptyList());
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, String str4, DrmInitData drmInitData, long j2) {
        return a(str, str2, str3, i2, i3, str4, -1, drmInitData, j2, (List<byte[]>) Collections.emptyList());
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, String str4, int i4, DrmInitData drmInitData, long j2, List<byte[]> list) {
        return new Format(str, (String) null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, i3, str4, i4, j2, list, drmInitData, (Metadata) null);
    }

    public static Format a(String str, String str2, String str3, int i2, List<byte[]> list, String str4, DrmInitData drmInitData) {
        return new Format(str, (String) null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, 0, str4, -1, Clock.MAX_TIME, list, drmInitData, (Metadata) null);
    }

    public static Format b(String str, String str2, String str3, String str4, int i2, int i3, String str5) {
        return new Format(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, i3, str5, -1, Clock.MAX_TIME, (List<byte[]>) null, (DrmInitData) null, (Metadata) null);
    }

    public static Format a(String str, String str2, long j2) {
        return new Format(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, 0, (String) null, -1, j2, (List<byte[]>) null, (DrmInitData) null, (Metadata) null);
    }

    public static Format a(String str, String str2, String str3, int i2, DrmInitData drmInitData) {
        return new Format(str, (String) null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, 0, (String) null, -1, Clock.MAX_TIME, (List<byte[]>) null, drmInitData, (Metadata) null);
    }

    Format(String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, float f2, int i6, float f3, byte[] bArr, int i7, ColorInfo colorInfo, int i8, int i9, int i10, int i11, int i12, int i13, String str5, int i14, long j2, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        this.f8953a = str;
        this.f8957e = str2;
        this.f8958f = str3;
        this.f8955c = str4;
        this.f8954b = i2;
        this.f8959g = i3;
        this.j = i4;
        this.k = i5;
        this.l = f2;
        this.m = i6;
        this.n = f3;
        this.p = bArr;
        this.o = i7;
        this.q = colorInfo;
        this.r = i8;
        this.s = i9;
        this.t = i10;
        this.u = i11;
        this.v = i12;
        this.x = i13;
        this.y = str5;
        this.z = i14;
        this.w = j2;
        this.h = list == null ? Collections.emptyList() : list;
        this.i = drmInitData;
        this.f8956d = metadata;
    }

    Format(Parcel parcel) {
        this.f8953a = parcel.readString();
        this.f8957e = parcel.readString();
        this.f8958f = parcel.readString();
        this.f8955c = parcel.readString();
        this.f8954b = parcel.readInt();
        this.f8959g = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readFloat();
        this.m = parcel.readInt();
        this.n = parcel.readFloat();
        this.p = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.o = parcel.readInt();
        this.q = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.u = parcel.readInt();
        this.v = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readString();
        this.z = parcel.readInt();
        this.w = parcel.readLong();
        int readInt = parcel.readInt();
        this.h = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.h.add(parcel.createByteArray());
        }
        this.i = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.f8956d = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
    }

    public Format a(int i2) {
        String str = this.f8953a;
        return new Format(str, this.f8957e, this.f8958f, this.f8955c, this.f8954b, i2, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.h, this.i, this.f8956d);
    }

    public Format a(long j2) {
        return new Format(this.f8953a, this.f8957e, this.f8958f, this.f8955c, this.f8954b, this.f8959g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, j2, this.h, this.i, this.f8956d);
    }

    public Format a(String str, String str2, int i2, int i3, int i4, int i5, String str3) {
        return new Format(str, this.f8957e, this.f8958f, str2, i2, this.f8959g, i3, i4, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, i5, str3, this.z, this.w, this.h, this.i, this.f8956d);
    }

    public Format a(Format format) {
        Format format2 = format;
        if (this == format2) {
            return this;
        }
        String str = format2.f8953a;
        String str2 = this.f8955c;
        if (str2 == null) {
            str2 = format2.f8955c;
        }
        String str3 = str2;
        int i2 = this.f8954b;
        if (i2 == -1) {
            i2 = format2.f8954b;
        }
        int i3 = i2;
        float f2 = this.l;
        if (f2 == -1.0f) {
            f2 = format2.l;
        }
        float f3 = f2;
        int i4 = this.x | format2.x;
        String str4 = this.y;
        if (str4 == null) {
            str4 = format2.y;
        }
        String str5 = str4;
        DrmInitData drmInitData = format2.i;
        if (drmInitData == null) {
            drmInitData = this.i;
        }
        DrmInitData drmInitData2 = drmInitData;
        String str6 = this.f8957e;
        return new Format(str, str6, this.f8958f, str3, i3, this.f8959g, this.j, this.k, f3, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, i4, str5, this.z, this.w, this.h, drmInitData2, this.f8956d);
    }

    public Format a(int i2, int i3) {
        String str = this.f8953a;
        return new Format(str, this.f8957e, this.f8958f, this.f8955c, this.f8954b, this.f8959g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, i2, i3, this.x, this.y, this.z, this.w, this.h, this.i, this.f8956d);
    }

    public Format a(DrmInitData drmInitData) {
        String str = this.f8953a;
        return new Format(str, this.f8957e, this.f8958f, this.f8955c, this.f8954b, this.f8959g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.h, drmInitData, this.f8956d);
    }

    public Format a(Metadata metadata) {
        String str = this.f8953a;
        return new Format(str, this.f8957e, this.f8958f, this.f8955c, this.f8954b, this.f8959g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.h, this.i, metadata);
    }

    public int a() {
        int i2 = this.j;
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.k;
        if (i3 == -1) {
            return -1;
        }
        return i2 * i3;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat b() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, this.f8958f);
        a(mediaFormat, IjkMediaMeta.IJKM_KEY_LANGUAGE, this.y);
        a(mediaFormat, "max-input-size", this.f8959g);
        a(mediaFormat, "width", this.j);
        a(mediaFormat, "height", this.k);
        a(mediaFormat, "frame-rate", this.l);
        a(mediaFormat, "rotation-degrees", this.m);
        a(mediaFormat, "channel-count", this.r);
        a(mediaFormat, "sample-rate", this.s);
        a(mediaFormat, "encoder-delay", this.u);
        a(mediaFormat, "encoder-padding", this.v);
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap(this.h.get(i2)));
        }
        a(mediaFormat, this.q);
        return mediaFormat;
    }

    public String toString() {
        return "Format(" + this.f8953a + ", " + this.f8957e + ", " + this.f8958f + ", " + this.f8954b + ", " + this.y + ", [" + this.j + ", " + this.k + ", " + this.l + "]" + ", [" + this.r + ", " + this.s + "])";
    }

    public int hashCode() {
        if (this.A == 0) {
            String str = this.f8953a;
            int i2 = 0;
            int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f8957e;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f8958f;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f8955c;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f8954b) * 31) + this.j) * 31) + this.k) * 31) + this.r) * 31) + this.s) * 31;
            String str5 = this.y;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.z) * 31;
            DrmInitData drmInitData = this.i;
            int hashCode6 = (hashCode5 + (drmInitData == null ? 0 : drmInitData.hashCode())) * 31;
            Metadata metadata = this.f8956d;
            if (metadata != null) {
                i2 = metadata.hashCode();
            }
            this.A = hashCode6 + i2;
        }
        return this.A;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Format format = (Format) obj;
            if (this.f8954b == format.f8954b && this.f8959g == format.f8959g && this.j == format.j && this.k == format.k && this.l == format.l && this.m == format.m && this.n == format.n && this.o == format.o && this.r == format.r && this.s == format.s && this.t == format.t && this.u == format.u && this.v == format.v && this.w == format.w && this.x == format.x && v.a((Object) this.f8953a, (Object) format.f8953a) && v.a((Object) this.y, (Object) format.y) && this.z == format.z && v.a((Object) this.f8957e, (Object) format.f8957e) && v.a((Object) this.f8958f, (Object) format.f8958f) && v.a((Object) this.f8955c, (Object) format.f8955c) && v.a((Object) this.i, (Object) format.i) && v.a((Object) this.f8956d, (Object) format.f8956d) && v.a((Object) this.q, (Object) format.q) && Arrays.equals(this.p, format.p) && this.h.size() == format.h.size()) {
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    if (!Arrays.equals(this.h.get(i2), format.h.get(i2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @TargetApi(24)
    private static void a(MediaFormat mediaFormat, ColorInfo colorInfo) {
        if (colorInfo != null) {
            a(mediaFormat, "color-transfer", colorInfo.f12219c);
            a(mediaFormat, "color-standard", colorInfo.f12217a);
            a(mediaFormat, "color-range", colorInfo.f12218b);
            a(mediaFormat, "hdr-static-info", colorInfo.f12220d);
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, float f2) {
        if (f2 != -1.0f) {
            mediaFormat.setFloat(str, f2);
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8953a);
        parcel.writeString(this.f8957e);
        parcel.writeString(this.f8958f);
        parcel.writeString(this.f8955c);
        parcel.writeInt(this.f8954b);
        parcel.writeInt(this.f8959g);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeFloat(this.l);
        parcel.writeInt(this.m);
        parcel.writeFloat(this.n);
        parcel.writeInt(this.p != null ? 1 : 0);
        byte[] bArr = this.p;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.o);
        parcel.writeParcelable(this.q, i2);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeInt(this.x);
        parcel.writeString(this.y);
        parcel.writeInt(this.z);
        parcel.writeLong(this.w);
        int size = this.h.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeByteArray(this.h.get(i3));
        }
        parcel.writeParcelable(this.i, 0);
        parcel.writeParcelable(this.f8956d, 0);
    }
}
