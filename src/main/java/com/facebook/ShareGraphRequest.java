package com.facebook;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareGraphRequest {
    public static GraphRequest createOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject) throws FacebookException {
        String string = shareOpenGraphObject.getString("type");
        if (string == null) {
            string = shareOpenGraphObject.getString("og:type");
        }
        if (string != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("object", ((JSONObject) OpenGraphJSONUtility.toJSONValue(shareOpenGraphObject, new OpenGraphJSONUtility.PhotoJSONProcessor() {
                    public JSONObject toJSONObject(SharePhoto sharePhoto) {
                        Uri imageUrl = sharePhoto.getImageUrl();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", imageUrl.toString());
                            return jSONObject;
                        } catch (Exception e2) {
                            throw new FacebookException("Unable to attach images", (Throwable) e2);
                        }
                    }
                })).toString());
                Locale locale = Locale.ROOT;
                return new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(locale, "%s/%s", new Object[]{"me", "objects/" + string}), bundle, HttpMethod.POST);
            } catch (JSONException e2) {
                throw new FacebookException(e2.getMessage());
            }
        } else {
            throw new FacebookException("Open graph object type cannot be null");
        }
    }
}
