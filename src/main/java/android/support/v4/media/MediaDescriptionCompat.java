package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.a(a.a(parcel));
        }

        /* renamed from: a */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final String f423a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f424b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f425c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f426d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f427e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f428f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f429g;
    private final Uri h;
    private Object i;

    public int describeContents() {
        return 0;
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f423a = str;
        this.f424b = charSequence;
        this.f425c = charSequence2;
        this.f426d = charSequence3;
        this.f427e = bitmap;
        this.f428f = uri;
        this.f429g = bundle;
        this.h = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f423a = parcel.readString();
        this.f424b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f425c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f426d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = getClass().getClassLoader();
        this.f427e = (Bitmap) parcel.readParcelable(classLoader);
        this.f428f = (Uri) parcel.readParcelable(classLoader);
        this.f429g = parcel.readBundle(classLoader);
        this.h = (Uri) parcel.readParcelable(classLoader);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f423a);
            TextUtils.writeToParcel(this.f424b, parcel, i2);
            TextUtils.writeToParcel(this.f425c, parcel, i2);
            TextUtils.writeToParcel(this.f426d, parcel, i2);
            parcel.writeParcelable(this.f427e, i2);
            parcel.writeParcelable(this.f428f, i2);
            parcel.writeBundle(this.f429g);
            parcel.writeParcelable(this.h, i2);
            return;
        }
        a.a(a(), parcel, i2);
    }

    public String toString() {
        return this.f424b + ", " + this.f425c + ", " + this.f426d;
    }

    public Object a() {
        if (this.i != null || Build.VERSION.SDK_INT < 21) {
            return this.i;
        }
        Object a2 = a.C0003a.a();
        a.C0003a.a(a2, this.f423a);
        a.C0003a.a(a2, this.f424b);
        a.C0003a.b(a2, this.f425c);
        a.C0003a.c(a2, this.f426d);
        a.C0003a.a(a2, this.f427e);
        a.C0003a.a(a2, this.f428f);
        Bundle bundle = this.f429g;
        if (Build.VERSION.SDK_INT < 23 && this.h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.h);
        }
        a.C0003a.a(a2, bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            b.a.a(a2, this.h);
        }
        this.i = a.C0003a.a(a2);
        return this.i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0080
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x0080
            android.support.v4.media.MediaDescriptionCompat$a r1 = new android.support.v4.media.MediaDescriptionCompat$a
            r1.<init>()
            java.lang.String r2 = android.support.v4.media.a.a((java.lang.Object) r8)
            r1.a((java.lang.String) r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.b(r8)
            r1.a((java.lang.CharSequence) r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.c(r8)
            r1.b((java.lang.CharSequence) r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.d(r8)
            r1.c(r2)
            android.graphics.Bitmap r2 = android.support.v4.media.a.e(r8)
            r1.a((android.graphics.Bitmap) r2)
            android.net.Uri r2 = android.support.v4.media.a.f(r8)
            r1.a((android.net.Uri) r2)
            android.os.Bundle r2 = android.support.v4.media.a.g(r8)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            if (r2 == 0) goto L_0x004a
            android.support.v4.media.session.MediaSessionCompat.a(r2)
            android.os.Parcelable r4 = r2.getParcelable(r3)
            android.net.Uri r4 = (android.net.Uri) r4
            goto L_0x004b
        L_0x004a:
            r4 = r0
        L_0x004b:
            if (r4 == 0) goto L_0x0063
            java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r6 = r2.containsKey(r5)
            if (r6 == 0) goto L_0x005d
            int r6 = r2.size()
            r7 = 2
            if (r6 != r7) goto L_0x005d
            goto L_0x0064
        L_0x005d:
            r2.remove(r3)
            r2.remove(r5)
        L_0x0063:
            r0 = r2
        L_0x0064:
            r1.a((android.os.Bundle) r0)
            if (r4 == 0) goto L_0x006d
            r1.b((android.net.Uri) r4)
            goto L_0x007a
        L_0x006d:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L_0x007a
            android.net.Uri r0 = android.support.v4.media.b.a(r8)
            r1.b((android.net.Uri) r0)
        L_0x007a:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.a()
            r0.i = r8
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f430a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f431b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f432c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f433d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f434e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f435f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f436g;
        private Uri h;

        public a a(String str) {
            this.f430a = str;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f431b = charSequence;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.f432c = charSequence;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f433d = charSequence;
            return this;
        }

        public a a(Bitmap bitmap) {
            this.f434e = bitmap;
            return this;
        }

        public a a(Uri uri) {
            this.f435f = uri;
            return this;
        }

        public a a(Bundle bundle) {
            this.f436g = bundle;
            return this;
        }

        public a b(Uri uri) {
            this.h = uri;
            return this;
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f430a, this.f431b, this.f432c, this.f433d, this.f434e, this.f435f, this.f436g, this.h);
        }
    }
}
