package com.devfd.RNGeocoder;

import android.location.Address;
import android.location.Geocoder;
import com.facebook.appevents.UserDataStore;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ViewProps;
import java.io.IOException;
import java.util.List;

@ReactModule(name = "RNGeocoder")
public class RNGeocoderModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "RNGeocoder";
    private Geocoder geocoder;

    public String getName() {
        return NAME;
    }

    public RNGeocoderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.geocoder = new Geocoder(reactApplicationContext.getApplicationContext());
    }

    @ReactMethod
    public void geocodeAddress(String str, Promise promise) {
        Geocoder geocoder2 = this.geocoder;
        if (!Geocoder.isPresent()) {
            promise.reject("NOT_AVAILABLE", "Geocoder not available for this platform");
            return;
        }
        try {
            promise.resolve(transform(this.geocoder.getFromLocationName(str, 20)));
        } catch (IOException e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void geocodePosition(ReadableMap readableMap, Promise promise) {
        Geocoder geocoder2 = this.geocoder;
        if (!Geocoder.isPresent()) {
            promise.reject("NOT_AVAILABLE", "Geocoder not available for this platform");
            return;
        }
        try {
            promise.resolve(transform(this.geocoder.getFromLocation(readableMap.getDouble("lat"), readableMap.getDouble("lng"), 20)));
        } catch (IOException e2) {
            promise.reject((Throwable) e2);
        }
    }

    /* access modifiers changed from: package-private */
    public WritableArray transform(List<Address> list) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (Address next : list) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            writableNativeMap2.putDouble("lat", next.getLatitude());
            writableNativeMap2.putDouble("lng", next.getLongitude());
            writableNativeMap.putMap(ViewProps.POSITION, writableNativeMap2);
            String featureName = next.getFeatureName();
            if (featureName == null || featureName.equals(next.getSubThoroughfare()) || featureName.equals(next.getThoroughfare()) || featureName.equals(next.getLocality())) {
                writableNativeMap.putString("feature", (String) null);
            } else {
                writableNativeMap.putString("feature", featureName);
            }
            writableNativeMap.putString("locality", next.getLocality());
            writableNativeMap.putString("adminArea", next.getAdminArea());
            writableNativeMap.putString(UserDataStore.COUNTRY, next.getCountryName());
            writableNativeMap.putString("countryCode", next.getCountryCode());
            writableNativeMap.putString("locale", next.getLocale().toString());
            writableNativeMap.putString("postalCode", next.getPostalCode());
            writableNativeMap.putString("subAdminArea", next.getSubAdminArea());
            writableNativeMap.putString("subLocality", next.getSubLocality());
            writableNativeMap.putString("streetNumber", next.getSubThoroughfare());
            writableNativeMap.putString("streetName", next.getThoroughfare());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= next.getMaxAddressLineIndex(); i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(next.getAddressLine(i));
            }
            writableNativeMap.putString("formattedAddress", sb.toString());
            writableNativeArray.pushMap(writableNativeMap);
        }
        return writableNativeArray;
    }
}
