package com.salesforce.android.service.common.ui.internal.messaging;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public interface ViewHolderFactory {
    int getItemViewType(Object obj);

    void onBindViewHolder(RecyclerView.w wVar, int i, Object obj);

    RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i, LayoutInflater layoutInflater);
}
