package twitter4j;

import java.io.Serializable;
import java.util.Date;

public interface Status extends Serializable, Comparable<Status>, EntitySupport, TwitterResponse {
    long[] getContributors();

    Date getCreatedAt();

    long getCurrentUserRetweetId();

    int getDisplayTextRangeEnd();

    int getDisplayTextRangeStart();

    int getFavoriteCount();

    GeoLocation getGeoLocation();

    long getId();

    String getInReplyToScreenName();

    long getInReplyToStatusId();

    long getInReplyToUserId();

    String getLang();

    Place getPlace();

    Status getQuotedStatus();

    long getQuotedStatusId();

    int getRetweetCount();

    Status getRetweetedStatus();

    Scopes getScopes();

    String getSource();

    String getText();

    User getUser();

    String[] getWithheldInCountries();

    boolean isFavorited();

    boolean isPossiblySensitive();

    boolean isRetweet();

    boolean isRetweeted();

    boolean isRetweetedByMe();

    boolean isTruncated();
}
