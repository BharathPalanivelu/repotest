package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ActTrackCategoryScroll extends Message {
    public static final String DEFAULT_CATEGORY_ID = "";
    public static final List<Long> DEFAULT_ITEMIDS = Collections.emptyList();
    public static final String DEFAULT_TAB = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String category_id;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> itemids;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String tab;

    public ActTrackCategoryScroll(List<Long> list, String str, String str2) {
        this.itemids = immutableCopyOf(list);
        this.category_id = str;
        this.tab = str2;
    }

    private ActTrackCategoryScroll(Builder builder) {
        this(builder.itemids, builder.category_id, builder.tab);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActTrackCategoryScroll)) {
            return false;
        }
        ActTrackCategoryScroll actTrackCategoryScroll = (ActTrackCategoryScroll) obj;
        if (!equals((List<?>) this.itemids, (List<?>) actTrackCategoryScroll.itemids) || !equals((Object) this.category_id, (Object) actTrackCategoryScroll.category_id) || !equals((Object) this.tab, (Object) actTrackCategoryScroll.tab)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Long> list = this.itemids;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        String str = this.category_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.tab;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActTrackCategoryScroll> {
        public String category_id;
        public List<Long> itemids;
        public String tab;

        public Builder() {
        }

        public Builder(ActTrackCategoryScroll actTrackCategoryScroll) {
            super(actTrackCategoryScroll);
            if (actTrackCategoryScroll != null) {
                this.itemids = ActTrackCategoryScroll.copyOf(actTrackCategoryScroll.itemids);
                this.category_id = actTrackCategoryScroll.category_id;
                this.tab = actTrackCategoryScroll.tab;
            }
        }

        public Builder itemids(List<Long> list) {
            this.itemids = checkForNulls(list);
            return this;
        }

        public Builder category_id(String str) {
            this.category_id = str;
            return this;
        }

        public Builder tab(String str) {
            this.tab = str;
            return this;
        }

        public ActTrackCategoryScroll build() {
            return new ActTrackCategoryScroll(this);
        }
    }
}
