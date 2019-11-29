package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BatchSetActivityResponse extends Message {
    public static final List<CuratedActivity> DEFAULT_ACTIVITY = Collections.emptyList();
    public static final ErrCode DEFAULT_CODE = ErrCode.Success;
    public static final List<DuplicateKeywordInfo> DEFAULT_DUPLICATED_KEYWORD = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CuratedActivity.class, tag = 3)
    public final List<CuratedActivity> activity;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final ErrCode code;
    @ProtoField(label = Message.Label.REPEATED, messageType = DuplicateKeywordInfo.class, tag = 2)
    public final List<DuplicateKeywordInfo> duplicated_keyword;

    public BatchSetActivityResponse(ErrCode errCode, List<DuplicateKeywordInfo> list, List<CuratedActivity> list2) {
        this.code = errCode;
        this.duplicated_keyword = immutableCopyOf(list);
        this.activity = immutableCopyOf(list2);
    }

    private BatchSetActivityResponse(Builder builder) {
        this(builder.code, builder.duplicated_keyword, builder.activity);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchSetActivityResponse)) {
            return false;
        }
        BatchSetActivityResponse batchSetActivityResponse = (BatchSetActivityResponse) obj;
        if (!equals((Object) this.code, (Object) batchSetActivityResponse.code) || !equals((List<?>) this.duplicated_keyword, (List<?>) batchSetActivityResponse.duplicated_keyword) || !equals((List<?>) this.activity, (List<?>) batchSetActivityResponse.activity)) {
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
        int i2 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<CuratedActivity> list2 = this.activity;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BatchSetActivityResponse> {
        public List<CuratedActivity> activity;
        public ErrCode code;
        public List<DuplicateKeywordInfo> duplicated_keyword;

        public Builder() {
        }

        public Builder(BatchSetActivityResponse batchSetActivityResponse) {
            super(batchSetActivityResponse);
            if (batchSetActivityResponse != null) {
                this.code = batchSetActivityResponse.code;
                this.duplicated_keyword = BatchSetActivityResponse.copyOf(batchSetActivityResponse.duplicated_keyword);
                this.activity = BatchSetActivityResponse.copyOf(batchSetActivityResponse.activity);
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

        public Builder activity(List<CuratedActivity> list) {
            this.activity = checkForNulls(list);
            return this;
        }

        public BatchSetActivityResponse build() {
            return new BatchSetActivityResponse(this);
        }
    }
}
