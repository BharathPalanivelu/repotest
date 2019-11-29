package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CoinExpiryInfo extends Message {
    public static final List<CoinMonthSummary> DEFAULT_SUMMARY = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CoinMonthSummary.class, tag = 1)
    public final List<CoinMonthSummary> summary;

    public CoinExpiryInfo(List<CoinMonthSummary> list) {
        this.summary = immutableCopyOf(list);
    }

    private CoinExpiryInfo(Builder builder) {
        this(builder.summary);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinExpiryInfo)) {
            return false;
        }
        return equals((List<?>) this.summary, (List<?>) ((CoinExpiryInfo) obj).summary);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<CoinMonthSummary> list = this.summary;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<CoinExpiryInfo> {
        public List<CoinMonthSummary> summary;

        public Builder() {
        }

        public Builder(CoinExpiryInfo coinExpiryInfo) {
            super(coinExpiryInfo);
            if (coinExpiryInfo != null) {
                this.summary = CoinExpiryInfo.copyOf(coinExpiryInfo.summary);
            }
        }

        public Builder summary(List<CoinMonthSummary> list) {
            this.summary = checkForNulls(list);
            return this;
        }

        public CoinExpiryInfo build() {
            return new CoinExpiryInfo(this);
        }
    }
}
