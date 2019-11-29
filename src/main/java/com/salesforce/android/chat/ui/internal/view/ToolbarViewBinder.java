package com.salesforce.android.chat.ui.internal.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

public interface ToolbarViewBinder {
    boolean onCreateOptionsMenu(Menu menu, MenuInflater menuInflater);

    boolean onOptionsItemSelected(MenuItem menuItem);

    void onToolbarInflated(Toolbar toolbar);
}
