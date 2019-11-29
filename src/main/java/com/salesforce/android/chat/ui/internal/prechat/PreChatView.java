package com.salesforce.android.chat.ui.internal.prechat;

import androidx.appcompat.widget.Toolbar;
import com.salesforce.android.chat.ui.internal.view.ViewBinder;
import com.salesforce.android.service.common.utilities.control.Async;

public interface PreChatView extends ViewBinder {
    void onPreChatComplete(Async.CompletionHandler completionHandler);

    void onSatisfiedUpdated(Boolean bool);

    void onToolbarInflated(Toolbar toolbar);
}
