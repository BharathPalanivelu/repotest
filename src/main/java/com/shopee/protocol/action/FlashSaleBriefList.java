package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class FlashSaleBriefList extends Message {
    public static final List<FlashSaleBrief> DEFAULT_BRIEFS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = FlashSaleBrief.class, tag = 1)
    public final List<FlashSaleBrief> briefs;

    public FlashSaleBriefList(List<FlashSaleBrief> list) {
        this.briefs = immutableCopyOf(list);
    }

    private FlashSaleBriefList(Builder builder) {
        this(builder.briefs);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlashSaleBriefList)) {
            return false;
        }
        return equals((List<?>) this.briefs, (List<?>) ((FlashSaleBriefList) obj).briefs);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<FlashSaleBrief> list = this.briefs;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<FlashSaleBriefList> {
        public List<FlashSaleBrief> briefs;

        public Builder() {
        }

        public Builder(FlashSaleBriefList flashSaleBriefList) {
            super(flashSaleBriefList);
            if (flashSaleBriefList != null) {
                this.briefs = FlashSaleBriefList.copyOf(flashSaleBriefList.briefs);
            }
        }

        public Builder briefs(List<FlashSaleBrief> list) {
            this.briefs = checkForNulls(list);
            return this;
        }

        public FlashSaleBriefList build() {
            return new FlashSaleBriefList(this);
        }
    }
}
