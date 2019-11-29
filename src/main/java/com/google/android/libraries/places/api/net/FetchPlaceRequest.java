package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.ay;
import com.google.android.libraries.places.internal.di;
import com.google.android.libraries.places.internal.ha;
import java.util.List;

public abstract class FetchPlaceRequest implements ay {

    public static abstract class Builder {
        public abstract Builder a(String str);

        public abstract Builder a(List<Place.Field> list);

        public abstract FetchPlaceRequest a();

        public abstract Builder setCancellationToken(CancellationToken cancellationToken);

        public abstract Builder setSessionToken(AutocompleteSessionToken autocompleteSessionToken);

        public FetchPlaceRequest build() {
            a((List<Place.Field>) ha.a(a().getPlaceFields()));
            return a();
        }
    }

    public abstract CancellationToken getCancellationToken();

    public abstract List<Place.Field> getPlaceFields();

    public abstract String getPlaceId();

    public abstract AutocompleteSessionToken getSessionToken();

    public static FetchPlaceRequest newInstance(String str, List<Place.Field> list) {
        return builder(str, list).build();
    }

    public static Builder builder(String str, List<Place.Field> list) {
        return new di().a(str).a(list);
    }
}
