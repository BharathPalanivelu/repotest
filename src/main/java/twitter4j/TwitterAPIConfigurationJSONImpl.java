package twitter4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import twitter4j.MediaEntity;
import twitter4j.MediaEntityJSONImpl;
import twitter4j.conf.Configuration;

class TwitterAPIConfigurationJSONImpl extends TwitterResponseImpl implements TwitterAPIConfiguration {
    private static final long serialVersionUID = -3588904550808591686L;
    private int charactersReservedPerMedia;
    private int dmTextCharacterLimit;
    private int maxMediaPerUpload;
    private String[] nonUsernamePaths;
    private int photoSizeLimit;
    private Map<Integer, MediaEntity.Size> photoSizes;
    private int shortURLLength;
    private int shortURLLengthHttps;

    TwitterAPIConfigurationJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        JSONObject jSONObject;
        try {
            JSONObject asJSONObject = httpResponse.asJSONObject();
            this.photoSizeLimit = ParseUtil.getInt("photo_size_limit", asJSONObject);
            this.shortURLLength = ParseUtil.getInt("short_url_length", asJSONObject);
            this.shortURLLengthHttps = ParseUtil.getInt("short_url_length_https", asJSONObject);
            this.charactersReservedPerMedia = ParseUtil.getInt("characters_reserved_per_media", asJSONObject);
            this.dmTextCharacterLimit = ParseUtil.getInt("dm_text_character_limit", asJSONObject);
            JSONObject jSONObject2 = asJSONObject.getJSONObject("photo_sizes");
            this.photoSizes = new HashMap(4);
            this.photoSizes.put(MediaEntity.Size.LARGE, new MediaEntityJSONImpl.Size(jSONObject2.getJSONObject("large")));
            if (jSONObject2.isNull("med")) {
                jSONObject = jSONObject2.getJSONObject("medium");
            } else {
                jSONObject = jSONObject2.getJSONObject("med");
            }
            this.photoSizes.put(MediaEntity.Size.MEDIUM, new MediaEntityJSONImpl.Size(jSONObject));
            this.photoSizes.put(MediaEntity.Size.SMALL, new MediaEntityJSONImpl.Size(jSONObject2.getJSONObject("small")));
            this.photoSizes.put(MediaEntity.Size.THUMB, new MediaEntityJSONImpl.Size(jSONObject2.getJSONObject("thumb")));
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
                TwitterObjectFactory.registerJSONObject(this, httpResponse.asJSONObject());
            }
            JSONArray jSONArray = asJSONObject.getJSONArray("non_username_paths");
            this.nonUsernamePaths = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                this.nonUsernamePaths[i] = jSONArray.getString(i);
            }
            this.maxMediaPerUpload = ParseUtil.getInt("max_media_per_upload", asJSONObject);
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public int getPhotoSizeLimit() {
        return this.photoSizeLimit;
    }

    public int getShortURLLength() {
        return this.shortURLLength;
    }

    public int getShortURLLengthHttps() {
        return this.shortURLLengthHttps;
    }

    public int getCharactersReservedPerMedia() {
        return this.charactersReservedPerMedia;
    }

    public int getDmTextCharacterLimit() {
        return this.dmTextCharacterLimit;
    }

    public Map<Integer, MediaEntity.Size> getPhotoSizes() {
        return this.photoSizes;
    }

    public String[] getNonUsernamePaths() {
        return this.nonUsernamePaths;
    }

    public int getMaxMediaPerUpload() {
        return this.maxMediaPerUpload;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TwitterAPIConfigurationJSONImpl)) {
            return false;
        }
        TwitterAPIConfigurationJSONImpl twitterAPIConfigurationJSONImpl = (TwitterAPIConfigurationJSONImpl) obj;
        if (this.charactersReservedPerMedia != twitterAPIConfigurationJSONImpl.charactersReservedPerMedia || this.dmTextCharacterLimit != twitterAPIConfigurationJSONImpl.dmTextCharacterLimit || this.maxMediaPerUpload != twitterAPIConfigurationJSONImpl.maxMediaPerUpload || this.photoSizeLimit != twitterAPIConfigurationJSONImpl.photoSizeLimit || this.shortURLLength != twitterAPIConfigurationJSONImpl.shortURLLength || this.shortURLLengthHttps != twitterAPIConfigurationJSONImpl.shortURLLengthHttps || !Arrays.equals(this.nonUsernamePaths, twitterAPIConfigurationJSONImpl.nonUsernamePaths)) {
            return false;
        }
        Map<Integer, MediaEntity.Size> map = this.photoSizes;
        return map == null ? twitterAPIConfigurationJSONImpl.photoSizes == null : map.equals(twitterAPIConfigurationJSONImpl.photoSizes);
    }

    public int hashCode() {
        int i = ((((((((this.photoSizeLimit * 31) + this.shortURLLength) * 31) + this.shortURLLengthHttps) * 31) + this.charactersReservedPerMedia) * 32) + this.dmTextCharacterLimit) * 31;
        Map<Integer, MediaEntity.Size> map = this.photoSizes;
        int i2 = 0;
        int hashCode = (i + (map != null ? map.hashCode() : 0)) * 31;
        String[] strArr = this.nonUsernamePaths;
        if (strArr != null) {
            i2 = Arrays.hashCode(strArr);
        }
        return ((hashCode + i2) * 31) + this.maxMediaPerUpload;
    }

    public String toString() {
        List list;
        StringBuilder sb = new StringBuilder();
        sb.append("TwitterAPIConfigurationJSONImpl{photoSizeLimit=");
        sb.append(this.photoSizeLimit);
        sb.append(", shortURLLength=");
        sb.append(this.shortURLLength);
        sb.append(", shortURLLengthHttps=");
        sb.append(this.shortURLLengthHttps);
        sb.append(", charactersReservedPerMedia=");
        sb.append(this.charactersReservedPerMedia);
        sb.append(", dmTextCharacterLimit=");
        sb.append(this.dmTextCharacterLimit);
        sb.append(", photoSizes=");
        sb.append(this.photoSizes);
        sb.append(", nonUsernamePaths=");
        String[] strArr = this.nonUsernamePaths;
        if (strArr == null) {
            list = null;
        } else {
            list = Arrays.asList(strArr);
        }
        sb.append(list);
        sb.append(", maxMediaPerUpload=");
        sb.append(this.maxMediaPerUpload);
        sb.append('}');
        return sb.toString();
    }
}
