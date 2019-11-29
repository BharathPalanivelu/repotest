package androidx.media;

import androidx.versionedparcelable.a;

public final class AudioAttributesImplBaseParcelizer {
    public static c read(a aVar) {
        c cVar = new c();
        cVar.f2660a = aVar.b(cVar.f2660a, 1);
        cVar.f2661b = aVar.b(cVar.f2661b, 2);
        cVar.f2662c = aVar.b(cVar.f2662c, 3);
        cVar.f2663d = aVar.b(cVar.f2663d, 4);
        return cVar;
    }

    public static void write(c cVar, a aVar) {
        aVar.a(false, false);
        aVar.a(cVar.f2660a, 1);
        aVar.a(cVar.f2661b, 2);
        aVar.a(cVar.f2662c, 3);
        aVar.a(cVar.f2663d, 4);
    }
}
