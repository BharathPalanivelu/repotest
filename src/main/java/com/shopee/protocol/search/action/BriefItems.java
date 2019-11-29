package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BriefItems extends Message {
    public static final List<BriefItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = BriefItem.class, tag = 1)
    public final List<BriefItem> items;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer total;

    public BriefItems(List<BriefItem> list, Integer num) {
        this.items = immutableCopyOf(list);
        this.total = num;
    }

    private BriefItems(Builder builder) {
        this(builder.items, builder.total);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BriefItems)) {
            return false;
        }
        BriefItems briefItems = (BriefItems) obj;
        if (!equals((List<?>) this.items, (List<?>) briefItems.items) || !equals((Object) this.total, (Object) briefItems.total)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<BriefItem> list = this.items;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Integer num = this.total;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<BriefItems> {
        public List<BriefItem> items;
        public Integer total;

        public Builder() {
        }

        public Builder(BriefItems briefItems) {
            super(briefItems);
            if (briefItems != null) {
                this.items = BriefItems.copyOf(briefItems.items);
                this.total = briefItems.total;
            }
        }

        public Builder items(List<BriefItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder total(Integer num) {
            this.total = num;
            return this;
        }

        public BriefItems build() {
            return new BriefItems(this);
        }
    }
}
