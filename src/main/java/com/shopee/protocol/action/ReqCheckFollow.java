package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ReqCheckFollow extends Message {
    public static final Boolean DEFAULT_NEED_UNFOLLOW_INFO = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Integer> DEFAULT_SHOPS = Collections.emptyList();
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean need_unfollow_info;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> shops;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public ReqCheckFollow(String str, String str2, List<Integer> list, Boolean bool) {
        this.requestid = str;
        this.token = str2;
        this.shops = immutableCopyOf(list);
        this.need_unfollow_info = bool;
    }

    private ReqCheckFollow(Builder builder) {
        this(builder.requestid, builder.token, builder.shops, builder.need_unfollow_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReqCheckFollow)) {
            return false;
        }
        ReqCheckFollow reqCheckFollow = (ReqCheckFollow) obj;
        if (!equals((Object) this.requestid, (Object) reqCheckFollow.requestid) || !equals((Object) this.token, (Object) reqCheckFollow.token) || !equals((List<?>) this.shops, (List<?>) reqCheckFollow.shops) || !equals((Object) this.need_unfollow_info, (Object) reqCheckFollow.need_unfollow_info)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<Integer> list = this.shops;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.need_unfollow_info;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReqCheckFollow> {
        public Boolean need_unfollow_info;
        public String requestid;
        public List<Integer> shops;
        public String token;

        public Builder() {
        }

        public Builder(ReqCheckFollow reqCheckFollow) {
            super(reqCheckFollow);
            if (reqCheckFollow != null) {
                this.requestid = reqCheckFollow.requestid;
                this.token = reqCheckFollow.token;
                this.shops = ReqCheckFollow.copyOf(reqCheckFollow.shops);
                this.need_unfollow_info = reqCheckFollow.need_unfollow_info;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder shops(List<Integer> list) {
            this.shops = checkForNulls(list);
            return this;
        }

        public Builder need_unfollow_info(Boolean bool) {
            this.need_unfollow_info = bool;
            return this;
        }

        public ReqCheckFollow build() {
            return new ReqCheckFollow(this);
        }
    }
}
