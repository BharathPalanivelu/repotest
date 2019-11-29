package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResultItemList extends Message {
    public static final List<ResultItem> DEFAULT_ITEMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResultItem.class, tag = 1)
    public final List<ResultItem> items;

    public ResultItemList(List<ResultItem> list) {
        this.items = immutableCopyOf(list);
    }

    private ResultItemList(Builder builder) {
        this(builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResultItemList)) {
            return false;
        }
        return equals((List<?>) this.items, (List<?>) ((ResultItemList) obj).items);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<ResultItem> list = this.items;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ResultItemList> {
        public List<ResultItem> items;

        public Builder() {
        }

        public Builder(ResultItemList resultItemList) {
            super(resultItemList);
            if (resultItemList != null) {
                this.items = ResultItemList.copyOf(resultItemList.items);
            }
        }

        public Builder items(List<ResultItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public ResultItemList build() {
            return new ResultItemList(this);
        }
    }
}
