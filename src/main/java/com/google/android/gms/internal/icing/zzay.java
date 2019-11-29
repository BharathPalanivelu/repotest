package com.google.android.gms.internal.icing;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuthApi;

final class zzay implements SearchAuthApi.GoogleNowAuthResult {
    private final GoogleNowAuthState zzce;
    private final Status zzv;

    zzay(Status status, GoogleNowAuthState googleNowAuthState) {
        this.zzv = status;
        this.zzce = googleNowAuthState;
    }

    public final Status getStatus() {
        return this.zzv;
    }

    public final GoogleNowAuthState getGoogleNowAuthState() {
        return this.zzce;
    }
}
