package twitter4j;

import com.google.android.gms.actions.SearchIntents;
import java.io.Serializable;

final class TrendJSONImpl implements Serializable, Trend {
    private static final long serialVersionUID = -4353426776065521132L;
    private final String name;
    private String query;
    private String url;

    TrendJSONImpl(JSONObject jSONObject, boolean z) {
        this.url = null;
        this.query = null;
        this.name = ParseUtil.getRawString("name", jSONObject);
        this.url = ParseUtil.getRawString("url", jSONObject);
        this.query = ParseUtil.getRawString(SearchIntents.EXTRA_QUERY, jSONObject);
        if (z) {
            TwitterObjectFactory.registerJSONObject(this, jSONObject);
        }
    }

    TrendJSONImpl(JSONObject jSONObject) {
        this(jSONObject, false);
    }

    public String getName() {
        return this.name;
    }

    public String getURL() {
        return this.url;
    }

    public String getQuery() {
        return this.query;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trend)) {
            return false;
        }
        Trend trend = (Trend) obj;
        if (!this.name.equals(trend.getName())) {
            return false;
        }
        String str = this.query;
        if (str == null ? trend.getQuery() != null : !str.equals(trend.getQuery())) {
            return false;
        }
        String str2 = this.url;
        return str2 == null ? trend.getURL() == null : str2.equals(trend.getURL());
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.url;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.query;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "TrendJSONImpl{name='" + this.name + '\'' + ", url='" + this.url + '\'' + ", query='" + this.query + '\'' + '}';
    }
}
