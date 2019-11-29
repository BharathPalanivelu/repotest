package twitter4j;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.facebook.share.internal.ShareConstants;
import java.io.Serializable;
import twitter4j.conf.Configuration;

class RelationshipJSONImpl extends TwitterResponseImpl implements Serializable, Relationship {
    private static final long serialVersionUID = -2001484553401916448L;
    private final boolean sourceBlockingTarget;
    private final boolean sourceCanDm;
    private final boolean sourceFollowedByTarget;
    private final boolean sourceFollowingTarget;
    private final boolean sourceMutingTarget;
    private final boolean sourceNotificationsEnabled;
    private final long sourceUserId;
    private final String sourceUserScreenName;
    private final long targetUserId;
    private final String targetUserScreenName;
    private boolean wantRetweets;

    RelationshipJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        this(httpResponse, httpResponse.asJSONObject());
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, httpResponse.asJSONObject());
        }
    }

    RelationshipJSONImpl(JSONObject jSONObject) throws TwitterException {
        this((HttpResponse) null, jSONObject);
    }

    RelationshipJSONImpl(HttpResponse httpResponse, JSONObject jSONObject) throws TwitterException {
        super(httpResponse);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("relationship");
            JSONObject jSONObject3 = jSONObject2.getJSONObject(ShareConstants.FEED_SOURCE_PARAM);
            JSONObject jSONObject4 = jSONObject2.getJSONObject(TouchesHelper.TARGET_KEY);
            this.sourceUserId = ParseUtil.getLong("id", jSONObject3);
            this.targetUserId = ParseUtil.getLong("id", jSONObject4);
            this.sourceUserScreenName = ParseUtil.getUnescapedString("screen_name", jSONObject3);
            this.targetUserScreenName = ParseUtil.getUnescapedString("screen_name", jSONObject4);
            this.sourceBlockingTarget = ParseUtil.getBoolean("blocking", jSONObject3);
            this.sourceFollowingTarget = ParseUtil.getBoolean("following", jSONObject3);
            this.sourceFollowedByTarget = ParseUtil.getBoolean("followed_by", jSONObject3);
            this.sourceCanDm = ParseUtil.getBoolean("can_dm", jSONObject3);
            this.sourceMutingTarget = ParseUtil.getBoolean("muting", jSONObject3);
            this.sourceNotificationsEnabled = ParseUtil.getBoolean("notifications_enabled", jSONObject3);
            this.wantRetweets = ParseUtil.getBoolean("want_retweets", jSONObject3);
        } catch (JSONException e2) {
            throw new TwitterException(e2.getMessage() + ":" + jSONObject.toString(), (Throwable) e2);
        }
    }

    static ResponseList<Relationship> createRelationshipList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray asJSONArray = httpResponse.asJSONArray();
            int length = asJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                RelationshipJSONImpl relationshipJSONImpl = new RelationshipJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(relationshipJSONImpl, jSONObject);
                }
                responseListImpl.add(relationshipJSONImpl);
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, asJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public long getSourceUserId() {
        return this.sourceUserId;
    }

    public long getTargetUserId() {
        return this.targetUserId;
    }

    public boolean isSourceBlockingTarget() {
        return this.sourceBlockingTarget;
    }

    public String getSourceUserScreenName() {
        return this.sourceUserScreenName;
    }

    public String getTargetUserScreenName() {
        return this.targetUserScreenName;
    }

    public boolean isSourceFollowingTarget() {
        return this.sourceFollowingTarget;
    }

    public boolean isTargetFollowingSource() {
        return this.sourceFollowedByTarget;
    }

    public boolean isSourceFollowedByTarget() {
        return this.sourceFollowedByTarget;
    }

    public boolean isTargetFollowedBySource() {
        return this.sourceFollowingTarget;
    }

    public boolean canSourceDm() {
        return this.sourceCanDm;
    }

    public boolean isSourceMutingTarget() {
        return this.sourceMutingTarget;
    }

    public boolean isSourceNotificationsEnabled() {
        return this.sourceNotificationsEnabled;
    }

    public boolean isSourceWantRetweets() {
        return this.wantRetweets;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RelationshipJSONImpl relationshipJSONImpl = (RelationshipJSONImpl) obj;
        if (this.sourceBlockingTarget != relationshipJSONImpl.sourceBlockingTarget || this.sourceCanDm != relationshipJSONImpl.sourceCanDm || this.sourceFollowedByTarget != relationshipJSONImpl.sourceFollowedByTarget || this.sourceFollowingTarget != relationshipJSONImpl.sourceFollowingTarget || this.sourceMutingTarget != relationshipJSONImpl.sourceMutingTarget || this.sourceNotificationsEnabled != relationshipJSONImpl.sourceNotificationsEnabled || this.sourceUserId != relationshipJSONImpl.sourceUserId || this.targetUserId != relationshipJSONImpl.targetUserId || this.wantRetweets != relationshipJSONImpl.wantRetweets) {
            return false;
        }
        String str = this.sourceUserScreenName;
        if (str == null ? relationshipJSONImpl.sourceUserScreenName != null : !str.equals(relationshipJSONImpl.sourceUserScreenName)) {
            return false;
        }
        String str2 = this.targetUserScreenName;
        return str2 == null ? relationshipJSONImpl.targetUserScreenName == null : str2.equals(relationshipJSONImpl.targetUserScreenName);
    }

    public int hashCode() {
        long j = this.targetUserId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.targetUserScreenName;
        int i2 = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.sourceUserId;
        int i3 = (((((((((((((((i + hashCode) * 31) + (this.sourceBlockingTarget ? 1 : 0)) * 31) + (this.sourceNotificationsEnabled ? 1 : 0)) * 31) + (this.sourceFollowingTarget ? 1 : 0)) * 31) + (this.sourceFollowedByTarget ? 1 : 0)) * 31) + (this.sourceCanDm ? 1 : 0)) * 31) + (this.sourceMutingTarget ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str2 = this.sourceUserScreenName;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((i3 + i2) * 31) + (this.wantRetweets ? 1 : 0);
    }

    public String toString() {
        return "RelationshipJSONImpl{targetUserId=" + this.targetUserId + ", targetUserScreenName='" + this.targetUserScreenName + '\'' + ", sourceBlockingTarget=" + this.sourceBlockingTarget + ", sourceNotificationsEnabled=" + this.sourceNotificationsEnabled + ", sourceFollowingTarget=" + this.sourceFollowingTarget + ", sourceFollowedByTarget=" + this.sourceFollowedByTarget + ", sourceCanDm=" + this.sourceCanDm + ", sourceMutingTarget=" + this.sourceMutingTarget + ", sourceUserId=" + this.sourceUserId + ", sourceUserScreenName='" + this.sourceUserScreenName + '\'' + ", wantRetweets=" + this.wantRetweets + '}';
    }
}
