package com.salesforce.android.service.common.ui.internal.utils;

import android.view.View;
import android.view.ViewGroup;

public class ViewGroupHelper {
    private ViewGroupHelper() {
    }

    public static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }
}
