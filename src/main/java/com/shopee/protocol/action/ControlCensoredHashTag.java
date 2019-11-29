package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ControlCensoredHashTag extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final List<String> DEFAULT_HASHTAG_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.STRING)
    public final List<String> hashtag_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;

    public ControlCensoredHashTag(String str, Integer num, String str2, List<String> list) {
        this.requestid = str;
        this.type = num;
        this.country = str2;
        this.hashtag_list = immutableCopyOf(list);
    }

    private ControlCensoredHashTag(Builder builder) {
        this(builder.requestid, builder.type, builder.country, builder.hashtag_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ControlCensoredHashTag)) {
            return false;
        }
        ControlCensoredHashTag controlCensoredHashTag = (ControlCensoredHashTag) obj;
        if (!equals((Object) this.requestid, (Object) controlCensoredHashTag.requestid) || !equals((Object) this.type, (Object) controlCensoredHashTag.type) || !equals((Object) this.country, (Object) controlCensoredHashTag.country) || !equals((List<?>) this.hashtag_list, (List<?>) controlCensoredHashTag.hashtag_list)) {
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
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<String> list = this.hashtag_list;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<ControlCensoredHashTag> {
        public String country;
        public List<String> hashtag_list;
        public String requestid;
        public Integer type;

        public Builder() {
        }

        public Builder(ControlCensoredHashTag controlCensoredHashTag) {
            super(controlCensoredHashTag);
            if (controlCensoredHashTag != null) {
                this.requestid = controlCensoredHashTag.requestid;
                this.type = controlCensoredHashTag.type;
                this.country = controlCensoredHashTag.country;
                this.hashtag_list = ControlCensoredHashTag.copyOf(controlCensoredHashTag.hashtag_list);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder hashtag_list(List<String> list) {
            this.hashtag_list = checkForNulls(list);
            return this;
        }

        public ControlCensoredHashTag build() {
            return new ControlCensoredHashTag(this);
        }
    }
}
