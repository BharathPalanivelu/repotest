package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchItem extends Message {
    public static final String DEFAULT_ABTEST_SIGN = "";
    public static final String DEFAULT_ALGORITHM = "";
    public static final List<String> DEFAULT_HINT_KEYWORDS = Collections.emptyList();
    public static final List<ResultItem> DEFAULT_ITEM = Collections.emptyList();
    public static final String DEFAULT_JSON_DATA = "";
    public static final Integer DEFAULT_NOMORE_ITEM = 0;
    public static final String DEFAULT_RESERVED_KEYWORD = "";
    public static final Integer DEFAULT_SHOW_DISCLAIMER = 0;
    public static final Integer DEFAULT_SUGGESTION_ALGORITHM = 0;
    public static final Integer DEFAULT_TOTAL_ADS_COUNT = 0;
    public static final Integer DEFAULT_TOTAL_COUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String abtest_sign;
    @ProtoField(tag = 9)
    public final ShuffleInfo adjust;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, tag = 10, type = Message.Datatype.STRING)
    public final List<String> hint_keywords;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResultItem.class, tag = 2)
    public final List<ResultItem> item;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String json_data;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer nomore_item;
    @ProtoField(tag = 8)
    public final PriceRange price_adjust;
    @ProtoField(tag = 15)
    public final QueryRewrite query_rewrite;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String reserved_keyword;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer show_disclaimer;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer suggestion_algorithm;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer total_ads_count;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer total_count;

    public ResponseSearchItem(ResponseHeader responseHeader, List<ResultItem> list, Integer num, String str, Integer num2, Integer num3, String str2, PriceRange priceRange, ShuffleInfo shuffleInfo, List<String> list2, Integer num4, Integer num5, String str3, String str4, QueryRewrite queryRewrite) {
        this.header = responseHeader;
        this.item = immutableCopyOf(list);
        this.total_count = num;
        this.reserved_keyword = str;
        this.nomore_item = num2;
        this.suggestion_algorithm = num3;
        this.algorithm = str2;
        this.price_adjust = priceRange;
        this.adjust = shuffleInfo;
        this.hint_keywords = immutableCopyOf(list2);
        this.total_ads_count = num4;
        this.show_disclaimer = num5;
        this.abtest_sign = str3;
        this.json_data = str4;
        this.query_rewrite = queryRewrite;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ResponseSearchItem(com.shopee.protocol.search.action.ResponseSearchItem.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            com.shopee.protocol.search.action.ResponseHeader r2 = r0.header
            java.util.List<com.shopee.protocol.search.action.ResultItem> r3 = r0.item
            java.lang.Integer r4 = r0.total_count
            java.lang.String r5 = r0.reserved_keyword
            java.lang.Integer r6 = r0.nomore_item
            java.lang.Integer r7 = r0.suggestion_algorithm
            java.lang.String r8 = r0.algorithm
            com.shopee.protocol.search.action.PriceRange r9 = r0.price_adjust
            com.shopee.protocol.search.action.ShuffleInfo r10 = r0.adjust
            java.util.List<java.lang.String> r11 = r0.hint_keywords
            java.lang.Integer r12 = r0.total_ads_count
            java.lang.Integer r13 = r0.show_disclaimer
            java.lang.String r14 = r0.abtest_sign
            java.lang.String r15 = r0.json_data
            com.shopee.protocol.search.action.QueryRewrite r1 = r0.query_rewrite
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.search.action.ResponseSearchItem.<init>(com.shopee.protocol.search.action.ResponseSearchItem$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchItem)) {
            return false;
        }
        ResponseSearchItem responseSearchItem = (ResponseSearchItem) obj;
        if (!equals((Object) this.header, (Object) responseSearchItem.header) || !equals((List<?>) this.item, (List<?>) responseSearchItem.item) || !equals((Object) this.total_count, (Object) responseSearchItem.total_count) || !equals((Object) this.reserved_keyword, (Object) responseSearchItem.reserved_keyword) || !equals((Object) this.nomore_item, (Object) responseSearchItem.nomore_item) || !equals((Object) this.suggestion_algorithm, (Object) responseSearchItem.suggestion_algorithm) || !equals((Object) this.algorithm, (Object) responseSearchItem.algorithm) || !equals((Object) this.price_adjust, (Object) responseSearchItem.price_adjust) || !equals((Object) this.adjust, (Object) responseSearchItem.adjust) || !equals((List<?>) this.hint_keywords, (List<?>) responseSearchItem.hint_keywords) || !equals((Object) this.total_ads_count, (Object) responseSearchItem.total_ads_count) || !equals((Object) this.show_disclaimer, (Object) responseSearchItem.show_disclaimer) || !equals((Object) this.abtest_sign, (Object) responseSearchItem.abtest_sign) || !equals((Object) this.json_data, (Object) responseSearchItem.json_data) || !equals((Object) this.query_rewrite, (Object) responseSearchItem.query_rewrite)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int i2 = 0;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        List<ResultItem> list = this.item;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.total_count;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.reserved_keyword;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.nomore_item;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.suggestion_algorithm;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.algorithm;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        PriceRange priceRange = this.price_adjust;
        int hashCode8 = (hashCode7 + (priceRange != null ? priceRange.hashCode() : 0)) * 37;
        ShuffleInfo shuffleInfo = this.adjust;
        int hashCode9 = (hashCode8 + (shuffleInfo != null ? shuffleInfo.hashCode() : 0)) * 37;
        List<String> list2 = this.hint_keywords;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode9 + i3) * 37;
        Integer num4 = this.total_ads_count;
        int hashCode10 = (i4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.show_disclaimer;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str3 = this.abtest_sign;
        int hashCode12 = (hashCode11 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.json_data;
        int hashCode13 = (hashCode12 + (str4 != null ? str4.hashCode() : 0)) * 37;
        QueryRewrite queryRewrite = this.query_rewrite;
        if (queryRewrite != null) {
            i2 = queryRewrite.hashCode();
        }
        int i5 = hashCode13 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseSearchItem> {
        public String abtest_sign;
        public ShuffleInfo adjust;
        public String algorithm;
        public ResponseHeader header;
        public List<String> hint_keywords;
        public List<ResultItem> item;
        public String json_data;
        public Integer nomore_item;
        public PriceRange price_adjust;
        public QueryRewrite query_rewrite;
        public String reserved_keyword;
        public Integer show_disclaimer;
        public Integer suggestion_algorithm;
        public Integer total_ads_count;
        public Integer total_count;

        public Builder() {
        }

        public Builder(ResponseSearchItem responseSearchItem) {
            super(responseSearchItem);
            if (responseSearchItem != null) {
                this.header = responseSearchItem.header;
                this.item = ResponseSearchItem.copyOf(responseSearchItem.item);
                this.total_count = responseSearchItem.total_count;
                this.reserved_keyword = responseSearchItem.reserved_keyword;
                this.nomore_item = responseSearchItem.nomore_item;
                this.suggestion_algorithm = responseSearchItem.suggestion_algorithm;
                this.algorithm = responseSearchItem.algorithm;
                this.price_adjust = responseSearchItem.price_adjust;
                this.adjust = responseSearchItem.adjust;
                this.hint_keywords = ResponseSearchItem.copyOf(responseSearchItem.hint_keywords);
                this.total_ads_count = responseSearchItem.total_ads_count;
                this.show_disclaimer = responseSearchItem.show_disclaimer;
                this.abtest_sign = responseSearchItem.abtest_sign;
                this.json_data = responseSearchItem.json_data;
                this.query_rewrite = responseSearchItem.query_rewrite;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder item(List<ResultItem> list) {
            this.item = checkForNulls(list);
            return this;
        }

        public Builder total_count(Integer num) {
            this.total_count = num;
            return this;
        }

        public Builder reserved_keyword(String str) {
            this.reserved_keyword = str;
            return this;
        }

        public Builder nomore_item(Integer num) {
            this.nomore_item = num;
            return this;
        }

        public Builder suggestion_algorithm(Integer num) {
            this.suggestion_algorithm = num;
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public Builder price_adjust(PriceRange priceRange) {
            this.price_adjust = priceRange;
            return this;
        }

        public Builder adjust(ShuffleInfo shuffleInfo) {
            this.adjust = shuffleInfo;
            return this;
        }

        public Builder hint_keywords(List<String> list) {
            this.hint_keywords = checkForNulls(list);
            return this;
        }

        public Builder total_ads_count(Integer num) {
            this.total_ads_count = num;
            return this;
        }

        public Builder show_disclaimer(Integer num) {
            this.show_disclaimer = num;
            return this;
        }

        public Builder abtest_sign(String str) {
            this.abtest_sign = str;
            return this;
        }

        public Builder json_data(String str) {
            this.json_data = str;
            return this;
        }

        public Builder query_rewrite(QueryRewrite queryRewrite) {
            this.query_rewrite = queryRewrite;
            return this;
        }

        public ResponseSearchItem build() {
            return new ResponseSearchItem(this);
        }
    }
}
