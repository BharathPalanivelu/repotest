package com.google.android.libraries.places.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.internal.impl.net.pablo.PlaceResult;
import com.google.android.libraries.places.api.model.AddressComponent;
import com.google.android.libraries.places.api.model.AddressComponents;
import com.google.android.libraries.places.api.model.DayOfWeek;
import com.google.android.libraries.places.api.model.LocalTime;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.Period;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlusCode;
import com.google.android.libraries.places.api.model.TimeOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ao {

    /* renamed from: a  reason: collision with root package name */
    private static final hd<String, Place.Type> f12341a = new he().a("accounting", Place.Type.ACCOUNTING).a("administrative_area_level_1", Place.Type.ADMINISTRATIVE_AREA_LEVEL_1).a("administrative_area_level_2", Place.Type.ADMINISTRATIVE_AREA_LEVEL_2).a("administrative_area_level_3", Place.Type.ADMINISTRATIVE_AREA_LEVEL_3).a("administrative_area_level_4", Place.Type.ADMINISTRATIVE_AREA_LEVEL_4).a("administrative_area_level_5", Place.Type.ADMINISTRATIVE_AREA_LEVEL_5).a("airport", Place.Type.AIRPORT).a("amusement_park", Place.Type.AMUSEMENT_PARK).a("aquarium", Place.Type.AQUARIUM).a("art_gallery", Place.Type.ART_GALLERY).a("atm", Place.Type.ATM).a("bakery", Place.Type.BAKERY).a("bank", Place.Type.BANK).a("bar", Place.Type.BAR).a("beauty_salon", Place.Type.BEAUTY_SALON).a("bicycle_store", Place.Type.BICYCLE_STORE).a("book_store", Place.Type.BOOK_STORE).a("bowling_alley", Place.Type.BOWLING_ALLEY).a("bus_station", Place.Type.BUS_STATION).a("cafe", Place.Type.CAFE).a("campground", Place.Type.CAMPGROUND).a("car_dealer", Place.Type.CAR_DEALER).a("car_rental", Place.Type.CAR_RENTAL).a("car_repair", Place.Type.CAR_REPAIR).a("car_wash", Place.Type.CAR_WASH).a("casino", Place.Type.CASINO).a("cemetery", Place.Type.CEMETERY).a("church", Place.Type.CHURCH).a("city_hall", Place.Type.CITY_HALL).a("clothing_store", Place.Type.CLOTHING_STORE).a("colloquial_area", Place.Type.COLLOQUIAL_AREA).a("convenience_store", Place.Type.CONVENIENCE_STORE).a(UserDataStore.COUNTRY, Place.Type.COUNTRY).a("courthouse", Place.Type.COURTHOUSE).a("dentist", Place.Type.DENTIST).a("department_store", Place.Type.DEPARTMENT_STORE).a("doctor", Place.Type.DOCTOR).a("electrician", Place.Type.ELECTRICIAN).a("electronics_store", Place.Type.ELECTRONICS_STORE).a("embassy", Place.Type.EMBASSY).a("establishment", Place.Type.ESTABLISHMENT).a("finance", Place.Type.FINANCE).a("fire_station", Place.Type.FIRE_STATION).a("floor", Place.Type.FLOOR).a("florist", Place.Type.FLORIST).a("food", Place.Type.FOOD).a("funeral_home", Place.Type.FUNERAL_HOME).a("furniture_store", Place.Type.FURNITURE_STORE).a("gas_station", Place.Type.GAS_STATION).a("general_contractor", Place.Type.GENERAL_CONTRACTOR).a("geocode", Place.Type.GEOCODE).a("grocery_or_supermarket", Place.Type.GROCERY_OR_SUPERMARKET).a("gym", Place.Type.GYM).a("hair_care", Place.Type.HAIR_CARE).a("hardware_store", Place.Type.HARDWARE_STORE).a("health", Place.Type.HEALTH).a("hindu_temple", Place.Type.HINDU_TEMPLE).a("home_goods_store", Place.Type.HOME_GOODS_STORE).a("hospital", Place.Type.HOSPITAL).a("insurance_agency", Place.Type.INSURANCE_AGENCY).a("intersection", Place.Type.INTERSECTION).a("jewelry_store", Place.Type.JEWELRY_STORE).a("laundry", Place.Type.LAUNDRY).a("lawyer", Place.Type.LAWYER).a("library", Place.Type.LIBRARY).a("liquor_store", Place.Type.LIQUOR_STORE).a("local_government_office", Place.Type.LOCAL_GOVERNMENT_OFFICE).a("locality", Place.Type.LOCALITY).a("locksmith", Place.Type.LOCKSMITH).a("lodging", Place.Type.LODGING).a("meal_delivery", Place.Type.MEAL_DELIVERY).a("meal_takeaway", Place.Type.MEAL_TAKEAWAY).a("mosque", Place.Type.MOSQUE).a("movie_rental", Place.Type.MOVIE_RENTAL).a("movie_theater", Place.Type.MOVIE_THEATER).a("moving_company", Place.Type.MOVING_COMPANY).a("museum", Place.Type.MUSEUM).a("natural_feature", Place.Type.NATURAL_FEATURE).a("neighborhood", Place.Type.NEIGHBORHOOD).a("night_club", Place.Type.NIGHT_CLUB).a("painter", Place.Type.PAINTER).a("park", Place.Type.PARK).a(PlaceFields.PARKING, Place.Type.PARKING).a("pet_store", Place.Type.PET_STORE).a("pharmacy", Place.Type.PHARMACY).a("physiotherapist", Place.Type.PHYSIOTHERAPIST).a("place_of_worship", Place.Type.PLACE_OF_WORSHIP).a("plumber", Place.Type.PLUMBER).a("point_of_interest", Place.Type.POINT_OF_INTEREST).a("police", Place.Type.POLICE).a("political", Place.Type.POLITICAL).a("post_box", Place.Type.POST_BOX).a("post_office", Place.Type.POST_OFFICE).a("postal_code", Place.Type.POSTAL_CODE).a("postal_code_prefix", Place.Type.POSTAL_CODE_PREFIX).a("postal_code_suffix", Place.Type.POSTAL_CODE_SUFFIX).a("postal_town", Place.Type.POSTAL_TOWN).a("premise", Place.Type.PREMISE).a("real_estate_agency", Place.Type.REAL_ESTATE_AGENCY).a("restaurant", Place.Type.RESTAURANT).a("roofing_contractor", Place.Type.ROOFING_CONTRACTOR).a("room", Place.Type.ROOM).a("route", Place.Type.ROUTE).a("rv_park", Place.Type.RV_PARK).a("school", Place.Type.SCHOOL).a("shoe_store", Place.Type.SHOE_STORE).a("shopping_mall", Place.Type.SHOPPING_MALL).a("spa", Place.Type.SPA).a("stadium", Place.Type.STADIUM).a("street_address", Place.Type.STREET_ADDRESS).a("storage", Place.Type.STORAGE).a("store", Place.Type.STORE).a("sublocality", Place.Type.SUBLOCALITY).a("sublocality_level_1", Place.Type.SUBLOCALITY_LEVEL_1).a("sublocality_level_2", Place.Type.SUBLOCALITY_LEVEL_2).a("sublocality_level_3", Place.Type.SUBLOCALITY_LEVEL_3).a("sublocality_level_4", Place.Type.SUBLOCALITY_LEVEL_4).a("sublocality_level_5", Place.Type.SUBLOCALITY_LEVEL_5).a("subpremise", Place.Type.SUBPREMISE).a("subway_station", Place.Type.SUBWAY_STATION).a("supermarket", Place.Type.SUPERMARKET).a("synagogue", Place.Type.SYNAGOGUE).a("taxi_stand", Place.Type.TAXI_STAND).a("train_station", Place.Type.TRAIN_STATION).a("transit_station", Place.Type.TRANSIT_STATION).a("travel_agency", Place.Type.TRAVEL_AGENCY).a("university", Place.Type.UNIVERSITY).a("veterinary_care", Place.Type.VETERINARY_CARE).a("zoo", Place.Type.ZOO).a();

    public static Place a(PlaceResult placeResult, List<String> list) throws ApiException {
        AddressComponents addressComponents;
        LatLngBounds latLngBounds;
        LatLng latLng;
        ArrayList arrayList;
        OpeningHours openingHours;
        ArrayList arrayList2;
        PhotoMetadata photoMetadata;
        int i;
        Place.Builder builder = Place.builder();
        builder.setAttributions(list);
        if (placeResult != null) {
            List<PlaceResult.AddressComponent> addressComponents2 = placeResult.getAddressComponents();
            PlusCode plusCode = null;
            if (addressComponents2 == null) {
                addressComponents = null;
            } else {
                ArrayList arrayList3 = new ArrayList();
                for (PlaceResult.AddressComponent a2 : addressComponents2) {
                    a(arrayList3, a(a2));
                }
                addressComponents = AddressComponents.newInstance(arrayList3);
            }
            PlaceResult.Geometry geometry = placeResult.getGeometry();
            if (geometry != null) {
                latLng = a(geometry.getLocation());
                PlaceResult.Geometry.Viewport viewport = geometry.getViewport();
                if (viewport != null) {
                    LatLng a3 = a(viewport.getSouthwest());
                    LatLng a4 = a(viewport.getNortheast());
                    if (!(a3 == null || a4 == null)) {
                        latLngBounds = new LatLngBounds(a3, a4);
                    }
                }
                latLngBounds = null;
            } else {
                latLng = null;
                latLngBounds = null;
            }
            String website = placeResult.getWebsite();
            Uri parse = website != null ? Uri.parse(website) : null;
            Place.Builder phoneNumber = builder.setAddress(placeResult.getFormattedAddress()).setAddressComponents(addressComponents).setId(placeResult.getPlaceId()).setLatLng(latLng).setName(placeResult.getName()).setPhoneNumber(placeResult.getInternationalPhoneNumber());
            List<PlaceResult.Photo> photos = placeResult.getPhotos();
            if (photos != null) {
                arrayList = new ArrayList();
                for (PlaceResult.Photo next : photos) {
                    if (next == null) {
                        photoMetadata = null;
                    } else if (!TextUtils.isEmpty(next.getPhotoReference())) {
                        Integer height = next.getHeight();
                        Integer width = next.getWidth();
                        PhotoMetadata.Builder builder2 = PhotoMetadata.builder(next.getPhotoReference());
                        List<String> htmlAttributions = next.getHtmlAttributions();
                        PhotoMetadata.Builder attributions = builder2.setAttributions((htmlAttributions == null || htmlAttributions.isEmpty()) ? "" : hj.b(", ").a().a((Iterable<?>) htmlAttributions));
                        int i2 = 0;
                        if (height == null) {
                            i = 0;
                        } else {
                            i = height.intValue();
                        }
                        PhotoMetadata.Builder height2 = attributions.setHeight(i);
                        if (width != null) {
                            i2 = width.intValue();
                        }
                        photoMetadata = height2.setWidth(i2).build();
                    } else {
                        throw b("Photo reference not provided for a PhotoMetadata result.");
                    }
                    a(arrayList, photoMetadata);
                }
            } else {
                arrayList = null;
            }
            Place.Builder photoMetadatas = phoneNumber.setPhotoMetadatas(arrayList);
            PlaceResult.OpeningHours openingHours2 = placeResult.getOpeningHours();
            if (openingHours2 != null) {
                OpeningHours.Builder builder3 = OpeningHours.builder();
                List<PlaceResult.OpeningHours.Period> periods = openingHours2.getPeriods();
                if (periods != null) {
                    arrayList2 = new ArrayList();
                    Iterator<PlaceResult.OpeningHours.Period> it = periods.iterator();
                    while (it.hasNext()) {
                        PlaceResult.OpeningHours.Period next2 = it.next();
                        a(arrayList2, next2 != null ? Period.builder().setOpen(a(next2.getOpen())).setClose(a(next2.getClose())).build() : null);
                    }
                } else {
                    arrayList2 = null;
                }
                openingHours = builder3.setPeriods(b(arrayList2)).setWeekdayText(b(openingHours2.getWeekdayText())).build();
            } else {
                openingHours = null;
            }
            Place.Builder openingHours3 = photoMetadatas.setOpeningHours(openingHours);
            PlaceResult.PlusCode plusCode2 = placeResult.getPlusCode();
            if (plusCode2 != null) {
                plusCode = PlusCode.builder().setCompoundCode(plusCode2.getCompoundCode()).setGlobalCode(plusCode2.getGlobalCode()).build();
            }
            openingHours3.setPlusCode(plusCode).setPriceLevel(placeResult.getPriceLevel()).setRating(placeResult.getRating()).setTypes(a(placeResult.getTypes())).setUserRatingsTotal(placeResult.getUserRatingsTotal()).setViewport(latLngBounds).setWebsiteUri(parse);
        }
        return builder.build();
    }

    private static AddressComponent a(PlaceResult.AddressComponent addressComponent) throws ApiException {
        if (addressComponent == null) {
            return null;
        }
        try {
            return AddressComponent.builder(addressComponent.getLongName(), addressComponent.getTypes()).setShortName(addressComponent.getShortName()).build();
        } catch (IllegalStateException | NullPointerException e2) {
            throw b(String.format("AddressComponent not properly defined (%s).", new Object[]{e2.getMessage()}));
        }
    }

    private static TimeOfWeek a(PlaceResult.OpeningHours.TimeOfWeek timeOfWeek) {
        DayOfWeek dayOfWeek;
        if (timeOfWeek == null) {
            return null;
        }
        boolean z = true;
        go.a(timeOfWeek.getDay() != null, (Object) "Unable to convert Pablo response to TimeOfWeek: The \"day\" field is missing.");
        if (timeOfWeek.getTime() == null) {
            z = false;
        }
        go.a(z, (Object) "Unable to convert Pablo response to TimeOfWeek: The \"time\" field is missing.");
        switch (timeOfWeek.getDay().intValue()) {
            case 0:
                dayOfWeek = DayOfWeek.SUNDAY;
                break;
            case 1:
                dayOfWeek = DayOfWeek.MONDAY;
                break;
            case 2:
                dayOfWeek = DayOfWeek.TUESDAY;
                break;
            case 3:
                dayOfWeek = DayOfWeek.WEDNESDAY;
                break;
            case 4:
                dayOfWeek = DayOfWeek.THURSDAY;
                break;
            case 5:
                dayOfWeek = DayOfWeek.FRIDAY;
                break;
            case 6:
                dayOfWeek = DayOfWeek.SATURDAY;
                break;
            default:
                throw new IllegalArgumentException("pabloDayOfWeek can only be an integer between 0 and 6");
        }
        return TimeOfWeek.newInstance(dayOfWeek, a(timeOfWeek.getTime()));
    }

    private static LocalTime a(String str) {
        if (str == null) {
            return null;
        }
        boolean z = true;
        String format = String.format("Unable to convert %s to LocalTime, must be of format \"hhmm\".", new Object[]{str});
        if (str.length() != 4) {
            z = false;
        }
        go.a(z, (Object) format);
        try {
            return LocalTime.newInstance(Integer.parseInt(str.substring(0, 2)), Integer.parseInt(str.substring(2, 4)));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException(format, e2);
        }
    }

    public static List<Place.Type> a(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (String next : list) {
            if (f12341a.containsKey(next)) {
                arrayList.add(f12341a.get(next));
            } else {
                z = true;
            }
        }
        if (z) {
            arrayList.add(Place.Type.OTHER);
        }
        return arrayList;
    }

    private static LatLng a(PlaceResult.Geometry.Location location) {
        if (location == null || location.getLat() == null || location.getLng() == null) {
            return null;
        }
        return new LatLng(location.getLat().doubleValue(), location.getLng().doubleValue());
    }

    private static ApiException b(String str) {
        String valueOf = String.valueOf(str);
        return new ApiException(new Status(8, valueOf.length() != 0 ? "Unexpected server error: ".concat(valueOf) : new String("Unexpected server error: ")));
    }

    public static <T> List<T> b(List<T> list) {
        return list != null ? list : new ArrayList();
    }

    private static <T> boolean a(Collection<T> collection, T t) {
        if (t != null) {
            return collection.add(t);
        }
        return false;
    }
}
