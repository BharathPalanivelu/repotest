package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SlashPriceRejectExtInfo extends Message {
    public static final String DEFAULT_CLIENT_IP = "";
    public static final f DEFAULT_HASHED_FINGERPRINT = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f hashed_fingerprint;

    public SlashPriceRejectExtInfo(String str, f fVar) {
        this.client_ip = str;
        this.hashed_fingerprint = fVar;
    }

    private SlashPriceRejectExtInfo(Builder builder) {
        this(builder.client_ip, builder.hashed_fingerprint);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceRejectExtInfo)) {
            return false;
        }
        SlashPriceRejectExtInfo slashPriceRejectExtInfo = (SlashPriceRejectExtInfo) obj;
        if (!equals((Object) this.client_ip, (Object) slashPriceRejectExtInfo.client_ip) || !equals((Object) this.hashed_fingerprint, (Object) slashPriceRejectExtInfo.hashed_fingerprint)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.client_ip;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        f fVar = this.hashed_fingerprint;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceRejectExtInfo> {
        public String client_ip;
        public f hashed_fingerprint;

        public Builder() {
        }

        public Builder(SlashPriceRejectExtInfo slashPriceRejectExtInfo) {
            super(slashPriceRejectExtInfo);
            if (slashPriceRejectExtInfo != null) {
                this.client_ip = slashPriceRejectExtInfo.client_ip;
                this.hashed_fingerprint = slashPriceRejectExtInfo.hashed_fingerprint;
            }
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder hashed_fingerprint(f fVar) {
            this.hashed_fingerprint = fVar;
            return this;
        }

        public SlashPriceRejectExtInfo build() {
            return new SlashPriceRejectExtInfo(this);
        }
    }
}
