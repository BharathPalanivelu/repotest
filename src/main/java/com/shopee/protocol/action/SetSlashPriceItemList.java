package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetSlashPriceItemList extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final List<SlashPriceItemRequest> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REPEATED, messageType = SlashPriceItemRequest.class, tag = 3)
    public final List<SlashPriceItemRequest> items;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetSlashPriceItemList(String str, String str2, List<SlashPriceItemRequest> list, BackendParam backendParam) {
        this.requestid = str;
        this.country = str2;
        this.items = immutableCopyOf(list);
        this.bparam = backendParam;
    }

    private SetSlashPriceItemList(Builder builder) {
        this(builder.requestid, builder.country, builder.items, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetSlashPriceItemList)) {
            return false;
        }
        SetSlashPriceItemList setSlashPriceItemList = (SetSlashPriceItemList) obj;
        if (!equals((Object) this.requestid, (Object) setSlashPriceItemList.requestid) || !equals((Object) this.country, (Object) setSlashPriceItemList.country) || !equals((List<?>) this.items, (List<?>) setSlashPriceItemList.items) || !equals((Object) this.bparam, (Object) setSlashPriceItemList.bparam)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<SlashPriceItemRequest> list = this.items;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetSlashPriceItemList> {
        public BackendParam bparam;
        public String country;
        public List<SlashPriceItemRequest> items;
        public String requestid;

        public Builder() {
        }

        public Builder(SetSlashPriceItemList setSlashPriceItemList) {
            super(setSlashPriceItemList);
            if (setSlashPriceItemList != null) {
                this.requestid = setSlashPriceItemList.requestid;
                this.country = setSlashPriceItemList.country;
                this.items = SetSlashPriceItemList.copyOf(setSlashPriceItemList.items);
                this.bparam = setSlashPriceItemList.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder items(List<SlashPriceItemRequest> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public SetSlashPriceItemList build() {
            return new SetSlashPriceItemList(this);
        }
    }
}
