package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LineAccountInfo extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_LINEID = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final Boolean DEFAULT_VERIFIED = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String lineid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean verified;

    public LineAccountInfo(Long l, String str, Integer num, Boolean bool, Integer num2, Integer num3) {
        this.id = l;
        this.lineid = str;
        this.userid = num;
        this.verified = bool;
        this.ctime = num2;
        this.mtime = num3;
    }

    private LineAccountInfo(Builder builder) {
        this(builder.id, builder.lineid, builder.userid, builder.verified, builder.ctime, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LineAccountInfo)) {
            return false;
        }
        LineAccountInfo lineAccountInfo = (LineAccountInfo) obj;
        if (!equals((Object) this.id, (Object) lineAccountInfo.id) || !equals((Object) this.lineid, (Object) lineAccountInfo.lineid) || !equals((Object) this.userid, (Object) lineAccountInfo.userid) || !equals((Object) this.verified, (Object) lineAccountInfo.verified) || !equals((Object) this.ctime, (Object) lineAccountInfo.ctime) || !equals((Object) this.mtime, (Object) lineAccountInfo.mtime)) {
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
        String str = this.lineid;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.userid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.verified;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LineAccountInfo> {
        public Integer ctime;
        public Long id;
        public String lineid;
        public Integer mtime;
        public Integer userid;
        public Boolean verified;

        public Builder() {
        }

        public Builder(LineAccountInfo lineAccountInfo) {
            super(lineAccountInfo);
            if (lineAccountInfo != null) {
                this.id = lineAccountInfo.id;
                this.lineid = lineAccountInfo.lineid;
                this.userid = lineAccountInfo.userid;
                this.verified = lineAccountInfo.verified;
                this.ctime = lineAccountInfo.ctime;
                this.mtime = lineAccountInfo.mtime;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder lineid(String str) {
            this.lineid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder verified(Boolean bool) {
            this.verified = bool;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public LineAccountInfo build() {
            return new LineAccountInfo(this);
        }
    }
}
