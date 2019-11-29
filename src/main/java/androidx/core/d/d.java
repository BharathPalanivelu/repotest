package androidx.core.d;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class d {
    @Deprecated
    public static <T> Parcelable.Creator<T> a(e<T> eVar) {
        return new a(eVar);
    }

    static class a<T> implements Parcelable.ClassLoaderCreator<T> {

        /* renamed from: a  reason: collision with root package name */
        private final e<T> f1658a;

        a(e<T> eVar) {
            this.f1658a = eVar;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f1658a.a(parcel, (ClassLoader) null);
        }

        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f1658a.a(parcel, classLoader);
        }

        public T[] newArray(int i) {
            return this.f1658a.a(i);
        }
    }
}
