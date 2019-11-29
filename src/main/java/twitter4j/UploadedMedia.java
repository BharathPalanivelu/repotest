package twitter4j;

import java.io.Serializable;

public final class UploadedMedia implements Serializable {
    private static final long serialVersionUID = 5393092535610604718L;
    private int imageHeight;
    private String imageType;
    private int imageWidth;
    private long mediaId;
    private long size;

    UploadedMedia(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public String getImageType() {
        return this.imageType;
    }

    public long getMediaId() {
        return this.mediaId;
    }

    public long getSize() {
        return this.size;
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        this.mediaId = ParseUtil.getLong("media_id", jSONObject);
        this.size = ParseUtil.getLong("size", jSONObject);
        try {
            if (!jSONObject.isNull("image")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("image");
                this.imageWidth = ParseUtil.getInt("w", jSONObject2);
                this.imageHeight = ParseUtil.getInt("h", jSONObject2);
                this.imageType = ParseUtil.getUnescapedString("image_type", jSONObject2);
            }
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UploadedMedia uploadedMedia = (UploadedMedia) obj;
        return this.imageWidth == uploadedMedia.imageWidth && this.imageHeight == uploadedMedia.imageHeight && this.imageType == uploadedMedia.imageType && this.mediaId == uploadedMedia.mediaId && this.size == uploadedMedia.size;
    }

    public int hashCode() {
        long j = this.mediaId;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + this.imageWidth) * 31) + this.imageHeight) * 31;
        String str = this.imageType;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.size;
        return ((i + hashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "UploadedMedia{mediaId=" + this.mediaId + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", imageType='" + this.imageType + '\'' + ", size=" + this.size + '}';
    }
}
