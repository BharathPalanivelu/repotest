package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class VoucherCustomisedLabel extends Message {
    public static final List<MultiLangTxt> DEFAULT_LABEL = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = MultiLangTxt.class, tag = 1)
    public final List<MultiLangTxt> label;

    public VoucherCustomisedLabel(List<MultiLangTxt> list) {
        this.label = immutableCopyOf(list);
    }

    private VoucherCustomisedLabel(Builder builder) {
        this(builder.label);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoucherCustomisedLabel)) {
            return false;
        }
        return equals((List<?>) this.label, (List<?>) ((VoucherCustomisedLabel) obj).label);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<MultiLangTxt> list = this.label;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<VoucherCustomisedLabel> {
        public List<MultiLangTxt> label;

        public Builder() {
        }

        public Builder(VoucherCustomisedLabel voucherCustomisedLabel) {
            super(voucherCustomisedLabel);
            if (voucherCustomisedLabel != null) {
                this.label = VoucherCustomisedLabel.copyOf(voucherCustomisedLabel.label);
            }
        }

        public Builder label(List<MultiLangTxt> list) {
            this.label = checkForNulls(list);
            return this;
        }

        public VoucherCustomisedLabel build() {
            return new VoucherCustomisedLabel(this);
        }
    }
}
