package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetBlockPlatformRequest extends Message {
    public static final List<BlockPlatformInfo> DEFAULT_BLOCK_PLATFORM_INFOS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = BlockPlatformInfo.class, tag = 2)
    public final List<BlockPlatformInfo> block_platform_infos;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public SetBlockPlatformRequest(RequestHeader requestHeader, List<BlockPlatformInfo> list) {
        this.header = requestHeader;
        this.block_platform_infos = immutableCopyOf(list);
    }

    private SetBlockPlatformRequest(Builder builder) {
        this(builder.header, builder.block_platform_infos);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetBlockPlatformRequest)) {
            return false;
        }
        SetBlockPlatformRequest setBlockPlatformRequest = (SetBlockPlatformRequest) obj;
        if (!equals((Object) this.header, (Object) setBlockPlatformRequest.header) || !equals((List<?>) this.block_platform_infos, (List<?>) setBlockPlatformRequest.block_platform_infos)) {
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
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        List<BlockPlatformInfo> list = this.block_platform_infos;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SetBlockPlatformRequest> {
        public List<BlockPlatformInfo> block_platform_infos;
        public RequestHeader header;

        public Builder() {
        }

        public Builder(SetBlockPlatformRequest setBlockPlatformRequest) {
            super(setBlockPlatformRequest);
            if (setBlockPlatformRequest != null) {
                this.header = setBlockPlatformRequest.header;
                this.block_platform_infos = SetBlockPlatformRequest.copyOf(setBlockPlatformRequest.block_platform_infos);
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder block_platform_infos(List<BlockPlatformInfo> list) {
            this.block_platform_infos = checkForNulls(list);
            return this;
        }

        public SetBlockPlatformRequest build() {
            return new SetBlockPlatformRequest(this);
        }
    }
}
