package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.ReplicationConfiguration;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class PutBucketReplicationRequest extends BucketRequest {
    private ReplicationConfiguration replicationConfiguration = new ReplicationConfiguration();

    public static class RuleStruct {
        public String appid;
        public String bucket;
        public String id;
        public boolean isEnable;
        public String prefix;
        public String region;
        public String storageClass;
    }

    public String getMethod() {
        return "PUT";
    }

    public boolean isNeedMD5() {
        return true;
    }

    public PutBucketReplicationRequest(String str) {
        super(str);
        this.replicationConfiguration.rules = new ArrayList();
    }

    public void setReplicationConfigurationWithRole(String str, String str2) {
        if (str != null && str2 != null) {
            this.replicationConfiguration.role = "qcs::cam::uin/" + str + ":uin/" + str2;
        }
    }

    public void setReplicationConfigurationWithRule(RuleStruct ruleStruct) {
        if (ruleStruct != null) {
            ReplicationConfiguration.Rule rule = new ReplicationConfiguration.Rule();
            rule.id = ruleStruct.id;
            rule.status = ruleStruct.isEnable ? "Enabled" : "Disabled";
            rule.prefix = ruleStruct.prefix;
            ReplicationConfiguration.Destination destination = new ReplicationConfiguration.Destination();
            destination.storageClass = ruleStruct.storageClass;
            destination.bucket = "qcs:id/0:cos:" + ruleStruct.region + ":appid/" + ruleStruct.appid + ":" + ruleStruct.bucket;
            rule.destination = destination;
            this.replicationConfiguration.rules.add(rule);
        }
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("replication", (Object) null);
        return super.getQueryString();
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildReplicationConfiguration(this.replicationConfiguration));
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }
}
