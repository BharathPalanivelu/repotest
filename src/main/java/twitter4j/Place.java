package twitter4j;

import java.io.Serializable;

public interface Place extends Serializable, Comparable<Place>, TwitterResponse {
    GeoLocation[][] getBoundingBoxCoordinates();

    String getBoundingBoxType();

    Place[] getContainedWithIn();

    String getCountry();

    String getCountryCode();

    String getFullName();

    GeoLocation[][] getGeometryCoordinates();

    String getGeometryType();

    String getId();

    String getName();

    String getPlaceType();

    String getStreetAddress();

    String getURL();
}
