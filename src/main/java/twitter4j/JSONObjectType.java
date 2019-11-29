package twitter4j;

public final class JSONObjectType {
    private static final Logger logger = Logger.getLogger(JSONObjectType.class);

    public enum Type {
        SENDER,
        STATUS,
        DIRECT_MESSAGE,
        DELETE,
        LIMIT,
        STALL_WARNING,
        SCRUB_GEO,
        FRIENDS,
        FAVORITE,
        UNFAVORITE,
        FOLLOW,
        UNFOLLOW,
        USER_LIST_MEMBER_ADDED,
        USER_LIST_MEMBER_DELETED,
        USER_LIST_SUBSCRIBED,
        USER_LIST_UNSUBSCRIBED,
        USER_LIST_CREATED,
        USER_LIST_UPDATED,
        USER_LIST_DESTROYED,
        USER_UPDATE,
        USER_DELETE,
        USER_SUSPEND,
        BLOCK,
        UNBLOCK,
        DISCONNECTION,
        RETWEETED_RETWEET,
        FAVORITED_RETWEET,
        QUOTED_TWEET,
        UNKNOWN
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        logger.warn("Failed to get event element: ", r3.toString(2));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:113:0x013d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static twitter4j.JSONObjectType.Type determine(twitter4j.JSONObject r3) {
        /*
            java.lang.String r0 = "sender"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x000b
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.SENDER
            return r3
        L_0x000b:
            java.lang.String r0 = "text"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x0016
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.STATUS
            return r3
        L_0x0016:
            java.lang.String r0 = "direct_message"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x0021
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.DIRECT_MESSAGE
            return r3
        L_0x0021:
            java.lang.String r0 = "delete"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x002c
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.DELETE
            return r3
        L_0x002c:
            java.lang.String r0 = "limit"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x0037
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.LIMIT
            return r3
        L_0x0037:
            java.lang.String r0 = "warning"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x0042
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.STALL_WARNING
            return r3
        L_0x0042:
            java.lang.String r0 = "scrub_geo"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x004d
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.SCRUB_GEO
            return r3
        L_0x004d:
            java.lang.String r0 = "friends"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x0058
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.FRIENDS
            return r3
        L_0x0058:
            java.lang.String r0 = "event"
            boolean r1 = r3.isNull(r0)
            if (r1 != 0) goto L_0x014a
            java.lang.String r0 = r3.getString(r0)     // Catch:{ JSONException -> 0x013d }
            java.lang.String r1 = "favorite"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x006f
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.FAVORITE     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x006f:
            java.lang.String r1 = "unfavorite"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x007a
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.UNFAVORITE     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x007a:
            java.lang.String r1 = "follow"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x0085
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.FOLLOW     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x0085:
            java.lang.String r1 = "unfollow"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x0090
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.UNFOLLOW     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x0090:
            java.lang.String r1 = "list"
            boolean r1 = r0.startsWith(r1)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x00e5
            java.lang.String r1 = "list_member_added"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x00a3
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.USER_LIST_MEMBER_ADDED     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x00a3:
            java.lang.String r1 = "list_member_removed"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x00ae
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.USER_LIST_MEMBER_DELETED     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x00ae:
            java.lang.String r1 = "list_user_subscribed"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x00b9
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.USER_LIST_SUBSCRIBED     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x00b9:
            java.lang.String r1 = "list_user_unsubscribed"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x00c4
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.USER_LIST_UNSUBSCRIBED     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x00c4:
            java.lang.String r1 = "list_created"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x00cf
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.USER_LIST_CREATED     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x00cf:
            java.lang.String r1 = "list_updated"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x00da
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.USER_LIST_UPDATED     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x00da:
            java.lang.String r1 = "list_destroyed"
            boolean r0 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r0 == 0) goto L_0x0155
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.USER_LIST_DESTROYED     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x00e5:
            java.lang.String r1 = "user_update"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x00f0
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.USER_UPDATE     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x00f0:
            java.lang.String r1 = "user_delete"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x00fb
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.USER_DELETE     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x00fb:
            java.lang.String r1 = "user_suspend"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x0106
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.USER_SUSPEND     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x0106:
            java.lang.String r1 = "block"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x0111
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.BLOCK     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x0111:
            java.lang.String r1 = "unblock"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x011c
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.UNBLOCK     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x011c:
            java.lang.String r1 = "retweeted_retweet"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x0127
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.RETWEETED_RETWEET     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x0127:
            java.lang.String r1 = "favorited_retweet"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r1 == 0) goto L_0x0132
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.FAVORITED_RETWEET     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x0132:
            java.lang.String r1 = "quoted_tweet"
            boolean r0 = r1.equals(r0)     // Catch:{ JSONException -> 0x013d }
            if (r0 == 0) goto L_0x0155
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.QUOTED_TWEET     // Catch:{ JSONException -> 0x013d }
            return r3
        L_0x013d:
            twitter4j.Logger r0 = logger     // Catch:{ JSONException -> 0x0155 }
            java.lang.String r1 = "Failed to get event element: "
            r2 = 2
            java.lang.String r3 = r3.toString(r2)     // Catch:{ JSONException -> 0x0155 }
            r0.warn(r1, r3)     // Catch:{ JSONException -> 0x0155 }
            goto L_0x0155
        L_0x014a:
            java.lang.String r0 = "disconnect"
            boolean r3 = r3.isNull(r0)
            if (r3 != 0) goto L_0x0155
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.DISCONNECTION
            return r3
        L_0x0155:
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.UNKNOWN
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.JSONObjectType.determine(twitter4j.JSONObject):twitter4j.JSONObjectType$Type");
    }
}
