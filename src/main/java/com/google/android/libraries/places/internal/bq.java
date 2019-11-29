package com.google.android.libraries.places.internal;

import android.net.Uri;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.AddressComponents;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlusCode;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import java.util.List;

abstract class bq extends Place {

    /* renamed from: a  reason: collision with root package name */
    private final String f12401a;

    /* renamed from: b  reason: collision with root package name */
    private final AddressComponents f12402b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f12403c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12404d;

    /* renamed from: e  reason: collision with root package name */
    private final LatLng f12405e;

    /* renamed from: f  reason: collision with root package name */
    private final String f12406f;

    /* renamed from: g  reason: collision with root package name */
    private final OpeningHours f12407g;
    private final String h;
    private final List<PhotoMetadata> i;
    private final PlusCode j;
    private final Integer k;
    private final Double l;
    private final List<Place.Type> m;
    private final Integer n;
    private final LatLngBounds o;
    private final Uri p;

    bq(String str, AddressComponents addressComponents, List<String> list, String str2, LatLng latLng, String str3, OpeningHours openingHours, String str4, List<PhotoMetadata> list2, PlusCode plusCode, Integer num, Double d2, List<Place.Type> list3, Integer num2, LatLngBounds latLngBounds, Uri uri) {
        this.f12401a = str;
        this.f12402b = addressComponents;
        this.f12403c = list;
        this.f12404d = str2;
        this.f12405e = latLng;
        this.f12406f = str3;
        this.f12407g = openingHours;
        this.h = str4;
        this.i = list2;
        this.j = plusCode;
        this.k = num;
        this.l = d2;
        this.m = list3;
        this.n = num2;
        this.o = latLngBounds;
        this.p = uri;
    }

    public String getAddress() {
        return this.f12401a;
    }

    public AddressComponents getAddressComponents() {
        return this.f12402b;
    }

    public List<String> getAttributions() {
        return this.f12403c;
    }

    public String getId() {
        return this.f12404d;
    }

    public LatLng getLatLng() {
        return this.f12405e;
    }

    public String getName() {
        return this.f12406f;
    }

    public OpeningHours getOpeningHours() {
        return this.f12407g;
    }

    public String getPhoneNumber() {
        return this.h;
    }

    public List<PhotoMetadata> getPhotoMetadatas() {
        return this.i;
    }

    public PlusCode getPlusCode() {
        return this.j;
    }

    public Integer getPriceLevel() {
        return this.k;
    }

    public Double getRating() {
        return this.l;
    }

    public List<Place.Type> getTypes() {
        return this.m;
    }

    public Integer getUserRatingsTotal() {
        return this.n;
    }

    public LatLngBounds getViewport() {
        return this.o;
    }

    public Uri getWebsiteUri() {
        return this.p;
    }

