package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.ay;
import com.google.android.libraries.places.internal.dl;

public abstract class FindAutocompletePredictionsRequest implements ay {

    public static abstract class Builder {
        public abstract FindAutocompletePredictionsRequest build();

        public abstract Builder setCancellationToken(CancellationToken cancellationToken);

        public abstract Builder setCountry(String str);

        public abstract Builder setLocationBias(LocationBias locationBias);

        public abstract Builder setLocationRestriction(LocationRestriction locationRestriction);

        public abstract Builder setQuery(String str);

        public abstract Builder setSessionToken(AutocompleteSessionToken autocompleteSessionToken);

        public abstract Builder setTypeFilter(TypeFilter typeFilter);
    }

    public abstract CancellationToken getCancellationToken();

    public abstract String getCountry();

    public abstract LocationBias getLocationBias();

    public abstract LocationRestriction getLocationRestriction();

    public abstract String getQuery();

    public abstract AutocompleteSessionToken getSessionToken();

    public abstract TypeFilter getTypeFilter();

    public static FindAutocompletePredictionsRequest newInstance(String str) {
        return builder().setQuery(str).build();
    }

    public static Builder builder() {
        return new dl();
    }
}
