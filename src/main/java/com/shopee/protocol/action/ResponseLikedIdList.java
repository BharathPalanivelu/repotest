package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseLikedIdList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<ShopItemId> DEFAULT_IDLIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopItemId.class, tag = 3)
    public final List<ShopItemId> idlist;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseLikedIdList(String str, Integer num, List<ShopItemId> list) {
        this.requestid = str;
        this.errcode = num;
        this.idlist = immutableCopyOf(list);
    }

    private ResponseLikedIdList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.idlist);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseLikedIdList)) {
            return false;
        }
        ResponseLikedIdList responseLikedIdList = (ResponseLikedIdList) obj;
        if (!equals((Object) this.requestid, (Object) responseLikedIdList.requestid) || !equals((Object) this.errcode, (Object) responseLikedIdList.errcode) || !equals((List<?>) this.idlist, (List<?>) responseLikedIdList.idlist)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<ShopItemId> list = this.idlist;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseLikedIdList> {
        public Integer errcode;
        public List<ShopItemId> idlist;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseLikedIdList responseLikedIdList) {
            super(responseLikedIdList);
            if (responseLikedIdList != null) {
                this.requestid = responseLikedIdList.requestid;
                this.errcode = responseLikedIdList.errcode;
                this.idlist = ResponseLikedIdList.copyOf(responseLikedIdList.idlist);
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

        public Builder idlist(List<ShopItemId> list) {
            this.idlist = checkForNulls(list);
            return this;
        }

        public ResponseLikedIdList build() {
            checkRequiredFields();
            return new ResponseLikedIdList(this);
        }
    }
}
