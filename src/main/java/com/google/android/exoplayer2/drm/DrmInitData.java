package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.v;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() {
        /* renamed from: a */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        /* renamed from: a */
        public DrmInitData[] newArray(int i) {
            return new DrmInitData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f9293a;

    /* renamed from: b  reason: collision with root package name */
    private final SchemeData[] f9294b;

    /* renamed from: c  reason: collision with root package name */
    private int f9295c;

    public int describeContents() {
        return 0;
    }

    public DrmInitData(List<SchemeData> list) {
        this(false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(true, schemeDataArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: com.google.android.exoplayer2.drm.DrmInitData$SchemeData[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DrmInitData(boolean r4, com.google.android.exoplayer2.drm.DrmInitData.SchemeData... r5) {
        /*
            r3 = this;
            r3.<init>()
            if (r4 == 0) goto L_0x000c
            java.lang.Object r4 = r5.clone()
            r5 = r4
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r5 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r5
        L_0x000c:
            java.util.Arrays.sort(r5, r3)
            r4 = 1
        L_0x0010:
            int r0 = r5.length
            if (r4 >= r0) goto L_0x0047
            int r0 = r4 + -1
            r0 = r5[r0]
            java.util.UUID r0 = r0.f9301f
            r1 = r5[r4]
            java.util.UUID r1 = r1.f9301f
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002a
            int r4 = r4 + 1
            goto L_0x0010
        L_0x002a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Duplicate data for uuid: "
            r1.append(r2)
            r4 = r5[r4]
            java.util.UUID r4 = r4.f9301f
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x0047:
            r3.f9294b = r5
            int r4 = r5.length
            r3.f9293a = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DrmInitData.<init>(boolean, com.google.android.exoplayer2.drm.DrmInitData$SchemeData[]):void");
    }

    DrmInitData(Parcel parcel) {
        this.f9294b = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.f9293a = this.f9294b.length;
    }

    public SchemeData a(int i) {
        return this.f9294b[i];
    }

    public DrmInitData a(String str) {
        boolean z;
        SchemeData[] schemeDataArr = this.f9294b;
        int length = schemeDataArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (!v.a((Object) schemeDataArr[i].f9296a, (Object) str)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            return this;
        }
        SchemeData[] schemeDataArr2 = new SchemeData[this.f9294b.length];
        for (int i2 = 0; i2 < schemeDataArr2.length; i2++) {
            schemeDataArr2[i2] = this.f9294b[i2].a(str);
        }
        return new DrmInitData(schemeDataArr2);
    }

    public int hashCode() {
        if (this.f9295c == 0) {
            this.f9295c = Arrays.hashCode(this.f9294b);
        }
        return this.f9295c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f9294b, ((DrmInitData) obj).f9294b);
    }

    /* renamed from: a */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        if (b.f9137b.equals(schemeData.f9301f)) {
            return b.f9137b.equals(schemeData2.f9301f) ? 0 : 1;
        }
        return schemeData.f9301f.compareTo(schemeData2.f9301f);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f9294b, 0);
    }

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() {
            /* renamed from: a */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            /* renamed from: a */
            public SchemeData[] newArray(int i) {
                return new SchemeData[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public final String f9296a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9297b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f9298c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f9299d;

        /* renamed from: e  reason: collision with root package name */
        private int f9300e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final UUID f9301f;

        public int describeContents() {
            return 0;
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr) {
            this(uuid, str, str2, bArr, false);
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr, boolean z) {
            this.f9301f = (UUID) a.a(uuid);
            this.f9296a = str;
            this.f9297b = (String) a.a(str2);
            this.f9298c = (byte[]) a.a(bArr);
            this.f9299d = z;
        }

        SchemeData(Parcel parcel) {
            this.f9301f = new UUID(parcel.readLong(), parcel.readLong());
            this.f9296a = parcel.readString();
            this.f9297b = parcel.readString();
            this.f9298c = parcel.createByteArray();
            this.f9299d = parcel.readByte() != 0;
        }

        public SchemeData a(String str) {
            if (v.a((Object) this.f9296a, (Object) str)) {
                return this;
            }
            return new SchemeData(this.f9301f, str, this.f9297b, this.f9298c, this.f9299d);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            if (!this.f9297b.equals(schemeData.f9297b) || !v.a((Object) this.f9301f, (Object) schemeData.f9301f) || !v.a((Object) this.f9296a, (Object) schemeData.f9296a) || !Arrays.equals(this.f9298c, schemeData.f9298c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.f9300e == 0) {
                int hashCode = this.f9301f.hashCode() * 31;
                String str = this.f9296a;
                this.f9300e = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f9297b.hashCode()) * 31) + Arrays.hashCode(this.f9298c);
            }
            return this.f9300e;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f9301f.getMostSignificantBits());
            parcel.writeLong(this.f9301f.getLeastSignificantBits());
            parcel.writeString(this.f9296a);
            parcel.writeString(this.f9297b);
            parcel.writeByteArray(this.f9298c);
            parcel.writeByte(this.f9299d ? (byte) 1 : 0);
        }
    }
}
