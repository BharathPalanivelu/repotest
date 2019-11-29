package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.CORSConfiguration;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class PutBucketCORSRequest extends BucketRequest {
    private CORSConfiguration corsConfiguration = new CORSConfiguration();

    public String getMethod() {
        return "PUT";
    }

    public boolean isNeedMD5() {
        return true;
    }

    public PutBucketCORSRequest(String str) {
        super(str);
        this.corsConfiguration.corsRules = new ArrayList();
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("cors", (Object) null);
        return super.getQueryString();
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildCORSConfigurationXML(this.corsConfiguration));
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public void addCORSRules(List<CORSConfiguration.CORSRule> list) {
        if (list != null) {
            this.corsConfiguration.corsRules.addAll(list);
        }
    }

    public void addCORSRule(CORSConfiguration.CORSRule cORSRule) {
        if (cORSRule != null) {
            this.corsConfiguration.corsRules.add(cORSRule);
        }
    }

    public CORSConfiguration getCorsConfiguration() {
        return this.corsConfiguration;
    }
}
