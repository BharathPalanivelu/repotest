package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemCmt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseItemCmtList extends Message {
    public static final List<CmtidLike> DEFAULT_CMTIDLIKELIST = Collections.emptyList();
    public static final List<ItemCmt> DEFAULT_COMMENT = Collections.emptyList();
    public static final Integer DEFAULT_COUNT_ALL = 0;
    public static final Integer DEFAULT_COUNT_REVIEW = 0;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CmtidLike.class, tag = 7)
    public final List<CmtidLike> cmtidLikeList;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemCmt.class, tag = 3)
    public final List<ItemCmt> comment;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer count_all;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer count_review;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseItemCmtList(String str, Integer num, List<ItemCmt> list, Long l, Integer num2, Integer num3, List<CmtidLike> list2) {
        this.requestid = str;
        this.errcode = num;
        this.comment = immutableCopyOf(list);
        this.itemid = l;
        this.count_all = num2;
        this.count_review = num3;
        this.cmtidLikeList = immutableCopyOf(list2);
    }

    private ResponseItemCmtList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.comment, builder.itemid, builder.count_all, builder.count_review, builder.cmtidLikeList);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseItemCmtList)) {
            return false;
        }
        ResponseItemCmtList responseItemCmtList = (ResponseItemCmtList) obj;
        if (!equals((Object) this.requestid, (Object) responseItemCmtList.requestid) || !equals((Object) this.errcode, (Object) responseItemCmtList.errcode) || !equals((List<?>) this.comment, (List<?>) responseItemCmtList.comment) || !equals((Object) this.itemid, (Object) responseItemCmtList.itemid) || !equals((Object) this.count_all, (Object) responseItemCmtList.count_all) || !equals((Object) this.count_review, (Object) responseItemCmtList.count_review) || !equals((List<?>) this.cmtidLikeList, (List<?>) responseItemCmtList.cmtidLikeList)) {
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
        List<ItemCmt> list = this.comment;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.itemid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.count_all;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.count_review;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i4 = (hashCode5 + i2) * 37;
        List<CmtidLike> list2 = this.cmtidLikeList;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseItemCmtList> {
        public List<CmtidLike> cmtidLikeList;
        public List<ItemCmt> comment;
        public Integer count_all;
        public Integer count_review;
        public Integer errcode;
        public Long itemid;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseItemCmtList responseItemCmtList) {
            super(responseItemCmtList);
            if (responseItemCmtList != null) {
                this.requestid = responseItemCmtList.requestid;
                this.errcode = responseItemCmtList.errcode;
                this.comment = ResponseItemCmtList.copyOf(responseItemCmtList.comment);
                this.itemid = responseItemCmtList.itemid;
                this.count_all = responseItemCmtList.count_all;
                this.count_review = responseItemCmtList.count_review;
                this.cmtidLikeList = ResponseItemCmtList.copyOf(responseItemCmtList.cmtidLikeList);
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

        public Builder comment(List<ItemCmt> list) {
            this.comment = checkForNulls(list);
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder count_all(Integer num) {
            this.count_all = num;
            return this;
        }

        public Builder count_review(Integer num) {
            this.count_review = num;
            return this;
        }

        public Builder cmtidLikeList(List<CmtidLike> list) {
            this.cmtidLikeList = checkForNulls(list);
            return this;
        }

        public ResponseItemCmtList build() {
            checkRequiredFields();
            return new ResponseItemCmtList(this);
        }
    }
}
