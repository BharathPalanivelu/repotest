package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class KeepAliveRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public KeepAliveRequest(RequestHeader requestHeader) {
        this.header = requestHeader;
    }

    private KeepAliveRequest(Builder builder) {
        this(builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeepAliveRequest)) {
            return false;
        }
        return equals((Object) this.header, (Object) ((KeepAliveRequest) obj).header);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            RequestHeader requestHeader = this.header;
            i = requestHeader != null ? requestHeader.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<KeepAliveRequest> {
        public RequestHeader header;

        public Builder() {
        }

        public Builder(KeepAliveRequest keepAliveRequest) {
            super(keepAliveRequest);
            if (keepAliveRequest != null) {
                this.header = keepAliveRequest.header;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public KeepAliveRequest build() {
            return new KeepAliveRequest(this);
        }
    }
}
