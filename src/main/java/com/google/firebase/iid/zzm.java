package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

public class zzm implements Parcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new ao();

    /* renamed from: a  reason: collision with root package name */
    private Messenger f14198a;

    /* renamed from: b  reason: collision with root package name */
    private ay f14199b;

    public static final class a extends ClassLoader {
        /* access modifiers changed from: protected */
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            if (!FirebaseInstanceId.d()) {
                return zzm.class;
            }
            Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
            return zzm.class;
        }
    }

    public zzm(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f14198a = new Messenger(iBinder);
        } else {
            this.f14199b = new ax(iBinder);
        }
    }

    public int describeContents() {
        return 0;
    }

    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f14198a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f14199b.a(message);
        }
    }

    private final IBinder a() {
        Messenger messenger = this.f14198a;
        return messenger != null ? messenger.getBinder() : this.f14199b.asBinder();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((zzm) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.f14198a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f14199b.asBinder());
        }
    }
}
