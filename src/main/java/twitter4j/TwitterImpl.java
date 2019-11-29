package twitter4j;

import com.facebook.AccessToken;
import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.actions.SearchIntents;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import twitter4j.api.DirectMessagesResources;
import twitter4j.api.FavoritesResources;
import twitter4j.api.FriendsFollowersResources;
import twitter4j.api.HelpResources;
import twitter4j.api.ListsResources;
import twitter4j.api.PlacesGeoResources;
import twitter4j.api.SavedSearchesResources;
import twitter4j.api.SearchResource;
import twitter4j.api.SpamReportingResource;
import twitter4j.api.SuggestedUsersResources;
import twitter4j.api.TimelinesResources;
import twitter4j.api.TrendsResources;
import twitter4j.api.TweetsResources;
import twitter4j.api.UsersResources;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;

class TwitterImpl extends TwitterBaseImpl implements Twitter {
    private static final ConcurrentHashMap<Configuration, HttpParameter[]> implicitParamsMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Configuration, String> implicitParamsStrMap = new ConcurrentHashMap<>();
    private static final long serialVersionUID = 9170943084096085770L;
    private final HttpParameter[] IMPLICIT_PARAMS;
    private final String IMPLICIT_PARAMS_STR;
    private final HttpParameter INCLUDE_MY_RETWEET;

    public DirectMessagesResources directMessages() {
        return this;
    }

    public FavoritesResources favorites() {
        return this;
    }

    public FriendsFollowersResources friendsFollowers() {
        return this;
    }

    public HelpResources help() {
        return this;
    }

    public ListsResources list() {
        return this;
    }

    public PlacesGeoResources placesGeo() {
        return this;
    }

    public SavedSearchesResources savedSearches() {
        return this;
    }

    public SearchResource search() {
        return this;
    }

    public SpamReportingResource spamReporting() {
        return this;
    }

    public SuggestedUsersResources suggestedUsers() {
        return this;
    }

    public TimelinesResources timelines() {
        return this;
    }

    public TrendsResources trends() {
        return this;
    }

    public TweetsResources tweets() {
        return this;
    }

    public UsersResources users() {
        return this;
    }

    TwitterImpl(Configuration configuration, Authorization authorization) {
        super(configuration, authorization);
        this.INCLUDE_MY_RETWEET = new HttpParameter("include_my_retweet", configuration.isIncludeMyRetweetEnabled());
        if (implicitParamsMap.containsKey(configuration)) {
            this.IMPLICIT_PARAMS = implicitParamsMap.get(configuration);
            this.IMPLICIT_PARAMS_STR = implicitParamsStrMap.get(configuration);
            return;
        }
        String str = configuration.isIncludeEntitiesEnabled() ? "include_entities=true" : "";
        boolean z = configuration.getContributingTo() != -1;
        if (z) {
            if (!"".equals(str)) {
                str = str + "&";
            }
            str = str + "contributingto=" + configuration.getContributingTo();
        }
        if (configuration.isTweetModeExtended()) {
            if (!"".equals(str)) {
                str = str + "&";
            }
            str = str + "tweet_mode=extended";
        }
        ArrayList arrayList = new ArrayList(3);
        if (configuration.isIncludeEntitiesEnabled()) {
            arrayList.add(new HttpParameter("include_entities", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        }
        if (z) {
            arrayList.add(new HttpParameter("contributingto", configuration.getContributingTo()));
        }
        if (configuration.isTrimUserEnabled()) {
            arrayList.add(new HttpParameter("trim_user", "1"));
        }
        if (configuration.isIncludeExtAltTextEnabled()) {
            arrayList.add(new HttpParameter("include_ext_alt_text", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        }
        if (configuration.isTweetModeExtended()) {
            arrayList.add(new HttpParameter("tweet_mode", "extended"));
        }
        HttpParameter[] httpParameterArr = (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
        implicitParamsStrMap.putIfAbsent(configuration, str);
        implicitParamsMap.putIfAbsent(configuration, httpParameterArr);
        this.IMPLICIT_PARAMS = httpParameterArr;
        this.IMPLICIT_PARAMS_STR = str;
    }

    public ResponseList<Status> getMentionsTimeline() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/mentions_timeline.json"));
    }

    public ResponseList<Status> getMentionsTimeline(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/mentions_timeline.json", paging.asPostParameterArray()));
    }

    public ResponseList<Status> getHomeTimeline() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/home_timeline.json", this.INCLUDE_MY_RETWEET));
    }

    public ResponseList<Status> getHomeTimeline(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/home_timeline.json", mergeParameters(paging.asPostParameterArray(), new HttpParameter[]{this.INCLUDE_MY_RETWEET})));
    }

    public ResponseList<Status> getRetweetsOfMe() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/retweets_of_me.json"));
    }

    public ResponseList<Status> getRetweetsOfMe(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/retweets_of_me.json", paging.asPostParameterArray()));
    }

    public ResponseList<Status> getUserTimeline(String str, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/user_timeline.json", mergeParameters(new HttpParameter[]{new HttpParameter("screen_name", str), this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    public ResponseList<Status> getUserTimeline(long j, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/user_timeline.json", mergeParameters(new HttpParameter[]{new HttpParameter((String) AccessToken.USER_ID_KEY, j), this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    public ResponseList<Status> getUserTimeline(String str) throws TwitterException {
        return getUserTimeline(str, new Paging());
    }

    public ResponseList<Status> getUserTimeline(long j) throws TwitterException {
        return getUserTimeline(j, new Paging());
    }

    public ResponseList<Status> getUserTimeline() throws TwitterException {
        return getUserTimeline(new Paging());
    }

    public ResponseList<Status> getUserTimeline(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/user_timeline.json", mergeParameters(new HttpParameter[]{this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    public ResponseList<Status> getRetweets(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/retweets/" + j + ".json?count=100"));
    }

    public IDs getRetweeterIds(long j, long j2) throws TwitterException {
        return getRetweeterIds(j, 100, j2);
    }

    public IDs getRetweeterIds(long j, int i, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "statuses/retweeters/ids.json?id=" + j + "&cursor=" + j2 + "&count=" + i));
    }

    public Status showStatus(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatus(get(this.conf.getRestBaseURL() + "statuses/show/" + j + ".json", this.INCLUDE_MY_RETWEET));
    }

    public Status destroyStatus(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatus(post(this.conf.getRestBaseURL() + "statuses/destroy/" + j + ".json"));
    }

    public Status updateStatus(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatus(post(this.conf.getRestBaseURL() + "statuses/update.json", new HttpParameter("status", str)));
    }

    public Status updateStatus(StatusUpdate statusUpdate) throws TwitterException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append(statusUpdate.isForUpdateWithMedia() ? "statuses/update_with_media.json" : "statuses/update.json");
        return this.factory.createStatus(post(sb.toString(), statusUpdate.asHttpParameterArray()));
    }

