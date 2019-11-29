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
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.zzm;
import java.util.Locale;

public final class zzae extends GmsClient<zzr> {
    private final Locale locale;
    private final zzau zzbt;

    private zzae(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 67, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.locale = Locale.getDefault();
        this.zzbt = new zzau(str, this.locale, clientSettings.getAccount() != null ? clientSettings.getAccount().name : null, (String) null, 0);
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    public final void zzb(zzm zzm, PlaceFilter placeFilter) throws RemoteException {
        Preconditions.checkNotNull(zzm, "callback == null");
        if (placeFilter == null) {
            placeFilter = PlaceFilter.zzc();
        }
        ((zzr) getService()).zzb(placeFilter, this.zzbt, (zzx) zzm);
    }

    public final void zzb(zzm zzm, PlaceReport placeReport) throws RemoteException {
        Preconditions.checkNotNull(zzm, "callback == null");
        ((zzr) getService()).zzb(placeReport, this.zzbt, (zzx) zzm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
        if (queryLocalInterface instanceof zzr) {
            return (zzr) queryLocalInterface;
        }
        return new zzu(iBinder);
    }
}