    public String toString() {
        String str = this.f12401a;
        String valueOf = String.valueOf(this.f12402b);
        String valueOf2 = String.valueOf(this.f12403c);
        String str2 = this.f12404d;
        String valueOf3 = String.valueOf(this.f12405e);
        String str3 = this.f12406f;
        String valueOf4 = String.valueOf(this.f12407g);
        String str4 = this.h;
        String valueOf5 = String.valueOf(this.i);
        String valueOf6 = String.valueOf(this.j);
        String valueOf7 = String.valueOf(this.k);
        String valueOf8 = String.valueOf(this.l);
        String valueOf9 = String.valueOf(this.m);
        String valueOf10 = String.valueOf(this.n);
        String valueOf11 = String.valueOf(this.o);
        String valueOf12 = String.valueOf(this.p);
        String str5 = valueOf12;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + DanmaKuEntity.MESSAGE_PUBLIC + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length() + String.valueOf(str2).length() + String.valueOf(valueOf3).length() + String.valueOf(str3).length() + String.valueOf(valueOf4).length() + String.valueOf(str4).length() + String.valueOf(valueOf5).length() + String.valueOf(valueOf6).length() + String.valueOf(valueOf7).length() + String.valueOf(valueOf8).length() + String.valueOf(valueOf9).length() + String.valueOf(valueOf10).length() + String.valueOf(valueOf11).length() + String.valueOf(valueOf12).length());
        sb.append("Place{address=");
        sb.append(str);
        sb.append(", addressComponents=");
        sb.append(valueOf);
        sb.append(", attributions=");
        sb.append(valueOf2);
        sb.append(", id=");
        sb.append(str2);
        sb.append(", latLng=");
        sb.append(valueOf3);
        sb.append(", name=");
        sb.append(str3);
        sb.append(", openingHours=");
        sb.append(valueOf4);
        sb.append(", phoneNumber=");
        sb.append(str4);
        sb.append(", photoMetadatas=");
        sb.append(valueOf5);
        sb.append(", plusCode=");
        sb.append(valueOf6);
        sb.append(", priceLevel=");
        sb.append(valueOf7);
        sb.append(", rating=");
        sb.append(valueOf8);
        sb.append(", types=");
        sb.append(valueOf9);
        sb.append(", userRatingsTotal=");
        sb.append(valueOf10);
        sb.append(", viewport=");
        sb.append(valueOf11);
        sb.append(", websiteUri=");
        sb.append(str5);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Place) {
            Place place = (Place) obj;
            String str = this.f12401a;
            if (str != null ? str.equals(place.getAddress()) : place.getAddress() == null) {
                AddressComponents addressComponents = this.f12402b;
                if (addressComponents != null ? addressComponents.equals(place.getAddressComponents()) : place.getAddressComponents() == null) {
                    List<String> list = this.f12403c;
                    if (list != null ? list.equals(place.getAttributions()) : place.getAttributions() == null) {
                        String str2 = this.f12404d;
                        if (str2 != null ? str2.equals(place.getId()) : place.getId() == null) {
                            LatLng latLng = this.f12405e;
                            if (latLng != null ? latLng.equals(place.getLatLng()) : place.getLatLng() == null) {
                                String str3 = this.f12406f;
                                if (str3 != null ? str3.equals(place.getName()) : place.getName() == null) {
                                    OpeningHours openingHours = this.f12407g;
                                    if (openingHours != null ? openingHours.equals(place.getOpeningHours()) : place.getOpeningHours() == null) {
                                        String str4 = this.h;
                                        if (str4 != null ? str4.equals(place.getPhoneNumber()) : place.getPhoneNumber() == null) {
                                            List<PhotoMetadata> list2 = this.i;
                                            if (list2 != null ? list2.equals(place.getPhotoMetadatas()) : place.getPhotoMetadatas() == null) {
                                                PlusCode plusCode = this.j;
                                                if (plusCode != null ? plusCode.equals(place.getPlusCode()) : place.getPlusCode() == null) {
                                                    Integer num = this.k;
                                                    if (num != null ? num.equals(place.getPriceLevel()) : place.getPriceLevel() == null) {
                                                        Double d2 = this.l;
                                                        if (d2 != null ? d2.equals(place.getRating()) : place.getRating() == null) {
                                                            List<Place.Type> list3 = this.m;
                                                            if (list3 != null ? list3.equals(place.getTypes()) : place.getTypes() == null) {
                                                                Integer num2 = this.n;
                                                                if (num2 != null ? num2.equals(place.getUserRatingsTotal()) : place.getUserRatingsTotal() == null) {
                                                                    LatLngBounds latLngBounds = this.o;
                                                                    if (latLngBounds != null ? latLngBounds.equals(place.getViewport()) : place.getViewport() == null) {
                                                                        Uri uri = this.p;
                                                                        return uri != null ? uri.equals(place.getWebsiteUri()) : place.getWebsiteUri() == null;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int hashCode() {
        String str = this.f12401a;
        int i2 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        AddressComponents addressComponents = this.f12402b;
        int hashCode2 = (hashCode ^ (addressComponents == null ? 0 : addressComponents.hashCode())) * 1000003;
        List<String> list = this.f12403c;
        int hashCode3 = (hashCode2 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        String str2 = this.f12404d;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        LatLng latLng = this.f12405e;
        int hashCode5 = (hashCode4 ^ (latLng == null ? 0 : latLng.hashCode())) * 1000003;
        String str3 = this.f12406f;
        int hashCode6 = (hashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        OpeningHours openingHours = this.f12407g;
        int hashCode7 = (hashCode6 ^ (openingHours == null ? 0 : openingHours.hashCode())) * 1000003;
        String str4 = this.h;
        int hashCode8 = (hashCode7 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        List<PhotoMetadata> list2 = this.i;
        int hashCode9 = (hashCode8 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        PlusCode plusCode = this.j;
        int hashCode10 = (hashCode9 ^ (plusCode == null ? 0 : plusCode.hashCode())) * 1000003;
        Integer num = this.k;
        int hashCode11 = (hashCode10 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Double d2 = this.l;
        int hashCode12 = (hashCode11 ^ (d2 == null ? 0 : d2.hashCode())) * 1000003;
        List<Place.Type> list3 = this.m;
        int hashCode13 = (hashCode12 ^ (list3 == null ? 0 : list3.hashCode())) * 1000003;
        Integer num2 = this.n;
        int hashCode14 = (hashCode13 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        LatLngBounds latLngBounds = this.o;
        int hashCode15 = (hashCode14 ^ (latLngBounds == null ? 0 : latLngBounds.hashCode())) * 1000003;
        Uri uri = this.p;
        if (uri != null) {
            i2 = uri.hashCode();
        }
        return hashCode15 ^ i2;
    }
}
