package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import java.util.concurrent.atomic.AtomicLong;

public final class u implements PlacesClient {

    /* renamed from: a  reason: collision with root package name */
    public final fw f13066a;

    /* renamed from: b  reason: collision with root package name */
    public final j f13067b;

    /* renamed from: c  reason: collision with root package name */
    public final ds f13068c;

    /* renamed from: d  reason: collision with root package name */
    public final a f13069d;

    /* renamed from: e  reason: collision with root package name */
    private final d f13070e;

    public u(fw fwVar, d dVar, j jVar, ds dsVar, a aVar) {
        this.f13066a = fwVar;
        this.f13070e = dVar;
        this.f13067b = jVar;
        this.f13068c = dsVar;
        this.f13069d = aVar;
    }

    public final Task<FindAutocompletePredictionsResponse> findAutocompletePredictions(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest) {
        try {
            go.a(findAutocompletePredictionsRequest, (Object) "Request must not be null.");
            return this.f13066a.a(findAutocompletePredictionsRequest).continueWithTask(new v(this, findAutocompletePredictionsRequest, this.f13069d.a())).continueWithTask(new w(this));
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final Task<FetchPhotoResponse> fetchPhoto(FetchPhotoRequest fetchPhotoRequest) {
        try {
            go.a(fetchPhotoRequest, (Object) "Request must not be null.");
            return this.f13066a.a(fetchPhotoRequest).continueWithTask(new x(this, fetchPhotoRequest, this.f13069d.a())).continueWithTask(new y(this));
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final Task<FetchPlaceResponse> fetchPlace(FetchPlaceRequest fetchPlaceRequest) {
        try {
            go.a(fetchPlaceRequest, (Object) "Request must not be null.");
            return this.f13066a.a(fetchPlaceRequest).continueWithTask(new z(this, fetchPlaceRequest, this.f13069d.a())).continueWithTask(new aa(this));
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final Task<FindCurrentPlaceResponse> findCurrentPlace(FindCurrentPlaceRequest findCurrentPlaceRequest) {
        try {
            go.a(findCurrentPlaceRequest, (Object) "Request must not be null.");
            long a2 = this.f13069d.a();
            AtomicLong atomicLong = new AtomicLong(-1);
            d dVar = this.f13070e;
            CancellationToken cancellationToken = findCurrentPlaceRequest.getCancellationToken();
            return dVar.f12431e.a(dVar.f12430d.getLastLocation(), cancellationToken, d.f12427a, "Location timeout.").continueWithTask(new e(dVar, cancellationToken)).onSuccessTask(new ab(this, atomicLong, findCurrentPlaceRequest)).continueWithTask(new ac(this, findCurrentPlaceRequest, a2, atomicLong)).continueWithTask(new ad(this));
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    static <ResponseT extends az> Task<ResponseT> a(Task<ResponseT> task) {
        Exception exception = task.getException();
        return exception != null ? Tasks.forException(k.a(exception)) : task;
    }
}
