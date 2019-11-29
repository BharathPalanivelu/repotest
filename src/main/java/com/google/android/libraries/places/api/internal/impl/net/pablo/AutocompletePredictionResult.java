package com.google.android.libraries.places.api.internal.impl.net.pablo;

import com.google.a.a.c;
import java.util.List;

class AutocompletePredictionResult {
    @c(a = "description")
    public String fullText;
    @c(a = "matched_substrings")
    public List<Substring> fullTextMatchedSubstrings;
    public String placeId;
    public StructuredFormatting structuredFormatting;
    public List<String> types;

    static class StructuredFormatting {
        @c(a = "main_text")
        public String primaryText;
        @c(a = "main_text_matched_substrings")
        public List<Substring> primaryTextMatchedSubstrings;
        public String secondaryText;
        public List<Substring> secondaryTextMatchedSubstrings;

        StructuredFormatting() {
        }

        /* access modifiers changed from: package-private */
        public String getPrimaryText() {
            return this.primaryText;
        }

        /* access modifiers changed from: package-private */
        public String getSecondaryText() {
            return this.secondaryText;
        }

        /* access modifiers changed from: package-private */
        public List<Substring> getPrimaryTextMatchedSubstrings() {
            return this.primaryTextMatchedSubstrings;
        }

        /* access modifiers changed from: package-private */
        public List<Substring> getSecondaryTextMatchedSubstrings() {
            return this.secondaryTextMatchedSubstrings;
        }
    }

    static class Substring {
        public Integer length;
        public Integer offset;

        Substring() {
        }

        /* access modifiers changed from: package-private */
        public Integer getOffset() {
            return this.offset;
        }

        /* access modifiers changed from: package-private */
        public Integer getLength() {
            return this.length;
        }
    }

    AutocompletePredictionResult() {
    }

    /* access modifiers changed from: package-private */
    public String getFullText() {
        return this.fullText;
    }

    /* access modifiers changed from: package-private */
    public String getPlaceId() {
        return this.placeId;
    }

    /* access modifiers changed from: package-private */
    public StructuredFormatting getStructuredFormatting() {
        return this.structuredFormatting;
    }

    /* access modifiers changed from: package-private */
    public List<String> getTypes() {
        return this.types;
    }

    /* access modifiers changed from: package-private */
    public List<Substring> getFullTextMatchedSubstrings() {
        return this.fullTextMatchedSubstrings;
    }
}
