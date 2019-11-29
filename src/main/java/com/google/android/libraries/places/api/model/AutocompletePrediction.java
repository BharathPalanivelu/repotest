package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.be;
import com.google.android.libraries.places.internal.ha;
import java.util.ArrayList;
import java.util.List;

public abstract class AutocompletePrediction implements Parcelable {

    public static abstract class Builder {
        public abstract Builder a(String str);

        public abstract Builder a(List<a> list);

        public abstract AutocompletePrediction a();

        public abstract Builder b(List<a> list);

        public abstract Builder c(List<a> list);

        public abstract Builder setFullText(String str);

        public abstract Builder setPlaceTypes(List<Place.Type> list);

        public abstract Builder setPrimaryText(String str);

        public abstract Builder setSecondaryText(String str);

        public AutocompletePrediction build() {
            AutocompletePrediction a2 = a();
            setPlaceTypes(ha.a(a2.getPlaceTypes()));
            List<a> d2 = a2.d();
            if (d2 != null) {
                a((List<a>) ha.a(d2));
            }
            List<a> e2 = a2.e();
            if (e2 != null) {
                b(ha.a(e2));
            }
            List<a> f2 = a2.f();
            if (f2 != null) {
                c(ha.a(f2));
            }
            return a();
        }
    }

    public static abstract class a implements Parcelable {

        /* renamed from: com.google.android.libraries.places.api.model.AutocompletePrediction$a$a  reason: collision with other inner class name */
        public static abstract class C0213a {
            public abstract C0213a a(int i);

            public abstract a a();

            public abstract C0213a b(int i);
        }

        public abstract int a();

        public abstract int b();
    }

    public abstract String a();

    public abstract String b();

    public abstract String c();

    public abstract List<a> d();

    public abstract List<a> e();

    public abstract List<a> f();

    public abstract String getPlaceId();

    public abstract List<Place.Type> getPlaceTypes();

    public SpannableString getFullText(CharacterStyle characterStyle) {
        return a(a(), d(), characterStyle);
    }

    public SpannableString getPrimaryText(CharacterStyle characterStyle) {
        return a(b(), e(), characterStyle);
    }

    public SpannableString getSecondaryText(CharacterStyle characterStyle) {
        return a(c(), f(), characterStyle);
    }

    public static Builder builder(String str) {
        return new be().a(str).setPlaceTypes(new ArrayList()).setFullText("").setPrimaryText("").setSecondaryText("");
    }

    private static SpannableString a(String str, List<a> list, CharacterStyle characterStyle) {
        SpannableString spannableString = new SpannableString(str);
        if (!(str.length() == 0 || characterStyle == null || list == null)) {
            for (a next : list) {
                spannableString.setSpan(CharacterStyle.wrap(characterStyle), next.a(), next.a() + next.b(), 0);
            }
        }
        return spannableString;
    }
}
