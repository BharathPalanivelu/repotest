package twitter4j;

import com.facebook.appevents.UserDataStore;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import twitter4j.conf.Configuration;

final class PlaceJSONImpl extends TwitterResponseImpl implements Serializable, Place {
    private static final long serialVersionUID = -6368276880878829754L;
    private GeoLocation[][] boundingBoxCoordinates;
    private String boundingBoxType;
    private Place[] containedWithIn;
    private String country;
    private String countryCode;
    private String fullName;
    private GeoLocation[][] geometryCoordinates;
    private String geometryType;
    private String id;
    private String name;
    private String placeType;
    private String streetAddress;
    private String url;

    PlaceJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        JSONObject asJSONObject = httpResponse.asJSONObject();
        init(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, asJSONObject);
        }
    }

    PlaceJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    PlaceJSONImpl() {
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            this.name = ParseUtil.getUnescapedString("name", jSONObject);
            this.streetAddress = ParseUtil.getUnescapedString("street_address", jSONObject);
            this.countryCode = ParseUtil.getRawString("country_code", jSONObject);
            this.id = ParseUtil.getRawString("id", jSONObject);
            this.country = ParseUtil.getRawString(UserDataStore.COUNTRY, jSONObject);
            if (!jSONObject.isNull("place_type")) {
                this.placeType = ParseUtil.getRawString("place_type", jSONObject);
            } else {
                this.placeType = ParseUtil.getRawString("type", jSONObject);
            }
            this.url = ParseUtil.getRawString("url", jSONObject);
            this.fullName = ParseUtil.getRawString("full_name", jSONObject);
            if (!jSONObject.isNull("bounding_box")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("bounding_box");
                this.boundingBoxType = ParseUtil.getRawString("type", jSONObject2);
                this.boundingBoxCoordinates = JSONImplFactory.coordinatesAsGeoLocationArray(jSONObject2.getJSONArray("coordinates"));
            } else {
                this.boundingBoxType = null;
                this.boundingBoxCoordinates = null;
            }
            if (!jSONObject.isNull("geometry")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("geometry");
                this.geometryType = ParseUtil.getRawString("type", jSONObject3);
                JSONArray jSONArray = jSONObject3.getJSONArray("coordinates");
                if (this.geometryType.equals("Point")) {
                    this.geometryCoordinates = (GeoLocation[][]) Array.newInstance(GeoLocation.class, new int[]{1, 1});
                    this.geometryCoordinates[0][0] = new GeoLocation(jSONArray.getDouble(1), jSONArray.getDouble(0));
                } else if (this.geometryType.equals("Polygon")) {
                    this.geometryCoordinates = JSONImplFactory.coordinatesAsGeoLocationArray(jSONArray);
                } else {
                    this.geometryType = null;
                    this.geometryCoordinates = null;
                }
            } else {
                this.geometryType = null;
                this.geometryCoordinates = null;
            }
            if (!jSONObject.isNull("contained_within")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("contained_within");
                this.containedWithIn = new Place[jSONArray2.length()];
                for (int i = 0; i < jSONArray2.length(); i++) {
                    this.containedWithIn[i] = new PlaceJSONImpl(jSONArray2.getJSONObject(i));
                }
                return;
            }
            this.containedWithIn = null;
        } catch (JSONException e2) {
            throw new TwitterException(e2.getMessage() + ":" + jSONObject.toString(), (Throwable) e2);
        }
    }

    public int compareTo(Place place) {
        return this.id.compareTo(place.getId());
    }

    static ResponseList<Place> createPlaceList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        JSONObject jSONObject;
        try {
            jSONObject = httpResponse.asJSONObject();
            try {
                return createPlaceList(jSONObject.getJSONObject(AbTestingModule.KEY_RESULT).getJSONArray("places"), httpResponse, configuration);
            } catch (JSONException e2) {
                e = e2;
                throw new TwitterException(e.getMessage() + ":" + jSONObject.toString(), (Throwable) e);
            }
        } catch (JSONException e3) {
            e = e3;
            jSONObject = null;
            throw new TwitterException(e.getMessage() + ":" + jSONObject.toString(), (Throwable) e);
        }
    }

    static ResponseList<Place> createPlaceList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        try {
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                PlaceJSONImpl placeJSONImpl = new PlaceJSONImpl(jSONObject);
                responseListImpl.add(placeJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(placeJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getId() {
        return this.id;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPlaceType() {
        return this.placeType;
    }

    public String getURL() {
        return this.url;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getBoundingBoxType() {
        return this.boundingBoxType;
    }

    public GeoLocation[][] getBoundingBoxCoordinates() {
        return this.boundingBoxCoordinates;
    }

    public String getGeometryType() {
        return this.geometryType;
    }

    public GeoLocation[][] getGeometryCoordinates() {
        return this.geometryCoordinates;
    }

    public Place[] getContainedWithIn() {
        return this.containedWithIn;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof Place) && ((Place) obj).getId().equals(this.id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        List list;
        List list2;
        StringBuilder sb = new StringBuilder();
        sb.append("PlaceJSONImpl{name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", streetAddress='");
        sb.append(this.streetAddress);
        sb.append('\'');
        sb.append(", countryCode='");
        sb.append(this.countryCode);
        sb.append('\'');
        sb.append(", id='");
        sb.append(this.id);
        sb.append('\'');
        sb.append(", country='");
        sb.append(this.country);
        sb.append('\'');
        sb.append(", placeType='");
        sb.append(this.placeType);
        sb.append('\'');
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", fullName='");
        sb.append(this.fullName);
        sb.append('\'');
        sb.append(", boundingBoxType='");
        sb.append(this.boundingBoxType);
        sb.append('\'');
        sb.append(", boundingBoxCoordinates=");
        GeoLocation[][] geoLocationArr = this.boundingBoxCoordinates;
        List list3 = null;
        if (geoLocationArr == null) {
            list = null;
        } else {
            list = Arrays.asList(geoLocationArr);
        }
        sb.append(list);
        sb.append(", geometryType='");
        sb.append(this.geometryType);
        sb.append('\'');
        sb.append(", geometryCoordinates=");
        GeoLocation[][] geoLocationArr2 = this.geometryCoordinates;
        if (geoLocationArr2 == null) {
            list2 = null;
        } else {
            list2 = Arrays.asList(geoLocationArr2);
        }
        sb.append(list2);
        sb.append(", containedWithIn=");
        Place[] placeArr = this.containedWithIn;
        if (placeArr != null) {
            list3 = Arrays.asList(placeArr);
        }
        sb.append(list3);
        sb.append('}');
        return sb.toString();
    }
}