    public Status retweetStatus(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatus(post(this.conf.getRestBaseURL() + "statuses/retweet/" + j + ".json"));
    }

    public OEmbed getOEmbed(OEmbedRequest oEmbedRequest) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createOEmbed(get(this.conf.getRestBaseURL() + "statuses/oembed.json", oEmbedRequest.asHttpParameterArray()));
    }

    public ResponseList<Status> lookup(long... jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/lookup.json?id=" + StringUtil.join(jArr)));
    }

    public UploadedMedia uploadMedia(File file) throws TwitterException {
        checkFileValidity(file);
        return new UploadedMedia(post(this.conf.getUploadBaseURL() + "media/upload.json", new HttpParameter("media", file)).asJSONObject());
    }

    public UploadedMedia uploadMedia(String str, InputStream inputStream) throws TwitterException {
        return new UploadedMedia(post(this.conf.getUploadBaseURL() + "media/upload.json", new HttpParameter("media", str, inputStream)).asJSONObject());
    }

    public QueryResult search(Query query) throws TwitterException {
        if (query.nextPage() != null) {
            ObjectFactory objectFactory = this.factory;
            return objectFactory.createQueryResult(get(this.conf.getRestBaseURL() + "search/tweets.json" + query.nextPage()), query);
        }
        ObjectFactory objectFactory2 = this.factory;
        return objectFactory2.createQueryResult(get(this.conf.getRestBaseURL() + "search/tweets.json", query.asHttpParameterArray()), query);
    }

    public ResponseList<DirectMessage> getDirectMessages() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createDirectMessageList(get(this.conf.getRestBaseURL() + "direct_messages.json?full_text=true"));
    }

    public ResponseList<DirectMessage> getDirectMessages(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createDirectMessageList(get(this.conf.getRestBaseURL() + "direct_messages.json", mergeParameters(paging.asPostParameterArray(), new HttpParameter("full_text", true))));
    }

    public ResponseList<DirectMessage> getSentDirectMessages() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createDirectMessageList(get(this.conf.getRestBaseURL() + "direct_messages/sent.json?full_text=true"));
    }

    public ResponseList<DirectMessage> getSentDirectMessages(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createDirectMessageList(get(this.conf.getRestBaseURL() + "direct_messages/sent.json", mergeParameters(paging.asPostParameterArray(), new HttpParameter("full_text", true))));
    }

    public DirectMessage showDirectMessage(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createDirectMessage(get(this.conf.getRestBaseURL() + "direct_messages/show.json?id=" + j + "&full_text=true"));
    }

    public DirectMessage destroyDirectMessage(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createDirectMessage(post(this.conf.getRestBaseURL() + "direct_messages/destroy.json?id=" + j + "&full_text=true"));
    }

    public DirectMessage sendDirectMessage(long j, String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createDirectMessage(post(this.conf.getRestBaseURL() + "direct_messages/new.json", new HttpParameter((String) AccessToken.USER_ID_KEY, j), new HttpParameter("text", str), new HttpParameter("full_text", true)));
    }

    public DirectMessage sendDirectMessage(String str, String str2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createDirectMessage(post(this.conf.getRestBaseURL() + "direct_messages/new.json", new HttpParameter("screen_name", str), new HttpParameter("text", str2), new HttpParameter("full_text", true)));
    }

    public InputStream getDMImageAsStream(String str) throws TwitterException {
        return get(str).asStream();
    }

    public IDs getNoRetweetsFriendships() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "friendships/no_retweets/ids.json"));
    }

    public IDs getFriendsIDs(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "friends/ids.json?cursor=" + j));
    }

    public IDs getFriendsIDs(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "friends/ids.json?user_id=" + j + "&cursor=" + j2));
    }

    public IDs getFriendsIDs(long j, long j2, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "friends/ids.json?user_id=" + j + "&cursor=" + j2 + "&count=" + i));
    }

    public IDs getFriendsIDs(String str, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "friends/ids.json", new HttpParameter("screen_name", str), new HttpParameter("cursor", j)));
    }

    public IDs getFriendsIDs(String str, long j, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "friends/ids.json", new HttpParameter("screen_name", str), new HttpParameter("cursor", j), new HttpParameter("count", i)));
    }

    public IDs getFollowersIDs(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "followers/ids.json?cursor=" + j));
    }

    public IDs getFollowersIDs(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "followers/ids.json?user_id=" + j + "&cursor=" + j2));
    }

    public IDs getFollowersIDs(long j, long j2, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "followers/ids.json?user_id=" + j + "&cursor=" + j2 + "&count=" + i));
    }

    public IDs getFollowersIDs(String str, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "followers/ids.json", new HttpParameter("screen_name", str), new HttpParameter("cursor", j)));
    }

    public IDs getFollowersIDs(String str, long j, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "followers/ids.json", new HttpParameter("screen_name", str), new HttpParameter("cursor", j), new HttpParameter("count", i)));
    }

    public ResponseList<Friendship> lookupFriendships(long... jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createFriendshipList(get(this.conf.getRestBaseURL() + "friendships/lookup.json?user_id=" + StringUtil.join(jArr)));
    }

    public ResponseList<Friendship> lookupFriendships(String... strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createFriendshipList(get(this.conf.getRestBaseURL() + "friendships/lookup.json?screen_name=" + StringUtil.join(strArr)));
    }

    public IDs getIncomingFriendships(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "friendships/incoming.json?cursor=" + j));
    }

    public IDs getOutgoingFriendships(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "friendships/outgoing.json?cursor=" + j));
    }

    public User createFriendship(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "friendships/create.json?user_id=" + j));
    }

    public User createFriendship(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "friendships/create.json", new HttpParameter("screen_name", str)));
    }

    public User createFriendship(long j, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "friendships/create.json?user_id=" + j + "&follow=" + z));
    }

    public User createFriendship(String str, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "friendships/create.json", new HttpParameter("screen_name", str), new HttpParameter("follow", z)));
    }

    public User destroyFriendship(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "friendships/destroy.json?user_id=" + j));
    }

    public User destroyFriendship(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "friendships/destroy.json", new HttpParameter("screen_name", str)));
    }

    public Relationship updateFriendship(long j, boolean z, boolean z2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createRelationship(post(this.conf.getRestBaseURL() + "friendships/update.json", new HttpParameter((String) AccessToken.USER_ID_KEY, j), new HttpParameter("device", z), new HttpParameter("retweets", z2)));
    }

    public Relationship updateFriendship(String str, boolean z, boolean z2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createRelationship(post(this.conf.getRestBaseURL() + "friendships/update.json", new HttpParameter("screen_name", str), new HttpParameter("device", z), new HttpParameter("retweets", z2)));
    }

    public Relationship showFriendship(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createRelationship(get(this.conf.getRestBaseURL() + "friendships/show.json", new HttpParameter("source_id", j), new HttpParameter("target_id", j2)));
    }

    public Relationship showFriendship(String str, String str2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createRelationship(get(this.conf.getRestBaseURL() + "friendships/show.json", HttpParameter.getParameterArray("source_screen_name", str, "target_screen_name", str2)));
    }

    public PagableResponseList<User> getFriendsList(long j, long j2) throws TwitterException {
        return getFriendsList(j, j2, 20);
    }

    public PagableResponseList<User> getFriendsList(long j, long j2, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "friends/list.json?user_id=" + j + "&cursor=" + j2 + "&count=" + i));
    }

    public PagableResponseList<User> getFriendsList(String str, long j) throws TwitterException {
        return getFriendsList(str, j, 20);
    }

    public PagableResponseList<User> getFriendsList(String str, long j, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "friends/list.json", new HttpParameter("screen_name", str), new HttpParameter("cursor", j), new HttpParameter("count", i)));
    }

    public PagableResponseList<User> getFriendsList(long j, long j2, int i, boolean z, boolean z2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "friends/list.json?user_id=" + j + "&cursor=" + j2 + "&count=" + i + "&skip_status=" + z + "&include_user_entities=" + z2));
    }

    public PagableResponseList<User> getFriendsList(String str, long j, int i, boolean z, boolean z2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "friends/list.json", new HttpParameter("screen_name", str), new HttpParameter("cursor", j), new HttpParameter("count", i), new HttpParameter("skip_status", z), new HttpParameter("include_user_entities", z2)));
    }

    public PagableResponseList<User> getFollowersList(long j, long j2) throws TwitterException {
        return getFollowersList(j, j2, 20);
    }

    public PagableResponseList<User> getFollowersList(String str, long j) throws TwitterException {
        return getFollowersList(str, j, 20);
    }

    public PagableResponseList<User> getFollowersList(long j, long j2, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "followers/list.json?user_id=" + j + "&cursor=" + j2 + "&count=" + i));
    }

    public PagableResponseList<User> getFollowersList(String str, long j, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "followers/list.json", new HttpParameter("screen_name", str), new HttpParameter("cursor", j), new HttpParameter("count", i)));
    }

    public PagableResponseList<User> getFollowersList(long j, long j2, int i, boolean z, boolean z2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "followers/list.json?user_id=" + j + "&cursor=" + j2 + "&count=" + i + "&skip_status=" + z + "&include_user_entities=" + z2));
    }

    public PagableResponseList<User> getFollowersList(String str, long j, int i, boolean z, boolean z2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "followers/list.json", new HttpParameter("screen_name", str), new HttpParameter("cursor", j), new HttpParameter("count", i), new HttpParameter("skip_status", z), new HttpParameter("include_user_entities", z2)));
    }

    public AccountSettings getAccountSettings() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAccountSettings(get(this.conf.getRestBaseURL() + "account/settings.json"));
    }

    public User verifyCredentials() throws TwitterException {
        return super.fillInIDAndScreenName(new HttpParameter[]{new HttpParameter("include_email", this.conf.isIncludeEmailEnabled())});
    }

    public AccountSettings updateAccountSettings(Integer num, Boolean bool, String str, String str2, String str3, String str4) throws TwitterException {
        ArrayList arrayList = new ArrayList(6);
        if (num != null) {
            arrayList.add(new HttpParameter("trend_location_woeid", num.intValue()));
        }
        if (bool != null) {
            arrayList.add(new HttpParameter("sleep_time_enabled", bool.toString()));
        }
        if (str != null) {
            arrayList.add(new HttpParameter("start_sleep_time", str));
        }
        if (str2 != null) {
            arrayList.add(new HttpParameter("end_sleep_time", str2));
        }
        if (str3 != null) {
            arrayList.add(new HttpParameter("time_zone", str3));
        }
        if (str4 != null) {
            arrayList.add(new HttpParameter("lang", str4));
        }
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAccountSettings(post(this.conf.getRestBaseURL() + "account/settings.json", (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public User updateProfile(String str, String str2, String str3, String str4) throws TwitterException {
        ArrayList arrayList = new ArrayList(4);
        addParameterToList(arrayList, "name", str);
        addParameterToList(arrayList, "url", str2);
        addParameterToList(arrayList, PlaceFields.LOCATION, str3);
        addParameterToList(arrayList, "description", str4);
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "account/update_profile.json", (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public User updateProfileBackgroundImage(File file, boolean z) throws TwitterException {
        checkFileValidity(file);
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "account/update_profile_background_image.json", new HttpParameter("image", file), new HttpParameter("tile", z)));
    }

    public User updateProfileBackgroundImage(InputStream inputStream, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "account/update_profile_background_image.json", new HttpParameter("image", "image", inputStream), new HttpParameter("tile", z)));
    }

    public User updateProfileColors(String str, String str2, String str3, String str4, String str5) throws TwitterException {
        throw new UnsupportedOperationException("this API is no longer supported. https://twittercommunity.com/t/deprecation-of-account-update-profile-colors/28692");
    }

    private void addParameterToList(List<HttpParameter> list, String str, String str2) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    public User updateProfileImage(File file) throws TwitterException {
        checkFileValidity(file);
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "account/update_profile_image.json", new HttpParameter("image", file)));
    }

    public User updateProfileImage(InputStream inputStream) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "account/update_profile_image.json", new HttpParameter("image", "image", inputStream)));
    }

    private void checkFileValidity(File file) throws TwitterException {
        if (!file.exists()) {
            throw new TwitterException((Exception) new FileNotFoundException(file + " is not found."));
        } else if (!file.isFile()) {
            throw new TwitterException((Exception) new IOException(file + " is not a file."));
        }
    }

    public PagableResponseList<User> getBlocksList() throws TwitterException {
        return getBlocksList(-1);
    }

    public PagableResponseList<User> getBlocksList(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "blocks/list.json?cursor=" + j));
    }

    public IDs getBlocksIDs() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "blocks/ids.json"));
    }

    public IDs getBlocksIDs(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "blocks/ids.json?cursor=" + j));
    }

    public User createBlock(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "blocks/create.json?user_id=" + j));
    }

    public User createBlock(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "blocks/create.json", new HttpParameter("screen_name", str)));
    }

    public User destroyBlock(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "blocks/destroy.json?user_id=" + j));
    }

    public User destroyBlock(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "blocks/destroy.json", new HttpParameter("screen_name", str)));
    }

    public PagableResponseList<User> getMutesList(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "mutes/users/list.json?cursor=" + j));
    }

    public IDs getMutesIDs(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createIDs(get(this.conf.getRestBaseURL() + "mutes/users/ids.json?cursor=" + j));
    }

    public User createMute(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "mutes/users/create.json?user_id=" + j));
    }

    public User createMute(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "mutes/users/create.json", new HttpParameter("screen_name", str)));
    }

    public User destroyMute(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "mutes/users/destroy.json?user_id=" + j));
    }

    public User destroyMute(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "mutes/users/destroy.json", new HttpParameter("screen_name", str)));
    }

    public ResponseList<User> lookupUsers(long... jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUserList(get(this.conf.getRestBaseURL() + "users/lookup.json", new HttpParameter((String) AccessToken.USER_ID_KEY, StringUtil.join(jArr))));
    }

    public ResponseList<User> lookupUsers(String... strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUserList(get(this.conf.getRestBaseURL() + "users/lookup.json", new HttpParameter("screen_name", StringUtil.join(strArr))));
    }

    public User showUser(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(get(this.conf.getRestBaseURL() + "users/show.json?user_id=" + j));
    }

    public User showUser(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(get(this.conf.getRestBaseURL() + "users/show.json", new HttpParameter("screen_name", str)));
    }

    public ResponseList<User> searchUsers(String str, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUserList(get(this.conf.getRestBaseURL() + "users/search.json", new HttpParameter("q", str), new HttpParameter("per_page", 20), new HttpParameter((String) PlaceFields.PAGE, i)));
    }

    public ResponseList<User> getContributees(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUserList(get(this.conf.getRestBaseURL() + "users/contributees.json?user_id=" + j));
    }

    public ResponseList<User> getContributees(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUserList(get(this.conf.getRestBaseURL() + "users/contributees.json", new HttpParameter("screen_name", str)));
    }

    public ResponseList<User> getContributors(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUserList(get(this.conf.getRestBaseURL() + "users/contributors.json?user_id=" + j));
    }

    public ResponseList<User> getContributors(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUserList(get(this.conf.getRestBaseURL() + "users/contributors.json", new HttpParameter("screen_name", str)));
    }

    public void removeProfileBanner() throws TwitterException {
        post(this.conf.getRestBaseURL() + "account/remove_profile_banner.json");
    }

    public void updateProfileBanner(File file) throws TwitterException {
        checkFileValidity(file);
        post(this.conf.getRestBaseURL() + "account/update_profile_banner.json", new HttpParameter("banner", file));
    }

    public void updateProfileBanner(InputStream inputStream) throws TwitterException {
        post(this.conf.getRestBaseURL() + "account/update_profile_banner.json", new HttpParameter("banner", "banner", inputStream));
    }

    public ResponseList<User> getUserSuggestions(String str) throws TwitterException {
        try {
            return this.factory.createUserListFromJSONArray_Users(get(this.conf.getRestBaseURL() + "users/suggestions/" + URLEncoder.encode(str, "UTF-8") + ".json"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public ResponseList<Category> getSuggestedUserCategories() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createCategoryList(get(this.conf.getRestBaseURL() + "users/suggestions.json"));
    }

    public ResponseList<User> getMemberSuggestions(String str) throws TwitterException {
        try {
            return this.factory.createUserListFromJSONArray(get(this.conf.getRestBaseURL() + "users/suggestions/" + URLEncoder.encode(str, "UTF-8") + "/members.json"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public ResponseList<Status> getFavorites() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "favorites/list.json"));
    }

    public ResponseList<Status> getFavorites(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "favorites/list.json?user_id=" + j));
    }

    public ResponseList<Status> getFavorites(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "favorites/list.json", new HttpParameter("screen_name", str)));
    }

    public ResponseList<Status> getFavorites(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "favorites/list.json", paging.asPostParameterArray()));
    }

    public ResponseList<Status> getFavorites(long j, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "favorites/list.json", mergeParameters(new HttpParameter[]{new HttpParameter((String) AccessToken.USER_ID_KEY, j)}, paging.asPostParameterArray())));
    }

    public ResponseList<Status> getFavorites(String str, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "favorites/list.json", mergeParameters(new HttpParameter[]{new HttpParameter("screen_name", str)}, paging.asPostParameterArray())));
    }

    public Status destroyFavorite(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatus(post(this.conf.getRestBaseURL() + "favorites/destroy.json?id=" + j));
    }

    public Status createFavorite(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatus(post(this.conf.getRestBaseURL() + "favorites/create.json?id=" + j));
    }

    public ResponseList<UserList> getUserLists(String str) throws TwitterException {
        return getUserLists(str, false);
    }

    public ResponseList<UserList> getUserLists(String str, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUserListList(get(this.conf.getRestBaseURL() + "lists/list.json", new HttpParameter("screen_name", str), new HttpParameter("reverse", z)));
    }

    public ResponseList<UserList> getUserLists(long j) throws TwitterException {
        return getUserLists(j, false);
    }

    public ResponseList<UserList> getUserLists(long j, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUserListList(get(this.conf.getRestBaseURL() + "lists/list.json", new HttpParameter((String) AccessToken.USER_ID_KEY, j), new HttpParameter("reverse", z)));
    }

    public ResponseList<Status> getUserListStatuses(long j, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "lists/statuses.json", mergeParameters(paging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter("list_id", j))));
    }

    public ResponseList<Status> getUserListStatuses(long j, String str, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "lists/statuses.json", mergeParameters(paging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter[]{new HttpParameter("owner_id", j), new HttpParameter("slug", str)})));
    }

    public ResponseList<Status> getUserListStatuses(String str, String str2, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createStatusList(get(this.conf.getRestBaseURL() + "lists/statuses.json", mergeParameters(paging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter[]{new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)})));
    }

    public UserList destroyUserListMember(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/destroy.json", new HttpParameter("list_id", j), new HttpParameter((String) AccessToken.USER_ID_KEY, j2)));
    }

    public UserList destroyUserListMember(long j, String str, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/destroy.json", new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter((String) AccessToken.USER_ID_KEY, j2)));
    }

    public UserList destroyUserListMember(long j, String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/destroy.json", new HttpParameter("list_id", j), new HttpParameter("screen_name", str)));
    }

    public UserList destroyUserListMember(String str, String str2, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/destroy.json", new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter((String) AccessToken.USER_ID_KEY, j)));
    }

    public UserList destroyUserListMembers(long j, String[] strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/destroy_all.json", new HttpParameter("list_id", j), new HttpParameter("screen_name", StringUtil.join(strArr))));
    }

    public UserList destroyUserListMembers(long j, long[] jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/destroy_all.json", new HttpParameter("list_id", j), new HttpParameter((String) AccessToken.USER_ID_KEY, StringUtil.join(jArr))));
    }

    public UserList destroyUserListMembers(String str, String str2, String[] strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/destroy_all.json", new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("screen_name", StringUtil.join(strArr))));
    }

    public PagableResponseList<UserList> getUserListMemberships(long j) throws TwitterException {
        return getUserListMemberships(20, j);
    }

    public PagableResponseList<UserList> getUserListMemberships(int i, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserListList(get(this.conf.getRestBaseURL() + "lists/memberships.json", new HttpParameter("cursor", j), new HttpParameter("count", i)));
    }

    public PagableResponseList<UserList> getUserListMemberships(String str, long j) throws TwitterException {
        return getUserListMemberships(str, j, false);
    }

    public PagableResponseList<UserList> getUserListMemberships(String str, int i, long j) throws TwitterException {
        return getUserListMemberships(str, i, j, false);
    }

    public PagableResponseList<UserList> getUserListMemberships(String str, long j, boolean z) throws TwitterException {
        return getUserListMemberships(str, 20, j, z);
    }

    public PagableResponseList<UserList> getUserListMemberships(String str, int i, long j, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserListList(get(this.conf.getRestBaseURL() + "lists/memberships.json", new HttpParameter("screen_name", str), new HttpParameter("count", i), new HttpParameter("cursor", j), new HttpParameter("filter_to_owned_lists", z)));
    }

    public PagableResponseList<UserList> getUserListMemberships(long j, long j2) throws TwitterException {
        return getUserListMemberships(j, j2, false);
    }

    public PagableResponseList<UserList> getUserListMemberships(long j, int i, long j2) throws TwitterException {
        return getUserListMemberships(j, i, j2, false);
    }

    public PagableResponseList<UserList> getUserListMemberships(long j, long j2, boolean z) throws TwitterException {
        return getUserListMemberships(j, 20, j2, z);
    }

    public PagableResponseList<UserList> getUserListMemberships(long j, int i, long j2, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserListList(get(this.conf.getRestBaseURL() + "lists/memberships.json", new HttpParameter((String) AccessToken.USER_ID_KEY, j), new HttpParameter("count", i), new HttpParameter("cursor", j2), new HttpParameter("filter_to_owned_lists", z)));
    }

    public PagableResponseList<User> getUserListSubscribers(long j, long j2) throws TwitterException {
        return getUserListSubscribers(j, 20, j2, false);
    }

    public PagableResponseList<User> getUserListSubscribers(long j, int i, long j2) throws TwitterException {
        return getUserListSubscribers(j, i, j2, false);
    }

    public PagableResponseList<User> getUserListSubscribers(long j, int i, long j2, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "lists/subscribers.json", new HttpParameter("list_id", j), new HttpParameter("count", i), new HttpParameter("cursor", j2), new HttpParameter("skip_status", z)));
    }

    public PagableResponseList<User> getUserListSubscribers(long j, String str, long j2) throws TwitterException {
        return getUserListSubscribers(j, str, 20, j2, false);
    }

    public PagableResponseList<User> getUserListSubscribers(long j, String str, int i, long j2) throws TwitterException {
        return getUserListSubscribers(j, str, i, j2, false);
    }

    public PagableResponseList<User> getUserListSubscribers(long j, String str, int i, long j2, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "lists/subscribers.json", new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter("count", i), new HttpParameter("cursor", j2), new HttpParameter("skip_status", z)));
    }

    public PagableResponseList<User> getUserListSubscribers(String str, String str2, long j) throws TwitterException {
        return getUserListSubscribers(str, str2, 20, j, false);
    }

    public PagableResponseList<User> getUserListSubscribers(String str, String str2, int i, long j) throws TwitterException {
        return getUserListSubscribers(str, str2, i, j, false);
    }

    public PagableResponseList<User> getUserListSubscribers(String str, String str2, int i, long j, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "lists/subscribers.json", new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("count", i), new HttpParameter("cursor", j), new HttpParameter("skip_status", z)));
    }

    public UserList createUserListSubscription(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/subscribers/create.json", new HttpParameter("list_id", j)));
    }

    public UserList createUserListSubscription(long j, String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/subscribers/create.json", new HttpParameter("owner_id", j), new HttpParameter("slug", str)));
    }

    public UserList createUserListSubscription(String str, String str2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/subscribers/create.json", new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)));
    }

    public User showUserListSubscription(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(get(this.conf.getRestBaseURL() + "lists/subscribers/show.json?list_id=" + j + "&user_id=" + j2));
    }

    public User showUserListSubscription(long j, String str, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(get(this.conf.getRestBaseURL() + "lists/subscribers/show.json?owner_id=" + j + "&slug=" + str + "&user_id=" + j2));
    }

    public User showUserListSubscription(String str, String str2, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(get(this.conf.getRestBaseURL() + "lists/subscribers/show.json", new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter((String) AccessToken.USER_ID_KEY, j)));
    }

    public UserList destroyUserListSubscription(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/subscribers/destroy.json", new HttpParameter("list_id", j)));
    }

    public UserList destroyUserListSubscription(long j, String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/subscribers/destroy.json", new HttpParameter("owner_id", j), new HttpParameter("slug", str)));
    }

    public UserList destroyUserListSubscription(String str, String str2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/subscribers/destroy.json", new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)));
    }

    public UserList createUserListMembers(long j, long... jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create_all.json", new HttpParameter("list_id", j), new HttpParameter((String) AccessToken.USER_ID_KEY, StringUtil.join(jArr))));
    }

    public UserList createUserListMembers(long j, String str, long... jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create_all.json", new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter((String) AccessToken.USER_ID_KEY, StringUtil.join(jArr))));
    }

    public UserList createUserListMembers(String str, String str2, long... jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create_all.json", new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter((String) AccessToken.USER_ID_KEY, StringUtil.join(jArr))));
    }

    public UserList createUserListMembers(long j, String... strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create_all.json", new HttpParameter("list_id", j), new HttpParameter("screen_name", StringUtil.join(strArr))));
    }

    public UserList createUserListMembers(long j, String str, String... strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create_all.json", new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter("screen_name", StringUtil.join(strArr))));
    }

    public UserList createUserListMembers(String str, String str2, String... strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create_all.json", new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("screen_name", StringUtil.join(strArr))));
    }

    public User showUserListMembership(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(get(this.conf.getRestBaseURL() + "lists/members/show.json?list_id=" + j + "&user_id=" + j2));
    }

    public User showUserListMembership(long j, String str, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(get(this.conf.getRestBaseURL() + "lists/members/show.json?owner_id=" + j + "&slug=" + str + "&user_id=" + j2));
    }

    public User showUserListMembership(String str, String str2, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(get(this.conf.getRestBaseURL() + "lists/members/show.json", new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter((String) AccessToken.USER_ID_KEY, j)));
    }

    public PagableResponseList<User> getUserListMembers(long j, long j2) throws TwitterException {
        return getUserListMembers(j, 20, j2, false);
    }

    public PagableResponseList<User> getUserListMembers(long j, int i, long j2) throws TwitterException {
        return getUserListMembers(j, i, j2, false);
    }

    public PagableResponseList<User> getUserListMembers(long j, int i, long j2, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "lists/members.json", new HttpParameter("list_id", j), new HttpParameter("count", i), new HttpParameter("cursor", j2), new HttpParameter("skip_status", z)));
    }

    public PagableResponseList<User> getUserListMembers(long j, String str, long j2) throws TwitterException {
        return getUserListMembers(j, str, 20, j2, false);
    }

    public PagableResponseList<User> getUserListMembers(long j, String str, int i, long j2) throws TwitterException {
        return getUserListMembers(j, str, i, j2, false);
    }

    public PagableResponseList<User> getUserListMembers(long j, String str, int i, long j2, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "lists/members.json", new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter("count", i), new HttpParameter("cursor", j2), new HttpParameter("skip_status", z)));
    }

    public PagableResponseList<User> getUserListMembers(String str, String str2, long j) throws TwitterException {
        return getUserListMembers(str, str2, 20, j, false);
    }

    public PagableResponseList<User> getUserListMembers(String str, String str2, int i, long j) throws TwitterException {
        return getUserListMembers(str, str2, i, j, false);
    }

    public PagableResponseList<User> getUserListMembers(String str, String str2, int i, long j, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserList(get(this.conf.getRestBaseURL() + "lists/members.json", new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("count", i), new HttpParameter("cursor", j), new HttpParameter("skip_status", z)));
    }

    public UserList createUserListMember(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create.json", new HttpParameter((String) AccessToken.USER_ID_KEY, j2), new HttpParameter("list_id", j)));
    }

    public UserList createUserListMember(long j, String str, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create.json", new HttpParameter((String) AccessToken.USER_ID_KEY, j2), new HttpParameter("owner_id", j), new HttpParameter("slug", str)));
    }

    public UserList createUserListMember(String str, String str2, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create.json", new HttpParameter((String) AccessToken.USER_ID_KEY, j), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)));
    }

    public UserList destroyUserList(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/destroy.json", new HttpParameter("list_id", j)));
    }

    public UserList destroyUserList(long j, String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/destroy.json", new HttpParameter("owner_id", j), new HttpParameter("slug", str)));
    }

    public UserList destroyUserList(String str, String str2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/destroy.json", new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)));
    }

    public UserList updateUserList(long j, String str, boolean z, String str2) throws TwitterException {
        return updateUserList(str, z, str2, new HttpParameter("list_id", j));
    }

    public UserList updateUserList(long j, String str, String str2, boolean z, String str3) throws TwitterException {
        return updateUserList(str2, z, str3, new HttpParameter("owner_id", j), new HttpParameter("slug", str));
    }

    public UserList updateUserList(String str, String str2, String str3, boolean z, String str4) throws TwitterException {
        return updateUserList(str3, z, str4, new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2));
    }

    private UserList updateUserList(String str, boolean z, String str2, HttpParameter... httpParameterArr) throws TwitterException {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, httpParameterArr);
        if (str != null) {
            arrayList.add(new HttpParameter("name", str));
        }
        arrayList.add(new HttpParameter("mode", z ? "public" : "private"));
        if (str2 != null) {
            arrayList.add(new HttpParameter("description", str2));
        }
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/update.json", (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public UserList createUserList(String str, boolean z, String str2) throws TwitterException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HttpParameter("name", str));
        arrayList.add(new HttpParameter("mode", z ? "public" : "private"));
        if (str2 != null) {
            arrayList.add(new HttpParameter("description", str2));
        }
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(post(this.conf.getRestBaseURL() + "lists/create.json", (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public UserList showUserList(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(get(this.conf.getRestBaseURL() + "lists/show.json?list_id=" + j));
    }

    public UserList showUserList(long j, String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(get(this.conf.getRestBaseURL() + "lists/show.json?owner_id=" + j + "&slug=" + str));
    }

    public UserList showUserList(String str, String str2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createAUserList(get(this.conf.getRestBaseURL() + "lists/show.json", new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)));
    }

    public PagableResponseList<UserList> getUserListSubscriptions(String str, long j) throws TwitterException {
        return getUserListSubscriptions(str, 20, j);
    }

    public PagableResponseList<UserList> getUserListSubscriptions(String str, int i, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserListList(get(this.conf.getRestBaseURL() + "lists/subscriptions.json", new HttpParameter("screen_name", str), new HttpParameter("count", i), new HttpParameter("cursor", j)));
    }

    public PagableResponseList<UserList> getUserListSubscriptions(long j, long j2) throws TwitterException {
        return getUserListSubscriptions(j, 20, j2);
    }

    public PagableResponseList<UserList> getUserListSubscriptions(long j, int i, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserListList(get(this.conf.getRestBaseURL() + "lists/subscriptions.json", new HttpParameter((String) AccessToken.USER_ID_KEY, j), new HttpParameter("count", i), new HttpParameter("cursor", j2)));
    }

    public PagableResponseList<UserList> getUserListsOwnerships(String str, long j) throws TwitterException {
        return getUserListsOwnerships(str, 20, j);
    }

    public PagableResponseList<UserList> getUserListsOwnerships(String str, int i, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserListList(get(this.conf.getRestBaseURL() + "lists/ownerships.json", new HttpParameter("screen_name", str), new HttpParameter("count", i), new HttpParameter("cursor", j)));
    }

    public PagableResponseList<UserList> getUserListsOwnerships(long j, long j2) throws TwitterException {
        return getUserListsOwnerships(j, 20, j2);
    }

    public PagableResponseList<UserList> getUserListsOwnerships(long j, int i, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPagableUserListList(get(this.conf.getRestBaseURL() + "lists/ownerships.json", new HttpParameter((String) AccessToken.USER_ID_KEY, j), new HttpParameter("count", i), new HttpParameter("cursor", j2)));
    }

    public ResponseList<SavedSearch> getSavedSearches() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createSavedSearchList(get(this.conf.getRestBaseURL() + "saved_searches/list.json"));
    }

    public SavedSearch showSavedSearch(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createSavedSearch(get(this.conf.getRestBaseURL() + "saved_searches/show/" + j + ".json"));
    }

    public SavedSearch createSavedSearch(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createSavedSearch(post(this.conf.getRestBaseURL() + "saved_searches/create.json", new HttpParameter((String) SearchIntents.EXTRA_QUERY, str)));
    }

    public SavedSearch destroySavedSearch(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createSavedSearch(post(this.conf.getRestBaseURL() + "saved_searches/destroy/" + j + ".json"));
    }

    public Place getGeoDetails(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPlace(get(this.conf.getRestBaseURL() + "geo/id/" + str + ".json"));
    }

    public ResponseList<Place> reverseGeoCode(GeoQuery geoQuery) throws TwitterException {
        try {
            ObjectFactory objectFactory = this.factory;
            return objectFactory.createPlaceList(get(this.conf.getRestBaseURL() + "geo/reverse_geocode.json", geoQuery.asHttpParameterArray()));
        } catch (TwitterException e2) {
            if (e2.getStatusCode() == 404) {
                return this.factory.createEmptyResponseList();
            }
            throw e2;
        }
    }

    public ResponseList<Place> searchPlaces(GeoQuery geoQuery) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPlaceList(get(this.conf.getRestBaseURL() + "geo/search.json", geoQuery.asHttpParameterArray()));
    }

    public ResponseList<Place> getSimilarPlaces(GeoLocation geoLocation, String str, String str2, String str3) throws TwitterException {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new HttpParameter("lat", geoLocation.getLatitude()));
        arrayList.add(new HttpParameter("long", geoLocation.getLongitude()));
        arrayList.add(new HttpParameter("name", str));
        if (str2 != null) {
            arrayList.add(new HttpParameter("contained_within", str2));
        }
        if (str3 != null) {
            arrayList.add(new HttpParameter("attribute:street_address", str3));
        }
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createPlaceList(get(this.conf.getRestBaseURL() + "geo/similar_places.json", (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public Trends getPlaceTrends(int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createTrends(get(this.conf.getRestBaseURL() + "trends/place.json?id=" + i));
    }

    public ResponseList<Location> getAvailableTrends() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createLocationList(get(this.conf.getRestBaseURL() + "trends/available.json"));
    }

    public ResponseList<Location> getClosestTrends(GeoLocation geoLocation) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createLocationList(get(this.conf.getRestBaseURL() + "trends/closest.json", new HttpParameter("lat", geoLocation.getLatitude()), new HttpParameter("long", geoLocation.getLongitude())));
    }

    public User reportSpam(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "users/report_spam.json?user_id=" + j));
    }

    public User reportSpam(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createUser(post(this.conf.getRestBaseURL() + "users/report_spam.json", new HttpParameter("screen_name", str)));
    }

    public TwitterAPIConfiguration getAPIConfiguration() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createTwitterAPIConfiguration(get(this.conf.getRestBaseURL() + "help/configuration.json"));
    }

    public ResponseList<HelpResources.Language> getLanguages() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createLanguageList(get(this.conf.getRestBaseURL() + "help/languages.json"));
    }

    public String getPrivacyPolicy() throws TwitterException {
        try {
            return get(this.conf.getRestBaseURL() + "help/privacy.json").asJSONObject().getString(ShareConstants.WEB_DIALOG_PARAM_PRIVACY);
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public String getTermsOfService() throws TwitterException {
        try {
            return get(this.conf.getRestBaseURL() + "help/tos.json").asJSONObject().getString("tos");
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public Map<String, RateLimitStatus> getRateLimitStatus() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createRateLimitStatuses(get(this.conf.getRestBaseURL() + "application/rate_limit_status.json"));
    }

    public Map<String, RateLimitStatus> getRateLimitStatus(String... strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        return objectFactory.createRateLimitStatuses(get(this.conf.getRestBaseURL() + "application/rate_limit_status.json?resources=" + StringUtil.join(strArr)));
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [twitter4j.HttpResponse, twitter4j.HttpParameter[]] */
    private HttpResponse get(String str) throws TwitterException {
        ensureAuthorizationEnabled();
        if (this.IMPLICIT_PARAMS_STR.length() > 0) {
            if (str.contains("?")) {
                str = str + "&" + this.IMPLICIT_PARAMS_STR;
            } else {
                str = str + "?" + this.IMPLICIT_PARAMS_STR;
            }
        }
        HttpResponse httpResponse = 0;
        if (!this.conf.isMBeanEnabled()) {
            return this.http.get(str, httpResponse, this.auth, this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            httpResponse = this.http.get(str, httpResponse, this.auth, this);
            return httpResponse;
        } finally {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(httpResponse));
        }
    }

    private HttpResponse get(String str, HttpParameter... httpParameterArr) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.get(str, mergeImplicitParams(httpParameterArr), this.auth, this);
        }
        HttpResponse httpResponse = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            httpResponse = this.http.get(str, mergeImplicitParams(httpParameterArr), this.auth, this);
            return httpResponse;
        } finally {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(httpResponse));
        }
    }

    private HttpResponse post(String str) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(str, this.IMPLICIT_PARAMS, this.auth, this);
        }
        HttpResponse httpResponse = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            httpResponse = this.http.post(str, this.IMPLICIT_PARAMS, this.auth, this);
            return httpResponse;
        } finally {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(httpResponse));
        }
    }

    private HttpResponse post(String str, HttpParameter... httpParameterArr) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(str, mergeImplicitParams(httpParameterArr), this.auth, this);
        }
        HttpResponse httpResponse = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            httpResponse = this.http.post(str, mergeImplicitParams(httpParameterArr), this.auth, this);
            return httpResponse;
        } finally {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(httpResponse));
        }
    }

    private HttpParameter[] mergeParameters(HttpParameter[] httpParameterArr, HttpParameter[] httpParameterArr2) {
        if (httpParameterArr != null && httpParameterArr2 != null) {
            HttpParameter[] httpParameterArr3 = new HttpParameter[(httpParameterArr.length + httpParameterArr2.length)];
            System.arraycopy(httpParameterArr, 0, httpParameterArr3, 0, httpParameterArr.length);
            System.arraycopy(httpParameterArr2, 0, httpParameterArr3, httpParameterArr.length, httpParameterArr2.length);
            return httpParameterArr3;
        } else if (httpParameterArr == null && httpParameterArr2 == null) {
            return new HttpParameter[0];
        } else {
            return httpParameterArr != null ? httpParameterArr : httpParameterArr2;
        }
    }

    private HttpParameter[] mergeParameters(HttpParameter[] httpParameterArr, HttpParameter httpParameter) {
        if (httpParameterArr != null && httpParameter != null) {
            HttpParameter[] httpParameterArr2 = new HttpParameter[(httpParameterArr.length + 1)];
            System.arraycopy(httpParameterArr, 0, httpParameterArr2, 0, httpParameterArr.length);
            httpParameterArr2[httpParameterArr2.length - 1] = httpParameter;
            return httpParameterArr2;
        } else if (httpParameterArr == null && httpParameter == null) {
            return new HttpParameter[0];
        } else {
            if (httpParameterArr != null) {
                return httpParameterArr;
            }
            return new HttpParameter[]{httpParameter};
        }
    }

    private HttpParameter[] mergeImplicitParams(HttpParameter... httpParameterArr) {
        return mergeParameters(httpParameterArr, this.IMPLICIT_PARAMS);
    }

    private boolean isOk(HttpResponse httpResponse) {
        return httpResponse != null && httpResponse.getStatusCode() < 300;
    }

    public String toString() {
        return "TwitterImpl{INCLUDE_MY_RETWEET=" + this.INCLUDE_MY_RETWEET + '}';
    }
}
