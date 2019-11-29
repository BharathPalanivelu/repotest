package com.salesforce.android.service.common.ui.internal.android;

import android.content.Context;
import android.view.LayoutInflater;

public class LayoutInflaterFactory {
    public LayoutInflater createFrom(Context context) {
        return LayoutInflater.from(context);
    }
}
