package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.libraries.places.internal.bl;
import com.google.android.libraries.places.internal.go;
import com.google.android.libraries.places.internal.ha;
import java.util.ArrayList;
import java.util.List;

public abstract class OpeningHours implements Parcelable {

    public static abstract class Builder {
        public abstract OpeningHours a();

        public abstract Builder setPeriods(List<Period> list);

        public abstract Builder setWeekdayText(List<String> list);

        public OpeningHours build() {
            OpeningHours a2 = a();
            for (String isEmpty : a2.getWeekdayText()) {
                go.b(!TextUtils.isEmpty(isEmpty), (Object) "WeekdayText must not contain null or empty values.");
            }
            setPeriods(ha.a(a2.getPeriods()));
            setWeekdayText(ha.a(a2.getWeekdayText()));
            return a();
        }
    }

    public abstract List<Period> getPeriods();

    public abstract List<String> getWeekdayText();

    public static Builder builder() {
        return new bl().setPeriods(new ArrayList()).setWeekdayText(new ArrayList());
    }
}
