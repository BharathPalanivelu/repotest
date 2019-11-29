package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class QueryRewrite extends Message {
    public static final Integer DEFAULT_FEQUERYWRITESTATUS = 0;
    public static final List<String> DEFAULT_HINT_KEYWORDS = Collections.emptyList();
    public static final String DEFAULT_ORI_KEYWORD = "";
    public static final Integer DEFAULT_ORI_TOTALCOUNT = 0;
    public static final String DEFAULT_REWRITE_KEYWORD = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer FEQueryWriteStatus;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> hint_keywords;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String ori_keyword;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ori_totalCount;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String rewrite_keyword;

    public QueryRewrite(Integer num, String str, List<String> list, String str2, Integer num2) {
        this.FEQueryWriteStatus = num;
        this.rewrite_keyword = str;
        this.hint_keywords = immutableCopyOf(list);
        this.ori_keyword = str2;
        this.ori_totalCount = num2;
    }

    private QueryRewrite(Builder builder) {
        this(builder.FEQueryWriteStatus, builder.rewrite_keyword, builder.hint_keywords, builder.ori_keyword, builder.ori_totalCount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QueryRewrite)) {
            return false;
        }
        QueryRewrite queryRewrite = (QueryRewrite) obj;
        if (!equals((Object) this.FEQueryWriteStatus, (Object) queryRewrite.FEQueryWriteStatus) || !equals((Object) this.rewrite_keyword, (Object) queryRewrite.rewrite_keyword) || !equals((List<?>) this.hint_keywords, (List<?>) queryRewrite.hint_keywords) || !equals((Object) this.ori_keyword, (Object) queryRewrite.ori_keyword) || !equals((Object) this.ori_totalCount, (Object) queryRewrite.ori_totalCount)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.FEQueryWriteStatus;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.rewrite_keyword;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        List<String> list = this.hint_keywords;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.ori_keyword;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.ori_totalCount;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<QueryRewrite> {
        public Integer FEQueryWriteStatus;
        public List<String> hint_keywords;
        public String ori_keyword;
        public Integer ori_totalCount;
        public String rewrite_keyword;

        public Builder() {
        }

        public Builder(QueryRewrite queryRewrite) {
            super(queryRewrite);
            if (queryRewrite != null) {
                this.FEQueryWriteStatus = queryRewrite.FEQueryWriteStatus;
                this.rewrite_keyword = queryRewrite.rewrite_keyword;
                this.hint_keywords = QueryRewrite.copyOf(queryRewrite.hint_keywords);
                this.ori_keyword = queryRewrite.ori_keyword;
                this.ori_totalCount = queryRewrite.ori_totalCount;
            }
        }

        public Builder FEQueryWriteStatus(Integer num) {
            this.FEQueryWriteStatus = num;
            return this;
        }

        public Builder rewrite_keyword(String str) {
            this.rewrite_keyword = str;
            return this;
        }

        public Builder hint_keywords(List<String> list) {
            this.hint_keywords = checkForNulls(list);
            return this;
        }

        public Builder ori_keyword(String str) {
            this.ori_keyword = str;
            return this;
        }

        public Builder ori_totalCount(Integer num) {
            this.ori_totalCount = num;
            return this;
        }

        public QueryRewrite build() {
            return new QueryRewrite(this);
        }
    }
}
