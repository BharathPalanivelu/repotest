package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemCmt;
import com.shopee.protocol.shop.UserCmt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseItemCmt extends Message {
    public static final List<CmtidLike> DEFAULT_CMTIDLIKELIST = Collections.emptyList();
    public static final List<ItemCmt> DEFAULT_COMMENT = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final UserCmt buyer_rating;
    @ProtoField(label = Message.Label.REPEATED, messageType = CmtidLike.class, tag = 5)
    public final List<CmtidLike> cmtidLikeList;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemCmt.class, tag = 3)
    public final List<ItemCmt> comment;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseItemCmt(String str, Integer num, List<ItemCmt> list, UserCmt userCmt, List<CmtidLike> list2) {
        this.requestid = str;
        this.errcode = num;
        this.comment = immutableCopyOf(list);
        this.buyer_rating = userCmt;
        this.cmtidLikeList = immutableCopyOf(list2);
    }

    private ResponseItemCmt(Builder builder) {
        this(builder.requestid, builder.errcode, builder.comment, builder.buyer_rating, builder.cmtidLikeList);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseItemCmt)) {
            return false;
        }
        ResponseItemCmt responseItemCmt = (ResponseItemCmt) obj;
        if (!equals((Object) this.requestid, (Object) responseItemCmt.requestid) || !equals((Object) this.errcode, (Object) responseItemCmt.errcode) || !equals((List<?>) this.comment, (List<?>) responseItemCmt.comment) || !equals((Object) this.buyer_rating, (Object) responseItemCmt.buyer_rating) || !equals((List<?>) this.cmtidLikeList, (List<?>) responseItemCmt.cmtidLikeList)) {
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
        UserCmt userCmt = this.buyer_rating;
        if (userCmt != null) {
            i2 = userCmt.hashCode();
        }
        int i4 = (hashCode3 + i2) * 37;
        List<CmtidLike> list2 = this.cmtidLikeList;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseItemCmt> {
        public UserCmt buyer_rating;
        public List<CmtidLike> cmtidLikeList;
        public List<ItemCmt> comment;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseItemCmt responseItemCmt) {
            super(responseItemCmt);
            if (responseItemCmt != null) {
                this.requestid = responseItemCmt.requestid;
                this.errcode = responseItemCmt.errcode;
                this.comment = ResponseItemCmt.copyOf(responseItemCmt.comment);
                this.buyer_rating = responseItemCmt.buyer_rating;
                this.cmtidLikeList = ResponseItemCmt.copyOf(responseItemCmt.cmtidLikeList);
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

        public Builder buyer_rating(UserCmt userCmt) {
            this.buyer_rating = userCmt;
            return this;
        }

        public Builder cmtidLikeList(List<CmtidLike> list) {
            this.cmtidLikeList = checkForNulls(list);
            return this;
        }

        public ResponseItemCmt build() {
            checkRequiredFields();
            return new ResponseItemCmt(this);
        }
    }
}
