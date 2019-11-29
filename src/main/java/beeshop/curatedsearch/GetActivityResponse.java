package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetActivityResponse extends Message {
    public static final ErrCode DEFAULT_CODE = ErrCode.Success;
    public static final List<ActivityData> DEFAULT_DATA = Collections.emptyList();
    public static final Long DEFAULT_TOTAL = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final ErrCode code;
    @ProtoField(label = Message.Label.REPEATED, messageType = ActivityData.class, tag = 2)
    public final List<ActivityData> data;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long total;

    public GetActivityResponse(ErrCode errCode, List<ActivityData> list, Long l) {
        this.code = errCode;
        this.data = immutableCopyOf(list);
        this.total = l;
    }

    private GetActivityResponse(Builder builder) {
        this(builder.code, builder.data, builder.total);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetActivityResponse)) {
            return false;
        }
        GetActivityResponse getActivityResponse = (GetActivityResponse) obj;
        if (!equals((Object) this.code, (Object) getActivityResponse.code) || !equals((List<?>) this.data, (List<?>) getActivityResponse.data) || !equals((Object) this.total, (Object) getActivityResponse.total)) {
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
        List<ActivityData> list = this.data;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.total;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetActivityResponse> {
        public ErrCode code;
        public List<ActivityData> data;
        public Long total;

        public Builder() {
        }

        public Builder(GetActivityResponse getActivityResponse) {
            super(getActivityResponse);
            if (getActivityResponse != null) {
                this.code = getActivityResponse.code;
                this.data = GetActivityResponse.copyOf(getActivityResponse.data);
                this.total = getActivityResponse.total;
            }
        }

        public Builder code(ErrCode errCode) {
            this.code = errCode;
            return this;
        }

        public Builder data(List<ActivityData> list) {
            this.data = checkForNulls(list);
            return this;
        }

        public Builder total(Long l) {
            this.total = l;
            return this;
        }

        public GetActivityResponse build() {
            return new GetActivityResponse(this);
        }
    }
}
