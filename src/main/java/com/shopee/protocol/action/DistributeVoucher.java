package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class DistributeVoucher extends Message {
    public static final Boolean DEFAULT_ALL_USER = false;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_USERID = 0;
    public static final List<DistributeVoucherUser> DEFAULT_USERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean all_user;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(label = Message.Label.REPEATED, messageType = DistributeVoucherUser.class, tag = 4)
    public final List<DistributeVoucherUser> users;

    public DistributeVoucher(String str, Integer num, Long l, List<DistributeVoucherUser> list, Boolean bool) {
        this.requestid = str;
        this.userid = num;
        this.promotionid = l;
        this.users = immutableCopyOf(list);
        this.all_user = bool;
    }

    private DistributeVoucher(Builder builder) {
        this(builder.requestid, builder.userid, builder.promotionid, builder.users, builder.all_user);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DistributeVoucher)) {
            return false;
        }
        DistributeVoucher distributeVoucher = (DistributeVoucher) obj;
        if (!equals((Object) this.requestid, (Object) distributeVoucher.requestid) || !equals((Object) this.userid, (Object) distributeVoucher.userid) || !equals((Object) this.promotionid, (Object) distributeVoucher.promotionid) || !equals((List<?>) this.users, (List<?>) distributeVoucher.users) || !equals((Object) this.all_user, (Object) distributeVoucher.all_user)) {
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
        Long l = this.promotionid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        List<DistributeVoucherUser> list = this.users;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.all_user;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DistributeVoucher> {
        public Boolean all_user;
        public Long promotionid;
        public String requestid;
        public Integer userid;
        public List<DistributeVoucherUser> users;

        public Builder() {
        }

        public Builder(DistributeVoucher distributeVoucher) {
            super(distributeVoucher);
            if (distributeVoucher != null) {
                this.requestid = distributeVoucher.requestid;
                this.userid = distributeVoucher.userid;
                this.promotionid = distributeVoucher.promotionid;
                this.users = DistributeVoucher.copyOf(distributeVoucher.users);
                this.all_user = distributeVoucher.all_user;
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

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder users(List<DistributeVoucherUser> list) {
            this.users = checkForNulls(list);
            return this;
        }

        public Builder all_user(Boolean bool) {
            this.all_user = bool;
            return this;
        }

        public DistributeVoucher build() {
            checkRequiredFields();
            return new DistributeVoucher(this);
        }
    }
}
