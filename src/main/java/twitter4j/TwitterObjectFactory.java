package twitter4j;

import java.util.HashMap;
import java.util.Map;

public final class TwitterObjectFactory {
    private static final ThreadLocal<Map> rawJsonMap = new ThreadLocal<Map>() {
        /* access modifiers changed from: protected */
        public Map initialValue() {
            return new HashMap();
        }
    };
    private static boolean registeredAtleastOnce = false;

    private TwitterObjectFactory() {
        throw new AssertionError("not intended to be instantiated.");
    }

    public static String getRawJSON(Object obj) {
        if (registeredAtleastOnce) {
            Object obj2 = rawJsonMap.get().get(obj);
            if (obj2 instanceof String) {
                return (String) obj2;
            }
            if (obj2 != null) {
                return obj2.toString();
            }
            return null;
        }
        throw new IllegalStateException("Apparently jsonStoreEnabled is not set to true.");
    }

    public static Status createStatus(String str) throws TwitterException {
        try {
            return new StatusJSONImpl(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static User createUser(String str) throws TwitterException {
        try {
            return new UserJSONImpl(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static AccountTotals createAccountTotals(String str) throws TwitterException {
        try {
            return new AccountTotalsJSONImpl(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static Relationship createRelationship(String str) throws TwitterException {
        try {
            return new RelationshipJSONImpl(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static Place createPlace(String str) throws TwitterException {
        try {
            return new PlaceJSONImpl(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static SavedSearch createSavedSearch(String str) throws TwitterException {
        try {
            return new SavedSearchJSONImpl(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static Trend createTrend(String str) throws TwitterException {
        try {
            return new TrendJSONImpl(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static Trends createTrends(String str) throws TwitterException {
        return new TrendsJSONImpl(str);
    }

    public static IDs createIDs(String str) throws TwitterException {
        return new IDsJSONImpl(str);
    }

    public static Map<String, RateLimitStatus> createRateLimitStatus(String str) throws TwitterException {
        try {
            return RateLimitStatusJSONImpl.createRateLimitStatuses(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static Category createCategory(String str) throws TwitterException {
        try {
            return new CategoryJSONImpl(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static DirectMessage createDirectMessage(String str) throws TwitterException {
        try {
            return new DirectMessageJSONImpl(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static Location createLocation(String str) throws TwitterException {
        try {
            return new LocationJSONImpl(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static UserList createUserList(String str) throws TwitterException {
        try {
            return new UserListJSONImpl(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static OEmbed createOEmbed(String str) throws TwitterException {
        try {
            return new OEmbedJSONImpl(new JSONObject(str));
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public static Object createObject(String str) throws TwitterException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            switch (JSONObjectType.determine(jSONObject)) {
                case SENDER:
                    return registerJSONObject(new DirectMessageJSONImpl(jSONObject.getJSONObject("direct_message")), jSONObject);
                case STATUS:
                    return registerJSONObject(new StatusJSONImpl(jSONObject), jSONObject);
                case DIRECT_MESSAGE:
                    return registerJSONObject(new DirectMessageJSONImpl(jSONObject.getJSONObject("direct_message")), jSONObject);
                case DELETE:
                    return registerJSONObject(new StatusDeletionNoticeImpl(jSONObject.getJSONObject("delete").getJSONObject("status")), jSONObject);
                default:
                    return jSONObject;
            }
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
        throw new TwitterException((Exception) e2);
    }

    static void clearThreadLocalMap() {
        rawJsonMap.get().clear();
    }

    static <T> T registerJSONObject(T t, Object obj) {
        registeredAtleastOnce = true;
        rawJsonMap.get().put(t, obj);
        return t;
    }
}
