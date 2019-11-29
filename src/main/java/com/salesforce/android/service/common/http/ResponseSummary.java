package com.salesforce.android.service.common.http;

import java.net.URL;
import java.util.List;

public interface ResponseSummary {
    List<Challenge> getChallenges();

    int getCode();

    String getInitialRequestHeader(String str);

    URL getUrl();
}
