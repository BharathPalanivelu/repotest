package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class UserLocationSnapshot extends Message {
    public static final Integer DEFAULT_CREATE_TIME = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ORIGINAL_USER_LOCATION_ID = 0L;
    public static final Integer DEFAULT_USER_ID = 0;
    public static final f DEFAULT_USER_LOCATION_SNAPSHOT_DATA = f.f32736b;
    public static final Integer DEFAULT_USER_LOCATION_SNAPSHOT_DATA_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer create_time;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long id;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long original_user_location_id;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer user_id;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f user_location_snapshot_data;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer user_location_snapshot_data_type;

    public UserLocationSnapshot(Long l, Integer num, Long l2, f fVar, Integer num2, Integer num3) {
        this.id = l;
        this.user_id = num;
        this.original_user_location_id = l2;
        this.user_location_snapshot_data = fVar;
        this.create_time = num2;
        this.user_location_snapshot_data_type = num3;
    }

    private UserLocationSnapshot(Builder builder) {
        this(builder.id, builder.user_id, builder.original_user_location_id, builder.user_location_snapshot_data, builder.create_time, builder.user_location_snapshot_data_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserLocationSnapshot)) {
            return false;
        }
        UserLocationSnapshot userLocationSnapshot = (UserLocationSnapshot) obj;
        if (!equals((Object) this.id, (Object) userLocationSnapshot.id) || !equals((Object) this.user_id, (Object) userLocationSnapshot.user_id) || !equals((Object) this.original_user_location_id, (Object) userLocationSnapshot.original_user_location_id) || !equals((Object) this.user_location_snapshot_data, (Object) userLocationSnapshot.user_location_snapshot_data) || !equals((Object) this.create_time, (Object) userLocationSnapshot.create_time) || !equals((Object) this.user_location_snapshot_data_type, (Object) userLocationSnapshot.user_location_snapshot_data_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.user_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.original_user_location_id;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        f fVar = this.user_location_snapshot_data;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num2 = this.create_time;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.user_location_snapshot_data_type;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserLocationSnapshot> {
        public Integer create_time;
        public Long id;
        public Long original_user_location_id;
        public Integer user_id;
        public f user_location_snapshot_data;
        public Integer user_location_snapshot_data_type;

        public Builder() {
        }

        public Builder(UserLocationSnapshot userLocationSnapshot) {
            super(userLocationSnapshot);
            if (userLocationSnapshot != null) {
                this.id = userLocationSnapshot.id;
                this.user_id = userLocationSnapshot.user_id;
                this.original_user_location_id = userLocationSnapshot.original_user_location_id;
                this.user_location_snapshot_data = userLocationSnapshot.user_location_snapshot_data;
                this.create_time = userLocationSnapshot.create_time;
                this.user_location_snapshot_data_type = userLocationSnapshot.user_location_snapshot_data_type;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder user_id(Integer num) {
            this.user_id = num;
            return this;
        }

        public Builder original_user_location_id(Long l) {
            this.original_user_location_id = l;
            return this;
        }

        public Builder user_location_snapshot_data(f fVar) {
            this.user_location_snapshot_data = fVar;
            return this;
        }

        public Builder create_time(Integer num) {
            this.create_time = num;
            return this;
        }

        public Builder user_location_snapshot_data_type(Integer num) {
            this.user_location_snapshot_data_type = num;
            return this;
        }

        public UserLocationSnapshot build() {
            return new UserLocationSnapshot(this);
        }
    }
}
