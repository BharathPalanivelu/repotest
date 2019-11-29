package com.google.android.libraries.places.internal;

import android.content.Context;
import android.location.Location;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.android.b.a.l;
import com.android.b.m;
import com.c.a.c;
import com.c.a.j;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.internal.impl.net.pablo.FetchPlacePabloResponse;
import com.google.android.libraries.places.api.internal.impl.net.pablo.FindAutocompletePredictionsPabloResponse;
import com.google.android.libraries.places.api.internal.impl.net.pablo.FindCurrentPlacePabloResponse;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;

public class fw implements ny {

    /* renamed from: a  reason: collision with root package name */
    public final ax f12589a;

    /* renamed from: b  reason: collision with root package name */
    public final fg f12590b;

    /* renamed from: c  reason: collision with root package name */
    public final gg f12591c;

    /* renamed from: d  reason: collision with root package name */
    public final dq f12592d;

    public static void a(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static m a(Context context) {
        return l.a(context);
    }

    public static j b(Context context) {
        return c.b(context);
    }

    public static j a(WifiManager wifiManager, a aVar) {
        return new j(wifiManager, aVar);
    }

    public /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public Task<FindAutocompletePredictionsResponse> a(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest) {
        if (TextUtils.isEmpty(findAutocompletePredictionsRequest.getQuery())) {
            return Tasks.forResult(FindAutocompletePredictionsResponse.newInstance(ha.g()));
        }
        return this.f12591c.a((r<Object, ? extends ay>) new ah(findAutocompletePredictionsRequest, this.f12589a.c(), this.f12589a.b(), this.f12589a.d(), this.f12590b), FindAutocompletePredictionsPabloResponse.class).continueWith(ak.f12337a);
    }

    public Task<FetchPhotoResponse> a(FetchPhotoRequest fetchPhotoRequest) {
        Integer maxWidth = fetchPhotoRequest.getMaxWidth();
        Integer maxHeight = fetchPhotoRequest.getMaxHeight();
        if (maxWidth == null && maxHeight == null) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Must include max width or max height in request.")));
        }
        if (maxWidth != null && maxWidth.intValue() <= 0) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, String.format("Max Width must not be < 1, but was: %d.", new Object[]{maxWidth}))));
        } else if (maxHeight == null || maxHeight.intValue() > 0) {
            return this.f12592d.a((r<Object, ?>) new ae(fetchPhotoRequest, this.f12589a.b(), this.f12589a.d(), this.f12590b), new dv()).continueWith(al.f12338a);
        } else {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, String.format("Max Height must not be < 1, but was: %d.", new Object[]{maxHeight}))));
        }
    }

    public Task<FetchPlaceResponse> a(FetchPlaceRequest fetchPlaceRequest) {
        if (TextUtils.isEmpty(fetchPlaceRequest.getPlaceId())) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place ID must not be empty.")));
        }
        if (fetchPlaceRequest.getPlaceFields().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place Fields must not be empty.")));
        }
        return this.f12591c.a((r<Object, ? extends ay>) new ag(fetchPlaceRequest, this.f12589a.c(), this.f12589a.b(), this.f12589a.d(), this.f12590b), FetchPlacePabloResponse.class).continueWith(am.f12339a);
    }

    public Task<FindCurrentPlaceResponse> a(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location, ha<fu> haVar) {
        if (findCurrentPlaceRequest.getPlaceFields().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place Fields must not be empty.")));
        }
        return this.f12591c.a((r<Object, ? extends ay>) new ai(findCurrentPlaceRequest, location, haVar, this.f12589a.c(), this.f12589a.b(), this.f12589a.d(), this.f12590b), FindCurrentPlacePabloResponse.class).continueWith(an.f12340a);
    }

    public fw(ax axVar, fg fgVar, gg ggVar, dq dqVar) {
        this.f12589a = axVar;
        this.f12590b = fgVar;
        this.f12591c = ggVar;
        this.f12592d = dqVar;
    }

    public static /* synthetic */ FindCurrentPlaceResponse a(Task task) throws Exception {
        return (FindCurrentPlaceResponse) ((FindCurrentPlacePabloResponse) task.getResult()).convert();
    }

    public static /* synthetic */ FetchPlaceResponse b(Task task) throws Exception {
        return (FetchPlaceResponse) ((FetchPlacePabloResponse) task.getResult()).convert();
    }

    public static /* synthetic */ FetchPhotoResponse c(Task task) throws Exception {
        return (FetchPhotoResponse) ((af) task.getResult()).convert();
    }

    public static /* synthetic */ FindAutocompletePredictionsResponse d(Task task) throws Exception {
        return (FindAutocompletePredictionsResponse) ((FindAutocompletePredictionsPabloResponse) task.getResult()).convert();
    }
}
