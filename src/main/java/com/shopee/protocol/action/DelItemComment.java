package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DelItemComment extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Boolean DEFAULT_NO_PN = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean no_pn;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String token;

    public DelItemComment(String str, Integer num, Long l, Long l2, BackendParam backendParam, String str2, Boolean bool) {
        this.requestid = str;
        this.shopid = num;
        this.itemid = l;
        this.cmtid = l2;
        this.bparam = backendParam;
        this.token = str2;
        this.no_pn = bool;
    }

    private DelItemComment(Builder builder) {
        this(builder.requestid, builder.shopid, builder.itemid, builder.cmtid, builder.bparam, builder.token, builder.no_pn);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DelItemComment)) {
            return false;
        }
        DelItemComment delItemComment = (DelItemComment) obj;
        if (!equals((Object) this.requestid, (Object) delItemComment.requestid) || !equals((Object) this.shopid, (Object) delItemComment.shopid) || !equals((Object) this.itemid, (Object) delItemComment.itemid) || !equals((Object) this.cmtid, (Object) delItemComment.cmtid) || !equals((Object) this.bparam, (Object) delItemComment.bparam) || !equals((Object) this.token, (Object) delItemComment.token) || !equals((Object) this.no_pn, (Object) delItemComment.no_pn)) {
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
        Long l2 = this.cmtid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode5 = (hashCode4 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.no_pn;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DelItemComment> {
        public BackendParam bparam;
        public Long cmtid;
        public Long itemid;
        public Boolean no_pn;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(DelItemComment delItemComment) {
            super(delItemComment);
            if (delItemComment != null) {
                this.requestid = delItemComment.requestid;
                this.shopid = delItemComment.shopid;
                this.itemid = delItemComment.itemid;
                this.cmtid = delItemComment.cmtid;
                this.bparam = delItemComment.bparam;
                this.token = delItemComment.token;
                this.no_pn = delItemComment.no_pn;
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

        public Builder cmtid(Long l) {
            this.cmtid = l;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder no_pn(Boolean bool) {
            this.no_pn = bool;
            return this;
        }

        public DelItemComment build() {
            checkRequiredFields();
            return new DelItemComment(this);
        }
    }
}
