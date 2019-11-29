package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

public final class AudioAttributesImplApi21Parcelizer {
    public static b read(a aVar) {
        b bVar = new b();
        bVar.f2658a = (AudioAttributes) aVar.b(bVar.f2658a, 1);
        bVar.f2659b = aVar.b(bVar.f2659b, 2);
        return bVar;
    }

    public static void write(b bVar, a aVar) {
        aVar.a(false, false);
        aVar.a((Parcelable) bVar.f2658a, 1);
        aVar.a(bVar.f2659b, 2);
    }
}
