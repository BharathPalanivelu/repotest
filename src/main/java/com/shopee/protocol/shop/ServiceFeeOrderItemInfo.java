package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ServiceFeeOrderItemInfo extends Message {
    public static final List<SingleServiceFeeInfo> DEFAULT_INFO_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = SingleServiceFeeInfo.class, tag = 1)
    public final List<SingleServiceFeeInfo> info_list;

    public ServiceFeeOrderItemInfo(List<SingleServiceFeeInfo> list) {
        this.info_list = immutableCopyOf(list);
    }

    private ServiceFeeOrderItemInfo(Builder builder) {
        this(builder.info_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ServiceFeeOrderItemInfo)) {
            return false;
        }
        return equals((List<?>) this.info_list, (List<?>) ((ServiceFeeOrderItemInfo) obj).info_list);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<SingleServiceFeeInfo> list = this.info_list;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ServiceFeeOrderItemInfo> {
        public List<SingleServiceFeeInfo> info_list;

        public Builder() {
        }

        public Builder(ServiceFeeOrderItemInfo serviceFeeOrderItemInfo) {
            super(serviceFeeOrderItemInfo);
            if (serviceFeeOrderItemInfo != null) {
                this.info_list = ServiceFeeOrderItemInfo.copyOf(serviceFeeOrderItemInfo.info_list);
            }
        }

        public Builder info_list(List<SingleServiceFeeInfo> list) {
            this.info_list = checkForNulls(list);
            return this;
        }

        public ServiceFeeOrderItemInfo build() {
            return new ServiceFeeOrderItemInfo(this);
        }
    }
}
