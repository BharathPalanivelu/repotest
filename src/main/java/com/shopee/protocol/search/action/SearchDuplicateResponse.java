package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchDuplicateResponse extends Message {
    public static final String DEFAULT_ERR = "";
    public static final Boolean DEFAULT_ISDUPLICATE = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String Err;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean IsDuplicate;

    public SearchDuplicateResponse(Boolean bool, String str) {
        this.IsDuplicate = bool;
        this.Err = str;
    }

    private SearchDuplicateResponse(Builder builder) {
        this(builder.IsDuplicate, builder.Err);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchDuplicateResponse)) {
            return false;
        }
        SearchDuplicateResponse searchDuplicateResponse = (SearchDuplicateResponse) obj;
        if (!equals((Object) this.IsDuplicate, (Object) searchDuplicateResponse.IsDuplicate) || !equals((Object) this.Err, (Object) searchDuplicateResponse.Err)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.IsDuplicate;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        String str = this.Err;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchDuplicateResponse> {
        public String Err;
        public Boolean IsDuplicate;

        public Builder() {
        }

        public Builder(SearchDuplicateResponse searchDuplicateResponse) {
            super(searchDuplicateResponse);
            if (searchDuplicateResponse != null) {
                this.IsDuplicate = searchDuplicateResponse.IsDuplicate;
                this.Err = searchDuplicateResponse.Err;
            }
        }

        public Builder IsDuplicate(Boolean bool) {
            this.IsDuplicate = bool;
            return this;
        }

        public Builder Err(String str) {
            this.Err = str;
            return this;
        }

        public SearchDuplicateResponse build() {
            return new SearchDuplicateResponse(this);
        }
    }
}
