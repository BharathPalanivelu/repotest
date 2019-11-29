package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetItemPromoInfo extends Message {
    public static final List<ShopItemId> DEFAULT_IDLIST = Collections.emptyList();
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopItemId.class, tag = 3)
    public final List<ShopItemId> idlist;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetItemPromoInfo(String str, Long l, List<ShopItemId> list) {
        this.requestid = str;
        this.promotionid = l;
        this.idlist = immutableCopyOf(list);
    }

    private GetItemPromoInfo(Builder builder) {
        this(builder.requestid, builder.promotionid, builder.idlist);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetItemPromoInfo)) {
            return false;
        }
        GetItemPromoInfo getItemPromoInfo = (GetItemPromoInfo) obj;
        if (!equals((Object) this.requestid, (Object) getItemPromoInfo.requestid) || !equals((Object) this.promotionid, (Object) getItemPromoInfo.promotionid) || !equals((List<?>) this.idlist, (List<?>) getItemPromoInfo.idlist)) {
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
        Long l = this.promotionid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<ShopItemId> list = this.idlist;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<GetItemPromoInfo> {
        public List<ShopItemId> idlist;
        public Long promotionid;
        public String requestid;

        public Builder() {
        }

        public Builder(GetItemPromoInfo getItemPromoInfo) {
            super(getItemPromoInfo);
            if (getItemPromoInfo != null) {
                this.requestid = getItemPromoInfo.requestid;
                this.promotionid = getItemPromoInfo.promotionid;
                this.idlist = GetItemPromoInfo.copyOf(getItemPromoInfo.idlist);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder idlist(List<ShopItemId> list) {
            this.idlist = checkForNulls(list);
            return this;
        }

        public GetItemPromoInfo build() {
            return new GetItemPromoInfo(this);
        }
    }
}
