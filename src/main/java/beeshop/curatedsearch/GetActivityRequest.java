package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetActivityRequest extends Message {
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Boolean DEFAULT_ONLY_ACTIVITY = false;
    public static final Long DEFAULT_STATUS = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean only_activity;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long status;

    public GetActivityRequest(RequestHeader requestHeader, Long l, String str, String str2, Boolean bool, Integer num, Integer num2, Long l2) {
        this.header = requestHeader;
        this.id = l;
        this.name = str;
        this.keyword = str2;
        this.only_activity = bool;
        this.offset = num;
        this.limit = num2;
        this.status = l2;
    }

    private GetActivityRequest(Builder builder) {
        this(builder.header, builder.id, builder.name, builder.keyword, builder.only_activity, builder.offset, builder.limit, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetActivityRequest)) {
            return false;
        }
        GetActivityRequest getActivityRequest = (GetActivityRequest) obj;
        if (!equals((Object) this.header, (Object) getActivityRequest.header) || !equals((Object) this.id, (Object) getActivityRequest.id) || !equals((Object) this.name, (Object) getActivityRequest.name) || !equals((Object) this.keyword, (Object) getActivityRequest.keyword) || !equals((Object) this.only_activity, (Object) getActivityRequest.only_activity) || !equals((Object) this.offset, (Object) getActivityRequest.offset) || !equals((Object) this.limit, (Object) getActivityRequest.limit) || !equals((Object) this.status, (Object) getActivityRequest.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int i2 = 0;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        Long l = this.id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.keyword;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.only_activity;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.offset;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.status;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetActivityRequest> {
        public RequestHeader header;
        public Long id;
        public String keyword;
        public Integer limit;
        public String name;
        public Integer offset;
        public Boolean only_activity;
        public Long status;

        public Builder() {
        }

        public Builder(GetActivityRequest getActivityRequest) {
            super(getActivityRequest);
            if (getActivityRequest != null) {
                this.header = getActivityRequest.header;
                this.id = getActivityRequest.id;
                this.name = getActivityRequest.name;
                this.keyword = getActivityRequest.keyword;
                this.only_activity = getActivityRequest.only_activity;
                this.offset = getActivityRequest.offset;
                this.limit = getActivityRequest.limit;
                this.status = getActivityRequest.status;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder only_activity(Boolean bool) {
            this.only_activity = bool;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder status(Long l) {
            this.status = l;
            return this;
        }

        public GetActivityRequest build() {
            return new GetActivityRequest(this);
        }
    }
}
