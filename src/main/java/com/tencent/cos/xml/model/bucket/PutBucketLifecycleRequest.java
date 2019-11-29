package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.LifecycleConfiguration;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class PutBucketLifecycleRequest extends BucketRequest {
    private LifecycleConfiguration lifecycleConfiguration = new LifecycleConfiguration();

    public String getMethod() {
        return "PUT";
    }

    public boolean isNeedMD5() {
        return true;
    }

    public PutBucketLifecycleRequest(String str) {
        super(str);
        this.lifecycleConfiguration.rules = new ArrayList();
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("lifecycle", (Object) null);
        return super.getQueryString();
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildLifecycleConfigurationXML(this.lifecycleConfiguration));
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public void setRuleList(List<LifecycleConfiguration.Rule> list) {
        if (list != null) {
            this.lifecycleConfiguration.rules.addAll(list);
        }
    }

    public void setRuleList(LifecycleConfiguration.Rule rule) {
        if (rule != null) {
            this.lifecycleConfiguration.rules.add(rule);
        }
    }

    public LifecycleConfiguration getLifecycleConfiguration() {
        return this.lifecycleConfiguration;
    }
}
