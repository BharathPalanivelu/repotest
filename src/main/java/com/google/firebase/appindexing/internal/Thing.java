package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@SafeParcelable.Class(creator = "ThingCreator")
public final class Thing extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Thing> CREATOR = new b();
    @SafeParcelable.Field(getter = "getVersionCode", id = 1000)

    /* renamed from: a  reason: collision with root package name */
    private final int f6790a;
    @SafeParcelable.Field(getter = "getPropertyBundle", id = 1)

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f6791b;
    @SafeParcelable.Field(getter = "getMetadata", id = 2)

    /* renamed from: c  reason: collision with root package name */
    private final zza f6792c;
    @SafeParcelable.Field(getter = "getUrl", id = 3)

    /* renamed from: d  reason: collision with root package name */
    private final String f6793d;
    @SafeParcelable.Field(getter = "getType", id = 4)

    /* renamed from: e  reason: collision with root package name */
    private final String f6794e;

    @SafeParcelable.Constructor
    public Thing(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) zza zza2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2) {
        this.f6790a = i;
        this.f6791b = bundle;
        this.f6792c = zza2;
        this.f6793d = str;
        this.f6794e = str2;
        this.f6791b.setClassLoader(getClass().getClassLoader());
    }

    @SafeParcelable.Class(creator = "MetadataCreator")
    @SafeParcelable.Reserved({1000})
    public static class zza extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zza> CREATOR = new f();
        @SafeParcelable.Field(getter = "getWorksOffline", id = 1)

        /* renamed from: a  reason: collision with root package name */
        private final boolean f6795a;
        @SafeParcelable.Field(getter = "getScore", id = 2)

        /* renamed from: b  reason: collision with root package name */
        private final int f6796b;
        @SafeParcelable.Field(getter = "getAccountEmail", id = 3)

        /* renamed from: c  reason: collision with root package name */
        private final String f6797c;
        @SafeParcelable.Field(getter = "getPropertyBundle", id = 4)

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f6798d;

        @SafeParcelable.Constructor
        public zza(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) Bundle bundle) {
            this.f6795a = z;
            this.f6796b = i;
            this.f6797c = str;
            this.f6798d = bundle == null ? new Bundle() : bundle;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, this.f6795a);
            SafeParcelWriter.writeInt(parcel, 2, this.f6796b);
            SafeParcelWriter.writeString(parcel, 3, this.f6797c, false);
            SafeParcelWriter.writeBundle(parcel, 4, this.f6798d, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("worksOffline: ");
            sb.append(this.f6795a);
            sb.append(", score: ");
            sb.append(this.f6796b);
            if (!this.f6797c.isEmpty()) {
                sb.append(", accountEmail: ");
                sb.append(this.f6797c);
            }
            Bundle bundle = this.f6798d;
            if (bundle != null && !bundle.isEmpty()) {
                sb.append(", Properties { ");
                Thing.b(this.f6798d, sb);
                sb.append("}");
            }
            return sb.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return Objects.equal(Boolean.valueOf(this.f6795a), Boolean.valueOf(zza.f6795a)) && Objects.equal(Integer.valueOf(this.f6796b), Integer.valueOf(zza.f6796b)) && Objects.equal(this.f6797c, zza.f6797c) && Thing.b(this.f6798d, zza.f6798d);
        }

        public final int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.f6795a), Integer.valueOf(this.f6796b), this.f6797c, Integer.valueOf(Thing.b(this.f6798d)));
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.f6791b, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f6792c, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.f6793d, false);
        SafeParcelWriter.writeString(parcel, 4, this.f6794e, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f6790a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: private */
    public static void b(Bundle bundle, StringBuilder sb) {
        try {
            Set keySet = bundle.keySet();
            String[] strArr = (String[]) keySet.toArray(new String[keySet.size()]);
            Arrays.sort(strArr, a.f6799a);
            for (String str : strArr) {
                sb.append("{ key: '");
                sb.append(str);
                sb.append("' value: ");
                Object obj = bundle.get(str);
                if (obj == null) {
                    sb.append("<null>");
                } else if (obj.getClass().isArray()) {
                    sb.append("[ ");
                    for (int i = 0; i < Array.getLength(obj); i++) {
                        sb.append("'");
                        sb.append(Array.get(obj, i));
                        sb.append("' ");
                    }
                    sb.append("]");
                } else {
                    sb.append(obj.toString());
                }
                sb.append(" } ");
            }
        } catch (RuntimeException unused) {
            sb.append("<error>");
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6794e.equals("Thing") ? "Indexable" : this.f6794e);
        sb.append(" { { id: ");
        if (this.f6793d == null) {
            sb.append("<null>");
        } else {
            sb.append("'");
            sb.append(this.f6793d);
            sb.append("'");
        }
        sb.append(" } Properties { ");
        b(this.f6791b, sb);
        sb.append("} ");
        sb.append("Metadata { ");
        sb.append(this.f6792c.toString());
        sb.append(" } ");
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Thing)) {
            return false;
        }
        Thing thing = (Thing) obj;
        return Objects.equal(Integer.valueOf(this.f6790a), Integer.valueOf(thing.f6790a)) && Objects.equal(this.f6793d, thing.f6793d) && Objects.equal(this.f6794e, thing.f6794e) && Objects.equal(this.f6792c, thing.f6792c) && b(this.f6791b, thing.f6791b);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f6790a), this.f6793d, this.f6794e, Integer.valueOf(this.f6792c.hashCode()), Integer.valueOf(b(this.f6791b)));
    }

    /* access modifiers changed from: private */
    public static boolean b(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !b((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null && (obj2 != null || !bundle2.containsKey(str))) {
                return false;
            }
            if (obj instanceof boolean[]) {
                if (!(obj2 instanceof boolean[]) || !Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof long[]) {
                if (!(obj2 instanceof long[]) || !Arrays.equals((long[]) obj, (long[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof double[]) {
                if (!(obj2 instanceof double[]) || !Arrays.equals((double[]) obj, (double[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof byte[]) {
                if (!(obj2 instanceof byte[]) || !Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                    return false;
                }
            } else if ((obj instanceof Object[]) && (!(obj2 instanceof Object[]) || !Arrays.equals((Object[]) obj, (Object[]) obj2))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static int b(Bundle bundle) {
        ArrayList arrayList = new ArrayList(bundle.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = arrayList;
        int size = arrayList3.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            Object obj2 = bundle.get((String) obj);
            if (obj2 instanceof boolean[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((boolean[]) obj2)));
            } else if (obj2 instanceof long[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((long[]) obj2)));
            } else if (obj2 instanceof double[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((double[]) obj2)));
            } else if (obj2 instanceof byte[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((byte[]) obj2)));
            } else if (obj2 instanceof Object[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((Object[]) obj2)));
            } else {
                arrayList2.add(Integer.valueOf(Objects.hashCode(obj2)));
            }
        }
        return Objects.hashCode(arrayList2.toArray());
    }

    static final /* synthetic */ int a(String str, String str2) {
        if (str == null) {
            return str2 == null ? 0 : -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }
}
