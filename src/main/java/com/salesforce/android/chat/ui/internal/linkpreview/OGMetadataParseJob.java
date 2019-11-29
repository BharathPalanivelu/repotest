package com.salesforce.android.chat.ui.internal.linkpreview;

import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.threading.Job;

class OGMetadataParseJob implements Job<OGMetadata> {
    private String mHtml;
    private OGMetadataParser mParser;

    OGMetadataParseJob(Builder builder) {
        this.mHtml = builder.mHtml;
        this.mParser = builder.mParser;
    }

    public void execute(ResultReceiver<OGMetadata> resultReceiver) {
        resultReceiver.setResult(parseHtml(this.mHtml));
    }

    private OGMetadata parseHtml(String str) {
        return this.mParser.parse(str);
    }

    static class Builder {
        /* access modifiers changed from: private */
        public String mHtml;
        /* access modifiers changed from: private */
        public OGMetadataParser mParser;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder setHtml(String str) {
            this.mHtml = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder linkPreviewParserFactory(OGMetadataParser oGMetadataParser) {
            this.mParser = oGMetadataParser;
            return this;
        }

        /* access modifiers changed from: package-private */
        public OGMetadataParseJob build() {
            if (this.mParser == null) {
                this.mParser = new OGMetadataParser();
            }
            return new OGMetadataParseJob(this);
        }
    }
}
