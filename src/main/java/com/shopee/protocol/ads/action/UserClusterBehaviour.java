package com.shopee.protocol.ads.action;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;

public final class UserClusterBehaviour extends Message {
    public static final String DEFAULT_ID = "";
    public static final Float DEFAULT_SCORE = Float.valueOf(BitmapDescriptorFactory.HUE_RED);
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String id;
    @ProtoField(tag = 3, type = Message.Datatype.FLOAT)
    public final Float score;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long timestamp;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public UserClusterBehaviour(Integer num, String str, Float f2, Long l) {
        this.type = num;
        this.id = str;
        this.score = f2;
        this.timestamp = l;
    }

    private UserClusterBehaviour(Builder builder) {
        this(builder.type, builder.id, builder.score, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserClusterBehaviour)) {
            return false;
        }
        UserClusterBehaviour userClusterBehaviour = (UserClusterBehaviour) obj;
        if (!equals((Object) this.type, (Object) userClusterBehaviour.type) || !equals((Object) this.id, (Object) userClusterBehaviour.id) || !equals((Object) this.score, (Object) userClusterBehaviour.score) || !equals((Object) this.timestamp, (Object) userClusterBehaviour.timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.id;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Float f2 = this.score;
        int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Long l = this.timestamp;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserClusterBehaviour> {
        public String id;
        public Float score;
        public Long timestamp;
        public Integer type;

        public Builder() {
        }

        public Builder(UserClusterBehaviour userClusterBehaviour) {
            super(userClusterBehaviour);
            if (userClusterBehaviour != null) {
                this.type = userClusterBehaviour.type;
                this.id = userClusterBehaviour.id;
                this.score = userClusterBehaviour.score;
                this.timestamp = userClusterBehaviour.timestamp;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder id(String str) {
            this.id = str;
            return this;
        }

        public Builder score(Float f2) {
            this.score = f2;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public UserClusterBehaviour build() {
            return new UserClusterBehaviour(this);
        }
    }

    public enum LevelType implements ProtoEnum {
        L0(0),
        L1(1),
        L2(2);
        
        private final int value;

        private LevelType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
