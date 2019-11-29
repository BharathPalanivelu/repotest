package com.google.android.libraries.places.internal;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import java.util.HashMap;
import java.util.Map;

public final class fj extends RecyclerView.a<RecyclerView.w> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    public final ex f12555a;

    /* renamed from: b  reason: collision with root package name */
    public int f12556b;

    /* renamed from: c  reason: collision with root package name */
    public int f12557c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<RecyclerView.c, DataSetObserver> f12558d = new HashMap();

    public fj(ex exVar) {
        this.f12555a = exVar;
        setHasStableIds(true);
        this.f12555a.registerDataSetObserver(new fk(this));
    }

    public final RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        try {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            if (i == 0) {
                return new fp(from.inflate(R.layout.places_autocomplete_item_powered_by_google, viewGroup, false));
            }
            if (i == 1) {
                return new fq(from.inflate(R.layout.places_autocomplete_item_prediction, viewGroup, false));
            }
            throw new IllegalStateException();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final int getItemViewType(int i) {
        try {
            return this.f12555a.getItemViewType(i);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final void onBindViewHolder(RecyclerView.w wVar, int i) {
        try {
            int itemViewType = this.f12555a.getItemViewType(i);
            if (itemViewType != 0) {
                boolean z = true;
                if (itemViewType == 1) {
                    if (this.f12556b != 0 || this.f12557c <= 0) {
                        z = false;
                    }
                    fq fqVar = (fq) wVar;
                    ex exVar = this.f12555a;
                    fqVar.f12570a = i;
                    fqVar.f12571b = z;
                    exVar.a(fqVar.itemView, i);
                    fqVar.itemView.setOnClickListener(new fr(fqVar, exVar, i));
                    return;
                }
                return;
            }
            this.f12555a.a(((fp) wVar).itemView);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final void registerAdapterDataObserver(RecyclerView.c cVar) {
        try {
            super.registerAdapterDataObserver(cVar);
            fl flVar = new fl(cVar);
            this.f12555a.registerDataSetObserver(flVar);
            this.f12558d.put(cVar, flVar);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final void unregisterAdapterDataObserver(RecyclerView.c cVar) {
        try {
            super.unregisterAdapterDataObserver(cVar);
            if (this.f12558d.containsKey(cVar)) {
                this.f12555a.unregisterDataSetObserver(this.f12558d.get(cVar));
                this.f12558d.remove(cVar);
            }
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final int getItemCount() {
        try {
            return this.f12555a.getCount();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final long getItemId(int i) {
        try {
            if (this.f12555a.getItemViewType(i) != 1) {
                return -1;
            }
            return (long) ((AutocompletePrediction) this.f12555a.getItem(i)).getPlaceId().hashCode();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    /* renamed from: a */
    public final fa getFilter() {
        try {
            return (fa) this.f12555a.getFilter();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final fe b() {
        return this.f12555a.f12532e;
    }
}
