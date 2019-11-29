package com.google.android.libraries.places.widget;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.dx;
import com.google.android.libraries.places.internal.ea;
import com.google.android.libraries.places.internal.eb;
import com.google.android.libraries.places.internal.go;
import com.google.android.libraries.places.internal.ha;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import java.util.List;

@Deprecated
public class AutocompleteFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public EditText f13083a;

    /* renamed from: b  reason: collision with root package name */
    public LocationBias f13084b;

    /* renamed from: c  reason: collision with root package name */
    public LocationRestriction f13085c;

    /* renamed from: d  reason: collision with root package name */
    public String f13086d;

    /* renamed from: e  reason: collision with root package name */
    public TypeFilter f13087e;

    /* renamed from: f  reason: collision with root package name */
    public ha<Place.Field> f13088f;

    /* renamed from: g  reason: collision with root package name */
    private View f13089g;
    private View h;
    private PlaceSelectionListener i;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            View inflate = layoutInflater.inflate(R.layout.places_autocomplete_fragment, viewGroup, false);
            this.f13089g = inflate.findViewById(R.id.places_autocomplete_search_button);
            this.h = inflate.findViewById(R.id.places_autocomplete_clear_button);
            this.f13083a = (EditText) inflate.findViewById(R.id.places_autocomplete_search_input);
            ea eaVar = new ea(this);
            this.f13089g.setOnClickListener(eaVar);
            this.f13083a.setOnClickListener(eaVar);
            this.h.setOnClickListener(new eb(this));
            a();
            inflate.setEnabled(false);
            return inflate;
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public void onDestroyView() {
        try {
            this.f13089g = null;
            this.h = null;
            this.f13083a = null;
            super.onDestroyView();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public void setText(CharSequence charSequence) {
        try {
            this.f13083a.setText(charSequence);
            a();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public void setHint(CharSequence charSequence) {
        try {
            this.f13083a.setHint(charSequence);
            this.f13089g.setContentDescription(charSequence);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public void setLocationBias(LocationBias locationBias) {
        this.f13084b = locationBias;
    }

    public void setLocationRestriction(LocationRestriction locationRestriction) {
        this.f13085c = locationRestriction;
    }

    public void setCountry(String str) {
        this.f13086d = str;
    }

    public void setTypeFilter(TypeFilter typeFilter) {
        this.f13087e = typeFilter;
    }

    public void setPlaceFields(List<Place.Field> list) {
        try {
            go.a(list, (Object) "Place Fields must not be null.");
            this.f13088f = ha.a(list);
            getView().setEnabled(true);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public void setOnPlaceSelectedListener(PlaceSelectionListener placeSelectionListener) {
        this.i = placeSelectionListener;
    }

    private final void a() {
        this.h.setVisibility(this.f13083a.getText().toString().isEmpty() ^ true ? 0 : 8);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        try {
            getView().setEnabled(true);
            if (i2 == 30421) {
                if (this.i == null) {
                    if (Log.isLoggable("Places", 5)) {
                        Log.w("Places", "No PlaceSelectionListener is set. No result will be delivered.");
                    }
                } else if (i3 == -1) {
                    Place placeFromIntent = Autocomplete.getPlaceFromIntent(intent);
                    this.i.onPlaceSelected(placeFromIntent);
                    setText(placeFromIntent.getName());
                } else if (i3 == 2) {
                    this.i.onError(Autocomplete.getStatusFromIntent(intent));
                }
            }
            super.onActivityResult(i2, i3, intent);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }
}
