package com.salesforce.android.chat.ui.internal.linkpreview;

import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.threading.Job;

class FaviconParseJob implements Job<String> {
    private String mHtml;

    FaviconParseJob(String str) {
        this.mHtml = str;
    }

    public void execute(ResultReceiver<String> resultReceiver) {
        resultReceiver.setResult(new FaviconParser().parse(this.mHtml));
    }
}
