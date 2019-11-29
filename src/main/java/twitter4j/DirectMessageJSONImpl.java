package twitter4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import twitter4j.conf.Configuration;

final class DirectMessageJSONImpl extends TwitterResponseImpl implements Serializable, DirectMessage {
    private static final long serialVersionUID = 7092906238192790921L;
    private Date createdAt;
    private HashtagEntity[] hashtagEntities;
    private long id;
    private MediaEntity[] mediaEntities;
    private User recipient;
    private long recipientId;
    private String recipientScreenName;
    private User sender;
    private long senderId;
    private String senderScreenName;
    private SymbolEntity[] symbolEntities;
    private String text;
    private URLEntity[] urlEntities;
    private UserMentionEntity[] userMentionEntities;

    DirectMessageJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        JSONObject asJSONObject = httpResponse.asJSONObject();
        init(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, asJSONObject);
        }
    }

    DirectMessageJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        this.id = ParseUtil.getLong("id", jSONObject);
        this.senderId = ParseUtil.getLong("sender_id", jSONObject);
        this.recipientId = ParseUtil.getLong("recipient_id", jSONObject);
        this.createdAt = ParseUtil.getDate("created_at", jSONObject);
        this.senderScreenName = ParseUtil.getUnescapedString("sender_screen_name", jSONObject);
        this.recipientScreenName = ParseUtil.getUnescapedString("recipient_screen_name", jSONObject);
        try {
            this.sender = new UserJSONImpl(jSONObject.getJSONObject("sender"));
            this.recipient = new UserJSONImpl(jSONObject.getJSONObject("recipient"));
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
            this.userMentionEntities = this.userMentionEntities == null ? new UserMentionEntity[0] : this.userMentionEntities;
            this.urlEntities = this.urlEntities == null ? new URLEntity[0] : this.urlEntities;
            this.hashtagEntities = this.hashtagEntities == null ? new HashtagEntity[0] : this.hashtagEntities;
            this.symbolEntities = this.symbolEntities == null ? new SymbolEntity[0] : this.symbolEntities;
            this.mediaEntities = this.mediaEntities == null ? new MediaEntity[0] : this.mediaEntities;
            this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject.getString("text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public long getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public long getSenderId() {
        return this.senderId;
    }

    public long getRecipientId() {
        return this.recipientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getSenderScreenName() {
        return this.senderScreenName;
    }

    public String getRecipientScreenName() {
        return this.recipientScreenName;
    }

    public User getSender() {
        return this.sender;
    }

    public User getRecipient() {
        return this.recipient;
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

    static ResponseList<DirectMessage> createDirectMessageList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray asJSONArray = httpResponse.asJSONArray();
            int length = asJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                DirectMessageJSONImpl directMessageJSONImpl = new DirectMessageJSONImpl(jSONObject);
                responseListImpl.add(directMessageJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(directMessageJSONImpl, jSONObject);
                }
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
        return (obj instanceof DirectMessage) && ((DirectMessage) obj).getId() == this.id;
    }

    public String toString() {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        StringBuilder sb = new StringBuilder();
        sb.append("DirectMessageJSONImpl{id=");
        sb.append(this.id);
        sb.append(", text='");
        sb.append(this.text);
        sb.append('\'');
        sb.append(", sender_id=");
        sb.append(this.senderId);
        sb.append(", recipient_id=");
        sb.append(this.recipientId);
        sb.append(", created_at=");
        sb.append(this.createdAt);
        sb.append(", userMentionEntities=");
        UserMentionEntity[] userMentionEntityArr = this.userMentionEntities;
        List list6 = null;
        if (userMentionEntityArr == null) {
            list = null;
        } else {
            list = Arrays.asList(userMentionEntityArr);
        }
        sb.append(list);
        sb.append(", urlEntities=");
        URLEntity[] uRLEntityArr = this.urlEntities;
        if (uRLEntityArr == null) {
            list2 = null;
        } else {
            list2 = Arrays.asList(uRLEntityArr);
        }
        sb.append(list2);
        sb.append(", hashtagEntities=");
        HashtagEntity[] hashtagEntityArr = this.hashtagEntities;
        if (hashtagEntityArr == null) {
            list3 = null;
        } else {
            list3 = Arrays.asList(hashtagEntityArr);
        }
        sb.append(list3);
        sb.append(", sender_screen_name='");
        sb.append(this.senderScreenName);
        sb.append('\'');
        sb.append(", recipient_screen_name='");
        sb.append(this.recipientScreenName);
        sb.append('\'');
        sb.append(", sender=");
        sb.append(this.sender);
        sb.append(", recipient=");
        sb.append(this.recipient);
        sb.append(", userMentionEntities=");
        UserMentionEntity[] userMentionEntityArr2 = this.userMentionEntities;
        if (userMentionEntityArr2 == null) {
            list4 = null;
        } else {
            list4 = Arrays.asList(userMentionEntityArr2);
        }
        sb.append(list4);
        sb.append(", urlEntities=");
        URLEntity[] uRLEntityArr2 = this.urlEntities;
        if (uRLEntityArr2 == null) {
            list5 = null;
        } else {
            list5 = Arrays.asList(uRLEntityArr2);
        }
        sb.append(list5);
        sb.append(", hashtagEntities=");
        HashtagEntity[] hashtagEntityArr2 = this.hashtagEntities;
        if (hashtagEntityArr2 != null) {
            list6 = Arrays.asList(hashtagEntityArr2);
        }
        sb.append(list6);
        sb.append('}');
        return sb.toString();
    }
}
