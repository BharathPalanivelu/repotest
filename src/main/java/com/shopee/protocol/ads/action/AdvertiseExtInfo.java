package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AdvertiseExtInfo extends Message {
    public static final List<AdvertiseKeyword> DEFAULT_KEYWORDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = AdvertiseKeyword.class, tag = 1)
    public final List<AdvertiseKeyword> keywords;
    @ProtoField(tag = 2)
    public final AdvertiseTarget target;

    public AdvertiseExtInfo(List<AdvertiseKeyword> list, AdvertiseTarget advertiseTarget) {
        this.keywords = immutableCopyOf(list);
        this.target = advertiseTarget;
    }

    private AdvertiseExtInfo(Builder builder) {
        this(builder.keywords, builder.target);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdvertiseExtInfo)) {
            return false;
        }
        AdvertiseExtInfo advertiseExtInfo = (AdvertiseExtInfo) obj;
        if (!equals((List<?>) this.keywords, (List<?>) advertiseExtInfo.keywords) || !equals((Object) this.target, (Object) advertiseExtInfo.target)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<AdvertiseKeyword> list = this.keywords;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        AdvertiseTarget advertiseTarget = this.target;
        int hashCode2 = hashCode + (advertiseTarget != null ? advertiseTarget.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<AdvertiseExtInfo> {
        public List<AdvertiseKeyword> keywords;
        public AdvertiseTarget target;

        public Builder() {
        }

        public Builder(AdvertiseExtInfo advertiseExtInfo) {
            super(advertiseExtInfo);
            if (advertiseExtInfo != null) {
                this.keywords = AdvertiseExtInfo.copyOf(advertiseExtInfo.keywords);
                this.target = advertiseExtInfo.target;
            }
        }

        public Builder keywords(List<AdvertiseKeyword> list) {
            this.keywords = checkForNulls(list);
            return this;
        }

        public Builder target(AdvertiseTarget advertiseTarget) {
            this.target = advertiseTarget;
            return this;
        }

        public AdvertiseExtInfo build() {
            return new AdvertiseExtInfo(this);
        }
    }
}
