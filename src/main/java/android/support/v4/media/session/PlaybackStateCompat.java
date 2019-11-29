package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() {
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: a */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f474a;

    /* renamed from: b  reason: collision with root package name */
    final long f475b;

    /* renamed from: c  reason: collision with root package name */
    final long f476c;

    /* renamed from: d  reason: collision with root package name */
    final float f477d;

    /* renamed from: e  reason: collision with root package name */
    final long f478e;

    /* renamed from: f  reason: collision with root package name */
    final int f479f;

    /* renamed from: g  reason: collision with root package name */
    final CharSequence f480g;
    final long h;
    List<CustomAction> i;
    final long j;
    final Bundle k;
    private Object l;

    public int describeContents() {
        return 0;
    }

    PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, int i3, CharSequence charSequence, long j5, List<CustomAction> list, long j6, Bundle bundle) {
        this.f474a = i2;
        this.f475b = j2;
        this.f476c = j3;
        this.f477d = f2;
        this.f478e = j4;
        this.f479f = i3;
        this.f480g = charSequence;
        this.h = j5;
        this.i = new ArrayList(list);
        this.j = j6;
        this.k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f474a = parcel.readInt();
        this.f475b = parcel.readLong();
        this.f477d = parcel.readFloat();
        this.h = parcel.readLong();
        this.f476c = parcel.readLong();
        this.f478e = parcel.readLong();
        this.f480g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.j = parcel.readLong();
        this.k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f479f = parcel.readInt();
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f474a + ", position=" + this.f475b + ", buffered position=" + this.f476c + ", speed=" + this.f477d + ", updated=" + this.h + ", actions=" + this.f478e + ", error code=" + this.f479f + ", error message=" + this.f480g + ", custom actions=" + this.i + ", active item id=" + this.j + "}";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f474a);
        parcel.writeLong(this.f475b);
        parcel.writeFloat(this.f477d);
        parcel.writeLong(this.h);
        parcel.writeLong(this.f476c);
        parcel.writeLong(this.f478e);
        TextUtils.writeToParcel(this.f480g, parcel, i2);
        parcel.writeTypedList(this.i);
        parcel.writeLong(this.j);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.f479f);
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        Object obj2 = obj;
        Bundle bundle = null;
        if (obj2 == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> h2 = e.h(obj);
        if (h2 != null) {
            ArrayList arrayList2 = new ArrayList(h2.size());
            for (Object a2 : h2) {
                arrayList2.add(CustomAction.a(a2));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = f.a(obj);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(e.a(obj), e.b(obj), e.c(obj), e.d(obj), e.e(obj), 0, e.f(obj), e.g(obj), arrayList, e.i(obj), bundle);
        playbackStateCompat.l = obj2;
        return playbackStateCompat;
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() {
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: a */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final String f481a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f482b;

        /* renamed from: c  reason: collision with root package name */
        private final int f483c;

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f484d;

        /* renamed from: e  reason: collision with root package name */
        private Object f485e;

        public int describeContents() {
            return 0;
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f481a = str;
            this.f482b = charSequence;
            this.f483c = i;
            this.f484d = bundle;
        }

        CustomAction(Parcel parcel) {
            this.f481a = parcel.readString();
            this.f482b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f483c = parcel.readInt();
            this.f484d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f481a);
            TextUtils.writeToParcel(this.f482b, parcel, i);
            parcel.writeInt(this.f483c);
            parcel.writeBundle(this.f484d);
        }

        public static CustomAction a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(e.a.a(obj), e.a.b(obj), e.a.c(obj), e.a.d(obj));
            customAction.f485e = obj;
            return customAction;
        }

        public String toString() {
            return "Action:mName='" + this.f482b + ", mIcon=" + this.f483c + ", mExtras=" + this.f484d;
        }
    }
}
