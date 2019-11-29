package com.airbnb.android.react.maps;

import android.content.Context;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.gms.maps.GoogleMap;

public abstract class c extends ReactViewGroup {
    public abstract void b(GoogleMap googleMap);

    public abstract Object getFeature();

    public c(Context context) {
        super(context);
    }
}
