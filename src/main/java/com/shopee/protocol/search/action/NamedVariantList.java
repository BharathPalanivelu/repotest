package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class NamedVariantList extends Message {
    public static final List<NamedVariant> DEFAULT_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = NamedVariant.class, tag = 1)
    public final List<NamedVariant> List;

    public NamedVariantList(List<NamedVariant> list) {
        this.List = immutableCopyOf(list);
    }

    private NamedVariantList(Builder builder) {
        this(builder.List);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NamedVariantList)) {
            return false;
        }
        return equals((List<?>) this.List, (List<?>) ((NamedVariantList) obj).List);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<NamedVariant> list = this.List;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<NamedVariantList> {
        public List<NamedVariant> List;

        public Builder() {
        }

        public Builder(NamedVariantList namedVariantList) {
            super(namedVariantList);
            if (namedVariantList != null) {
                this.List = NamedVariantList.copyOf(namedVariantList.List);
            }
        }

        public Builder List(List<NamedVariant> list) {
            this.List = checkForNulls(list);
            return this;
        }

        public NamedVariantList build() {
            return new NamedVariantList(this);
        }
    }
}
