package com.facebook.places.model;

import java.util.HashSet;
import java.util.Set;

public final class PlaceInfoRequestParams {
    private final Set<String> fields;
    private final String placeId;

    private PlaceInfoRequestParams(Builder builder) {
        this.fields = new HashSet();
        this.placeId = builder.placeId;
        this.fields.addAll(builder.fields);
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public Set<String> getFields() {
        return this.fields;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public final Set<String> fields = new HashSet();
        /* access modifiers changed from: private */
        public String placeId;

        public Builder setPlaceId(String str) {
            this.placeId = str;
            return this;
        }

        public Builder addField(String str) {
            this.fields.add(str);
            return this;
        }

        public Builder addFields(String[] strArr) {
            for (String add : strArr) {
                this.fields.add(add);
            }
            return this;
        }

        public PlaceInfoRequestParams build() {
            return new PlaceInfoRequestParams(this);
        }
    }
}
