package com.salesforce.android.chat.ui.internal.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public interface ViewBinder {
    boolean onBackPressed();

    void onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    void onDestroyView();

    void onRestoreInstanceState(Bundle bundle);

    void onSaveInstanceState(Bundle bundle);
}
