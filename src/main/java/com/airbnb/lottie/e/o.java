package com.airbnb.lottie.e;

import android.util.JsonReader;
import java.io.IOException;

public class o implements aj<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final o f3680a = new o();

    private o() {
    }

    /* renamed from: a */
    public Integer b(JsonReader jsonReader, float f2) throws IOException {
        return Integer.valueOf(Math.round(p.b(jsonReader) * f2));
    }
}
