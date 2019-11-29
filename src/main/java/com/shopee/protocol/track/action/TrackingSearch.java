package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TrackingSearch extends Message {
    public static final List<TrackingColorBlock> DEFAULT_COLOR_BLOCK = Collections.emptyList();
    public static final String DEFAULT_KEYWORD = "";
    public static final Boolean DEFAULT_RESULTS_CONTAIN_ADS = false;
    public static final Integer DEFAULT_SEARCH_METHOD = 0;
    public static final String DEFAULT_USER_INPUT = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final TrackingAutoComplete auto_complete;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingColorBlock.class, tag = 6)
    public final List<TrackingColorBlock> color_block;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean results_contain_ads;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer search_method;
    @ProtoField(tag = 7)
    public final TrackingSort sort;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String user_input;

    public TrackingSearch(String str, String str2, Boolean bool, Integer num, TrackingAutoComplete trackingAutoComplete, List<TrackingColorBlock> list, TrackingSort trackingSort) {
        this.user_input = str;
        this.keyword = str2;
        this.results_contain_ads = bool;
        this.search_method = num;
        this.auto_complete = trackingAutoComplete;
        this.color_block = immutableCopyOf(list);
        this.sort = trackingSort;
    }

    private TrackingSearch(Builder builder) {
        this(builder.user_input, builder.keyword, builder.results_contain_ads, builder.search_method, builder.auto_complete, builder.color_block, builder.sort);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingSearch)) {
            return false;
        }
        TrackingSearch trackingSearch = (TrackingSearch) obj;
        if (!equals((Object) this.user_input, (Object) trackingSearch.user_input) || !equals((Object) this.keyword, (Object) trackingSearch.keyword) || !equals((Object) this.results_contain_ads, (Object) trackingSearch.results_contain_ads) || !equals((Object) this.search_method, (Object) trackingSearch.search_method) || !equals((Object) this.auto_complete, (Object) trackingSearch.auto_complete) || !equals((List<?>) this.color_block, (List<?>) trackingSearch.color_block) || !equals((Object) this.sort, (Object) trackingSearch.sort)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.user_input;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.keyword;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.results_contain_ads;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.search_method;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        TrackingAutoComplete trackingAutoComplete = this.auto_complete;
        int hashCode5 = (hashCode4 + (trackingAutoComplete != null ? trackingAutoComplete.hashCode() : 0)) * 37;
        List<TrackingColorBlock> list = this.color_block;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 1)) * 37;
        TrackingSort trackingSort = this.sort;
        if (trackingSort != null) {
            i2 = trackingSort.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingSearch> {
        public TrackingAutoComplete auto_complete;
        public List<TrackingColorBlock> color_block;
        public String keyword;
        public Boolean results_contain_ads;
        public Integer search_method;
        public TrackingSort sort;
        public String user_input;

        public Builder() {
        }

        public Builder(TrackingSearch trackingSearch) {
            super(trackingSearch);
            if (trackingSearch != null) {
                this.user_input = trackingSearch.user_input;
                this.keyword = trackingSearch.keyword;
                this.results_contain_ads = trackingSearch.results_contain_ads;
                this.search_method = trackingSearch.search_method;
                this.auto_complete = trackingSearch.auto_complete;
                this.color_block = TrackingSearch.copyOf(trackingSearch.color_block);
                this.sort = trackingSearch.sort;
            }
        }

        public Builder user_input(String str) {
            this.user_input = str;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder results_contain_ads(Boolean bool) {
            this.results_contain_ads = bool;
            return this;
        }

        public Builder search_method(Integer num) {
            this.search_method = num;
            return this;
        }

        public Builder auto_complete(TrackingAutoComplete trackingAutoComplete) {
            this.auto_complete = trackingAutoComplete;
            return this;
        }

        public Builder color_block(List<TrackingColorBlock> list) {
            this.color_block = checkForNulls(list);
            return this;
        }

        public Builder sort(TrackingSort trackingSort) {
            this.sort = trackingSort;
            return this;
        }

        public TrackingSearch build() {
            return new TrackingSearch(this);
        }
    }
}
