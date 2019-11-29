package com.google.android.libraries.places.api.internal.impl.net.pablo;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.internal.aj;
import com.google.android.libraries.places.internal.ao;
import com.google.android.libraries.places.internal.ft;
import java.util.List;

public final class FetchPlacePabloResponse extends aj<Object, FetchPlaceResponse> {
    public String errorMessage;
    public List<String> htmlAttributions;
    public PlaceResult result;
    public String status;

    FetchPlacePabloResponse() {
    }

    public final FetchPlaceResponse convert() throws ApiException {
        int a2 = ft.a(this.status);
        if (!PlacesStatusCodes.isError(a2)) {
            return FetchPlaceResponse.newInstance(ao.a(this.result, this.htmlAttributions));
        }
        throw new ApiException(new Status(a2, ft.a(this.status, this.errorMessage)));
    }
}
