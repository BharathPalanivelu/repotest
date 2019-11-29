package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GroupBuyFraudLinkedUser extends Message {
    public static final List<Integer> DEFAULT_REASONS = Collections.emptyList();
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> reasons;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public GroupBuyFraudLinkedUser(Integer num, List<Integer> list) {
        this.userid = num;
        this.reasons = immutableCopyOf(list);
    }

    private GroupBuyFraudLinkedUser(Builder builder) {
        this(builder.userid, builder.reasons);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupBuyFraudLinkedUser)) {
            return false;
        }
        GroupBuyFraudLinkedUser groupBuyFraudLinkedUser = (GroupBuyFraudLinkedUser) obj;
        if (!equals((Object) this.userid, (Object) groupBuyFraudLinkedUser.userid) || !equals((List<?>) this.reasons, (List<?>) groupBuyFraudLinkedUser.reasons)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<Integer> list = this.reasons;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<GroupBuyFraudLinkedUser> {
        public List<Integer> reasons;
        public Integer userid;

        public Builder() {
        }

        public Builder(GroupBuyFraudLinkedUser groupBuyFraudLinkedUser) {
            super(groupBuyFraudLinkedUser);
            if (groupBuyFraudLinkedUser != null) {
                this.userid = groupBuyFraudLinkedUser.userid;
                this.reasons = GroupBuyFraudLinkedUser.copyOf(groupBuyFraudLinkedUser.reasons);
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder reasons(List<Integer> list) {
            this.reasons = checkForNulls(list);
            return this;
        }

        public GroupBuyFraudLinkedUser build() {
            return new GroupBuyFraudLinkedUser(this);
        }
    }
}
