package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.VersioningConfiguration;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class PutBucketVersioningRequest extends BucketRequest {
    private VersioningConfiguration versioningConfiguration = new VersioningConfiguration();

    public String getMethod() {
        return "PUT";
    }

    public PutBucketVersioningRequest(String str) {
        super(str);
    }

    public void setEnableVersion(boolean z) {
        if (z) {
            this.versioningConfiguration.status = "Enabled";
        } else {
            this.versioningConfiguration.status = "Suspended";
        }
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("versioning", (Object) null);
        return super.getQueryString();
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildVersioningConfiguration(this.versioningConfiguration));
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }
}
