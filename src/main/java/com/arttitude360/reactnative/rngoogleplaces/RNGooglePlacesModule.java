package com.arttitude360.reactnative.rngoogleplaces;

import android.text.TextUtils;
import android.text.style.CharacterStyle;
import com.facebook.appevents.UserDataStore;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.maps.android.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ReactModule(name = "RNGooglePlaces")
public class RNGooglePlacesModule extends ReactContextBaseJavaModule {
    private static final List<Place.Field> PLACE_FIELDS = Arrays.asList(new Place.Field[]{Place.Field.ADDRESS, Place.Field.ID, Place.Field.LAT_LNG, Place.Field.NAME, Place.Field.OPENING_HOURS, Place.Field.PHOTO_METADATAS, Place.Field.PLUS_CODE, Place.Field.TYPES, Place.Field.VIEWPORT});
    public static String REACT_CLASS = "RNGooglePlaces";
    private Promise pendingPromise;
    private PlacesClient placesClient;
    private ReactApplicationContext reactContext;
    /* access modifiers changed from: private */
    public AutocompleteSessionToken token = null;

    @ReactMethod
    public void getCurrentPlace(Promise promise) {
    }

    @ReactMethod
    public void lookUpPlacesByIDs(ReadableArray readableArray, Promise promise) {
    }

    @ReactMethod
    public void openAutocompleteModal(ReadableMap readableMap, Promise promise) {
    }

    @ReactMethod
    public void openPlacePickerModal(ReadableMap readableMap, Promise promise) {
    }

