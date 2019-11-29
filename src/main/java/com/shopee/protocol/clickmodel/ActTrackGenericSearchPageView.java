package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActTrackGenericSearchPageView extends Message {
    public static final Integer DEFAULT_COUNT = 0;
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_PAGE_TYPE = 0;
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer page_type;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long userid;

    public ActTrackGenericSearchPageView(String str, Integer num, Integer num2, Long l) {
        this.keyword = str;
        this.page_type = num;
        this.count = num2;
        this.userid = l;
    }

    private ActTrackGenericSearchPageView(Builder builder) {
        this(builder.keyword, builder.page_type, builder.count, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActTrackGenericSearchPageView)) {
            return false;
        }
        ActTrackGenericSearchPageView actTrackGenericSearchPageView = (ActTrackGenericSearchPageView) obj;
        if (!equals((Object) this.keyword, (Object) actTrackGenericSearchPageView.keyword) || !equals((Object) this.page_type, (Object) actTrackGenericSearchPageView.page_type) || !equals((Object) this.count, (Object) actTrackGenericSearchPageView.count) || !equals((Object) this.userid, (Object) actTrackGenericSearchPageView.userid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.keyword;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.page_type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.count;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.userid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActTrackGenericSearchPageView> {
        public Integer count;
        public String keyword;
        public Integer page_type;
        public Long userid;

        public Builder() {
        }

        public Builder(ActTrackGenericSearchPageView actTrackGenericSearchPageView) {
            super(actTrackGenericSearchPageView);
            if (actTrackGenericSearchPageView != null) {
                this.keyword = actTrackGenericSearchPageView.keyword;
                this.page_type = actTrackGenericSearchPageView.page_type;
                this.count = actTrackGenericSearchPageView.count;
                this.userid = actTrackGenericSearchPageView.userid;
            }
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder page_type(Integer num) {
            this.page_type = num;
            return this;
        }

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public Builder userid(Long l) {
            this.userid = l;
            return this;
        }

        public ActTrackGenericSearchPageView build() {
            return new ActTrackGenericSearchPageView(this);
        }
    }
}
