package com.tencent.cos.xml.model;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.utils.URLEncodeUtils;
import com.tencent.qcloud.core.auth.COSXmlSignSourceProvider;
import com.tencent.qcloud.core.auth.QCloudSignSourceProvider;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.HttpTask;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class CosXmlRequest {
    private HttpTask httpTask;
    private boolean isNeedMD5 = false;
    private boolean isSupportAccelerate = false;
    protected Map<String, String> queryParameters = new LinkedHashMap();
    protected Map<String, List<String>> requestHeaders = new LinkedHashMap();
    private QCloudSignSourceProvider signSourceProvider;

    public abstract void checkParameters() throws CosXmlClientException;

    /* access modifiers changed from: protected */
    public abstract String getHostPrefix();

    public abstract String getMethod();

    public abstract String getPath();

    public abstract RequestBodySerializer getRequestBody() throws CosXmlClientException;

    public Map<String, String> getQueryString() {
        return this.queryParameters;
    }

    public Map<String, List<String>> getRequestHeaders() {
        return this.requestHeaders;
    }

    public boolean isNeedMD5() {
        return this.isNeedMD5;
    }

    public void setNeedMD5(boolean z) {
        this.isNeedMD5 = z;
    }

    @Deprecated
    public void setRequestHeaders(String str, String str2) throws CosXmlClientException {
        if (str != null && str2 != null) {
            addHeader(str, URLEncodeUtils.cosPathEncode(str2));
        }
    }

    public void setRequestHeaders(String str, String str2, boolean z) throws CosXmlClientException {
        if (str != null && str2 != null) {
            if (z) {
                str2 = URLEncodeUtils.cosPathEncode(str2);
            }
            addHeader(str, str2);
        }
    }

    /* access modifiers changed from: protected */
    public void addHeader(String str, String str2) {
        List list;
        if (this.requestHeaders.containsKey(str)) {
            list = this.requestHeaders.get(str);
        } else {
            list = new ArrayList();
        }
        list.add(str2);
        this.requestHeaders.put(str, list);
    }

    public String getHost(String str, String str2, boolean z) {
        String hostPrefix = getHostPrefix();
        if (!hostPrefix.endsWith("-" + str)) {
            hostPrefix = hostPrefix + "-" + str;
        }
        if (z) {
            return hostPrefix + ".cos-accelerate" + "." + "myqcloud.com";
        }
        return hostPrefix + ".cos." + str2 + "." + "myqcloud.com";
    }

    public void isSupportAccelerate(boolean z) {
        this.isSupportAccelerate = z;
    }

    public boolean isSupportAccelerate() {
        return this.isSupportAccelerate;
    }

    public void setSign(String str) {
        addHeader(HttpConstants.Header.AUTHORIZATION, str);
    }

    public void setSign(long j) {
        this.signSourceProvider = new COSXmlSignSourceProvider().setDuration(j);
    }

    public void setSign(long j, long j2) {
        this.signSourceProvider = new COSXmlSignSourceProvider().setSignBeginTime(j).setSignExpiredTime(j2);
    }

    public QCloudSignSourceProvider getSignSourceProvider() {
        if (this.signSourceProvider == null) {
            this.signSourceProvider = new COSXmlSignSourceProvider().setDuration(600);
        }
        return this.signSourceProvider;
    }

    public void setSign(long j, Set<String> set, Set<String> set2) {
        COSXmlSignSourceProvider duration = new COSXmlSignSourceProvider().setDuration(j);
        duration.parameters(set);
        duration.headers(set2);
        this.signSourceProvider = duration;
    }

    public void setSign(long j, long j2, Set<String> set, Set<String> set2) {
        COSXmlSignSourceProvider signExpiredTime = new COSXmlSignSourceProvider().setSignBeginTime(j).setSignExpiredTime(j2);
        signExpiredTime.parameters(set);
        signExpiredTime.headers(set2);
        this.signSourceProvider = signExpiredTime;
    }

    public void setTask(HttpTask httpTask2) {
        this.httpTask = httpTask2;
    }

    public HttpTask getHttpTask() {
        return this.httpTask;
    }
}