    public RNGooglePlacesModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        if (!Places.isInitialized()) {
            Places.initialize(reactApplicationContext.getApplicationContext(), "AIzaSyBUE9EvumcGUCzDcyEXY_RFH8bBmTcrzI0");
        }
        this.placesClient = Places.createClient(reactApplicationContext.getApplicationContext());
        this.reactContext = reactApplicationContext;
        this.reactContext.addLifecycleEventListener(new LifecycleEventListener() {
            public void onHostPause() {
            }

            public void onHostResume() {
            }

            public void onHostDestroy() {
                AutocompleteSessionToken unused = RNGooglePlacesModule.this.token = null;
            }
        });
    }

    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void getAutocompletePredictions(String str, ReadableMap readableMap, final Promise promise) {
        String string = readableMap.getString("type");
        String string2 = readableMap.getString(UserDataStore.COUNTRY);
        RectangularBounds rectangularBounds = null;
        if (string2.isEmpty()) {
            string2 = null;
        }
        double d2 = readableMap.getDouble("latitude");
        double d3 = readableMap.getDouble("longitude");
        double d4 = readableMap.getDouble("radius");
        LatLng latLng = new LatLng(d2, d3);
        if (!(d2 == 0.0d || d3 == 0.0d || d4 == 0.0d)) {
            rectangularBounds = getLatLngBounds(latLng, d4);
        }
        if (this.token == null) {
            this.token = AutocompleteSessionToken.newInstance();
        }
        Task<FindAutocompletePredictionsResponse> findAutocompletePredictions = this.placesClient.findAutocompletePredictions(FindAutocompletePredictionsRequest.builder().setQuery(str).setLocationBias(rectangularBounds).setCountry(string2).setTypeFilter(getTypeFilter(string)).setSessionToken(this.token).build());
        findAutocompletePredictions.addOnSuccessListener(new OnSuccessListener<FindAutocompletePredictionsResponse>() {
            /* renamed from: a */
            public void onSuccess(FindAutocompletePredictionsResponse findAutocompletePredictionsResponse) {
                WritableArray createArray = Arguments.createArray();
                for (AutocompletePrediction next : findAutocompletePredictionsResponse.getAutocompletePredictions()) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("fullText", next.getFullText((CharacterStyle) null).toString());
                    createMap.putString("primaryText", next.getPrimaryText((CharacterStyle) null).toString());
                    createMap.putString("secondaryText", next.getSecondaryText((CharacterStyle) null).toString());
                    createMap.putString("placeID", next.getPlaceId());
                    ArrayList arrayList = new ArrayList();
                    for (Place.Type a2 : next.getPlaceTypes()) {
                        arrayList.add(b.a(a2));
                    }
                    createMap.putArray("types", Arguments.fromArray(arrayList.toArray(new String[0])));
                    createArray.pushMap(createMap);
                }
                promise.resolve(createArray);
            }
        });
        findAutocompletePredictions.addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception exc) {
                Promise promise = promise;
                promise.reject("E_PLACE_DETAILS_ERROR", (Throwable) new Error("Error making place lookup API call: " + exc));
            }
        });
    }

    @ReactMethod
    public void lookUpPlaceByID(String str, final Promise promise) {
        Task<FetchPlaceResponse> fetchPlace = this.placesClient.fetchPlace(FetchPlaceRequest.builder(str, PLACE_FIELDS).setSessionToken(this.token).build());
        fetchPlace.addOnSuccessListener(new OnSuccessListener<FetchPlaceResponse>() {
            /* renamed from: a */
            public void onSuccess(FetchPlaceResponse fetchPlaceResponse) {
                promise.resolve(RNGooglePlacesModule.this.propertiesMapForPlace(fetchPlaceResponse.getPlace()));
            }
        });
        fetchPlace.addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception exc) {
                Promise promise = promise;
                promise.reject("E_PLACE_DETAILS_ERROR", (Throwable) new Error("Error making place lookup API call: " + exc));
            }
        });
        this.token = null;
    }

    /* access modifiers changed from: private */
    public WritableMap propertiesMapForPlace(Place place) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("latitude", place.getLatLng().latitude);
        createMap.putDouble("longitude", place.getLatLng().longitude);
        createMap.putString("name", place.getName());
        if (!TextUtils.isEmpty(place.getAddress())) {
            createMap.putString("address", place.getAddress());
        }
        createMap.putString("placeID", place.getId());
        if (place.getAttributions() != null) {
            createMap.putString("attributions", TextUtils.join("\n", place.getAttributions()));
        }
        if (place.getTypes() != null) {
            ArrayList arrayList = new ArrayList();
            for (Place.Type a2 : place.getTypes()) {
                arrayList.add(b.a(a2));
            }
            createMap.putArray("types", Arguments.fromArray(arrayList.toArray(new String[0])));
        } else {
            createMap.putArray("types", Arguments.createArray());
        }
        if (place.getViewport() != null) {
            createMap.putDouble("north", place.getViewport().northeast.latitude);
            createMap.putDouble("east", place.getViewport().northeast.longitude);
            createMap.putDouble("south", place.getViewport().southwest.latitude);
            createMap.putDouble("west", place.getViewport().southwest.longitude);
        }
        return createMap;
    }

    private TypeFilter getTypeFilter(String str) {
        if (str == null) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1480760809:
                if (str.equals("establishment")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1360151735:
                if (str.equals("cities")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1147692044:
                if (str.equals("address")) {
                    c2 = 1;
                    break;
                }
                break;
            case -79287106:
                if (str.equals("geocode")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1086109695:
                if (str.equals("regions")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            return TypeFilter.GEOCODE;
        }
        if (c2 == 1) {
            return TypeFilter.ADDRESS;
        }
        if (c2 == 2) {
            return TypeFilter.ESTABLISHMENT;
        }
        if (c2 == 3) {
            return TypeFilter.REGIONS;
        }
        if (c2 != 4) {
            return null;
        }
        return TypeFilter.CITIES;
    }

    private void rejectPromise(String str, Error error) {
        Promise promise = this.pendingPromise;
        if (promise != null) {
            promise.reject(str, (Throwable) error);
            this.pendingPromise = null;
        }
    }

    private void resolvePromise(Object obj) {
        Promise promise = this.pendingPromise;
        if (promise != null) {
            promise.resolve(obj);
            this.pendingPromise = null;
        }
    }

    private RectangularBounds getLatLngBounds(LatLng latLng, double d2) {
        return RectangularBounds.newInstance(b.a(latLng, Math.sqrt(2.0d) * d2, 225.0d), b.a(latLng, d2 * Math.sqrt(2.0d), 45.0d));
    }
}
