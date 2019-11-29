package com.google.android.libraries.places.internal;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteFragment;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

public final /* synthetic */ class ea implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final AutocompleteFragment f12489a;

    public ea(AutocompleteFragment autocompleteFragment) {
        this.f12489a = autocompleteFragment;
    }

    public final void onClick(View view) {
        AutocompleteFragment autocompleteFragment = this.f12489a;
        if (!autocompleteFragment.getView().isEnabled()) {
            go.a(autocompleteFragment.f13088f, (Object) "Place Fields must be set.");
            if (Log.isLoggable("Places", 6)) {
                Log.e("Places", "Autocomplete activity cannot be launched until fragment is enabled.");
                return;
            }
            return;
        }
        Intent build = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, autocompleteFragment.f13088f).setInitialQuery(autocompleteFragment.f13083a.getText().toString()).setCountry(autocompleteFragment.f13086d).setLocationBias(autocompleteFragment.f13084b).setLocationRestriction(autocompleteFragment.f13085c).setTypeFilter(autocompleteFragment.f13087e).a(ee.FRAGMENT).build(autocompleteFragment.getActivity());
        autocompleteFragment.getView().setEnabled(false);
        autocompleteFragment.startActivityForResult(build, 30421);
    }
}
