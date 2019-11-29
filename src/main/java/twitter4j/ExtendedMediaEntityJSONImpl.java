package twitter4j;

import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.util.Arrays;
import twitter4j.ExtendedMediaEntity;

public class ExtendedMediaEntityJSONImpl extends MediaEntityJSONImpl implements ExtendedMediaEntity {
    private static final long serialVersionUID = -3889082303259253211L;
    private String extAltText;
    private int videoAspectRatioHeight;
    private int videoAspectRatioWidth;
    private long videoDurationMillis;
    private Variant[] videoVariants;

    ExtendedMediaEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        super(jSONObject);
        try {
            if (jSONObject.has(VideoEditEntity.VIDEO_INFO)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(VideoEditEntity.VIDEO_INFO);
                JSONArray jSONArray = jSONObject2.getJSONArray("aspect_ratio");
                this.videoAspectRatioWidth = jSONArray.getInt(0);
                this.videoAspectRatioHeight = jSONArray.getInt(1);
                if (!jSONObject2.isNull("duration_millis")) {
                    this.videoDurationMillis = jSONObject2.getLong("duration_millis");
                }
                JSONArray jSONArray2 = jSONObject2.getJSONArray("variants");
                this.videoVariants = new Variant[jSONArray2.length()];
                for (int i = 0; i < jSONArray2.length(); i++) {
                    this.videoVariants[i] = new Variant(jSONArray2.getJSONObject(i));
                }
            } else {
                this.videoVariants = new Variant[0];
            }
            if (jSONObject.has("ext_alt_text")) {
                this.extAltText = jSONObject.getString("ext_alt_text");
            }
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    ExtendedMediaEntityJSONImpl() {
    }

    public int getVideoAspectRatioWidth() {
        return this.videoAspectRatioWidth;
    }

    public int getVideoAspectRatioHeight() {
        return this.videoAspectRatioHeight;
    }

    public long getVideoDurationMillis() {
        return this.videoDurationMillis;
    }

    public String getExtAltText() {
        return this.extAltText;
    }

    public ExtendedMediaEntity.Variant[] getVideoVariants() {
        return this.videoVariants;
    }

    static class Variant implements ExtendedMediaEntity.Variant {
        private static final long serialVersionUID = 1027236588556797980L;
        int bitrate;
        String contentType;
        String url;

        Variant(JSONObject jSONObject) throws JSONException {
            this.bitrate = jSONObject.has(IjkMediaMeta.IJKM_KEY_BITRATE) ? jSONObject.getInt(IjkMediaMeta.IJKM_KEY_BITRATE) : 0;
            this.contentType = jSONObject.getString("content_type");
            this.url = jSONObject.getString("url");
        }

        Variant() {
        }

        public int getBitrate() {
            return this.bitrate;
        }

        public String getContentType() {
            return this.contentType;
        }

        public String getUrl() {
            return this.url;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Variant)) {
                return false;
            }
            Variant variant = (Variant) obj;
            return this.bitrate == variant.bitrate && this.contentType.equals(variant.contentType) && this.url.equals(variant.url);
        }

        public int hashCode() {
            int i = this.bitrate * 31;
            String str = this.contentType;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.url;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            return "Variant{bitrate=" + this.bitrate + ", contentType=" + this.contentType + ", url=" + this.url + '}';
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ExtendedMediaEntityJSONImpl) && this.id == ((ExtendedMediaEntityJSONImpl) obj).id;
    }

    public int hashCode() {
        return (int) (this.id ^ (this.id >>> 32));
    }

    public String toString() {
        return "ExtendedMediaEntityJSONImpl{id=" + this.id + ", url=" + this.url + ", mediaURL=" + this.mediaURL + ", mediaURLHttps=" + this.mediaURLHttps + ", expandedURL=" + this.expandedURL + ", displayURL='" + this.displayURL + '\'' + ", sizes=" + this.sizes + ", type=" + this.type + ", videoAspectRatioWidth=" + this.videoAspectRatioWidth + ", videoAspectRatioHeight=" + this.videoAspectRatioHeight + ", videoDurationMillis=" + this.videoDurationMillis + ", extAltText=" + this.extAltText + ", videoVariants=" + Arrays.toString(this.videoVariants) + '}';
    }
}
