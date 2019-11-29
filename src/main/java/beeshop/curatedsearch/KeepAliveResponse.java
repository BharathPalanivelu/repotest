package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class KeepAliveResponse extends Message {
    public static final ErrCode DEFAULT_CODE = ErrCode.Success;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final ErrCode code;

    public KeepAliveResponse(ErrCode errCode) {
        this.code = errCode;
    }

    private KeepAliveResponse(Builder builder) {
        this(builder.code);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeepAliveResponse)) {
            return false;
        }
        return equals((Object) this.code, (Object) ((KeepAliveResponse) obj).code);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            ErrCode errCode = this.code;
            i = errCode != null ? errCode.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<KeepAliveResponse> {
        public ErrCode code;

        public Builder() {
        }

        public Builder(KeepAliveResponse keepAliveResponse) {
            super(keepAliveResponse);
            if (keepAliveResponse != null) {
                this.code = keepAliveResponse.code;
            }
        }

        public Builder code(ErrCode errCode) {
            this.code = errCode;
            return this;
        }

        public KeepAliveResponse build() {
            return new KeepAliveResponse(this);
        }
    }
}
