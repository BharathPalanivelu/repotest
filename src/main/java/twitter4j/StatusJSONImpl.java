package twitter4j;

import com.facebook.share.internal.ShareConstants;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import twitter4j.conf.Configuration;

final class StatusJSONImpl extends TwitterResponseImpl implements Serializable, Status {
    private static final Logger logger = Logger.getLogger(StatusJSONImpl.class);
    private static final long serialVersionUID = -6461195536943679985L;
    private long[] contributorsIDs;
    private Date createdAt;
    private long currentUserRetweetId = -1;
    private int displayTextRangeEnd = -1;
    private int displayTextRangeStart = -1;
    private int favoriteCount;
    private GeoLocation geoLocation = null;
    private HashtagEntity[] hashtagEntities;
    private long id;
    private String inReplyToScreenName;
    private long inReplyToStatusId;
    private long inReplyToUserId;
    private boolean isFavorited;
    private boolean isPossiblySensitive;
    private boolean isRetweeted;
    private boolean isTruncated;
    private String lang;
    private MediaEntity[] mediaEntities;
    private Place place = null;
    private Status quotedStatus;
    private long quotedStatusId = -1;
    private long retweetCount;
    private Status retweetedStatus;
    private Scopes scopes;
    private String source;
    private SymbolEntity[] symbolEntities;
    private String text;
    private URLEntity[] urlEntities;
    private User user = null;
    private UserMentionEntity[] userMentionEntities;
    private String[] withheldInCountries = null;

    StatusJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        JSONObject asJSONObject = httpResponse.asJSONObject();
        init(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, asJSONObject);
        }
    }

    StatusJSONImpl(JSONObject jSONObject, Configuration configuration) throws TwitterException {
        init(jSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.registerJSONObject(this, jSONObject);
        }
    }

    StatusJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    StatusJSONImpl() {
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        JSONObject jSONObject2 = jSONObject;
        String str = "lang";
        String str2 = "current_user_retweet";
        this.id = ParseUtil.getLong("id", jSONObject2);
        this.source = ParseUtil.getUnescapedString(ShareConstants.FEED_SOURCE_PARAM, jSONObject2);
        this.createdAt = ParseUtil.getDate("created_at", jSONObject2);
        this.isTruncated = ParseUtil.getBoolean("truncated", jSONObject2);
        this.inReplyToStatusId = ParseUtil.getLong("in_reply_to_status_id", jSONObject2);
        this.inReplyToUserId = ParseUtil.getLong("in_reply_to_user_id", jSONObject2);
        this.isFavorited = ParseUtil.getBoolean("favorited", jSONObject2);
        this.isRetweeted = ParseUtil.getBoolean("retweeted", jSONObject2);
        this.inReplyToScreenName = ParseUtil.getUnescapedString("in_reply_to_screen_name", jSONObject2);
        this.retweetCount = ParseUtil.getLong("retweet_count", jSONObject2);
        this.favoriteCount = ParseUtil.getInt("favorite_count", jSONObject2);
        this.isPossiblySensitive = ParseUtil.getBoolean("possibly_sensitive", jSONObject2);
        try {
            if (!jSONObject2.isNull("user")) {
                this.user = new UserJSONImpl(jSONObject2.getJSONObject("user"));
            }
            this.geoLocation = JSONImplFactory.createGeoLocation(jSONObject);
            if (!jSONObject2.isNull("place")) {
                this.place = new PlaceJSONImpl(jSONObject2.getJSONObject("place"));
            }
            if (!jSONObject2.isNull("retweeted_status")) {
                this.retweetedStatus = new StatusJSONImpl(jSONObject2.getJSONObject("retweeted_status"));
            }
            if (!jSONObject2.isNull("contributors")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("contributors");
                this.contributorsIDs = new long[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.contributorsIDs[i] = Long.parseLong(jSONArray.getString(i));
                }
            } else {
                this.contributorsIDs = new long[0];
            }
            collectEntities(jSONObject);
            mergeExtendedEntities(jSONObject);
            if (!jSONObject2.isNull("quoted_status")) {
                this.quotedStatus = new StatusJSONImpl(jSONObject2.getJSONObject("quoted_status"));
            }
            if (!jSONObject2.isNull("quoted_status_id")) {
                this.quotedStatusId = ParseUtil.getLong("quoted_status_id", jSONObject2);
            }
            if (!jSONObject2.isNull("display_text_range")) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("display_text_range");
                this.displayTextRangeStart = jSONArray2.getInt(0);
                this.displayTextRangeEnd = jSONArray2.getInt(1);
            }
            this.userMentionEntities = this.userMentionEntities == null ? new UserMentionEntity[0] : this.userMentionEntities;
            this.urlEntities = this.urlEntities == null ? new URLEntity[0] : this.urlEntities;
            this.hashtagEntities = this.hashtagEntities == null ? new HashtagEntity[0] : this.hashtagEntities;
            this.symbolEntities = this.symbolEntities == null ? new SymbolEntity[0] : this.symbolEntities;
            this.mediaEntities = this.mediaEntities == null ? new MediaEntity[0] : this.mediaEntities;
            if (!jSONObject2.isNull("text")) {
                this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject2.getString("text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
            }
            if (!jSONObject2.isNull("full_text")) {
                this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject2.getString("full_text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
            }
            if (!jSONObject2.isNull("extended_tweet")) {
                mergeExtendedTweet(jSONObject2.getJSONObject("extended_tweet"));
            }
            String str3 = str2;
            if (!jSONObject2.isNull(str3)) {
                this.currentUserRetweetId = jSONObject2.getJSONObject(str3).getLong("id");
            }
            String str4 = str;
            if (!jSONObject2.isNull(str4)) {
                this.lang = ParseUtil.getUnescapedString(str4, jSONObject2);
            }
            if (!jSONObject2.isNull("scopes")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("scopes");
                if (!jSONObject3.isNull("place_ids")) {
                    JSONArray jSONArray3 = jSONObject3.getJSONArray("place_ids");
                    int length = jSONArray3.length();
                    String[] strArr = new String[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        strArr[i2] = jSONArray3.getString(i2);
                    }
                    this.scopes = new ScopesImpl(strArr);
                }
            }
            if (!jSONObject2.isNull("withheld_in_countries")) {
                JSONArray jSONArray4 = jSONObject2.getJSONArray("withheld_in_countries");
                int length2 = jSONArray4.length();
                this.withheldInCountries = new String[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    this.withheldInCountries[i3] = jSONArray4.getString(i3);
                }
            }
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    private void collectEntities(JSONObject jSONObject) throws JSONException, TwitterException {
        if (!jSONObject.isNull("entities")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("entities");
            if (!jSONObject2.isNull("user_mentions")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("user_mentions");
                int length = jSONArray.length();
                this.userMentionEntities = new UserMentionEntity[length];
                for (int i = 0; i < length; i++) {
                    this.userMentionEntities[i] = new UserMentionEntityJSONImpl(jSONArray.getJSONObject(i));
                }
            }
            if (!jSONObject2.isNull("urls")) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("urls");
                int length2 = jSONArray2.length();
                this.urlEntities = new URLEntity[length2];
                for (int i2 = 0; i2 < length2; i2++) {
                    this.urlEntities[i2] = new URLEntityJSONImpl(jSONArray2.getJSONObject(i2));
                }
            }
            if (!jSONObject2.isNull("hashtags")) {
                JSONArray jSONArray3 = jSONObject2.getJSONArray("hashtags");
                int length3 = jSONArray3.length();
                this.hashtagEntities = new HashtagEntity[length3];
                for (int i3 = 0; i3 < length3; i3++) {
                    this.hashtagEntities[i3] = new HashtagEntityJSONImpl(jSONArray3.getJSONObject(i3));
                }
            }
            if (!jSONObject2.isNull("symbols")) {
                JSONArray jSONArray4 = jSONObject2.getJSONArray("symbols");
                int length4 = jSONArray4.length();
                this.symbolEntities = new SymbolEntity[length4];
                for (int i4 = 0; i4 < length4; i4++) {
                    this.symbolEntities[i4] = new HashtagEntityJSONImpl(jSONArray4.getJSONObject(i4));
                }
            }
            if (!jSONObject2.isNull("media")) {
                JSONArray jSONArray5 = jSONObject2.getJSONArray("media");
                int length5 = jSONArray5.length();
                this.mediaEntities = new MediaEntity[length5];
                for (int i5 = 0; i5 < length5; i5++) {
                    this.mediaEntities[i5] = new MediaEntityJSONImpl(jSONArray5.getJSONObject(i5));
                }
            }
        }
    }

    private void mergeExtendedEntities(JSONObject jSONObject) throws JSONException, TwitterException {
        if (!jSONObject.isNull("extended_entities")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("extended_entities");
            if (!jSONObject2.isNull("media")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("media");
                int length = jSONArray.length();
                this.mediaEntities = new MediaEntity[length];
                for (int i = 0; i < length; i++) {
                    this.mediaEntities[i] = new MediaEntityJSONImpl(jSONArray.getJSONObject(i));
                }
            }
        }
    }

    private void mergeExtendedTweet(JSONObject jSONObject) throws TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("display_text_range");
            this.displayTextRangeStart = jSONArray.getInt(0);
            this.displayTextRangeEnd = jSONArray.getInt(1);
            collectEntities(jSONObject);
            this.userMentionEntities = this.userMentionEntities == null ? new UserMentionEntity[0] : this.userMentionEntities;
            this.urlEntities = this.urlEntities == null ? new URLEntity[0] : this.urlEntities;
            this.hashtagEntities = this.hashtagEntities == null ? new HashtagEntity[0] : this.hashtagEntities;
            this.symbolEntities = this.symbolEntities == null ? new SymbolEntity[0] : this.symbolEntities;
            this.mediaEntities = this.mediaEntities == null ? new MediaEntity[0] : this.mediaEntities;
            this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject.getString("full_text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public int compareTo(Status status) {
        long id2 = this.id - status.getId();
        if (id2 < -2147483648L) {
            return RNCartPanelDataEntity.NULL_VALUE;
        }
        if (id2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) id2;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public long getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public int getDisplayTextRangeStart() {
        return this.displayTextRangeStart;
    }

    public int getDisplayTextRangeEnd() {
        return this.displayTextRangeEnd;
    }

    public String getSource() {
        return this.source;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public long getInReplyToStatusId() {
        return this.inReplyToStatusId;
    }

    public long getInReplyToUserId() {
        return this.inReplyToUserId;
    }

    public String getInReplyToScreenName() {
        return this.inReplyToScreenName;
    }

    public GeoLocation getGeoLocation() {
        return this.geoLocation;
    }

    public Place getPlace() {
        return this.place;
    }

    public long[] getContributors() {
        return this.contributorsIDs;
    }

    public boolean isFavorited() {
        return this.isFavorited;
    }

    public boolean isRetweeted() {
        return this.isRetweeted;
    }

    public int getFavoriteCount() {
        return this.favoriteCount;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isRetweet() {
        return this.retweetedStatus != null;
    }

    public Status getRetweetedStatus() {
        return this.retweetedStatus;
    }

    public int getRetweetCount() {
        return (int) this.retweetCount;
    }

    public boolean isRetweetedByMe() {
        return this.currentUserRetweetId != -1;
    }

    public long getCurrentUserRetweetId() {
        return this.currentUserRetweetId;
    }

    public boolean isPossiblySensitive() {
        return this.isPossiblySensitive;
    }

    public UserMentionEntity[] getUserMentionEntities() {
        return this.userMentionEntities;
    }

    public URLEntity[] getURLEntities() {
        return this.urlEntities;
    }

    public HashtagEntity[] getHashtagEntities() {
        return this.hashtagEntities;
    }

    public MediaEntity[] getMediaEntities() {
        return this.mediaEntities;
    }

    public SymbolEntity[] getSymbolEntities() {
        return this.symbolEntities;
    }

    public Scopes getScopes() {
        return this.scopes;
    }

    public String[] getWithheldInCountries() {
        return this.withheldInCountries;
    }

    public long getQuotedStatusId() {
        return this.quotedStatusId;
    }

    public Status getQuotedStatus() {
        return this.quotedStatus;
    }

    public String getLang() {
        return this.lang;
    }

    static ResponseList<Status> createStatusList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray asJSONArray = httpResponse.asJSONArray();
            int length = asJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                StatusJSONImpl statusJSONImpl = new StatusJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(statusJSONImpl, jSONObject);
                }
                responseListImpl.add(statusJSONImpl);
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, asJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public int hashCode() {
        return (int) this.id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof Status) && ((Status) obj).getId() == this.id;
    }

    public String toString() {
        return "StatusJSONImpl{createdAt=" + this.createdAt + ", id=" + this.id + ", text='" + this.text + '\'' + ", source='" + this.source + '\'' + ", isTruncated=" + this.isTruncated + ", inReplyToStatusId=" + this.inReplyToStatusId + ", inReplyToUserId=" + this.inReplyToUserId + ", isFavorited=" + this.isFavorited + ", isRetweeted=" + this.isRetweeted + ", favoriteCount=" + this.favoriteCount + ", inReplyToScreenName='" + this.inReplyToScreenName + '\'' + ", geoLocation=" + this.geoLocation + ", place=" + this.place + ", retweetCount=" + this.retweetCount + ", isPossiblySensitive=" + this.isPossiblySensitive + ", lang='" + this.lang + '\'' + ", contributorsIDs=" + Arrays.toString(this.contributorsIDs) + ", retweetedStatus=" + this.retweetedStatus + ", userMentionEntities=" + Arrays.toString(this.userMentionEntities) + ", urlEntities=" + Arrays.toString(this.urlEntities) + ", hashtagEntities=" + Arrays.toString(this.hashtagEntities) + ", mediaEntities=" + Arrays.toString(this.mediaEntities) + ", symbolEntities=" + Arrays.toString(this.symbolEntities) + ", currentUserRetweetId=" + this.currentUserRetweetId + ", user=" + this.user + ", withHeldInCountries=" + Arrays.toString(this.withheldInCountries) + ", quotedStatusId=" + this.quotedStatusId + ", quotedStatus=" + this.quotedStatus + '}';
    }
}
