package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class QueryContactInfoRequest extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_USER_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer user_id;

    public QueryContactInfoRequest(String str, Integer num) {
        this.country = str;
        this.user_id = num;
    }

    private QueryContactInfoRequest(Builder builder) {
        this(builder.country, builder.user_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QueryContactInfoRequest)) {
            return false;
        }
        QueryContactInfoRequest queryContactInfoRequest = (QueryContactInfoRequest) obj;
        if (!equals((Object) this.country, (Object) queryContactInfoRequest.country) || !equals((Object) this.user_id, (Object) queryContactInfoRequest.user_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.country;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.user_id;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<QueryContactInfoRequest> {
        public String country;
        public Integer user_id;

        public Builder() {
        }

        public Builder(QueryContactInfoRequest queryContactInfoRequest) {
            super(queryContactInfoRequest);
            if (queryContactInfoRequest != null) {
                this.country = queryContactInfoRequest.country;
                this.user_id = queryContactInfoRequest.user_id;
            }
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder user_id(Integer num) {
            this.user_id = num;
            return this;
        }

        public QueryContactInfoRequest build() {
            return new QueryContactInfoRequest(this);
        }
    }
}
