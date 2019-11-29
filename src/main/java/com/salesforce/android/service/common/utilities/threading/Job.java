package com.salesforce.android.service.common.utilities.threading;

import com.salesforce.android.service.common.utilities.control.ResultReceiver;

public interface Job<T> {
    void execute(ResultReceiver<T> resultReceiver);
}
