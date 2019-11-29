package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory {
    private static ICameraUpdateFactoryDelegate zzf;

    private CameraUpdateFactory() {
    }

    private static ICameraUpdateFactoryDelegate zzc() {
        return (ICameraUpdateFactoryDelegate) Preconditions.checkNotNull(zzf, "CameraUpdateFactory is not initialized");
    }

    public static void zza(ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate) {
        zzf = (ICameraUpdateFactoryDelegate) Preconditions.checkNotNull(iCameraUpdateFactoryDelegate);
    }

    public static CameraUpdate zoomIn() {
        try {
            return new CameraUpdate(zzc().zoomIn());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate zoomOut() {
        try {
            return new CameraUpdate(zzc().zoomOut());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate scrollBy(float f2, float f3) {
        try {
            return new CameraUpdate(zzc().scrollBy(f2, f3));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate zoomTo(float f2) {
        try {
            return new CameraUpdate(zzc().zoomTo(f2));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate zoomBy(float f2) {
        try {
            return new CameraUpdate(zzc().zoomBy(f2));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate zoomBy(float f2, Point point) {
        try {
            return new CameraUpdate(zzc().zoomByWithFocus(f2, point.x, point.y));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        try {
            return new CameraUpdate(zzc().newCameraPosition(cameraPosition));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        try {
            return new CameraUpdate(zzc().newLatLng(latLng));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f2) {
        try {
            return new CameraUpdate(zzc().newLatLngZoom(latLng, f2));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        try {
            return new CameraUpdate(zzc().newLatLngBounds(latLngBounds, i));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        try {
            return new CameraUpdate(zzc().newLatLngBoundsWithSize(latLngBounds, i, i2, i3));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
