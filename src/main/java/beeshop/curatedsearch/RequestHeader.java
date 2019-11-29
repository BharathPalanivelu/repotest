package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestHeader extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_OPERATOR = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String operator;

    public RequestHeader(String str, String str2) {
        this.country = str;
        this.operator = str2;
    }

    private RequestHeader(Builder builder) {
        this(builder.country, builder.operator);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestHeader)) {
            return false;
        }
        RequestHeader requestHeader = (RequestHeader) obj;
        if (!equals((Object) this.country, (Object) requestHeader.country) || !equals((Object) this.operator, (Object) requestHeader.operator)) {
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
        String str2 = this.operator;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestHeader> {
        public String country;
        public String operator;

        public Builder() {
        }

        public Builder(RequestHeader requestHeader) {
            super(requestHeader);
            if (requestHeader != null) {
                this.country = requestHeader.country;
                this.operator = requestHeader.operator;
            }
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public RequestHeader build() {
            return new RequestHeader(this);
        }
    }
}
