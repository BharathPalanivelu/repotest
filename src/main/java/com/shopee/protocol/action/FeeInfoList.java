package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class FeeInfoList extends Message {
    public static final List<FeeInfo> DEFAULT_FEELIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = FeeInfo.class, tag = 1)
    public final List<FeeInfo> feelist;

    public FeeInfoList(List<FeeInfo> list) {
        this.feelist = immutableCopyOf(list);
    }

    private FeeInfoList(Builder builder) {
        this(builder.feelist);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeeInfoList)) {
            return false;
        }
        return equals((List<?>) this.feelist, (List<?>) ((FeeInfoList) obj).feelist);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<FeeInfo> list = this.feelist;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<FeeInfoList> {
        public List<FeeInfo> feelist;

        public Builder() {
        }

        public Builder(FeeInfoList feeInfoList) {
            super(feeInfoList);
            if (feeInfoList != null) {
                this.feelist = FeeInfoList.copyOf(feeInfoList.feelist);
            }
        }

        public Builder feelist(List<FeeInfo> list) {
            this.feelist = checkForNulls(list);
            return this;
        }

        public FeeInfoList build() {
            return new FeeInfoList(this);
        }
    }
}
