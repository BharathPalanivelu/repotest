package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

public final class zzq extends GmsClient<zzt> {
    private final zzau zzbt;

    private zzq(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 65, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzbt = new zzau(str, Locale.getDefault(), clientSettings.getAccount() != null ? clientSettings.getAccount().name : null, (String) null, 0);
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    public final void zzb(zzm zzm, String str, LatLngBounds latLngBounds, int i, AutocompleteFilter autocompleteFilter) throws RemoteException {
        Preconditions.checkNotNull(zzm, "callback == null");
        if (str == null) {
            str = "";
        }
        String str2 = str;
        if (autocompleteFilter == null) {
            autocompleteFilter = new AutocompleteFilter.Builder().build();
        }
        ((zzt) getService()).zzb(str2, latLngBounds, i, autocompleteFilter, this.zzbt, (zzx) zzm);
    }

    public final void zzb(zzm zzm, List<String> list) throws RemoteException {
        Preconditions.checkNotNull(zzm, "callback == null");
        ((zzt) getService()).zzb(list, this.zzbt, (zzx) zzm);
    }

    public final void zzb(zzm zzm, AddPlaceRequest addPlaceRequest) throws RemoteException {
        Preconditions.checkNotNull(zzm, "callback == null");
        ((zzt) getService()).zzb(addPlaceRequest, this.zzbt, (zzx) zzm);
    }

    public final void zzb(zzf zzf, String str) throws RemoteException {
        Preconditions.checkNotNull(zzf, "callback cannot be null");
        ((zzt) getService()).zzb(str, this.zzbt, (zzv) zzf);
    }

    public final void zzb(zzf zzf, String str, int i, int i2, int i3) throws RemoteException {
        Preconditions.checkNotNull(zzf, "callback cannot be null");
        ((zzt) getService()).zzb(str, i, i2, i3, this.zzbt, (zzv) zzf);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (queryLocalInterface instanceof zzt) {
            return (zzt) queryLocalInterface;
        }
        return new zzw(iBinder);
    }
}
