package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DelUserComment extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final Boolean DEFAULT_NO_PN = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean no_pn;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public DelUserComment(String str, Integer num, Long l, BackendParam backendParam, Boolean bool) {
        this.requestid = str;
        this.userid = num;
        this.cmtid = l;
        this.bparam = backendParam;
        this.no_pn = bool;
    }

    private DelUserComment(Builder builder) {
        this(builder.requestid, builder.userid, builder.cmtid, builder.bparam, builder.no_pn);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DelUserComment)) {
            return false;
        }
        DelUserComment delUserComment = (DelUserComment) obj;
        if (!equals((Object) this.requestid, (Object) delUserComment.requestid) || !equals((Object) this.userid, (Object) delUserComment.userid) || !equals((Object) this.cmtid, (Object) delUserComment.cmtid) || !equals((Object) this.bparam, (Object) delUserComment.bparam) || !equals((Object) this.no_pn, (Object) delUserComment.no_pn)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.cmtid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode4 = (hashCode3 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Boolean bool = this.no_pn;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DelUserComment> {
        public BackendParam bparam;
        public Long cmtid;
        public Boolean no_pn;
        public String requestid;
        public Integer userid;

        public Builder() {
        }

        public Builder(DelUserComment delUserComment) {
            super(delUserComment);
            if (delUserComment != null) {
                this.requestid = delUserComment.requestid;
                this.userid = delUserComment.userid;
                this.cmtid = delUserComment.cmtid;
                this.bparam = delUserComment.bparam;
                this.no_pn = delUserComment.no_pn;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
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

        public Builder no_pn(Boolean bool) {
            this.no_pn = bool;
            return this;
        }

        public DelUserComment build() {
            return new DelUserComment(this);
        }
    }
}
