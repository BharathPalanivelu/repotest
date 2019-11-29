package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.google.android.libraries.places.api.model.Place;
import java.util.ArrayList;
import java.util.List;

public final class aq {

    /* renamed from: a  reason: collision with root package name */
    private static final hd<Place.Field, String> f12343a = new he().a(Place.Field.ADDRESS, "formatted_address").a(Place.Field.ADDRESS_COMPONENTS, "address_components").a(Place.Field.ID, "place_id").a(Place.Field.LAT_LNG, "geometry/location").a(Place.Field.NAME, "name").a(Place.Field.OPENING_HOURS, "opening_hours").a(Place.Field.PHONE_NUMBER, "international_phone_number").a(Place.Field.PHOTO_METADATAS, PlaceFields.PHOTOS_PROFILE).a(Place.Field.PLUS_CODE, "plus_code").a(Place.Field.PRICE_LEVEL, "price_level").a(Place.Field.RATING, "rating").a(Place.Field.TYPES, "types").a(Place.Field.USER_RATINGS_TOTAL, "user_ratings_total").a(Place.Field.VIEWPORT, "geometry/viewport").a(Place.Field.WEBSITE_URI, PlaceFields.WEBSITE).a();

    public static List<String> a(List<Place.Field> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Place.Field field : list) {
            arrayList.add(f12343a.get(field));
        }
        return arrayList;
    }

    public static String b(List<Place.Field> list) {
        StringBuilder sb = new StringBuilder();
        for (Place.Field field : list) {
            String str = f12343a.get(field);
            if (!TextUtils.isEmpty(str)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
