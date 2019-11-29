package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1828a = aVar.b(iconCompat.f1828a, 1);
        iconCompat.f1830c = aVar.b(iconCompat.f1830c, 2);
        iconCompat.f1831d = aVar.b(iconCompat.f1831d, 3);
        iconCompat.f1832e = aVar.b(iconCompat.f1832e, 4);
        iconCompat.f1833f = aVar.b(iconCompat.f1833f, 5);
        iconCompat.f1834g = (ColorStateList) aVar.b(iconCompat.f1834g, 6);
        iconCompat.j = aVar.b(iconCompat.j, 7);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.a(true, true);
        iconCompat.a(aVar.a());
        if (-1 != iconCompat.f1828a) {
            aVar.a(iconCompat.f1828a, 1);
        }
        if (iconCompat.f1830c != null) {
            aVar.a(iconCompat.f1830c, 2);
        }
        if (iconCompat.f1831d != null) {
            aVar.a(iconCompat.f1831d, 3);
        }
        if (iconCompat.f1832e != 0) {
            aVar.a(iconCompat.f1832e, 4);
        }
        if (iconCompat.f1833f != 0) {
            aVar.a(iconCompat.f1833f, 5);
        }
        if (iconCompat.f1834g != null) {
            aVar.a((Parcelable) iconCompat.f1834g, 6);
        }
        if (iconCompat.j != null) {
            aVar.a(iconCompat.j, 7);
        }
    }
}
