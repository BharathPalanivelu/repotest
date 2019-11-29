package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseFeedList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<Feed> DEFAULT_FEEDLIST = Collections.emptyList();
    public static final Boolean DEFAULT_LOAD_MORE = false;
    public static final Integer DEFAULT_NEW_COUNT = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = Feed.class, tag = 3)
    public final List<Feed> feedlist;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean load_more;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer new_count;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseFeedList(String str, Integer num, List<Feed> list, Boolean bool, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.feedlist = immutableCopyOf(list);
        this.load_more = bool;
        this.new_count = num2;
    }

    private ResponseFeedList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.feedlist, builder.load_more, builder.new_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseFeedList)) {
            return false;
        }
        ResponseFeedList responseFeedList = (ResponseFeedList) obj;
        if (!equals((Object) this.requestid, (Object) responseFeedList.requestid) || !equals((Object) this.errcode, (Object) responseFeedList.errcode) || !equals((List<?>) this.feedlist, (List<?>) responseFeedList.feedlist) || !equals((Object) this.load_more, (Object) responseFeedList.load_more) || !equals((Object) this.new_count, (Object) responseFeedList.new_count)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<Feed> list = this.feedlist;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.load_more;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num2 = this.new_count;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseFeedList> {
        public Integer errcode;
        public List<Feed> feedlist;
        public Boolean load_more;
        public Integer new_count;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseFeedList responseFeedList) {
            super(responseFeedList);
            if (responseFeedList != null) {
                this.requestid = responseFeedList.requestid;
                this.errcode = responseFeedList.errcode;
                this.feedlist = ResponseFeedList.copyOf(responseFeedList.feedlist);
                this.load_more = responseFeedList.load_more;
                this.new_count = responseFeedList.new_count;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder feedlist(List<Feed> list) {
            this.feedlist = checkForNulls(list);
            return this;
        }

        public Builder load_more(Boolean bool) {
            this.load_more = bool;
            return this;
        }

        public Builder new_count(Integer num) {
            this.new_count = num;
            return this;
        }

        public ResponseFeedList build() {
            checkRequiredFields();
            return new ResponseFeedList(this);
        }
    }
}
