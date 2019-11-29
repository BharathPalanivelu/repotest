package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class WelcomePackageExtInfo extends Message {
    public static final List<WelcomePackageItem> DEFAULT_ITEMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = WelcomePackageItem.class, tag = 1)
    public final List<WelcomePackageItem> items;

    public WelcomePackageExtInfo(List<WelcomePackageItem> list) {
        this.items = immutableCopyOf(list);
    }

    private WelcomePackageExtInfo(Builder builder) {
        this(builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WelcomePackageExtInfo)) {
            return false;
        }
        return equals((List<?>) this.items, (List<?>) ((WelcomePackageExtInfo) obj).items);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<WelcomePackageItem> list = this.items;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<WelcomePackageExtInfo> {
        public List<WelcomePackageItem> items;

        public Builder() {
        }

        public Builder(WelcomePackageExtInfo welcomePackageExtInfo) {
            super(welcomePackageExtInfo);
            if (welcomePackageExtInfo != null) {
                this.items = WelcomePackageExtInfo.copyOf(welcomePackageExtInfo.items);
            }
        }

        public Builder items(List<WelcomePackageItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public WelcomePackageExtInfo build() {
            return new WelcomePackageExtInfo(this);
        }
    }
}
