package com.airbnb.lottie.e;

import android.util.JsonReader;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.c;
import com.airbnb.lottie.c.a.g;
import com.airbnb.lottie.c.a.h;
import com.airbnb.lottie.c.a.j;
import com.airbnb.lottie.f.f;
import com.airbnb.lottie.g.a;
import java.io.IOException;
import java.util.List;

public class d {
    public static b a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return a(jsonReader, dVar, true);
    }

    public static b a(JsonReader jsonReader, com.airbnb.lottie.d dVar, boolean z) throws IOException {
        return new b(a(jsonReader, z ? f.a() : 1.0f, dVar, i.f3678a));
    }

    static com.airbnb.lottie.c.a.d b(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.c.a.d(a(jsonReader, dVar, o.f3680a));
    }

    static com.airbnb.lottie.c.a.f c(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.c.a.f(a(jsonReader, f.a(), dVar, y.f3685a));
    }

    static g d(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new g((List<a<com.airbnb.lottie.g.d>>) a(jsonReader, dVar, ac.f3674a));
    }

    static h e(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new h(a(jsonReader, f.a(), dVar, ad.f3675a));
    }

    static j f(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new j(a(jsonReader, dVar, h.f3677a));
    }

    static com.airbnb.lottie.c.a.a g(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.c.a.a(a(jsonReader, dVar, f.f3676a));
    }

    static c a(JsonReader jsonReader, com.airbnb.lottie.d dVar, int i) throws IOException {
        return new c(a(jsonReader, dVar, new l(i)));
    }

    private static <T> List<a<T>> a(JsonReader jsonReader, com.airbnb.lottie.d dVar, aj<T> ajVar) throws IOException {
        return r.a(jsonReader, dVar, 1.0f, ajVar);
    }

    private static <T> List<a<T>> a(JsonReader jsonReader, float f2, com.airbnb.lottie.d dVar, aj<T> ajVar) throws IOException {
        return r.a(jsonReader, dVar, f2, ajVar);
    }
}
