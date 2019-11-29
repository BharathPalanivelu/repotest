package twitter4j;

public class ScopesImpl implements Scopes {
    private static final long serialVersionUID = -6301829625595514787L;
    private final String[] placeIds;

    ScopesImpl() {
        this.placeIds = new String[0];
    }

    public ScopesImpl(String[] strArr) {
        this.placeIds = strArr;
    }

    public String[] getPlaceIds() {
        return this.placeIds;
    }
}
