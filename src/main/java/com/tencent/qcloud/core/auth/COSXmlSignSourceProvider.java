package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.util.QCloudHttpUtils;
import com.tencent.qcloud.core.util.QCloudStringUtils;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;

public class COSXmlSignSourceProvider implements QCloudSignSourceProvider {
    private long beginTime;
    private long duration;
    private long expiredTime;
    private Set<String> headers = new HashSet();
    private Set<String> paras = new HashSet();
    private Set<String> realSignHeader = new HashSet();
    private Set<String> realSignParas = new HashSet();
    private String signTime;

    public COSXmlSignSourceProvider setSignBeginTime(long j) {
        this.beginTime = Utils.handleTimeAccuracy(j);
        return this;
    }

    public COSXmlSignSourceProvider setSignExpiredTime(long j) {
        this.expiredTime = Utils.handleTimeAccuracy(j);
        return this;
    }

    public COSXmlSignSourceProvider setDuration(long j) {
        this.duration = j;
        return this;
    }

    public void parameter(String str) {
        this.paras.add(str);
    }

    public void parameters(Set<String> set) {
        if (set != null) {
            this.paras.addAll(set);
        }
    }

    public void header(String str) {
        this.headers.add(str);
    }

    public void headers(Set<String> set) {
        if (set != null) {
            this.headers.addAll(set);
        }
    }

    public <T> String source(HttpRequest<T> httpRequest) throws QCloudClientException {
        if (httpRequest == null) {
            return null;
        }
        if (this.headers.size() > 0) {
            Set<String> lowerCase = toLowerCase(this.headers);
            if (lowerCase != null && lowerCase.contains(HttpConstants.Header.CONTENT_TYPE.toLowerCase())) {
                String contentType = httpRequest.contentType();
                if (contentType != null) {
                    httpRequest.addHeader(HttpConstants.Header.CONTENT_TYPE, contentType);
                }
            }
            if (lowerCase != null && lowerCase.contains(HttpConstants.Header.CONTENT_LENGTH.toLowerCase())) {
                try {
                    long contentLength = httpRequest.contentLength();
                    if (contentLength != -1) {
                        httpRequest.addHeader(HttpConstants.Header.CONTENT_LENGTH, Long.toString(contentLength));
                        httpRequest.removeHeader(HttpConstants.Header.TRANSFER_ENCODING);
                    } else {
                        httpRequest.addHeader(HttpConstants.Header.TRANSFER_ENCODING, "chunked");
                        httpRequest.removeHeader(HttpConstants.Header.CONTENT_LENGTH);
                    }
                } catch (IOException e2) {
                    throw new QCloudClientException("read content length fails", e2);
                }
            }
            if (lowerCase != null && lowerCase.contains(HttpConstants.Header.DATE.toLowerCase())) {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                httpRequest.addHeader(HttpConstants.Header.DATE, simpleDateFormat.format(date));
            }
        }
        StringBuilder sb = new StringBuilder(httpRequest.method().toLowerCase());
        sb.append("\n");
        sb.append(QCloudHttpUtils.urlDecodeString(httpRequest.url().getPath()));
        sb.append("\n");
        String queryStringForKeys = queryStringForKeys(httpRequest.url(), this.paras, this.realSignParas);
        String str = "";
        if (queryStringForKeys == null) {
            queryStringForKeys = str;
        }
        sb.append(queryStringForKeys);
        sb.append("\n");
        if (httpRequest.headers() != null) {
            str = headersStringForKeys(httpRequest.headers(), this.headers, this.realSignHeader);
        }
        sb.append(str);
        sb.append("\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AuthConstants.SHA1);
        sb2.append("\n");
        if (this.beginTime == 0) {
            this.beginTime = System.currentTimeMillis() / 1000;
        }
        if (this.expiredTime == 0) {
            this.expiredTime = this.beginTime + this.duration;
        }
        this.signTime = this.beginTime + ";" + this.expiredTime;
        sb2.append(this.signTime);
        sb2.append("\n");
        sb2.append(Utils.encodeHexString(Utils.sha1(sb.toString())));
        sb2.append("\n");
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public String getRealHeaderList() {
        return sortAndJoinSemicolon(this.realSignHeader);
    }

    /* access modifiers changed from: package-private */
    public String getRealParameterList() {
        return sortAndJoinSemicolon(this.realSignParas);
    }

    /* access modifiers changed from: package-private */
    public String getSignTime() {
        return this.signTime;
    }

    private String sortAndJoinSemicolon(Set<String> set) {
        if (set == null) {
            return "";
        }
        TreeSet<String> treeSet = new TreeSet<>(set);
        StringBuilder sb = new StringBuilder();
        for (String str : treeSet) {
            if (!QCloudStringUtils.isEmpty(sb.toString())) {
                sb.append(";");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    private Set<String> toLowerCase(Set<String> set) {
        if (set == null || set.size() <= 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (String next : set) {
            if (next != null) {
                hashSet.add(next.toLowerCase());
            }
        }
        return hashSet;
    }

    private String queryStringForKeys(URL url, Set<String> set, Set<String> set2) {
        StringBuilder sb = new StringBuilder();
        LinkedList<String> linkedList = new LinkedList<>();
        for (String lowerCase : set) {
            linkedList.add(lowerCase.toLowerCase());
        }
        Collections.sort(linkedList, new Comparator<String>() {
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        });
        Map<String, List<String>> decodedQueryPair = QCloudHttpUtils.getDecodedQueryPair(url);
        Set<String> keySet = decodedQueryPair.keySet();
        if (keySet == null) {
            return "";
        }
        HashMap hashMap = new HashMap();
        for (String next : keySet) {
            hashMap.put(next.toLowerCase(), next);
        }
        boolean z = true;
        for (String str : linkedList) {
            List<String> list = decodedQueryPair.get(hashMap.get(str));
            if (list != null) {
                for (String str2 : list) {
                    if (!z) {
                        sb.append('&');
                    }
                    z = false;
                    set2.add(str.toLowerCase());
                    sb.append(str.toLowerCase());
                    if (str2 != null) {
                        sb.append('=');
                        sb.append(str2.toLowerCase());
                    }
                }
            }
        }
        return sb.toString();
    }

    private String headersStringForKeys(Map<String, List<String>> map, Set<String> set, Set<String> set2) {
        StringBuilder sb = new StringBuilder();
        LinkedList<String> linkedList = new LinkedList<>();
        for (String lowerCase : set) {
            linkedList.add(lowerCase.toLowerCase());
        }
        Collections.sort(linkedList, new Comparator<String>() {
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        });
        Set<String> keySet = map.keySet();
        if (keySet == null) {
            return "";
        }
        HashMap hashMap = new HashMap();
        for (String next : keySet) {
            hashMap.put(next.toLowerCase(), next);
        }
        boolean z = true;
        for (String str : linkedList) {
            List<String> list = map.get(str);
            if (list != null) {
                for (String str2 : list) {
                    if (!z) {
                        sb.append('&');
                    }
                    z = false;
                    sb.append(str.toLowerCase());
                    set2.add(str);
                    if (str2 != null) {
                        sb.append('=');
                        sb.append(QCloudHttpUtils.urlEncodeString(str2));
                    }
                }
            }
        }
        return sb.toString();
    }
}
