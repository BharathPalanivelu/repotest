package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CachedSearchItemList extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final List<ItemSearchInfo> DEFAULT_ITEM = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemSearchInfo.class, tag = 1)
    public final List<ItemSearchInfo> item;

    public CachedSearchItemList(List<ItemSearchInfo> list, Integer num) {
        this.item = immutableCopyOf(list);
        this.ctime = num;
    }

    private CachedSearchItemList(Builder builder) {
        this(builder.item, builder.ctime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CachedSearchItemList)) {
            return false;
        }
        CachedSearchItemList cachedSearchItemList = (CachedSearchItemList) obj;
        if (!equals((List<?>) this.item, (List<?>) cachedSearchItemList.item) || !equals((Object) this.ctime, (Object) cachedSearchItemList.ctime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<ItemSearchInfo> list = this.item;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Integer num = this.ctime;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CachedSearchItemList> {
        public Integer ctime;
        public List<ItemSearchInfo> item;

        public Builder() {
        }

        public Builder(CachedSearchItemList cachedSearchItemList) {
            super(cachedSearchItemList);
            if (cachedSearchItemList != null) {
                this.item = CachedSearchItemList.copyOf(cachedSearchItemList.item);
                this.ctime = cachedSearchItemList.ctime;
            }
        }

        public Builder item(List<ItemSearchInfo> list) {
            this.item = checkForNulls(list);
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public CachedSearchItemList build() {
            return new CachedSearchItemList(this);
        }
    }
}
