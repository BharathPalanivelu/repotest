package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RecUser extends Message {
    public static final List<Long> DEFAULT_ITEMID_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> itemid_list;
    @ProtoField(tag = 1)
    public final UserBrief user;

    public RecUser(UserBrief userBrief, List<Long> list) {
        this.user = userBrief;
        this.itemid_list = immutableCopyOf(list);
    }

    private RecUser(Builder builder) {
        this(builder.user, builder.itemid_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecUser)) {
            return false;
        }
        RecUser recUser = (RecUser) obj;
        if (!equals((Object) this.user, (Object) recUser.user) || !equals((List<?>) this.itemid_list, (List<?>) recUser.itemid_list)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        UserBrief userBrief = this.user;
        int hashCode = (userBrief != null ? userBrief.hashCode() : 0) * 37;
        List<Long> list = this.itemid_list;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<RecUser> {
        public List<Long> itemid_list;
        public UserBrief user;

        public Builder() {
        }

        public Builder(RecUser recUser) {
            super(recUser);
            if (recUser != null) {
                this.user = recUser.user;
                this.itemid_list = RecUser.copyOf(recUser.itemid_list);
            }
        }

        public Builder user(UserBrief userBrief) {
            this.user = userBrief;
            return this;
        }

        public Builder itemid_list(List<Long> list) {
            this.itemid_list = checkForNulls(list);
            return this;
        }

        public RecUser build() {
            return new RecUser(this);
        }
    }
}
