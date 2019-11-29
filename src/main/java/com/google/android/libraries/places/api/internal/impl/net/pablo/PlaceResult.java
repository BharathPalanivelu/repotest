package com.google.android.libraries.places.api.internal.impl.net.pablo;

import java.util.List;

public class PlaceResult {
    public List<AddressComponent> addressComponents;
    public String formattedAddress;
    public Geometry geometry;
    public String icon;
    public String internationalPhoneNumber;
    public String name;
    public OpeningHours openingHours;
    public List<Photo> photos;
    public String placeId;
    public PlusCode plusCode;
    public Integer priceLevel;
    public Double rating;
    public List<String> types;
    public Integer userRatingsTotal;
    public String website;

    public static class AddressComponent {
        public String longName;
        public String shortName;
        public List<String> types;

        AddressComponent() {
        }

        public String getLongName() {
            return this.longName;
        }

        public String getShortName() {
            return this.shortName;
        }

        public List<String> getTypes() {
            return this.types;
        }
    }

    public static class Geometry {
        public Location location;
        public Viewport viewport;

        public static class Location {
            public Double lat;
            public Double lng;

            Location() {
            }

            public Double getLat() {
                return this.lat;
            }

            public Double getLng() {
                return this.lng;
            }
        }

        public static class Viewport {
            public Location northeast;
            public Location southwest;

            Viewport() {
            }

            public Location getNortheast() {
                return this.northeast;
            }

            public Location getSouthwest() {
                return this.southwest;
            }
        }

        Geometry() {
        }

        public Location getLocation() {
            return this.location;
        }

        public Viewport getViewport() {
            return this.viewport;
        }
    }

    public static class OpeningHours {
        public List<Period> periods;
        public List<String> weekdayText;

        public static class Period {
            public TimeOfWeek close;
            public TimeOfWeek open;

            Period() {
            }

            public TimeOfWeek getClose() {
                return this.close;
            }

            public TimeOfWeek getOpen() {
                return this.open;
            }
        }

        public static class TimeOfWeek {
            public Integer day;
            public String time;

            TimeOfWeek() {
            }

            public Integer getDay() {
                return this.day;
            }

            public String getTime() {
                return this.time;
            }
        }

        OpeningHours() {
        }

        public List<Period> getPeriods() {
            return this.periods;
        }

        public List<String> getWeekdayText() {
            return this.weekdayText;
        }
    }

    public static class Photo {
        public Integer height;
        public List<String> htmlAttributions;
        public String photoReference;
        public Integer width;

        Photo() {
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getWidth() {
            return this.width;
        }

        public String getPhotoReference() {
            return this.photoReference;
        }

        public List<String> getHtmlAttributions() {
            return this.htmlAttributions;
        }
    }

    public static class PlusCode {
        public String compoundCode;
        public String globalCode;

        PlusCode() {
        }

        public String getCompoundCode() {
            return this.compoundCode;
        }

        public String getGlobalCode() {
            return this.globalCode;
        }
    }

    PlaceResult() {
    }

    public List<AddressComponent> getAddressComponents() {
        return this.addressComponents;
    }

    public String getFormattedAddress() {
        return this.formattedAddress;
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    /* access modifiers changed from: package-private */
    public String getIcon() {
        return this.icon;
    }

    public String getInternationalPhoneNumber() {
        return this.internationalPhoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public OpeningHours getOpeningHours() {
        return this.openingHours;
    }

    public List<Photo> getPhotos() {
        return this.photos;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public PlusCode getPlusCode() {
        return this.plusCode;
    }

    public Integer getPriceLevel() {
        return this.priceLevel;
    }

    public Double getRating() {
        return this.rating;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public Integer getUserRatingsTotal() {
        return this.userRatingsTotal;
    }

    public String getWebsite() {
        return this.website;
    }
}
