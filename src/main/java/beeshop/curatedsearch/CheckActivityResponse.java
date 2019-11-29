package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CheckActivityResponse extends Message {
    public static final ErrCode DEFAULT_CODE = ErrCode.Success;
    public static final List<DuplicateKeywordInfo> DEFAULT_DUPLICATED_KEYWORD = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final ErrCode code;
    @ProtoField(label = Message.Label.REPEATED, messageType = DuplicateKeywordInfo.class, tag = 2)
    public final List<DuplicateKeywordInfo> duplicated_keyword;

    public CheckActivityResponse(ErrCode errCode, List<DuplicateKeywordInfo> list) {
        this.code = errCode;
        this.duplicated_keyword = immutableCopyOf(list);
    }

    private CheckActivityResponse(Builder builder) {
        this(builder.code, builder.duplicated_keyword);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckActivityResponse)) {
            return false;
        }
        CheckActivityResponse checkActivityResponse = (CheckActivityResponse) obj;
        if (!equals((Object) this.code, (Object) checkActivityResponse.code) || !equals((List<?>) this.duplicated_keyword, (List<?>) checkActivityResponse.duplicated_keyword)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ErrCode errCode = this.code;
        int hashCode = (errCode != null ? errCode.hashCode() : 0) * 37;
        List<DuplicateKeywordInfo> list = this.duplicated_keyword;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CheckActivityResponse> {
        public ErrCode code;
        public List<DuplicateKeywordInfo> duplicated_keyword;

        public Builder() {
        }

        public Builder(CheckActivityResponse checkActivityResponse) {
            super(checkActivityResponse);
            if (checkActivityResponse != null) {
                this.code = checkActivityResponse.code;
                this.duplicated_keyword = CheckActivityResponse.copyOf(checkActivityResponse.duplicated_keyword);
            }
        }

        public Builder code(ErrCode errCode) {
            this.code = errCode;
            return this;
        }

        public Builder duplicated_keyword(List<DuplicateKeywordInfo> list) {
            this.duplicated_keyword = checkForNulls(list);
            return this;
        }

        public CheckActivityResponse build() {
            return new CheckActivityResponse(this);
        }
    }
}
