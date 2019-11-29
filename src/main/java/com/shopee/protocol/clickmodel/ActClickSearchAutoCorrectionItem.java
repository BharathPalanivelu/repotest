package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActClickSearchAutoCorrectionItem extends Message {
    public static final String DEFAULT_KEYWORD = "";
    public static final String DEFAULT_SUGGESTION = "";
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String suggestion;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userid;

    public ActClickSearchAutoCorrectionItem(Long l, String str, String str2) {
        this.userid = l;
        this.keyword = str;
        this.suggestion = str2;
    }

    private ActClickSearchAutoCorrectionItem(Builder builder) {
        this(builder.userid, builder.keyword, builder.suggestion);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActClickSearchAutoCorrectionItem)) {
            return false;
        }
        ActClickSearchAutoCorrectionItem actClickSearchAutoCorrectionItem = (ActClickSearchAutoCorrectionItem) obj;
        if (!equals((Object) this.userid, (Object) actClickSearchAutoCorrectionItem.userid) || !equals((Object) this.keyword, (Object) actClickSearchAutoCorrectionItem.keyword) || !equals((Object) this.suggestion, (Object) actClickSearchAutoCorrectionItem.suggestion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.userid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.keyword;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.suggestion;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActClickSearchAutoCorrectionItem> {
        public String keyword;
        public String suggestion;
        public Long userid;

        public Builder() {
        }

        public Builder(ActClickSearchAutoCorrectionItem actClickSearchAutoCorrectionItem) {
            super(actClickSearchAutoCorrectionItem);
            if (actClickSearchAutoCorrectionItem != null) {
                this.userid = actClickSearchAutoCorrectionItem.userid;
                this.keyword = actClickSearchAutoCorrectionItem.keyword;
                this.suggestion = actClickSearchAutoCorrectionItem.suggestion;
            }
        }

        public Builder userid(Long l) {
            this.userid = l;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder suggestion(String str) {
            this.suggestion = str;
            return this;
        }

        public ActClickSearchAutoCorrectionItem build() {
            return new ActClickSearchAutoCorrectionItem(this);
        }
    }
}
