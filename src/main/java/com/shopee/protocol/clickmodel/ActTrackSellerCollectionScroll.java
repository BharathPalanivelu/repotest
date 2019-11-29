package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ActTrackSellerCollectionScroll extends Message {
    public static final List<Long> DEFAULT_ITEMID = Collections.emptyList();
    public static final List<Integer> DEFAULT_SHOPID = Collections.emptyList();
    public static final List<Long> DEFAULT_USERID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> itemid;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> shopid;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> userid;

    public ActTrackSellerCollectionScroll(List<Long> list, List<Integer> list2, List<Long> list3) {
        this.itemid = immutableCopyOf(list);
        this.shopid = immutableCopyOf(list2);
        this.userid = immutableCopyOf(list3);
    }

    private ActTrackSellerCollectionScroll(Builder builder) {
        this(builder.itemid, builder.shopid, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActTrackSellerCollectionScroll)) {
            return false;
        }
        ActTrackSellerCollectionScroll actTrackSellerCollectionScroll = (ActTrackSellerCollectionScroll) obj;
        if (!equals((List<?>) this.itemid, (List<?>) actTrackSellerCollectionScroll.itemid) || !equals((List<?>) this.shopid, (List<?>) actTrackSellerCollectionScroll.shopid) || !equals((List<?>) this.userid, (List<?>) actTrackSellerCollectionScroll.userid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Long> list = this.itemid;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<Integer> list2 = this.shopid;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Long> list3 = this.userid;
        if (list3 != null) {
            i2 = list3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActTrackSellerCollectionScroll> {
        public List<Long> itemid;
        public List<Integer> shopid;
        public List<Long> userid;

        public Builder() {
        }

        public Builder(ActTrackSellerCollectionScroll actTrackSellerCollectionScroll) {
            super(actTrackSellerCollectionScroll);
            if (actTrackSellerCollectionScroll != null) {
                this.itemid = ActTrackSellerCollectionScroll.copyOf(actTrackSellerCollectionScroll.itemid);
                this.shopid = ActTrackSellerCollectionScroll.copyOf(actTrackSellerCollectionScroll.shopid);
                this.userid = ActTrackSellerCollectionScroll.copyOf(actTrackSellerCollectionScroll.userid);
            }
        }

        public Builder itemid(List<Long> list) {
            this.itemid = checkForNulls(list);
            return this;
        }

        public Builder shopid(List<Integer> list) {
            this.shopid = checkForNulls(list);
            return this;
        }

        public Builder userid(List<Long> list) {
            this.userid = checkForNulls(list);
            return this;
        }

        public ActTrackSellerCollectionScroll build() {
            return new ActTrackSellerCollectionScroll(this);
        }
    }
}
