package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.k.b;
import com.google.android.exoplayer2.n.t;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.ijk.media.player.misc.IMediaFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class j implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new Parcelable.Creator<j>() {
        /* renamed from: a */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        /* renamed from: a */
        public j[] newArray(int i) {
            return new j[i];
        }
    };
    private int A;

    /* renamed from: a  reason: collision with root package name */
    public final String f10422a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10423b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10424c;

    /* renamed from: d  reason: collision with root package name */
    public final a f10425d;

    /* renamed from: e  reason: collision with root package name */
    public final String f10426e;

    /* renamed from: f  reason: collision with root package name */
    public final String f10427f;

    /* renamed from: g  reason: collision with root package name */
    public final int f10428g;
    public final List<byte[]> h;
    public final com.google.android.exoplayer2.c.a i;
    public final int j;
    public final int k;
    public final float l;
    public final int m;
    public final float n;
    public final int o;
    public final byte[] p;
    public final b q;
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

    public static j a(String str, String str2, String str3, String str4, int i2, int i3, int i4, float f2, List<byte[]> list, int i5) {
        return new j(str, str2, str3, str4, i2, -1, i3, i4, f2, -1, -1.0f, (byte[]) null, -1, (b) null, -1, -1, -1, -1, -1, i5, (String) null, -1, Clock.MAX_TIME, list, (com.google.android.exoplayer2.c.a) null, (a) null);
    }

    public static j a(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, com.google.android.exoplayer2.c.a aVar) {
        return a(str, str2, str3, i2, i3, i4, i5, f2, list, i6, f3, (byte[]) null, -1, (b) null, aVar);
    }

    public static j a(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, byte[] bArr, int i7, b bVar, com.google.android.exoplayer2.c.a aVar) {
        return new j(str, (String) null, str2, str3, i2, i3, i4, i5, f2, i6, f3, bArr, i7, bVar, -1, -1, -1, -1, -1, 0, (String) null, -1, Clock.MAX_TIME, list, aVar, (a) null);
    }

    public static j a(String str, String str2, String str3, String str4, int i2, int i3, int i4, List<byte[]> list, int i5, String str5) {
        return new j(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, i3, i4, -1, -1, -1, i5, str5, -1, Clock.MAX_TIME, list, (com.google.android.exoplayer2.c.a) null, (a) null);
    }

    public static j a(String str, String str2, String str3, int i2, int i3, int i4, int i5, List<byte[]> list, com.google.android.exoplayer2.c.a aVar, int i6, String str4) {
        return a(str, str2, str3, i2, i3, i4, i5, -1, list, aVar, i6, str4);
    }

    public static j a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, List<byte[]> list, com.google.android.exoplayer2.c.a aVar, int i7, String str4) {
        return a(str, str2, str3, i2, i3, i4, i5, i6, -1, -1, list, aVar, i7, str4, (a) null);
    }

    public static j a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, List<byte[]> list, com.google.android.exoplayer2.c.a aVar, int i9, String str4, a aVar2) {
        return new j(str, (String) null, str2, str3, i2, i3, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, i4, i5, i6, i7, i8, i9, str4, -1, Clock.MAX_TIME, list, aVar, aVar2);
    }

    public static j a(String str, String str2, String str3, String str4, int i2, int i3, String str5) {
        return a(str, str2, str3, str4, i2, i3, str5, -1);
    }

    public static j a(String str, String str2, String str3, String str4, int i2, int i3, String str5, int i4) {
        return new j(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, -1, -1, -1, -1, -1, i3, str5, i4, Clock.MAX_TIME, (List<byte[]>) null, (com.google.android.exoplayer2.c.a) null, (a) null);
    }

    public static j a(String str, String str2, String str3, int i2, int i3, String str4, com.google.android.exoplayer2.c.a aVar) {
        return a(str, str2, str3, i2, i3, str4, -1, aVar, (long) Clock.MAX_TIME, (List<byte[]>) Collections.emptyList());
    }

    public static j a(String str, String str2, String str3, int i2, int i3, String str4, int i4, com.google.android.exoplayer2.c.a aVar) {
        return a(str, str2, str3, i2, i3, str4, i4, aVar, (long) Clock.MAX_TIME, (List<byte[]>) Collections.emptyList());
    }

    public static j a(String str, String str2, String str3, int i2, int i3, String str4, com.google.android.exoplayer2.c.a aVar, long j2) {
        return a(str, str2, str3, i2, i3, str4, -1, aVar, j2, (List<byte[]>) Collections.emptyList());
    }

    public static j a(String str, String str2, String str3, int i2, int i3, String str4, int i4, com.google.android.exoplayer2.c.a aVar, long j2, List<byte[]> list) {
        return new j(str, (String) null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, -1, -1, -1, -1, -1, i3, str4, i4, j2, list, aVar, (a) null);
    }

    public static j a(String str, String str2, String str3, int i2, List<byte[]> list, String str4, com.google.android.exoplayer2.c.a aVar) {
        return new j(str, (String) null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, -1, -1, -1, -1, -1, 0, str4, -1, Clock.MAX_TIME, list, aVar, (a) null);
    }

    public static j b(String str, String str2, String str3, String str4, int i2, int i3, String str5) {
        return new j(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, -1, -1, -1, -1, -1, i3, str5, -1, Clock.MAX_TIME, (List<byte[]>) null, (com.google.android.exoplayer2.c.a) null, (a) null);
    }

    public static j a(String str, String str2, long j2) {
        return new j(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, -1, -1, -1, -1, -1, 0, (String) null, -1, j2, (List<byte[]>) null, (com.google.android.exoplayer2.c.a) null, (a) null);
    }

    public static j a(String str, String str2, String str3, int i2, com.google.android.exoplayer2.c.a aVar) {
        return new j(str, (String) null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (b) null, -1, -1, -1, -1, -1, 0, (String) null, -1, Clock.MAX_TIME, (List<byte[]>) null, aVar, (a) null);
    }

    j(String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, float f2, int i6, float f3, byte[] bArr, int i7, b bVar, int i8, int i9, int i10, int i11, int i12, int i13, String str5, int i14, long j2, List<byte[]> list, com.google.android.exoplayer2.c.a aVar, a aVar2) {
        this.f10422a = str;
        this.f10426e = str2;
        this.f10427f = str3;
        this.f10424c = str4;
        this.f10423b = i2;
        this.f10428g = i3;
        this.j = i4;
        this.k = i5;
        this.l = f2;
        this.m = i6;
        this.n = f3;
        this.p = bArr;
        this.o = i7;
        this.q = bVar;
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
        this.i = aVar;
        this.f10425d = aVar2;
    }

    j(Parcel parcel) {
        this.f10422a = parcel.readString();
        this.f10426e = parcel.readString();
        this.f10427f = parcel.readString();
        this.f10424c = parcel.readString();
        this.f10423b = parcel.readInt();
        this.f10428g = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readFloat();
        this.m = parcel.readInt();
        this.n = parcel.readFloat();
        this.p = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.o = parcel.readInt();
        this.q = (b) parcel.readParcelable(b.class.getClassLoader());
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
        this.i = (com.google.android.exoplayer2.c.a) parcel.readParcelable(com.google.android.exoplayer2.c.a.class.getClassLoader());
        this.f10425d = (a) parcel.readParcelable(a.class.getClassLoader());
    }

    public j a(int i2) {
        String str = this.f10422a;
        return new j(str, this.f10426e, this.f10427f, this.f10424c, this.f10423b, i2, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.h, this.i, this.f10425d);
    }

    public j a(long j2) {
        return new j(this.f10422a, this.f10426e, this.f10427f, this.f10424c, this.f10423b, this.f10428g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, j2, this.h, this.i, this.f10425d);
    }

    public j a(String str, String str2, int i2, int i3, int i4, int i5, String str3) {
        return new j(str, this.f10426e, this.f10427f, str2, i2, this.f10428g, i3, i4, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, i5, str3, this.z, this.w, this.h, this.i, this.f10425d);
    }

    public j a(j jVar) {
        j jVar2 = jVar;
        if (this == jVar2) {
            return this;
        }
        String str = jVar2.f10422a;
        String str2 = this.f10424c;
        if (str2 == null) {
            str2 = jVar2.f10424c;
        }
        String str3 = str2;
        int i2 = this.f10423b;
        if (i2 == -1) {
            i2 = jVar2.f10423b;
        }
        int i3 = i2;
        float f2 = this.l;
        if (f2 == -1.0f) {
            f2 = jVar2.l;
        }
        float f3 = f2;
        int i4 = this.x | jVar2.x;
        String str4 = this.y;
        if (str4 == null) {
            str4 = jVar2.y;
        }
        String str5 = str4;
        com.google.android.exoplayer2.c.a aVar = jVar2.i;
        if (aVar == null) {
            aVar = this.i;
        }
        com.google.android.exoplayer2.c.a aVar2 = aVar;
        String str6 = this.f10426e;
        return new j(str, str6, this.f10427f, str3, i3, this.f10428g, this.j, this.k, f3, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, i4, str5, this.z, this.w, this.h, aVar2, this.f10425d);
    }

    public j a(int i2, int i3) {
        String str = this.f10422a;
        return new j(str, this.f10426e, this.f10427f, this.f10424c, this.f10423b, this.f10428g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, i2, i3, this.x, this.y, this.z, this.w, this.h, this.i, this.f10425d);
    }

    public j a(com.google.android.exoplayer2.c.a aVar) {
        String str = this.f10422a;
        return new j(str, this.f10426e, this.f10427f, this.f10424c, this.f10423b, this.f10428g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.h, aVar, this.f10425d);
    }

    public j a(a aVar) {
        String str = this.f10422a;
        return new j(str, this.f10426e, this.f10427f, this.f10424c, this.f10423b, this.f10428g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.h, this.i, aVar);
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
        mediaFormat.setString(IMediaFormat.KEY_MIME, this.f10427f);
        a(mediaFormat, IjkMediaMeta.IJKM_KEY_LANGUAGE, this.y);
        a(mediaFormat, "max-input-size", this.f10428g);
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
        return "Format(" + this.f10422a + ", " + this.f10426e + ", " + this.f10427f + ", " + this.f10423b + ", " + this.y + ", [" + this.j + ", " + this.k + ", " + this.l + "]" + ", [" + this.r + ", " + this.s + "])";
    }

    public int hashCode() {
        if (this.A == 0) {
            String str = this.f10422a;
            int i2 = 0;
            int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f10426e;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f10427f;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f10424c;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f10423b) * 31) + this.j) * 31) + this.k) * 31) + this.r) * 31) + this.s) * 31;
            String str5 = this.y;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.z) * 31;
            com.google.android.exoplayer2.c.a aVar = this.i;
            int hashCode6 = (hashCode5 + (aVar == null ? 0 : aVar.hashCode())) * 31;
            a aVar2 = this.f10425d;
            if (aVar2 != null) {
                i2 = aVar2.hashCode();
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
            j jVar = (j) obj;
            if (this.f10423b == jVar.f10423b && this.f10428g == jVar.f10428g && this.j == jVar.j && this.k == jVar.k && this.l == jVar.l && this.m == jVar.m && this.n == jVar.n && this.o == jVar.o && this.r == jVar.r && this.s == jVar.s && this.t == jVar.t && this.u == jVar.u && this.v == jVar.v && this.w == jVar.w && this.x == jVar.x && t.a((Object) this.f10422a, (Object) jVar.f10422a) && t.a((Object) this.y, (Object) jVar.y) && this.z == jVar.z && t.a((Object) this.f10426e, (Object) jVar.f10426e) && t.a((Object) this.f10427f, (Object) jVar.f10427f) && t.a((Object) this.f10424c, (Object) jVar.f10424c) && t.a((Object) this.i, (Object) jVar.i) && t.a((Object) this.f10425d, (Object) jVar.f10425d) && t.a((Object) this.q, (Object) jVar.q) && Arrays.equals(this.p, jVar.p) && this.h.size() == jVar.h.size()) {
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    if (!Arrays.equals(this.h.get(i2), jVar.h.get(i2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @TargetApi(24)
    private static void a(MediaFormat mediaFormat, b bVar) {
        if (bVar != null) {
            a(mediaFormat, "color-transfer", bVar.f10640c);
            a(mediaFormat, "color-standard", bVar.f10638a);
            a(mediaFormat, "color-range", bVar.f10639b);
            a(mediaFormat, "hdr-static-info", bVar.f10641d);
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

    public static String b(j jVar) {
        if (jVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(jVar.f10422a);
        sb.append(", mimeType=");
        sb.append(jVar.f10427f);
        if (jVar.f10423b != -1) {
            sb.append(", bitrate=");
            sb.append(jVar.f10423b);
        }
        if (!(jVar.j == -1 || jVar.k == -1)) {
            sb.append(", res=");
            sb.append(jVar.j);
            sb.append("x");
            sb.append(jVar.k);
        }
        if (jVar.l != -1.0f) {
            sb.append(", fps=");
            sb.append(jVar.l);
        }
        if (jVar.r != -1) {
            sb.append(", channels=");
            sb.append(jVar.r);
        }
        if (jVar.s != -1) {
            sb.append(", sample_rate=");
            sb.append(jVar.s);
        }
        if (jVar.y != null) {
            sb.append(", language=");
            sb.append(jVar.y);
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f10422a);
        parcel.writeString(this.f10426e);
        parcel.writeString(this.f10427f);
        parcel.writeString(this.f10424c);
        parcel.writeInt(this.f10423b);
        parcel.writeInt(this.f10428g);
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
        parcel.writeParcelable(this.f10425d, 0);
    }
}
