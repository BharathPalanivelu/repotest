package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f412a = Log.isLoggable("MediaBrowserCompat", 3);

    public static abstract class a {
        public void a(String str, Bundle bundle, Bundle bundle2) {
        }

        public void b(String str, Bundle bundle, Bundle bundle2) {
        }

        public void c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    public static abstract class b {
        public void a(MediaItem mediaItem) {
        }

        public void a(String str) {
        }
    }

    public static abstract class c {
        public void a(String str, Bundle bundle) {
        }

        public void a(String str, Bundle bundle, List<MediaItem> list) {
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: a */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final int f418a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaDescriptionCompat f419b;

        public int describeContents() {
            return 0;
        }

        MediaItem(Parcel parcel) {
            this.f418a = parcel.readInt();
            this.f419b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f418a);
            this.f419b.writeToParcel(parcel, i);
        }

        public String toString() {
            return "MediaItem{" + "mFlags=" + this.f418a + ", mDescription=" + this.f419b + '}';
        }
    }

    private static class ItemReceiver extends ResultReceiver {

        /* renamed from: d  reason: collision with root package name */
        private final String f416d;

        /* renamed from: e  reason: collision with root package name */
        private final b f417e;

        /* access modifiers changed from: protected */
        public void a(int i, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.f417e.a(this.f416d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.f417e.a((MediaItem) parcelable);
            } else {
                this.f417e.a(this.f416d);
            }
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {

        /* renamed from: d  reason: collision with root package name */
        private final String f420d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f421e;

        /* renamed from: f  reason: collision with root package name */
        private final c f422f;

        /* access modifiers changed from: protected */
        public void a(int i, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.f422f.a(this.f420d, this.f421e);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            this.f422f.a(this.f420d, this.f421e, arrayList);
        }
    }

    private static class CustomActionResultReceiver extends ResultReceiver {

        /* renamed from: d  reason: collision with root package name */
        private final String f413d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f414e;

        /* renamed from: f  reason: collision with root package name */
        private final a f415f;

        /* access modifiers changed from: protected */
        public void a(int i, Bundle bundle) {
            if (this.f415f != null) {
                MediaSessionCompat.a(bundle);
                if (i == -1) {
                    this.f415f.c(this.f413d, this.f414e, bundle);
                } else if (i == 0) {
                    this.f415f.b(this.f413d, this.f414e, bundle);
                } else if (i != 1) {
                    Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.f414e + ", resultData=" + bundle + SQLBuilder.PARENTHESES_RIGHT);
                } else {
                    this.f415f.a(this.f413d, this.f414e, bundle);
                }
            }
        }
    }
}
