package com.google.android.libraries.places.internal;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

public final /* synthetic */ class ec implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final AutocompleteSupportFragment f12491a;

    public ec(AutocompleteSupportFragment autocompleteSupportFragment) {
        this.f12491a = autocompleteSupportFragment;
    }

    public final void onClick(View view) {
        AutocompleteSupportFragment autocompleteSupportFragment = this.f12491a;
        if (!autocompleteSupportFragment.getView().isEnabled()) {
            go.a(autocompleteSupportFragment.f13095f, (Object) "Place Fields must be set.");
            if (Log.isLoggable("Places", 6)) {
                Log.e("Places", "Autocomplete activity cannot be launched until fragment is enabled.");
                return;
            }
            return;
        }
        Intent build = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, autocompleteSupportFragment.f13095f).setInitialQuery(autocompleteSupportFragment.f13090a.getText().toString()).setCountry(autocompleteSupportFragment.f13093d).setLocationBias(autocompleteSupportFragment.f13091b).setLocationRestriction(autocompleteSupportFragment.f13092c).setTypeFilter(autocompleteSupportFragment.f13094e).a(ee.FRAGMENT).build(autocompleteSupportFragment.getActivity());
        autocompleteSupportFragment.getView().setEnabled(false);
        autocompleteSupportFragment.startActivityForResult(build, 30421);
    }
}
