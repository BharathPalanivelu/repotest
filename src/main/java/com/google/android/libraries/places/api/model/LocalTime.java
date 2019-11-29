package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.bj;
import com.google.android.libraries.places.internal.go;
import com.google.android.libraries.places.internal.hk;

public abstract class LocalTime implements Parcelable {

    public static abstract class a {
        public abstract a a(int i);

        public abstract LocalTime a();

        public abstract a b(int i);
    }

    public abstract int getHours();

    public abstract int getMinutes();

    public static LocalTime newInstance(int i, int i2) {
        try {
            LocalTime a2 = new bj().a(i).b(i2).a();
            int hours = a2.getHours();
            go.a(hk.a(0, 23).b(Integer.valueOf(hours)), "Hours must not be out-of-range: 0 to 23, but was: %s.", hours);
            int minutes = a2.getMinutes();
            go.a(hk.a(0, 59).b(Integer.valueOf(minutes)), "Minutes must not be out-of-range: 0 to 59, but was: %s.", minutes);
            return a2;
        } catch (IllegalStateException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
