package com.google.firebase;

import com.google.android.gms.common.internal.Preconditions;

public class c extends Exception {
    public c(String str) {
        super(Preconditions.checkNotEmpty(str, "Detail message must not be empty"));
    }

    public c(String str, Throwable th) {
        super(Preconditions.checkNotEmpty(str, "Detail message must not be empty"), th);
    }
}
