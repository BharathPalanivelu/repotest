package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ActTrackCategoryScrollV1 extends Message {
    public static final String DEFAULT_CATEGORY_ID = "";
    public static final List<String> DEFAULT_ITEMIDS = Collections.emptyList();
    public static final String DEFAULT_TAB = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String category_id;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.STRING)
    public final List<String> itemids;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String tab;

    public ActTrackCategoryScrollV1(List<String> list, String str, String str2) {
        this.itemids = immutableCopyOf(list);
        this.category_id = str;
        this.tab = str2;
    }

    private ActTrackCategoryScrollV1(Builder builder) {
        this(builder.itemids, builder.category_id, builder.tab);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActTrackCategoryScrollV1)) {
            return false;
        }
        ActTrackCategoryScrollV1 actTrackCategoryScrollV1 = (ActTrackCategoryScrollV1) obj;
        if (!equals((List<?>) this.itemids, (List<?>) actTrackCategoryScrollV1.itemids) || !equals((Object) this.category_id, (Object) actTrackCategoryScrollV1.category_id) || !equals((Object) this.tab, (Object) actTrackCategoryScrollV1.tab)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<String> list = this.itemids;
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

    public static final class Builder extends Message.Builder<ActTrackCategoryScrollV1> {
        public String category_id;
        public List<String> itemids;
        public String tab;

        public Builder() {
        }

        public Builder(ActTrackCategoryScrollV1 actTrackCategoryScrollV1) {
            super(actTrackCategoryScrollV1);
            if (actTrackCategoryScrollV1 != null) {
                this.itemids = ActTrackCategoryScrollV1.copyOf(actTrackCategoryScrollV1.itemids);
                this.category_id = actTrackCategoryScrollV1.category_id;
                this.tab = actTrackCategoryScrollV1.tab;
            }
        }

        public Builder itemids(List<String> list) {
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

        public ActTrackCategoryScrollV1 build() {
            return new ActTrackCategoryScrollV1(this);
        }
    }
}
