package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SlashPriceHistoryExtInfo extends Message {
    public static final String DEFAULT_CLIENT_IP = "";
    public static final f DEFAULT_HASHED_FINGERPRINT = f.f32736b;
    public static final String DEFAULT_NICKNAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f hashed_fingerprint;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String nickname;

    public SlashPriceHistoryExtInfo(String str, String str2, f fVar) {
        this.nickname = str;
        this.client_ip = str2;
        this.hashed_fingerprint = fVar;
    }

    private SlashPriceHistoryExtInfo(Builder builder) {
        this(builder.nickname, builder.client_ip, builder.hashed_fingerprint);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceHistoryExtInfo)) {
            return false;
        }
        SlashPriceHistoryExtInfo slashPriceHistoryExtInfo = (SlashPriceHistoryExtInfo) obj;
        if (!equals((Object) this.nickname, (Object) slashPriceHistoryExtInfo.nickname) || !equals((Object) this.client_ip, (Object) slashPriceHistoryExtInfo.client_ip) || !equals((Object) this.hashed_fingerprint, (Object) slashPriceHistoryExtInfo.hashed_fingerprint)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.nickname;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.client_ip;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.hashed_fingerprint;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceHistoryExtInfo> {
        public String client_ip;
        public f hashed_fingerprint;
        public String nickname;

        public Builder() {
        }

        public Builder(SlashPriceHistoryExtInfo slashPriceHistoryExtInfo) {
            super(slashPriceHistoryExtInfo);
            if (slashPriceHistoryExtInfo != null) {
                this.nickname = slashPriceHistoryExtInfo.nickname;
                this.client_ip = slashPriceHistoryExtInfo.client_ip;
                this.hashed_fingerprint = slashPriceHistoryExtInfo.hashed_fingerprint;
            }
        }

        public Builder nickname(String str) {
            this.nickname = str;
            return this;
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder hashed_fingerprint(f fVar) {
            this.hashed_fingerprint = fVar;
            return this;
        }

        public SlashPriceHistoryExtInfo build() {
            return new SlashPriceHistoryExtInfo(this);
        }
    }
}
