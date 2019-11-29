package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.Cdo;
import com.google.android.libraries.places.internal.ay;
import com.google.android.libraries.places.internal.ha;
import java.util.List;

public abstract class FindCurrentPlaceRequest implements ay {

    public static abstract class Builder {
        public abstract Builder a(List<Place.Field> list);

        public abstract FindCurrentPlaceRequest a();

        public abstract Builder setCancellationToken(CancellationToken cancellationToken);

        public FindCurrentPlaceRequest build() {
            a(ha.a(a().getPlaceFields()));
            return a();
        }
    }

    public abstract CancellationToken getCancellationToken();

    public abstract List<Place.Field> getPlaceFields();

    public static FindCurrentPlaceRequest newInstance(List<Place.Field> list) {
        return builder(list).build();
    }

    public static Builder builder(List<Place.Field> list) {
        return new Cdo().a(list);
    }
}
