package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BlockPlatformInfo extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final List<Integer> DEFAULT_BLOCKED_PLATFORMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long activity_id;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> blocked_platforms;

    public BlockPlatformInfo(Long l, List<Integer> list) {
        this.activity_id = l;
        this.blocked_platforms = immutableCopyOf(list);
    }

    private BlockPlatformInfo(Builder builder) {
        this(builder.activity_id, builder.blocked_platforms);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BlockPlatformInfo)) {
            return false;
        }
        BlockPlatformInfo blockPlatformInfo = (BlockPlatformInfo) obj;
        if (!equals((Object) this.activity_id, (Object) blockPlatformInfo.activity_id) || !equals((List<?>) this.blocked_platforms, (List<?>) blockPlatformInfo.blocked_platforms)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.activity_id;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        List<Integer> list = this.blocked_platforms;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<BlockPlatformInfo> {
        public Long activity_id;
        public List<Integer> blocked_platforms;

        public Builder() {
        }

        public Builder(BlockPlatformInfo blockPlatformInfo) {
            super(blockPlatformInfo);
            if (blockPlatformInfo != null) {
                this.activity_id = blockPlatformInfo.activity_id;
                this.blocked_platforms = BlockPlatformInfo.copyOf(blockPlatformInfo.blocked_platforms);
            }
        }

        public Builder activity_id(Long l) {
            this.activity_id = l;
            return this;
        }

        public Builder blocked_platforms(List<Integer> list) {
            this.blocked_platforms = checkForNulls(list);
            return this;
        }

        public BlockPlatformInfo build() {
            return new BlockPlatformInfo(this);
        }
    }
}
