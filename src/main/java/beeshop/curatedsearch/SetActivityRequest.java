package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetActivityRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final CuratedActivity activity;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public SetActivityRequest(RequestHeader requestHeader, CuratedActivity curatedActivity) {
        this.header = requestHeader;
        this.activity = curatedActivity;
    }

    private SetActivityRequest(Builder builder) {
        this(builder.header, builder.activity);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetActivityRequest)) {
            return false;
        }
        SetActivityRequest setActivityRequest = (SetActivityRequest) obj;
        if (!equals((Object) this.header, (Object) setActivityRequest.header) || !equals((Object) this.activity, (Object) setActivityRequest.activity)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int i2 = 0;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        CuratedActivity curatedActivity = this.activity;
        if (curatedActivity != null) {
            i2 = curatedActivity.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetActivityRequest> {
        public CuratedActivity activity;
        public RequestHeader header;

        public Builder() {
        }

        public Builder(SetActivityRequest setActivityRequest) {
            super(setActivityRequest);
            if (setActivityRequest != null) {
                this.header = setActivityRequest.header;
                this.activity = setActivityRequest.activity;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder activity(CuratedActivity curatedActivity) {
            this.activity = curatedActivity;
            return this;
        }

        public SetActivityRequest build() {
            return new SetActivityRequest(this);
        }
    }
}
