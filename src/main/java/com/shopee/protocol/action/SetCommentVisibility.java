package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetCommentVisibility extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final Integer DEFAULT_HIDE_OPT = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final BackendParam bparam;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer hide_opt;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String token;

    public SetCommentVisibility(String str, Integer num, Long l, Long l2, BackendParam backendParam, String str2, Integer num2) {
        this.requestid = str;
        this.shopid = num;
        this.itemid = l;
        this.cmtid = l2;
        this.bparam = backendParam;
        this.token = str2;
        this.hide_opt = num2;
    }

    private SetCommentVisibility(Builder builder) {
        this(builder.requestid, builder.shopid, builder.itemid, builder.cmtid, builder.bparam, builder.token, builder.hide_opt);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetCommentVisibility)) {
            return false;
        }
        SetCommentVisibility setCommentVisibility = (SetCommentVisibility) obj;
        if (!equals((Object) this.requestid, (Object) setCommentVisibility.requestid) || !equals((Object) this.shopid, (Object) setCommentVisibility.shopid) || !equals((Object) this.itemid, (Object) setCommentVisibility.itemid) || !equals((Object) this.cmtid, (Object) setCommentVisibility.cmtid) || !equals((Object) this.bparam, (Object) setCommentVisibility.bparam) || !equals((Object) this.token, (Object) setCommentVisibility.token) || !equals((Object) this.hide_opt, (Object) setCommentVisibility.hide_opt)) {
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
        Integer num2 = this.hide_opt;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetCommentVisibility> {
        public BackendParam bparam;
        public Long cmtid;
        public Integer hide_opt;
        public Long itemid;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(SetCommentVisibility setCommentVisibility) {
            super(setCommentVisibility);
            if (setCommentVisibility != null) {
                this.requestid = setCommentVisibility.requestid;
                this.shopid = setCommentVisibility.shopid;
                this.itemid = setCommentVisibility.itemid;
                this.cmtid = setCommentVisibility.cmtid;
                this.bparam = setCommentVisibility.bparam;
                this.token = setCommentVisibility.token;
                this.hide_opt = setCommentVisibility.hide_opt;
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

        public Builder hide_opt(Integer num) {
            this.hide_opt = num;
            return this;
        }

        public SetCommentVisibility build() {
            return new SetCommentVisibility(this);
        }
    }
}
