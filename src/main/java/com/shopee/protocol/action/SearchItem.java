package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchItem extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Boolean DEFAULT_HASHTAG_SEARCH = false;
    public static final Boolean DEFAULT_HTSEARCH_NEWALGORITHM = false;
    public static final Boolean DEFAULT_ID_ONLY = false;
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_NEED_DROP_WORD = false;
    public static final Boolean DEFAULT_NO_DESCRIPTION = false;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SORTTYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 9)
    public final SearchCondition condition;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean hashtag_search;
    @ProtoField(tag = 12, type = Message.Datatype.BOOL)
    public final Boolean htsearch_newalgorithm;
    @ProtoField(tag = 14, type = Message.Datatype.BOOL)
    public final Boolean id_only;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean need_drop_word;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean no_description;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer sorttype;

    public SearchItem(String str, Integer num, String str2, Integer num2, Integer num3, Integer num4, String str3, Integer num5, SearchCondition searchCondition, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5) {
        this.requestid = str;
        this.shopid = num;
        this.keyword = str2;
        this.offset = num2;
        this.limit = num3;
        this.catid = num4;
        this.country = str3;
        this.sorttype = num5;
        this.condition = searchCondition;
        this.no_description = bool;
        this.hashtag_search = bool2;
        this.htsearch_newalgorithm = bool3;
        this.need_drop_word = bool4;
        this.id_only = bool5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SearchItem(com.shopee.protocol.action.SearchItem.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r2 = r0.requestid
            java.lang.Integer r3 = r0.shopid
            java.lang.String r4 = r0.keyword
            java.lang.Integer r5 = r0.offset
            java.lang.Integer r6 = r0.limit
            java.lang.Integer r7 = r0.catid
            java.lang.String r8 = r0.country
            java.lang.Integer r9 = r0.sorttype
            com.shopee.protocol.action.SearchCondition r10 = r0.condition
            java.lang.Boolean r11 = r0.no_description
            java.lang.Boolean r12 = r0.hashtag_search
            java.lang.Boolean r13 = r0.htsearch_newalgorithm
            java.lang.Boolean r14 = r0.need_drop_word
            java.lang.Boolean r15 = r0.id_only
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.SearchItem.<init>(com.shopee.protocol.action.SearchItem$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchItem)) {
            return false;
        }
        SearchItem searchItem = (SearchItem) obj;
        if (!equals((Object) this.requestid, (Object) searchItem.requestid) || !equals((Object) this.shopid, (Object) searchItem.shopid) || !equals((Object) this.keyword, (Object) searchItem.keyword) || !equals((Object) this.offset, (Object) searchItem.offset) || !equals((Object) this.limit, (Object) searchItem.limit) || !equals((Object) this.catid, (Object) searchItem.catid) || !equals((Object) this.country, (Object) searchItem.country) || !equals((Object) this.sorttype, (Object) searchItem.sorttype) || !equals((Object) this.condition, (Object) searchItem.condition) || !equals((Object) this.no_description, (Object) searchItem.no_description) || !equals((Object) this.hashtag_search, (Object) searchItem.hashtag_search) || !equals((Object) this.htsearch_newalgorithm, (Object) searchItem.htsearch_newalgorithm) || !equals((Object) this.need_drop_word, (Object) searchItem.need_drop_word) || !equals((Object) this.id_only, (Object) searchItem.id_only)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.keyword;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.catid;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num5 = this.sorttype;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        SearchCondition searchCondition = this.condition;
        int hashCode9 = (hashCode8 + (searchCondition != null ? searchCondition.hashCode() : 0)) * 37;
        Boolean bool = this.no_description;
        int hashCode10 = (hashCode9 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.hashtag_search;
        int hashCode11 = (hashCode10 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.htsearch_newalgorithm;
        int hashCode12 = (hashCode11 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.need_drop_word;
        int hashCode13 = (hashCode12 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.id_only;
        if (bool5 != null) {
            i2 = bool5.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchItem> {
        public Integer catid;
        public SearchCondition condition;
        public String country;
        public Boolean hashtag_search;
        public Boolean htsearch_newalgorithm;
        public Boolean id_only;
        public String keyword;
        public Integer limit;
        public Boolean need_drop_word;
        public Boolean no_description;
        public Integer offset;
        public String requestid;
        public Integer shopid;
        public Integer sorttype;

        public Builder() {
        }

        public Builder(SearchItem searchItem) {
            super(searchItem);
            if (searchItem != null) {
                this.requestid = searchItem.requestid;
                this.shopid = searchItem.shopid;
                this.keyword = searchItem.keyword;
                this.offset = searchItem.offset;
                this.limit = searchItem.limit;
                this.catid = searchItem.catid;
                this.country = searchItem.country;
                this.sorttype = searchItem.sorttype;
                this.condition = searchItem.condition;
                this.no_description = searchItem.no_description;
                this.hashtag_search = searchItem.hashtag_search;
                this.htsearch_newalgorithm = searchItem.htsearch_newalgorithm;
                this.need_drop_word = searchItem.need_drop_word;
                this.id_only = searchItem.id_only;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder sorttype(Integer num) {
            this.sorttype = num;
            return this;
        }

        public Builder condition(SearchCondition searchCondition) {
            this.condition = searchCondition;
            return this;
        }

        public Builder no_description(Boolean bool) {
            this.no_description = bool;
            return this;
        }

        public Builder hashtag_search(Boolean bool) {
            this.hashtag_search = bool;
            return this;
        }

        public Builder htsearch_newalgorithm(Boolean bool) {
            this.htsearch_newalgorithm = bool;
            return this;
        }

        public Builder need_drop_word(Boolean bool) {
            this.need_drop_word = bool;
            return this;
        }

        public Builder id_only(Boolean bool) {
            this.id_only = bool;
            return this;
        }

        public SearchItem build() {
            checkRequiredFields();
            return new SearchItem(this);
        }
    }
}
