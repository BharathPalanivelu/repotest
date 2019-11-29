package com.salesforce.android.service.common.ui.internal.android;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.w;

public interface RecyclerViewAdapter<VH extends RecyclerView.w> {
    int getItemCount();

    long getItemId(int i);

    int getItemViewType(int i);

    void onAttachedToRecyclerView(RecyclerView recyclerView);

    void onBindViewHolder(VH vh, int i);

    VH onCreateViewHolder(ViewGroup viewGroup, int i);

    void onDetachedFromRecyclerView(RecyclerView recyclerView);
}
