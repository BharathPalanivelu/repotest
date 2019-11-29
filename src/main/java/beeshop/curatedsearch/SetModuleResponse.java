package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetModuleResponse extends Message {
    public static final ErrCode DEFAULT_CODE = ErrCode.Success;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final ErrCode code;
    @ProtoField(tag = 2)
    public final CuratedModule module;

    public SetModuleResponse(ErrCode errCode, CuratedModule curatedModule) {
        this.code = errCode;
        this.module = curatedModule;
    }

    private SetModuleResponse(Builder builder) {
        this(builder.code, builder.module);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetModuleResponse)) {
            return false;
        }
        SetModuleResponse setModuleResponse = (SetModuleResponse) obj;
        if (!equals((Object) this.code, (Object) setModuleResponse.code) || !equals((Object) this.module, (Object) setModuleResponse.module)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ErrCode errCode = this.code;
        int i2 = 0;
        int hashCode = (errCode != null ? errCode.hashCode() : 0) * 37;
        CuratedModule curatedModule = this.module;
        if (curatedModule != null) {
            i2 = curatedModule.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetModuleResponse> {
        public ErrCode code;
        public CuratedModule module;

        public Builder() {
        }

        public Builder(SetModuleResponse setModuleResponse) {
            super(setModuleResponse);
            if (setModuleResponse != null) {
                this.code = setModuleResponse.code;
                this.module = setModuleResponse.module;
            }
        }

        public Builder code(ErrCode errCode) {
            this.code = errCode;
            return this;
        }

        public Builder module(CuratedModule curatedModule) {
            this.module = curatedModule;
            return this;
        }

        public SetModuleResponse build() {
            return new SetModuleResponse(this);
        }
    }
}
