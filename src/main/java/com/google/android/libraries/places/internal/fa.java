package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.widget.Filter;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;

public final class fa extends Filter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ex f12539a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f12540b;

    public fa(ex exVar) {
        this.f12539a = exVar;
    }

    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        this.f12540b = null;
        if (TextUtils.isEmpty(charSequence)) {
            return a(fe.f12546g);
        }
        this.f12540b = new fb(this, charSequence);
        return a(new fe(2, (Status) null, this.f12539a.f12532e.f12549c, -1, (Place) null));
    }

    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        this.f12539a.a((fe) filterResults.values);
        Runnable runnable = this.f12540b;
        if (runnable != null) {
            runnable.run();
            this.f12540b = null;
        }
    }

    public final CharSequence convertResultToString(Object obj) {
        if (!(obj instanceof AutocompletePrediction)) {
            return super.convertResultToString(obj);
        }
        return ((AutocompletePrediction) obj).getPrimaryText((CharacterStyle) null);
    }

    private static Filter.FilterResults a(fe feVar) {
        Filter.FilterResults filterResults = new Filter.FilterResults();
        filterResults.values = feVar;
        filterResults.count = feVar.f12549c.size();
        return filterResults;
    }
}
