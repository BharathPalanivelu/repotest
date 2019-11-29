package com.shopee.protocol.ads.action;

import com.shopee.protocol.index.action.IndexSource;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class UpdatePaidAds extends Message {
    public static final Long DEFAULT_ADSID = 0L;
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final List<AdvertiseKeyword> DEFAULT_KEYWORDS = Collections.emptyList();
    public static final IndexSource DEFAULT_SOURCE = IndexSource.UNKNOW;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Boolean DEFAULT_UPDATE_TIME = false;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7)
    public final AdsAccount acc;
    @ProtoField(tag = 6)
    public final Advertisement ads;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 5)
    public final Campaign campaign;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REPEATED, messageType = AdvertiseKeyword.class, tag = 8)
    public final List<AdvertiseKeyword> keywords;
    @ProtoField(tag = 11, type = Message.Datatype.ENUM)
    public final IndexSource source;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean update_time;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer userid;

    public UpdatePaidAds(Integer num, Long l, Long l2, Integer num2, Campaign campaign2, Advertisement advertisement, AdsAccount adsAccount, List<AdvertiseKeyword> list, String str, Boolean bool, IndexSource indexSource) {
        this.type = num;
        this.adsid = l;
        this.campaignid = l2;
        this.userid = num2;
        this.campaign = campaign2;
        this.ads = advertisement;
        this.acc = adsAccount;
        this.keywords = immutableCopyOf(list);
        this.country = str;
        this.update_time = bool;
        this.source = indexSource;
    }

    private UpdatePaidAds(Builder builder) {
        this(builder.type, builder.adsid, builder.campaignid, builder.userid, builder.campaign, builder.ads, builder.acc, builder.keywords, builder.country, builder.update_time, builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdatePaidAds)) {
            return false;
        }
        UpdatePaidAds updatePaidAds = (UpdatePaidAds) obj;
        if (!equals((Object) this.type, (Object) updatePaidAds.type) || !equals((Object) this.adsid, (Object) updatePaidAds.adsid) || !equals((Object) this.campaignid, (Object) updatePaidAds.campaignid) || !equals((Object) this.userid, (Object) updatePaidAds.userid) || !equals((Object) this.campaign, (Object) updatePaidAds.campaign) || !equals((Object) this.ads, (Object) updatePaidAds.ads) || !equals((Object) this.acc, (Object) updatePaidAds.acc) || !equals((List<?>) this.keywords, (List<?>) updatePaidAds.keywords) || !equals((Object) this.country, (Object) updatePaidAds.country) || !equals((Object) this.update_time, (Object) updatePaidAds.update_time) || !equals((Object) this.source, (Object) updatePaidAds.source)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.adsid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.campaignid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Campaign campaign2 = this.campaign;
        int hashCode5 = (hashCode4 + (campaign2 != null ? campaign2.hashCode() : 0)) * 37;
        Advertisement advertisement = this.ads;
        int hashCode6 = (hashCode5 + (advertisement != null ? advertisement.hashCode() : 0)) * 37;
        AdsAccount adsAccount = this.acc;
        int hashCode7 = (hashCode6 + (adsAccount != null ? adsAccount.hashCode() : 0)) * 37;
        List<AdvertiseKeyword> list = this.keywords;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.country;
        int hashCode9 = (hashCode8 + (str != null ? str.hashCode() : 0)) * 37;
        Boolean bool = this.update_time;
        int hashCode10 = (hashCode9 + (bool != null ? bool.hashCode() : 0)) * 37;
        IndexSource indexSource = this.source;
        if (indexSource != null) {
            i2 = indexSource.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UpdatePaidAds> {
        public AdsAccount acc;
        public Advertisement ads;
        public Long adsid;
        public Campaign campaign;
        public Long campaignid;
        public String country;
        public List<AdvertiseKeyword> keywords;
        public IndexSource source;
        public Integer type;
        public Boolean update_time;
        public Integer userid;

        public Builder() {
        }

        public Builder(UpdatePaidAds updatePaidAds) {
            super(updatePaidAds);
            if (updatePaidAds != null) {
                this.type = updatePaidAds.type;
                this.adsid = updatePaidAds.adsid;
                this.campaignid = updatePaidAds.campaignid;
                this.userid = updatePaidAds.userid;
                this.campaign = updatePaidAds.campaign;
                this.ads = updatePaidAds.ads;
                this.acc = updatePaidAds.acc;
                this.keywords = UpdatePaidAds.copyOf(updatePaidAds.keywords);
                this.country = updatePaidAds.country;
                this.update_time = updatePaidAds.update_time;
                this.source = updatePaidAds.source;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder campaign(Campaign campaign2) {
            this.campaign = campaign2;
            return this;
        }

        public Builder ads(Advertisement advertisement) {
            this.ads = advertisement;
            return this;
        }

        public Builder acc(AdsAccount adsAccount) {
            this.acc = adsAccount;
            return this;
        }

        public Builder keywords(List<AdvertiseKeyword> list) {
            this.keywords = checkForNulls(list);
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder update_time(Boolean bool) {
            this.update_time = bool;
            return this;
        }

        public Builder source(IndexSource indexSource) {
            this.source = indexSource;
            return this;
        }

        public UpdatePaidAds build() {
            return new UpdatePaidAds(this);
        }
    }
}
