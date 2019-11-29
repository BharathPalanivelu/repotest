package com.google.android.libraries.places.api.internal.impl.net.pablo;

import android.text.TextUtils;
import com.google.a.a.c;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.internal.impl.net.pablo.AutocompletePredictionResult;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.internal.aj;
import com.google.android.libraries.places.internal.ao;
import com.google.android.libraries.places.internal.bg;
import com.google.android.libraries.places.internal.ft;
import com.google.android.libraries.places.internal.go;
import java.util.ArrayList;
import java.util.List;

public final class FindAutocompletePredictionsPabloResponse extends aj<Object, FindAutocompletePredictionsResponse> {
    public String errorMessage;
    @c(a = "predictions")
    public List<AutocompletePredictionResult> predictionResults;
    public String status;

    FindAutocompletePredictionsPabloResponse() {
    }

    public final FindAutocompletePredictionsResponse convert() throws ApiException {
        int a2 = ft.a(this.status);
        if (!PlacesStatusCodes.isError(a2)) {
            ArrayList arrayList = new ArrayList();
            List<AutocompletePredictionResult> list = this.predictionResults;
            if (list != null) {
                for (AutocompletePredictionResult prediction : list) {
                    arrayList.add(toPrediction(prediction));
                }
            }
            return FindAutocompletePredictionsResponse.newInstance(arrayList);
        }
        throw new ApiException(new Status(a2, ft.a(this.status, this.errorMessage)));
    }

    private static AutocompletePrediction toPrediction(AutocompletePredictionResult autocompletePredictionResult) throws ApiException {
        if (autocompletePredictionResult == null || TextUtils.isEmpty(autocompletePredictionResult.getPlaceId())) {
            throw new ApiException(new Status(8, "Unexpected server error: Place ID not provided for an autocomplete prediction result"));
        }
        AutocompletePrediction.Builder a2 = AutocompletePrediction.builder(autocompletePredictionResult.getPlaceId()).setPlaceTypes(ao.b(ao.a(autocompletePredictionResult.getTypes()))).setFullText(go.a(autocompletePredictionResult.getFullText())).a(toSubstringMatches(autocompletePredictionResult.getFullTextMatchedSubstrings()));
        AutocompletePredictionResult.StructuredFormatting structuredFormatting = autocompletePredictionResult.getStructuredFormatting();
        if (structuredFormatting != null) {
            a2.setPrimaryText(go.a(structuredFormatting.getPrimaryText())).b(toSubstringMatches(structuredFormatting.getPrimaryTextMatchedSubstrings())).setSecondaryText(go.a(structuredFormatting.getSecondaryText())).c(toSubstringMatches(structuredFormatting.getSecondaryTextMatchedSubstrings()));
        }
        return a2.build();
    }

    private static List<AutocompletePrediction.a> toSubstringMatches(List<AutocompletePredictionResult.Substring> list) throws ApiException {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (AutocompletePredictionResult.Substring substringMatch : list) {
            arrayList.add(toSubstringMatch(substringMatch));
        }
        return arrayList;
    }

    private static AutocompletePrediction.a toSubstringMatch(AutocompletePredictionResult.Substring substring) throws ApiException {
        if (substring != null && substring.getOffset() != null && substring.getLength() != null) {
            return new bg().a(substring.getOffset().intValue()).b(substring.getLength().intValue()).a();
        }
        throw new ApiException(new Status(8, "Unexpected server error: Place ID not provided for an autocomplete prediction result"));
    }
}
