package com.salesforce.android.service.common.liveagentclient.response.message;

import com.google.a.a.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwitchServerMessage {
    public static final String TYPE = "SwitchServer";
    @c(a = "newUrl")
    private String mNewServerUrl;

    public SwitchServerMessage(String str) {
        this.mNewServerUrl = str;
    }

    public String getNewServerUrl() {
        return this.mNewServerUrl;
    }

    public String getNewLiveAgentPod() {
        if (this.mNewServerUrl == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("https://(.*)/chat").matcher(this.mNewServerUrl);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
