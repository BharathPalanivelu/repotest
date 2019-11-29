package com.google.android.libraries.places.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.dx;
import com.google.android.libraries.places.internal.ee;
import com.google.android.libraries.places.internal.fm;
import com.google.android.libraries.places.internal.go;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Autocomplete {
    private Autocomplete() {
    }

    public static Place getPlaceFromIntent(Intent intent) {
        try {
            go.a(intent, (Object) "Intent must not be null.");
            Place place = (Place) intent.getParcelableExtra("selected_place");
            go.a(place != null, (Object) "Intent expected to contain a Place, but doesn't.");
            return place;
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public static class IntentBuilder extends fm {
        public IntentBuilder(AutocompleteActivityMode autocompleteActivityMode, List<Place.Field> list) {
            this.f12561a.putExtra("mode", autocompleteActivityMode);
            this.f12561a.putExtra(AppMeasurementSdk.ConditionalUserProperty.ORIGIN, ee.INTENT);
            this.f12561a.putExtra("place_fields", new ArrayList(list));
        }

        public final IntentBuilder a(ee eeVar) {
            this.f12561a.putExtra(AppMeasurementSdk.ConditionalUserProperty.ORIGIN, eeVar);
            return this;
        }

        public IntentBuilder setInitialQuery(String str) {
            a("initial_query", str);
            return this;
        }

        public IntentBuilder setLocationBias(LocationBias locationBias) {
            a("location_bias", (Parcelable) locationBias);
            return this;
        }

        public IntentBuilder setLocationRestriction(LocationRestriction locationRestriction) {
            a("location_restriction", (Parcelable) locationRestriction);
            return this;
        }

        public IntentBuilder setCountry(String str) {
            a(UserDataStore.COUNTRY, str);
            return this;
        }

        public IntentBuilder setTypeFilter(TypeFilter typeFilter) {
            a("types", (Serializable) typeFilter);
            return this;
        }

        public Intent build(Context context) {
            try {
                return super.a(context, (Class<?>) AutocompleteActivity.class);
            } catch (Error | RuntimeException e2) {
                dx.a(e2);
                throw e2;
            }
        }
    }

    public static Status getStatusFromIntent(Intent intent) {
        try {
            go.a(intent, (Object) "Intent must not be null.");
            Status status = (Status) intent.getParcelableExtra("status");
            go.a(status != null, (Object) "Intent expected to contain a Status, but doesn't.");
            return status;
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }
}
