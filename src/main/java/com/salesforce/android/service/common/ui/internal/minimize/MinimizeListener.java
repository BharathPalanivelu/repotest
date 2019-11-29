package com.salesforce.android.service.common.ui.internal.minimize;

import android.content.Context;
import android.view.ViewGroup;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;

public interface MinimizeListener {
    void onCloseClicked();

    void onCreate(ViewGroup viewGroup, Context context);

    void onDropped(Coordinate coordinate);

    void onMaximize(Context context);

    void onMinimize();
}
