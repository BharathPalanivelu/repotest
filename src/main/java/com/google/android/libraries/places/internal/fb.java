package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;

final /* synthetic */ class fb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final fa f12541a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f12542b;

    fb(fa faVar, CharSequence charSequence) {
        this.f12541a = faVar;
        this.f12542b = charSequence;
    }

    public final void run() {
        fa faVar = this.f12541a;
        CharSequence charSequence = this.f12542b;
        try {
            if (!faVar.f12539a.a()) {
                faVar.f12539a.f12530c = new CancellationTokenSource();
                faVar.f12539a.f12528a.findAutocompletePredictions(FindAutocompletePredictionsRequest.builder().setQuery(charSequence.toString()).setLocationBias(faVar.f12539a.f12529b.b()).setLocationRestriction(faVar.f12539a.f12529b.c()).setCountry(faVar.f12539a.f12529b.d()).setTypeFilter(faVar.f12539a.f12529b.e()).setSessionToken(faVar.f12539a.h).setCancellationToken(faVar.f12539a.f12530c.getToken()).build()).addOnSuccessListener(new fc(faVar)).addOnFailureListener(new fd(faVar));
            }
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }
}
