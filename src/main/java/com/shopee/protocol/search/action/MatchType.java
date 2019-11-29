package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class MatchType extends Message {
    public static final List<String> DEFAULT_BRAND = Collections.emptyList();
    public static final List<Integer> DEFAULT_BRANDIDS = Collections.emptyList();
    public static final String DEFAULT_HASHTAG = "";
    public static final List<String> DEFAULT_HASHTAGS = Collections.emptyList();
    public static final List<Long> DEFAULT_ID = Collections.emptyList();
    public static final List<ItemId> DEFAULT_ITEMIDS = Collections.emptyList();
    public static final List<String> DEFAULT_KEYWORDS = Collections.emptyList();
    public static final List<LabelGroup> DEFAULT_LABEL_GROUPS = Collections.emptyList();
    public static final MatchTypeIndex DEFAULT_MATCH_TYPE = MatchTypeIndex.MATCH_SHOP;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 8, type = Message.Datatype.STRING)
    public final List<String> brand;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.INT32)
    public final List<Integer> brandids;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String hashtag;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.STRING)
    public final List<String> hashtags;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> id;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemId.class, tag = 6)
    public final List<ItemId> itemids;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.STRING)
    public final List<String> keywords;
    @ProtoField(label = Message.Label.REPEATED, messageType = LabelGroup.class, tag = 7)
    public final List<LabelGroup> label_groups;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final MatchTypeIndex match_type;

    public MatchType(MatchTypeIndex matchTypeIndex, List<Long> list, String str, List<String> list2, List<String> list3, List<ItemId> list4, List<LabelGroup> list5, List<String> list6, List<Integer> list7) {
        this.match_type = matchTypeIndex;
        this.id = immutableCopyOf(list);
        this.hashtag = str;
        this.hashtags = immutableCopyOf(list2);
        this.keywords = immutableCopyOf(list3);
        this.itemids = immutableCopyOf(list4);
        this.label_groups = immutableCopyOf(list5);
        this.brand = immutableCopyOf(list6);
        this.brandids = immutableCopyOf(list7);
    }

    private MatchType(Builder builder) {
        this(builder.match_type, builder.id, builder.hashtag, builder.hashtags, builder.keywords, builder.itemids, builder.label_groups, builder.brand, builder.brandids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MatchType)) {
            return false;
        }
        MatchType matchType = (MatchType) obj;
        if (!equals((Object) this.match_type, (Object) matchType.match_type) || !equals((List<?>) this.id, (List<?>) matchType.id) || !equals((Object) this.hashtag, (Object) matchType.hashtag) || !equals((List<?>) this.hashtags, (List<?>) matchType.hashtags) || !equals((List<?>) this.keywords, (List<?>) matchType.keywords) || !equals((List<?>) this.itemids, (List<?>) matchType.itemids) || !equals((List<?>) this.label_groups, (List<?>) matchType.label_groups) || !equals((List<?>) this.brand, (List<?>) matchType.brand) || !equals((List<?>) this.brandids, (List<?>) matchType.brandids)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        MatchTypeIndex matchTypeIndex = this.match_type;
        int i2 = 0;
        int hashCode = (matchTypeIndex != null ? matchTypeIndex.hashCode() : 0) * 37;
        List<Long> list = this.id;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.hashtag;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i4 = (hashCode2 + i2) * 37;
        List<String> list2 = this.hashtags;
        int hashCode3 = (i4 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<String> list3 = this.keywords;
        int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<ItemId> list4 = this.itemids;
        int hashCode5 = (hashCode4 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<LabelGroup> list5 = this.label_groups;
        int hashCode6 = (hashCode5 + (list5 != null ? list5.hashCode() : 1)) * 37;
        List<String> list6 = this.brand;
        int hashCode7 = (hashCode6 + (list6 != null ? list6.hashCode() : 1)) * 37;
        List<Integer> list7 = this.brandids;
        if (list7 != null) {
            i3 = list7.hashCode();
        }
        int i5 = hashCode7 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<MatchType> {
        public List<String> brand;
        public List<Integer> brandids;
        public String hashtag;
        public List<String> hashtags;
        public List<Long> id;
        public List<ItemId> itemids;
        public List<String> keywords;
        public List<LabelGroup> label_groups;
        public MatchTypeIndex match_type;

        public Builder() {
        }

        public Builder(MatchType matchType) {
            super(matchType);
            if (matchType != null) {
                this.match_type = matchType.match_type;
                this.id = MatchType.copyOf(matchType.id);
                this.hashtag = matchType.hashtag;
                this.hashtags = MatchType.copyOf(matchType.hashtags);
                this.keywords = MatchType.copyOf(matchType.keywords);
                this.itemids = MatchType.copyOf(matchType.itemids);
                this.label_groups = MatchType.copyOf(matchType.label_groups);
                this.brand = MatchType.copyOf(matchType.brand);
                this.brandids = MatchType.copyOf(matchType.brandids);
            }
        }

        public Builder match_type(MatchTypeIndex matchTypeIndex) {
            this.match_type = matchTypeIndex;
            return this;
        }

        public Builder id(List<Long> list) {
            this.id = checkForNulls(list);
            return this;
        }

        public Builder hashtag(String str) {
            this.hashtag = str;
            return this;
        }

        public Builder hashtags(List<String> list) {
            this.hashtags = checkForNulls(list);
            return this;
        }

        public Builder keywords(List<String> list) {
            this.keywords = checkForNulls(list);
            return this;
        }

        public Builder itemids(List<ItemId> list) {
            this.itemids = checkForNulls(list);
            return this;
        }

        public Builder label_groups(List<LabelGroup> list) {
            this.label_groups = checkForNulls(list);
            return this;
        }

        public Builder brand(List<String> list) {
            this.brand = checkForNulls(list);
            return this;
        }

        public Builder brandids(List<Integer> list) {
            this.brandids = checkForNulls(list);
            return this;
        }

        public MatchType build() {
            return new MatchType(this);
        }
    }
}
