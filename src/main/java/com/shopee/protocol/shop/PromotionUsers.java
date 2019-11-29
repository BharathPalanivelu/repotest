package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PromotionUsers extends Message {
    public static final Boolean DEFAULT_ALL_USER = false;
    public static final Boolean DEFAULT_BY_USERIDS = false;
    public static final Boolean DEFAULT_NEW_USER = false;
    public static final Long DEFAULT_NOTI_TASK_ID = 0L;
    public static final Long DEFAULT_REGISTER_TIME_END = 0L;
    public static final Long DEFAULT_REGISTER_TIME_START = 0L;
    public static final List<Integer> DEFAULT_USERIDS = Collections.emptyList();
    public static final List<UserAttribute> DEFAULT_USER_ATTRIBUTES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean all_user;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean by_userids;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean new_user;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long noti_task_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long register_time_end;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long register_time_start;
    @ProtoField(label = Message.Label.REPEATED, messageType = UserAttribute.class, tag = 8)
    public final List<UserAttribute> user_attributes;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> userids;

    public PromotionUsers(Boolean bool, List<Integer> list, Long l, Long l2, Boolean bool2, Long l3, Boolean bool3, List<UserAttribute> list2) {
        this.all_user = bool;
        this.userids = immutableCopyOf(list);
        this.register_time_start = l;
        this.register_time_end = l2;
        this.by_userids = bool2;
        this.noti_task_id = l3;
        this.new_user = bool3;
        this.user_attributes = immutableCopyOf(list2);
    }

    private PromotionUsers(Builder builder) {
        this(builder.all_user, builder.userids, builder.register_time_start, builder.register_time_end, builder.by_userids, builder.noti_task_id, builder.new_user, builder.user_attributes);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PromotionUsers)) {
            return false;
        }
        PromotionUsers promotionUsers = (PromotionUsers) obj;
        if (!equals((Object) this.all_user, (Object) promotionUsers.all_user) || !equals((List<?>) this.userids, (List<?>) promotionUsers.userids) || !equals((Object) this.register_time_start, (Object) promotionUsers.register_time_start) || !equals((Object) this.register_time_end, (Object) promotionUsers.register_time_end) || !equals((Object) this.by_userids, (Object) promotionUsers.by_userids) || !equals((Object) this.noti_task_id, (Object) promotionUsers.noti_task_id) || !equals((Object) this.new_user, (Object) promotionUsers.new_user) || !equals((List<?>) this.user_attributes, (List<?>) promotionUsers.user_attributes)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.all_user;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        List<Integer> list = this.userids;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.register_time_start;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.register_time_end;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Boolean bool2 = this.by_userids;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Long l3 = this.noti_task_id;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Boolean bool3 = this.new_user;
        if (bool3 != null) {
            i2 = bool3.hashCode();
        }
        int i4 = (hashCode6 + i2) * 37;
        List<UserAttribute> list2 = this.user_attributes;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<PromotionUsers> {
        public Boolean all_user;
        public Boolean by_userids;
        public Boolean new_user;
        public Long noti_task_id;
        public Long register_time_end;
        public Long register_time_start;
        public List<UserAttribute> user_attributes;
        public List<Integer> userids;

        public Builder() {
        }

        public Builder(PromotionUsers promotionUsers) {
            super(promotionUsers);
            if (promotionUsers != null) {
                this.all_user = promotionUsers.all_user;
                this.userids = PromotionUsers.copyOf(promotionUsers.userids);
                this.register_time_start = promotionUsers.register_time_start;
                this.register_time_end = promotionUsers.register_time_end;
                this.by_userids = promotionUsers.by_userids;
                this.noti_task_id = promotionUsers.noti_task_id;
                this.new_user = promotionUsers.new_user;
                this.user_attributes = PromotionUsers.copyOf(promotionUsers.user_attributes);
            }
        }

        public Builder all_user(Boolean bool) {
            this.all_user = bool;
            return this;
        }

        public Builder userids(List<Integer> list) {
            this.userids = checkForNulls(list);
            return this;
        }

        public Builder register_time_start(Long l) {
            this.register_time_start = l;
            return this;
        }

        public Builder register_time_end(Long l) {
            this.register_time_end = l;
            return this;
        }

        public Builder by_userids(Boolean bool) {
            this.by_userids = bool;
            return this;
        }

        public Builder noti_task_id(Long l) {
            this.noti_task_id = l;
            return this;
        }

        public Builder new_user(Boolean bool) {
            this.new_user = bool;
            return this;
        }

        public Builder user_attributes(List<UserAttribute> list) {
            this.user_attributes = checkForNulls(list);
            return this;
        }

        public PromotionUsers build() {
            return new PromotionUsers(this);
        }
    }
}
