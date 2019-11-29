package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GroupBuyFraudRecordExtInfo extends Message {
    public static final List<GroupBuyFraudLinkedUser> DEFAULT_LINKED_USERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = GroupBuyFraudLinkedUser.class, tag = 1)
    public final List<GroupBuyFraudLinkedUser> linked_users;

    public GroupBuyFraudRecordExtInfo(List<GroupBuyFraudLinkedUser> list) {
        this.linked_users = immutableCopyOf(list);
    }

    private GroupBuyFraudRecordExtInfo(Builder builder) {
        this(builder.linked_users);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupBuyFraudRecordExtInfo)) {
            return false;
        }
        return equals((List<?>) this.linked_users, (List<?>) ((GroupBuyFraudRecordExtInfo) obj).linked_users);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<GroupBuyFraudLinkedUser> list = this.linked_users;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<GroupBuyFraudRecordExtInfo> {
        public List<GroupBuyFraudLinkedUser> linked_users;

        public Builder() {
        }

        public Builder(GroupBuyFraudRecordExtInfo groupBuyFraudRecordExtInfo) {
            super(groupBuyFraudRecordExtInfo);
            if (groupBuyFraudRecordExtInfo != null) {
                this.linked_users = GroupBuyFraudRecordExtInfo.copyOf(groupBuyFraudRecordExtInfo.linked_users);
            }
        }

        public Builder linked_users(List<GroupBuyFraudLinkedUser> list) {
            this.linked_users = checkForNulls(list);
            return this;
        }

        public GroupBuyFraudRecordExtInfo build() {
            return new GroupBuyFraudRecordExtInfo(this);
        }
    }
}
