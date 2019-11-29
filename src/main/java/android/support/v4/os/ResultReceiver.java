package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.a;

@SuppressLint({"BanParcelableUsage"})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() {
        /* renamed from: a */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        /* renamed from: a */
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final boolean f489a = false;

    /* renamed from: b  reason: collision with root package name */
    final Handler f490b = null;

    /* renamed from: c  reason: collision with root package name */
    a f491c;

    /* access modifiers changed from: protected */
    public void a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final int f493a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f494b;

        b(int i, Bundle bundle) {
            this.f493a = i;
            this.f494b = bundle;
        }

        public void run() {
            ResultReceiver.this.a(this.f493a, this.f494b);
        }
    }

    class a extends a.C0009a {
        a() {
        }

        public void a(int i, Bundle bundle) {
            if (ResultReceiver.this.f490b != null) {
                ResultReceiver.this.f490b.post(new b(i, bundle));
            } else {
                ResultReceiver.this.a(i, bundle);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f491c == null) {
                this.f491c = new a();
            }
            parcel.writeStrongBinder(this.f491c.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f491c = a.C0009a.a(parcel.readStrongBinder());
    }
}
