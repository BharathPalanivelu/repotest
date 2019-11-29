package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DuplicateKeywordInfo extends Message {
    public static final String DEFAULT_DUPLICATED_KEYWORD = "";
    public static final String DEFAULT_ORIGINAL_KEYWORD_INPUT = "";
    public static final String DEFAULT_ORIGINAL_KEYWORD_IN_CACHE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String duplicated_keyword;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String original_keyword_in_cache;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String original_keyword_input;
    @ProtoField(tag = 1)
    public final CuratedActivity target;

    public DuplicateKeywordInfo(CuratedActivity curatedActivity, String str, String str2, String str3) {
        this.target = curatedActivity;
        this.duplicated_keyword = str;
        this.original_keyword_input = str2;
        this.original_keyword_in_cache = str3;
    }

    private DuplicateKeywordInfo(Builder builder) {
        this(builder.target, builder.duplicated_keyword, builder.original_keyword_input, builder.original_keyword_in_cache);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DuplicateKeywordInfo)) {
            return false;
        }
        DuplicateKeywordInfo duplicateKeywordInfo = (DuplicateKeywordInfo) obj;
        if (!equals((Object) this.target, (Object) duplicateKeywordInfo.target) || !equals((Object) this.duplicated_keyword, (Object) duplicateKeywordInfo.duplicated_keyword) || !equals((Object) this.original_keyword_input, (Object) duplicateKeywordInfo.original_keyword_input) || !equals((Object) this.original_keyword_in_cache, (Object) duplicateKeywordInfo.original_keyword_in_cache)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        CuratedActivity curatedActivity = this.target;
        int i2 = 0;
        int hashCode = (curatedActivity != null ? curatedActivity.hashCode() : 0) * 37;
        String str = this.duplicated_keyword;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.original_keyword_input;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.original_keyword_in_cache;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DuplicateKeywordInfo> {
        public String duplicated_keyword;
        public String original_keyword_in_cache;
        public String original_keyword_input;
        public CuratedActivity target;

        public Builder() {
        }

        public Builder(DuplicateKeywordInfo duplicateKeywordInfo) {
            super(duplicateKeywordInfo);
            if (duplicateKeywordInfo != null) {
                this.target = duplicateKeywordInfo.target;
                this.duplicated_keyword = duplicateKeywordInfo.duplicated_keyword;
                this.original_keyword_input = duplicateKeywordInfo.original_keyword_input;
                this.original_keyword_in_cache = duplicateKeywordInfo.original_keyword_in_cache;
            }
        }

        public Builder target(CuratedActivity curatedActivity) {
            this.target = curatedActivity;
            return this;
        }

        public Builder duplicated_keyword(String str) {
            this.duplicated_keyword = str;
            return this;
        }

        public Builder original_keyword_input(String str) {
            this.original_keyword_input = str;
            return this;
        }

        public Builder original_keyword_in_cache(String str) {
            this.original_keyword_in_cache = str;
            return this;
        }

        public DuplicateKeywordInfo build() {
            return new DuplicateKeywordInfo(this);
        }
    }
}
