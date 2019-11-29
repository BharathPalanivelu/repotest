package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceEntity;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class zzar extends zzaw implements Place {
    private final String placeId = zzb("place_id", "");
    private final zzai zzcf;

    public zzar(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        zzai zzai;
        String str = null;
        if (getPlaceTypes().size() > 0 || (getPhoneNumber() != null && getPhoneNumber().length() > 0) || ((getWebsiteUri() != null && !getWebsiteUri().equals(Uri.EMPTY)) || getRating() >= BitmapDescriptorFactory.HUE_RED || getPriceLevel() >= 0)) {
            zzai = new zzai(getPlaceTypes(), getPhoneNumber() != null ? getPhoneNumber().toString() : str, getWebsiteUri(), getRating(), getPriceLevel());
        } else {
            zzai = null;
        }
        this.zzcf = zzai;
    }

    public final CharSequence getAddress() {
        return zzb("place_address", "");
    }

    public final String getId() {
        return this.placeId;
    }

    public final LatLng getLatLng() {
        return (LatLng) zzb("place_lat_lng", LatLng.CREATOR);
    }

    public final Locale getLocale() {
        String zzb = zzb("place_locale_language", "");
        if (!TextUtils.isEmpty(zzb)) {
            return new Locale(zzb, zzb("place_locale_country", ""));
        }
        String zzb2 = zzb("place_locale", "");
        if (!TextUtils.isEmpty(zzb2)) {
            return new Locale(zzb2);
        }
        return Locale.getDefault();
    }

    public final CharSequence getName() {
        return zzb("place_name", "");
    }

    public final CharSequence getPhoneNumber() {
        return zzb("place_phone_number", "");
    }

    public final List<Integer> getPlaceTypes() {
        return zzb("place_types", (List<Integer>) Collections.emptyList());
    }

    public final int getPriceLevel() {
        return zzc("place_price_level", -1);
    }

    public final float getRating() {
        return zzb("place_rating", -1.0f);
    }

    public final LatLngBounds getViewport() {
        return (LatLngBounds) zzb("place_viewport", LatLngBounds.CREATOR);
    }

    public final Uri getWebsiteUri() {
        String zzb = zzb("place_website_uri", (String) null);
        if (zzb == null) {
            return null;
        }
        return Uri.parse(zzb);
    }

    private final List<String> zzl() {
        return zzc("place_attributions", (List<String>) Collections.emptyList());
    }

    public final CharSequence getAttributions() {
        return zzi.zzc(zzl());
    }

    public final /* synthetic */ Object freeze() {
        PlaceEntity zzj = new PlaceEntity.zzb().zzd(getAddress().toString()).zzd(zzl()).zzb(getId()).zzb((!hasColumn("place_is_permanently_closed") || hasNull("place_is_permanently_closed")) ? false : getBoolean("place_is_permanently_closed")).zzb(getLatLng()).zzb(zzb("place_level_number", (float) BitmapDescriptorFactory.HUE_RED)).zzc(getName().toString()).zze(getPhoneNumber().toString()).zzc(getPriceLevel()).zzc(getRating()).zzc(getPlaceTypes()).zzb(getViewport()).zzb(getWebsiteUri()).zzb((zzal) zzb("place_opening_hours", zzal.CREATOR)).zzb(this.zzcf).zzf(zzb("place_adr_address", "")).zzj();
        zzj.setLocale(getLocale());
        return zzj;
    }
}
