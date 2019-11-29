package com.google.android.gms.location.places;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

@Deprecated
public class PlaceTypes {
    public static final Set<Integer> ALL;
    @ShowFirstParty
    private static final Set<Integer> zzaj;
    @ShowFirstParty
    private static final Set<Integer> zzak;

    private PlaceTypes() {
    }

    static {
        Integer valueOf = Integer.valueOf(Place.TYPE_LOCALITY);
        zzaj = CollectionUtils.setOf(1001, 1002, 1003, 1005, 1006, valueOf, Integer.valueOf(Place.TYPE_POST_BOX), Integer.valueOf(Place.TYPE_POSTAL_CODE), Integer.valueOf(Place.TYPE_POSTAL_CODE_PREFIX), Integer.valueOf(Place.TYPE_POSTAL_TOWN), 1018, 1019, 1020, 1021, 1022, 1023, 1024, 1025, 1026, 1027, 1028);
        zzak = CollectionUtils.setOf(1001, 1002, 1003, 1005, valueOf, Integer.valueOf(Place.TYPE_POSTAL_CODE), Integer.valueOf(Place.TYPE_POSTAL_CODE_PREFIX), Integer.valueOf(Place.TYPE_POSTAL_TOWN));
        ALL = CollectionUtils.setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, valueOf, Integer.valueOf(Place.TYPE_NATURAL_FEATURE), Integer.valueOf(Place.TYPE_NEIGHBORHOOD), Integer.valueOf(Place.TYPE_POLITICAL), Integer.valueOf(Place.TYPE_POINT_OF_INTEREST), Integer.valueOf(Place.TYPE_POST_BOX), Integer.valueOf(Place.TYPE_POSTAL_CODE), Integer.valueOf(Place.TYPE_POSTAL_CODE_PREFIX), Integer.valueOf(Place.TYPE_POSTAL_TOWN), 1018, 1019, 1020, 1021, 1022, 1023, 1024, 1025, 1026, 1027, 1028, Integer.valueOf(Place.TYPE_TRANSIT_STATION));
    }
}
