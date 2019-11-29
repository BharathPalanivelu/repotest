package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class Feed extends Message {
    public static final Integer DEFAULT_CMT_COUNT = 0;
    public static final Integer DEFAULT_CONTACT_TYPE = 0;
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Long DEFAULT_FEEDID = 0L;
    public static final Long DEFAULT_FEED_TIME = 0L;
    public static final Integer DEFAULT_FEED_TYPE = 0;
    public static final String DEFAULT_FRIEND_NAME = "";
    public static final List<FeedItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_ITEM_COUNT = 0;
    public static final Boolean DEFAULT_LIKED = false;
    public static final Integer DEFAULT_LIKED_COUNT = 0;
    public static final Integer DEFAULT_OPT = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer cmt_count;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer contact_type;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long feed_time;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer feed_type;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long feedid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String friend_name;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer item_count;
    @ProtoField(label = Message.Label.REPEATED, messageType = FeedItem.class, tag = 5)
    public final List<FeedItem> items;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean liked;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer liked_count;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer opt;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public Feed(Integer num, Integer num2, Integer num3, Integer num4, List<FeedItem> list, Long l, String str, Long l2, Integer num5, Integer num6, Integer num7, Integer num8, Boolean bool, String str2) {
        this.feed_type = num;
        this.userid = num2;
        this.shopid = num3;
        this.item_count = num4;
        this.items = immutableCopyOf(list);
        this.feed_time = l;
        this.friend_name = str;
        this.feedid = l2;
        this.opt = num5;
        this.contact_type = num6;
        this.liked_count = num7;
        this.cmt_count = num8;
        this.liked = bool;
        this.debug_msg = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Feed(com.shopee.protocol.action.Feed.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Integer r2 = r0.feed_type
            java.lang.Integer r3 = r0.userid
            java.lang.Integer r4 = r0.shopid
            java.lang.Integer r5 = r0.item_count
            java.util.List<com.shopee.protocol.action.FeedItem> r6 = r0.items
            java.lang.Long r7 = r0.feed_time
            java.lang.String r8 = r0.friend_name
            java.lang.Long r9 = r0.feedid
            java.lang.Integer r10 = r0.opt
            java.lang.Integer r11 = r0.contact_type
            java.lang.Integer r12 = r0.liked_count
            java.lang.Integer r13 = r0.cmt_count
            java.lang.Boolean r14 = r0.liked
            java.lang.String r15 = r0.debug_msg
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.Feed.<init>(com.shopee.protocol.action.Feed$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Feed)) {
            return false;
        }
        Feed feed = (Feed) obj;
        if (!equals((Object) this.feed_type, (Object) feed.feed_type) || !equals((Object) this.userid, (Object) feed.userid) || !equals((Object) this.shopid, (Object) feed.shopid) || !equals((Object) this.item_count, (Object) feed.item_count) || !equals((List<?>) this.items, (List<?>) feed.items) || !equals((Object) this.feed_time, (Object) feed.feed_time) || !equals((Object) this.friend_name, (Object) feed.friend_name) || !equals((Object) this.feedid, (Object) feed.feedid) || !equals((Object) this.opt, (Object) feed.opt) || !equals((Object) this.contact_type, (Object) feed.contact_type) || !equals((Object) this.liked_count, (Object) feed.liked_count) || !equals((Object) this.cmt_count, (Object) feed.cmt_count) || !equals((Object) this.liked, (Object) feed.liked) || !equals((Object) this.debug_msg, (Object) feed.debug_msg)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.feed_type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.item_count;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        List<FeedItem> list = this.items;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.feed_time;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.friend_name;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        Long l2 = this.feedid;
        int hashCode8 = (hashCode7 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num5 = this.opt;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.contact_type;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.liked_count;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.cmt_count;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Boolean bool = this.liked;
        int hashCode13 = (hashCode12 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Feed> {
        public Integer cmt_count;
        public Integer contact_type;
        public String debug_msg;
        public Long feed_time;
        public Integer feed_type;
        public Long feedid;
        public String friend_name;
        public Integer item_count;
        public List<FeedItem> items;
        public Boolean liked;
        public Integer liked_count;
        public Integer opt;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(Feed feed) {
            super(feed);
            if (feed != null) {
                this.feed_type = feed.feed_type;
                this.userid = feed.userid;
                this.shopid = feed.shopid;
                this.item_count = feed.item_count;
                this.items = Feed.copyOf(feed.items);
                this.feed_time = feed.feed_time;
                this.friend_name = feed.friend_name;
                this.feedid = feed.feedid;
                this.opt = feed.opt;
                this.contact_type = feed.contact_type;
                this.liked_count = feed.liked_count;
                this.cmt_count = feed.cmt_count;
                this.liked = feed.liked;
                this.debug_msg = feed.debug_msg;
            }
        }

        public Builder feed_type(Integer num) {
            this.feed_type = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder item_count(Integer num) {
            this.item_count = num;
            return this;
        }

        public Builder items(List<FeedItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder feed_time(Long l) {
            this.feed_time = l;
            return this;
        }

        public Builder friend_name(String str) {
            this.friend_name = str;
            return this;
        }

        public Builder feedid(Long l) {
            this.feedid = l;
            return this;
        }

        public Builder opt(Integer num) {
            this.opt = num;
            return this;
        }

        public Builder contact_type(Integer num) {
            this.contact_type = num;
            return this;
        }

        public Builder liked_count(Integer num) {
            this.liked_count = num;
            return this;
        }

        public Builder cmt_count(Integer num) {
            this.cmt_count = num;
            return this;
        }

        public Builder liked(Boolean bool) {
            this.liked = bool;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Feed build() {
            return new Feed(this);
        }
    }
}
