package twitter4j;

import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.util.HashMap;
import java.util.Map;
import twitter4j.MediaEntity;

public class MediaEntityJSONImpl extends EntityIndex implements MediaEntity {
    private static final long serialVersionUID = 1571961225214439778L;
    private String displayURL;
    private String expandedURL;
    private String extAltText;
    protected long id;
    private String mediaURL;
    private String mediaURLHttps;
    private Map<Integer, MediaEntity.Size> sizes;
    protected String type;
    protected String url;
    private int videoAspectRatioHeight;
    private int videoAspectRatioWidth;
    private long videoDurationMillis;
    private Variant[] videoVariants;

    public /* bridge */ /* synthetic */ int compareTo(EntityIndex entityIndex) {
        return super.compareTo(entityIndex);
    }

    MediaEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            this.id = ParseUtil.getLong("id", jSONObject);
            this.url = jSONObject.getString("url");
            this.expandedURL = jSONObject.getString("expanded_url");
            this.mediaURL = jSONObject.getString("media_url");
            this.mediaURLHttps = jSONObject.getString("media_url_https");
            this.displayURL = jSONObject.getString("display_url");
            JSONObject jSONObject2 = jSONObject.getJSONObject("sizes");
            this.sizes = new HashMap(4);
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, MediaEntity.Size.LARGE, "large");
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, MediaEntity.Size.MEDIUM, "medium");
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, MediaEntity.Size.SMALL, "small");
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, MediaEntity.Size.THUMB, "thumb");
            if (!jSONObject.isNull("type")) {
                this.type = jSONObject.getString("type");
            }
            if (jSONObject.has(VideoEditEntity.VIDEO_INFO)) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(VideoEditEntity.VIDEO_INFO);
                JSONArray jSONArray2 = jSONObject3.getJSONArray("aspect_ratio");
                this.videoAspectRatioWidth = jSONArray2.getInt(0);
                this.videoAspectRatioHeight = jSONArray2.getInt(1);
                if (!jSONObject3.isNull("duration_millis")) {
                    this.videoDurationMillis = jSONObject3.getLong("duration_millis");
                }
                JSONArray jSONArray3 = jSONObject3.getJSONArray("variants");
                this.videoVariants = new Variant[jSONArray3.length()];
                for (int i = 0; i < jSONArray3.length(); i++) {
                    this.videoVariants[i] = new Variant(jSONArray3.getJSONObject(i));
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

    private void addMediaEntitySizeIfNotNull(Map<Integer, MediaEntity.Size> map, JSONObject jSONObject, Integer num, String str) throws JSONException {
        if (!jSONObject.isNull(str)) {
            map.put(num, new Size(jSONObject.getJSONObject(str)));
        }
    }

    MediaEntityJSONImpl() {
    }

    public long getId() {
        return this.id;
    }

    public String getMediaURL() {
        return this.mediaURL;
    }

    public String getMediaURLHttps() {
        return this.mediaURLHttps;
    }

    public String getText() {
        return this.url;
    }

    public String getURL() {
        return this.url;
    }

    public String getDisplayURL() {
        return this.displayURL;
    }

    public String getExpandedURL() {
        return this.expandedURL;
    }

    public Map<Integer, MediaEntity.Size> getSizes() {
        return this.sizes;
    }

    public String getType() {
        return this.type;
    }

    public int getStart() {
        return super.getStart();
    }

    public int getEnd() {
        return super.getEnd();
    }

    static class Size implements MediaEntity.Size {
        private static final long serialVersionUID = -2515842281909325169L;
        int height;
        int resize;
        int width;

        Size() {
        }

        Size(JSONObject jSONObject) throws JSONException {
            this.width = jSONObject.getInt("w");
            this.height = jSONObject.getInt("h");
            this.resize = "fit".equals(jSONObject.getString("resize")) ? 100 : 101;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public int getResize() {
            return this.resize;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            return this.height == size.height && this.resize == size.resize && this.width == size.width;
        }

        public int hashCode() {
            return (((this.width * 31) + this.height) * 31) + this.resize;
        }

        public String toString() {
            return "Size{width=" + this.width + ", height=" + this.height + ", resize=" + this.resize + '}';
        }
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

    public MediaEntity.Variant[] getVideoVariants() {
        return this.videoVariants;
    }

    static class Variant implements MediaEntity.Variant {
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
        return (obj instanceof MediaEntityJSONImpl) && this.id == ((MediaEntityJSONImpl) obj).id;
    }

    public int hashCode() {
        long j = this.id;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return "MediaEntityJSONImpl{id=" + this.id + ", url='" + this.url + '\'' + ", mediaURL='" + this.mediaURL + '\'' + ", mediaURLHttps='" + this.mediaURLHttps + '\'' + ", expandedURL='" + this.expandedURL + '\'' + ", displayURL='" + this.displayURL + '\'' + ", sizes=" + this.sizes + ", type='" + this.type + '\'' + ", videoAspectRatioWidth=" + this.videoAspectRatioWidth + ", videoAspectRatioHeight=" + this.videoAspectRatioHeight + ", videoDurationMillis=" + this.videoDurationMillis + ", videoVariants=" + this.videoVariants.length + ", extAltText='" + this.extAltText + '\'' + '}';
    }
}
