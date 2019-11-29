package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchFeedUserOption extends Message {
    public static final Boolean DEFAULT_KOL = false;
    public static final Boolean DEFAULT_SELLER = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean kol;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean seller;

    public SearchFeedUserOption(Boolean bool, Boolean bool2) {
        this.kol = bool;
        this.seller = bool2;
    }

    private SearchFeedUserOption(Builder builder) {
        this(builder.kol, builder.seller);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchFeedUserOption)) {
            return false;
        }
        SearchFeedUserOption searchFeedUserOption = (SearchFeedUserOption) obj;
        if (!equals((Object) this.kol, (Object) searchFeedUserOption.kol) || !equals((Object) this.seller, (Object) searchFeedUserOption.seller)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.kol;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        Boolean bool2 = this.seller;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchFeedUserOption> {
        public Boolean kol;
        public Boolean seller;

        public Builder() {
        }

        public Builder(SearchFeedUserOption searchFeedUserOption) {
            super(searchFeedUserOption);
            if (searchFeedUserOption != null) {
                this.kol = searchFeedUserOption.kol;
                this.seller = searchFeedUserOption.seller;
            }
        }

        public Builder kol(Boolean bool) {
            this.kol = bool;
            return this;
        }

        public Builder seller(Boolean bool) {
            this.seller = bool;
            return this;
        }

        public SearchFeedUserOption build() {
            return new SearchFeedUserOption(this);
        }
    }
}
