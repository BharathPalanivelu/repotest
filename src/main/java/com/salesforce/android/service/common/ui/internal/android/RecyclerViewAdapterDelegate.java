package com.salesforce.android.service.common.ui.internal.android;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.w;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class RecyclerViewAdapterDelegate<VH extends RecyclerView.w> extends RecyclerView.a<VH> implements RecyclerViewAdapter<VH> {
    private RecyclerViewAdapter<VH> mRecyclerViewAdapter;

    public void wrap(RecyclerViewAdapter<VH> recyclerViewAdapter) {
        this.mRecyclerViewAdapter = recyclerViewAdapter;
    }

    public int getItemCount() {
        Arguments.checkNotNull(this.mRecyclerViewAdapter);
        return this.mRecyclerViewAdapter.getItemCount();
    }

    public long getItemId(int i) {
        Arguments.checkNotNull(this.mRecyclerViewAdapter);
        return this.mRecyclerViewAdapter.getItemId(i);
    }

    public int getItemViewType(int i) {
        Arguments.checkNotNull(this.mRecyclerViewAdapter);
        return this.mRecyclerViewAdapter.getItemViewType(i);
    }

    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        Arguments.checkNotNull(this.mRecyclerViewAdapter);
        return this.mRecyclerViewAdapter.onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(VH vh, int i) {
        Arguments.checkNotNull(this.mRecyclerViewAdapter);
        this.mRecyclerViewAdapter.onBindViewHolder(vh, i);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Arguments.checkNotNull(this.mRecyclerViewAdapter);
        this.mRecyclerViewAdapter.onAttachedToRecyclerView(recyclerView);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Arguments.checkNotNull(this.mRecyclerViewAdapter);
        this.mRecyclerViewAdapter.onDetachedFromRecyclerView(recyclerView);
    }
}
