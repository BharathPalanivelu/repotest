package com.google.android.libraries.places.internal;

import android.content.Context;
import android.database.DataSetObserver;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import java.util.HashSet;
import java.util.Set;

public final class ex implements AdapterView.OnItemClickListener, Filterable, ListAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final PlacesClient f12528a;

    /* renamed from: b  reason: collision with root package name */
    public final fh f12529b;

    /* renamed from: c  reason: collision with root package name */
    public CancellationTokenSource f12530c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12531d;

    /* renamed from: e  reason: collision with root package name */
    public fe f12532e;

    /* renamed from: f  reason: collision with root package name */
    public PlaceSelectionListener f12533f;

    /* renamed from: g  reason: collision with root package name */
    public fy f12534g;
    public AutocompleteSessionToken h;
    private final Context i;
    private final Set<DataSetObserver> j = new HashSet();
    private final fa k = new fa(this);

    public ex(Context context, PlacesClient placesClient, fh fhVar) {
        this.i = context;
        this.f12528a = placesClient;
        this.f12529b = fhVar;
        if (fhVar.a().isEmpty()) {
            this.f12532e = fe.f12545f;
        } else {
            this.f12532e = fe.f12546g;
        }
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final int getCount() {
        int size;
        int i2 = this.f12532e.f12547a;
        if (i2 == 2) {
            size = this.f12532e.f12549c.size();
        } else if (i2 != 4) {
            return 1;
        } else {
            size = this.f12532e.f12549c.size();
        }
        return size + 1;
    }

    public final boolean isEmpty() {
        return getCount() == 0;
    }

    public final int getItemViewType(int i2) {
        int i3 = this.f12532e.f12547a;
        if ((i3 == 2 || i3 == 4) && i2 < this.f12532e.f12549c.size()) {
            return 1;
        }
        return 0;
    }

    public final boolean isEnabled(int i2) {
        return getItemViewType(i2) == 1;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i2);
        LayoutInflater from = LayoutInflater.from(this.i);
        if (itemViewType == 0) {
            if (view == null) {
                view = from.inflate(R.layout.places_autocomplete_item_powered_by_google, viewGroup, false);
            }
            a(view);
        } else if (itemViewType == 1) {
            if (view == null) {
                view = from.inflate(R.layout.places_autocomplete_item_prediction, viewGroup, false);
            }
            a(view, i2);
        } else if (Log.isLoggable("Places", 6)) {
            Log.e("Places", "Unknown view type.");
        }
        return view;
    }

    public final void a(View view) {
        int i2 = 4;
        boolean z = true;
        int i3 = 0;
        boolean z2 = (this.f12532e.f12547a == 2 && this.f12532e.f12549c.isEmpty()) || (this.f12532e.f12547a == 4 && this.f12532e.f12549c.isEmpty()) || this.f12532e.f12547a == 3 || this.f12532e.f12547a == 6 || this.f12532e.f12547a == 5;
        if (getCount() <= 1) {
            z = false;
        }
        View findViewById = view.findViewById(R.id.places_autocomplete_progress);
        if (z2) {
            i2 = 0;
        }
        findViewById.setVisibility(i2);
        View findViewById2 = view.findViewById(R.id.places_autocomplete_separator);
        if (!z) {
            i3 = 8;
        }
        findViewById2.setVisibility(i3);
    }

    public final void a(View view, int i2) {
        AutocompletePrediction autocompletePrediction = (AutocompletePrediction) getItem(i2);
        TextView textView = (TextView) view.findViewById(R.id.places_autocomplete_prediction_secondary_text);
        SpannableString primaryText = autocompletePrediction.getPrimaryText(new ForegroundColorSpan(view.getContext().getResources().getColor(R.color.places_autocomplete_prediction_primary_text_highlight)));
        SpannableString secondaryText = autocompletePrediction.getSecondaryText((CharacterStyle) null);
        ((TextView) view.findViewById(R.id.places_autocomplete_prediction_primary_text)).setText(primaryText);
        textView.setText(secondaryText);
        View findViewById = view.findViewById(R.id.places_autocomplete_separator);
        if (TextUtils.isEmpty(secondaryText)) {
            textView.setVisibility(8);
            findViewById.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        findViewById.setVisibility(0);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        if (!this.f12532e.a()) {
            a(i2, (AutocompletePrediction) getItem(i2));
        }
    }

    public final void a(int i2, AutocompletePrediction autocompletePrediction) {
        if (!a()) {
            this.f12530c = new CancellationTokenSource();
            a(new fe(5, (Status) null, this.f12532e.f12549c, i2, (Place) null));
            this.f12528a.fetchPlace(FetchPlaceRequest.builder(autocompletePrediction.getPlaceId(), this.f12529b.a()).setSessionToken(this.h).setCancellationToken(this.f12530c.getToken()).build()).addOnSuccessListener(new ey(this)).addOnFailureListener(new ez(this));
        }
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.j.add(dataSetObserver);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.j.remove(dataSetObserver);
    }

    public final Filter getFilter() {
        return this.k;
    }

    public final boolean a() {
        CancellationTokenSource cancellationTokenSource = this.f12530c;
        if (cancellationTokenSource != null) {
            cancellationTokenSource.cancel();
        }
        return this.f12531d;
    }

    public final void a(fe feVar) {
        if (this.f12532e != fe.f12545f) {
            this.f12532e = feVar;
            if (feVar.f12547a == 3 || feVar.f12547a == 6) {
                if (Log.isLoggable("Places", 6)) {
                    String valueOf = String.valueOf(feVar.f12548b != null ? PlacesStatusCodes.getStatusCodeString(feVar.f12548b.getStatusCode()) : "Unknown");
                    Log.e("Places", valueOf.length() != 0 ? "Error while autocompleting: ".concat(valueOf) : new String("Error while autocompleting: "));
                }
                if (feVar.f12548b != null) {
                    int statusCode = feVar.f12548b.getStatusCode();
                    if (statusCode == 9011 || statusCode == 9012) {
                        PlaceSelectionListener placeSelectionListener = this.f12533f;
                        if (placeSelectionListener != null) {
                            placeSelectionListener.onError(feVar.f12548b);
                        }
                    }
                }
            }
            for (DataSetObserver next : this.j) {
                if (!this.f12532e.f12549c.isEmpty()) {
                    next.onChanged();
                } else {
                    next.onInvalidated();
                }
            }
            fy fyVar = this.f12534g;
            if (fyVar != null) {
                fyVar.a(this.f12532e);
            }
        }
    }

    static Status a(Exception exc) {
        if (!(exc instanceof ApiException)) {
            return new Status(13, exc.getMessage());
        }
        ApiException apiException = (ApiException) exc;
        return new Status(apiException.getStatusCode(), apiException.getStatusMessage());
    }

    public final /* synthetic */ Object getItem(int i2) {
        int i3 = this.f12532e.f12547a;
        if ((i3 == 2 || i3 == 4) && i2 < this.f12532e.f12549c.size()) {
            return this.f12532e.f12549c.get(i2);
        }
        return null;
    }
}
