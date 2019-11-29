package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetHotHashTagList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<HotHashTagInfo> DEFAULT_HASHTAG_LIST = Collections.emptyList();
    public static final Long DEFAULT_HOT_HASHTAG_COUNT = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = HotHashTagInfo.class, tag = 3)
    public final List<HotHashTagInfo> hashtag_list;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long hot_hashtag_count;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5)
    public final HotHashTagInfo seeall_hashtag;

    public ResponseGetHotHashTagList(String str, Integer num, List<HotHashTagInfo> list, Long l, HotHashTagInfo hotHashTagInfo) {
        this.requestid = str;
        this.errcode = num;
        this.hashtag_list = immutableCopyOf(list);
        this.hot_hashtag_count = l;
        this.seeall_hashtag = hotHashTagInfo;
    }

    private ResponseGetHotHashTagList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.hashtag_list, builder.hot_hashtag_count, builder.seeall_hashtag);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetHotHashTagList)) {
            return false;
        }
        ResponseGetHotHashTagList responseGetHotHashTagList = (ResponseGetHotHashTagList) obj;
        if (!equals((Object) this.requestid, (Object) responseGetHotHashTagList.requestid) || !equals((Object) this.errcode, (Object) responseGetHotHashTagList.errcode) || !equals((List<?>) this.hashtag_list, (List<?>) responseGetHotHashTagList.hashtag_list) || !equals((Object) this.hot_hashtag_count, (Object) responseGetHotHashTagList.hot_hashtag_count) || !equals((Object) this.seeall_hashtag, (Object) responseGetHotHashTagList.seeall_hashtag)) {
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
        List<HotHashTagInfo> list = this.hashtag_list;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.hot_hashtag_count;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        HotHashTagInfo hotHashTagInfo = this.seeall_hashtag;
        if (hotHashTagInfo != null) {
            i2 = hotHashTagInfo.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetHotHashTagList> {
        public Integer errcode;
        public List<HotHashTagInfo> hashtag_list;
        public Long hot_hashtag_count;
        public String requestid;
        public HotHashTagInfo seeall_hashtag;

        public Builder() {
        }

        public Builder(ResponseGetHotHashTagList responseGetHotHashTagList) {
            super(responseGetHotHashTagList);
            if (responseGetHotHashTagList != null) {
                this.requestid = responseGetHotHashTagList.requestid;
                this.errcode = responseGetHotHashTagList.errcode;
                this.hashtag_list = ResponseGetHotHashTagList.copyOf(responseGetHotHashTagList.hashtag_list);
                this.hot_hashtag_count = responseGetHotHashTagList.hot_hashtag_count;
                this.seeall_hashtag = responseGetHotHashTagList.seeall_hashtag;
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

        public Builder hashtag_list(List<HotHashTagInfo> list) {
            this.hashtag_list = checkForNulls(list);
            return this;
        }

        public Builder hot_hashtag_count(Long l) {
            this.hot_hashtag_count = l;
            return this;
        }

        public Builder seeall_hashtag(HotHashTagInfo hotHashTagInfo) {
            this.seeall_hashtag = hotHashTagInfo;
            return this;
        }

        public ResponseGetHotHashTagList build() {
            checkRequiredFields();
            return new ResponseGetHotHashTagList(this);
        }
    }
}
