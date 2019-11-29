package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetItemCmtList extends Message {
    public static final Integer DEFAULT_APP_VERSION_CODE = 0;
    public static final Boolean DEFAULT_CMT_ONLY = false;
    public static final Long DEFAULT_CURSOR = 0L;
    public static final Integer DEFAULT_FILTER = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_NEED_HIDDEN = false;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Boolean DEFAULT_RATING_ONLY = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer app_version_code;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean cmt_only;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long cursor;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer filter;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean need_hidden;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean rating_only;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer userid;

    public GetItemCmtList(String str, Integer num, Long l, Integer num2, Integer num3, Boolean bool, Long l2, Integer num4, Integer num5, Boolean bool2, Boolean bool3, Integer num6, String str2, Integer num7) {
        this.requestid = str;
        this.shopid = num;
        this.itemid = l;
        this.offset = num2;
        this.limit = num3;
        this.rating_only = bool;
        this.cursor = l2;
        this.type = num4;
        this.userid = num5;
        this.need_hidden = bool2;
        this.cmt_only = bool3;
        this.filter = num6;
        this.token = str2;
        this.app_version_code = num7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private GetItemCmtList(com.shopee.protocol.action.GetItemCmtList.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r2 = r0.requestid
            java.lang.Integer r3 = r0.shopid
            java.lang.Long r4 = r0.itemid
            java.lang.Integer r5 = r0.offset
            java.lang.Integer r6 = r0.limit
            java.lang.Boolean r7 = r0.rating_only
            java.lang.Long r8 = r0.cursor
            java.lang.Integer r9 = r0.type
            java.lang.Integer r10 = r0.userid
            java.lang.Boolean r11 = r0.need_hidden
            java.lang.Boolean r12 = r0.cmt_only
            java.lang.Integer r13 = r0.filter
            java.lang.String r14 = r0.token
            java.lang.Integer r15 = r0.app_version_code
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.GetItemCmtList.<init>(com.shopee.protocol.action.GetItemCmtList$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetItemCmtList)) {
            return false;
        }
        GetItemCmtList getItemCmtList = (GetItemCmtList) obj;
        if (!equals((Object) this.requestid, (Object) getItemCmtList.requestid) || !equals((Object) this.shopid, (Object) getItemCmtList.shopid) || !equals((Object) this.itemid, (Object) getItemCmtList.itemid) || !equals((Object) this.offset, (Object) getItemCmtList.offset) || !equals((Object) this.limit, (Object) getItemCmtList.limit) || !equals((Object) this.rating_only, (Object) getItemCmtList.rating_only) || !equals((Object) this.cursor, (Object) getItemCmtList.cursor) || !equals((Object) this.type, (Object) getItemCmtList.type) || !equals((Object) this.userid, (Object) getItemCmtList.userid) || !equals((Object) this.need_hidden, (Object) getItemCmtList.need_hidden) || !equals((Object) this.cmt_only, (Object) getItemCmtList.cmt_only) || !equals((Object) this.filter, (Object) getItemCmtList.filter) || !equals((Object) this.token, (Object) getItemCmtList.token) || !equals((Object) this.app_version_code, (Object) getItemCmtList.app_version_code)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool = this.rating_only;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l2 = this.cursor;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num4 = this.type;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.userid;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Boolean bool2 = this.need_hidden;
        int hashCode10 = (hashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.cmt_only;
        int hashCode11 = (hashCode10 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num6 = this.filter;
        int hashCode12 = (hashCode11 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode13 = (hashCode12 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num7 = this.app_version_code;
        if (num7 != null) {
            i2 = num7.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetItemCmtList> {
        public Integer app_version_code;
        public Boolean cmt_only;
        public Long cursor;
        public Integer filter;
        public Long itemid;
        public Integer limit;
        public Boolean need_hidden;
        public Integer offset;
        public Boolean rating_only;
        public String requestid;
        public Integer shopid;
        public String token;
        public Integer type;
        public Integer userid;

        public Builder() {
        }

        public Builder(GetItemCmtList getItemCmtList) {
            super(getItemCmtList);
            if (getItemCmtList != null) {
                this.requestid = getItemCmtList.requestid;
                this.shopid = getItemCmtList.shopid;
                this.itemid = getItemCmtList.itemid;
                this.offset = getItemCmtList.offset;
                this.limit = getItemCmtList.limit;
                this.rating_only = getItemCmtList.rating_only;
                this.cursor = getItemCmtList.cursor;
                this.type = getItemCmtList.type;
                this.userid = getItemCmtList.userid;
                this.need_hidden = getItemCmtList.need_hidden;
                this.cmt_only = getItemCmtList.cmt_only;
                this.filter = getItemCmtList.filter;
                this.token = getItemCmtList.token;
                this.app_version_code = getItemCmtList.app_version_code;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder rating_only(Boolean bool) {
            this.rating_only = bool;
            return this;
        }

        public Builder cursor(Long l) {
            this.cursor = l;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder need_hidden(Boolean bool) {
            this.need_hidden = bool;
            return this;
        }

        public Builder cmt_only(Boolean bool) {
            this.cmt_only = bool;
            return this;
        }

        public Builder filter(Integer num) {
            this.filter = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder app_version_code(Integer num) {
            this.app_version_code = num;
            return this;
        }

        public GetItemCmtList build() {
            return new GetItemCmtList(this);
        }
    }
}
