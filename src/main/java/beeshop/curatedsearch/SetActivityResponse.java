package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetActivityResponse extends Message {
    public static final ErrCode DEFAULT_CODE = ErrCode.Success;
    public static final List<DuplicateKeywordInfo> DEFAULT_DUPLICATED_KEYWORD = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final CuratedActivity activity;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final ErrCode code;
    @ProtoField(label = Message.Label.REPEATED, messageType = DuplicateKeywordInfo.class, tag = 2)
    public final List<DuplicateKeywordInfo> duplicated_keyword;

    public SetActivityResponse(ErrCode errCode, List<DuplicateKeywordInfo> list, CuratedActivity curatedActivity) {
        this.code = errCode;
        this.duplicated_keyword = immutableCopyOf(list);
        this.activity = curatedActivity;
    }

    private SetActivityResponse(Builder builder) {
        this(builder.code, builder.duplicated_keyword, builder.activity);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetActivityResponse)) {
            return false;
        }
        SetActivityResponse setActivityResponse = (SetActivityResponse) obj;
        if (!equals((Object) this.code, (Object) setActivityResponse.code) || !equals((List<?>) this.duplicated_keyword, (List<?>) setActivityResponse.duplicated_keyword) || !equals((Object) this.activity, (Object) setActivityResponse.activity)) {
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
        int i2 = 0;
        int hashCode = (errCode != null ? errCode.hashCode() : 0) * 37;
        List<DuplicateKeywordInfo> list = this.duplicated_keyword;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        CuratedActivity curatedActivity = this.activity;
        if (curatedActivity != null) {
            i2 = curatedActivity.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetActivityResponse> {
        public CuratedActivity activity;
        public ErrCode code;
        public List<DuplicateKeywordInfo> duplicated_keyword;

        public Builder() {
        }

        public Builder(SetActivityResponse setActivityResponse) {
            super(setActivityResponse);
            if (setActivityResponse != null) {
                this.code = setActivityResponse.code;
                this.duplicated_keyword = SetActivityResponse.copyOf(setActivityResponse.duplicated_keyword);
                this.activity = setActivityResponse.activity;
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

        public Builder activity(CuratedActivity curatedActivity) {
            this.activity = curatedActivity;
            return this;
        }

        public SetActivityResponse build() {
            return new SetActivityResponse(this);
        }
    }
}
