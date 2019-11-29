package com.google.android.libraries.places.api.internal.impl.net.pablo;

import com.google.a.a.c;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.internal.aj;
import com.google.android.libraries.places.internal.ao;
import com.google.android.libraries.places.internal.ft;
import java.util.ArrayList;
import java.util.List;

public final class FindCurrentPlacePabloResponse extends aj<Object, FindCurrentPlaceResponse> {
    public String errorMessage;
    public List<String> htmlAttributions;
    @c(a = "predictions")
    public List<PlaceLikelihoodResult> placeLikelihoodResults;
    public String status;

    FindCurrentPlacePabloResponse() {
    }

    public final FindCurrentPlaceResponse convert() throws ApiException {
        int a2 = ft.a(this.status);
        if (!PlacesStatusCodes.isError(a2)) {
            ArrayList arrayList = new ArrayList();
            List<PlaceLikelihoodResult> list = this.placeLikelihoodResults;
            if (list != null) {
                for (PlaceLikelihoodResult next : list) {
                    if (next.getPlaceResult() == null) {
                        throw new ApiException(new Status(8, "Unexpected server error: PlaceLikelihood returned without a Place value"));
                    } else if (next.getLikelihood() != null) {
                        arrayList.add(PlaceLikelihood.newInstance(ao.a(next.getPlaceResult(), this.htmlAttributions), next.getLikelihood().doubleValue()));
                    } else {
                        throw new ApiException(new Status(8, "Unexpected server error: PlaceLikelihood returned without a likelihood value"));
                    }
                }
            }
            return FindCurrentPlaceResponse.newInstance(arrayList);
        }
        throw new ApiException(new Status(a2, ft.a(this.status, this.errorMessage)));
    }
}
