package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.tasks.TaskCompletionSource;

final class h extends LocationCallback {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f12640a;

    h(TaskCompletionSource taskCompletionSource) {
        this.f12640a = taskCompletionSource;
    }

    public final void onLocationResult(LocationResult locationResult) {
        try {
            super.onLocationResult(locationResult);
            this.f12640a.trySetResult(locationResult.getLastLocation());
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final void onLocationAvailability(LocationAvailability locationAvailability) {
        try {
            super.onLocationAvailability(locationAvailability);
            if (!locationAvailability.isLocationAvailable()) {
                this.f12640a.trySetException(new ApiException(new Status(8, "Location unavailable.")));
            }
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }
}
