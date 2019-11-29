package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class QueryContactInfoResponse extends Message {
    public static final List<ContactInfo> DEFAULT_CONTACT_INFO = Collections.emptyList();
    public static final Integer DEFAULT_USER_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ContactInfo.class, tag = 2)
    public final List<ContactInfo> contact_info;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer user_id;

    public QueryContactInfoResponse(Integer num, List<ContactInfo> list) {
        this.user_id = num;
        this.contact_info = immutableCopyOf(list);
    }

    private QueryContactInfoResponse(Builder builder) {
        this(builder.user_id, builder.contact_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QueryContactInfoResponse)) {
            return false;
        }
        QueryContactInfoResponse queryContactInfoResponse = (QueryContactInfoResponse) obj;
        if (!equals((Object) this.user_id, (Object) queryContactInfoResponse.user_id) || !equals((List<?>) this.contact_info, (List<?>) queryContactInfoResponse.contact_info)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.user_id;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<ContactInfo> list = this.contact_info;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<QueryContactInfoResponse> {
        public List<ContactInfo> contact_info;
        public Integer user_id;

        public Builder() {
        }

        public Builder(QueryContactInfoResponse queryContactInfoResponse) {
            super(queryContactInfoResponse);
            if (queryContactInfoResponse != null) {
                this.user_id = queryContactInfoResponse.user_id;
                this.contact_info = QueryContactInfoResponse.copyOf(queryContactInfoResponse.contact_info);
            }
        }

        public Builder user_id(Integer num) {
            this.user_id = num;
            return this;
        }

        public Builder contact_info(List<ContactInfo> list) {
            this.contact_info = checkForNulls(list);
            return this;
        }

        public QueryContactInfoResponse build() {
            return new QueryContactInfoResponse(this);
        }
    }
}
