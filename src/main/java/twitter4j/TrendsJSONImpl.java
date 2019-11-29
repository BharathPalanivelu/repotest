package twitter4j;

import com.BV.LinearGradient.LinearGradientManager;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import twitter4j.conf.Configuration;

final class TrendsJSONImpl extends TwitterResponseImpl implements Serializable, Trends {
    private static final long serialVersionUID = 2054973282133379835L;
    private Date asOf;
    private Location location;
    private Date trendAt;
    private Trend[] trends;

    public int compareTo(Trends trends2) {
        return this.trendAt.compareTo(trends2.getTrendAt());
    }

    TrendsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        init(httpResponse.asString(), configuration.isJSONStoreEnabled());
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, httpResponse.asString());
        }
    }

    TrendsJSONImpl(String str) throws TwitterException {
        this(str, false);
    }

    TrendsJSONImpl(String str, boolean z) throws TwitterException {
        init(str, z);
    }

    /* access modifiers changed from: package-private */
    public void init(String str, boolean z) throws TwitterException {
        JSONObject jSONObject;
        try {
            if (str.startsWith("[")) {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    jSONObject = jSONArray.getJSONObject(0);
                } else {
                    throw new TwitterException("No trends found on the specified woeid");
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            this.asOf = ParseUtil.parseTrendsDate(jSONObject.getString("as_of"));
            this.location = extractLocation(jSONObject, z);
            JSONArray jSONArray2 = jSONObject.getJSONArray("trends");
            this.trendAt = this.asOf;
            this.trends = jsonArrayToTrendArray(jSONArray2, z);
        } catch (JSONException e2) {
            throw new TwitterException(e2.getMessage(), (Throwable) e2);
        }
    }

    TrendsJSONImpl(Date date, Location location2, Date date2, Trend[] trendArr) {
        this.asOf = date;
        this.location = location2;
        this.trendAt = date2;
        this.trends = trendArr;
    }

    static ResponseList<Trends> createTrendsList(HttpResponse httpResponse, boolean z) throws TwitterException {
        JSONObject asJSONObject = httpResponse.asJSONObject();
        try {
            Date parseTrendsDate = ParseUtil.parseTrendsDate(asJSONObject.getString("as_of"));
            JSONObject jSONObject = asJSONObject.getJSONObject("trends");
            Location extractLocation = extractLocation(asJSONObject, z);
            ResponseListImpl responseListImpl = new ResponseListImpl(jSONObject.length(), httpResponse);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Trend[] jsonArrayToTrendArray = jsonArrayToTrendArray(jSONObject.getJSONArray(str), z);
                if (str.length() == 19) {
                    responseListImpl.add(new TrendsJSONImpl(parseTrendsDate, extractLocation, ParseUtil.getDate(str, "yyyy-MM-dd HH:mm:ss"), jsonArrayToTrendArray));
                } else if (str.length() == 16) {
                    responseListImpl.add(new TrendsJSONImpl(parseTrendsDate, extractLocation, ParseUtil.getDate(str, "yyyy-MM-dd HH:mm"), jsonArrayToTrendArray));
                } else if (str.length() == 10) {
                    responseListImpl.add(new TrendsJSONImpl(parseTrendsDate, extractLocation, ParseUtil.getDate(str, "yyyy-MM-dd"), jsonArrayToTrendArray));
                }
            }
            Collections.sort(responseListImpl);
            return responseListImpl;
        } catch (JSONException e2) {
            throw new TwitterException(e2.getMessage() + ":" + httpResponse.asString(), (Throwable) e2);
        }
    }

    private static Location extractLocation(JSONObject jSONObject, boolean z) throws TwitterException {
        if (jSONObject.isNull(LinearGradientManager.PROP_LOCATIONS)) {
            return null;
        }
        try {
            ResponseList<Location> createLocationList = LocationJSONImpl.createLocationList(jSONObject.getJSONArray(LinearGradientManager.PROP_LOCATIONS), z);
            if (createLocationList.size() != 0) {
                return (Location) createLocationList.get(0);
            }
            return null;
        } catch (JSONException unused) {
            throw new AssertionError("locations can't be null");
        }
    }

    private static Trend[] jsonArrayToTrendArray(JSONArray jSONArray, boolean z) throws JSONException {
        Trend[] trendArr = new Trend[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            trendArr[i] = new TrendJSONImpl(jSONArray.getJSONObject(i), z);
        }
        return trendArr;
    }

    public Trend[] getTrends() {
        return this.trends;
    }

    public Location getLocation() {
        return this.location;
    }

    public Date getAsOf() {
        return this.asOf;
    }

    public Date getTrendAt() {
        return this.trendAt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trends)) {
            return false;
        }
        Trends trends2 = (Trends) obj;
        Date date = this.asOf;
        if (date == null ? trends2.getAsOf() != null : !date.equals(trends2.getAsOf())) {
            return false;
        }
        Date date2 = this.trendAt;
        if (date2 == null ? trends2.getTrendAt() == null : date2.equals(trends2.getTrendAt())) {
            return Arrays.equals(this.trends, trends2.getTrends());
        }
        return false;
    }

    public int hashCode() {
        Date date = this.asOf;
        int i = 0;
        int hashCode = (date != null ? date.hashCode() : 0) * 31;
        Date date2 = this.trendAt;
        int hashCode2 = (hashCode + (date2 != null ? date2.hashCode() : 0)) * 31;
        Trend[] trendArr = this.trends;
        if (trendArr != null) {
            i = Arrays.hashCode(trendArr);
        }
        return hashCode2 + i;
    }

    public String toString() {
        List list;
        StringBuilder sb = new StringBuilder();
        sb.append("TrendsJSONImpl{asOf=");
        sb.append(this.asOf);
        sb.append(", trendAt=");
        sb.append(this.trendAt);
        sb.append(", trends=");
        Trend[] trendArr = this.trends;
        if (trendArr == null) {
            list = null;
        } else {
            list = Arrays.asList(trendArr);
        }
        sb.append(list);
        sb.append('}');
        return sb.toString();
    }
}
