package twitter4j;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class GeoQuery implements Serializable {
    private static final long serialVersionUID = 5434503339001056634L;
    private String accuracy = null;
    private String granularity = null;
    private String ip = null;
    private GeoLocation location;
    private int maxResults = -1;
    private String query = null;

    public GeoQuery(GeoLocation geoLocation) {
        this.location = geoLocation;
    }

    public GeoQuery(String str) {
        this.ip = str;
    }

    public GeoLocation getLocation() {
        return this.location;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public String getIp() {
        return this.ip;
    }

    public String getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(String str) {
        this.accuracy = str;
    }

    public GeoQuery accuracy(String str) {
        setAccuracy(str);
        return this;
    }

    public String getGranularity() {
        return this.granularity;
    }

    public void setGranularity(String str) {
        this.granularity = str;
    }

    public GeoQuery granularity(String str) {
        setGranularity(str);
        return this;
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public void setMaxResults(int i) {
        this.maxResults = i;
    }

    public GeoQuery maxResults(int i) {
        setMaxResults(i);
        return this;
    }

    /* access modifiers changed from: package-private */
    public HttpParameter[] asHttpParameterArray() {
        ArrayList arrayList = new ArrayList();
        GeoLocation geoLocation = this.location;
        if (geoLocation != null) {
            appendParameter("lat", geoLocation.getLatitude(), (List<HttpParameter>) arrayList);
            appendParameter("long", this.location.getLongitude(), (List<HttpParameter>) arrayList);
        }
        String str = this.ip;
        if (str != null) {
            appendParameter(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, str, (List<HttpParameter>) arrayList);
        }
        appendParameter("accuracy", this.accuracy, (List<HttpParameter>) arrayList);
        appendParameter(SearchIntents.EXTRA_QUERY, this.query, (List<HttpParameter>) arrayList);
        appendParameter("granularity", this.granularity, (List<HttpParameter>) arrayList);
        appendParameter("max_results", this.maxResults, (List<HttpParameter>) arrayList);
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    private void appendParameter(String str, String str2, List<HttpParameter> list) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    private void appendParameter(String str, int i, List<HttpParameter> list) {
        if (i > 0) {
            list.add(new HttpParameter(str, String.valueOf(i)));
        }
    }

    private void appendParameter(String str, double d2, List<HttpParameter> list) {
        list.add(new HttpParameter(str, String.valueOf(d2)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeoQuery geoQuery = (GeoQuery) obj;
        if (this.maxResults != geoQuery.maxResults) {
            return false;
        }
        String str = this.accuracy;
        if (str == null ? geoQuery.accuracy != null : !str.equals(geoQuery.accuracy)) {
            return false;
        }
        String str2 = this.granularity;
        if (str2 == null ? geoQuery.granularity != null : !str2.equals(geoQuery.granularity)) {
            return false;
        }
        String str3 = this.ip;
        if (str3 == null ? geoQuery.ip != null : !str3.equals(geoQuery.ip)) {
            return false;
        }
        GeoLocation geoLocation = this.location;
        return geoLocation == null ? geoQuery.location == null : geoLocation.equals(geoQuery.location);
    }

    public int hashCode() {
        GeoLocation geoLocation = this.location;
        int i = 0;
        int hashCode = (geoLocation != null ? geoLocation.hashCode() : 0) * 31;
        String str = this.ip;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.accuracy;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.granularity;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.maxResults;
    }

    public String toString() {
        return "GeoQuery{location=" + this.location + ", query='" + this.query + '\'' + ", ip='" + this.ip + '\'' + ", accuracy='" + this.accuracy + '\'' + ", granularity='" + this.granularity + '\'' + ", maxResults=" + this.maxResults + '}';
    }
}
