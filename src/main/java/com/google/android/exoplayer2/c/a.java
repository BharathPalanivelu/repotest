package com.google.android.exoplayer2.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.z;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class a implements Parcelable, Comparator<C0159a> {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f9249a;

    /* renamed from: b  reason: collision with root package name */
    private final C0159a[] f9250b;

    /* renamed from: c  reason: collision with root package name */
    private int f9251c;

    public int describeContents() {
        return 0;
    }

    public a(List<C0159a> list) {
        this(false, (C0159a[]) list.toArray(new C0159a[list.size()]));
    }

    public a(C0159a... aVarArr) {
        this(true, aVarArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: com.google.android.exoplayer2.c.a$a[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private a(boolean r4, com.google.android.exoplayer2.c.a.C0159a... r5) {
        /*
            r3 = this;
            r3.<init>()
            if (r4 == 0) goto L_0x000c
            java.lang.Object r4 = r5.clone()
            r5 = r4
            com.google.android.exoplayer2.c.a$a[] r5 = (com.google.android.exoplayer2.c.a.C0159a[]) r5
        L_0x000c:
            java.util.Arrays.sort(r5, r3)
            r4 = 1
        L_0x0010:
            int r0 = r5.length
            if (r4 >= r0) goto L_0x0047
            int r0 = r4 + -1
            r0 = r5[r0]
            java.util.UUID r0 = r0.f9256e
            r1 = r5[r4]
            java.util.UUID r1 = r1.f9256e
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
            java.util.UUID r4 = r4.f9256e
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x0047:
            r3.f9250b = r5
            int r4 = r5.length
            r3.f9249a = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.a.<init>(boolean, com.google.android.exoplayer2.c.a$a[]):void");
    }

    a(Parcel parcel) {
        this.f9250b = (C0159a[]) parcel.createTypedArray(C0159a.CREATOR);
        this.f9249a = this.f9250b.length;
    }

    public C0159a a(int i) {
        return this.f9250b[i];
    }

    public int hashCode() {
        if (this.f9251c == 0) {
            this.f9251c = Arrays.hashCode(this.f9250b);
        }
        return this.f9251c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f9250b, ((a) obj).f9250b);
    }

    /* renamed from: a */
    public int compare(C0159a aVar, C0159a aVar2) {
        if (z.f12316b.equals(aVar.f9256e)) {
            return z.f12316b.equals(aVar2.f9256e) ? 0 : 1;
        }
        return aVar.f9256e.compareTo(aVar2.f9256e);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f9250b, 0);
    }

    /* renamed from: com.google.android.exoplayer2.c.a$a  reason: collision with other inner class name */
    public static final class C0159a implements Parcelable {
        public static final Parcelable.Creator<C0159a> CREATOR = new Parcelable.Creator<C0159a>() {
            /* renamed from: a */
            public C0159a createFromParcel(Parcel parcel) {
                return new C0159a(parcel);
            }

            /* renamed from: a */
            public C0159a[] newArray(int i) {
                return new C0159a[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public final String f9252a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f9253b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f9254c;

        /* renamed from: d  reason: collision with root package name */
        private int f9255d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final UUID f9256e;

        public int describeContents() {
            return 0;
        }

        public C0159a(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public C0159a(UUID uuid, String str, byte[] bArr, boolean z) {
            this.f9256e = (UUID) com.google.android.exoplayer2.n.a.a(uuid);
            this.f9252a = (String) com.google.android.exoplayer2.n.a.a(str);
            this.f9253b = (byte[]) com.google.android.exoplayer2.n.a.a(bArr);
            this.f9254c = z;
        }

        C0159a(Parcel parcel) {
            this.f9256e = new UUID(parcel.readLong(), parcel.readLong());
            this.f9252a = parcel.readString();
            this.f9253b = parcel.createByteArray();
            this.f9254c = parcel.readByte() != 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0159a)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            C0159a aVar = (C0159a) obj;
            if (!this.f9252a.equals(aVar.f9252a) || !t.a((Object) this.f9256e, (Object) aVar.f9256e) || !Arrays.equals(this.f9253b, aVar.f9253b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.f9255d == 0) {
                this.f9255d = (((this.f9256e.hashCode() * 31) + this.f9252a.hashCode()) * 31) + Arrays.hashCode(this.f9253b);
            }
            return this.f9255d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f9256e.getMostSignificantBits());
            parcel.writeLong(this.f9256e.getLeastSignificantBits());
            parcel.writeString(this.f9252a);
            parcel.writeByteArray(this.f9253b);
            parcel.writeByte(this.f9254c ? (byte) 1 : 0);
        }
    }
}
