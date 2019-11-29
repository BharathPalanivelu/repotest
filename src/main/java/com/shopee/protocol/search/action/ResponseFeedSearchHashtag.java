package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseFeedSearchHashtag extends Message {
    public static final ErrCode DEFAULT_ERR_CODE = ErrCode.Success;
    public static final List<ResultHashtag> DEFAULT_HASHTAGS = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL_COUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.ENUM)
    public final ErrCode err_code;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResultHashtag.class, tag = 4)
    public final List<ResultHashtag> hashtags;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer total_count;

    public ResponseFeedSearchHashtag(ResponseHeader responseHeader, ErrCode errCode, Integer num, List<ResultHashtag> list) {
        this.header = responseHeader;
        this.err_code = errCode;
        this.total_count = num;
        this.hashtags = immutableCopyOf(list);
    }

    private ResponseFeedSearchHashtag(Builder builder) {
        this(builder.header, builder.err_code, builder.total_count, builder.hashtags);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseFeedSearchHashtag)) {
            return false;
        }
        ResponseFeedSearchHashtag responseFeedSearchHashtag = (ResponseFeedSearchHashtag) obj;
        if (!equals((Object) this.header, (Object) responseFeedSearchHashtag.header) || !equals((Object) this.err_code, (Object) responseFeedSearchHashtag.err_code) || !equals((Object) this.total_count, (Object) responseFeedSearchHashtag.total_count) || !equals((List<?>) this.hashtags, (List<?>) responseFeedSearchHashtag.hashtags)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int i2 = 0;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        ErrCode errCode = this.err_code;
        int hashCode2 = (hashCode + (errCode != null ? errCode.hashCode() : 0)) * 37;
        Integer num = this.total_count;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<ResultHashtag> list = this.hashtags;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<ResponseFeedSearchHashtag> {
        public ErrCode err_code;
        public List<ResultHashtag> hashtags;
        public ResponseHeader header;
        public Integer total_count;

        public Builder() {
        }

        public Builder(ResponseFeedSearchHashtag responseFeedSearchHashtag) {
            super(responseFeedSearchHashtag);
            if (responseFeedSearchHashtag != null) {
                this.header = responseFeedSearchHashtag.header;
                this.err_code = responseFeedSearchHashtag.err_code;
                this.total_count = responseFeedSearchHashtag.total_count;
                this.hashtags = ResponseFeedSearchHashtag.copyOf(responseFeedSearchHashtag.hashtags);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder err_code(ErrCode errCode) {
            this.err_code = errCode;
            return this;
        }

        public Builder total_count(Integer num) {
            this.total_count = num;
            return this;
        }

        public Builder hashtags(List<ResultHashtag> list) {
            this.hashtags = checkForNulls(list);
            return this;
        }

        public ResponseFeedSearchHashtag build() {
            return new ResponseFeedSearchHashtag(this);
        }
    }
}
