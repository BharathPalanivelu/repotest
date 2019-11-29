package twitter4j;

class UserMentionEntityJSONImpl extends EntityIndex implements UserMentionEntity {
    private static final long serialVersionUID = 6060510953676673013L;
    private long id;
    private String name;
    private String screenName;

    UserMentionEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    UserMentionEntityJSONImpl(int i, int i2, String str, String str2, long j) {
        setStart(i);
        setEnd(i2);
        this.name = str;
        this.screenName = str2;
        this.id = j;
    }

    UserMentionEntityJSONImpl() {
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            if (!jSONObject.isNull("name")) {
                this.name = jSONObject.getString("name");
            }
            if (!jSONObject.isNull("screen_name")) {
                this.screenName = jSONObject.getString("screen_name");
            }
            this.id = ParseUtil.getLong("id", jSONObject);
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public String getText() {
        return this.screenName;
    }

    public String getName() {
        return this.name;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public long getId() {
        return this.id;
    }

    public int getStart() {
        return super.getStart();
    }

    public int getEnd() {
        return super.getEnd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserMentionEntityJSONImpl userMentionEntityJSONImpl = (UserMentionEntityJSONImpl) obj;
        if (this.id != userMentionEntityJSONImpl.id) {
            return false;
        }
        String str = this.name;
        if (str == null ? userMentionEntityJSONImpl.name != null : !str.equals(userMentionEntityJSONImpl.name)) {
            return false;
        }
        String str2 = this.screenName;
        return str2 == null ? userMentionEntityJSONImpl.screenName == null : str2.equals(userMentionEntityJSONImpl.screenName);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.screenName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        long j = this.id;
        return ((hashCode + i) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "UserMentionEntityJSONImpl{name='" + this.name + '\'' + ", screenName='" + this.screenName + '\'' + ", id=" + this.id + '}';
    }
}
