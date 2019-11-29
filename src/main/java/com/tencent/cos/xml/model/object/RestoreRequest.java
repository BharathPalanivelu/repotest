package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.RestoreConfigure;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class RestoreRequest extends ObjectRequest {
    private RestoreConfigure restoreConfigure = new RestoreConfigure();

    public String getMethod() {
        return "POST";
    }

    public boolean isNeedMD5() {
        return true;
    }

    public RestoreRequest(String str, String str2) {
        super(str, str2);
        this.restoreConfigure.casJobParameters = new RestoreConfigure.CASJobParameters();
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("restore", (Object) null);
        return this.queryParameters;
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildRestore(this.restoreConfigure));
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public void setExpireDays(int i) {
        if (i < 0) {
            i = 0;
        }
        this.restoreConfigure.days = i;
    }

    public void setTier(RestoreConfigure.Tier tier) {
        if (tier != null) {
            this.restoreConfigure.casJobParameters.tier = tier.getTier();
        }
    }
}
