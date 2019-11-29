package com.salesforce.android.service.common.http.auth;

import com.salesforce.android.service.common.http.Challenge;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.ResponseSummary;
import com.salesforce.android.service.common.http.okhttp.SalesforceHttpChallenge;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpRequest;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import okhttp3.Response;

class AuthResponseSummary implements ResponseSummary {
    private final List<Challenge> mChallenges;
    private final HttpRequest mRequest;
    private final int mResponseCode;

    public AuthResponseSummary(Response response) {
        this.mResponseCode = response.code();
        this.mRequest = SalesforceOkHttpRequest.wrap(response.request());
        LinkedList linkedList = new LinkedList();
        for (okhttp3.Challenge wrap : response.challenges()) {
            linkedList.add(SalesforceHttpChallenge.wrap(wrap));
        }
        this.mChallenges = Collections.unmodifiableList(linkedList);
    }

    public int getCode() {
        return this.mResponseCode;
    }

    public List<Challenge> getChallenges() {
        return this.mChallenges;
    }

    public URL getUrl() {
        return this.mRequest.url().url();
    }

    public String getInitialRequestHeader(String str) {
        return this.mRequest.header(str);
    }
}
