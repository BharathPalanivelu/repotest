package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetBlockPlatformResponse extends Message {
    public static final ErrCode DEFAULT_CODE = ErrCode.Success;
    public static final List<BlockPlatformInfo> DEFAULT_FAILED_BLOCK_PLATFORM_INFOS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final ErrCode code;
    @ProtoField(label = Message.Label.REPEATED, messageType = BlockPlatformInfo.class, tag = 2)
    public final List<BlockPlatformInfo> failed_block_platform_infos;

    public SetBlockPlatformResponse(ErrCode errCode, List<BlockPlatformInfo> list) {
        this.code = errCode;
        this.failed_block_platform_infos = immutableCopyOf(list);
    }

    private SetBlockPlatformResponse(Builder builder) {
        this(builder.code, builder.failed_block_platform_infos);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetBlockPlatformResponse)) {
            return false;
        }
        SetBlockPlatformResponse setBlockPlatformResponse = (SetBlockPlatformResponse) obj;
        if (!equals((Object) this.code, (Object) setBlockPlatformResponse.code) || !equals((List<?>) this.failed_block_platform_infos, (List<?>) setBlockPlatformResponse.failed_block_platform_infos)) {
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
        int hashCode = (errCode != null ? errCode.hashCode() : 0) * 37;
        List<BlockPlatformInfo> list = this.failed_block_platform_infos;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SetBlockPlatformResponse> {
        public ErrCode code;
        public List<BlockPlatformInfo> failed_block_platform_infos;

        public Builder() {
        }

        public Builder(SetBlockPlatformResponse setBlockPlatformResponse) {
            super(setBlockPlatformResponse);
            if (setBlockPlatformResponse != null) {
                this.code = setBlockPlatformResponse.code;
                this.failed_block_platform_infos = SetBlockPlatformResponse.copyOf(setBlockPlatformResponse.failed_block_platform_infos);
            }
        }

        public Builder code(ErrCode errCode) {
            this.code = errCode;
            return this;
        }

        public Builder failed_block_platform_infos(List<BlockPlatformInfo> list) {
            this.failed_block_platform_infos = checkForNulls(list);
            return this;
        }

        public SetBlockPlatformResponse build() {
            return new SetBlockPlatformResponse(this);
        }
    }
}
