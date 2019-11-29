package com.salesforce.android.service.common.utilities.activity;

import android.app.Activity;
import com.salesforce.android.service.common.utilities.functional.OptionalReference;

public class ActivityReference<T extends Activity> extends OptionalReference<T> {
    private static final ActivityReference<?> NONE = new ActivityReference<>((Activity) null);

    protected ActivityReference(T t) {
        super(t);
    }

    public static <T extends Activity> ActivityReference<T> create(T t) {
        return new ActivityReference<>(t);
    }

    public static <T extends Activity> ActivityReference<T> none() {
        return NONE;
    }
}
