package com.shopee.protocol.action;

import com.shopee.protocol.shop.ShopStats;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AddStats extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final List<ShopStats> DEFAULT_STATS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopStats.class, tag = 2)
    public final List<ShopStats> stats;

    public AddStats(String str, List<ShopStats> list) {
        this.requestid = str;
        this.stats = immutableCopyOf(list);
    }

    private AddStats(Builder builder) {
        this(builder.requestid, builder.stats);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddStats)) {
            return false;
        }
        AddStats addStats = (AddStats) obj;
        if (!equals((Object) this.requestid, (Object) addStats.requestid) || !equals((List<?>) this.stats, (List<?>) addStats.stats)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<ShopStats> list = this.stats;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<AddStats> {
        public String requestid;
        public List<ShopStats> stats;

        public Builder() {
        }

        public Builder(AddStats addStats) {
            super(addStats);
            if (addStats != null) {
                this.requestid = addStats.requestid;
                this.stats = AddStats.copyOf(addStats.stats);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder stats(List<ShopStats> list) {
            this.stats = checkForNulls(list);
            return this;
        }

        public AddStats build() {
            return new AddStats(this);
        }
    }
}
