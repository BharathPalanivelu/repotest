package twitter4j;

final class URLEntityJSONImpl extends EntityIndex implements URLEntity {
    private static final long serialVersionUID = 7333552738058031524L;
    private String displayURL;
    private String expandedURL;
    private String url;

    URLEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    URLEntityJSONImpl(int i, int i2, String str, String str2, String str3) {
        setStart(i);
        setEnd(i2);
        this.url = str;
        this.expandedURL = str2;
        this.displayURL = str3;
    }

    URLEntityJSONImpl() {
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            if (!jSONObject.isNull("url")) {
                this.url = jSONObject.getString("url");
            }
            if (!jSONObject.isNull("expanded_url")) {
                this.expandedURL = jSONObject.getString("expanded_url");
            } else {
                this.expandedURL = this.url;
            }
            if (!jSONObject.isNull("display_url")) {
                this.displayURL = jSONObject.getString("display_url");
            } else {
                this.displayURL = this.url;
            }
        } catch (JSONException e2) {
            throw new TwitterException((Exception) e2);
        }
    }

    public String getText() {
        return this.url;
    }

    public String getURL() {
        return this.url;
    }

    public String getExpandedURL() {
        return this.expandedURL;
    }

    public String getDisplayURL() {
        return this.displayURL;
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
        URLEntityJSONImpl uRLEntityJSONImpl = (URLEntityJSONImpl) obj;
        String str = this.displayURL;
        if (str == null ? uRLEntityJSONImpl.displayURL != null : !str.equals(uRLEntityJSONImpl.displayURL)) {
            return false;
        }
        String str2 = this.expandedURL;
        if (str2 == null ? uRLEntityJSONImpl.expandedURL != null : !str2.equals(uRLEntityJSONImpl.expandedURL)) {
            return false;
        }
        String str3 = this.url;
        return str3 == null ? uRLEntityJSONImpl.url == null : str3.equals(uRLEntityJSONImpl.url);
    }

    public int hashCode() {
        String str = this.url;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.expandedURL;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.displayURL;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "URLEntityJSONImpl{url='" + this.url + '\'' + ", expandedURL='" + this.expandedURL + '\'' + ", displayURL='" + this.displayURL + '\'' + '}';
    }
}
