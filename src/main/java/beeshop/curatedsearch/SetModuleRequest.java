package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetModuleRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 2)
    public final CuratedModule module;

    public SetModuleRequest(RequestHeader requestHeader, CuratedModule curatedModule) {
        this.header = requestHeader;
        this.module = curatedModule;
    }

    private SetModuleRequest(Builder builder) {
        this(builder.header, builder.module);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetModuleRequest)) {
            return false;
        }
        SetModuleRequest setModuleRequest = (SetModuleRequest) obj;
        if (!equals((Object) this.header, (Object) setModuleRequest.header) || !equals((Object) this.module, (Object) setModuleRequest.module)) {
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
        CuratedModule curatedModule = this.module;
        if (curatedModule != null) {
            i2 = curatedModule.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetModuleRequest> {
        public RequestHeader header;
        public CuratedModule module;

        public Builder() {
        }

        public Builder(SetModuleRequest setModuleRequest) {
            super(setModuleRequest);
            if (setModuleRequest != null) {
                this.header = setModuleRequest.header;
                this.module = setModuleRequest.module;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder module(CuratedModule curatedModule) {
            this.module = curatedModule;
            return this;
        }

        public SetModuleRequest build() {
            return new SetModuleRequest(this);
        }
    }
}
