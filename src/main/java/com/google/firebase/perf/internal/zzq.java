package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.zzax;
import com.google.android.gms.internal.p000firebaseperf.zzbg;
import com.google.android.gms.internal.p000firebaseperf.zzcr;
import com.google.android.gms.internal.p000firebaseperf.zzcv;
import com.google.android.gms.internal.p000firebaseperf.zzep;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class zzq implements Parcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    private String f14286a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14287b;

    /* renamed from: c  reason: collision with root package name */
    private zzbg f14288c;

    public static zzq a() {
        String replaceAll = UUID.randomUUID().toString().replaceAll("\\-", "");
        zzq zzq = new zzq(replaceAll, new zzax());
        zzq.f14287b = a(FeatureControl.zzao().zzap(), FeatureControl.zzao().zzas());
        Object[] objArr = new Object[2];
        objArr[0] = zzq.f14287b ? "Verbose" : "Non Verbose";
        objArr[1] = replaceAll;
        Log.d("FirebasePerformance", String.format("Creating a new %s Session: %s", objArr));
        return zzq;
    }

    public int describeContents() {
        return 0;
    }

    private zzq(String str, zzax zzax) {
        this.f14287b = false;
        this.f14286a = str;
        this.f14288c = new zzbg();
    }

    public final String b() {
        return this.f14286a;
    }

    public final boolean c() {
        return this.f14287b;
    }

    public final boolean d() {
        return TimeUnit.MICROSECONDS.toMinutes(this.f14288c.zzcs()) > FeatureControl.zzao().zzax();
    }

    public final zzcr e() {
        zzcr.zza zzad = zzcr.zzfl().zzad(this.f14286a);
        if (this.f14287b) {
            zzad.zzb(zzcv.GAUGES_AND_SYSTEM_EVENTS);
        }
        return (zzcr) ((zzep) zzad.zzhr());
    }

    public static zzcr[] a(List<zzq> list) {
        if (list.isEmpty()) {
            return null;
        }
        zzcr[] zzcrArr = new zzcr[list.size()];
        zzcr e2 = list.get(0).e();
        boolean z = false;
        for (int i = 1; i < list.size(); i++) {
            zzcr e3 = list.get(i).e();
            if (z || !list.get(i).f14287b) {
                zzcrArr[i] = e3;
            } else {
                zzcrArr[0] = e3;
                zzcrArr[i] = e2;
                z = true;
            }
        }
        if (!z) {
            zzcrArr[0] = e2;
        }
        return zzcrArr;
    }

    private static boolean a(boolean z, float f2) {
        return z && Math.random() * 100.0d < ((double) f2);
    }

    public static boolean f() {
        return a(true, 1.0f);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14286a);
        parcel.writeByte(this.f14287b ? (byte) 1 : 0);
        parcel.writeParcelable(this.f14288c, 0);
    }

    private zzq(Parcel parcel) {
        boolean z = false;
        this.f14287b = false;
        this.f14286a = parcel.readString();
        this.f14287b = parcel.readByte() != 0 ? true : z;
        this.f14288c = (zzbg) parcel.readParcelable(zzbg.class.getClassLoader());
    }

    /* synthetic */ zzq(Parcel parcel, s sVar) {
        this(parcel);
    }
}
